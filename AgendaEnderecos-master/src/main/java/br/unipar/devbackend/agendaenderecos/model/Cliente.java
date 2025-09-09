package br.unipar.devbackend.agendaenderecos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private Date dataNascimento;


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", foreignKey = @ForeignKey(name = "fk_cliente_endereco"))
    private Endereco endereco;
}
