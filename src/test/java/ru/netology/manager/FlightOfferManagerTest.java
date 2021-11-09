package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.FlightOfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class FlightOfferManagerTest {
    private FlightOfferManager manager = new FlightOfferManager(new FlightOfferRepository());
    private final FlightOffer first = new FlightOffer(1, 3500, "MOW",
            "IST", 180);
    private final FlightOffer second = new FlightOffer(2, 20000, "KGD",
            "PKC", 900);
    private final FlightOffer third = new FlightOffer(3, 10000, "CCU",
            "GOJ", 1200);
    private final FlightOffer fourth = new FlightOffer(4, 5000, "MOW",
            "KGD", 120);
    private final FlightOffer fifth = new FlightOffer(5, 1000, "MOW",
            "GOJ", 60);
    private final FlightOffer sixth = new FlightOffer(6, 500, "MOW",
            "IST", 120);
    private final FlightOffer seventh = new FlightOffer(7, 3500, "MOW",
            "IST", 200);
    private final FlightOffer eighth = new FlightOffer(8, 5000, "MOW",
            "IST", 180);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);


    }

    @Test
    public void shouldSearchBy() {
        FlightOffer[] actual = manager.searchBy("MOW", "IST");
        FlightOffer[] expected = {sixth, first, seventh, eighth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByOne() {
        FlightOffer[] actual = manager.searchBy("KGD", "PKC");
        FlightOffer[] expected = {second};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByNoFrom() {
        FlightOffer[] actual = manager.searchBy("", "PKC");
        FlightOffer[] expected = {};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByNoTo() {
        FlightOffer[] actual = manager.searchBy("MOW", "");
        FlightOffer[] expected = {};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByPart() {
        FlightOffer[] actual = manager.searchBy("MOW", "K");
        FlightOffer[] expected = {};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByNoFlight() {
        FlightOffer[] actual = manager.searchBy("MOW", "PKC");
        FlightOffer[] expected = {};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchById() {
        FlightOffer actual = manager.searchById(1);
        FlightOffer expected = first;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldSearchByMissingId() {
        FlightOffer actual = manager.searchById(11);
        FlightOffer expected = null;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldDeleteById() {
        manager.deleteById(2);
        FlightOffer[] actual = manager.viewAll();
        FlightOffer[] expected = {first, third, fourth, fifth, sixth, seventh, eighth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldDeleteByMissingId() {

        assertThrows(NotFoundException.class, () -> {
            manager.deleteById(55);
        });
    }
}