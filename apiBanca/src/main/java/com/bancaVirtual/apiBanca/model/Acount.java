package com.bancaVirtual.apiBanca.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "acounts", schema ="BANCA_DB")

public class Acount {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "Varchar(36)")
    private String id_acount;

    private String NameAcount;
    private String AcountNumber;
    private String Balance;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public String getId_acount() {
        return id_acount;
    }

    public void setId_acount(String id_acount) {
        this.id_acount = id_acount;
    }

    public String getNameAcount() {
        return NameAcount;
    }

    public void setNameAcount(String nameAcount) {
        NameAcount = nameAcount;
    }

    public String getAcountNumber() {
        return AcountNumber;
    }

    public void setAcountNumber(String acountNumber) {
        AcountNumber = acountNumber;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
