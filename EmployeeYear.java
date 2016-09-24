/* File: Employee.java
 * Author: Anthony Pipkin
 * Date: 2016-09-23
 * Instructor: Stephen Grady
 * Class: CMIS 242
 * Project: Week 2 - Project 1
 * Purpose: Writing a program that computes the salaries for a collection of employees of different types
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Contains a list of employees of various types for a given year
 *
 * @author Anthony Pipkin
 * @version 0.1.0
 */
public class EmployeeYear {

    private String year;
    private List<Employee> employees = new ArrayList<Employee>();

    /**
     * Sets the year
     *
     * @param year Year
     */
    public  EmployeeYear(String year) {
        this.year = year;
    }

    /**
     * Adds the given employee to the internal list
     *
     * @param emp Employee
     */
    public void push(Employee emp) {
        employees.add(emp);
    }

    /**
     * Returns a count of the employees stored
     *
     * @return Number of employees
     */
    public int getCount() {
        return employees.size();
    }

    /**
     * Iterates and prints all employees
     */
    public void printEmployees(){ 
        for (Employee emp : employees) {
            System.out.println("\n" + emp);
        }
        System.out.println();
    }

    /**
     * Iterates over all employees and returns the total salary for the year
     *
     * @return Total salary
     */
    public double getTotalSalary() {
        double total = 0.0;

        for (Employee emp : employees) {
            total += emp.getSalary();
        }

        return total;
    }

    /**
     * Returns the average salary for the year based on employees added
     *
     * @return Average salary
     */
    public double getAverageSalary() {
        return getTotalSalary() / getCount();
    }
}