package com.nhnacademy.taskapi.project.taskapi.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
@Entity

public class Account {

    @Id
    @Column(name = "account_no")
    @OneToMany(fetch = FetchType.EAGER)
    private final Integer accountNo;

    @Column(name ="account_id")
    private final String accountId;

    @Column(name = "account_email")
    private final String accountEmail;

}
