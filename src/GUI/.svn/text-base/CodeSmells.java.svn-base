package GUI;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * 
 * @author Computard
 * GUI to present information about different code smell.
 *
 */
public class CodeSmells {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	
	private JPanel jContentPane = null;
	
	private JLabel bloater_Titled_Border = null;
	private JLabel lazyClass_Titled_Border = null;
	private JLabel deepNesting_Titled_Border = null;
	private JLabel godClass_Titled_Border = null;
	
	private JTextArea bloater_TextArea = null;
	private JTextArea lazyClass_TextArea = null;
	private JTextArea deepNesting_TextArea = null;
	private JTextArea godClass_TextArea = null;

	private JButton back_Button = null;
	private JLabel excessComment_Titled_Border = null;
	private JTextArea excessComment_TextArea = null;


	public CodeSmells(){
		
	}
	
	protected JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(512, 646);
			jFrame.setResizable(false);
			jFrame.setLocationRelativeTo(null);//Centre Window for everyones display
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("Code Smell Information");
		}
		return jFrame;
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			
			getDeepNesting_Titled_Border();
			getLazyClass_Titled_Border();
			getgodClass_Titled_Border();
			getBloater_Titled_Border();
			
			excessComment_Titled_Border = new JLabel("");
			excessComment_Titled_Border.setBounds(new Rectangle(14, 463, 465, 100));
			excessComment_Titled_Border.setHorizontalAlignment(JLabel.CENTER);
			excessComment_Titled_Border.setText("");
			excessComment_Titled_Border.setBorder(new TitledBorder("Excess Commenting:"));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(Color.white);
			
			jContentPane.add(bloater_Titled_Border, null);
			jContentPane.add(lazyClass_Titled_Border, null);
			jContentPane.add(deepNesting_Titled_Border, null);
			jContentPane.add(godClass_Titled_Border, null);
			
			jContentPane.add(getBloater_TextArea(), null);
			jContentPane.add(getLazyClass_TextArea(), null);
			jContentPane.add(getDeepNesting_TextArea(), null);
			jContentPane.add(getgodClass_TextArea(), null);
			jContentPane.add(getBack_Button(), null);
			jContentPane.add(excessComment_Titled_Border, null);
			jContentPane.add(getExcessComment_TextArea(), null);
		}
		return jContentPane;
	}

	
	//-----------------------Bloater----------------------------------------------------//
	
	private JLabel getBloater_Titled_Border(){
		if(bloater_Titled_Border == null){
			bloater_Titled_Border = new JLabel("");
			bloater_Titled_Border.setBounds(new Rectangle(16, 15, 465, 100));
			bloater_Titled_Border.setHorizontalAlignment(JLabel.CENTER);
			bloater_Titled_Border.setText("");
			bloater_Titled_Border.setBorder(new TitledBorder("Bloater:"));
		}
		return bloater_Titled_Border;
	}

	
	private JTextArea getBloater_TextArea() {
		if (bloater_TextArea == null) {
			bloater_TextArea = new JTextArea();
			bloater_TextArea.setBounds(new Rectangle(25, 36, 440, 70));
			bloater_TextArea.setBackground(Color.white);
			bloater_TextArea.setEditable(false);
			bloater_TextArea.setText("We have defined a Bloater as a Class or Method that is too" +
					" long. Short methods\nand short Classes are easier to read, understand and debug" +
					" than longer ones.");
			
		}
		return bloater_TextArea;
	}
	
