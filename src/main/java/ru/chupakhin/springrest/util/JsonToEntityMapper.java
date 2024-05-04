package ru.chupakhin.springrest.util;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.chupakhin.springrest.models.CoinEntity;

import java.util.ArrayList;
import java.util.List;
public class JsonToEntityMapper {
    public static List<CoinEntity> mapJsonToEntity(String jsonData) {
        ObjectMapper mapper = new ObjectMapper();
        List<CoinEntity> coins = new ArrayList<>();
        try {
            JsonNode root = mapper.readTree(jsonData);
            JsonNode dataArray = root.path("data");

            for (JsonNode node : dataArray) {
                CoinEntity coin = new CoinEntity();
                coin.setCoinName(node.path("name").asText());
                coin.setCoinCode(node.path("symbol").asText());
                coin.setPrice(node.path("priceUsd").asDouble());
                coin.setOneHourChange(null);
                coin.setTwentyFourHourChange(node.path("changePercent24Hr").asDouble());
                coin.setSevenDayChange(null);
                coin.setMarketCap(node.path("marketCapUsd").asDouble());
                coin.setVolume(node.path("volumeUsd24Hr").asDouble());

                coins.add(coin);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return coins;
    }
}
