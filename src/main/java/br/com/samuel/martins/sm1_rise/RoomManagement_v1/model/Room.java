package br.com.samuel.martins.sm1_rise.RoomManagement_v1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "name cannot be null or blank")
    @Size(min= 3, max = 50, message = "" )
    private String name;

    private UUID createdBy;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime closedAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "room_players", joinColumns = @JoinColumn(name = "room_id"))
    @Column(name = "player_id")
    private Set<UUID> players;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Story> stories;

}


