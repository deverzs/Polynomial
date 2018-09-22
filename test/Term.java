/*Term.java - stores variables for a term of a polynomial
@author Zsuzsanna Dianovics
Assignment: Homework 03
Description: this class stores coefficient and exponent variables and creates an object of Term.
 This class implements Comparable interface

    Instance Variables:
        coefficient (int)
        exponent (int)

    Methods:
        empty constructor
        full constructor
        copy constructor
        getters, setters, setAll
        equals()
        toString()
        compareTo(Term term)

*/

public class Term implements Comparable<Term> {

    private int coefficient ;
    private int exponent ;

    /**
     * The constructors for the class Term
     */
    // Constructor
    public Term() {
        this(1, 0) ;
    }

    /**
     * Ccnstructor with all instance variables as parameters
     * @param coefficient coefficient of the polynomial
     * @param exponent exponent of the polynomial
     */
    public Term(int coefficient, int exponent)	{
        setAll(coefficient, exponent) ;
    }

    /**
     * Copy Constructor
     * @param original Term object being copied
     */
    public Term(Term original) {
        if (original == null) {
            System.out.println("Fatal error") ;
            System.exit(0) ;
        }
        exponent = original.exponent ;
        coefficient = original.coefficient ;
    }

    // Getters

    /**
     * Returns the coefficient of the Term object
     * @return coefficient
     */
    public int getCoefficient()	{
        return coefficient ;
    }

    /**
     * Reutrns the exponent of the Term object
     * @return exponent
     */
    public int getExponent() {
        return exponent ;
    }

    // Setters

    /**
     * Sets the coefficient of the Term object
     * @param coefficient
     */
    public void setCoefficient(int coefficient)	{
        this.coefficient = coefficient ;
    }

    /**
     * Sets the exponent of the Term object
     * @param exponent
     */
    public void setExpoent(int exponent) {
        this.exponent = exponent ;
    }

    /**
     * Sets all the instance variables of the Term class
     * @param coefficient
     * @param exponent
     */
    public void setAll(int coefficient, int exponent) {
        this.coefficient = coefficient ;
        this.exponent = exponent ;
    }

    // toString

    /**
     * Returns a string of the Term object
     * @return String of coefficient and exponent
     */
    public String toString() {
        return coefficient + "x^" + exponent ;
    }

    // equals

    /**
     * Compares the equality of two Term objects
     * @param anObject any objects to equate
     * @return true or false
     */
    public boolean equals(Object anObject) 	{
        if (!(anObject instanceof Term)) {
            return false ;
        }
        Term anotherTerm = (Term) anObject ;
        return ( (coefficient == (anotherTerm.getCoefficient()) )&&
                (exponent == anotherTerm.getExponent()) ) ;
    }

    // compareTo

    /**
     * Uses comparable interface to return an integer whether the Object is before, after or equal to the comparing object
     * @param other Term being compared
     * @return an integer -1,0 or 1
     */
    public int compareTo(Term other) 	{

        int result = 0 ;
        if (this.exponent > other.getExponent()) {
            result = 1 ;
        }
        else if (this.exponent < other.getExponent() ) {
            result = -1 ;
        }
        else  {
            result =  0 ; }

        return result ;
    } // end compareTo


} // end class
