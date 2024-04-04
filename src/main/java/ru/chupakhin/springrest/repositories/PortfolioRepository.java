package ru.chupakhin.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chupakhin.springrest.models.CoinEntity;
import ru.chupakhin.springrest.models.PortfolioEntity;
import ru.chupakhin.springrest.models.TrendEntity;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Long> {

}