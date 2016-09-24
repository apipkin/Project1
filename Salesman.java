/* File: Employee.java
 * Author: Anthony Pipkin
 * Date: 2016-09-23
 * Instructor: Stephen Grady
 * Class: CMIS 242
 * Project: Week 2 - Project 1
 * Purpose: Writing a program that computes the salaries for a collection of employees of different types
 */

/**
 * Extends Employee and gives the employee the ability to get a commission based on the annual sales
 *
 * @author Anthony Pipkin
 * @version 0.1.0
 */
public class Salesman extends Employee {
    private double sales;

    /**
     * Initializes the Salesman with the given parameters
     *
     * @param fName First name
     * @param lName Last name
     * @param salary Monthly salary
     * @param sales Annual sales
     */
    public Salesman(String fName, String lName, double salary, double sales) {
        super(fName, lName, salary);
        setAnnualSales(sales);
    }

    /**
     * Setter for annual sales
     * @param sales Annual sales
     */
    public void setAnnualSales(double sales) {
        this.sales = sales;
    }

    /**
     * Getter for annual sales
     * @return Annual sales
     */
    public double getAnnualSales() {
        return this.sales;
    }

    /**
     * Calculates a commission based on the annual sales
     * @return Total commission
     */
    public double getCommission() {
        double commission= sales * .2;
        return Math.max(20000, commission);
    }

    /**
     * Calculates the annual salary with added commission
     * @return Annual salary
     */
    public double annualSalary() {
        return getSalary() + 12 + getCommission();
    }

    /**
     * Overloads the toString method so it returns the name, monthly salary, and annual sales
     * @return Full description of Employee
     */
    public String toString() {
        return super.toString() + "\n\tAnnual Sales: " + String.format("%.2f", getAnnualSales());
    }
}