package com.nurouchh.pract15.controllers;

import com.nurouchh.pract15.classes.Market;
import com.nurouchh.pract15.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
                              @RequestParam String address) {
        marketService.addEntity(new Market(name, address));
        return "redirect:/markets/";
    }


    @GetMapping("/delete")
    public String deleteMarket(@RequestParam("name") String name,
                                 @RequestParam("address") String address) {
        marketService.deleteEntity(new Market(name, address));
        return "redirect:/markets/";
    }
}

//localhost:8080/markets/add?name=Перекресток&address=УлицаПушкинаДомКолотушкина