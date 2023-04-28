package com.nutouchh.pract24.repository;

import com.nutouchh.pract24.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    List<Market> findByNameAndAddress(String name, String address);
    List<Market> findByName(String name);
    @Query("SELECT b FROM Market b ORDER BY b.name ASC") ///////////////////////////////////////////////////////////////////////
    List<Market> findAllSortedByName();
}
