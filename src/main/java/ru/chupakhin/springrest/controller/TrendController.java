package ru.chupakhin.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chupakhin.springrest.models.CoinEntity;
import ru.chupakhin.springrest.models.TrendEntity;
import ru.chupakhin.springrest.repositories.TrendRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trends")
public class TrendController {

    @Autowired
    private TrendRepository trendRepository;

    @GetMapping
    public List<TrendEntity> getAllCoins() {
        return trendRepository.findAll();
    }
    // Добавление нового тренда
    @PostMapping
    public ResponseEntity<TrendEntity> addTrend(@RequestBody TrendEntity trend) {
        TrendEntity savedTrend = trendRepository.save(trend);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrend);
    }

    // Обновление существующего тренда по ID
    @PutMapping("/{id}")
    public ResponseEntity<TrendEntity> updateTrend(@PathVariable Long id, @RequestBody TrendEntity updatedTrend) {
        Optional<TrendEntity> trendOptional = trendRepository.findById(id);
        if (trendOptional.isPresent()) {
            updatedTrend.setId(id);
            TrendEntity savedTrend = trendRepository.save(updatedTrend);
            return ResponseEntity.ok(savedTrend);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Удаление тренда по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrend(@PathVariable Long id) {
        Optional<TrendEntity> trendOptional = trendRepository.findById(id);
        if (trendOptional.isPresent()) {
            trendRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}