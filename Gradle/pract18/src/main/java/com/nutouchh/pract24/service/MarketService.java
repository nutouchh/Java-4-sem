package com.nutouchh.pract24.service;

import com.nutouchh.pract24.model.Market;
import com.nutouchh.pract24.repository.MarketRepository;
import com.nutouchh.pract24.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
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
        return marketRepository.findAll();
    }

    public void addEntity(Market market, long product_id) {
        productRepository.findById(product_id).ifPresent(product -> product.addMarketToProduct(market));
        marketRepository.save(market);
    }


    public void deleteEntity(String name, String address) {
        List<Market> toDelete = marketRepository.findByNameAndAddress(name, address);
        marketRepository.deleteAll(toDelete);
    }

    public List<Market> sortMarketsOrderedByName() {
        return marketRepository.findAllSortedByName();
    }

    public List<Market> filterMarketsByAddress(String name) {
        return marketRepository.findByName(name);
    }
}
