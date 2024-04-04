package ru.chupakhin.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chupakhin.springrest.models.CoinEntity;
import ru.chupakhin.springrest.models.ExchangesEntity;

@Repository
public interface ExchangesRepository extends JpaRepository<ExchangesEntity, Long> {

}