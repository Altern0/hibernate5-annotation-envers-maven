package net.roseindia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import net.roseindia.model.*;

/**
 * @author Deepak Kumar Web: http://www.roseindia.net
 */
public class GetAllData {
	
	public static void main(String[] args ) throws Exception {

		// se llama el método que creamos para instanciar la sessionfactory
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		
		// tomamos la Session
		Session session = sessFact.getCurrentSession();
		
		// iniciamos una transacción en esta session
		Transaction tr = session.beginTransaction();
		
		// Creamos el objeto de la consulta y le enviamos el tipo de retorno que deseamos
		CriteriaQuery<Article> cq = session.getCriteriaBuilder().createQuery( Article.class );
		
		// Cree y añade una consulta raiz correspondiente a la clase enviada
		cq.from( Article.class );
		
		// Ejecuta una consulta la cual devuelve una colección de la clase creada y la almacenamos en una lista.
		List<Article> articleList = session.createQuery( cq ).getResultList();

		for (Article article : articleList) {
			
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