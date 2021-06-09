package mas.myestate.Models.Entities;

import javax.persistence.*;

@Entity
public class Apartment extends Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
}
