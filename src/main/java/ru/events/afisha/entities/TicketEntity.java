package ru.events.afisha.entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_ticket")
    @SequenceGenerator(name = "seq_ticket", sequenceName = "public.seq_ticket", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "event_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private EventEntity event;

    @Column(name = "place")
    private Integer place;

    @Column(name = "row")
    private Integer row;

    @Version
    private Integer version;
}