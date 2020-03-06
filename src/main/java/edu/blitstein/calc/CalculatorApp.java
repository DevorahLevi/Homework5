package edu.blitstein.calc;

import edu.blitstein.calc.engine.op.engine.Calculator;
import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {

    //Numbers this close to zero are treated as if equal to zero.
    public static void main(String[] args)
            throws DivideByZeroException, UnknownOpException {
        System.out.println("Calculator is on.");
        System.out.print("Format of each line: ");
        System.out.println("operator space number");
        System.out.println("For example: + 3");
        System.out.println("To end, enter the letter e.");
        Scanner keyboard = new Scanner(System.in);
        Calculator clerk = new Calculator();
        System.out.println("Starting with = " + clerk.getResult());

        String fileName = "src/main/resources/" + args[0];
        PrintWriter printWriter = null;

        boolean done = false;
        try {
            printWriter = new PrintWriter(fileName);
            printWriter.println("Calculator is on and set to 0.0");
            while (!done) {
                String opType = (keyboard.next()); //****
                if (opType.substring(0,1).equalsIgnoreCase("E"))
                    done = true;
                else {
                    try {
                        double nextNumber = keyboard.nextDouble();
                        double result = clerk.evaluate(opType, nextNumber);
                        printWriter.println("result " + opType + " " + nextNumber + " = " + result);
                        printWriter.println("updated result = " + result);
                        } catch (DivideByZeroException e) {
                            //e.printStackTrace(); **used for finding where the error is
                            System.out.println(e.getMessage());
                        } catch (UnknownOpException e) {
                            //e.printStackTrace();
                            System.out.println(e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage());
                        }
                }
            }
            //System.out.println("The final result is " + clerk.getResult()); //***How does this line get the updated result from clerk? We x update it anywhere
            printWriter.println("Calculator program ending.");
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName + ": " + e.getMessage());
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}