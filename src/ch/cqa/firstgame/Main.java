package ch.cqa.firstgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	
	//methode principal
	public static void main(String[] args) {
		
		start();

		GUI();

		
	}
	
	//tableau de jeu et de modifications
	static int[][] game = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	static int[][] changed = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	
	//tableau nombre aleatoire
	static int[] rand = {0,0,0,0};
	
	//methode de depart
	public static void start() {
		for(int i = 0; i < 4; i++) {
			rand[i] = (int)(Math.random() * (3 + 1));
		}
		
		game[rand[0]][rand[1]] = 2;
		game[rand[2]][rand[3]] = 2;
		
		if(rand[0] == rand[2] && rand[1] == rand[3]) {
			switch(game[1][1]) {
				case 0 :
					game[1][1] = 2;
					break;
				default :
					game[0][0] = 2;
					break;
			}
		}
		
		printtable();
	}
	
	//methode d'ecriture du tableau de jeu
	public static void printtable() {
		for(int i = 0; i < 4; i++) {
			System.out.println("{ " + game[i][0] + ", " + game[i][1] + ", " + game[i][2] + ", " + game[i][3] + " }");
		}
		
		System.out.println("");
	}
	
	//methodes de mouvements du jeu
	public static void up() {
		saving();
		
		for(int i = 1; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 1; k < 4; k++) {
					if(0 <= (i-k)) {
						if(game[i - k][j] == 0) {
							game[i - k][j] = game[i - k + 1][j];
							game[i - k + 1][j] = 0;
							changed[i - k][j] = changed[i - k + 1][j];
							changed[i - k + 1][j] = 0;
						}
						if(game[i - k][j] == game[i - k + 1][j] && changed[i - k][j] == 0 && changed[i - k + 1][j] == 0) {
							game[i - k][j] = game[i - k + 1][j]*2;
							game[i - k + 1][j] = 0;
							changed[i - k][j] = 1;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {	
				changed[i][j] = 0;			
			}
		}
		
		printtable();
		
		control();
		if(isSame == false) {
			newnumber();
			printtable();
			
			isSame = true;
		}
		
		majtext();
		
	}
	
	public static void down() {
		saving();
		
		for(int i = 2; i >= 0; i--) {
			for(int j = 0; j < 4; j++) {
				for(int k = 1; k < 4; k++) {
					if(4 > (i+k)) {
						if(game[i + k][j] == 0) {
							game[i + k][j] = game[i + k - 1][j];
							game[i + k - 1][j] = 0;
							changed[i + k][j] = changed[i + k - 1][j];
							changed[i + k - 1][j] = 0;
						}
						if(game[i + k][j] == game[i + k - 1][j] && changed[i + k][j] == 0 && changed[i + k - 1][j] == 0) {
							game[i + k][j] = game[i + k - 1][j]*2;
							game[i + k - 1][j] = 0;
							changed[i + k][j] = 1;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {	
				changed[i][j] = 0;			
			}
		}
		
		printtable();
		
		control();
		if(isSame == false) {
			newnumber();
			printtable();
			
			isSame = true;
		}
		
		majtext();
	}
	
	public static void left() {
		saving();
		
		for(int i = 1; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 1; k < 4; k++) {
					if(0 <= (i-k)) {
						if(game[j][i - k] == 0) {
							game[j][i - k] = game[j][i - k + 1];
							game[j][i - k + 1] = 0;
							changed[j][i - k] = changed[j][i - k + 1];
							changed[j][i - k + 1] = 0;
						}
						if(game[j][i - k] == game[j][i - k + 1] && changed[j][i - k] == 0 && changed[j][i-k+1] == 0) {
							game[j][i - k] = game[j][i - k + 1]*2;
							game[j][i - k + 1] = 0;
							changed[j][i - k] = 1;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {	
				changed[i][j] = 0;			
			}
		}
		
		printtable();
		
		control();
		if(isSame == false) {
			newnumber();
			printtable();
			
			isSame = true;
		}
		
		majtext();
		
	}
	
	public static void right() {
		saving();
		
		for(int i = 2; i >= 0; i--) {
			for(int j = 0; j < 4; j++) {
				for(int k = 1; k < 4; k++) {
					if(4 > (i+k)) {
						if(game[j][i + k] == 0) {
							game[j][i + k] = game[j][i + k - 1];
							game[j][i + k - 1] = 0;
							changed[j][i + k] = changed[j][i + k - 1];
							changed[j][i + k - 1] = 0;
						}
						if(game[j][i + k] == game[j][i + k - 1] && changed[j][i + k] == 0 && changed[j][i + k - 1] == 0) {
							game[j][i + k] = game[j][i + k - 1]*2;
							game[j][i + k - 1] = 0;
							changed[j][i + k] = 1;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {	
				changed[i][j] = 0;			
			}
		}
		
		printtable();
		
		control();
		if(isSame == false) {
			newnumber();
			printtable();
			
			isSame = true;
		}
		
		majtext();
	}
	
	//methode d'ajout de nombre au jeu
	public static boolean fill = false;
	public static void newnumber() {
		while(fill == false) {
			for(int i = 0; i < 2; i++) {
				rand[i] = (int)(Math.random() * (3 + 1));
			}
			
			if(game[rand[0]][rand[1]] == 0) {
				rand[2] = (int)(Math.random() * (10 + 1));
				if(rand[2] <= 9) {
					game[rand[0]][rand[1]] = 2;
				} else {
					game[rand[0]][rand[1]] = 4;
				}
				
				fill = true;
			}
		}
		
		fill = false;
	}
	
	//fenetre du jeu
	public static JFrame f1 = new JFrame("2048");
	
	//taille des cases
	public static int caseSize = 50;
	
	//void pour initialiser les cases
	public static void casevoid(JButton b, int i, int j) {
		b.setBounds(j*caseSize, i*caseSize, caseSize, caseSize);
		
		f1.add(b);
	}
	
	//void de setup et de maj du texte
	public static void casetext(JButton b, int i, int j) {
		String number = String.valueOf(game[i][j]);
		b.setText(number);
		
		switch(game[i][j]) {
			case 2 :
				b.setBackground(Color.white);
				break;
			case 4 :
				b.setBackground(Color.lightGray);
				break;
			case 8 :
				b.setBackground(Color.yellow);
				break;
			case 16 :
				b.setBackground(Color.orange);
				break;
			case 32 :
				b.setBackground(Color.red);
				break;
			case 64 :
				b.setBackground(Color.pink);
				break;
			case 128 :
				b.setBackground(Color.magenta);
				break;
			case 256 :
				b.setBackground(Color.blue);
				break;
			case 512 :
				b.setBackground(Color.cyan);
				break;
			case 1024 :
				b.setBackground(Color.gray);
				break;
			case 2048 :
				b.setBackground(Color.green);
				break;
			case 4096 :
				b.setBackground(Color.white);
				break;
			case 8192 :
				b.setBackground(Color.lightGray);
				break;
			case 16384 :
				b.setBackground(Color.yellow);
				break;
			case 32768 :
				b.setBackground(Color.orange);
				break;
			case 65536 :
				b.setBackground(Color.red);
				break;
			case 131072 :
				b.setBackground(Color.darkGray);
				break;
			default : 
				b.setBackground(Color.black);
				break;
		}
	}
	public static void majtext() {
		casetext(case1, 0, 0);
		casetext(case2, 0, 1);
		casetext(case3, 0, 2);
		casetext(case4, 0, 3);
		casetext(case5, 1, 0);
		casetext(case6, 1, 1);
		casetext(case7, 1, 2);
		casetext(case8, 1, 3);
		casetext(case9, 2, 0);
		casetext(case10, 2, 1);
		casetext(case11, 2, 2);
		casetext(case12, 2, 3);
		casetext(case13, 3, 0);
		casetext(case14, 3, 1);
		casetext(case15, 3, 2);
		casetext(case16, 3, 3);
	}
	
	//initialisation des cases
	public static JButton case1 = new JButton();
	public static JButton case2 = new JButton();
	public static JButton case3 = new JButton();
	public static JButton case4 = new JButton();
	public static JButton case5 = new JButton();
	public static JButton case6 = new JButton();
	public static JButton case7 = new JButton();
	public static JButton case8 = new JButton();
	public static JButton case9 = new JButton();
	public static JButton case10 = new JButton();
	public static JButton case11 = new JButton();
	public static JButton case12 = new JButton();
	public static JButton case13 = new JButton();
	public static JButton case14 = new JButton();
	public static JButton case15 = new JButton();
	public static JButton case16 = new JButton();
	
	//background de debug
	public static JButton background = new JButton();
	
	//boutons de mouvements
	public static JButton bUp = new JButton("Up");
	public static JButton bDown = new JButton("Down");
	public static JButton bLeft = new JButton("Left");
	public static JButton bRight = new JButton("Right");
	
	//GUI
	public static void GUI(){
		casevoid(case1, 0, 0);
		casevoid(case2, 0, 1);
		casevoid(case3, 0, 2);
		casevoid(case4, 0, 3);
		casevoid(case5, 1, 0);
		casevoid(case6, 1, 1);
		casevoid(case7, 1, 2);
		casevoid(case8, 1, 3);
		casevoid(case9, 2, 0);
		casevoid(case10, 2, 1);
		casevoid(case11, 2, 2);
		casevoid(case12, 2, 3);
		casevoid(case13, 3, 0);
		casevoid(case14, 3, 1);
		casevoid(case15, 3, 2);
		casevoid(case16, 3, 3);
		
		majtext();
		
		bUp.setBounds(caseSize*5+17, caseSize*2-31, caseSize+16, caseSize+16);
		bDown.setBounds(caseSize*5+17, caseSize*3-15, caseSize+16, caseSize+16);
		bLeft.setBounds(caseSize*4+1, caseSize*3-15, caseSize+16, caseSize+16);
		bRight.setBounds(caseSize*6+33, caseSize*3-15, caseSize+16, caseSize+16);
		
		bUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				up();
			}
		});
		bDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				down();
			}
		});
		bLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				left();
			}
		});
		bRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				right();
			}
		});
		
		bReset.setBounds(caseSize*4+1, 0, caseSize*2, caseSize/2);
		bRecall.setBounds(caseSize*6+1, 0, caseSize*2, caseSize/2);
		
		bReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		bRecall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recall();
			}
		});
		
		f1.add(bDown);
		f1.add(bLeft);
		f1.add(bRight);
		f1.add(bUp);
		
		f1.add(bReset);
		f1.add(bRecall);
		
		background.setVisible(false);
		f1.add(background);
		
		f1.setSize(caseSize*8+17, caseSize*5-7);
		f1.setResizable(false);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	static int[][] save1 = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	static int[][] save2 = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	static int[][] save3 = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	
	public static void saving() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				save3[i][j] = save2[i][j];
				save2[i][j] = save1[i][j];
				save1[i][j] = game[i][j];
			}
		}		
	}
	
	public static void recall() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				game[i][j] = save1[i][j];
				save1[i][j] = save2[i][j];
				save2[i][j] = save3[i][j];
			}
		}	
		
		majtext();
	}

	public static void reset() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				game[i][j] = 0;
				changed[i][j] = 0;
				save1[i][j] = 0;
				save2[i][j] = 0;
				save3[i][j] = 0;
			}
		}
		
		start();
		majtext();
	}

	public static JButton bReset = new JButton("Reset");
	public static JButton bRecall = new JButton("Recall");
	
	public static boolean isSame = true;
	
	public static void control() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(game[i][j] != save1[i][j]) {
					isSame = false;
				}
			}
		}
	}
	
}
