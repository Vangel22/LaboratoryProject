package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "balloon_orders")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private String deliveryAddress;

    private LocalDateTime timestamp;

    @ManyToMany
    private List<Balloon> balloons;


    public Order(User user, String deliveryAddress) {
        this.user = user;
        this.timestamp = LocalDateTime.now();
        this.deliveryAddress = deliveryAddress;
        this.balloons = new ArrayList<>();
    }
}
