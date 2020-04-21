package com.parabeyin.api.controller;
/* Created by Farhad on 2020-04-18 */

import com.parabeyin.api.entity.*;
import com.parabeyin.api.entity.dto.AnswerPostDto;
import com.parabeyin.api.entity.dto.RepliedQuestionStatisticsDto;
import com.parabeyin.api.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;

    @Autowired
    private RepliedAnswerService repliedAnswerService;

    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Game> getGame() {
        Game game = gameService.getActiveGame();
        if(game != null)  {
            game.setQuestions(questionService.getQuestionByGame(game.getId()));
            return ResponseEntity.ok(game);
        }

        return new ResponseEntity("Game Not Found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{game_id}/{question_id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestionAndAnswers(@PathVariable long game_id, @PathVariable long question_id) {
        Question question = questionService.getQuestionByIdAndGame(question_id, game_id);
        if(question != null) {
            question.setAnswers(answerService.getAnswersByQuestion(question_id));
            return ResponseEntity.ok(question);
        }

        return new ResponseEntity("Question Not Found", HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/{game_id}/{question_id}", method = RequestMethod.POST)
    public ResponseEntity<String> checkAnswer(@PathVariable long game_id, @PathVariable long question_id, @Valid @RequestBody AnswerPostDto answerPostDto) {

        User user = userService.getLoggedInUser();
        long user_id = user.getId();

        long answer_id = answerPostDto.getAnswer_id();

        // Check unique answer for user
        if(!repliedAnswerService.checkUniqueAnswerForUser(game_id,question_id, user_id)){
            RepliedAnswer repliedAnswer = new RepliedAnswer();
            repliedAnswer.setUser(user_id);
            repliedAnswer.setGame(game_id);
            repliedAnswer.setQuestion(question_id);
            repliedAnswer.setAnswer(answer_id);
            repliedAnswerService.save(repliedAnswer);
            return new ResponseEntity<>("Your answer saved. Wait for response", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("U already replied this question", HttpStatus.BAD_REQUEST);
        }


    }


    // Get answer result and statistics
    @RequestMapping(value = "/{game_id}/{question_id}/statistics", method = RequestMethod.GET)
    public ResponseEntity<RepliedQuestionStatisticsDto> getStatistics(@PathVariable long game_id, @PathVariable long question_id) {

        User user = userService.getLoggedInUser();
        long user_id = user.getId();

        Question question = questionService.getQuestionByIdAndGame(question_id,  game_id);
        RepliedQuestionStatisticsDto statistics = new RepliedQuestionStatisticsDto();
        if(question !=  null) {

            statistics.setQuestion_id(question_id);

            Answer correctAnswer = answerService.getCorrectAnswerByQuestion(question_id);
            statistics.setCorrectAnswerId(correctAnswer.getId());

            RepliedAnswer yourAnswer = repliedAnswerService.getAnswerByUserAndGameAndQuestion(user_id,  game_id,  question_id);

            if(yourAnswer != null) {
                if(yourAnswer.getAnswer() == statistics.getCorrectAnswerId()) {
                    statistics.setYourAnswerIsCorrect(true);
                }
            }

            statistics.setStatistics(repliedAnswerService.getStatistics(game_id, question_id));

            return ResponseEntity.ok(statistics);

        }


        return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
    }

}
