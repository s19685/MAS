package mas.myestate.Models.Entities;

import javax.persistence.*;

@Entity
public class Estate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
}
