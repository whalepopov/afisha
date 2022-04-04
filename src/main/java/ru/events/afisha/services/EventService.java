package ru.events.afisha.services;

import ru.events.afisha.entities.EventEntity;
import ru.events.afisha.mappers.MyMapper;
import ru.events.afisha.model.Event;
import ru.events.afisha.repository.JpaEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private JpaEventRepository eventRepository;
    private MyMapper mapper;

    @Autowired
    public EventService(JpaEventRepository repository, MyMapper mapper) {
        this.eventRepository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public Long addEvent(Event event) {
        EventEntity savedEntity = eventRepository.save(mapper.toEntity(event));
        return savedEntity.getId();
    }

    @Transactional
    public void setEvent(Event event) {
        final EventEntity pr = eventRepository.getById(event.getEventId());
        eventRepository.save(new EventEntity(event.getEventId(), event.getTitle(), event.getDescription(), event.getAgeCategory(), event.getCapacity(), pr.getVersion()));
    }


    @Transactional
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public void printEvent(Long id) {
        System.out.println(eventRepository.findById(id));
    }

    public void printAll() {
        eventRepository.findAll().forEach(System.out::println);
    }

    public EventEntity getbyId(Long id) {
        return eventRepository.getById(id);
    }

    public Event get(Long id) {
        return mapper.toDomain(eventRepository.getById(id));
    }

    public List<Event> getAll() {
        return eventRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}