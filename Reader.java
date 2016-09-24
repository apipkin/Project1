/* File: Employee.java
 * Author: Anthony Pipkin
 * Date: 2016-09-23
 * Instructor: Stephen Grady
 * Class: CMIS 242
 * Project: Week 2 - Project 1
 * Purpose: Writing a program that computes the salaries for a collection of employees of different types
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reads in a given file, processes the data, and generates a report printed to the System.out
 *
 * @author Anthony Pipkin
 * @version 0.1.0
 */
public class Reader {

    private static String fileName = "";

    private static HashMap<String, EmployeeYear> empsByYear = new HashMap<String, EmployeeYear>();

    /**
     * Entry point for the application. Takes in a file name or uses "data.txt" if one is not provided
     *
     * @param args File name where the data can be found.
     * @throws IOException File not available to read
     */
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            fileName = args[0];
        } else {
            fileName = "data.txt";
        }

        System.out.println("Reading... " + fileName);

        readData();

        printSummary();
    }

    /**
     * Reads the file and calls `processLine` for each line of the data. Throws exception if file is not found.
     *
     * @throws IOException File not available to read
     */
    public static void readData() throws IOException {
        File file;
        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            file = new File(fileName);
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);

            String line;

            while ( (line = buffer.readLine()) != null) {
                line = line.trim();

                if (line.length() > 0) { // prevent empty lines
                    processLine(line);
                }
            }
        }
        catch (IOException ex) {
            // print an exception if one is found
            System.out.println(ex.getMessage());
        }
        finally {
            if (buffer != null) {
                buffer.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }

    /**
     * Takes in a line of data from the file and parses the year, type, name, monthly salary, and an extra field
     *   depending on the type of employee. Stores objects based on the data in the `empsByYear` list.
     *
     * @param line Line from the data file
     */
    public static void processLine(String line) { 

        String[] tokens = line.split("[ ,]+");

        String year = tokens[0];
        String type = tokens[1].toLowerCase();
        String lname = tokens[2];
        String fname = tokens[3];
        double sal = Double.parseDouble(tokens[4]);
        double extra = 0.0;
        Employee emp;

        if (tokens.length == 6) {
            extra = Double.parseDouble(tokens[5]);
        }

        switch (type) {
            case "salesman":
                emp = new Salesman(fname, lname, sal, extra);
                break;
            case "executive":
                emp = new Executive(fname, lname, sal, extra);
                break;
            default:
                emp = new Employee(fname, lname, sal);
        }

        if (empsByYear.get(year) == null) {
            empsByYear.put(year, new EmployeeYear(year));
        }

        empsByYear.get(year).push(emp);
    }

    /**
     * Prints a report for each year in System.out
     */
    public static void printSummary () {

        List<String> sortedYears = new ArrayList<String>(empsByYear.keySet());
        Collections.sort(sortedYears);

        for (String year : sortedYears) {
            System.out.println("\n---------------\n");
            System.out.println(":: YEAR :: " + year + " :: ");
            empsByYear.get(year).printEmployees();
            System.out.println("Average annual salary: $" + String.format("%.2f", empsByYear.get(year).getAverageSalary()));
        }

        System.out.println("\n---------------\n");
    }
}