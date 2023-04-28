package com.nutouchh.pract24.service;

import com.nutouchh.pract24.model.Market;
import com.nutouchh.pract24.repository.MarketRepository;
import com.nutouchh.pract24.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@Transactional
//@RequiredArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;
    private final ProductRepository productRepository;

    @Autowired
    public MarketService(MarketRepository marketRepository, ProductRepository productRepository) {
        this.marketRepository = marketRepository;
        this.productRepository = productRepository;
    }

    public List<Market> getAllMarkets() {
        log.info("Find all markets");
        return marketRepository.findAll();
    }

    public void addEntity(Market market, long product_id) {
        log.info("Saving market: {}", market);
        productRepository.findById(product_id).ifPresent(product -> product.addMarketToProduct(market));
        marketRepository.save(market);
    }


    public void deleteEntity(String name, String address) {
        log.info("Removing all markets with name = {} and address = {}", name, address);
        List<Market> toDelete = marketRepository.findByNameAndAddress(name, address);
        marketRepository.deleteAll(toDelete);
    }

    public List<Market> sortMarketsOrderedByName() {
        log.info("Getting all markets sorted by name");
        return marketRepository.findAllSortedByName();
    }

    public List<Market> filterMarketsByAddress(String name) {
        log.info("Getting all markets with name = {}", name);
        return marketRepository.findByName(name);
    }
}
