package com.parabeyin.api.repository;
/* Created by Farhad on 2020-04-17 */

import com.parabeyin.api.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,  Long> {
    public List<Question> findQuestionByGame(long id);

    public Question findByIdAndGameAndActive(long id, long game_id, boolean active);

}
