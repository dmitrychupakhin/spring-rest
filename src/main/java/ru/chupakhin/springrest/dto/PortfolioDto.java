package ru.chupakhin.springrest.dto;
import java.util.List;

public class PortfolioDto {
    private List<CoinDto> coins;
    private List<DealDto> deals;
    private List<Double> profileVolumeUsd;
    private List<Double> profileVolumeBtc;
    private double currentVolumeUsd;
    private double currentVolumeBtc;

    // Геттеры и сеттеры

    public List<CoinDto> getCoins() {
        return coins;
    }

    public void setCoins(List<CoinDto> coins) {
        this.coins = coins;
    }

    public List<DealDto> getDeals() {
        return deals;
    }

    public void setDeals(List<DealDto> deals) {
        this.deals = deals;
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

    public double getCurrentVolumeUsd() {
        return currentVolumeUsd;
    }

    public void setCurrentVolumeUsd(double currentVolumeUsd) {
        this.currentVolumeUsd = currentVolumeUsd;
    }

    public double getCurrentVolumeBtc() {
        return currentVolumeBtc;
    }

    public void setCurrentVolumeBtc(double currentVolumeBtc) {
        this.currentVolumeBtc = currentVolumeBtc;
    }
}