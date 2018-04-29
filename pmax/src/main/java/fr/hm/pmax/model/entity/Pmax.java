package fr.hm.pmax.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pmax {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pmax_id")
    private Long id;
    private Long value;

}
