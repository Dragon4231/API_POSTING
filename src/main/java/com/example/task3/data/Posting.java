package com.example.task3.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "posting")
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String number;
    private int item;
    private Date date;
    private Date postingDate;
    private String materialDescription;
    private int quantity;
    private String bUn;
    private double amount;
    private String val;
    private String userName;

    private boolean authorityPosting;
}
