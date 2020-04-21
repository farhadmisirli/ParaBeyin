package com.parabeyin.api.service;
/* Created by Farhad on 2020-04-17 */

import com.parabeyin.api.entity.Question;
import com.parabeyin.api.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestionByGame(long id) {
        return questionRepository.findQuestionByGame(id);
    }

    public Question getQuestionByIdAndGame(long id, long game_id) {
        return questionRepository.findByIdAndGameAndActive(id, game_id, true);
    }
}
