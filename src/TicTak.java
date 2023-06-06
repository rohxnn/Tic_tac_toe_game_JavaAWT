import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTak implements ActionListener {
	Random random=new Random();
	JFrame frame=new JFrame("TIC TAC TOE");
	JPanel Title_panel=new JPanel();
	JPanel Button_Panel=new JPanel();
	JLabel label=new JLabel();
	
	JButton[] buttons=new JButton[9];
	Boolean player1_turn;
	
	
	
	
	TicTak()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		label.setBackground(new Color(25, 25, 25));
		label.setForeground(new Color(25,255,0));
		label.setFont(new Font("Ink Free",Font.BOLD,75));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);
		label.setText("TIC-TAC-TOE");
		frame.add(label);
		
		Title_panel.setLayout(new BorderLayout());
		Title_panel.setBounds(0, 0, 800, 100);
		
		Button_Panel.setLayout(new GridLayout(3, 3));
		Button_Panel.setBackground(new Color(150,150,150));
		Button_Panel.setOpaque(true);
		
		Title_panel.add(label);
		frame.add(Title_panel,BorderLayout.NORTH);
		
		frame.add(Button_Panel);
		
		for(int i=0;i<9;i++)
		{
			buttons[i]=new JButton();
			Button_Panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
			//Firstturn();
			
		}
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		  for(int i=0;i<9;i++)
		  {
			  if(e.getSource()==buttons[i])
			  {
				  if(player1_turn)
				  {
					  if(buttons[i].getText()=="")
					  {
						  buttons[i].setForeground(new Color(255, 0, 0));
						  buttons[i].setText("X");
						  player1_turn=false;
						  label.setText("O TURN");
						  check();
					  }
				  }
				  else
				  {
					  if(buttons[i].getText()=="")
					  {
						  buttons[i].setForeground(new Color(0,0,255));
						  buttons[i].setText("O");
						  player1_turn=true;
						  label.setText("X TURN");
						  check();
					  }}
				  }
		
	}
	}
	public void Firstturn()
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0)
		{
			player1_turn=true;
			
			label.setText("X turn");
		}
		else
		{
			player1_turn=false;
			label.setText("O turn");
		}
		
	}
	
	public void check()
	{
		//x winning chances
		
		if((buttons[0].getText()=="X")&&
				(buttons[1].getText()=="X")&&
				(buttons[2].getText()=="X"))
		{
			xwins(0, 1, 2);
		}
		if((buttons[3].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[5].getText()=="X"))
		{
			xwins(3, 4, 5);
		}
		if((buttons[6].getText()=="X")&&
				(buttons[7].getText()=="X")&&
				(buttons[8].getText()=="X")) {
			xwins(6, 7, 8);
		}
		if((buttons[0].getText()=="X")&&
				(buttons[3].getText()=="X")&&
				(buttons[6].getText()=="X"))
		{
			xwins(0, 3, 6);
		}
		if((buttons[1].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[7].getText()=="X"))
		{
			xwins(1, 4, 7);
		}
		if((buttons[1].getText()=="X")&&
				(buttons[5].getText()=="X")&&
				(buttons[8].getText()=="X"))
		{
			xwins(1, 5, 8);
		}
		if((buttons[0].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[8].getText()=="X"))
		{
			xwins(0, 4, 8);
		}
		if((buttons[2].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[6].getText()=="X"))
		{
			xwins(2, 4, 6);
		}
		//check o wins
		
		
		
		if((buttons[0].getText()=="O")&&
				(buttons[1].getText()=="O")&&
				(buttons[2].getText()=="O"))
		{
			owins(0, 1, 2);
		}
		if((buttons[3].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[5].getText()=="O"))
		{
			owins(3, 4, 5);
		}
		if((buttons[6].getText()=="O")&&
				(buttons[7].getText()=="O")&&
				(buttons[8].getText()=="O")) {
			owins(6, 7, 8);
		}
		if((buttons[0].getText()=="O")&&
				(buttons[3].getText()=="O")&&
				(buttons[6].getText()=="O"))
		{
			owins(0, 3, 6);
		}
		if((buttons[1].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[7].getText()=="O"))
		{
			owins(1, 4, 7);
		}
		if((buttons[1].getText()=="O")&&
				(buttons[5].getText()=="O")&&
				(buttons[8].getText()=="O"))
		{
			owins(1, 5, 8);
		}
		if((buttons[0].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[8].getText()=="O"))
		{
			owins(0, 4, 8);
		}
		if((buttons[2].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[6].getText()=="O"))
		{
			owins(2, 4, 6);
		}
	}
	public void xwins(int i, int j, int k) {
		buttons[i].setBackground(Color.green);
		buttons[j].setBackground(Color.green);
		buttons[k].setBackground(Color.green);
		for(int a=0;a<9;a++)
		{
			buttons[a].setEnabled(false);
		}
			label.setText("X wins");
		
	}



	public void owins(int a,int b,int c)
	{
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
			label.setText("O wins");
	}

}
