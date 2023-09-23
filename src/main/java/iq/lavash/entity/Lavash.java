package iq.lavash.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Entity
public class Lavash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 7, message = "At least 7 characters")
    private String name;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 2, message = "Choose at least 2 elements")
    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();


}
