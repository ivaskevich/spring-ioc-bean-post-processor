package com.bobocode.demo.service;

import com.bobocode.demo.annotation.Trimmed;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Trimmed
@Service
public class ProductInfoService {

    private static String advertisementText = """
                                    Hello guys !
            Only today you can buy %s from the manufacturer %s at a discount of %s percent.
            The final price of the goods is only %s hryvnias!              """;

    @SneakyThrows
    public String composeAdvertisement(String productName, Integer price, String producerName, int discountPercent) {
        return String
                .format(advertisementText, productName, producerName, discountPercent, price);
    }
}
