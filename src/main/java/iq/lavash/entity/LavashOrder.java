package iq.lavash.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class LavashOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt = new Date();

    @NotBlank
    @Size(min = 7, message = "Name must be at least 7 characters")
    private String deliveryName;

    @Digits(integer = 5, fraction = 0, message = "Enter digits only")
    private int deliveryHomeNumber;

    @NotBlank
    @Size(min = 4, message = "Name must be at least 4 characters")
    private String deliveryStreet;
    @NotBlank

    @Size(min = 4, message = "Name must be at least 4 characters")
    private String deliveryDistrict;

    @CreditCardNumber(message = "Enter Valid Credit Card Number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Lavash> lavashs = new ArrayList<>();

    public void addLavash(Lavash lavash) {

        this.lavashs.add(lavash);
    }


}
