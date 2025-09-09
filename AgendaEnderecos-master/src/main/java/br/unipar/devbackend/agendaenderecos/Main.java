package br.unipar.devbackend.agendaenderecos;

import br.unipar.devbackend.agendaenderecos.dao.ClienteDAO;
import br.unipar.devbackend.agendaenderecos.dao.EnderecoDAO;
import br.unipar.devbackend.agendaenderecos.model.Cliente;
import br.unipar.devbackend.agendaenderecos.model.Endereco;
import br.unipar.devbackend.agendaenderecos.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

//    public static void main(String[] args) {
//        EntityManagerUtil.getEmf();
//
//        Endereco endereco = new Endereco();
//        endereco.setCep("85915-230");
//        endereco.setLogradouro("Rua das Araucárias");
//        endereco.setBairro("Vila Industrial");
//        endereco.setComplemento("Casa rosa");
//        endereco.setLocalidade("Cascavel");
//        endereco.setUf("CE");
//
//        EnderecoDAO dao = new EnderecoDAO(EntityManagerUtil.getEm());
//        dao.gravar(endereco);
//
//        EntityManagerUtil.closeEmf();
//
//    }

    public static void main(String[] args) {
        EntityManagerUtil.getEmf();

        Cliente cliente = new Cliente();
       cliente.setNome("Gabriel");
       cliente.setEmail("gabriel@gmail.com");
       cliente.setDataNascimento(new Date("1995/05/08"));


        ClienteDAO dao = new ClienteDAO(EntityManagerUtil.getEm());
        dao.gravar(cliente);

        EntityManagerUtil.closeEmf();
    }

//    public static void main(String[] args) {
//        EntityManagerUtil.getEmf();
//
//        EnderecoDAO dao = new EnderecoDAO(EntityManagerUtil.getEm());
//        List<Endereco> enderecos = dao.findByCep("85900-199");
//
//        for(Endereco end : enderecos){
//            System.out.println("CEP: "  + end.getCep() +
//                    ", logradouro: " +  end.getLogradouro() +
//                    ", Bairro " + end.getBairro() +
//                    ", Localidade: " + end.getLocalidade() + "/" + end.getUf());
//
//        }
//
//        EntityManagerUtil.closeEmf();
//
//    }

    //primeiro contato com entitymanager persistimos um endereço
//    public static void main(String[] args) {
//        EntityManagerUtil.getEmf();
//        System.out.println("Hello World");
//        Endereco endereco = new Endereco();
//        endereco.setCep("85900-199");
//        endereco.setLogradouro("Rua do Lego");
//        endereco.setComplemento("apto 101");
//        endereco.setBairro("Centro");
//        endereco.setLocalidade("Toledo");
//        endereco.setUf("PR");
//
//
//
//        EntityManager em = EntityManagerUtil.getEm();
//
//        try {
//            em.getTransaction().begin();
//            em.persist(endereco);
//
//              em.getTransaction().commit();
//
//        } catch (Exception ex){
//            System.out.println("Erro ao persistir o endereço: " + ex.getMessage());
//        } finally {
//            if (em.isOpen()) {
//                em.close();
//                System.out.println("EntityManager fechado.");
//            }
//            EntityManagerUtil.closeEmf();
//        }
//    }

//    public static void main(String[] args) {
//        EntityManagerUtil.getEmf();
//
//        Cliente cliente = new Cliente();
//        cliente.setNome("Gabriel");
//        cliente.setEmail("gabriel@gmail.com");
//        cliente.setDataNascimento(new Date("1995/05/08"));
//
//        Endereco endereco = new Endereco();
//        endereco.setCep("85805-020");
//        endereco.setLogradouro("Rua Paraguai");
//        endereco.setBairro("Centro");
//        endereco.setLocalidade("Cascavel");
//        endereco.setUf("PR");
//        endereco.setCliente(cliente);
//
//        cliente.getEnderecos().add(endereco);
//
//        EntityManager em = EntityManagerUtil.getEm();
//
//        try {
//            em.getTransaction().begin();
//            em.persist(cliente);
//            em.getTransaction().commit();
//
//        } catch (Exception ex) {
//            em.getTransaction().rollback();
//            System.out.println("Erro ao persistir o cliente: " + ex.getMessage());
//        } finally {
//            if (em.isOpen()){
//                em.close();
//                System.out.println("EntityManager fechado.");
//            }
//            EntityManagerUtil.closeEmf();
//        }
//
//
//    }

//    public static void main(String[] args) {
//        EntityManagerUtil.getEmf();
//
//        EntityManager em = EntityManagerUtil.getEm();
//        Cliente cliente = em.find(Cliente.class, 2);
//
//        System.out.println("Cliente: " + cliente.getNome() +
//                ", Email: " + cliente.getEmail() +
//                ", Data de Nascimento: " + cliente.getDataNascimento());
//        System.out.println("Endereços do Cliente " + cliente.getNome());
//        for (Endereco end :  cliente.getEnderecos()) {
//            System.out.println("CEP: "  + end.getCep() +
//                    ", logradouro: " +  end.getLogradouro() +
//                    ", Bairro " + end.getBairro() +
//                    ", Localidade: " + end.getLocalidade() + "/" + end.getUf());
//        }
//
//
//    }

//    public static void main(String[] args) {
//        EntityManagerUtil.getEmf();
//
//        EntityManager em = EntityManagerUtil.getEm();
//        List<Cliente> clientes = new ArrayList<>();
//
//        clientes = em.createQuery("SELECT t FROM Cliente t", Cliente.class).getResultList();
//
//        for(Cliente cli : clientes) {
//            System.out.println(cli.getId() + " - " +
//                    cli.getNome());
//        }
//
//    }

//    public static void main(String[] args) {
//        EntityManagerUtil.getEmf();
//
//        EntityManager em = EntityManagerUtil.getEm();
//        Cliente cliente = em.find(Cliente.class, 1); // encontra cliente
//
//        System.out.println("Email do " + cliente.getNome() + ": " + cliente.getEmail());
//
//        cliente.setEmail("zezejoao@unipar.br"); // edita email
//
//        try{
//            em.getTransaction().begin(); //bloco de transacao
//            em.merge(cliente); // merge = update != persist = insert
//            em.getTransaction().commit();
//
//        } catch (Exception e){
//            em.getTransaction().rollback();
//            System.out.println("Algo de errado não deu certo: " + e.getMessage());
//
//        }finally {
//            if (em.isOpen()) {
//                em.close();
//                System.out.println("EntityManager closed.");
//            }
//            System.out.println("Email novo do " + cliente.getNome() + ": " + cliente.getEmail());
//        }
//    }

//    public static void main(String[] args) {
//        EntityManagerUtil.getEmf();
//
//        EntityManager em = EntityManagerUtil.getEm(); //entity manager (responpasavel pela aquisição)
//        Cliente cliente = em.find(Cliente.class, 4); //encontra cliente id=1 find = select where id...
//
//        try{
//            em.getTransaction().begin(); //abrindo transação
//            em.remove(cliente); //remove = delete
//            em.getTransaction().commit(); //confirma que é isso mesmo
//        }catch (Exception ex){
//            em.getTransaction().rollback();
//            System.out.println("Algo de errado não deu certo: " + ex.getMessage());
//        } finally {
//            if(em.isOpen()){
//                em.close();
//                System.out.println("EntityManager fechado. ");
//            }
//            System.out.println("Cliente removido: " + cliente.getNome());
//        }
//
//        EntityManagerUtil.closeEmf();
//
//
//    }




}
