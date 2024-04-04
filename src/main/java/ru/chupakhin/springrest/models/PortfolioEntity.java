package ru.chupakhin.springrest.models;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "portfolio")
public class PortfolioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "portfolio_coin",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "coin_id"))
    private Set<CoinEntity> coins = new HashSet<>();

    @OneToMany(mappedBy = "portfolio")
    private List<DealEntity> deals;

    @ElementCollection
    @Column(name = "last_price")
    private List<Integer> lastPrice;

    @ElementCollection
    @Column(name = "profile_volume_usd")
    private List<Double> profileVolumeUsd;

    @ElementCollection
    @Column(name = "profile_volume_btc")
    private List<Double> profileVolumeBtc;

    @Column(name = "current_volume_usd")
    private Double currentVolumeUsd;

    @Column(name = "current_volume_btc")
    private Double currentVolumeBtc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CoinEntity> getCoins() {
        return coins;
    }

    public void setCoins(Set<CoinEntity> coins) {
        this.coins = coins;
    }

    public List<DealEntity> getDeals() {
        return deals;
    }

    public void setDeals(List<DealEntity> deals) {
        this.deals = deals;
    }

    public List<Integer> getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(List<Integer> lastPrice) {
        this.lastPrice = lastPrice;
    }

    public List<Double> getProfileVolumeUsd() {
        return profileVolumeUsd;
    }

    public void setProfileVolumeUsd(List<Double> profileVolumeUsd) {
        this.profileVolumeUsd = profileVolumeUsd;
    }

    public List<Double> getProfileVolumeBtc() {
        return profileVolumeBtc;
    }

    public void setProfileVolumeBtc(List<Double> profileVolumeBtc) {
        this.profileVolumeBtc = profileVolumeBtc;
    }

    public Double getCurrentVolumeUsd() {
        return currentVolumeUsd;
    }

    public void setCurrentVolumeUsd(Double currentVolumeUsd) {
        this.currentVolumeUsd = currentVolumeUsd;
    }

    public Double getCurrentVolumeBtc() {
        return currentVolumeBtc;
    }

    public void setCurrentVolumeBtc(Double currentVolumeBtc) {
        this.currentVolumeBtc = currentVolumeBtc;
    }
}