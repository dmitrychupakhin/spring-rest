package ru.chupakhin.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chupakhin.springrest.models.ExchangesEntity;
import ru.chupakhin.springrest.repositories.ExchangesRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exchanges")
public class ExchangesController {

    @Autowired
    private ExchangesRepository exchangesRepository;

    // Получение всех бирж
    @GetMapping
    public List<ExchangesEntity> getAllExchanges() {
        return exchangesRepository.findAll();
    }

    // Добавление новой биржи
    @PostMapping
    public ResponseEntity<ExchangesEntity> addExchange(@RequestBody ExchangesEntity exchange) {
        ExchangesEntity savedExchange = exchangesRepository.save(exchange);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExchange);
    }

    // Обновление существующей биржи по ID
    @PutMapping("/{id}")
    public ResponseEntity<ExchangesEntity> updateExchange(@PathVariable Long id, @RequestBody ExchangesEntity updatedExchange) {
        Optional<ExchangesEntity> exchangeOptional = exchangesRepository.findById(id);
        if (exchangeOptional.isPresent()) {
            updatedExchange.setId(id);
            ExchangesEntity savedExchange = exchangesRepository.save(updatedExchange);
            return ResponseEntity.ok(savedExchange);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Удаление биржи по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExchange(@PathVariable Long id) {
        Optional<ExchangesEntity> exchangeOptional = exchangesRepository.findById(id);
        if (exchangeOptional.isPresent()) {
            exchangesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}