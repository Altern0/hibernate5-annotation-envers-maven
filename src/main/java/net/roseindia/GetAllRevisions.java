package net.roseindia;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import net.roseindia.model.*;


public class GetAllRevisions {
	
	public static void main( String[] args ) throws Exception {

		// se llama el método que creamos para instanciar la sessionfactory
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		
		// tomamos la Session
		Session session = sessFact.getCurrentSession();
		
		// iniciamos una transacción en esta session
		Transaction tr = session.beginTransaction();
		
		// Crear un lector de auditoría asociado a una sesión abierta pasada por parametros
		AuditReader reader = AuditReaderFactory.get( session );
		
		// Obtenemos una lista de números de revisión, en los que se modificó el registro identificado por la clave principal.
		List<Number> revisions = reader.getRevisions( Article.class, 1 );
		
		for(Number revNum : revisions ){
			
			// Busca un registro por clave principal y el número de revisión en el lector de la sesión abierta.
			Article article = reader.find( Article.class, 1, revNum );
			
			System.out.println( "Revision No: " + revNum );
			System.out.println( "Title: " + article.getTitle() );
			System.out.println( "Content: " + article.getContent() );		

		}
		
		// realizamos commit a la transacción para crear la persistencia de los datos
		tr.commit();
		
		System.out.println( "Data printed" );
		
		// Cerramos la Session
		sessFact.close();
		
	}
	
}