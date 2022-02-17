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
        //SpringApplication.run(AfishaApplication.class, args);

        final ConfigurableApplicationContext ctx = SpringApplication.run(AfishaApplication.class, args);
        ctx.getBean(EventService.class).addEvent("Guns N’ Roses", "будет жарко ", "18+", 30000);
        ctx.getBean(EventService.class).setEvent("Red Hot Chili Peppers", "будет весело", "18+", 30000);
        ctx.getBean(EventService.class).addEvent("Pearl Jam", "опапа", "21+", 50000);
        ctx.getBean(EventService.class).getEventList();
        System.out.println("-----------");
        ctx.getBean(EventService.class).deleteEvent();
        ctx.getBean(EventService.class).getEventList();

        System.out.println("-----------||-----------");
        UUID guid = UUID.randomUUID();
        ctx.getBean(TicketService.class).buyTicket(guid, 13, 13);
        ctx.getBean(TicketService.class).returnTicket(guid);

    }
}
