package com.nutouchh.pract24.service;

import com.nutouchh.pract24.model.Market;
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
public class MarketService {
    private final SessionFactory sessionFactory;
    private Session session;

    public MarketService(SessionFactory sessionFactory) {
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

    public List<Market> sortMarketsOrderedByName() {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Market> MarketCriteriaQuery = builder.createQuery(Market.class);
        Root<Market> root = MarketCriteriaQuery.from(Market.class);

        MarketCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));  /////////////////////////////////////////////////
        org.hibernate.query.Query<Market> query = session.createQuery(MarketCriteriaQuery);
        return query.getResultList();
    }

    public List<Market> filterMarketsByAddress(String address) {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Market> MarketCriteriaQuery = builder.createQuery(Market.class);
        Root<Market> root = MarketCriteriaQuery.from(Market.class);

        MarketCriteriaQuery.select(root).where(builder.equal(root.get("address"), address));
        org.hibernate.query.Query<Market> query = session.createQuery(MarketCriteriaQuery);
        return query.getResultList();
    }
}
