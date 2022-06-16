package com.nhnacademy.taskapi.project.taskapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
@Entity
public class Project {

    @Id
    @Column(name = "project_no")
    private Integer projectNo;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_admin")
    private String projectAdmin;

    @Column(name = "project_status")
    private String projectStatus;

    @Column(name = "project_content")
    private String projectContent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_no")
    private Account account;


}
