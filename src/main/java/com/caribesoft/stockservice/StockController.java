package com.caribesoft.stockservice;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import org.springframework.web.bind.annotation.RestController;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@RestController
class StockController {

    @GetMapping(value="/stocks/{symbol}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<StockPrice> prices(@PathVariable("symbol") String symbol)
    {
        return Flux.interval(Duration.ofSeconds(1))
                .map(x -> new StockPrice(symbol, randomStockPrice(), LocalDateTime.now()));
    }

//    @GetMapping(value="/stocks/{symbol}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    StockPrice prices(@PathVariable("symbol") String symbol)
//    {
//        return new StockPrice(symbol, randomStockPrice(), LocalDateTime.now());
//    }

    private Double randomStockPrice() {
        return ThreadLocalRandom.current().nextDouble(100.0);
    }
}
