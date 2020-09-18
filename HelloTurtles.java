import edu.gatech.mediacomp.Turtle;
import edu.support.AnimatedTurtle;
import edu.support.EndWorld;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class HelloTurtles {

    /**
     * Use the given turtle to draw your name.
     * @param t the turtle to use for drawing.
     */
    public static void drawName(Turtle t) {

        t.setPenColor(Color.red);
        t.forward(100);
        t.backward();
        t.forward(50);
        t.turnRight();
        t.forward(50);
        t.turnLeft();
        t.forward(50);
        t.backward();
        t.forward(100);


        t.setPenColor(Color.green);
       t.penUp();
       t.turnRight();
       t.forward(70);
       t.turn(115);
       t.penDown();
       t.forward(100);
       t.penUp();
       t.backward(100);
       t.turn(300);
       t.penDown();
       t.forward(100);
       t.penUp();
       t.backward(50);
       t.turnRight();
       t.turn(25);
       t.penDown();
       t.forward(53);


        t.penUp();
        t.setPenColor(Color.blue);
        t.backward(120);
        t.turnRight();
        t.turn(10);
        t.penDown();
        t.forward(25);
        t.turnLeft();
        t.forward(15);
        t.backward(30);
        t.penUp();
        t.forward(15);
        t.turnLeft();
        t.penDown();
        t.forward(80);
        t.turnLeft();
        t.forward(15);
        t.backward(30);


    } // end drawName

    /**
     * Draws a regular polygon of the specified number of sides and length of side.
     *
     * @param t the turtle to use to draw.
     * @param numSides the number of sides of each polygon.
     * @param sideLen the length of each side of each polygon.
     */
    public static void drawPolygon(Turtle t, int numSides, int sideLen) {

        for (int i = 0; i < numSides; i++) {
            t.forward(sideLen);
            t.turn(360/numSides);
        }



    } // end drawPolygon

    /**
     * Draws the specified number of regular polygons,
     * each starting at the same place, however,
     * after each polygon is drawn the turtle turns 360 / numPolys degrees
     *
     * @param t the turtle to use to draw.
     * @param numPolys the number of polygons to draw.
     * @param numSides the number of sides of each polygon.
     * @param sideLen the length of each side of each polygon.
     */
    public static void manyPolygons(Turtle t, int numPolys, int numSides, int sideLen) {

        for (int i  = 0; i < numPolys; i++) {
            drawPolygon(t, numSides, sideLen);
            t.turn(360.0/numPolys);

        }


    } // end manyPolygons

    /**
     * Draws the specified number of lines, rotating 360.0 / n between
     * each line.  The color of each line is determined by the angle
     * the turtle is facing when drawing that line.
     * A line drawn at angle ang has the HSB/HSV color of (ang / 360, 1, 1).
     * You may want to refer to
     * https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html#getHSBColor-float-float-float-
     *
     * @param t the turtle to use to draw.
     * @param numLines the number of line segments.
     * @param lineLength the length of each line segment.
     */
    public static void radial(Turtle t, int numLines, int lineLength) {
        // TODO: your implementation here

        for (int i = 0; i < numLines; i++) {

            t.setPenColor(Color.getHSBColor((float) t.getHeading() / 360f, 1, 1));
            t.forward(lineLength);
            t.backward(lineLength);
            t.turn(360.0/numLines);

        }


    } // end radial

    /**
     * Your code for creating the EndWorld, AnimatedTurtle,
     * and dealing with input goes in this method.
     */
    public static void solution() {
        String choice = menu();

        EndWorld world = new EndWorld();
        AnimatedTurtle t = new AnimatedTurtle(world);

        if (choice.equals("Name")) {

            drawName(t);

        }

        if (choice.equals("Polygon")) {


            String input = JOptionPane.showInputDialog("Enter number of Sides: ");
            int input2 = Integer.parseInt(input);


            String input1 = JOptionPane.showInputDialog("Enter side Length: ");
            int input3 = Integer.parseInt(input1);


            drawPolygon(t,input2 ,input3);
        }

        if (choice.equals("Many Polygons")) {

            String input2 = JOptionPane.showInputDialog("Enter number of Polygons: ");
            int input4 = Integer.parseInt(input2);

            String input3 = JOptionPane.showInputDialog("Enter number of Sides: ");
            int input5 = Integer.parseInt(input3);

            String input8 = JOptionPane.showInputDialog("Enter side Length: ");
            int input6 = Integer.parseInt(input8);

            manyPolygons(t, input4, input5, input6);

        }

        if (choice.equals("Radial")) {

            String input = JOptionPane.showInputDialog("Enter number of Lines: ");
            int input4 = Integer.parseInt(input);

            String input2 = JOptionPane.showInputDialog("Enter line Length: ");
            int input10 = Integer.parseInt(input2);

            radial(t, input4, input10);

        }

    } // end solution

    // Entry point of the program.

    public static void main(String[] args) {
        solution();
    } // end main TESTING

    //    Returns a random number between low (inclusive) and high (exclusive)
    //
    //     * DO NOT CHANGE THIS METHOD!!!!
    //
    //      @param low the lower (inclusive) part of the range.
    //      @param high the upper (exclusive) part of the range.
    //     @return a random number between low (inclusive) and high (exclusive).


    public static int rand(int low, int high) {
        return ThreadLocalRandom.current().nextInt(low, high);
    } // end rand

    // Code Break



    public static String menu() {
        JPanel panel = new JPanel();
        panel.add(new JRadioButton("radio"));
        String values[] = {"Name", "Polygon", "Many Polygons", "Radial"};
        Object choice = JOptionPane.showInputDialog(null,
                "Choose the demo to show", "Choose Demo",
                JOptionPane.DEFAULT_OPTION, null, values, "0");



        if (choice == null) {
            System.exit(0);
        }
        return choice.toString();



    } // end menu

} // end class HelloTurtles
