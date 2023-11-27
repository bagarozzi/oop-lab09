package it.unibo.mvc;

import java.io.File;
import java.util.List;
/**
 *
 */
public interface Controller {

    File getCurrentFile();

    String getCurrentFilePath();

    void print();

}
