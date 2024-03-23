package ru.chupakhin.springrest.dto;

import java.util.List;

public class ExchangeDto {
    private String name;
    private double score;
    private long volume24h;
    private int markets;
    private int coins;
    private List<Integer> lastVolume;

    // Геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public long getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(long volume24h) {
        this.volume24h = volume24h;
    }

    public int getMarkets() {
        return markets;
    }

    public void setMarkets(int markets) {
        this.markets = markets;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public List<Integer> getLastVolume() {
        return lastVolume;
    }

    public void setLastVolume(List<Integer> lastVolume) {
        this.lastVolume = lastVolume;
    }
}