package org.study.study240522;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.study.study240522.domain.Question;
import org.study.study240522.repository.QuestionRepository;

import java.time.LocalDateTime;

@SpringBootTest
public class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testJpa() {
        Question q1 = Question.builder()
                .subject("sbb가 무엇인가요?")
                .content("sbb에 대해서 알고 싶습니다.")
                .createDate(LocalDateTime.now())
                .build();

        this.questionRepository.save(q1);

        Question q2 = Question.builder()
                .subject("스트링 부트 모델 질문입니다.")
                .content("id는 자동으로 생성됌?")
                .createDate(LocalDateTime.now())
                .build();

        this.questionRepository.save(q2);
    }

    @Test
    @DisplayName("새로 만든 메서드 and를 통해 find되는가?")
    void testJpa2() {
        Question a = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        Assertions.assertEquals(1, a.getId());
    }

}
