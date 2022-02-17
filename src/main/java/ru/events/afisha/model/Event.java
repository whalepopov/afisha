package ru.events.afisha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Event {
    private UUID eventId;
    private String title;
    private String description;
    private String ageCategory;
    private Integer capacity;

}
