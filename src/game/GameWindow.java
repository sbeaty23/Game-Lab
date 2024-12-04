package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame implements ActionListener {

	public static void main(String[] args) {
		new GameWindow();
	}
	private JTextArea textArea = new JTextArea();
	private JButton[] buttons;
	private char turn = 'X';
	private JPanel panel = new JPanel(); 

	public GameWindow() {
		buildWindow();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton b = (JButton) event.getSource();
		if (b.getText().equals(" ")) {
			b.setText(turn + "");
			if (turn == 'X')
				turn = 'O';
			else
				turn = 'X';
		}
	}

	private void buildWindow() {
		setTitle("Game Title");
		setLayout(new BorderLayout());
		panel.setLayout(new GridLayout(3, 1)); 
		add(textArea,BorderLayout.CENTER);
		textArea.setForeground(new Color(69,76,237));
		textArea.setBackground(new Color(69,237,146));
		add(panel,BorderLayout.SOUTH);
		JLabel prompt = new JLabel("What would you like to do?");
		prompt.setOpaque(true);
		prompt.setFont(new Font(null, Font.BOLD, 10));
		prompt.setForeground(new Color(23,31,232));
		prompt.setBackground(new Color(23,232,119));
		panel.add(prompt,0);
		TextField text = new TextField(" ");
		text.setFont(new Font(null, Font.BOLD, 10));
		text.setForeground(new Color(69,76,237));
		text.setBackground(new Color(69,237,146));
		panel.add(text,1);
		JButton execute = new JButton("Execute");
		execute.addActionListener(this);
		execute.setFont(new Font(null, Font.BOLD, 10));
		execute.setForeground(new Color(23,31,232));
		execute.setBackground(new Color(23,232,119));
		panel.add(execute,2);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null); // Center window
		setVisible(true); // Make window appear
	}

}
