package ru.events.afisha.services;

import ru.events.afisha.annotations.Sendable;
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
    public void addEvent(String title, String description, String ageCategory, Integer capacity) {
        EventEntity eventEntity = new EventEntity(null, title, description, ageCategory, capacity, 0);
        eventRepository.save(eventEntity);

//        eventRepository.save(new EventEntity(789L, title, description, ageCategory, capacity, 1));

    }

    @Sendable
    @Transactional
    public void setEvent(EventEntity eventEntity) {
        final EventEntity pr = eventRepository.getById(eventEntity.getId());
        eventRepository.save(new EventEntity(eventEntity.getId(), eventEntity.getTitle(), eventEntity.getDescription(), eventEntity.getAgeCategory(), eventEntity.getCapacity(), pr.getVersion()));
    }

    @Transactional
    public void deleteEvent(EventEntity eventEntity) {
        eventRepository.delete(eventEntity);
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

    public List<Event> getAll() {
        return eventRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}