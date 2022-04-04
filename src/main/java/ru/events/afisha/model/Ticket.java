package ru.events.afisha.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ticket {
    private Long ticketId;
    private Long eventId;
    private Integer placeId;
    private Integer rowId;
}
