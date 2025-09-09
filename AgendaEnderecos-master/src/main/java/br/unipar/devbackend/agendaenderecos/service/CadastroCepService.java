package br.unipar.devbackend.agendaenderecos.service;

import br.unipar.devbackend.agendaenderecos.dao.ClienteDAO;
import br.unipar.devbackend.agendaenderecos.dao.EnderecoDAO;
import br.unipar.devbackend.agendaenderecos.model.Cliente;
import br.unipar.devbackend.agendaenderecos.model.Endereco;
import br.unipar.devbackend.agendaenderecos.utils.EntityManagerUtil;
import jakarta.xml.bind.JAXBException;

import jakarta.persistence.EntityManager;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public class CadastroCepService {

    private final ViaCepService viaCepService = new ViaCepService();

    public static String normalizarCepSomenteDigitos(String cep) {
        if (cep == null) throw new IllegalArgumentException("CEP não informado.");
        String digits = cep.replaceAll("\\D", "");
        if (digits.length() != 8) throw new IllegalArgumentException("CEP inválido. Informe 8 dígitos.");
        return digits;
    }

    private static String formatarComHifen(String cepSomenteDigitos) {
        return cepSomenteDigitos.substring(0, 5) + "-" + cepSomenteDigitos.substring(5);
    }


    public Endereco obterOuCriarEnderecoPorCep(String cepDigitado) throws IOException, JAXBException {
        String digits = normalizarCepSomenteDigitos(cepDigitado);
        String cepFormatado = formatarComHifen(digits);

        EntityManager em = EntityManagerUtil.getEm();
        EnderecoDAO endRepo = new EnderecoDAO(em);

        Optional<Endereco> existente = endRepo.findOneByCep(cepFormatado);
        if (existente.isPresent()) {
            System.out.println("✔ CEP encontrado no banco: " + cepFormatado);
            return existente.get();
        }

        System.out.println("ℹ CEP não encontrado no banco. Consultando ViaCEP…");
        Endereco viaCep = viaCepService.buscarCep(cepFormatado);
        if (viaCep == null || viaCep.getCep() == null) {
            throw new IllegalArgumentException("CEP não localizado na API ViaCEP.");
        }


        viaCep.setCep(cepFormatado);
        viaCep.setCriadoEm(LocalDateTime.now());

        endRepo.gravar(viaCep);
        System.out.println("✔ Endereço criado e salvo com sucesso para o CEP: " + cepFormatado);
        return viaCep;
    }


    public Cliente cadastrarCliente(Endereco endereco, String nome, String email, Date dataNascimento) {
        if (endereco == null) throw new IllegalArgumentException("Endereço obrigatório.");
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setEmail(email);
        c.setDataNascimento(dataNascimento);
        c.setEndereco(endereco);

        EntityManager em = EntityManagerUtil.getEm();
        ClienteDAO cliRepo = new ClienteDAO(em);
        cliRepo.gravar(c);

        System.out.println("🎉 Cliente cadastrado com sucesso e associado ao endereço!");
        return c;
    }
}
