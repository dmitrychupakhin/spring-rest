package ru.chupakhin.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chupakhin.springrest.models.DealEntity;
import ru.chupakhin.springrest.repositories.DealRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deals")
public class DealController {

    @Autowired
    private DealRepository dealRepository;

    // Получение всех сделок
    @GetMapping
    public List<DealEntity> getAllDeals() {
        return dealRepository.findAll();
    }

    // Добавление новой сделки
    @PostMapping
    public ResponseEntity<DealEntity> addDeal(@RequestBody DealEntity deal) {
        DealEntity savedDeal = dealRepository.save(deal);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDeal);
    }

    // Удаление сделки по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeal(@PathVariable Long id) {
        Optional<DealEntity> dealOptional = dealRepository.findById(id);
        if (dealOptional.isPresent()) {
            dealRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}