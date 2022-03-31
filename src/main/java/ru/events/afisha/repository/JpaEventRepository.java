package ru.events.afisha.repository;

import ru.events.afisha.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEventRepository extends JpaRepository<EventEntity, Long> {
    EventEntity getById(Long Id);
}