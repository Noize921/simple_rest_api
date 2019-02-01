package md.codefacotry.homework.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Country {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String capital;
}
