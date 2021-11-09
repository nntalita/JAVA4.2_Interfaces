package ru.netology.domain;

import java.util.Comparator;

public class FlightOfferByPriceAscComparator implements Comparator<FlightOffer> {
    public int compare(FlightOffer o1, FlightOffer o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
