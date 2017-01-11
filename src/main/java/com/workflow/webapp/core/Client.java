package com.workflow.webapp.core;

import javax.persistence.*;
import java.util.List;

/**
 * Created by skaliappan on 1/9/17.
 */
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column (name = "name", nullable = false, unique = true)
    private String name;

    @Column (name = "address", nullable = false)
    private String address;

    @Column (name = "contactPerson", nullable = false)
    private String contactPerson;

    @Column (name = "telephoneNumber", nullable = false, unique = true)
    private String telephoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Job> jobs;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
