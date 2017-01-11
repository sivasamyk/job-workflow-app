package com.workflow.webapp.dao;

import com.workflow.webapp.core.Job;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

/**
 * Created by skaliappan on 1/9/17.
 */
public class JobDAO extends AbstractDAO<Job> {
    public JobDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Job> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public Job create(Job job) {
        return persist(job);
    }

    public List<Job> findAll() {
        return list(namedQuery("com.workflow.webapp.core.Job.findAll"));
    }
}
