package com.nutouchh.pract24.service;

import com.nutouchh.pract24.model.Market;
import com.nutouchh.pract24.model.Product;
import com.nutouchh.pract24.repository.MarketRepository;
import com.nutouchh.pract24.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class MarketServiceTest {

    @Mock
    private MarketRepository marketRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private MarketService marketService;

    @Test
    public void testGetAllMarkets() {
        List<Market> expectedMarkets = new ArrayList<>();
        Market market1 = new Market("Market1", "Address1");
        Market market2 = new Market("Market2", "Address2");
        expectedMarkets.add(market1);
        expectedMarkets.add(market2);

        Mockito.when(marketRepository.findAll()).thenReturn(expectedMarkets);

        List<Market> actualMarkets = marketService.getAllMarkets();

        assertEquals(expectedMarkets.size(), actualMarkets.size());
        assertTrue(expectedMarkets.containsAll(actualMarkets));
    }

    @Test
    public void testAddEntity() {
        Market market = new Market("Market1", "Address1");
        Product product = new Product("Product1","Price1");
        product.setId(1L);

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(marketRepository.save(market)).thenReturn(market);

        marketService.addEntity(market, 1L);

        assertTrue(product.getMarkets().contains(market));
    }

    @Test
    public void testDeleteEntity() {
        String name = "Market1";
        String address = "Address1";
        Market market = new Market(name, address);
        List<Market> toDelete = new ArrayList<>();
        toDelete.add(market);

        Mockito.when(marketRepository.findByNameAndAddress(name, address)).thenReturn(toDelete);

        marketService.deleteEntity(name, address);

        Mockito.verify(marketRepository, Mockito.times(1)).deleteAll(toDelete);
    }

    @Test
    public void testSortMarketsOrderedByName() {
        List<Market> expectedMarkets = new ArrayList<>();
        Market market1 = new Market("Market1", "Address1");
        Market market2 = new Market("Market2", "Address2");
        expectedMarkets.add(market1);
        expectedMarkets.add(market2);

        Mockito.when(marketRepository.findAllSortedByName()).thenReturn(expectedMarkets);

        List<Market> actualMarkets = marketService.sortMarketsOrderedByName();

        assertEquals(expectedMarkets.size(), actualMarkets.size());
        assertTrue(expectedMarkets.containsAll(actualMarkets));
    }

    @Test
    public void testFilterMarketsByAddress() {
        String name = "Market1";
        List<Market> expectedMarkets = new ArrayList<>();
        Market market1 = new Market(name, "Address1");
        Market market2 = new Market(name, "Address2");
        expectedMarkets.add(market1);
        expectedMarkets.add(market2);

        Mockito.when(marketRepository.findByName(name)).thenReturn(expectedMarkets);

        List<Market> actualMarkets = marketService.filterMarketsByAddress(name);

        assertEquals(expectedMarkets.size(), actualMarkets.size());
        assertTrue(expectedMarkets.containsAll(actualMarkets));
    }
}