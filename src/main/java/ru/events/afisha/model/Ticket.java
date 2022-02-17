package ru.events.afisha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    private UUID ticketId;
    private UUID eventId;
    private Integer placeId;
    private Integer rowId;
}
