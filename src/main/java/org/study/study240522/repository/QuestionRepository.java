package org.study.study240522.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.study240522.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
