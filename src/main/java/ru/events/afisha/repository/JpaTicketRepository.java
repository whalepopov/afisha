package ru.events.afisha.repository;

import ru.events.afisha.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTicketRepository extends JpaRepository<TicketEntity, Long> {
    TicketEntity getById(Long Id);
}