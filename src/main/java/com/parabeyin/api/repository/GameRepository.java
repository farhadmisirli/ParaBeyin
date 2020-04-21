package com.parabeyin.api.repository;
/* Created by Farhad on 2020-04-18 */

import com.parabeyin.api.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    //public Game findByActiveAndStart_dateGreaterThanEqualAndOrderByStart_dateASC(boolean active, LocalDate current_date);

    @Query(value = "SELECT * FROM pb_games g WHERE g.active = true AND start_date >= ?1 ORDER BY start_date ASC  LIMIT 1", nativeQuery = true)
    public Game getActiveGame(Date current_date);
}
