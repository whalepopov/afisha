package ru.events.afisha.mappers;

import ru.events.afisha.entities.EventEntity;
import ru.events.afisha.entities.TicketEntity;
import ru.events.afisha.model.Event;
import ru.events.afisha.model.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyMapper {

    EventEntity toEntity(Event event);

    Event toDomain(EventEntity eventEntity);

    TicketEntity toEntity(Ticket ticket);

    Ticket toDomain(TicketEntity ticketEntity);
}