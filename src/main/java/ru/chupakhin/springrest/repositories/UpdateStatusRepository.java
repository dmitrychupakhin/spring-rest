package ru.chupakhin.springrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chupakhin.springrest.models.CoinEntity;
import ru.chupakhin.springrest.models.TrendEntity;
import ru.chupakhin.springrest.models.UpdateStatusEntity;

@Repository
public interface UpdateStatusRepository extends JpaRepository<UpdateStatusEntity, Long> {

}