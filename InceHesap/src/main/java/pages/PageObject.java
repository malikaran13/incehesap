package pages;

import au.com.bytecode.opencsv.CSVReader;
import constants.FileConstants;
import interfaces.IPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PageObject implements IPageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public String username;
    public String password;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public List readDataFromCSV() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(FileConstants.CSVFilePath));
        List userInfo = new ArrayList();
        String[] cell;

        while ((cell = reader.readNext()) != null) {
            for (int i = 0; i < cell.length; i++)
                userInfo.add(cell[i]);
        }
        return userInfo;
    }

    public String getUsername() throws IOException {
        return this.username = (String) readDataFromCSV().get(0);
    }

    public String getPassword() throws IOException {
        return this.password = (String) readDataFromCSV().get(1);
    }

    public void printToTxt(String value) {

        File file = new File(FileConstants.TXTFilePath);

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(value);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
    }

    public ArrayList<String> readFromTxt() throws FileNotFoundException {
        // pass the path to the file as a parameter
        ArrayList<String> txtList = new ArrayList<String>();
        File file = new File(FileConstants.TXTFilePath);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            txtList.add(sc.nextLine());
        sc.close();
        return txtList;
    }

    public void deleteFile(String filepath) {
        File file = new File(filepath);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }


}
