
package guessnumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GuessNumber implements ActionListener  {
    private final double VERSION = 2.3;
    //Initializing Main Window and Difficulty Window
    JFrame window = new JFrame("Guess The Number " + VERSION);
    JFrame DiffFrame = new JFrame("Difficulty");
    
    //Making Buttons
    JButton btnNewGame = new JButton("New Game");
    JButton btnInstruction = new JButton("Instructions");
    JButton btnDifficulty = new JButton("Change Difficulty");
    JButton btnAbout = new JButton("About");
    JButton btnExit = new JButton("Exit");
    JButton btnOK = new JButton("Ok");
    JButton btnDiff[] = new JButton[6];






    //Making Panel for Main Menu Buttons
    JPanel pnlMainMenu = new JPanel();
    //Making Panel for Difficulty Buttons
    JPanel pnlDifficulty = new JPanel();
    
    //All Variables used initialized here
    int diff = 100;
    int tries;
    int Secret;
    int Guess;

    int option = 0;
    boolean Cancel = false;
    
    GuessNumber()   { //constructor
        //Setting Main Window properties
        window.setSize(270, 205); 
        window.setLocation(500, 260);   
        window.setLayout(new FlowLayout(FlowLayout.CENTER));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting Dificulty Window properties
        DiffFrame.setSize(230, 210);
        DiffFrame.setLocation(530, 230);    
        DiffFrame.setLayout(new BorderLayout());
        //MainMenu Panel Layout and adding Main Menu Buttons     
        //GridLayout(int rows, int columns, int Horizontal_Gap, intVertical_Gap)
        pnlMainMenu.setLayout(new GridLayout(5, 1, 2, 8));
        pnlMainMenu.add(btnNewGame);
        pnlMainMenu.add(btnInstruction);
        pnlMainMenu.add(btnDifficulty);
        pnlMainMenu.add(btnAbout);
        pnlMainMenu.add(btnExit);
        pnlMainMenu.setBackground(Color.red);
        //Setting Layout for Difficulty Panel
        pnlDifficulty.setLayout(new GridLayout(6, 1, 2, 2));
        
        //Making Difficulty Buttons
        btnDiff[0] = new JButton("Very Easy (0 - 3)");


        btnDiff[1] = new JButton("Easy (0 - 50)");
        btnDiff[2] = new JButton("Medium (0 - 100)");
        btnDiff[3] = new JButton("Hard (0 - 500)");
        btnDiff[4] = new JButton("Very Hard (0 - 1000)");
        btnDiff[5] = new JButton("Custom (0 - ?)");
        
        //Adding Action Listener for MainMenu Buttons
        btnNewGame.addActionListener(this);
        btnInstruction.addActionListener(this);
        btnDifficulty.addActionListener(this);
        btnAbout.addActionListener(this);
        btnExit.addActionListener(this);


        btnOK.addActionListener(this);
        
        //Adding Difficulty Buttons to Panel and adding Action Listener
        for(int i=0; i<6; i++)  {
            btnDiff[i].addActionListener(this);
            pnlDifficulty.add(btnDiff[i]);
        }
        //Showing Window
        window.add(pnlMainMenu);
        window.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent click)  {
        System.out.println("Action Performed");
        if(click.getSource() == btnNewGame) {
            NewGame();
        }
        if(click.getSource() == btnExit)    {
            option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Game" ,JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION)
                System.exit(0);
        }
        if(click.getSource() == btnInstruction) {
            JOptionPane.showMessageDialog(null,
            "Game:" + "\nClick New Game to start a new game.\nGuess a number between 0 and " + diff + ".\nKeep Guessing until you get it correct."
            + "\n\nDifficulty:" + "\nYou can change the difficulty of the game\n in the Main Menu to a Custom range or a \npreset range."
            , "Instructions", JOptionPane.INFORMATION_MESSAGE);
        }
        if(click.getSource() == btnAbout)   {
            JOptionPane.showMessageDialog(null, "Title: Guess The Number" + "\nCreated By: Vijaylaxmi Hatte" + "\nChanges:" + 
                "\n2.3- fixed bug (Win Message wouldnt show)" + "\n2.2- changed instruction message" + "\n2.1- changed win message" +
                "\n2.0- added difficulty change function." + "\n1.8- Cancel button works during New Game"   +
                "\n1.7- added About button." + "\n1.6- added Play Again function" + "\n1.5- added Instruction button." + 
                "\n1.2- added tries to guess number." + "\n1.1- added Exit button." + "\n1.0- made it GUI now." + 

                "\n0.5- added basic guessing function.",
                "About", JOptionPane.INFORMATION_MESSAGE);
        }
        if(click.getSource() == btnDifficulty)  {
            Change_Difficulty();
        }
        for(int i=0; i<6; i++)  {
            if(click.getSource() == btnDiff[i]) {
                if(click.getSource() == btnDiff[0])
                    diff = 3;
                if(click.getSource() == btnDiff[1])
                    diff = 50;
                if(click.getSource() == btnDiff[2])
                    diff = 100;
                if(click.getSource() == btnDiff[3])
                    diff = 500;
                if(click.getSource() == btnDiff[4])
                    diff = 1000;
                if(click.getSource() == btnDiff[5])
                    diff = Custom();
                DiffFrame.setVisible(false);
            }
        }
    }




    public void NewGame()   {
        tries = 1;
        Guess = 101;
        Secret = (int)((Math.random()) * (diff + 1));
        Cancel = false;
        
        while(Guess != Secret)  {
            try {
                if(tries == 1)  {
                    Guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Try: 1" + "\nGuess a number between 0 and " + diff, "Guess?", JOptionPane.PLAIN_MESSAGE));
                    
                    tries++;
                }   else    {
                    if(Guess > Secret)
                        Guess

 = Integer.parseInt(JOptionPane.showInputDialog(null, "Try: " + tries + "\n" + Guess + "\nGuess Lower..."));
                    else if(Guess < Secret)
                        Guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Try: " + tries + "\n" + Guess + "\nGuess Higher..."));
                    tries++;
                }
            } catch(NumberFormatException e)    {
                if(e.getMessage() == "null")    {
                    option = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back to the Main Menu?", "Cancel?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(option == JOptionPane.YES_OPTION)    {
                        Cancel = true;
                        break;
                    }
                }
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "\nEnter whole numbers only!");
            }
        }
        if(!Cancel) {
            tries--;
            JOptionPane.showMessageDialog(null, Guess + " is Correct!!\nYou WON in " + tries + " tries.", "Winner", JOptionPane.INFORMATION_MESSAGE);
            option = JOptionPane.showConfirmDialog(null, "Do you want to try again?", "Try Again?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(option == JOptionPane.YES_OPTION)
                NewGame();
        }
    }
    
    public void Change_Difficulty() {
        DiffFrame.add(pnlDifficulty, BorderLayout.CENTER);
        DiffFrame.setVisible(true);
    }
    
    public int Custom() {
        try {
            diff = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number that you want to be the range! (0 to ?)", diff));

        } catch(NumberFormatException e)    {
                
        }
        return diff;
    }
    
    public static void main(String[] args)  {
        //Initializes the class GuessNumber and the constructor GuessNumber()
        new GuessNumber();
    }
}
