package ru.chupakhin.springrest.dto;

import java.util.List;

public class CoinDto {
    private String coinName;
    private String coinCode;
    private Double price;
    private Double _1h;
    private Double _24h;
    private Double _7d;
    private Double marketCap;
    private Double volume;
    private List<Integer> lastPrice;

    // Геттеры и сеттеры

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double get_1h() {
        return _1h;
    }

    public void set_1h(Double _1h) {
        this._1h = _1h;
    }

    public Double get_24h() {
        return _24h;
    }

    public void set_24h(Double _24h) {
        this._24h = _24h;
    }

    public Double get_7d() {
        return _7d;
    }

    public void set_7d(Double _7d) {
        this._7d = _7d;
    }

    public Double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Double marketCap) {
        this.marketCap = marketCap;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public List<Integer> getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(List<Integer> lastPrice) {
        this.lastPrice = lastPrice;
    }
}