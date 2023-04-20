package gunam.solarisgunam.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    private String firstname;

    private String lastname;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name ="authority_id" ))
    private Set<Authority> authorities;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_titles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "title_id"))
    private Set<Title> titles;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_positions",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "position_id"))
    private Set<Position> positions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_divisions",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "division_id"))
    private Set<Division> divisions;

}
