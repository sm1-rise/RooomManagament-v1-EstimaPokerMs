package br.com.samuel.martins.sm1_rise.RoomManagement_v1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "stories")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(min = 1, max = 100, message = "descripton must be bigger than 1 and small or equals 100")
    private String description;

    private UUID createdBy;

    private LocalDateTime createdAt;

    @Min(value = 1)
    private Double estimatedPoints;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private Double averagePoints;


}
