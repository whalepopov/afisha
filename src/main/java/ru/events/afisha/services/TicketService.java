package ru.events.afisha.services;

import org.springframework.stereotype.Service;
import ru.events.afisha.model.Ticket;

import java.util.UUID;

@Service
public class TicketService {

    private Ticket ticket;

    public void buyTicket(UUID eventId, Integer placeId, Integer rowId) {
        System.out.println("Билет куплен: место " + placeId + ", ряд " + rowId);
    }

    public void returnTicket(UUID ticketId) {
        System.out.println("Билет возвращен: " + ticketId);
    }

}
