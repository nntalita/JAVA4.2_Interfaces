package ru.netology.repository;

import ru.netology.domain.FlightOffer;
import ru.netology.exception.NotFoundException;

//private final ProductRepository repository;
//
//
//    public ProductManager(ProductRepository repository) {
//        this.repository = repository;
//    }

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

    public FlightOffer findById(int id) {
        for (FlightOffer item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        FlightOffer product = findById(id);
        if (product == null) {
            throw new NotFoundException("Element with id:" + id + " not found");
        }
        int length = items.length - 1;
        FlightOffer[] tmp = new FlightOffer[length];
        int index = 0;
        for (FlightOffer item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}
