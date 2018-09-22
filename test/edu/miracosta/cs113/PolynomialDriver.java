package edu.miracosta.cs113;
import java.util.Scanner ;

/**
 *  edu.miracosta.cs113.PolynomialDriver.java  - program that simplifies polynomials entered by user.
 *
 * @author Zsuzsanna Dianovics
 * Assignment: Homework 03
 *
 * Static Methods:
 *     Main Menu (polyFirst, polySecond)
 *         1. First Poly -  to edit the first polynomial
 *             directs to termMenu(polyFirst)
 *         2. Second Poly - to edit the second polynomial
 *             directs to termMenu(polySecond)
 *         3. Display both poly's - display of each
 *             displays both polynomials
 *         4. Add the poly's - simplifies polynomials
 *             simplifyPoly() and display()
 *         5. Exit program
 *
 *     Term Menu (Polynomial) - menu in loop until user exits to the mainMenu()
 *         1. Brand new
 *             call clearList() and display()
 *         2. Clear old
 *             call clearList() and display()
 *         3. Add a term
 *             prompt user for coefficient and exponent
 *             addTerm() and display()
 *         4. Delete a term
 *             prompt user for coefficient and exponent
 *             deleteTerm() and display()
 *         5. Exit to main menu
 *
 *     Display (poly) - prints out polynomial list
 *
 * Algorithm:
 *
 *     1. Create classes Polynomial and Term
 *     2. Create mainMenu(), termMenu() and display() methods
 *     3. Instantiate canned polynomials for testing
 *     4. Place menus in while loop. Exit loop when user exits program.
 */
public class PolynomialDriver {

    public static void main (String args[]) {

        Polynomial polyFirst = new Polynomial() ;
        Polynomial polySecond = new Polynomial() ;
        polyFirst.addTerm(3, 2) ;
        polyFirst.addTerm(7,12) ;
        //polyFirst.addTerm(2,6) ;
        polyFirst.addTerm(5, 2) ;
        //polyFirst.addTerm(13, 2) ;

        polySecond.addTerm(6, 2) ;
        polySecond.addTerm(8,12) ;
        //polySecond.addTerm(10, 4) ;

        while (true) {
            mainMenu(polyFirst, polySecond) ;
        }

    } // end main

    /**
     *
     * @param polyFirst
     * @param polySecond
     */
    public static void mainMenu(Polynomial polyFirst, Polynomial polySecond) {
        Scanner keyboardMenu = new Scanner(System.in) ;
        Polynomial addedPolys = new Polynomial() ;
        char decision ;

        System.out.println("*********************************") ;
        System.out.println("         Main Menu               ") ;
        System.out.println("    [F]irst Polynomial") ;
        System.out.println("    [S]econd Polynomial") ;
        System.out.println("    [D]isplay both Polynomials") ;
        System.out.println("    [A]dd the Polynomials") ;
        System.out.println("    [E]xit. Bye!") ;
        System.out.println("*********************************") ;
        decision = keyboardMenu.next().charAt(0) ;
        switch (decision) {
            // To modify first polynomial
            case 'F' :
            case 'f' :
                termMenu(polyFirst) ;
                break ;

            // To modify second polynomial
            case 'S' :
            case 's' :
                termMenu(polySecond) ;
                break ;

            // Add the poly's
            case 'A' :
            case 'a' :
                addedPolys =  polySecond.simplifyPoly(polyFirst) ;
                System.out.println("Adding the polynomials: ") ;
                display(addedPolys) ;
                break ;

            //Display both polynomials
            case 'D' :
            case 'd' :
                System.out.print("First Polynomial: " ) ;
                display(polyFirst) ;
                System.out.print("Second Polynomial: " ) ;
                display(polySecond) ;
                System.out.println() ;
                break ;
            // To quit the loop and thus the program
            case 'E' :
            case 'e' :
                System.out.println("\nGoodbye") ;
                System.exit(0) ;
                break ;

            // Invalid input
            default :
                System.out.println("That is not a valid input.") ;
        } // end switch

    } // end mainMenu()


    /**
     *
     * @param poly polynomial of choice
     */
    public static void termMenu(Polynomial poly) {
        Scanner keyboardMenu = new Scanner(System.in) ;
        Scanner keyboardInts = new Scanner(System.in) ;
        char decision ;
        int coeff = 0 ;
        int exp = 0 ;
        boolean done = false ;

        while (!done) {
            System.out.println("*********************************") ;
            System.out.println("         Term Menu               ") ;
            System.out.println("    [B]rand new Polynomial"       ) ;
            System.out.println("    [C]lear old Polynomial"       ) ;
            System.out.println("    [A]dd new Term"               ) ;
            System.out.println("    [D]elete a Term"              );
            System.out.println("    [E]xit to Main Menu!"                 ) ;
            System.out.println("*********************************") ;

            decision = keyboardMenu.next().charAt(0) ;

            switch (decision) {
                // Brand New Polynomial or clear the incoming one
                case 'B' :
                case 'b' :
                case 'C' :
                case 'c' :
                    poly.clearList() ;
                    display(poly) ;
                    break ;

                // 	Add a new Term
                case 'A' :
                case 'a' :
                    System.out.print("\nEnter the coefficient: ") ;
                    coeff = keyboardInts.nextInt() ;
                    System.out.print("Enter the exponent: \n") ;
                    exp = keyboardInts.nextInt() ;
                    poly.addTerm(coeff, exp) ;
                    display(poly) ;
                    break ;

                // Delete a Term
                case 'D' :
                case 'd' :
                    System.out.print("\nEnter the coefficient: ") ;
                    coeff = keyboardInts.nextInt() ;
                    System.out.print("Enter the exponent: \n") ;
                    exp = keyboardInts.nextInt() ;
                    poly.deleteTerm(coeff, exp) ;
                    display(poly) ;
                    break ;

                // To quit the termMenu
                case 'E' :
                case 'e' :
                    done = true ;
                    break ;

                // Invalid input
                default :
                    System.out.println("That is not a valid input.") ;
            }

        }
    } // end termMenu

    /**
     *
     * @param poly
     */
    public static void display(Polynomial poly) {
        System.out.println(poly.toString()) ;

    }
} // end driver class
