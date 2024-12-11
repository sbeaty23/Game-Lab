package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame implements ActionListener {

	static JTextArea textArea = new JTextArea();
	private JButton[] buttons;
	private JPanel panel = new JPanel(); 
	static TextField textF = new TextField();
	private JScrollPane scroller = new JScrollPane(textArea);
	

	public GameWindow() {
		buildWindow();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton b = (JButton) event.getSource();
		String s = textF.getText();
		Game.processCommand(s);
	}

	private void buildWindow() {
		setTitle("Escape The Lotus Hotel");
		setLayout(new BorderLayout());
		panel.setLayout(new GridLayout(3, 1)); 
		add(textArea,BorderLayout.CENTER);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		add(panel,BorderLayout.SOUTH);
		JLabel prompt = new JLabel("What would you like to do?");
		prompt.setOpaque(true);
		prompt.setFont(new Font(null, Font.BOLD, 10));
		prompt.setForeground(Color.WHITE);
		prompt.setBackground(new Color(23,232,119));
		panel.add(prompt,0);
		textF.setFont(new Font(null, Font.BOLD, 10));
		textF.setBackground(Color.BLACK);
		textF.setForeground(Color.WHITE);
		panel.add(textF,1);
		JButton execute = new JButton("Execute");
		execute.addActionListener(this);
		execute.setFont(new Font(null, Font.BOLD, 10));
		execute.setForeground(Color.WHITE);
		execute.setBackground(Color.BLACK);
		panel.add(execute,2);
		getContentPane().add(scroller, BorderLayout.CENTER);

		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null); // Center window
		setVisible(true); // Make window appear
	}

}
