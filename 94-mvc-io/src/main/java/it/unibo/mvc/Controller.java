package it.unibo.mvc;

import java.io.File;
/**
 *
 */
public interface Controller {

    File getCurrentFile();

    String getCurrentFilePath();

    void print();

}
