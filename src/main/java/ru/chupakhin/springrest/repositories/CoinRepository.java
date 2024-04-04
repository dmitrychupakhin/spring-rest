package ru.chupakhin.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chupakhin.springrest.models.CoinEntity;

@Repository
public interface CoinRepository extends JpaRepository<CoinEntity, Long> {

}