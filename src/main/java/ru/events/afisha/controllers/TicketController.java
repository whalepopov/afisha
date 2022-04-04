package ru.events.afisha.controllers;

import ru.events.afisha.controllers.dto.TicketDto;
import ru.events.afisha.mappers.MyMapper;
import ru.events.afisha.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private TicketService ticketService;
    private MyMapper mapper;

    @Autowired
    public TicketController(TicketService ticketService, MyMapper mapper) {
        this.ticketService = ticketService;
        this.mapper = mapper;
    }

    @PostMapping
    public Long buy(@RequestBody TicketDto ticketDto) {
        return ticketService.buyTicket(mapper.toDomain(ticketDto));
    }

    @DeleteMapping("/{id}")
    public void refund(@PathVariable("id") Long id) {
        ticketService.refundTicket(id);
    }

}