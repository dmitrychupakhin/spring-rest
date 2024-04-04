package ru.chupakhin.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chupakhin.springrest.models.CoinEntity;
import ru.chupakhin.springrest.models.DealEntity;

@Repository
public interface DealRepository extends JpaRepository<DealEntity, Long> {

}