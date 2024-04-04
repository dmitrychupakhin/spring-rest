package ru.chupakhin.springrest.models;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "coin")
public class CoinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coin_name")
    private String coinName;

    @Column(name = "coin_code")
    private String coinCode;

    private Double price;

    @Column(name = "1h")
    private Double oneHourChange;

    @Column(name = "24h")
    private Double twentyFourHourChange;

    @Column(name = "7d")
    private Double sevenDayChange;

    @Column(name = "market_cap")
    private Double marketCap;

    private Double volume;

    @ElementCollection
    private List<Double> lastPrice;

    @ManyToMany(mappedBy = "coins")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true) // Только ID будет сериализован
    private Set<PortfolioEntity> portfolios = new HashSet<>();
    // Геттеры и сеттеры

    public Set<PortfolioEntity> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(Set<PortfolioEntity> portfolios) {
        this.portfolios = portfolios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getOneHourChange() {
        return oneHourChange;
    }

    public void setOneHourChange(Double oneHourChange) {
        this.oneHourChange = oneHourChange;
    }

    public Double getTwentyFourHourChange() {
        return twentyFourHourChange;
    }

    public void setTwentyFourHourChange(Double twentyFourHourChange) {
        this.twentyFourHourChange = twentyFourHourChange;
    }

    public Double getSevenDayChange() {
        return sevenDayChange;
    }

    public void setSevenDayChange(Double sevenDayChange) {
        this.sevenDayChange = sevenDayChange;
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

    public List<Double> getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(List<Double> lastPrice) {
        this.lastPrice = lastPrice;
    }
}
