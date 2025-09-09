package br.unipar.devbackend.agendaenderecos.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private EntityManagerUtil() {} //construtor vazio para evitar instanciação externa

    public static EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence
                    .createEntityManagerFactory(
                            "agendaEnderecosPU");
            System.out.println("Conexão com o banco de " +
                    "dados estabelecida.");
        }
        return emf;
    }

    public static void closeEmf() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            System.out.println("Conexão com o banco de " +
                    "dados encerrada.");
        }
    }

    public static EntityManager getEm() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
            System.out.println("EnityManager criado.");
        }
        return em;
    }

}



