package com.nurouchh.pract15.service;

import com.nurouchh.pract15.classes.Product;
//import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class ProductService {
    private final SessionFactory sessionFactory;
    private Session session;

    public ProductService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Product> getAllProducts() {
        session = sessionFactory.openSession();
        List<Product> products = session.createQuery("from Product").getResultList();
//        List products = session.createQuery("from Product").getResultList();
        session.close();
        return products;
    }

    public void addEntity(Product product) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteEntity(Product product) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query q =  session.createQuery("DELETE FROM Product WHERE " +
                "name = :name AND price = :price");
        q.setParameter("name", product.getName())
                .setParameter("price", product.getPrice())
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
