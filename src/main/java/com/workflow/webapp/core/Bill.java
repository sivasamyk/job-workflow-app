package com.workflow.webapp.core;

import javax.persistence.*;
import java.util.List;

/**
 * Created by skaliappan on 1/9/17.
 */
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Job job;

    @OneToMany(mappedBy = "forBill")
    private List<Payment> payments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
