import edu.gatech.mediacomp.Turtle;
import edu.support.AnimatedTurtle;
import edu.support.EndWorld;

import javax.swing.JOptionPane;
import java.awt.*;

public class TurtleInterpreter {
    /**
     * Draw given the specified commands.
     * @param commands the String of turtle commands a combination of (F, f, +, -)
     * @param turtle the turtle to use to draw with
     * @param forwardPixels the pixels to move forward for an F or f.
     * @param degrees the number of degrees to turn for + or -
     */

    public static void interpret(String commands, Turtle turtle, int forwardPixels, int degrees) {


        for (int ind = 0; ind < commands.length(); ind++) {
            System.out.println(commands.charAt(ind));

            if (commands.charAt(ind) == 'F'){
                turtle.forward(forwardPixels);
            }

            if (commands.charAt(ind) == 'f') {
                turtle.penUp();
                turtle.forward(forwardPixels);
                turtle.penDown();
            }

            if (commands.charAt(ind) == '+') {
                turtle.turn(-degrees);
            }

            if (commands.charAt(ind) == '-') {
                turtle.turn(degrees);
            }

        }


    } // end interpret

    public static void main(String[] args) {


        EndWorld Turtle = new EndWorld();
        AnimatedTurtle t = new AnimatedTurtle(Turtle);

        {

            // Command Strings
            String input = JOptionPane.showInputDialog("Enter command strings:");

            // Forward Pixels
            String input2 = JOptionPane.showInputDialog("Enter forward pixels:");
            int forwardPixels = Integer.parseInt(input2);

            // Degree Turn
            String input3 = JOptionPane.showInputDialog("Enter degrees:");
            int degrees = Integer.parseInt(input3);

            interpret(input, t, forwardPixels, degrees);

        }

    } // end main
} // end class TurtleInterpreter