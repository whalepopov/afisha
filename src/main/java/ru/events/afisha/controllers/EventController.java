package ru.events.afisha.controllers;

import ru.events.afisha.controllers.dto.EventDto;
import ru.events.afisha.mappers.MyMapper;
import ru.events.afisha.model.Event;
import ru.events.afisha.services.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/ololo")
@Slf4j
public class EventController {
    private EventService eventService;
    private MyMapper mapper;

    @Autowired
    public EventController(EventService eventService, MyMapper mapper) {
        this.eventService = eventService;
        this.mapper = mapper;

    }

    @PostMapping
    public Long add(@RequestBody EventDto EventDto) {
        return eventService.addEvent(mapper.toDomain(EventDto));
    }

    @PutMapping("/{id}")
    public void set(@PathVariable("id") Long id, @RequestBody EventDto eventDto) {
        eventService.setEvent(mapper.toDomain(eventDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        eventService.deleteById(id);
    }

    @GetMapping("/{id}")
    public EventDto get(@PathVariable("id") Long id) {
        return mapper.toDto(eventService.get(id));
    }

    @GetMapping
    public Collection<EventDto> getAll() {
        List<Event> eventList = eventService.getAll();
        log.info(String.valueOf(eventList.size()) + " премьер");
        return eventList.stream().map(mapper::toDto).collect(toList());
    }
}