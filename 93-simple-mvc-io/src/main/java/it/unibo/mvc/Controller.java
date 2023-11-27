package it.unibo.mvc;

import java.io.File;
import java.io.IOException;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile = new File(System.getProperty("user.home") + System.getProperty("file.separataor") + "output.txt");

    public Controller(){

    }

    public void setCurrentFile(File f){
        currentFile = f;
    }

    public String getCurrentFile(){
        return currentFile.getAbsolutePath();
    }

    public String getCurrentFilePath(){
        return currentFile.getAbsolutePath();
    }

    public void saveContentToFile(String content) throws IOException {
        if(currentFile == null || content == null){
            throw new IOException("No file has been set or the content passed is null");
        }
        
    }
}
