package mas.myestate.Models.Entities;

import mas.myestate.Models.Enums.Role;

import javax.persistence.*;

@Entity
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firtName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String accountNumber;

    @Column(nullable = true)
    private Double salary;

    @Column(nullable = false)
    private Role role;

    
    public Resident() {
    }


}
