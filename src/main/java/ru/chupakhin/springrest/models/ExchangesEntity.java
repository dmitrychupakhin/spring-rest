package ru.chupakhin.springrest.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "exchange")
public class ExchangesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double score;

    @Column(name = "volume_24h")
    private Long volume24h;

    private Integer markets;

    private Integer coins;

    @ElementCollection
    @Column(name = "last_volume")
    private List<Integer> lastVolume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(Long volume24h) {
        this.volume24h = volume24h;
    }

    public Integer getMarkets() {
        return markets;
    }

    public void setMarkets(Integer markets) {
        this.markets = markets;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public List<Integer> getLastVolume() {
        return lastVolume;
    }

    public void setLastVolume(List<Integer> lastVolume) {
        this.lastVolume = lastVolume;
    }
}
