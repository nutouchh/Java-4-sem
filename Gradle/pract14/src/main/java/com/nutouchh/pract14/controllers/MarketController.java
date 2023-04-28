package com.nutouchh.pract14.controllers;

import com.nutouchh.pract14.classes.Market;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/markets")
public class MarketController {
    private List<Market> MarketList = new ArrayList<>();

    @GetMapping("/")
    @ResponseBody
    public List<Market> showMarkets() {
        return MarketList;
    }

    @GetMapping("/add")
    public String addMarket(@RequestParam("name") String name,
                            @RequestParam("address") String address) {
        MarketList.add(new Market(name, address));
        return "redirect:/markets/";
    }

    @GetMapping("/delete")
    public String deleteMarket(@RequestParam("name") String name,
                               @RequestParam("address") String address) {
        for (Market market : MarketList) {
            if (market.getName().equals(name) && market.getAddress().equals(address)) {
                MarketList.remove(market);
                return "redirect:/markets/";
            }
        }

        return "redirect:/markets/";
    }
}

//localhost:8080/markets/add?name=Перекресток&address=УлицаПушкинаДомКолотушкина