//-----------------------God Class----------------------------------------------------//

	
	private JLabel getgodClass_Titled_Border(){
		if(godClass_Titled_Border == null){
			godClass_Titled_Border = new JLabel("");
			godClass_Titled_Border.setBounds(new Rectangle(15, 351, 465, 100));
			godClass_Titled_Border.setHorizontalAlignment(JLabel.CENTER);
			godClass_Titled_Border.setText("");
			godClass_Titled_Border.setBorder(new TitledBorder("God Class:"));
		}
		return godClass_Titled_Border;
	}
	
	private JTextArea getgodClass_TextArea() {
		if (godClass_TextArea == null) {
			godClass_TextArea = new JTextArea();
			godClass_TextArea.setBounds(new Rectangle(24, 372, 440, 70));
			godClass_TextArea.setBackground(Color.white);
			godClass_TextArea.setEditable(false);
			godClass_TextArea.setText("A God Class is a class that does a disproportionate amount" +
					" of work compared \nto other classes. A God Class will have more methods than" +
					" the other classes \nwhere as ideally they should be shared out more evenly" +
					" amongst all the classes.");
		}
		return godClass_TextArea;
	}

	//-----------------------Deep Nesting----------------------------------------------------//
	
	
	private JLabel getDeepNesting_Titled_Border(){
		if(deepNesting_Titled_Border== null){
			deepNesting_Titled_Border = new JLabel("");
			deepNesting_Titled_Border.setBounds(new Rectangle(16, 239, 465, 100));
			deepNesting_Titled_Border.setHorizontalAlignment(JLabel.CENTER);
			deepNesting_Titled_Border.setText("");
			deepNesting_Titled_Border.setBorder(new TitledBorder("Deep Nesting:"));
		}
		return deepNesting_Titled_Border;
	}
	
	//-----------------------Lazy Class----------------------------------------------------//
	
	
	private JLabel getLazyClass_Titled_Border(){
		if(lazyClass_Titled_Border == null){
			lazyClass_Titled_Border = new JLabel("");
			lazyClass_Titled_Border.setBounds(new Rectangle(15, 129, 465, 100));
			lazyClass_Titled_Border.setHorizontalAlignment(JLabel.CENTER);
			lazyClass_Titled_Border.setText("");
			lazyClass_Titled_Border.setBorder(new TitledBorder("Lazy Class:"));
		}
		return lazyClass_Titled_Border;
	}
	

	private JTextArea getLazyClass_TextArea() {
		if (lazyClass_TextArea == null) {
			lazyClass_TextArea = new JTextArea();
			lazyClass_TextArea.setBounds(new Rectangle(23, 150, 440, 70));
			lazyClass_TextArea.setBackground(Color.white);
			lazyClass_TextArea.setEditable(false);
			lazyClass_TextArea.setText("A Lazy Class is a class that does too little. In other words" +
					" it is a Class that \ndoesn't justify its existance.");
		}
		return lazyClass_TextArea;
	}

//-----------------------Deep Nesting----------------------------------------------------//

	private JTextArea getDeepNesting_TextArea() {
		if (deepNesting_TextArea == null) {
			deepNesting_TextArea = new JTextArea();
			deepNesting_TextArea.setBounds(new Rectangle(23, 258, 440, 70));
			deepNesting_TextArea.setBackground(Color.white);
			deepNesting_TextArea.setEditable(false);
			deepNesting_TextArea.setText("Deep Nesting refers to when a piece of code is" +
					" nested or indented too much.\nThis may be caused, for example, by " +
					"having loops within loops.");
		}
		return deepNesting_TextArea;
	}

//-----------------------Back Button----------------------------------------------------//

	private JButton getBack_Button() {
		if (back_Button == null) {
			back_Button = new JButton();
			back_Button.setBounds(new Rectangle(204, 575, 94, 30));
			back_Button.setToolTipText("Click to Return Back to Mainscreen");
			back_Button.setText("Back");
			back_Button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MainScreen mainscreen = new MainScreen();
					jFrame.setVisible(false);
					mainscreen.getJFrame().setVisible(true);
				}
			});
		}
		return back_Button;
	}

//-----------------------Excess Commenting----------------------------------------------------//

	private JTextArea getExcessComment_TextArea() {
		if (excessComment_TextArea == null) {
			excessComment_TextArea = new JTextArea();
			excessComment_TextArea.setBounds(new Rectangle(22, 483, 440, 70));
			excessComment_TextArea.setBackground(Color.white);
			excessComment_TextArea.setEditable(false);
			excessComment_TextArea.setText("Excess Commenting is when there is " +
					"too much commenting in a piece of code.\nToo much commenting makes " +
					"the code messy and difficult to read where as \ncomments should help " +
					"others to understand your code.");
		}
		return excessComment_TextArea;
	}

	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CodeSmells application = new CodeSmells();
				application.getJFrame().setVisible(true);

			}
		});
	}

}
