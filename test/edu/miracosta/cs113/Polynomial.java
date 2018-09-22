package edu.miracosta.cs113;

import java.util.LinkedList ;
import java.util.ListIterator ;
import java.util.Collections ;

/**
 * Polynomial.java - stores a LinkedList<Term> for polynomial objects
 * Author: Zsuzsanna Dianovics
 * Assignment: Homework 03
 * Description: this class uses the Term class to create a list of objects of Term
 *
 *     Instance Variables:
 *         list (LinkedList<Term>)
 *
 *     Methods:
 *         empty constructor
 *         full constructor
 *         copy constructor
 *         getters, setters
 *         equals()
 *         toString()
 *         addTerm(int coefficient, int exponent)
 *         deleteTerm(int coefficient, int exponent)
 *         sortList()
 *         simplifyPoly(Polynomial poly)
 */
public class Polynomial {

    private LinkedList<Term> list ;


    // constructors

    /**
     * Default constructor. Initializes the list.
     */
    public Polynomial() {
        this.list = new LinkedList<Term>()  ;
    }

    /**
     * Constructor which accepts the instance variable, list
     * @param list is a LinkedList of Terms
     */
    public Polynomial(LinkedList<Term> list) {
        this.list = list ;
    }

    /**
     * Copy constructor of the Polynomial object
     * @param original is a Polynomial object being passed in.
     */
    public Polynomial(Polynomial original) {
        if (original == null) {
            System.out.println("Fatal error") ;
            System.exit(0) ;
        }
        Term temp = new Term() ;
        this.list = new LinkedList<Term>() ;
        ListIterator mover = original.list.listIterator() ;

        while (mover.hasNext()) {
            temp = (Term) mover.next() ;
            list.add(temp) ;
        }


    }

    // Getters

    /**
     * Returns the list of the Polynomial object
     * @return a list of terms
     */
    public LinkedList getList()	{
        return list ;
    }

    // Setters
    /**
     * Sets the list of the Polynomial object
     * @param list LinkedList of Term objects
     */
    public void setList(LinkedList<Term> list)	{
        this.list = list ;
    }

    /**
     * Checks the equality of two Polynomial objects
     * @param anObject is being passed in
     * @return is true if the Objects are the same
     */
    public boolean equals(Object anObject) 	{
        if (!(anObject instanceof Polynomial)) {
            return false ;
        }
        Polynomial anotherPoly = (Polynomial) anObject ;
        return ( list.equals(anotherPoly.getList()) ) ;
    }

    /**
     * Returns a String of the Polynomial object, specifying each Term. creates iterator and prints out terms
     * @return String of the polynomial
     */
    public String toString() {
        ListIterator mover = list.listIterator() ;
        if (!(mover.hasNext())) {
            return "Empty list" ;
        }
        String temp = " " ;
        while (mover.hasNext()) {
            temp +=  mover.next() + " " ;
        }
        return temp ;
    }

    /**
     * Adds a term to the Polynomial object
     * @param coefficient the coefficient of the term being added
     * @param exponent the exponent of the term being added
     */
    public void addTerm(int coefficient, int exponent) {
        Term temp = new Term(coefficient, exponent) ;
        list.add(temp) ;

    }

    /**
     * Deletes the term that is asked to be deleted
     * @param coefficient the coefficient of the term being deleted
     * @param exponent the exponent of the term being deleted
     */
    public void deleteTerm(int coefficient, int exponent) {
        Term temp = new Term(coefficient, exponent) ;
        ListIterator mover = list.listIterator() ;
        while (mover.hasNext()) {
            Term temp2 = (Term) mover.next() ;
            if (temp2.equals(temp)) {
                mover.remove() ;
            }
        }
    }

    /**
     * Sorts the list of Terms
     */
    public void sortList() {

        Collections.sort(list) ;
    }


    /**
     * Simplifies two polynomials by combining coefficients if exponents are the same
     * @param poly Polynomial being added
     * @return a new polynomial that contains the combined simplified list
     */
    public Polynomial simplifyPoly(Polynomial poly) {
        int coefficientAdded = 0 ;
        Term prevTerm = null ;
        Term currentTerm = null ;
        Term temp = null ;
        Polynomial returnPoly = new Polynomial() ;

        // new poly to keep old from changing
        //System.out.println("ReturnPoly just created contains:" + returnPoly.toString()) ;
        //System.out.println("original poly contains:" + poly.toString()) ;

        // new poly containing both this list and parameter poly list

        ListIterator mover2 = this.list.listIterator() ;
        while (mover2.hasNext()) {
            temp = (Term) mover2.next() ;
            returnPoly.list.add(temp) ;
        }
        ListIterator mover3 = poly.list.listIterator() ;
        while (mover3.hasNext()) {
            temp = (Term) mover3.next() ;
            returnPoly.list.add(temp) ;
        }

        returnPoly.sortList() ; // sort new combined list
        //System.out.println("__________________________") ;
        //System.out.println("After sort, incoming poly:" + poly.toString()) ;
        //System.out.println("After sort, base poly:" + list.toString()) ;
        //System.out.println("After sort, return poly:" + returnPoly.toString()) ;

        // create listIterator
        ListIterator mover = returnPoly.list.listIterator() ;

        // step over first and store returned Term as temp
        if (mover.hasNext()) {
            prevTerm = (Term) mover.next() ;
        }
        while (mover.hasNext()) {
            currentTerm = (Term) mover.next() ;
            //System.out.println("In while to add, current is: " + currentTerm.toString() + " prevTerm is: " + prevTerm.toString()) ;
            if (prevTerm.compareTo(currentTerm) == 0) {
                coefficientAdded = prevTerm.getCoefficient() + currentTerm.getCoefficient() ;
                mover.previous() ;
                mover.previous() ; // goes back two spaces
                mover.remove() ;
                prevTerm = (Term) mover.next() ;
                prevTerm.setCoefficient(coefficientAdded) ;
            }
            prevTerm = currentTerm ;
        }
        return returnPoly ;
    }

    /**
     * Clears the list of any Terms
     */
    public void clearList() {
        list.clear() ;
    }




} // end class
