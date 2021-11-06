/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AHMAD
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import sun.print.PathGraphics;

class SecondFrame
        extends JFrame
        implements ActionListener, Runnable {

    static Color C = Color.RED;
    // Components of the Form
    private Container c;
    private JButton Buttons[][] = new JButton[4][25];
    private static JButton ThreadButton[] = new JButton[8];
    private JLabel title;
    private JPanel panel;
    int NumberColor;
    int Numlevel;
    int Numspeed;
    int speed=150;
    JButton[][] matrix;
    Color[] ArrayColor = {Color.BLACK, Color.RED, Color.BLUE, Color.YELLOW, Color.WHITE, Color.GREEN, Color.ORANGE, Color.PINK};

    // constructor, to initialize the components
    // with default values.
    public SecondFrame(String Speed, String NumberOfColor, String Level) {
        setTitle("Sort Color Project Using Thread ");
        setSize(1850, 1010);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 15);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panel.setBounds(0, 0, 200, 1000);
        panel.setBackground(Color.white);

        switch (NumberOfColor) {
            case "FOUR":
                NumberColor = 4;
                break;
            case "SIX":
                NumberColor = 6;
                break;
            case "EIGHT":
                NumberColor = 8;
                break;
        }
        switch (Level) {
            case "LOW":
                Numlevel = 1;
                break;
            case "MEDIUM":
                Numlevel = 2;
                break;
            case "HIGH":
                Numlevel = 3;
                break;

        }
        switch (Speed) {
            case "LOW":
                speed = 400;
                break;
            case "MEDIUM":
                Numspeed = 200;
                break;
            case "HIGH":
                Numspeed = 10;
                break;

        }
        
        matrix = new JButton[NumberColor][Numlevel * 25];
        createthreadButtons(NumberColor);
        createSortButtons(NumberColor, Numlevel);

        setVisible(true);
    }

    private void createthreadButtons(int number) {
        int i = 0;
        for (int j = 0; j < number; j++) {
            ThreadButton[j] = new JButton("THREAD " + j);
            ThreadButton[j].setSize(250, 60);
            ThreadButton[j].setFont(new java.awt.Font("Ink Free", 70, 25));
            ThreadButton[j].setBackground(ArrayColor[j]);
            ThreadButton[j].setName("" + j);
            ThreadButton[j].setLocation(i, j * 100 + 15);
            String a = j + "";
            ThreadButton[j].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                    switch (a) {
                        case "0":
                            jButton0ActionPerformed(evt);
                            break;
                        case "1":
                            jButton1ActionPerformed(evt);
                            break;
                        case "2":
                            jButton2ActionPerformed(evt);
                            break;
                        case "3":
                            jButton3ActionPerformed(evt);
                            break;
                        case "4":
                            jButton4ActionPerformed(evt);
                            break;
                        case "5":
                            jButton5ActionPerformed(evt);
                            break;
                        case "6":
                            jButton6ActionPerformed(evt);
                            break;
                        case "7":
                            jButton7ActionPerformed(evt);
                            break;

                    }

                }
            });
            c.add(ThreadButton[j]);

        }
        JButton jMessUb = new JButton("MESS UP");
        jMessUb.setSize(250, 60);
        jMessUb.setFont(new java.awt.Font("Georgia", 100, 25));
        jMessUb.setBackground(Color.MAGENTA);
        jMessUb.setLocation(0, (number) * 100 + 15);
        jMessUb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMessUpActionPerformed(evt);
            }
        });
        c.add(jMessUb);

        JButton JTryAgain = new JButton("Try Again");
        JTryAgain.setSize(250, 60);
        JTryAgain.setFont(new java.awt.Font("Georgia", 100, 25));
        JTryAgain.setBackground(Color.MAGENTA);
        JTryAgain.setLocation(0, (number + 1) * 100 + 15);
        JTryAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTryAgainActionPerformed(evt);
            }
        });
        c.add(JTryAgain);
    }

    private void createSortButtons(int NumThread, int Level) {
        
        for (int i = 0; i < NumThread; i++) {
            for (int j = 0; j < Level * 25; j++) {
                matrix[i][j] = new JButton("");
                matrix[i][j].setSize(1590 / NumThread, 38 / Level);
                matrix[i][j].setBackground(ArrayColor[i]);
                matrix[i][j].setName(i + "," + j);
                matrix[i][j].setLocation(i * (1590 / NumThread) + 250, j * 38 / Level + 15);
                c.add(matrix[i][j]);
            }

        }

    }

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {
        C = Color.BLACK;
        Thread th = new Thread(this);
        th.start();

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        C = Color.RED;
        Thread th = new Thread(this);
        th.start();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        C = Color.BLUE;
        Thread th = new Thread(this);
        th.start();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        C = Color.YELLOW;
        Thread th = new Thread(this);
        th.start();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        C = Color.WHITE;
        Thread th = new Thread(this);
        th.start();
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        C = Color.GREEN;
        Thread th = new Thread(this);
        th.start();
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        C = Color.ORANGE;
        Thread th = new Thread(this);
        th.start();
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        C = Color.PINK;
        Thread th = new Thread(this);
        th.start();
    }

    private void jButtonMessUpActionPerformed(java.awt.event.ActionEvent evt) {

        this.MessUpFun();

    }

    private void jButtonTryAgainActionPerformed(java.awt.event.ActionEvent evt) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        this.setVisible(false);
    }

    public void refresh(int[][] matrix) {

//    for(int i=0;i<4;i++)
//		{
//			for(int j=0;j<25;j++)
//			{
//				System.out.print("i---("+i+") j----("+j+")  "+matrix[i][j]+"      ");
//                                 System.out.println("i---("+i+") j----("+j+") Buutons "+Buttons[i][j].getName()+"      ");
//			}
//                        System.out.println("");
//		}
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 25; j++) {
                //   System.out.println("i---("+i+") j----("+j+")");
                if (matrix[i][j] == 1) {
//            System.out.println("i---("+i+") j----("+j+")"+" Buttons[i][j].setBackground(Color.RED);"+Buttons[i][j].getBackground());
                    Buttons[i][j].setBackground(Color.RED);

                } else if (matrix[i][j] == 2) {
//             System.out.println("i---("+i+") j----("+j+")"+" Buttons[i][j].setBackground(Color.black);"+Buttons[i][j].getBackground());
                    Buttons[i][j].setBackground(Color.BLACK);
                } else if (matrix[i][j] == 3) {
//             System.out.println("i---("+i+") j----("+j+")"+" Buttons[i][j].setBackground(Color.yellow);"+Buttons[i][j].getBackground());
                    Buttons[i][j].setBackground(Color.YELLOW);
                } else if (matrix[i][j] == 4) {
//             System.out.println("i---("+i+") j----("+j+")"+" Buttons[i][j].setBackground(Color.blue);"+Buttons[i][j].getBackground());
                    Buttons[i][j].setBackground(Color.BLUE);
                }

            }
        }

        try {
            Thread a = Thread.currentThread();
            a.sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(SecondFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.invalidate();
        this.validate();
        this.repaint();
    }

    public void MessUpFun() {
        Random rand = new Random();
        int RandomI = 0;
        int RandomJ = 0;

        for (int i = 0; i < NumberColor; i++) {
            for (int j = 0; j < Numlevel * 25; j++) {

                RandomI = rand.nextInt((NumberColor - 1) + 1);
                RandomJ = rand.nextInt(((Numlevel * 25) - 1) + 1);
                Color butt = matrix[i][j].getBackground();
                matrix[i][j].setBackground(matrix[RandomI][RandomJ].getBackground());
                matrix[RandomI][RandomJ].setBackground(butt);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        Color Copy = C;
        int NumberOfColor = matrix.length;
        int numberOfButton = matrix[0].length;

        int place = 0;
        for (int i = 0; i < ArrayColor.length; i++) {
            if (Copy.equals(ArrayColor[i])) {
                place = i;
            }
        }
        int count = 0;
        for (int i = 0; i < NumberOfColor; i++) {

            if (i != place) {
                for (int j = 0; j < numberOfButton; j++) {
                    if (matrix[i][j].getBackground().equals(Copy)) {

                        Color empty = matrix[place][count].getBackground();
                        if (!empty.equals(Copy)) {
                            matrix[place][count].setBackground(matrix[i][j].getBackground());
                            matrix[i][j].setBackground(empty);
                            count++;
                        } else {
                            count++;
                        }
                        j--;
                    }
                    try {

                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SecondFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.invalidate();
                    this.validate();
                    this.repaint();
                }

            } else {
                for (int j = count; j < numberOfButton; j++) {
                    if (matrix[i][j].getBackground().equals(Copy)) {
                        Color empty = matrix[place][count].getBackground();

                        matrix[place][count].setBackground(Copy);
                        matrix[i][j].setBackground(empty);
                        count++;
                    }
                    try {

                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SecondFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.invalidate();
                    this.validate();
                    this.repaint();
                }
            }

        }

    }
}
