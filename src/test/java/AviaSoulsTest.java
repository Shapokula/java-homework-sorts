import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Хабаровск", 90, 0, 8);
    Ticket ticket2 = new Ticket("Москва", "Хабаровск", 150, 0, 12);
    Ticket ticket3 = new Ticket("Санкт-Петербург", "Хабаровск", 90, 0, 20);
    Ticket ticket4 = new Ticket("Москва", "Владивосток", 160, 0, 23);
    Ticket ticket5 = new Ticket("Москва", "Хабаровск", 120, 0, 7);
    Ticket ticket6 = new Ticket("Москва", "Хабаровск", 100, 0, 10);
    Ticket ticket7 = new Ticket("Москва", "Хабаровск", 150, 0, 14);

    AviaSouls manager = new AviaSouls();

    @Test
    public void shouldReturnPositiveOne() {

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNegativeOne() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZero() {

        int expected = 0;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByPrice() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = { ticket1, ticket6, ticket5, ticket2, ticket7 };
        Ticket[] actual = manager.search("Москва", "Хабаровск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortUsingComparator() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket1, ticket6, ticket2, ticket7};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Хабаровск", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
