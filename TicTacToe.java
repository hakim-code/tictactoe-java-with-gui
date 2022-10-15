import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import javax.swing.*;



public class TicTacToe implements ActionListener {
	
	Random random = new Random ();
	JFrame frame = new JFrame (); // box of 3x3 and title panel
	JPanel title_panel = new JPanel(); // TicTacToe Panel
	JPanel button_panel = new JPanel (); //button
	JLabel textfield = new JLabel (); //text field for messages
	JButton [] buttons = new JButton [9]; //all 3x3 boxes are the button 
	boolean player1_turn; //boolean for player2 is covered through false player1
	
	//constructor
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));//generic color can be done as well
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25, 25));
		textfield.setForeground(new Color (25, 255, 0));//green
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));//font size 75
		textfield.setHorizontalAlignment(JLabel.CENTER);//using border layout
		textfield.setText("Tic-Tac-Toe"); //title display
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i = 0 ; i<9; i++ ) {
			buttons[i] = new JButton(); //create 9 object of  JButton. JButton is declared as an array in the beginning
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
			
		}
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);//stick title panel on top, without border layout north it will be on the center
		frame.add(button_panel);//adding button panel onto the frame
		
		//
		firstTurn();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//run 9 times whenever a button is clicked
		for(int i = 0; i< 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (player1_turn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));//red
						buttons[i].setText("X");
						player1_turn = false;
						textfield.setText("O turn");
						check();
						
					}
				}
				else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));//blue
						buttons[i].setText("O");
						player1_turn = true;
						textfield.setText("X turn");
						check();
						
					}
			}
			
			
			}
		}
		
	}
	
	
	//determine whose turn is 
	
	public void firstTurn() {
		//sleep bit so that it can show title panel
		//try catch can be added through right click and surround Thread.sleep with try catch
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//0 is player 1
		if (random.nextInt(2)==0) {
			player1_turn = true;
			textfield.setText("X turn");
		}
		else {
			player1_turn = false;
			textfield.setText("O turn");
		}
	}
	
	//check winning condition
	
	public void check() {
		//winning conditions invoked when one of the rows, columns or cross fulfilled by the symbol.
		//when x win
		if (
				(buttons[0].getText()=="X")&&
				(buttons[1].getText()=="X")&&
				(buttons[2].getText()=="X")){
					XWins(0,1,2);
				}
		if (
				(buttons[3].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[5].getText()=="X")){
					XWins(3,4,5);
				}
		if (
				(buttons[6].getText()=="X")&&
				(buttons[7].getText()=="X")&&
				(buttons[8].getText()=="X")){
					XWins(6,7,8);
				}
		if (
				(buttons[0].getText()=="X")&&
				(buttons[3].getText()=="X")&&
				(buttons[6].getText()=="X")){
					XWins(0,3,6);
				}
		if (
				(buttons[1].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[7].getText()=="X")){
					XWins(1,4,7);
				}
		if (
				(buttons[2].getText()=="X")&&
				(buttons[5].getText()=="X")&&
				(buttons[8].getText()=="X")){
					XWins(2,5,8);
				}
		if (
				(buttons[2].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[6].getText()=="X")){
					XWins(2,4,6);
				}
				
		if (
				(buttons[0].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[8].getText()=="X")){
					XWins(0,4,8);
				}
		
		//if O wins
		
		if (
				(buttons[0].getText()=="O")&&
				(buttons[1].getText()=="O")&&
				(buttons[2].getText()=="O")){
					OWins(0,1,2);
				}
		if (
				(buttons[3].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[5].getText()=="O")){
					OWins(3,4,5);
				}
		if (
				(buttons[6].getText()=="O")&&
				(buttons[7].getText()=="O")&&
				(buttons[8].getText()=="O")){
					OWins(6,7,8);
				}
		if (
				(buttons[0].getText()=="O")&&
				(buttons[3].getText()=="O")&&
				(buttons[6].getText()=="O")){
					OWins(0,3,6);
				}
		if (
				(buttons[1].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[7].getText()=="O")){
					OWins(1,4,7);
				}
		if (
				(buttons[2].getText()=="O")&&
				(buttons[5].getText()=="O")&&
				(buttons[8].getText()=="O")){
					OWins(2,5,8);
				}
		if (
				(buttons[2].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[6].getText()=="O")){
					OWins(2,4,6);
				}
				
		if (
				(buttons[0].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[8].getText()=="O")){
					OWins(0,4,8);
				}
				
				
			
	}
	//when all the element get hit, those element will turn into green means win. 

	
	public void XWins( int a , int b, int c) {
		//indicate player x won 
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);

		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
			textfield.setText("X wins");
		}
	}
	
	public void OWins( int a , int b, int c) {
		//indicate player o won 
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);

		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
			textfield.setText("O wins");

		}
	}

}
