package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.domain.FlightOfferByPriceAscComparator;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.FlightOfferRepository;

import static org.junit.jupiter.api.Assertions.*;

public class SingleItemFlightOfferManagerTest {
    private final FlightOfferManager manager = new FlightOfferManager(new FlightOfferRepository());
    FlightOfferByPriceAscComparator comparator = new FlightOfferByPriceAscComparator();
    private final FlightOffer first = new FlightOffer(1, 3500, "MOW",
            "IST", 180);

    @BeforeEach
    public void setUp() {
        manager.add(first);
    }


    @Test
    public void shouldFindAll() {
        FlightOffer[] actual = manager.findAll("MOW", "IST", comparator);
        FlightOffer[] expected = {first};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAllNoFligt() {
        FlightOffer[] actual = manager.findAll("MOW", "GOW", comparator);
        FlightOffer[] expected = {};
        assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldSearchBy() {
        FlightOffer[] actual = manager.searchBy("MOW", "IST");
        FlightOffer[] expected = {first};
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
    public void shouldSearchByMissingId() {
        FlightOffer actual = manager.searchById(11);
        FlightOffer expected = null;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldDeleteByMissingId() {

        assertThrows(NotFoundException.class, () -> {
            manager.deleteById(55);
        });
    }

    @Test
    public void shouldSearchByNoFlight() {
        FlightOffer[] actual = manager.searchBy("MOW", "PKC");
        FlightOffer[] expected = {};
        assertArrayEquals(actual, expected);
    }
}
