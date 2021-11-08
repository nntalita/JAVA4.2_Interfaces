package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FlightOffer implements Comparable<FlightOffer> {
    private int id;
    private int ticketPrice;
    private String from;
    private String to;
    private int TravelTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightOffer that = (FlightOffer) o;
        return id == that.id && ticketPrice == that.ticketPrice && TravelTime == that.TravelTime && Objects.equals(from, that.from) && Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketPrice, from, to, TravelTime);
    }

    @Override
    public String toString() {
        return "FlightOffer{" +
                "id=" + id +
                ", ticketPrice=" + ticketPrice +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", TravelTime=" + TravelTime +
                '}';
    }


    @Override
    public int compareTo(FlightOffer o) {
        FlightOffer offer = (FlightOffer) o;
        int diff = this.ticketPrice - offer.ticketPrice;
        if (diff == 0) {
            return 0;
        } else if (diff < 0) {
            return -1;
        } else
            return 1;
    }

    public boolean matchesFrom(String search) {
        if (from.equals(search)) return true;
        return false;

    }

    public boolean matchesTo(String search) {
        if (to.equals(search)) return true;
        return false;

    }
}
