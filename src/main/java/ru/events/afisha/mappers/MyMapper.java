package ru.events.afisha.mappers;

import ru.events.afisha.entities.EventEntity;
import ru.events.afisha.entities.TicketEntity;
import ru.events.afisha.model.Event;
import ru.events.afisha.model.Ticket;
import ru.events.afisha.controllers.dto.EventDto;
import ru.events.afisha.controllers.dto.TicketDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyMapper {

    EventEntity toEntity(Event event);
    Event toDomain(EventEntity eventEntity);
    TicketEntity toEntity(Ticket ticket);
    Ticket toDomain(TicketEntity ticketEntity);

    EventDto toDto(Event event);
    Event toDomain(EventDto eventDto);

    TicketDto toDto(Ticket ticket);
    Ticket toDomain(TicketDto ticketDto);
}