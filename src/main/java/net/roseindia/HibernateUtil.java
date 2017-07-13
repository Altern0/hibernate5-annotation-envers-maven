package net.roseindia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;

	static {
		
		try {
				// se registra el servicio pasando el archivo de configuración
		        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure( "hibernate.cfg.xml" ).build();
		        
		        //se creaes el metadaa para representar la información del mapping
		        Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		        
		        //Crear la instancia de sessionfactory
		        sessionFactory = metaData.getSessionFactoryBuilder().build();
		
		} catch (Throwable th) {

			System.err.println("Enitial SessionFactory creation failed" + th);

			throw new ExceptionInInitializerError(th);

		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}
}
