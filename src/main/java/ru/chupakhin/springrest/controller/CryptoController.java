package ru.chupakhin.springrest.controller;

import org.springframework.web.bind.annotation.*;
import ru.chupakhin.springrest.dto.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CryptoController {

    // /coins GET
    @GetMapping("/coins")
    public List<CoinDto> getCoins() {
        List<CoinDto> coins = new ArrayList<>();

        CoinDto bitcoin = new CoinDto();
        bitcoin.setCoinName("Bitcoin");
        bitcoin.setCoinCode("BTC");
        bitcoin.setPrice(50000.0);
        bitcoin.set_1h(-25.0);
        bitcoin.set_24h(23.0);
        bitcoin.set_7d(56.0);
        bitcoin.setMarketCap(2303534050432.0);
        bitcoin.setVolume(4395723867.0);
        bitcoin.setLastPrice(List.of(324, 436, 584, 987, 674));

        coins.add(bitcoin);

        return coins;
    }
    @GetMapping("/trends")
    public List<TrendDto> getTrends() {
        // Создаем список трендов
        List<TrendDto> trends = new ArrayList<>();

        // Создаем объекты трендов для каждой монеты
        TrendDto bitcoinTrend1 = new TrendDto();
        bitcoinTrend1.setCoinName("Bitcoin");
        bitcoinTrend1.setCoinCode("BTC");
        bitcoinTrend1.set_24h(23.0);

        TrendDto bitcoinTrend2 = new TrendDto();
        bitcoinTrend2.setCoinName("Bitcoin");
        bitcoinTrend2.setCoinCode("BTC");
        bitcoinTrend2.set_24h(23.0);

        // Добавляем тренды в список
        trends.add(bitcoinTrend1);
        trends.add(bitcoinTrend2);

        return trends;
    }
    @GetMapping("/exchanges")
    public List<ExchangeDto> getExchanges() {
        List<ExchangeDto> exchanges = new ArrayList<>();

        ExchangeDto binance = new ExchangeDto();
        binance.setName("Binance");
        binance.setScore(9.0);
        binance.setVolume24h(364578658725L);
        binance.setMarkets(67);
        binance.setCoins(45);
        binance.setLastVolume(List.of(324, 436, 584, 987, 674));

        exchanges.add(binance);

        return exchanges;
    }
    @GetMapping("/portfolio")
    public PortfolioDto getPortfolio() {
        // Создаем объект портфеля
        PortfolioDto portfolio = new PortfolioDto();

        // Создаем список монет
        List<CoinDto> coins = new ArrayList<>();
        CoinDto bitcoin = new CoinDto();
        bitcoin.setCoinName("Bitcoin");
        bitcoin.setCoinCode("BTC");
        bitcoin.setVolume(34.0);
        bitcoin.setPrice(3289476278.0);
        bitcoin.setLastPrice(List.of(324, 436, 584, 987, 674));
        coins.add(bitcoin);

        // Создаем список сделок
        List<DealDto> deals = new ArrayList<>();
        DealDto deal = new DealDto();
        deal.setDate("2024-02-02T12:33:33");
        deal.setType("sell");
        deal.setPrice(3543256.0);
        deal.setVolume(3.0);
        deal.setCoinName("Bitcoin");
        deal.setCoinCode("BTC");
        deals.add(deal);

        // Устанавливаем остальные поля портфеля
        portfolio.setCoins(coins);
        portfolio.setDeals(deals);
        portfolio.setProfileVolumeUsd(List.of(324.0, 436.0, 584.0, 987.0, 674.0));
        portfolio.setProfileVolumeBtc(List.of(324.0, 436.0, 584.0, 987.0, 674.0));
        portfolio.setCurrentVolumeUsd(345.0);
        portfolio.setCurrentVolumeBtc(345.0);

        return portfolio;
    }
    @PostMapping("/add-deal")
    public DealDto addDeal(@RequestBody DealDto request) {
        //Добавление в бд
        return request;
    }
}