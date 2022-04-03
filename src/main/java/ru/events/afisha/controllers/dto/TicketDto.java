package ru.events.afisha.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDto {
    @JsonProperty
    Long id;
    @JsonProperty
    EventDto event;
    @JsonProperty
    Integer place;
    @JsonProperty
    Integer row;
}