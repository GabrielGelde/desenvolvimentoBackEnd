package br.unipar.devbackend.agendaenderecos;

import br.unipar.devbackend.agendaenderecos.model.Endereco;
import br.unipar.devbackend.agendaenderecos.service.CadastroCepService;
import br.unipar.devbackend.agendaenderecos.utils.EntityManagerUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainCadastroCep {

    public static void main(String[] args) {
        EntityManagerUtil.getEmf();
        Scanner sc = new Scanner(System.in);
        CadastroCepService service = new CadastroCepService();

        try {
            System.out.print("Informe um CEP: ");
            String cepDigitado = sc.nextLine();

            Endereco endereco = service.obterOuCriarEnderecoPorCep(cepDigitado);

            System.out.println("\nDeseja cadastrar um novo cliente para este endereço? (s/n)");
            String resp = sc.nextLine().trim().toLowerCase();
            if (resp.startsWith("s")) {
                System.out.print("Nome do cliente: ");
                String nome = sc.nextLine();

                System.out.print("E-mail: ");
                String email = sc.nextLine();

                System.out.print("Data de nascimento: ");
                String dn = sc.nextLine();
                Date dataNasc = null;
                try {
                    if (!dn.isBlank()) dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(dn);
                } catch (Exception ignore) {}

                service.cadastrarCliente(endereco, nome, email, dataNasc);
                System.out.println("✅ Cliente cadastrado com sucesso.");
            } else {
                System.out.println("Ok! Nenhum cliente cadastrado neste momento.");
            }

        } catch (IllegalArgumentException iae) {
            System.out.println("⚠ " + iae.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
            EntityManagerUtil.closeEmf();
        }
        System.out.println("Fim.");
    }
}
