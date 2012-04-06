package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Utils.Configurations;

import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;


/**
 * @author Computard
 * GUI for user to put in settings.
 */

public class Config {

	private JFrame jFrameConfig = null;  //  @jve:decl-index=0:visual-constraint="10,54"
	private JPanel jContentPane = null;
	private JButton return_Button = null;
	private JButton save_Button = null;
	private JButton default_Button = null;
	private JLabel max_Lines_Class_Label = null;
	private JLabel max_Lines_Method_Label = null;
	private JPanel bloaterJPanel = null;
	private JPanel lazyClassJPanel = null;
	private JPanel godClassJPanel = null;
	private JTextField maxMethodLinesJTextField = null;
	private JTextField maxClassLinesJTextField = null;
	private JPanel ButtonsjPanel = null;
	private JPanel mainJPanel;
	private JLabel LazyMinClassLengthLabel = null;
	private JLabel LazyMinMethodsInClassLabel = null;
	private JTextField MinClassLengthTextField = null;
	private JTextField MinAmountMethodsClassTextField = null;
	private JPanel ExcessCommentingPanel = null;
	private JLabel ExcessCommentingClassLabel = null;
	private JLabel ExcessCommentingMethodLabel = null;
	private JTextField ExcessCommentClassTextField = null;
	private JTextField ExcessCommentMethodTextField = null;
	private JLabel ratioLabel = null;
	private JLabel ratio2Label = null;
	private JPanel DeepNestingPanel = null;
	private JLabel NestingLevelClassLabel = null;
	private JLabel NestingLevelMethodLabel = null;
	private JTextField NestingLevelClassTextField = null;
	private JTextField NestingLevelMethodTextField = null;
	private JLabel godclassLabel = null;
	private JLabel godclass2Label = null;
	private JTextField godclassTextField = null;
	private JLabel godclass3Label = null;
	
	private int bloaterMaxClassLength = 0;
	private int bloaterMaxMethodLength = 0;
	private int lazyClassMinClassLength = 0;
	private int lazyClassMinMethodsInClass = 0;
	private float excessCommentClass = 0;
	private float excessCommentMethod = 0;
	private int deepNestingLevelClass = 0;
	private int deepNestingLevelMethod = 0;
	private int godClass = 0;
	
	/**
	 * Constructor
	 */
	public Config(){
		// Set bloater values
		setBloaterClassLength(Configurations.getBloaterMaxClassLength());
		setBloaterMethodLength(Configurations.getBloaterMaxMethodLength());
		
		// Set god value
		setGodclass(Configurations.getGodWorkAmount());
		
		// Set lazy class values
		setLazyClassMinClassLength(Configurations.getLazyClassMinLength());
		setLazyClassMinMethodsInClass(Configurations.getLazyMinMethodCount());
		
		// Set Excessive Commenting
		setExcessCommentClass(Configurations.getMaxClassCommentingRatio());
		setExcessCommentMethod(Configurations.getMaxMethodCommentingRatio());
		
		// Set Deep Nesting
		setDeepNestingLevelClass(Configurations.getMaxClassNesting());
		setDeepNestingLevelMethod(Configurations.getMaxMethodNesting());
		
		getJFrame().setVisible(true);
	}




