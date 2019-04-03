import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cappalog extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private final int FRAME_WIDTH = 450;
	private final int FRAME_HEIGHT = 400;
	
	private JTextField searchTextField;
	private JButton searchButton;
	private JTextArea wordListArea;
	private JRadioButton startsButton;
	private JRadioButton containsButton;
	private JRadioButton endsButton;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JLabel loginLabel;
	private JButton loginButton;
	private JTextField unField;
	private JPasswordField p1;
	
	private ArrayList<String> wordList;
	
	
	public Cappalog(){
		wordList = new ArrayList<String>();
		loadWordList();
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.getContentPane().add(createNorthPanel() , BorderLayout.NORTH);
		this.getContentPane().add(createCenterPanel(), BorderLayout.CENTER);
		this.getContentPane().add(createWestPanel(), BorderLayout.WEST);
		search();
	}
	private void loadWordList(){
		wordList.add("App 1");
		wordList.add("App 2");
		wordList.add("App 3");
		wordList.add("App 4");
		wordList.add("App 5");
		wordList.add("App 6");
		wordList.add("App 7");
		wordList.add("App 9");
		wordList.add("App 10");
		wordList.add("App 11");
		
	}
	private JPanel createWestPanel(){
		JPanel panel = new JPanel();
		wordListArea = new JTextArea(20,25);
		panel.add(wordListArea);
		searchButton.addActionListener(new SearchButtonListener());
		return panel;
		
	}
	private JPanel createCenterPanel(){
		JPanel panel = new JPanel();
		userNameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		unField = new JTextField(10);
		p1 = new JPasswordField(10);
		loginButton = new JButton("Login");
		
		unField.setBounds(30,10,50,15);
		
		panel.add(userNameLabel);
		panel.add(unField);
		panel.add(passwordLabel);
		panel.add(p1);
		panel.add(loginButton);
		return panel;
	}
	

	private JPanel createNorthPanel(){
		JPanel panel = new JPanel();
		searchTextField = new JTextField(15);
		panel.add(searchTextField);
		searchButton = new JButton("search");
		searchButton.addActionListener(new SearchButtonListener());
		panel.add(searchButton);
		return panel;
		
	}
	class SearchButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			search();
		}
	}
	private void search(){
		String query = searchTextField.getText();
		wordListArea.setText("");
		if ( query.length() == 0){
			for ( String word: wordList)
				wordListArea.append(word + "\n");
			
		}
		/*else{
			if(startsButton.isSelected()){
				for ( String word: wordList)
					if(word.startsWith(query))
						wordListArea.append(word + "\n");
				
			}
		
			if(containsButton.isSelected()){
				for ( String word: wordList)
					if(word.contains(query))
						wordListArea.append(word + "\n");
			}
		
			if(endsButton.isSelected()){
				for ( String word: wordList)
					if(word.endsWith(query))
						wordListArea.append(word + "\n");
			}
		}*/
	}

}
