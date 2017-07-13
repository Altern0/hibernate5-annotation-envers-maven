package net.roseindia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.roseindia.model.*;

public class CreateData {
	
	public static void main( String[] args ) throws Exception {

		// se llama el método que creamos para instanciar la sessionfactory
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		
		// tomamos la Session
		Session session = sessFact.getCurrentSession();
		
		// iniciamos una transacción en esta session
		Transaction tr = session.beginTransaction();
		
		// instaciamos la clase Articulo y asignamos datos a sus variables
		Article article = new Article();
		
		article.setTitle( "Java Tutorial" );
		article.setContent( "Read all tutorials at http://www.roseindia.net" );

		// guardamos el Articulo en la session
		session.save(article);
		

		// realizamos commit a la transacción para crear la persistencia de los datos
		tr.commit();
		
		System.out.println( "Successfully inserted" );
		
		// Cerramos la Session
		sessFact.close();
		
	}

}