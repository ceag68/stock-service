package com.caribesoft.stockservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
public class StockPrice implements Serializable {
    String symbol;
    Double price;
    LocalDateTime time;

    public StockPrice(String symbol, Double price, LocalDateTime time) {
        this.symbol = symbol;
        this.price = price;
        this.time = time;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "StockPrice{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockPrice)) return false;
        StockPrice that = (StockPrice) o;
        return getSymbol().equals(that.getSymbol()) && getPrice().equals(that.getPrice()) && getTime().equals(that.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbol(), getPrice(), getTime());
    }
}
