package ru.chupakhin.springrest.models;
import jakarta.persistence.*;

@Entity
@Table(name = "trend")
public class TrendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coin_id")
    private CoinEntity coin;

    @Column(name = "24h")
    private Double twentyFourHourChange;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoinEntity getCoin() {
        return coin;
    }

    public void setCoin(CoinEntity coin) {
        this.coin = coin;
    }

    public Double getTwentyFourHourChange() {
        return twentyFourHourChange;
    }

    public void setTwentyFourHourChange(Double twentyFourHourChange) {
        this.twentyFourHourChange = twentyFourHourChange;
    }
}