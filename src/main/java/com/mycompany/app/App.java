package com.mycompany.app;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        String filename = scanner.nextLine();

        try {

            ClassLoader classLoader = App.class.getClassLoader();
            File file = new File(classLoader.getResource(filename).getFile());

            FileInputStream fisFile = new FileInputStream(file);
            String fileData = IOUtils.toString(fisFile, "UTF-8");
            String dataWithoutSpaces = StringUtils.remove(fileData, ' ');

            System.out.println(dataWithoutSpaces);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
