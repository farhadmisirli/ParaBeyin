package com.parabeyin.api.service;
/* Created by Farhad on 2020-04-19 */

import com.parabeyin.api.entity.RepliedAnswer;
import com.parabeyin.api.entity.dto.AnswerResponseDto;
import com.parabeyin.api.entity.dto.AnswerStatisticsDto;
import com.parabeyin.api.repository.RepliedAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepliedAnswerService {

    @Autowired
    private RepliedAnswerRepository repliedAnswerRepository;

    public RepliedAnswer save(RepliedAnswer repliedAnswer) {
        return repliedAnswerRepository.save(repliedAnswer);
    }

    public boolean checkUniqueAnswerForUser(long game_id, long question_id, long user_id) {
        return repliedAnswerRepository.existsByGameAndQuestionAndUser(game_id, question_id, user_id);
    }

    public RepliedAnswer getAnswerByUserAndGameAndQuestion(long user_id, long game_id, long question_id) {
        return repliedAnswerRepository.findByUserAndGameAndQuestion(user_id, game_id, question_id);
    }

    public List<AnswerStatisticsDto> getStatistics(long game_id, long question_id) {
        return repliedAnswerRepository.getStatistics(game_id, question_id);
    }


}
