package ru.events.afisha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    private Long ticketId;
    private Long eventId;
    private Integer placeId;
    private Integer rowId;
}
