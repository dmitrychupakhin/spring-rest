package ru.chupakhin.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chupakhin.springrest.models.CoinEntity;
import ru.chupakhin.springrest.repositories.CoinRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coins")
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;

    @GetMapping
    public List<CoinEntity> getAllCoins() {
        return coinRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CoinEntity> getCoinById(@PathVariable Long id) {
        Optional<CoinEntity> coinOptional = coinRepository.findById(id);
        return coinOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<CoinEntity> createCoin(@RequestBody CoinEntity coin) {
        CoinEntity savedCoin = coinRepository.save(coin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCoin);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CoinEntity> updateCoin(@PathVariable Long id, @RequestBody CoinEntity updatedCoin) {
        Optional<CoinEntity> coinOptional = coinRepository.findById(id);
        if (coinOptional.isPresent()) {
            updatedCoin.setId(id);
            CoinEntity savedCoin = coinRepository.save(updatedCoin);
            return ResponseEntity.ok(savedCoin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoin(@PathVariable Long id) {
        Optional<CoinEntity> coinOptional = coinRepository.findById(id);
        if (coinOptional.isPresent()) {
            coinRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}