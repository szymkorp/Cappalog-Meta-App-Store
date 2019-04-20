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
    static boolean status = false;
    private static final long serialVersionUID = 1L;
    private final int FRAME_WIDTH = 450;
    private final int FRAME_HEIGHT = 400;
    //private SQLConnection sqlCon = new SQLConnection();

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
    private JButton logoffButton;
    private JTextField unField;
    private JPasswordField p1;
    private JLabel helloUser;

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

    // the panelc cannot in the createCenterPanel method for the purpose of disapear.
    JPanel panelc = new JPanel();
    private JPanel createCenterPanel(){
        panelAf.removeAll();
        panelAf.setVisible(true);
        userNameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        unField = new JTextField(10);
        p1 = new JPasswordField(10);
        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());
        unField.setBounds(30,10,50,15);

  //while (sqlCon.loginCheck(unField.getText(), p1.getText()) == false);
            panelc.add(userNameLabel);
            panelc.add(unField);
            panelc.add(passwordLabel);
            panelc.add(p1);
            panelc.add(loginButton);
            return panelc;
    }

    class LoginButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            login();
            panelc.setVisible(status == false);
            if(status == true) { getContentPane().add(createCenterPanelAfter(), BorderLayout.CENTER);}
             }
    }

    private void login() {
        //assume password and username are correct;
        //here should check the the correctness.
        status = true;

    }

    // the panel that after login in
    JPanel panelAf = new JPanel();
    private JPanel createCenterPanelAfter(){

        helloUser = new JLabel(" Hello User ");
        logoffButton = new JButton(" Log off ");
        logoffButton.addActionListener(new LogoffButtonListener());
        panelAf.add(helloUser);
        panelAf.add(logoffButton);
        return panelAf;}

    class LogoffButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            // here should be some process that clean up the last account info
            panelAf.setVisible(false);
            createCenterPanel().removeAll();
            status = false;
            createCenterPanel().setVisible(true);

        }
    }
//==============================================================================================
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
