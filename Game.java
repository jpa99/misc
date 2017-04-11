import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.math.*;

public class Game extends JFrame implements ActionListener{

	public static ArrayList<Integer> player_moves=new ArrayList<Integer>();
	public static int player_move, computer_move, analysis, difficulty;
	public static String[] options={"ROCK", "PAPER", "SCISSORS"}, results={"      TIE      ", " YOU WIN ", " YOU LOSE "}, difficulties={"Random", "Artificial Intelligence"};
	public static boolean quit=false,enabled=false;
	public static JLabel player, computer, result;
	private static JButton rock, paper, scissors;
	private static Border player_border, computer_border, black;
	private static TitledBorder result_border;
	
	public Game(){
		setLayout(new FlowLayout());
		
		player=new JLabel("Player is selecting...", JLabel.CENTER);
		JPanel comp = new JPanel(new GridLayout(10, 10), false);
        comp.add(player);
        player_border = BorderFactory.createLineBorder(Color.blue);
        comp.setBorder(player_border);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(comp);

        result=new JLabel("          CALCULATING...          ", JLabel.CENTER);
        black= BorderFactory.createLineBorder(Color.black);
        result_border=BorderFactory.createTitledBorder(black, "RESULT");
        result_border.setTitleJustification(TitledBorder.CENTER);
        result_border.setTitlePosition(TitledBorder.DEFAULT_POSITION);
        JPanel comp2 = new JPanel(new GridLayout(10, 20), false);
        comp2.add(result);
        comp2.setBorder(result_border);
        add(Box.createRigidArea(new Dimension(10, 10)));
        add(comp2);
        
		computer=new JLabel("Computer has selected ", JLabel.RIGHT);
		JPanel comp3 = new JPanel(new GridLayout(10, 10), false);
        comp3.add(computer);
        computer_border = BorderFactory.createLineBorder(Color.blue);
        comp3.setBorder(computer_border);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(comp3);
        

		rock=new JButton();
		add(rock);
		try {
		    Image img = ImageIO.read(new File("rock.jpg"));
		    rock.setIcon(new ImageIcon(img));
		}
		catch (IOException ex) {}
		rock.addActionListener(
		  new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	player_moves.add(0);
		    	player.setText("Player has selected ROCK");
		    	enabled=true;
		    	analyze();
		    }
		  }
		);
		
		
		paper=new JButton();
		add(paper);
		try {
		    Image img2 = ImageIO.read(new File("paper.jpg"));
		    paper.setIcon(new ImageIcon(img2));
		}
		catch (IOException ex) {}
		paper.addActionListener(
		  new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	player_moves.add(1);
		    	player.setText("Player has selected PAPER");
		    	enabled=true;
		    	analyze();
		    }
		  }
		);
		
		
		scissors=new JButton();
		add(scissors);
		try {
		    Image img3 = ImageIO.read(new File("scissors.jpg"));
		    scissors.setIcon(new ImageIcon(img3));
		} 
		catch (IOException ex) {}
		scissors.addActionListener(
		  new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	player_moves.add(2);
		    	player.setText("Player has selected SCISSORS");
		    	enabled=true;
		    	analyze();
		    }
		  }
		);
		
		
		setTitle("Rock, Paper, Scissors");
		setSize(675, 450); 
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]){
		Game f=new Game();
		prompt_difficulty();
		if(quit==false && enabled==true){
			enabled=false;
			analyze();
			quit();
		}
	}
	
	public static void prompt_difficulty(){
		int difficulty=JOptionPane.showOptionDialog(null, "Choose Difficulty Level: ", "Difficulty Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, difficulties, difficulties[0]);
	}
	
	private static void Computer_move(){
		if(player_moves.size()<=3 || difficulty==0){
			computer_move=(int)(Math.random()*3);
		}
		else{
			int possible_player_move=mostCommon(player_moves);
			if(possible_player_move==2){
				computer_move=0;
			}
			else{
				computer_move=possible_player_move+1;
			}
		}
		computer.setText("Computer has selected "+options[computer_move]);
	}
	
	public static <T> T mostCommon(ArrayList<T> list) {
	    Map<T, Integer> map = new HashMap<>();

	    for (T t : list) {
	        Integer val = map.get(t);
	        map.put(t, val == null ? 1 : val + 1);
	    }

	    Entry<T, Integer> max = null;

	    for (Entry<T, Integer> e : map.entrySet()) {
	        if (max == null || e.getValue() > max.getValue())
	            max = e;
	    }

	    return max.getKey();
	}
	
	private static void analyze(){
		Computer_move();
		player_move=player_moves.get(player_moves.size()-1);
		if(player_move==computer_move){
			analysis=0;
		}
		else if(player_move==0 && computer_move==2 || (player_move -computer_move==1)){
			analysis=1;
		}
		else{
			analysis=2;
		}
		result.setText(results[analysis]);
		quit();
	}

	private static BufferedImage displayImage(String file){
		BufferedImage img=null;
	    JButton button=new JButton();
	    try {
	    	img = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return img;
	}

	
	private static void quit(){
		int n=JOptionPane.showConfirmDialog(null, "Do you want to continue?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(n==0){
			quit=false;
		}
		else{
			quit=true;
			JOptionPane.showMessageDialog(null, "Thanks for Playing!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
