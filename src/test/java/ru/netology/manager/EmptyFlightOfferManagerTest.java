package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.FlightOfferRepository;

import static org.junit.jupiter.api.Assertions.*;

public class EmptyFlightOfferManagerTest {
    private final FlightOfferManager manager = new FlightOfferManager(new FlightOfferRepository());

    @Test
    public void shouldSearchBy() {
        FlightOffer[] actual = manager.searchBy("MOW", "IST");
        FlightOffer[] expected = {};
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
}
