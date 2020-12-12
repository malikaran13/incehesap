package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IPageObject {
    List readDataFromCSV() throws IOException;
    String getUsername() throws IOException;
    String getPassword() throws IOException;
    void printToTxt(String value);
    ArrayList<String> readFromTxt() throws FileNotFoundException;
    void deleteFile(String filepath);

}
