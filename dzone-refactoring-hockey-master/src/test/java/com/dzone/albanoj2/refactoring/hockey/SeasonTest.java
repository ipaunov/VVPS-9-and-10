package com.dzone.albanoj2.refactoring.hockey;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeasonTest {

    private static final double TOLERANCE = 0.000001;
    private Season season;

    @Before
    public void setUp() {
        season = new Season();
    }
    @Test
    public void canAddGamesWithSameParameters() {
        season.addGame(new Game(3,9,93));
        assertEquals(1,season.getGames().size(),TOLERANCE);
        season.addGame(new Game(2,5,91));
        assertEquals(2,season.getGames().size(),TOLERANCE);
        season.addGame(new Game(3,9,93));
        assertEquals(3,season.getGames().size(),TOLERANCE);
    }
    @Test
    public void newSeasonHasNoGames(){
        assertEquals(0,season.getGames().size(),TOLERANCE);
    }

    @Test
    public void addAndRemoveGame(){
        Game game1 = new Game(3,9,93);
        season.addGame(game1);
        assertEquals(1,season.getGames().size(),TOLERANCE);
        season.removeGame(game1);
        assertEquals(0,season.getGames().size(),TOLERANCE);
    }


    @Test
    public void RemovingGamesFromEmptySeasonNoError() {
        season.removeGame(new Game(3,9,93));
        assertEquals(0,season.getGames().size(),TOLERANCE);
    }
}