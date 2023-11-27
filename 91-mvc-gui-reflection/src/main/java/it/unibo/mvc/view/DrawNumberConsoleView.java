package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberConsoleView implements DrawNumberView {

    private DrawNumberController controller;

    /**
     * Sets the controller controlled by this view (if works as input).
     *
     * @param observer the controller to attach
     */
    public void setController(DrawNumberController observer){
        this.controller = observer;
    }

    /**
     * This method is called before the UI is used. It should finalize its status (if needed).
     */
    public void start(){
        System.out.println("Console view started");
    }

    /**
     * Tells the UI to display the result of the draw.
     *
     * @param res the result of the last draw
     */
    public void result(DrawResult res){ /* The console view must only write the output but not send commands to the controller  */
        System.err.println(res.getDescription());
    }
}
