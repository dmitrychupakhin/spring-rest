package ru.chupakhin.springrest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chupakhin.springrest.models.PortfolioEntity;
import ru.chupakhin.springrest.repositories.PortfolioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    // Получение всех портфолио
    @GetMapping
    public List<PortfolioEntity> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    // Получение портфолио по ID
    @GetMapping("/{id}")
    public ResponseEntity<PortfolioEntity> getPortfolioById(@PathVariable Long id) {
        Optional<PortfolioEntity> portfolioOptional = portfolioRepository.findById(id);
        return portfolioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Добавление нового портфолио
    @PostMapping
    public ResponseEntity<PortfolioEntity> addPortfolio(@RequestBody PortfolioEntity portfolio) {
        PortfolioEntity savedPortfolio = portfolioRepository.save(portfolio);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPortfolio);
    }

    // Обновление портфолио по ID
    @PutMapping("/{id}")
    public ResponseEntity<PortfolioEntity> updatePortfolio(@PathVariable Long id, @RequestBody PortfolioEntity updatedPortfolio) {
        Optional<PortfolioEntity> portfolioOptional = portfolioRepository.findById(id);
        if (portfolioOptional.isPresent()) {
            updatedPortfolio.setId(id);
            PortfolioEntity savedPortfolio = portfolioRepository.save(updatedPortfolio);
            return ResponseEntity.ok(savedPortfolio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Удаление портфолио по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id) {
        Optional<PortfolioEntity> portfolioOptional = portfolioRepository.findById(id);
        if (portfolioOptional.isPresent()) {
            portfolioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}