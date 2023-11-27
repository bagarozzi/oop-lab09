package it.unibo.mvc;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


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
        try(ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(currentFile)))){
            os.writeObject(content);
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
    }
}
