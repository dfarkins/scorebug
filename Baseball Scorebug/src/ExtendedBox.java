//This is the scorebar window. It gets called by ScorebarApp

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


@SuppressWarnings("unused")
public class ExtendedBox extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblAwayTeam;
	JLabel lblAwayScore;
	JLabel lblHomeName;
	JLabel lblHOMEScore;
	JLabel lblCount;
	JLabel lbl_Inning;
	JLabel lbl_inningArrow;
	
	private int awayPosition = -122;
	private int homePosition = -122;
	private int padding = 5;
	int yHeight = 617; //y layout value for text (617 looks right for top line)
	//int yHtBotLine = yHeight + 50;
	private String balls = "0";
	private String strikes = "0";
	GridBagConstraints gbc_lbl_Inning = new GridBagConstraints();
	JPanel mainPanel = new JPanel();
	private JLabel lblInningBOt;
	private JLabel lbl_outs;
	private JLabel lblb;
	private JLabel lblb_1;
	private JLabel lblb_2;


	/**
	 * Create the panel.
	 */
	public ExtendedBox(String homeName, String awayName, int hPosition) //constructor///
	{
		setBackground(new Color(0, 255, 0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		mainPanel.setBackground(new Color(0, 255, 0));
		
		
		mainPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(mainPanel);

		BufferedImage jPic = null;
		try {
			jPic = ImageIO.read(new File("img/Bug.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Missing Image Files.");
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
		yHeight = yHeight - difference;
		
		JLabel scorebarPic = new JLabel(new ImageIcon( jPic ));
		scorebarPic.setText("");
		GridBagConstraints gbc_scorebarPic = new GridBagConstraints();
		gbc_scorebarPic.insets = new Insets(0, 0, 5, 5);
		gbc_scorebarPic.anchor = GridBagConstraints.NORTHWEST;
		gbc_scorebarPic.gridx = 0;
		gbc_scorebarPic.gridy = 0;
		
		lblAwayTeam = new JLabel(awayName);
		lblAwayTeam.setForeground(new Color(245, 245, 245));
		lblAwayTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblAwayTeam.setVerticalAlignment(SwingConstants.TOP);
		lblAwayTeam.setFont(new Font("Calibri", Font.PLAIN, 28));
		GridBagConstraints gbc_lblAwayTeam = new GridBagConstraints();
		gbc_lblAwayTeam.ipady = 5;
		gbc_lblAwayTeam.ipadx = padding;
		gbc_lblAwayTeam.insets = new Insets(-35, awayPosition+hPosition, 5, 5);
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
		gbc_lblAwayScore.insets = new Insets(-35, 9, 5, 5);
		gbc_lblAwayScore.gridx = 0;
		gbc_lblAwayScore.gridy = 0;
		mainPanel.add(lblAwayScore, gbc_lblAwayScore);
		
		lbl_Inning = new JLabel("1");
		lbl_Inning.setForeground(new Color(255, 215, 0));
		lbl_Inning.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Inning.setVerticalAlignment(SwingConstants.TOP);
		lbl_Inning.setFont(new Font("Calibri", Font.PLAIN, 20));
		gbc_lbl_Inning.ipady = 5;
		gbc_lbl_Inning.ipadx = 5;
		gbc_lbl_Inning.insets = new Insets(-30, 89, 5, 5); //top, by default
		gbc_lbl_Inning.gridx = 0;
		gbc_lbl_Inning.gridy = 0;
		mainPanel.add(lbl_Inning, gbc_lbl_Inning);
		
		lblInningBOt = new JLabel("1");
		lblInningBOt.setVisible(false);
		lblInningBOt.setVerticalAlignment(SwingConstants.TOP);
		lblInningBOt.setHorizontalAlignment(SwingConstants.CENTER);
		lblInningBOt.setForeground(new Color(255, 215, 0));
		lblInningBOt.setFont(new Font("Calibri", Font.PLAIN, 20));
		GridBagConstraints gbc_lblInningBOt = new GridBagConstraints();
		gbc_lblInningBOt.ipady = 5;
		gbc_lblInningBOt.ipadx = 5;
		gbc_lblInningBOt.insets = new Insets(-36, 90, 5, 5); //top, by default
		gbc_lblInningBOt.gridx = 0;
		gbc_lblInningBOt.gridy = 0;
		mainPanel.add(lblInningBOt, gbc_lblInningBOt);
		
		
		lblHomeName = new JLabel(homeName);
		GridBagConstraints gbc_lblHomeName = new GridBagConstraints();
		lblHomeName.setForeground(new Color(245, 245, 245));
		lblHomeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeName.setVerticalAlignment(SwingConstants.TOP);
		lblHomeName.setFont(new Font("Calibri", Font.PLAIN, 28));
		gbc_lblHomeName.ipady = 5;
		gbc_lblHomeName.ipadx = 5;
		gbc_lblHomeName.insets = new Insets(36, homePosition+hPosition, 5, 5);
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
		gbc_lblHOMEScore.insets = new Insets(36, 9, 5, 5);
		gbc_lblHOMEScore.gridx = 0;
		gbc_lblHOMEScore.gridy = 0;
		mainPanel.add(lblHOMEScore, gbc_lblHOMEScore);
		
		lblCount = new JLabel(balls + "\u2013" + strikes);
		GridBagConstraints gbc_lblCount = new GridBagConstraints();
		lblCount.setForeground(new Color(245, 245, 245));
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setVerticalAlignment(SwingConstants.TOP);
		lblCount.setFont(new Font("Calibri", Font.PLAIN, 20));
		gbc_lblCount.ipady = 5;
		gbc_lblCount.ipadx = 5;	
		gbc_lblCount.insets = new Insets(39, 90, 5, 5);
		gbc_lblCount.gridx = 0;
		gbc_lblCount.gridy = 0;
		mainPanel.add(lblCount, gbc_lblCount);
		
		lbl_inningArrow = new JLabel("");
		lbl_inningArrow.setIcon(new ImageIcon("img/Up.png")); //by default
		lbl_inningArrow.setEnabled(true);
		GridBagConstraints gbc_lbl_inningArrow = new GridBagConstraints();
		//lblPlayClock.setForeground(Color.YELLOW);
		lbl_inningArrow.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_inningArrow.setVerticalAlignment(SwingConstants.TOP);
		//lblPlayClock.setFont(new Font("Impact", Font.BOLD, 22));
		gbc_lbl_inningArrow.ipady = 5;
		gbc_lbl_inningArrow.ipadx = 5;
		gbc_lbl_inningArrow.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_inningArrow.gridx = 0;
		gbc_lbl_inningArrow.gridy = 0;
		mainPanel.add(lbl_inningArrow, gbc_lbl_inningArrow);
		
		lbl_outs = new JLabel("");
		lbl_outs.setVisible(false); //by default
		lbl_outs.setIcon(new ImageIcon("img/1out.png")); //by default
		GridBagConstraints gbc_lbl_outs = new GridBagConstraints();
		gbc_lbl_outs.insets = new Insets(-4, -9, 5, 0);
		gbc_lbl_outs.gridx = 0;
		gbc_lbl_outs.gridy = 0;
		mainPanel.add(lbl_outs, gbc_lbl_outs);
		
		lblb = new JLabel("");
		lblb.setVisible(false);
		lblb.setIcon(new ImageIcon("img/1b.png")); //by default
		GridBagConstraints gbc_lblb = new GridBagConstraints();
		gbc_lblb.insets = new Insets(-4, -9, 5, 0);
		gbc_lblb.gridx = 0;
		gbc_lblb.gridy = 0;
		mainPanel.add(lblb, gbc_lblb);
		
		lblb_1 = new JLabel("");
		lblb_1.setVisible(false);
		lblb_1.setIcon(new ImageIcon("img/2b.png")); //by default
		GridBagConstraints gbc_lblb_1 = new GridBagConstraints();
		gbc_lblb_1.insets = new Insets(-4, -9, 5, 0);
		gbc_lblb_1.gridx = 0;
		gbc_lblb_1.gridy = 0;
		mainPanel.add(lblb_1, gbc_lblb_1);
		
		lblb_2 = new JLabel("");
		lblb_2.setVisible(false);
		lblb_2.setIcon(new ImageIcon("img/3b.png")); //by default
		GridBagConstraints gbc_lblb_2 = new GridBagConstraints();
		gbc_lblb_2.insets = new Insets(-4, -9, 5, 0);
		gbc_lblb_2.gridx = 0;
		gbc_lblb_2.gridy = 0;
		mainPanel.add(lblb_2, gbc_lblb_2);
		
		mainPanel.add(scorebarPic, gbc_scorebarPic);
	}

	//function sets the manual text fields
	public void update(String aScore, String hScore, String inning) 
	{	
		//Away Score
		if (!aScore.equals(""))
			lblAwayScore.setText(aScore);
		
		//home score
		if (!hScore.equals(""))
			lblHOMEScore.setText(hScore);
		
		//inning
		if (!inning.equals("")){
			lbl_Inning.setText(inning);
			lblInningBOt.setText(inning);
			
		}
		
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
	
	public void moveAwayTeam()
	{	
		padding -= 1;
		awayPosition -= 1;
		
		GridBagConstraints gbc_lblAwayTeam = new GridBagConstraints();
		gbc_lblAwayTeam.insets = new Insets(-35, awayPosition, 5, 5);
		
		this.updateUI();
		
		if(this.isVisible())
			this.setVisible(false);
		else
			this.setVisible(true);
	}
	
	public int getAP()
	{
		return padding;
	}

	public void topInning() {
		lbl_inningArrow.setIcon(new ImageIcon("img/Up.png"));
		lblInningBOt.setVisible(false);
		lbl_Inning.setVisible(true);
		//gbc_lbl_Inning.insets = new Insets(yHeight, 90, top, 0);
	}
	
	public void botInning() {
		lbl_inningArrow.setIcon(new ImageIcon("img/down.png"));
		lblInningBOt.setVisible(true);
		lbl_Inning.setVisible(false);
		//lbl_Inning.setLocation(lbl_Inning.getX(), lbl_Inning.getY()-5);
	}

	public void one_out() {
		lbl_outs.setIcon(new ImageIcon("img/1out.png"));
		lbl_outs.setVisible(true);
	}

	public void no_out() {
		lbl_outs.setVisible(false);		
	}

	public void two_out() {
		lbl_outs.setIcon(new ImageIcon("img/2outs.png"));
		lbl_outs.setVisible(true);
	}

	public void basesEmpty() {
		lblb_1.setVisible(false);
		lblb_2.setVisible(false);
		lblb.setVisible(false);
	}

	public void oneb_off() {
		lblb.setVisible(false);
	}

	public void onebON() {
		lblb.setVisible(true);
	}

	public void twob_off() {
		lblb_1.setVisible(false);
	}

	public void twobON() {
		lblb_1.setVisible(true);		
	}

	public void threeb_off() {
		lblb_2.setVisible(false);		
	}
	
	public void threebON() {
		lblb_2.setVisible(true);		
	}

	public void countOFF() {
		lblCount.setVisible(false);
	}

	public void countReset() {
		balls = "0";
		strikes = "0";
		lblCount.setText(balls + "\u2013" + strikes);
	}

	public void balls(String b) {
		balls = b;
		lblCount.setText(balls + "\u2013" + strikes);
	}
	
	public void strikes(String s) {
		strikes = s;
		lblCount.setText(balls + "\u2013" + strikes);
	}
	
	public String getHomeName(){
		return lblHomeName.getText();
	}

	public String getAwayName() {
		return lblAwayTeam.getText();
	}

	public void countON() {
		lblCount.setVisible(true);		
	}
	
	public void blankInning() {
		lbl_Inning.setVisible(false);	
		lbl_inningArrow.setVisible(false);		
	}
	
	public void showInning() {
		lbl_Inning.setVisible(true);	
		lbl_inningArrow.setVisible(true);		
	}
	
	public void showBotInning() {
		lblInningBOt.setVisible(true);	
		lbl_inningArrow.setVisible(true);		
	}
	
}
