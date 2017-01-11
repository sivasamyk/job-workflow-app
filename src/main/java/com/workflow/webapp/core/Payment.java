package com.workflow.webapp.core;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by skaliappan on 1/9/17.
 */
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Bill forBill;

}
