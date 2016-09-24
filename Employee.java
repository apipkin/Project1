/* File: Employee.java
 * Author: Anthony Pipkin
 * Date: 2016-09-23
 * Instructor: Stephen Grady
 * Class: CMIS 242
 * Project: Week 2 - Project 1
 * Purpose: Writing a program that computes the salaries for a collection of employees of different types
 */

/**
 * Creates an employee with a first and last name and a monthly salary.
 * 
 * @author Anthony Pipkin
 * @version 0.1.0
 */
public class Employee {

    private String fName;
    private String lName;
    private double salary;

    /**
     * Constructor sets the first name, last name, and monthly salary
     *
     * @param fName First name
     * @param lName Last name
     * @param salary Monthly salary
     */
    public Employee(String fName, String lName, double salary) {
        setFirstName(fName);
        setLastName(lName);
        setSalary(salary);
    }

    /**
     * First name setter
     * @param name First name
     */
    public void setFirstName(String name) {
        this.fName = name;
    }

    /**
     * First name getter
     * @return First name
     */
    public String getFirstName() {
        return this.fName;
    }

    /**
     * Last name setter
     * @param name Last name
     */
    public void setLastName(String name) {
        this.lName = name;
    }

    /**
     * Last name getter
     * @return Last name
     */
    public String getLastName() {
        return this.lName;
    }

    /**
     * Getter for the full name in the pattern of "<FirstName> <LastName>"
     * @return First name and last name
     */
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    /**
     * Setter for monthly salary
     * @param salary Monthly salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Getter for monthly salary
     * @return Monthly salary
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * Calculates the annual salary for the employee based on a 12 month year
     * @return Annual salary
     */
    public double annualSalary() {
        return getSalary() * 12;
    }

    /**
     * Overloads the toString method so it returns the name and monthly salary
     * @return Full description of Employee
     */
    public String toString() {
        return "Name: " + getFullName() + "\n\tMonthly Salary: " + String.format("%.2f", annualSalary());
    }
}