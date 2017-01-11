package com.workflow.webapp.core;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by skaliappan on 1/9/17.
 */
@Entity
@Table(name = "job")

@NamedQueries(
        {
                @NamedQuery(
                        name="com.workflow.webapp.core.Job.findAll",
                        query = "SELECT j FROM Job j"
                )
        }
)
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "jobType", nullable = false)
    private JobType jobType;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @Column(name = "assignDate", nullable = false)
    private Date assignDate;

    @Column(name = "dueDate", nullable = false)
    private Date dueDate;

    @Column(name = "completionDate")
    private Date completionDate;

    @OneToOne(mappedBy = "job")
    @Cascade(value = CascadeType.SAVE_UPDATE)
    private Bill bill;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
