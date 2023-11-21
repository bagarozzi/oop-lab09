package it.unibo.mvc.controller;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;

import java.util.Collection;

public class DrawNumberControllerMultipleViews implements DrawNumberController {

    Collection<DrawNumberView> views; /* Views collection, so the controller knows how many view it has to control */

    /**
     * Makes a guess.
     * 
     * @param n the attempt
     */
    public void newAttempt(int n){

    }

    /**
     * Resets the current game (if any is running) and starts a new one.
     */
    public void resetGame(){

    }

    /**
     * Gracefully quits from the application.
     */
    public void quit(){

    }

    /**
     * Adds a new view.
     *
     * @param newView the view to be added
     */
    public void addView(DrawNumberView newView){

    }
}