	//getters
	public int getBloaterClassLength(){return bloaterMaxClassLength;}
	public int getBloaterMethodLength(){return bloaterMaxMethodLength;}
	/**
	 * @return the excessCommentClass
	 */
	public float getExcessCommentClass() {return excessCommentClass;}
	/**
	 * @return the excessCommentMethod
	 */
	public float getExcessCommentMethod() {return excessCommentMethod;}
	/**
	 * @return the deepNestingLevelClass
	 */
	public int getDeepNestingLevelClass() {return deepNestingLevelClass;}
	/**
	 * @return the deepNestingLevelMethod
	 */
	public int getDeepNestingLevelMethod() {return deepNestingLevelMethod;}
	/**
	 * @return the godclass
	 */
	public int getGodclass() {return godClass;}
	/**
	 * @return the lazyClassMinClassLength
	 */
	public int getLazyClassMinClassLength() {return lazyClassMinClassLength;}
	/**
	 * @return the lazyClassMinMethodsInClass
	 */
	public int getLazyClassMinMethodsInClass() {return lazyClassMinMethodsInClass;}

	
	//setters
	public void setBloaterClassLength(int length){bloaterMaxClassLength = length;}
	public void setBloaterMethodLength(int length){bloaterMaxMethodLength = length;}
	/**
	 * @param f the excessCommentClass to set
	 */
	public void setExcessCommentClass(float f) {
		this.excessCommentClass = f;
	}
	/**
	 * @param f the excessCommentMethod to set
	 */
	public void setExcessCommentMethod(float f) {
		this.excessCommentMethod = f;
	}
	/**
	 * @param deepNestingLevelClass the deepNestingLevelClass to set
	 */
	public void setDeepNestingLevelClass(int deepNestingLevelClass) {
		this.deepNestingLevelClass = deepNestingLevelClass;
	}
	/**
	 * @param deepNestingLevelMethod the deepNestingLevelMethod to set
	 */
	public void setDeepNestingLevelMethod(int deepNestingLevelMethod) {
		this.deepNestingLevelMethod = deepNestingLevelMethod;
	}
	/**
	 * @param godclass the godclass to set
	 */
	public void setGodclass(int godclass) {
		this.godClass = godclass;
	}
	/**
	 * @param lazyClassMinClassLength the lazyClassMinClassLength to set
	 */
	public void setLazyClassMinClassLength(int lazyClassMinClassLength) {
		this.lazyClassMinClassLength = lazyClassMinClassLength;
	}
	/**
	 * @param lazyClassMinMethodsInClass the lazyClassMinMethodsInClass to set
	 */
	public void setLazyClassMinMethodsInClass(int lazyClassMinMethodsInClass) {
		this.lazyClassMinMethodsInClass = lazyClassMinMethodsInClass;
	}


	
	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	JFrame getJFrame() {
		if (jFrameConfig == null) {
			jFrameConfig = new JFrame();
			jFrameConfig.setResizable(false);
			jFrameConfig.setSize(473, 663);
			jFrameConfig.setLocationRelativeTo(null);
			jFrameConfig.setContentPane(getJContentPane());
			jFrameConfig.setTitle("Configuration");
		}
		return jFrameConfig;
	}

