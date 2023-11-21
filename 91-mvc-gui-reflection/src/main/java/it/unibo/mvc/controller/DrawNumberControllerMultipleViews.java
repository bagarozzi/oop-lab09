package it.unibo.mvc.controller;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawNumber;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class DrawNumberControllerMultipleViews implements DrawNumberController {

    private Collection<DrawNumberView> views; /* Views collection, so the controller knows how many view it has to control */
    private final DrawNumber model;

    public DrawNumberControllerMultipleViews(final DrawNumber model){
        this.model = model;
        views = new LinkedList<DrawNumberView>();
    }

    /**
     * Makes a guess.
     * 
     * @param n the attempt
     */
    public void newAttempt(int n){
        for(DrawNumberView view : views){
            Objects.requireNonNull(view, "There is no view attached!").result(model.attempt(n));
        }
    }

    /**
     * Resets the current game (if any is running) and starts a new one.
     */
    public void resetGame(){
        this.model.reset();
    }

    /**
     * Gracefully quits from the application.
     */
    public void quit(){
        System.exit(0);
    }

    /**
     * Adds a new view.
     *
     * @param newView the view to be added
     */
    public void addView(DrawNumberView newView){
        Objects.requireNonNull(newView, "Cannot add a null view");
        views.add(newView);
        newView.setController(this);
        newView.start();
    }
}
