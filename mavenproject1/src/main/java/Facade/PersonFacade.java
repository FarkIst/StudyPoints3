/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Farkas
 */
public class PersonFacade implements IPersonFacade {

     EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person addPerson(Person p) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(p);
        em.getTransaction().commit();
        em.close();

        return p;
    }

    @Override
    public Person deletePerson(int id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person p = em.find(Person.class, id);
        Person a = p;
        em.remove(p);
        em.getTransaction().commit();
        em.close();

        return a;

    }

    @Override
    public Person getPerson(int id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person p = em.find(Person.class, id);
        em.getTransaction().commit();
        em.close();

        return p;
    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Person.findAll");
        List<Person> p = (List<Person>) query.getResultList();

        em.getTransaction().commit();
        em.close();

        return p;

    }

    @Override
    public Person editPerson(Person p) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person newP = new Person();
        newP.setId(p.getId());
        newP.setfName(p.getfName());
        newP.setlName(p.getlName());
        newP.setPhone(p.getPhone());

        em.merge(newP);
        em.getTransaction().commit();
        em.close();

        return p;
    }

}
    

