package com.nutouchh.pract16;

import com.nutouchh.pract16.configuration.SQLConfig;
import com.nutouchh.pract16.model.Market;
import com.nutouchh.pract16.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Pract16Application {

	public static void main(String[] args) throws IOException {

		SessionFactory sessionFactory = new SQLConfig().sessionFactory();

		Product p1 = new Product(
				"Milk",
				"100");
		Product p2 = new Product(
				"java",
				"бесценно");

		Market m1 = new Market("Пятерочка", "Где-то тут");
		Market m2 = new Market("Перекресток", "На перекрестке");
		Market m3 = new Market("Ашан", "ЛЯЛЯЛЯЛЯЛ");
		Market m4 = new Market("Мирэа", "Проспект Вернадского 78");

		p1.addMarketToProduct(m1);
		p1.addMarketToProduct(m2);

		p2.addMarketToProduct(m3);
		p2.addMarketToProduct(m4);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.persist(p1);
		session.persist(p2);

		session.getTransaction().commit();


// ******************************************************

//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//
//		System.out.println("\nGet product\n");
//		Product product = session.get(Product.class, 51L);
//
//		System.out.println("\nPrint product info");
//		System.out.println("\n" + product + "\n");
//
//		System.out.println("\nShow markets");
//		System.out.println("\n" + product.getMarkets() + "\n");
//
//		System.out.println("\nCommit\n");
//
//		session.getTransaction().commit();
//		session.close();

//		System.out.println("\nShow markets");
//		System.out.println("\n" + product.getMarkets() + "\n");


		sessionFactory.close();
	}
}



