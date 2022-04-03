package ru.events.afisha.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDto {
    @JsonProperty
    Long id;
    @JsonProperty
    String title;
    @JsonProperty
    String description;
    @JsonProperty
    String ageCategory;
    @JsonProperty
    Integer capacity;
}