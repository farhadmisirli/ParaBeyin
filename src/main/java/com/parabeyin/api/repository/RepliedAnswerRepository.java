package com.parabeyin.api.repository;
/* Created by Farhad on 2020-04-19 */

import com.parabeyin.api.entity.RepliedAnswer;
import com.parabeyin.api.entity.dto.AnswerStatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepliedAnswerRepository extends JpaRepository<RepliedAnswer, Long> {

    boolean existsByGameAndQuestionAndUser(long game_id, long question_id, long user_id);
    RepliedAnswer findByUserAndGameAndQuestion(long user_id, long game_id, long question_id);

    @Query("SELECT new com.parabeyin.api.entity.dto.AnswerStatisticsDto(v.answer, COUNT(v)) FROM  RepliedAnswer v  where v.game = :game and v.question = :question  GROUP BY v.answer")
    List<AnswerStatisticsDto> getStatistics(@Param("game") long game, @Param("question") long question);

}
