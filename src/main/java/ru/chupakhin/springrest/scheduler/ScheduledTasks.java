package ru.chupakhin.springrest.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.chupakhin.springrest.models.CoinEntity;
import ru.chupakhin.springrest.services.CoinService;
import ru.chupakhin.springrest.services.UpdateStatusService;
import ru.chupakhin.springrest.util.JsonToEntityMapper;

import java.util.List;

@Component
public class ScheduledTasks {
    @Autowired
    private CoinService coinService;
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "https://api.coincap.io/v2/assets";
    @Autowired
    private UpdateStatusService updateStatusService;
    @Scheduled(fixedRate = 10000)
    public void fetchFromApi() {
        boolean success = true;
        try {
            String response = restTemplate.getForObject(URL, String.class);
            List<CoinEntity> coins = JsonToEntityMapper.mapJsonToEntity(response);
            coinService.saveOrUpdateCoins(coins);
            logger.info("API Response: {}", response);
        } catch (Exception e) {
            success = false;
            logger.error("Failed to fetch data from API", e);
        }
        updateStatusService.saveUpdateStatus(success);
    }
}