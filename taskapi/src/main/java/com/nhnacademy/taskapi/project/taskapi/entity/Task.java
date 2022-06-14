package com.nhnacademy.taskapi.project.taskapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
@Entity
public class Task {

    @Id
    private final Integer taskNo;

    @JoinColumn(name = "project_no")
    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    @Column
    private final String taksContent;

    @Column
    private final String taskStatus;

    @Column
    private final String mileStone;

    @JoinColumn(name = "account_no")
    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;


}
