package com.parabeyin.api.repository;

import com.parabeyin.api.entity.Answer;
import com.parabeyin.api.entity.dto.AnswerResponseDto;
import com.parabeyin.api.entity.dto.AnswerStatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {


    @Query(value = "SELECT  new com.parabeyin.api.entity.dto.AnswerResponseDto(id, content) FROM Answer where question = :question  order by sort asc")
    List<AnswerResponseDto> getAnswersByQuestionOrderBySortAscQuery(@Param("question") long question);

    @Query(value = "SELECT  new com.parabeyin.api.entity.dto.AnswerStatisticsDto(answer, COUNT (id) ) FROM RepliedAnswer where game = :game and question = :question group by question order by id desc ")
    List<AnswerStatisticsDto> getStatistics(@Param("game") long game, @Param("question") long question);

    Answer getAnswerById(long id);
    Answer getAnswerByQuestionAndCorrect(long question_id, boolean correct);


}
