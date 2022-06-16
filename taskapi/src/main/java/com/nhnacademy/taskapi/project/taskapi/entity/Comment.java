package com.nhnacademy.taskapi.project.taskapi.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
@Entity

public class Comment {

    @Id
    @Column(name = "comment_no")
    private Integer commetnNo;

    @Column
    private Integer accountNo;

    @Column
    private Integer taskNo;

    @Column
    private String commentCotent;
}
