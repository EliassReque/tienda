/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
public class test {
    public static final String STRING_A = "new";
    public static final String STRING_B = "old";
    public static void main(String[] args) throws java.lang.Exception {
        //1
       
        String originalFilePath = "C://Users//Virtuo/Desktop/readFile/users.txt";
        String originalFileContent = "";
        //2
        BufferedReader reader = null;
        BufferedWriter writer = null;
        //3
        try {
            //4
            reader = new BufferedReader(new FileReader(originalFilePath));
            //5
            String currentReadingLine = reader.readLine();
            //6
            while (currentReadingLine != null) {
                originalFileContent += currentReadingLine + System.lineSeparator();
                currentReadingLine = reader.readLine();
            }
            //7
            String modifiedFileContent = originalFileContent.replaceAll(STRING_A, STRING_B);
            //8
            writer = new BufferedWriter(new FileWriter(originalFilePath));
            //9
            writer.write(modifiedFileContent);
             if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
        } catch (IOException e) {
            //handle exception
        } 
        /*finally {
            //10
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                //handle exception
            }
        }*/
    }
}