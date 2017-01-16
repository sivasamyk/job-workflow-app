package com.workflow.webapp.dao;

import com.workflow.webapp.core.Client;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.Optional;

/**
 * Created  by skaliappan on 1/16/17.
 */
public class ClientDAO extends AbstractDAO<Client> {
    public ClientDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Client> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public Client create(Client client) {
        return persist(client);
    }

   /* public List<Job> findAll() {
        return list(namedQuery("com.workflow.webapp.core.Job.findAll"));
    }*/
}
