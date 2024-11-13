package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Entry;

import java.time.LocalDateTime;

@QuarkusTest
public class EntryResourceTest {

    @Test
    public void testCheckOutAfterCheckIn() {
        // Given
        Entry entry = new Entry();
        LocalDateTime checkIn = LocalDateTime.of(2023, 10, 1, 10, 0);
        LocalDateTime checkOut = LocalDateTime.of(2023, 10, 1, 12, 0);
        entry.setCheckIn(checkIn);
        entry.setCheckOut(checkOut);

        // When
        boolean result = entry.getCheckOut().isAfter(entry.getCheckIn());

        // Then
        assertTrue(result, "Check-out should be after check-in");
    }

    @Test
    public void givenCheckOutIsNull() {
        // Given
        Entry entry = new Entry();
        LocalDateTime checkIn = LocalDateTime.of(2023, 10, 1, 10, 0);
        entry.setCheckIn(checkIn);
        entry.setCheckOut(null);

        // When
        LocalDateTime checkOut = entry.getCheckOut();

        // Then
        assertNull(checkOut, "Check-out should be null");
    }
}