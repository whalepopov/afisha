package ru.events.afisha.services;

import org.springframework.stereotype.Service;
import ru.events.afisha.annotations.Sendable;
import ru.events.afisha.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    private Event event;
    private List<Event> eventList;

    //@Sendable
    public Event addEvent(String title, String description, String ageCategory, Integer capacity) {
        event = new Event(UUID.randomUUID(), title, description, ageCategory, capacity);
        if (eventList == null || eventList.size() == 0) {
            eventList = new ArrayList<>();
        }
        eventList.add(event);
        return event;
    }

    @Sendable
    public void setEvent(String title, String description, String ageCategory, Integer capacity) {
        event.setTitle(title);
        event.setDescription(description);
        event.setAgeCategory(ageCategory);
        event.setCapacity(capacity);
    }

    public void deleteEvent() {
        eventList.remove(event);
    }

    public Event getEvent() {
        System.out.println(event.getEventId() + " " + event.getTitle() + " " + event.getDescription() + " " + event.getAgeCategory());
        return event;
    }

    public void getEventList() {
        for (Event event : eventList) {
            System.out.println(event.getEventId() + " " + event.getTitle() + " " + event.getDescription() + " " + event.getAgeCategory());
        }
    }
}
