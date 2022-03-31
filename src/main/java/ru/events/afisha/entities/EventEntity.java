package ru.events.afisha.entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="premiere")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_premiere")
    @SequenceGenerator(name = "seq_premiere", sequenceName = "public.seq_premiere", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "agecategory")
    private String ageCategory;

    @Column(name = "capacity")
    private Integer capacity;

    @Version
    private Integer version;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%s (%s)\n %s\n %s", title, ageCategory, description, capacity));
        return sb.toString();
    }
}