package com.workflow.webapp.core;

import javax.persistence.*;
import java.security.Principal;
import java.util.List;

/**
 * Created by skaliappan on 1/9/17.
 */
public class User implements Principal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "name", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Job> jobs;

    @Column(name = "admin", nullable = false)
    private boolean admin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
