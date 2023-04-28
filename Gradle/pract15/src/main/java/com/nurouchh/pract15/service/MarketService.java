package com.nurouchh.pract15.service;

import com.nurouchh.pract15.classes.Market;
//import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

//import javax.persistence.Query;
import javax.persistence.Query;
import java.util.List;


@Service
public class MarketService {
    private final SessionFactory sessionFactory;
    private Session session;

    public MarketService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Market> getAllMarkets() {
        session = sessionFactory.openSession();
//        List markets = session.createQuery("from Market").getResultList();
        List<Market> markets = session.createQuery("from Market").getResultList();
        session.close();
        return markets;
    }

    public void addEntity(Market market) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(market);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteEntity(Market market) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Market WHERE " +  "name = :name AND address = :address");
        q.setParameter("name", market.getName())
                .setParameter("address", market.getAddress())
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
