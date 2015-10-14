//This is the ExtendedBoxscore window. It gets called by ScorebarApp.

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;


@SuppressWarnings("unused")
public class ExtendedBoxscore extends JPanel {

	private static final long serialVersionUID = 1L;
	final JLabel lblAwayTeam;
	final JLabel lblAwayScore;
	final JLabel lblHomeName;
	final JLabel lblHOMEScore;
	final JLabel lblHOMEhits;
	final JLabel lblHOMEerrors;
	final JLabel lbl_awayHits;
	final JLabel lbl_awayErrors;
	final JLabel lblTopLine;
	
	//private int awayPosition = -122;
	//private int homePosition = -122;
	private int padding = 5;
	private int inning;
	//int yHeight = 617; //y layout value for text (617 looks right for top line)
	//int yHtBotLine = yHeight + 50;
	GridBagConstraints gbc_lbl_awayHits = new GridBagConstraints();
	GridBagConstraints gbc_lbl_awayErrors = new GridBagConstraints();
	GridBagConstraints gbc_lbl_homeHits = new GridBagConstraints();

	JPanel mainPanel = new JPanel();

	/**
	 * Create the panel.
	 */
	public ExtendedBoxscore(String homeName, String awayName) //constructor///
	{
		setBackground(Color.GREEN);
		setLayout(new GridLayout(0, 1, 0, 0));
		mainPanel.setBackground(Color.GREEN);
		
		mainPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(mainPanel);

		BufferedImage jPic = null;
		try {
			jPic = ImageIO.read(new File("img/7 innings.jpg"));
		} catch (IOException e) {
			//JOptionPane.showMessageDialog(null, "Missing Image Files!");
			e.printStackTrace();
			System.exit(0);
		}
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{129, 1, 0};
		gbl_mainPanel.rowHeights = new int[]{31, 0, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		int difference = 720 - jPic.getHeight();
		//yHeight = yHeight - difference;
		
		JLabel scorebarPic = new JLabel(new ImageIcon( jPic ));
		scorebarPic.setText("");
		GridBagConstraints gbc_scorebarPic = new GridBagConstraints();
		gbc_scorebarPic.insets = new Insets(3, 0, 0, 0);
		gbc_scorebarPic.anchor = GridBagConstraints.NORTHWEST;
		gbc_scorebarPic.gridx = 0;
		gbc_scorebarPic.gridy = 0;
		
		lblTopLine = new JLabel(Integer.toString(inning));
		GridBagConstraints gbc_lbl_TopLine = new GridBagConstraints();
		lblTopLine.setForeground(new Color(0, 0, 0));
		lblTopLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopLine.setVerticalAlignment(SwingConstants.TOP);
		lblTopLine.setFont(new Font("Calibri", Font.PLAIN, 14));
		gbc_lbl_TopLine.ipady = 100;
		gbc_lbl_TopLine.ipadx = 10;
		gbc_lbl_TopLine.insets = new Insets(-130, -310, -10, -10);
		gbc_lbl_TopLine.gridx = 0;
		gbc_lbl_TopLine.gridy = 0;
		mainPanel.add(lblTopLine, gbc_lbl_TopLine);
		
		lblAwayTeam = new JLabel(awayName);
		lblAwayTeam.setForeground(new Color(245, 245, 245));
		lblAwayTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblAwayTeam.setVerticalAlignment(SwingConstants.TOP);
		lblAwayTeam.setFont(new Font("Calibri", Font.PLAIN, 28));
		GridBagConstraints gbc_lblAwayTeam = new GridBagConstraints();
		gbc_lblAwayTeam.ipady = 5;
		gbc_lblAwayTeam.ipadx = padding;
		gbc_lblAwayTeam.insets = new Insets(-15, -300, 5, 5);
		gbc_lblAwayTeam.gridx = 0;
		gbc_lblAwayTeam.gridy = 0;
		mainPanel.add(lblAwayTeam, gbc_lblAwayTeam);
		
		lblAwayScore = new JLabel("0");
		GridBagConstraints gbc_lblAwayScore = new GridBagConstraints();
		lblAwayScore.setForeground(new Color(245, 245, 245));
		lblAwayScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblAwayScore.setVerticalAlignment(SwingConstants.TOP);
		lblAwayScore.setFont(new Font("Calibri", Font.PLAIN, 28));
		gbc_lblAwayScore.ipady = 5;
		gbc_lblAwayScore.ipadx = 5;
		gbc_lblAwayScore.insets = new Insets(-15, -160, 5, 5);
		gbc_lblAwayScore.gridx = 0;
		gbc_lblAwayScore.gridy = 0;
		mainPanel.add(lblAwayScore, gbc_lblAwayScore);
		
		lbl_awayHits = new JLabel("0");
		lbl_awayHits.setForeground(new Color(245, 245, 245));
		lbl_awayHits.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_awayHits.setVerticalAlignment(SwingConstants.TOP);
		lbl_awayHits.setFont(new Font("Calibri", Font.PLAIN, 28));
		gbc_lbl_awayHits.ipady = 5;
		gbc_lbl_awayHits.ipadx = 5;
		gbc_lbl_awayHits.insets = new Insets(-15, -60, 5, 5); //top, by default
		gbc_lbl_awayHits.gridx = 0;
		gbc_lbl_awayHits.gridy = 0;
		mainPanel.add(lbl_awayHits, gbc_lbl_awayHits);
		
		lbl_awayErrors = new JLabel("0");
		lbl_awayErrors.setForeground(new Color(245, 245, 245));
		lbl_awayErrors.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_awayErrors.setVerticalAlignment(SwingConstants.TOP);
		lbl_awayErrors.setFont(new Font("Calibri", Font.PLAIN, 28));
		gbc_lbl_awayErrors.ipady = 5;
		gbc_lbl_awayErrors.ipadx = 5;
		gbc_lbl_awayErrors.insets = new Insets(-15, 9, 5, 5); //top, by default
		gbc_lbl_awayErrors.gridx = 0;
		gbc_lbl_awayErrors.gridy = 0;
		mainPanel.add(lbl_awayErrors, gbc_lbl_awayErrors);
		
		lblHomeName = new JLabel(homeName);
		GridBagConstraints gbc_lblHomeName = new GridBagConstraints();
		lblHomeName.setForeground(new Color(245, 245, 245));
		lblHomeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeName.setVerticalAlignment(SwingConstants.TOP);
		lblHomeName.setFont(new Font("Calibri", Font.PLAIN, 28));
		gbc_lblHomeName.ipady = 5;
		gbc_lblHomeName.ipadx = 5;
		gbc_lblHomeName.insets = new Insets(52, -300, 5, 5);
		gbc_lblHomeName.gridx = 0;
		gbc_lblHomeName.gridy = 0;
		mainPanel.add(lblHomeName, gbc_lblHomeName);
		
		lblHOMEScore = new JLabel("0");
		GridBagConstraints gbc_lblHOMEScore = new GridBagConstraints();
		lblHOMEScore.setForeground(new Color(245, 245, 245));
		lblHOMEScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHOMEScore.setVerticalAlignment(SwingConstants.TOP);
		lblHOMEScore.setFont(new Font("Calibri", Font.PLAIN, 28));
		gbc_lblHOMEScore.ipady = 5;
		gbc_lblHOMEScore.ipadx = 5;
		gbc_lblHOMEScore.insets = new Insets(52, -160, 5, 5);
		gbc_lblHOMEScore.gridx = 0;
		gbc_lblHOMEScore.gridy = 0;
		mainPanel.add(lblHOMEScore, gbc_lblHOMEScore);	
		
		lblHOMEhits = new JLabel("0");
		GridBagConstraints gbc_lbl_homeHits = new GridBagConstraints();
		lblHOMEhits.setForeground(new Color(245, 245, 245));
		lblHOMEhits.setHorizontalAlignment(SwingConstants.CENTER);
		lblHOMEhits.setVerticalAlignment(SwingConstants.TOP);
		lblHOMEhits.setFont(new Font("Calibri", Font.PLAIN, 28));
		gbc_lbl_homeHits.ipady = 5;
		gbc_lbl_homeHits.ipadx = 5;
		gbc_lbl_homeHits.insets = new Insets(52, -60, 5, 5);
		gbc_lbl_homeHits.gridx = 0;
		gbc_lbl_homeHits.gridy = 0;
		mainPanel.add(lblHOMEhits, gbc_lbl_homeHits);
		
		lblHOMEerrors = new JLabel("0");
		GridBagConstraints gbc_lbl_homeErrors = new GridBagConstraints();
		lblHOMEerrors.setForeground(new Color(245, 245, 245));
		lblHOMEerrors.setHorizontalAlignment(SwingConstants.CENTER);
		lblHOMEerrors.setVerticalAlignment(SwingConstants.TOP);
		lblHOMEerrors.setFont(new Font("Calibri", Font.PLAIN, 28));
		gbc_lbl_homeErrors.ipady = 5;
		gbc_lbl_homeErrors.ipadx = 5;
		gbc_lbl_homeErrors.insets = new Insets(52, 9, 5, 5);
		gbc_lbl_homeErrors.gridx = 0;
		gbc_lbl_homeErrors.gridy = 0;
		mainPanel.add(lblHOMEerrors, gbc_lbl_homeErrors);
		
		mainPanel.add(scorebarPic, gbc_scorebarPic);
		
		System.out.println("Enter a password: " + inning);
		InningBox b = new InningBox();
		b.setBackground(Color.GREEN);
		GridBagConstraints gbc_InningBox = new GridBagConstraints();
		gbc_InningBox.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(b, gbc_InningBox);

		InningBox b2 = new InningBox();
		String s = Integer.toString(inning);
		b2.setTopLine(s);
		GridBagConstraints gbc_InningBox2 = new GridBagConstraints();
		gbc_InningBox2.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(b2, gbc_InningBox2);
		
		EndBox endB = new EndBox();
		endB.setBackground(Color.GREEN);
		GridBagConstraints gbc_EndBox = new GridBagConstraints();
		gbc_EndBox.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(endB, gbc_EndBox);
		
		b.updateUI();
		b2.updateUI();
	}

	//function sets the manual text fields
	public void update(String aScore, String aHits, String aErrors, String hScore, String hHits, String hErrors) 
	{	
		//Away Score
		if (!aScore.equals(""))
			lblAwayScore.setText(aScore);
		
		//Away Hits
		if (!aHits.equals(""))
			lbl_awayHits.setText(aHits);
		
		//Away Errors
		if (!aErrors.equals(""))
			lbl_awayErrors.setText(aErrors);
		
		//home score
		if (!hScore.equals(""))
			lblHOMEScore.setText(hScore);
		
		//home hits
		if (!hHits.equals(""))
			lblHOMEhits.setText(hHits);
		
		//home errors
		if (!hErrors.equals(""))
			lblHOMEerrors.setText(hErrors);
			
	}//end update method

	public void updateNames(String aName, String hName) 
	{
		//Away Name
		if (!aName.equals(""))
			lblAwayTeam.setText(aName);
		
		//Home Name
		if (!hName.equals(""))
			lblHomeName.setText(hName);
	}
	
	public void moveAwayTeam(int num)
	{
		padding = padding - num;
	}
	
	public int getAP()
	{
		return padding;
	}
	
	public String getHomeName(){
		return lblHomeName.getText();
	}

	public String getAwayName() {
		return lblAwayTeam.getText();
	}
	
	public void setTopLine(String text) {
		lblTopLine.setText(text);
	}
	
	public void setInning(int i) {
		inning = i;
	}
	
}
