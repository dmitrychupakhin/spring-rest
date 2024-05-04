package ru.chupakhin.springrest.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chupakhin.springrest.models.UpdateStatusEntity;
import ru.chupakhin.springrest.repositories.UpdateStatusRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UpdateStatusService {

    @Autowired
    private UpdateStatusRepository updateStatusRepository;

    @Transactional
    public void saveUpdateStatus(boolean success) {
        UpdateStatusEntity updateStatus = new UpdateStatusEntity();
        updateStatus.setUpdateTime(LocalDateTime.now());
        updateStatus.setSuccess(success);

        List<UpdateStatusEntity> oldStatuses = updateStatusRepository.findAll();

        if (oldStatuses.size() >= 10) {
            UpdateStatusEntity oldestStatus = oldStatuses.get(0);
            updateStatusRepository.delete(oldestStatus);
        }

        updateStatusRepository.save(updateStatus);
    }
}