	//-----------------------------------------JPanels--------------------------------------------//

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(Color.white);
			jContentPane.add(getMainJPanel());
			jContentPane.add(getButtonsjPanel(), null);
		}
		return jContentPane;
	}

	private JPanel getMainJPanel() {
		if (mainJPanel == null) {
			mainJPanel = new JPanel();
			mainJPanel.setLayout(new BoxLayout(mainJPanel, BoxLayout.Y_AXIS));
			mainJPanel.setBounds(new Rectangle(30, 20, 400, 530));
			mainJPanel.add(getBloaterJPanel(), getBloaterJPanel().getName());
			mainJPanel.add(getPrimitiveObsessionJPanel());
			mainJPanel.add(getLazyClassJPanel(), getLazyClassJPanel().getName());
			mainJPanel.add(getExcessCommentingPanel(), null);
			mainJPanel.add(getDeepNestingPanel(), null);
		}
		return mainJPanel;
	}
	
	private JPanel getPrimitiveObsessionJPanel(){
		if(godClassJPanel == null){
			godclass3Label = new JLabel();
			godclass3Label.setBounds(new Rectangle(155, 31, 209, 21));
			godclass3Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
			godclass3Label.setText("times the amount of methods or work");
			godclass2Label = new JLabel();
			godclass2Label.setBounds(new Rectangle(16, 60, 364, 21));
			godclass2Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
			godclass2Label.setText("than any other Class, it is considered to be a God Class.");
			godclassLabel = new JLabel();

			godclassLabel.setBounds(new Rectangle(16, 31, 87, 21));
			godclassLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			godclassLabel.setBounds(new Rectangle(14, 29, 88, 21));

			godclassLabel.setText("If a Class has ");
			godClassJPanel = new JPanel();
			godClassJPanel.setBorder(new TitledBorder("God Class:"));
			godClassJPanel.setLayout(null);
			godClassJPanel.setBackground(Color.white);
			godClassJPanel.add(godclassLabel, null);
			godClassJPanel.add(godclass2Label, null);
			godClassJPanel.add(getGodclassTextField(), null);
			godClassJPanel.add(godclass3Label, null);
		}
		return godClassJPanel;
	}

	private JPanel getLazyClassJPanel(){
		if(lazyClassJPanel == null){
			LazyMinMethodsInClassLabel = new JLabel();
			LazyMinMethodsInClassLabel.setBounds(new Rectangle(16, 60, 278, 27));
			LazyMinMethodsInClassLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			LazyMinMethodsInClassLabel.setText("Set the Minimum Amount of Methods per Class:");
			LazyMinClassLengthLabel = new JLabel();
			LazyMinClassLengthLabel.setBounds(new Rectangle(16, 32, 230, 23));
			LazyMinClassLengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			LazyMinClassLengthLabel.setText("Set the Minimum Class Length:");
			lazyClassJPanel = new JPanel();
			lazyClassJPanel.setSize(397, 121);
			lazyClassJPanel.setLayout(null);
			lazyClassJPanel.setBorder(new TitledBorder("Lazy Class:"));
			lazyClassJPanel.setBackground(Color.white);
			lazyClassJPanel.add(LazyMinClassLengthLabel, null);
			lazyClassJPanel.add(LazyMinMethodsInClassLabel, null);
			lazyClassJPanel.add(getMinClassLengthTextField(), null);
			lazyClassJPanel.add(getMinAmountMethodsClassTextField(), null);
		}
		return lazyClassJPanel;
	}

	private JPanel getBloaterJPanel(){
		if(bloaterJPanel == null){
			bloaterJPanel = new JPanel();
			bloaterJPanel.setLayout(null);
			bloaterJPanel.setBorder(new TitledBorder("Bloater Settings:"));
			bloaterJPanel.setBackground(Color.white);
			bloaterJPanel.add(getMaxMethodLinesJTextField(), null);
			bloaterJPanel.add(getMaxClassLinesJTextField(), null);
			bloaterJPanel.add(getMax_Lines_Method_Label(), null);
			bloaterJPanel.add(getMax_Lines_Class_Label(), null);
		}
		return bloaterJPanel;
	}
	
	/**
	 * This method initializes ButtonsjPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getButtonsjPanel() {
		if (ButtonsjPanel == null) {
			ButtonsjPanel = new JPanel();
			ButtonsjPanel.setLayout(null);
			ButtonsjPanel.setBounds(new Rectangle(30, 544, 400, 67));
			ButtonsjPanel.setBackground(Color.white);
			ButtonsjPanel.add(getSave_button());
			ButtonsjPanel.add(getReturn_Button());
			ButtonsjPanel.add(getClear_Button());
		}
		return ButtonsjPanel;
	}



	//-----------------------------------------JTextFields----------------------------------------//

	/**
	 * This method initializes maxClassLinesJTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMaxClassLinesJTextField() {
		if (maxClassLinesJTextField == null) {
			maxClassLinesJTextField = new JTextField(Integer.toString(bloaterMaxClassLength));
			maxClassLinesJTextField.setHorizontalAlignment(SwingConstants.CENTER);
			maxClassLinesJTextField.setBounds(new Rectangle(275, 30, 50, 22));
		}
		return maxClassLinesJTextField;
	}


	/**
	 * This method initializes maxMethodLinesJTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMaxMethodLinesJTextField() {
		if (maxMethodLinesJTextField == null) {
			maxMethodLinesJTextField = new JTextField(Integer.toString(bloaterMaxMethodLength));
			maxMethodLinesJTextField.setHorizontalAlignment(SwingConstants.CENTER);
			maxMethodLinesJTextField.setBounds(new Rectangle(275, 65, 50, 22));
		}
		return maxMethodLinesJTextField;
	}
	
	//-----------------------------------------JLabels--------------------------------------------//
	
	private JLabel getMax_Lines_Method_Label(){
		if(max_Lines_Method_Label == null){
			max_Lines_Method_Label = new JLabel();
			max_Lines_Method_Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
			max_Lines_Method_Label.setText("Set the Maximum Amount of Lines in a Class:");
			max_Lines_Method_Label.setBounds(new Rectangle(31, 30, 234, 25));
		}
		return max_Lines_Method_Label;
	}
	
	private JLabel getMax_Lines_Class_Label(){
		if(max_Lines_Class_Label == null){
			max_Lines_Class_Label = new JLabel();
			max_Lines_Class_Label.setText("Set the Maximum Amount of Lines in a Method:");
			max_Lines_Class_Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
			max_Lines_Class_Label.setBounds(new Rectangle(31, 65, 234, 25));
		}
		return max_Lines_Class_Label;
	}

	
	//-----------------------------------------JButtons-------------------------------------------//
	
	/**
	 * This method initializes clear_Button	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getClear_Button() {
		if (default_Button == null) {
			default_Button = new JButton();
			default_Button.setLocation(275, 31);
			default_Button.setSize(80, 25);
			default_Button.setToolTipText("Clear Current settings");
			default_Button.setText("Default");
			default_Button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					maxMethodLinesJTextField.setText("10"); 
					maxClassLinesJTextField.setText("20"); 
					godclassTextField.setText("2");
					ExcessCommentMethodTextField.setText("3");
					ExcessCommentClassTextField.setText("5");
					NestingLevelClassTextField.setText("8");
					NestingLevelMethodTextField.setText("4");
					MinClassLengthTextField.setText("10");
					MinAmountMethodsClassTextField.setText("5");
				}
			});
		}
		return default_Button;
	}
	
	/**
	 * This method initializes save_button
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getSave_button() {
		if (save_Button == null) {
			save_Button = new JButton();
			save_Button.setSize(80, 25);
			save_Button.setLocation(44, 31);
			save_Button.setText("Save");
			save_Button.setToolTipText("Save Settings");
			save_Button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
		 
					if(intCheck(getMaxClassLinesJTextField().getText()) && 
							intCheck(getMaxMethodLinesJTextField().getText()) &&
							intCheck(getGodclassTextField().getText()) &&
							intCheck(getNestingLevelMethodTextField().getText()) &&
							intCheck(getNestingLevelClassTextField().getText()) &&
							intCheck(getMinClassLengthTextField().getText()) &&
							intCheck(getMinAmountMethodsClassTextField().getText())
					){
						setBloaterClassLength(Integer.parseInt(maxClassLinesJTextField.getText()));  // Update MaxClassLength with the text in the textbox.
						setBloaterMethodLength(Integer.parseInt(maxMethodLinesJTextField.getText()));  // Update MaxMethodLength with the text in the textbox.
						setExcessCommentClass(Float.parseFloat(ExcessCommentClassTextField.getText()));
						setExcessCommentMethod(Float.parseFloat(ExcessCommentMethodTextField.getText()));
						setDeepNestingLevelClass(Integer.parseInt(NestingLevelClassTextField.getText()));
						setDeepNestingLevelMethod(Integer.parseInt(NestingLevelMethodTextField.getText()));
						setGodclass(Integer.parseInt(godclassTextField.getText()));
						setLazyClassMinClassLength(Integer.parseInt(MinClassLengthTextField.getText()));
						setLazyClassMinMethodsInClass(Integer.parseInt(MinAmountMethodsClassTextField.getText()));
						
						if(bloaterMaxClassLength < bloaterMaxMethodLength){
							JOptionPane.showMessageDialog(null, "The value you entered for Max Method Length is larger than the Value you entered for Max Class Length.");
						} else{
							// Pass on the value to the Configurations class
							Configurations.setBloaterMaxClassLength(bloaterMaxClassLength); 
							Configurations.setBloaterMaxMethodLength(bloaterMaxMethodLength);
							Configurations.setMaxClassCommentingRatio(excessCommentClass);
							Configurations.setMaxMethodCommentingRatio(excessCommentMethod);
							Configurations.setNestingLevelClass(deepNestingLevelClass);
							Configurations.setNestingLevelMethod(deepNestingLevelMethod);
							Configurations.setGodWorkAmount(godClass);
							Configurations.setMinLazyClassLength(lazyClassMinClassLength);
							Configurations.setMinLazyMethods(lazyClassMinMethodsInClass);

							// Save the values to a file
							Configurations.saveConfig();

							jFrameConfig.setVisible(false);
						}

					} else{
						JOptionPane.showMessageDialog(null, "The values you entered are not numbers.");
					}					
				}
			});
		}
		return save_Button;
	}

	/**
	 * This method initializes Return_button
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getReturn_Button() {
		if (return_Button == null) {
			return_Button = new JButton();
			return_Button.setLocation(157, 31);
			return_Button.setSize(80, 25);
			return_Button.setText("Cancel");
			return_Button.setToolTipText("Click to Return to the Mainscreen");
			return_Button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFrameConfig.dispose();
				}
			});
		}
		return return_Button;
	}

	
	//-----------------------------------------Other Methods-------------------------------------------//

	private boolean intCheck(String test) {
		// Checks if a textfield is an int.
		try {
			Integer.parseInt(test);
			return true;
		} catch (NumberFormatException nfe) {
			System.out.println("etst");
			return false;
		}
	}

	/**
	 * This method initializes MinClassLengthTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMinClassLengthTextField() {
		if (MinClassLengthTextField == null) {
			MinClassLengthTextField = new JTextField(Integer.toString(lazyClassMinClassLength));
			MinClassLengthTextField.setHorizontalAlignment(SwingConstants.CENTER);
			MinClassLengthTextField.setBounds(new Rectangle(275, 30, 50, 22));
		}
		return MinClassLengthTextField;
	}

	/**
	 * This method initializes MinAmountMethodsClassTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMinAmountMethodsClassTextField() {
		if (MinAmountMethodsClassTextField == null) {
			MinAmountMethodsClassTextField = new JTextField(Integer.toString(lazyClassMinMethodsInClass));
			MinAmountMethodsClassTextField.setHorizontalAlignment(SwingConstants.CENTER);
			MinAmountMethodsClassTextField.setBounds(new Rectangle(275, 65, 50, 22));
		}
		return MinAmountMethodsClassTextField;
	}

	/**
	 * This method initializes ExcessCommentingPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getExcessCommentingPanel() {

		if (ExcessCommentingPanel == null) {
			ratio2Label = new JLabel();
			ratio2Label.setBounds(new Rectangle(327, 62, 73, 24));
			ratio2Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
			ratio2Label.setText(" : 1 (Ratio)");
			ratioLabel = new JLabel();
			ratioLabel.setBounds(new Rectangle(327, 29, 73, 24));
			ratioLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			ratioLabel.setText(" : 1 (Ratio)");
			ExcessCommentingMethodLabel = new JLabel();
			ExcessCommentingMethodLabel.setBounds(new Rectangle(16, 63, 234, 23));
			ExcessCommentingMethodLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			ExcessCommentingMethodLabel.setText("Set Excessive Commenting in a Method:");
			ExcessCommentingClassLabel = new JLabel();
			ExcessCommentingClassLabel.setBounds(new Rectangle(16, 29, 222, 25));
			ExcessCommentingClassLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			ExcessCommentingClassLabel.setText("Set Excessive Commenting in a Class:");
			ExcessCommentingPanel = new JPanel();
			ExcessCommentingPanel.setBorder(new TitledBorder("Excess Commenting:"));
			ExcessCommentingPanel.setLayout(null);
			ExcessCommentingPanel.setBackground(Color.white);
			ExcessCommentingPanel.add(ExcessCommentingClassLabel, null);
			ExcessCommentingPanel.add(ExcessCommentingMethodLabel, null);
			ExcessCommentingPanel.add(getExcessCommentClassTextField(), null);
			ExcessCommentingPanel.add(getExcessCommentMethodTextField(), null);
			ExcessCommentingPanel.add(ratioLabel, null);
			ExcessCommentingPanel.add(ratio2Label, null);
		}
		return ExcessCommentingPanel;
	}

	/**
	 * This method initializes ExcessCommentClassTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getExcessCommentClassTextField() {
		if (ExcessCommentClassTextField == null) {
			ExcessCommentClassTextField = new JTextField(Float.toString(excessCommentClass));
			ExcessCommentClassTextField.setHorizontalAlignment(SwingConstants.CENTER);
			ExcessCommentClassTextField.setBounds(new Rectangle(275, 30, 50, 22));
		}
		return ExcessCommentClassTextField;
	}

	/**
	 * This method initializes ExcessCommentMethodTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getExcessCommentMethodTextField() {
		if (ExcessCommentMethodTextField == null) {
			ExcessCommentMethodTextField = new JTextField(Float.toString(excessCommentMethod));
			ExcessCommentMethodTextField.setHorizontalAlignment(SwingConstants.CENTER);
			ExcessCommentMethodTextField.setBounds(new Rectangle(275, 63, 50, 22));
		}
		return ExcessCommentMethodTextField;
	}

	/**
	 * This method initializes DeepNestingPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getDeepNestingPanel() {
		if (DeepNestingPanel == null) {
			NestingLevelMethodLabel = new JLabel();
			NestingLevelMethodLabel.setBounds(new Rectangle(18, 64, 199, 24));
			NestingLevelMethodLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			NestingLevelMethodLabel.setText("Set the Nesting Level in a  Method:");
			NestingLevelClassLabel = new JLabel();
			NestingLevelClassLabel.setBounds(new Rectangle(18, 29, 188, 25));
			NestingLevelClassLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			NestingLevelClassLabel.setText("Set the Nesting Level in a Class:");
			DeepNestingPanel = new JPanel();
			DeepNestingPanel.setBorder(new TitledBorder("Deep Nesting:"));
			DeepNestingPanel.setLayout(null);
			DeepNestingPanel.setBackground(Color.white);
			DeepNestingPanel.add(NestingLevelClassLabel, null);
			DeepNestingPanel.add(NestingLevelMethodLabel, null);
			DeepNestingPanel.add(getNestingLevelClassTextField(), null);
			DeepNestingPanel.add(getNestingLevelMethodTextField(), null);
		}
		return DeepNestingPanel;
	}

	/**
	 * This method initializes NestingLevelClassTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNestingLevelClassTextField() {
		if (NestingLevelClassTextField == null) {
			NestingLevelClassTextField = new JTextField(Integer.toString(deepNestingLevelClass));
			NestingLevelClassTextField.setHorizontalAlignment(SwingConstants.CENTER);
			NestingLevelClassTextField.setBounds(new Rectangle(275, 30, 50, 22));
		}
		return NestingLevelClassTextField;
	}

	/**
	 * This method initializes NestingLevelMethodTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNestingLevelMethodTextField() {
		if (NestingLevelMethodTextField == null) {
			NestingLevelMethodTextField = new JTextField(Integer.toString(deepNestingLevelMethod));
			NestingLevelMethodTextField.setHorizontalAlignment(SwingConstants.CENTER);
			NestingLevelMethodTextField.setBounds(new Rectangle(275, 65, 50, 22));
		}
		return NestingLevelMethodTextField;
	}

	/**
	 * This method initializes godclassTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getGodclassTextField() {
		if (godclassTextField == null) {
			godclassTextField = new JTextField(Integer.toString(godClass));

			godclassTextField.setHorizontalAlignment(SwingConstants.CENTER);
			godclassTextField.setBounds(new Rectangle(102, 31, 50, 22));

			godclassTextField.setBounds(new Rectangle(102, 31, 32, 18));

		}
		return godclassTextField;
	}



}