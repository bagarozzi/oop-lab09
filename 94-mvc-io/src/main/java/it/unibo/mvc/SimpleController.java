package it.unibo.mvc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private File currentFile;
    private List<String> printHistory = new ArrayList<String>();

    public SimpleController(){
    }

    public File getCurrentFile(){
        return currentFile;
    }

    public String getCurrentFilePath(){
        return currentFile.getAbsolutePath();
    }

    public void print(){

    }
}
