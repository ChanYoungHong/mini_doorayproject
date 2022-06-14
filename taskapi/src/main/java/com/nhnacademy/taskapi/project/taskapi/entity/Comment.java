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
    private final Integer commetnNo;

    @Column
    private final Integer accountNo;

    @Column
    private final Integer taskNo;

    @Column
    private final String commentCotent;
}
