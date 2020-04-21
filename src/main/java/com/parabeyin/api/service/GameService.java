package com.parabeyin.api.service;
/* Created by Farhad on 2020-04-18 */

import com.parabeyin.api.entity.Game;
import com.parabeyin.api.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game getActiveGame() {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date current_date = new Date();
        return gameRepository.getActiveGame((java.util.Date) current_date);
    }

}
