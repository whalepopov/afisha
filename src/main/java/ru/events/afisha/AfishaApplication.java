package ru.events.afisha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.events.afisha.entities.EventEntity;
import ru.events.afisha.services.EventService;
import ru.events.afisha.services.TicketService;

import java.util.UUID;

@SpringBootApplication
public class AfishaApplication {

    public static void main(String[] args) {

        final ConfigurableApplicationContext ctx = SpringApplication.run(AfishaApplication.class, args);

        final EventService eventService = ctx.getBean(EventService.class);
        final TicketService ticketService = ctx.getBean(TicketService.class);

        eventService.addEvent("Guns and Roses", "will be hot", "10+", 7000);

        eventService.printAll();

        eventService.setEvent(new EventEntity(999L, "Rock", "great", "6+", 25000, 1));

        eventService.printEvent(999L);

        eventService.printAll();
        System.out.println("всего:" + eventService.getAll().size());

        Long ticketId = ticketService.buyTicket(999L, 13, 13);
        System.out.println("билет " + ticketId.toString());
        // ticketService.refundTicket(ticketId);

    }
}
