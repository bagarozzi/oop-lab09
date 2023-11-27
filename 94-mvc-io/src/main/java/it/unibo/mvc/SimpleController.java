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
    private String nextString;
    private String currentString;

    public SimpleController(){
    }

    public File getCurrentFile(){
        return currentFile;
    }

    public String getCurrentFilePath(){
        return currentFile.getAbsolutePath();
    }

    public void setNextString(String nextString) throws Exception {
        if(nextString == null){
            throw new NullPointerException();
        }
    }

    public String getNextString(){
        return nextString;
    }

    public List<String> getPrintHistory(){
        return printHistory;
    }

    public void print(){
        System.out.println(currentString);
        printHistory.add(currentString);
        currentString = nextString;
    }
}
