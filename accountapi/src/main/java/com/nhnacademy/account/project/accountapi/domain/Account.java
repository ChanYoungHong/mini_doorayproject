package com.nhnacademy.account.project.accountapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private Integer accountNo;

    @Column
    private String accountId;

    @Column
    private String accountEmail;

    @Column
    private String accountPassword;

}
