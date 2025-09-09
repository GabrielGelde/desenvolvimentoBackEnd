package br.unipar.devbackend.agendaenderecos.model;

import jakarta.persistence.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@XmlRootElement(name = "xmlcep")
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "endereco",
        uniqueConstraints = @UniqueConstraint(name = "uk_endereco_cep", columnNames = "cep"))
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 9, nullable = false)
    private String cep;

    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();


    @OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Cliente> clientes = new ArrayList<>();


    public static Endereco unmarshalFromString(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Endereco.class); // cria o contexto
        Unmarshaller unmarshaller = context.createUnmarshaller();      // objeto que faz a conversão
        StringReader reader = new StringReader(xml);                   // lê a string
        return (Endereco) unmarshaller.unmarshal(reader);              // converte a string em objeto
    }
}

