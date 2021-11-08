package ru.netology.manager;

import ru.netology.domain.FlightOffer;
import ru.netology.repository.FlightOfferRepository;

import java.util.Arrays;

public class FlightOfferManager {

    private final FlightOfferRepository repository;

    public FlightOfferManager(FlightOfferRepository repository) {
        this.repository = repository;
    }


    public void add(FlightOffer offer) {
        repository.save(offer);
    }

    public FlightOffer[] searchBy(String codFrom, String codTo) {
        FlightOffer[] result = new FlightOffer[0];
        FlightOffer[] offers = repository.findAll();
        if (codFrom.equals("")) return result;
        if (codTo.equals("")) return result;
        for (FlightOffer offer : offers) {
            if (offer.matchesFrom(codFrom) && offer.matchesTo(codTo)) {
                FlightOffer[] tmp = new FlightOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = offer;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public FlightOffer searchById(int id) {
        FlightOffer offer = repository.findById(id);
        return offer;
    }

    public void deleteById(int id) {
        repository.removeById(id);

    }
    public FlightOffer[] viewAll() {
        FlightOffer[] offers = repository.findAll();
        return offers;
    }

}
