import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import tempCode.SubmittedAppButtonListener;



public class submitForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int FRAME_WIDTH = 550;
	private final int FRAME_HEIGHT = 485;
	private JLabel appNameLabel;
	private JLabel developerLabel;
	private JLabel linkLabel;
	private JLabel descriptionLabel;
	private JLabel platformLabel;
	private JLabel priceLabel;
	private JTextField nameArea;
	private JTextField developerArea;
	private JTextField linkArea;
	private JTextField descriptionArea;
	private JTextField platformArea;
	private JTextField priceArea;
	private JButton submitB;

	

	public submitForm() {

		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.getContentPane().add(createCenterPanel(), BorderLayout.CENTER);

	}
	

	private JPanel createCenterPanel(){

		JPanel panel = new JPanel();
		appNameLabel = new JLabel("Enter app name:   ");
		nameArea = new JTextField(35);
		developerLabel = new JLabel("Enter developer:  ");
		developerArea = new JTextField(35);
		linkLabel = new JLabel("Enter link:              ");
		linkArea = new JTextField(35);
		descriptionLabel = new JLabel("Enter description:  ");
		descriptionArea = new JTextField(35);
		platformLabel = new JLabel("Enter platform:      ");
		platformArea = new JTextField(35);
		priceLabel = new JLabel("Enter price:          $");
		priceArea = new JTextField(35);
		submitB = new JButton("Submit App");
		
		
		panel.add(appNameLabel);
		panel.add(nameArea);
		panel.add(developerLabel);
		panel.add(developerArea);
		panel.add(linkLabel);
		panel.add(linkArea);
		panel.add(descriptionLabel);
		panel.add(descriptionArea);
		panel.add(platformLabel);
		panel.add(platformArea);
		panel.add(priceLabel);
		panel.add(priceArea);
		panel.add(submitB);
		
		submitB.addActionListener(new SubmitAppButtonListener());
		
		return panel;
	}
	
	class SubmitAppButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String name, developer, link, description, platform;
			double price;
			nameArea.setText("");
			name = nameArea.getText();
			developerArea.setText("");
			developer= developerArea.getText();
			linkArea.setText("");
			link = linkArea.getText();
			descriptionArea.setText("");
			description = descriptionArea.getText();
			platformArea.setText("");
			platform = platformArea.getText();
			priceArea.setText("");
			price = Double.parseDouble(priceArea.getText());
			
			submitApp(name, developer, link, description, platform, price);
			
			
		}
	}


	

};