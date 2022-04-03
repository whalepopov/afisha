package ru.events.afisha.services;

import ru.events.afisha.entities.EventEntity;
import ru.events.afisha.entities.TicketEntity;
import ru.events.afisha.mappers.MyMapper;
import ru.events.afisha.repository.JpaEventRepository;
import ru.events.afisha.repository.JpaTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {

    private JpaTicketRepository repository;
    private MyMapper mapper;
    private JpaEventRepository eventRepository;

    @Autowired
    public TicketService(JpaTicketRepository repository, MyMapper mapper, JpaEventRepository eventRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.eventRepository = eventRepository;
    }

    @Transactional
    public Long buyTicket(Long eventId, Integer place, Integer row) {
        EventEntity event = eventRepository.getById(eventId);
        TicketEntity ticketEntity = repository.save(new TicketEntity(null, event, place, row, 0));
        eventRepository.save(new EventEntity(null, event.getTitle(), event.getDescription(), event.getAgeCategory(), event.getCapacity() - 1, event.getVersion()));
        return ticketEntity.getId();
    }

    @Transactional
    public void refundTicket(Long ticketId) {
        TicketEntity ticketEntity = repository.getById(ticketId);
        System.out.println(ticketEntity.getEvent());
        EventEntity event = eventRepository.getById(ticketEntity.getEvent().getId());
        eventRepository.save(new EventEntity(event.getId(), event.getTitle(), event.getDescription(), event.getAgeCategory(), event.getCapacity() + 1, event.getVersion()));
        repository.deleteById(ticketId);
    }

    public TicketEntity getById(Long id) {
        return repository.getById(id);
    }
}