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
import java.awt.Dimension;
import java.awt.ComponentOrientation;


@SuppressWarnings("unused")
public class InningBox extends JPanel {

	private static final long serialVersionUID = 1L;
	final JLabel lblAwayScore;
	final JLabel lblHOMEScore;
	final JLabel lblTopLine;
	
	//private int awayPosition = -122;
	//private int homePosition = -122;
	private int padding = 5;
	//int yHeight = 617; //y layout value for text (617 looks right for top line)
	//int yHtBotLine = yHeight + 50;
	GridBagConstraints gbc_lbl_awayHits = new GridBagConstraints();
	GridBagConstraints gbc_lbl_awayErrors = new GridBagConstraints();
	GridBagConstraints gbc_lbl_homeHits = new GridBagConstraints();

	JPanel mainPanel = new JPanel();

	/**
	 * Create the panel.
	 */
	public InningBox() //constructor///
	{
		//setSize(new Dimension(42, 84));
		//setMaximumSize(new Dimension(42, 84));
		setBackground(Color.GREEN);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		mainPanel.setBackground(Color.GREEN);
		
		mainPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(mainPanel);

		BufferedImage jPic = null;
		try {
			jPic = ImageIO.read(new File("img/single_inning.jpg"));
		} catch (IOException e) {
			//JOptionPane.showMessageDialog(null, "Missing Image Files!");
			e.printStackTrace();
			System.exit(0);
		}
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{42, 0, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0};
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
		
//		String s = Integer.toString(inning);
		lblTopLine = new JLabel("99");
		GridBagConstraints gbc_lbl_TopLine = new GridBagConstraints();
		lblTopLine.setForeground(new Color(0, 0, 0));
		lblTopLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopLine.setVerticalAlignment(SwingConstants.TOP);
		lblTopLine.setFont(new Font("Calibri", Font.PLAIN, 14));
		gbc_lbl_TopLine.ipady = 50;
		gbc_lbl_TopLine.ipadx = 10;
		gbc_lbl_TopLine.insets = new Insets(-130, 0, 0, 0);
		gbc_lbl_TopLine.gridx = 0;
		gbc_lbl_TopLine.gridy = 0;
		mainPanel.add(lblTopLine, gbc_lbl_TopLine);
		
		lblAwayScore = new JLabel("0");
		GridBagConstraints gbc_lblAwayScore = new GridBagConstraints();
		lblAwayScore.setForeground(new Color(245, 245, 245));
		lblAwayScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblAwayScore.setVerticalAlignment(SwingConstants.TOP);
		lblAwayScore.setFont(new Font("Calibri", Font.PLAIN, 28));
		gbc_lblAwayScore.ipady = 0;
		gbc_lblAwayScore.ipadx = 0;
		gbc_lblAwayScore.insets = new Insets(-30, 0, 0, 0);
		gbc_lblAwayScore.gridx = 0;
		gbc_lblAwayScore.gridy = 0;
		mainPanel.add(lblAwayScore, gbc_lblAwayScore);
		
		lblHOMEScore = new JLabel("0");
		GridBagConstraints gbc_lblHOMEScore = new GridBagConstraints();
		lblHOMEScore.setForeground(new Color(245, 245, 245));
		lblHOMEScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHOMEScore.setVerticalAlignment(SwingConstants.TOP);
		lblHOMEScore.setFont(new Font("Calibri", Font.PLAIN, 28));
		gbc_lblHOMEScore.ipady = 8;
		gbc_lblHOMEScore.ipadx = 0;
		gbc_lblHOMEScore.insets = new Insets(49, 0, 5, 0);
		gbc_lblHOMEScore.gridx = 0;
		gbc_lblHOMEScore.gridy = 0;
		mainPanel.add(lblHOMEScore, gbc_lblHOMEScore);	
		
		mainPanel.add(scorebarPic, gbc_scorebarPic);
		
	}

	//function sets the manual text fields
	public void update(String aScore, String hScore) 
	{	
		//Away Score
		if (!aScore.equals(""))
			lblAwayScore.setText(aScore);
		
		//home score
		if (!hScore.equals(""))
			lblHOMEScore.setText(hScore);

	}//end update method
	
	public void moveAwayTeam(int num)
	{
		padding = padding - num;
	}
	
	public int getAP()
	{
		return padding;
	}
	
	public void setTopLine(String text) {
		lblTopLine.setText(text);
		System.out.println("Inningbox.java");
	}
	
}
