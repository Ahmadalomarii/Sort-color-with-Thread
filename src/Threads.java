
import java.awt.Color;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AHMAD
 */
public class Threads extends Thread {

    Color[] ArrayColor = {Color.BLACK, Color.RED, Color.BLUE, Color.YELLOW, Color.WHITE, Color.GREEN, Color.ORANGE, Color.PINK};

    public JButton[][] run(Color C, JButton[][] matrix) {
        int NumberOfColor = matrix.length;
        int numberOfButton = matrix[0].length;

        int place = 0;
        for (int i = 0; i < ArrayColor.length; i++) {
            if (C.equals(ArrayColor[i])) {
                place = i;
            }
        }
        int count = 0;
        for (int i = 0; i < NumberOfColor; i++) {
            if (i != place) {
                for (int j = 0; j < numberOfButton; j++) {
                    if (matrix[i][j].getBackground().equals(C)) {

                        Color empty = matrix[place][count].getBackground();
                        if (!empty.equals(C)) {
                            matrix[place][count].setBackground(matrix[i][j].getBackground());
                            matrix[i][j].setBackground(empty);
                            count++;
                        } else {
                            count++;
                        }
                        j--;
                    }
                }

            } else {
                for (int j = count; j < numberOfButton; j++) {
                    if (matrix[i][j].getBackground().equals(C)) {
                        Color empty = matrix[place][count].getBackground();

                        matrix[place][count].setBackground(C);
                        matrix[i][j].setBackground(empty);
                        count++;
                    }
                }
            }
        }
        return matrix;
    }
}
