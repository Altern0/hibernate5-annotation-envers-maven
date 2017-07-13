package net.roseindia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.roseindia.model.*;

public class UpdateData {
	
	public static void main( String[] args ) throws Exception {

		// se llama el método que creamos para instanciar la sessionfactory
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		
		// tomamos la Session
		Session session = sessFact.getCurrentSession();
		
		// iniciamos una transacción en esta session
		Transaction tr = session.beginTransaction();
		
		// tomamos el Articulo de la sesión por la clave primaria
		Article article =  (Article ) session.get( Article.class, new Integer( 1 ) );
		  
		// cambiamos los datos del Articulo
		article.setTitle( "Best Java Tutorial" );
		article.setContent( "Visit at http://www.roseindia.net" );

		// Actualizamos el Articulo en la session
		session.update( article );
		
		// realizamos commit a la transacción para crear la persistencia de los datos
		tr.commit();
		
		System.out.println( "Successfully inserted" );
		
		// Cerramos la Session
		sessFact.close();
		
	}

}