package org.study.study240522.domain;

import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;

@Entity
@Getter
//답변 클래스
public class Anser {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

@Column(columnDefinition = "Text")
private String content;

private LocalDateTime createDate;

@ManyToOne
private Question question;

}
