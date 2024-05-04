package ru.chupakhin.springrest.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chupakhin.springrest.models.CoinEntity;
import ru.chupakhin.springrest.repositories.CoinRepository;

import java.util.List;

@Service
public class CoinService {

    @Autowired
    private CoinRepository coinRepository;

    @Transactional
    public void saveOrUpdateCoins(List<CoinEntity> coins) {
        for (CoinEntity coin : coins) {
            CoinEntity existingCoin = coinRepository.findByCoinCode(coin.getCoinCode());
            if (existingCoin != null) {
                // Обновляем существующую запись
                existingCoin.setCoinName(coin.getCoinName());
                existingCoin.setPrice(coin.getPrice());
                existingCoin.setOneHourChange(coin.getOneHourChange());
                existingCoin.setTwentyFourHourChange(coin.getTwentyFourHourChange());
                existingCoin.setSevenDayChange(coin.getSevenDayChange());
                existingCoin.setMarketCap(coin.getMarketCap());
                existingCoin.setVolume(coin.getVolume());
                coinRepository.save(existingCoin);
            } else {
                // Добавляем новую запись
                coinRepository.save(coin);
            }
        }
    }
}