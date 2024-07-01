package org.study.study240522.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.study.study240522.domain.Question;
import org.study.study240522.exception.DataNotFoundException;
import org.study.study240522.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent())
        {
            return question.get();
        }else{
            throw new DataNotFoundException("question not found");
        }
    }
}
