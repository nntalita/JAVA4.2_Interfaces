package ru.netology.repository;

import ru.netology.domain.FlightOffer;


public class FlightOfferRepository {
    private FlightOffer[] items = new FlightOffer[0];

    public void save(FlightOffer item) {
        int length = items.length + 1;
        FlightOffer[] tmp = new FlightOffer[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FlightOffer[] findAll() {
        return items;
    }


}
