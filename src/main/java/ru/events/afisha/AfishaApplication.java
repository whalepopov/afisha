package ru.events.afisha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.events.afisha.services.EventService;
import ru.events.afisha.services.TicketService;

import java.util.UUID;

@SpringBootApplication
public class AfishaApplication {

    public static void main(String[] args) {

        final ConfigurableApplicationContext ctx = SpringApplication.run(AfishaApplication.class, args);

        final EventService eventService = ctx.getBean(EventService.class);
        final TicketService ticketService = ctx.getBean(TicketService.class);

        eventService.addEvent("Guns N’ Roses", "будет жарко ", "18+", 30000);
        eventService.setEvent("Red Hot Chili Peppers", "будет весело", "18+", 30000);
        eventService.addEvent("Pearl Jam", "опапа", "21+", 50000);
        eventService.getEventList();
        System.out.println("-----------");
        eventService.deleteEvent();
        eventService.getEventList();

        System.out.println("-----------||-----------");
        UUID guid = UUID.randomUUID();
        ticketService.buyTicket(guid, 13, 13);
        ticketService.returnTicket(guid);

    }
}
