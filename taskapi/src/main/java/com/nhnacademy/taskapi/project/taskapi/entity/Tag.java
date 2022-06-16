package com.nhnacademy.taskapi.project.taskapi.entity;


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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tag")
@Entity
public class Tag {

    @Id
    private String tagName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_no")
    private Task task;
}
