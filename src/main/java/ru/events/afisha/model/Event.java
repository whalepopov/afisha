package ru.events.afisha.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Event {
    private Long eventId;
    private String title;
    private String description;
    private String ageCategory;
    private Integer capacity;

}
