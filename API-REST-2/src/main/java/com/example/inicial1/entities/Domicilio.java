package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
@ToString
@Entity
@Audited
@Table(name = "Domicilio")

public class Domicilio extends Base{

    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private int numero;

    @ManyToOne(optional = false) //Con optional no permito que no exista esta instancia, siempre que creo una persona esta estará asignada a un domicilio
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}
