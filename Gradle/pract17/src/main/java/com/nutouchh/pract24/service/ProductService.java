package com.nutouchh.pract24.service;

import com.nutouchh.pract24.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class ProductService {
    private final SessionFactory sessionFactory;
    private Session session;

    public ProductService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    private void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    private void finish() {
        session.close();
        sessionFactory.close();
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

    public List<Product> sortProductsOrderedByName() {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> addressCriteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = addressCriteriaQuery.from(Product.class);

        addressCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        org.hibernate.query.Query<Product> query = session.createQuery(addressCriteriaQuery);
        return query.getResultList();
    }

    public List<Product> filterProductsByPrice(String price) {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> addressCriteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = addressCriteriaQuery.from(Product.class);

        addressCriteriaQuery.select(root).where(builder.equal(root.get("price"), price));
        org.hibernate.query.Query<Product> query = session.createQuery(addressCriteriaQuery);
        return query.getResultList();
    }
}
