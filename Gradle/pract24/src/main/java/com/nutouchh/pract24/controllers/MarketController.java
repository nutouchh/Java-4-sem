package com.nutouchh.pract24.controllers;

import com.nutouchh.pract24.model.Market;
import com.nutouchh.pract24.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/markets")
public class MarketController {
    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Market> showMarkets() {
        return marketService.getAllMarkets();
    }

    @GetMapping("/add")
    public String addMarket(@RequestParam String name,
                              @RequestParam String address, @RequestParam long productId) {
        marketService.addEntity(new Market(name, address), productId);
        return "redirect:/markets/";
    }


    @GetMapping("/delete")
    public String deleteMarket(@RequestParam("name") String name,
                                 @RequestParam("address") String address) {
        marketService.deleteEntity(name, address);
        return "redirect:/markets/";
    }

    @GetMapping("/sorted_by_market_name")
    @ResponseBody
    public String showMarketsOrderedByName() {
        return marketService.sortMarketsOrderedByName().toString();
    }

    @GetMapping("/{address}")
    @ResponseBody
    public String showMarketsByAddress(@PathVariable String address) {
        return  marketService.filterMarketsByAddress(address).toString();
    }
}

//localhost:8080/markets/add?name=Перекресток&address=УлицаПушкинаДомКолотушкина