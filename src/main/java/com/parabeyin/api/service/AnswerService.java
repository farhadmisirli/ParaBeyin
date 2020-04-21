package com.parabeyin.api.service;
/* Created by Farhad on 2020-04-18 */

import com.parabeyin.api.entity.Answer;
import com.parabeyin.api.entity.dto.AnswerResponseDto;
import com.parabeyin.api.entity.dto.AnswerStatisticsDto;
import com.parabeyin.api.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public List<AnswerResponseDto> getAnswersByQuestion(long question_id) {
        return answerRepository.getAnswersByQuestionOrderBySortAscQuery(question_id);
    }

    public Answer getAnswerById(long id) {
        return answerRepository.getAnswerById(id);
    }
    public Answer getCorrectAnswerByQuestion(long question_id) {
        return answerRepository.getAnswerByQuestionAndCorrect(question_id, true);
    }

    public List<AnswerStatisticsDto> getStatistics(long game_id, long question_id) {return answerRepository.getStatistics(game_id, question_id);}

}
