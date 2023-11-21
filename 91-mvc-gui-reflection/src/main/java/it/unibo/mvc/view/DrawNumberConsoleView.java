package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberConsoleView implements DrawNumberView {
            /**
     * Sets the controller controlled by this view (if works as input).
     *
     * @param observer the controller to attach
     */
    public void setController(DrawNumberController observer){

    }

    /**
     * This method is called before the UI is used. It should finalize its status (if needed).
     */
    public void start(){
        
    }

    /**
     * Tells the UI to display the result of the draw.
     *
     * @param res the result of the last draw
     */
    public void result(DrawResult res){

    }
}
