package org.ohjic.jpa.app;

import org.ohjic.jpa.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kim Donghoon on 2015-11-09.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fin_jpa_unit");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List<Integer> idList = Arrays.asList(1,2,3,4,5);
        for(Integer id : idList){
            Member member = new Member();
            member.setCity("korea");
            em.persist(member);
        }

        tx.commit();
        em.close();
        emf.close();
    }
}
