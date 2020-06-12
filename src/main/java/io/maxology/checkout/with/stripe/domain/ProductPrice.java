package io.maxology.checkout.with.stripe.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Getter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPrice {
    private static ObjectMapper mapper = new ObjectMapper();
    String itemName;
    double price;
    String currencyCode;

    @Getter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Id {
        String priceId;
        @SneakyThrows
        public static Id fromJsonString(String json){
            return mapper.readValue(json, ProductPrice.Id.class);
        }
    }

    @SneakyThrows
    public static ProductPrice fromJsonString(String json){
        return mapper.readValue(json, ProductPrice.class);
    }
}
