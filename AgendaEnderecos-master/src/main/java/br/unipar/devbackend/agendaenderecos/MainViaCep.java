package br.unipar.devbackend.agendaenderecos;

import br.unipar.devbackend.agendaenderecos.model.Endereco;
import br.unipar.devbackend.agendaenderecos.service.ViaCepService;
import jakarta.xml.bind.JAXBException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainViaCep {

    public static void main(String[] args) throws IOException, JAXBException {
        String cep = "85805020"; //cep estou buscando

        ViaCepService viaCep = new ViaCepService();
        Endereco endereco = viaCep.buscarCep(cep);

        System.out.println("CEP: " + endereco.getCep() +
                ", Logradouro: " + endereco.getLogradouro() +
                ", Bairro: " + endereco.getBairro() +
                ", Localidade: " + endereco.getLocalidade() +
                "/" + endereco.getUf());

        //buscar um cep qualquer
        // verificar se esse cep existe no banco de dados
            // se existir, pede pra adicionar um cliente para ele
            // se nao existir, grava um novo cep e com data e hora da gravacao



    }

}
