/* File: Employee.java
 * Author: Anthony Pipkin
 * Date: 2016-09-23
 * Instructor: Stephen Grady
 * Class: CMIS 242
 * Project: Week 2 - Project 1
 * Purpose: Writing a program that computes the salaries for a collection of employees of different types
 */

/**
 * Extends Employee and gives the employee the ability to get a bonus based on the value of the stock price.
 *
 * @author Anthony Pipkin
 * @version 0.1.0
 */
public class Executive extends Employee {

    private double stock;

    /**
     * Initializes the Executive with the given parameters
     *
     * @param fName First name
     * @param lName Last name
     * @param salary Monthly salary
     * @param stock Stock price
     */
    public Executive(String fName, String lName, double salary, double stock) {
        super(fName, lName, salary);
        setStockPrice(stock);
    }

    /**
     * Setter for the stock price
     *
     * @param stock Stock price
     */
    public void setStockPrice(double stock) {
        this.stock = stock;
    }

    /**
     * Getter for the stock price
     *
     * @return Stock price
     */
    public double getStockPrice() {
        return this.stock;
    }

    /**
     * Calculates the bonus based on the stock price
     *
     * @return Annual bonus
     */
    public double getBonus() {
        return this.stock > 50 ? 30000 : 0;
    }

    /**
     * Calculates annual salary with bonus included
     *
     * @return Annual salary
     */
    public double annualSalary() {
        return getSalary() + 12 + getBonus();
    }

    /**
     * Overloads the toString method so it returns the name, monthly salary, and stock price
     * @return Full description of Employee
     */
    public String toString() {
        return super.toString() + "\n\tStock Price: " + getStockPrice();
    }
}