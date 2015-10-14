//This is the main program window

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Checkbox;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.GridBagLayout;


@SuppressWarnings("unused")
public class ScorebarApp extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_Aname;
	private JTextField txtHscore;
	private int SideToSide = 20; //position of scorebug
	private int UpAndDown = 20;
	private int homeNamePosition = 0;

	private JTextField txt_Hname;
	private JTextField txt_hh;
	private JTextField txt_he;
	private JTextField txtAscore;
	private JTextField txt_ah;
	private JTextField txt_ae;
	JRadioButtonMenuItem radioButtonMenuItem_3 = new JRadioButtonMenuItem("0");
	JRadioButtonMenuItem radioButtonMenuItem_4 = new JRadioButtonMenuItem("0");
	JLabel lblHomeRuns = new JLabel("Home");
	JLabel lblAway = new JLabel("Away");
	JButton btnUpdateNames = new JButton("UPDATE NAMES");
	final JRadioButtonMenuItem radioButtonBottomInning = new JRadioButtonMenuItem("Bot");
	final JRadioButtonMenuItem radioButtonMiddleInning = new JRadioButtonMenuItem("Mid");
	final JRadioButtonMenuItem radioButtonEndInning = new JRadioButtonMenuItem("End Of");
	final JRadioButtonMenuItem rdbtnFinal = new JRadioButtonMenuItem("Final");
	final JRadioButtonMenuItem rdbtnDelay = new JRadioButtonMenuItem("Delay");
	final JRadioButtonMenuItem radioButtonBlank = new JRadioButtonMenuItem("Blank");

	final JRadioButtonMenuItem radioButtonMenuItem_10 = new JRadioButtonMenuItem("1");
	JRadioButtonMenuItem radioButtonMenuItem_11 = new JRadioButtonMenuItem("2");
	JRadioButtonMenuItem radioButtonMenuItem_2 = new JRadioButtonMenuItem("1");
	JRadioButtonMenuItem radioButtonMenuItem_1 = new JRadioButtonMenuItem("2");
	final JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem("3");
	JRadioButtonMenuItem radioButtonMenuItem_5 = new JRadioButtonMenuItem("1");
	JRadioButtonMenuItem radioButtonMenuItem_6 = new JRadioButtonMenuItem("2");
	final JRadioButtonMenuItem rdbtnmntmst = new JRadioButtonMenuItem("1st");
	final JRadioButtonMenuItem rdbtnmntmnd = new JRadioButtonMenuItem("2nd");
	JRadioButtonMenuItem rdbtnmntmrd = new JRadioButtonMenuItem("3rd");
	
	private String homeName = "MSUM";
	private String awayName = "AWAY";
	private String balls = "0";
	private String strikes = "0";
	private String outs = "0";
	private String inning = "1";
	private String innings = "1";
	private String hruns = "0";
	private String hhits = "0";
	private String herrors = "0";
	private String aruns = "0";
	private String ahits = "0";
	private String aerrors = "0";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScorebarApp frame = new ScorebarApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScorebarApp() {
		final Scorebar bar = new Scorebar(homeName, awayName, homeNamePosition);
		bar.setMinimumSize(new Dimension(300, 300));
		bar.setMaximumSize(new Dimension(300, 300));
		
		final Scorebox box = new Scorebox(homeName, awayName);
		box.setMinimumSize(new Dimension(300, 300));
		box.setMaximumSize(new Dimension(300, 300));
		
		final ExtendedBoxscore fullBox = new ExtendedBoxscore(homeName, awayName);
		
		ButtonGroup bgInnings = new ButtonGroup();
		ButtonGroup bgOuts = new ButtonGroup();
		ButtonGroup bg = new ButtonGroup();
		ButtonGroup bgStrikes = new ButtonGroup();
		ButtonGroup viewGroup = new ButtonGroup();
		
		setBackground(new Color(0, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 740);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
		final JPanel holder = new JPanel();
		holder.setBackground(Color.ORANGE);
		contentPane.add(holder, BorderLayout.CENTER);
		GridBagLayout gbl_holder = new GridBagLayout();
		gbl_holder.columnWidths = new int[]{0};
		gbl_holder.rowHeights = new int[]{0};
		gbl_holder.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_holder.rowWeights = new double[]{Double.MIN_VALUE};
		holder.setLayout(gbl_holder);
		
		
		JPanel Brdr_Pnl = new JPanel();
		Brdr_Pnl.setBackground(new Color(0, 255, 0));
		contentPane.add(Brdr_Pnl, BorderLayout.NORTH);
		Brdr_Pnl.setLayout(new BorderLayout(0, 0));
		
		JPanel Grid = new JPanel();
		Grid.setBackground(new Color(0, 255, 0));
		Grid.setMinimumSize(new Dimension(10, 7));
		Brdr_Pnl.add(Grid, BorderLayout.WEST);
		Grid.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel row3 = new JPanel();
		row3.setBackground(new Color(0, 255, 0));
		row3.setBorder(null);
		FlowLayout fl_row3 = (FlowLayout) row3.getLayout();
		fl_row3.setAlignment(FlowLayout.LEFT);
		fl_row3.setVgap(0);
		Grid.add(row3);
		
		JPanel Count = new JPanel();
		Count.setBackground(new Color(0, 255, 0));
		Count.setBorder(new LineBorder(new Color(0, 0, 0)));
		row3.add(Count);
		Count.setLayout(new GridLayout(7, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout_7 = (FlowLayout) panel_5.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		Count.add(panel_5);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblInning = new JLabel("INNING:");
		lblInning.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblInning);
		
		SpinnerModel model = new SpinnerNumberModel(1, 1, 99, 1); //default, floor, ceiling, step
	    final JSpinner spinner = new JSpinner(model);
	    spinner.setEditor(new JSpinner.DefaultEditor(spinner));
		spinner.setRequestFocusEnabled(false);
		spinner.setFocusable(false);
		spinner.setFocusTraversalKeysEnabled(false);
		spinner.setPreferredSize(new Dimension(45, 28));
		panel_5.add(spinner);
		
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				bar.updateInning(spinner.getValue().toString());
				innings = spinner.getValue().toString();
				fullBox.setInning((Integer) spinner.getValue());
				fullBox.setTopLine(spinner.getValue().toString());
			}
					});
			
		final JRadioButtonMenuItem radioButtonTopInning = new JRadioButtonMenuItem("Top");
		radioButtonTopInning.setBackground(Color.YELLOW);
		radioButtonTopInning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bar.topInning();
				bar.updateUI();
				
				if(radioButtonTopInning.isSelected())
				{
					radioButtonTopInning.setBackground(Color.yellow);
					radioButtonBottomInning.setBackground(Color.white);
					radioButtonMiddleInning.setBackground(Color.white);
					radioButtonEndInning.setBackground(Color.white);
					rdbtnFinal.setBackground(Color.white);
					rdbtnDelay.setBackground(Color.white);
					radioButtonBlank.setBackground(Color.white);
					
					bar.showInning();
					innings = spinner.getValue().toString();
					box.setTopLine("TOP OF " + innings);
				}

			}
		});
		radioButtonTopInning.setPreferredSize(new Dimension(50, 19));
		panel_5.add(radioButtonTopInning);
		radioButtonTopInning.setSelected(true);
		
		radioButtonBottomInning.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(radioButtonBottomInning.isSelected()){
					bar.botInning();
					radioButtonTopInning.setBackground(Color.white);
					radioButtonBottomInning.setBackground(Color.yellow);
					radioButtonMiddleInning.setBackground(Color.white);
					radioButtonEndInning.setBackground(Color.white);
					rdbtnFinal.setBackground(Color.white);
					rdbtnDelay.setBackground(Color.white);
					radioButtonBlank.setBackground(Color.white);
					bar.showBotInning();
					innings = spinner.getValue().toString();
					box.setTopLine("BOT OF " + innings);

				}
				bar.updateUI();
			}
		});
		radioButtonBottomInning.setPreferredSize(new Dimension(48, 19));
		panel_5.add(radioButtonBottomInning);
		bgInnings.add(radioButtonBottomInning);
		bgInnings.add(radioButtonTopInning);
		radioButtonMiddleInning.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(radioButtonMiddleInning.isSelected())
				{
					radioButtonTopInning.setBackground(Color.white);
					radioButtonBottomInning.setBackground(Color.white);
					radioButtonMiddleInning.setBackground(Color.yellow);
					radioButtonEndInning.setBackground(Color.white);
					rdbtnFinal.setBackground(Color.white);
					rdbtnDelay.setBackground(Color.white);
					radioButtonBlank.setBackground(Color.white);
					innings = spinner.getValue().toString();
					box.setTopLine("MIDDLE OF " + innings);
				}
			}
		});
		
		radioButtonMiddleInning.setPreferredSize(new Dimension(48, 19));
		panel_5.add(radioButtonMiddleInning);
		bgInnings.add(radioButtonMiddleInning);
		radioButtonEndInning.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(radioButtonEndInning.isSelected())
				{
					radioButtonTopInning.setBackground(Color.white);
					radioButtonBottomInning.setBackground(Color.white);
					radioButtonMiddleInning.setBackground(Color.white);
					radioButtonEndInning.setBackground(Color.yellow);
					rdbtnFinal.setBackground(Color.white);
					rdbtnDelay.setBackground(Color.white);
					radioButtonBlank.setBackground(Color.white);
					innings = spinner.getValue().toString();
					box.setTopLine("END OF " + innings);
				}
			}
		});
		
		radioButtonEndInning.setPreferredSize(new Dimension(70, 19));
		panel_5.add(radioButtonEndInning);
		bgInnings.add(radioButtonEndInning);
		rdbtnFinal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnFinal.isSelected())
				{
					radioButtonTopInning.setBackground(Color.white);
					radioButtonBottomInning.setBackground(Color.white);
					radioButtonMiddleInning.setBackground(Color.white);
					radioButtonEndInning.setBackground(Color.white);
					rdbtnFinal.setBackground(Color.yellow);
					rdbtnDelay.setBackground(Color.white);
					radioButtonBlank.setBackground(Color.white);
					
					box.setTopLine("FINAL");
				}
			}
		});
		
		rdbtnFinal.setPreferredSize(new Dimension(56, 19));
		panel_5.add(rdbtnFinal);
		bgInnings.add(rdbtnFinal);

		rdbtnDelay.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnDelay.isSelected())
				{
					radioButtonTopInning.setBackground(Color.white);
					radioButtonBottomInning.setBackground(Color.white);
					radioButtonMiddleInning.setBackground(Color.white);
					radioButtonEndInning.setBackground(Color.white);
					rdbtnFinal.setBackground(Color.white);
					rdbtnDelay.setBackground(Color.yellow);
					radioButtonBlank.setBackground(Color.white);
					
					box.setTopLine("DELAY");
				}
			}
		});
		
		rdbtnDelay.setPreferredSize(new Dimension(61, 19));
		panel_5.add(rdbtnDelay);
		bgInnings.add(rdbtnDelay);

		radioButtonBlank.setPreferredSize(new Dimension(61, 19));
		panel_5.add(radioButtonBlank);
		bgInnings.add(radioButtonBlank);
		
		radioButtonBlank.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(radioButtonBlank.isSelected())
				{
					radioButtonTopInning.setBackground(Color.white);
					radioButtonBottomInning.setBackground(Color.white);
					radioButtonMiddleInning.setBackground(Color.white);
					radioButtonEndInning.setBackground(Color.white);
					rdbtnFinal.setBackground(Color.white);
					rdbtnDelay.setBackground(Color.white);
					radioButtonBlank.setBackground(Color.yellow);
					
					bar.blankInning();
					
					box.setTopLine("");
				}
			}
		});

		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout_4 = (FlowLayout) panel_10.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		Count.add(panel_10);
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("RUNNERS:");
		panel_10.add(lblNewLabel);
		
		final JRadioButtonMenuItem rdbtnmntmBasesEmpty = new JRadioButtonMenuItem("Bases Empty");
		rdbtnmntmBasesEmpty.setBackground(Color.YELLOW);
		rdbtnmntmBasesEmpty.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if (rdbtnmntmBasesEmpty.isSelected()){
					bar.basesEmpty();
					rdbtnmntmBasesEmpty.setBackground(Color.YELLOW);
				}
				
				rdbtnmntmst.setSelected(false);
				rdbtnmntmst.setBackground(Color.white);
				rdbtnmntmnd.setSelected(false);
				rdbtnmntmnd.setBackground(Color.white);
				rdbtnmntmrd.setSelected(false);
				rdbtnmntmrd.setBackground(Color.white);
			}
		});
		rdbtnmntmBasesEmpty.setPreferredSize(new Dimension(111, 19));
		rdbtnmntmBasesEmpty.setSelected(true);
		panel_10.add(rdbtnmntmBasesEmpty);
				rdbtnmntmst.setPreferredSize(new Dimension(50, 19));
				
				rdbtnmntmst.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						if (!rdbtnmntmst.isSelected()){
							bar.oneb_off();
							rdbtnmntmst.setBackground(Color.white);
						}
						else
						{
							bar.onebON();

							rdbtnmntmBasesEmpty.setSelected(false);
							rdbtnmntmst.setSelected(true);
							
							if(!rdbtnmntmBasesEmpty.isSelected())
								rdbtnmntmBasesEmpty.setBackground(Color.white);
							
							rdbtnmntmst.setBackground(Color.yellow);
							
							if(!rdbtnmntmnd.isSelected())
								rdbtnmntmnd.setBackground(Color.white);
							if(!rdbtnmntmrd.isSelected())
								rdbtnmntmrd.setBackground(Color.white);
						}
					}
				});
				panel_10.add(rdbtnmntmst);
				
				rdbtnmntmnd.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						if (!rdbtnmntmnd.isSelected()){
							bar.twob_off();

							rdbtnmntmnd.setBackground(Color.white);
						}
						else
						{
							bar.twobON();

							rdbtnmntmBasesEmpty.setSelected(false);
							rdbtnmntmnd.setSelected(true);
							
							if(!rdbtnmntmBasesEmpty.isSelected())
								rdbtnmntmBasesEmpty.setBackground(Color.white);
							
							if (!rdbtnmntmst.isSelected())
								rdbtnmntmst.setBackground(Color.white);
							
							rdbtnmntmnd.setBackground(Color.yellow);
							
							if(!rdbtnmntmnd.isSelected())
								rdbtnmntmnd.setBackground(Color.white);
						}
					}
				});
				rdbtnmntmnd.setPreferredSize(new Dimension(50, 19));
				panel_10.add(rdbtnmntmnd);
				
				rdbtnmntmrd.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						if (!rdbtnmntmrd.isSelected()){
							bar.threeb_off();

							rdbtnmntmrd.setBackground(Color.white);
						}
						else
						{
							bar.threebON();

							rdbtnmntmBasesEmpty.setSelected(false);
							rdbtnmntmrd.setSelected(true);
							
							if(!rdbtnmntmBasesEmpty.isSelected())
								rdbtnmntmBasesEmpty.setBackground(Color.white);
							
							if(!rdbtnmntmst.isSelected())
								rdbtnmntmst.setBackground(Color.white);
							
							if(!rdbtnmntmst.isSelected())
								rdbtnmntmst.setBackground(Color.white);
							
							rdbtnmntmrd.setBackground(Color.yellow);
						}
					}
				});
				rdbtnmntmrd.setPreferredSize(new Dimension(50, 19));
				panel_10.add(rdbtnmntmrd);
		
		JPanel Outs = new JPanel();
		Outs.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout_3 = (FlowLayout) Outs.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		Count.add(Outs);
		Outs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblOuts = new JLabel("OUTS:");
		Outs.add(lblOuts);
		
		final JRadioButtonMenuItem radioButtonMenuItem_9 = new JRadioButtonMenuItem("0");
		radioButtonMenuItem_9.setBackground(Color.YELLOW);
		radioButtonMenuItem_9.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(radioButtonMenuItem_9.isSelected()){
					bar.no_out();

					radioButtonMenuItem_9.setBackground(Color.yellow);
					radioButtonMenuItem_10.setBackground(Color.white);
					radioButtonMenuItem_11.setBackground(Color.white);			
				}
			}
		});
		radioButtonMenuItem_9.setPreferredSize(new Dimension(44, 19));
		radioButtonMenuItem_9.setSelected(true);
		Outs.add(radioButtonMenuItem_9);
		
		radioButtonMenuItem_10.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(radioButtonMenuItem_10.isSelected()){
					bar.one_out();
					
					radioButtonMenuItem_9.setBackground(Color.white);
					radioButtonMenuItem_10.setBackground(Color.yellow);
					radioButtonMenuItem_11.setBackground(Color.white);
				}
			}
		});
		radioButtonMenuItem_10.setPreferredSize(new Dimension(44, 19));
		Outs.add(radioButtonMenuItem_10);
		
		radioButtonMenuItem_11.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bar.two_out();
				radioButtonMenuItem_9.setBackground(Color.white);
				radioButtonMenuItem_10.setBackground(Color.WHITE);
				radioButtonMenuItem_11.setBackground(Color.yellow);
			}
		});
		radioButtonMenuItem_11.setPreferredSize(new Dimension(44, 19));
		Outs.add(radioButtonMenuItem_11);
		bgOuts.add(radioButtonMenuItem_9);		
		bgOuts.add(radioButtonMenuItem_10);		
		bgOuts.add(radioButtonMenuItem_11);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		Count.add(panel_7);
		
		JLabel lblBalls = new JLabel("BALLS:");
		panel_7.add(lblBalls);
		radioButtonMenuItem_3.setBackground(Color.YELLOW);
		radioButtonMenuItem_3.setPreferredSize(new Dimension(44, 19));
		panel_7.add(radioButtonMenuItem_3);
		
		radioButtonMenuItem_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bar.balls("0");
				
				radioButtonMenuItem_3.setBackground(Color.yellow);
				radioButtonMenuItem_2.setBackground(Color.white);
				radioButtonMenuItem_1.setBackground(Color.white);
				radioButtonMenuItem.setBackground(Color.white);
			}
		});
		radioButtonMenuItem_3.setSelected(true);
		bg.add(radioButtonMenuItem_3);
		
		radioButtonMenuItem_2.setPreferredSize(new Dimension(44, 19));
		panel_7.add(radioButtonMenuItem_2);
		radioButtonMenuItem_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bar.balls("1");
				radioButtonMenuItem_3.setBackground(Color.white);
				radioButtonMenuItem_2.setBackground(Color.yellow);
				radioButtonMenuItem_1.setBackground(Color.white);
				radioButtonMenuItem.setBackground(Color.white);

			}
		});
		bg.add(radioButtonMenuItem_2);
		
		radioButtonMenuItem_1.setPreferredSize(new Dimension(44, 19));
		panel_7.add(radioButtonMenuItem_1);
		radioButtonMenuItem_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bar.balls("2");
				radioButtonMenuItem_3.setBackground(Color.white);
				radioButtonMenuItem_2.setBackground(Color.white);
				radioButtonMenuItem_1.setBackground(Color.yellow);
				radioButtonMenuItem.setBackground(Color.white);
			}
		});
		bg.add(radioButtonMenuItem_1);
		
		radioButtonMenuItem.setPreferredSize(new Dimension(44, 19));
		panel_7.add(radioButtonMenuItem);
		radioButtonMenuItem.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bar.balls("3");
				radioButtonMenuItem_3.setBackground(Color.white);
				radioButtonMenuItem_2.setBackground(Color.white);
				radioButtonMenuItem_1.setBackground(Color.white);
				radioButtonMenuItem.setBackground(Color.yellow);
				}
		});
		
		bg.add(radioButtonMenuItem);
		
		JButton btnResetTo = new JButton("RESET (0-0)");
		panel_7.add(btnResetTo);
		btnResetTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bar.countReset();
				radioButtonMenuItem_3.setSelected(true);
				radioButtonMenuItem_4.setSelected(true);
			}
		});
		btnResetTo.setFocusable(false);
		
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout_10 = (FlowLayout) panel_8.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		Count.add(panel_8);
		
		JLabel label_4 = new JLabel("STRIKES:");
		panel_8.add(label_4);
		radioButtonMenuItem_4.setBackground(Color.YELLOW);
		radioButtonMenuItem_4.setPreferredSize(new Dimension(44, 19));
		panel_8.add(radioButtonMenuItem_4);
		radioButtonMenuItem_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bar.strikes("0");
				radioButtonMenuItem_4.setBackground(Color.yellow);
				radioButtonMenuItem_5.setBackground(Color.white);
				radioButtonMenuItem_6.setBackground(Color.white);
			}
		});
		radioButtonMenuItem_4.setSelected(true);
		bgStrikes.add(radioButtonMenuItem_4);
		
		radioButtonMenuItem_5.setPreferredSize(new Dimension(44, 19));
		panel_8.add(radioButtonMenuItem_5);
		radioButtonMenuItem_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bar.strikes("1");
				radioButtonMenuItem_4.setBackground(Color.white);
				radioButtonMenuItem_5.setBackground(Color.yellow);
				radioButtonMenuItem_6.setBackground(Color.white);
			}
		});
		bgStrikes.add(radioButtonMenuItem_5);
		
		radioButtonMenuItem_6.setPreferredSize(new Dimension(44, 19));
		panel_8.add(radioButtonMenuItem_6);
		radioButtonMenuItem_6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bar.strikes("2");
				radioButtonMenuItem_4.setBackground(Color.white);
				radioButtonMenuItem_5.setBackground(Color.white);
				radioButtonMenuItem_6.setBackground(Color.yellow);
			}
		});
		bgStrikes.add(radioButtonMenuItem_6);
		
		JButton btnHideBalls = new JButton("HIDE COUNT");
		panel_8.add(btnHideBalls);
		btnHideBalls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bar.countOFF();
			}
		});
		btnHideBalls.setFocusable(false);
		
		JButton btnShowCount = new JButton("SHOW COUNT");
		btnShowCount.setFocusable(false);
		btnShowCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bar.countON();
			}
		});
		panel_8.add(btnShowCount);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout_9 = (FlowLayout) panel_15.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		Count.add(panel_15);
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		lblAway.setText(bar.getAwayName());
		lblAway.setHorizontalAlignment(SwingConstants.LEFT);
		lblAway.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		panel_15.add(lblAway);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout_1 = (FlowLayout) panel_13.getLayout();
		flowLayout_1.setHgap(11);
		panel_15.add(panel_13);
		
		JLabel label_9 = new JLabel("RUNS:");
		panel_15.add(label_9);
		
		txtAscore = new JTextField("0");
		txtAscore.setColumns(3);
		panel_15.add(txtAscore);
		
		JLabel label_10 = new JLabel("HITS:");
		panel_15.add(label_10);
		
		txt_ah = new JTextField("0");
		txt_ah.setColumns(3);
		panel_15.add(txt_ah);
		
		JLabel label_11 = new JLabel("ERRORS:");
		panel_15.add(label_11);
		
		txt_ae = new JTextField("0");
		txt_ae.setColumns(3);
		panel_15.add(txt_ae);
		
		final JLabel lblAway_1 = new JLabel("(0,0,0)");
		panel_15.add(lblAway_1);
		
		lblHomeRuns.setText(bar.getHomeName());
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout_8 = (FlowLayout) panel_4.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		Count.add(panel_4);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		

		panel_4.add(lblHomeRuns);
		lblHomeRuns.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(211, 211, 211));
		panel_4.add(panel_14);
		FlowLayout flowLayout_2 = (FlowLayout) panel_14.getLayout();
		flowLayout_2.setHgap(11);
		
		JLabel label_2 = new JLabel("RUNS:");
		panel_4.add(label_2);
		
		txtHscore = new JTextField("0");
		panel_4.add(txtHscore);
		txtHscore.setColumns(3);
		
		JLabel label_3 = new JLabel("HITS:");
		panel_4.add(label_3);
		
		txt_hh = new JTextField("0");
		panel_4.add(txt_hh);
		txt_hh.setColumns(3);
		
		JLabel label_5 = new JLabel("ERRORS:");
		panel_4.add(label_5);
		
		txt_he = new JTextField("0");
		panel_4.add(txt_he);
		txt_he.setColumns(3);
		
		final JLabel lblHome = new JLabel("(0,0,0)");
		panel_4.add(lblHome);
		Brdr_Pnl.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtHscore}));
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtHscore}));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(0, 255, 0));
		row3.add(panel_12);
		panel_12.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(211, 211, 211));
		panel_12.add(panel_11);
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		FlowLayout flowLayout_5 = (FlowLayout) panel_11.getLayout();
		flowLayout_5.setHgap(0);
		
		JLabel lblMoveBug = new JLabel(" Move Bug: ");
		panel_11.add(lblMoveBug);
		
		JButton btnL = new JButton("L");
		btnL.setFocusable(false);
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SideToSide > 0)
					SideToSide -= 5;
				bar.setLayout(new FlowLayout(FlowLayout.LEFT, SideToSide, UpAndDown));
				//bar.moveAwayTeam();
				bar.updateUI();
			}
		});
		btnL.setPreferredSize(new Dimension(30, 29));
		btnL.setRequestFocusEnabled(false);
		panel_11.add(btnL);
		
		JButton btnR = new JButton("R");
		btnR.setFocusable(false);
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SideToSide < contentPane.getWidth() - 216) //216 is the size of the JPEG
					SideToSide += 5;
				bar.setLayout(new FlowLayout(FlowLayout.LEFT, SideToSide, UpAndDown));
				bar.updateUI();
			}
		});
		btnR.setPreferredSize(new Dimension(30, 29));
		panel_11.add(btnR);
		
		JButton btnU = new JButton("U");
		btnU.setFocusable(false);
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpAndDown += 5;
				bar.setLayout(new FlowLayout(FlowLayout.LEFT, SideToSide, UpAndDown));
				bar.updateUI();
			}
		});
		btnU.setPreferredSize(new Dimension(30, 29));
		panel_11.add(btnU);
		
		JButton btnD = new JButton("D");
		btnD.setFocusable(false);
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(UpAndDown > 0)
					UpAndDown -= 5;
				bar.setLayout(new FlowLayout(FlowLayout.LEFT, SideToSide, UpAndDown));
				bar.updateUI();
			}
		});
		btnD.setPreferredSize(new Dimension(30, 29));
		panel_11.add(btnD);
		
		JButton button_9 = new JButton("RESET POSITION");
		button_9.setFocusable(false);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpAndDown = 20;
				SideToSide = 20;
				bar.setLayout(new FlowLayout(FlowLayout.LEFT, SideToSide, UpAndDown));
				bar.updateUI();
			}
		});
		panel_11.add(button_9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(211, 211, 211));
		panel_12.add(panel_2);
		panel_2.setFocusable(false);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setMinimumSize(new Dimension(10, 4));
		panel_2.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		
		JLabel lblAwayName = new JLabel(" Away Name:  ");
		panel_1.add(lblAwayName);
		lblAwayName.setFocusable(false);
		lblAwayName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txt_Aname = new JTextField();
		txt_Aname.setBackground(Color.LIGHT_GRAY);
		txt_Aname.setFocusable(false);
		panel_1.add(txt_Aname);
		txt_Aname.setColumns(4);
		
		JButton btnL_1 = new JButton("L");
		btnL_1.setEnabled(false);
		panel_1.add(btnL_1);
		btnL_1.setFocusable(false);
		btnL_1.setPreferredSize(new Dimension(30, 29));
		btnL_1.setMaximumSize(new Dimension(30, 29));
		btnL_1.setMinimumSize(new Dimension(30, 29));
		
		JButton btnR_1 = new JButton("R");
		btnR_1.setEnabled(false);
		panel_1.add(btnR_1);
		btnR_1.setFocusable(false);
		btnR_1.setPreferredSize(new Dimension(30, 29));
		btnL_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				homeNamePosition -= 10;
//				final Scorebar bar = new Scorebar(homeName, awayName, homeNamePosition);	
//				contentPane.add(bar, BorderLayout.SOUTH);
//				bar.setLayout(new FlowLayout(FlowLayout.LEFT, SideToSide, UpAndDown));	
//				bar.setVisible(false);
//				bar.setVisible(true);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel_2.add(panel);
		
		final JCheckBox chckbxCheckToSet = new JCheckBox("CHECK TO SET NAMES");
		panel.add(chckbxCheckToSet);
		chckbxCheckToSet.setFocusable(false);
		chckbxCheckToSet.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(chckbxCheckToSet.isSelected()){
					txt_Aname.setFocusable(true);
					txt_Hname.setFocusable(true);
					
					txt_Aname.setEditable(true);
					txt_Hname.setEditable(true);
					
					txt_Aname.setBackground(Color.white);
					txt_Hname.setBackground(Color.white);
					
					txt_Aname.requestFocus();
					
					btnUpdateNames.setEnabled(true);
					
				}
				else
				{				
					txt_Aname.setFocusable(false);
					txt_Hname.setFocusable(false);
					txt_Aname.setEditable(false);
					txt_Hname.setEditable(false);
					txt_Aname.setBackground(Color.LIGHT_GRAY);
					txt_Hname.setBackground(Color.LIGHT_GRAY);
								
					chckbxCheckToSet.setSelected(false);
					btnUpdateNames.setEnabled(false);
				}
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		
		JLabel lblHomeName = new JLabel(" Home Name: ");
		panel_3.add(lblHomeName);
		lblHomeName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txt_Hname = new JTextField();
		txt_Hname.setBackground(Color.LIGHT_GRAY);
		txt_Hname.setFocusable(false);
		panel_3.add(txt_Hname);
		txt_Hname.setColumns(4);
		
		JButton btnL_2 = new JButton("L");
		btnL_2.setEnabled(false);
		panel_3.add(btnL_2);
		btnL_2.setFocusable(false);
		btnL_2.setPreferredSize(new Dimension(30, 29));
		
		JButton btnR_2 = new JButton("R");
		btnR_2.setEnabled(false);
		panel_3.add(btnR_2);
		btnR_2.setFocusable(false);
		btnR_2.setPreferredSize(new Dimension(30, 29));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_9);
		panel_9.add(btnUpdateNames);
		
		btnUpdateNames.setEnabled(false);
		btnUpdateNames.setFocusable(false);
		btnUpdateNames.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnUpdateNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bar.updateNames(txt_Aname.getText(), txt_Hname.getText());
				box.updateNames(txt_Aname.getText(), txt_Hname.getText());

				lblHomeRuns.setText(bar.getHomeName());
				lblAway.setText(bar.getAwayName());
				
				txt_Aname.setFocusable(false);
				txt_Hname.setFocusable(false);
				txt_Aname.setEditable(false);
				txt_Hname.setEditable(false);
				txt_Aname.setBackground(Color.LIGHT_GRAY);
				txt_Hname.setBackground(Color.LIGHT_GRAY);
								
				chckbxCheckToSet.setSelected(false);
				btnUpdateNames.setEnabled(false);

			}
		});
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(211, 211, 211));
		panel_12.add(panel_6);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(211, 211, 211));
		panel_6.add(panel_16);
		
		JLabel lblView = new JLabel("View:");
		panel_16.add(lblView);
		
		final JRadioButton rdbtnBug = new JRadioButton("Bug");
		panel_16.add(rdbtnBug);
		rdbtnBug.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnBug.isSelected()){
					contentPane.add(bar, BorderLayout.SOUTH);
					bar.setLayout(new FlowLayout(FlowLayout.LEFT, SideToSide, UpAndDown));	
					
					bar.setVisible(true);
					bar.updateUI();
					box.setVisible(false);
					fullBox.setVisible(false);
				}
			}
		});
		rdbtnBug.setFocusable(false);
		rdbtnBug.setSelected(true);
		viewGroup.add(rdbtnBug);
		
		final JRadioButton rdbtnBoxscore = new JRadioButton("Box Score");
		panel_16.add(rdbtnBoxscore);
		rdbtnBoxscore.setFocusable(false);
		
		viewGroup.add(rdbtnBoxscore);
		
		final JRadioButton rdbtnFullBoxScore = new JRadioButton("Full Box Score");
		panel_16.add(rdbtnFullBoxScore);
		viewGroup.add(rdbtnFullBoxScore);
		
		rdbtnBoxscore.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnBoxscore.isSelected()) {
					contentPane.add(box, BorderLayout.SOUTH);
					box.setLayout(new FlowLayout(FlowLayout.LEFT, SideToSide+2, UpAndDown+2));
					box.setVisible(false);
					
					box.setVisible(true);
					box.updateUI();
					bar.setVisible(false);
					fullBox.setVisible(false);
				}
			}
		});
		
		rdbtnFullBoxScore.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e2) {
				if(rdbtnFullBoxScore.isSelected()) {
					fullBox.setInning((Integer) spinner.getValue());
					fullBox.setTopLine(spinner.getValue().toString());
					fullBox.updateUI();
					
					

					GridBagConstraints gbc_InningBox2 = new GridBagConstraints();
					gbc_InningBox2.insets = new Insets(0, 0, 0, 0);
					holder.add(fullBox, gbc_InningBox2);
					
					InningBox b2 = new InningBox();
					b2.setTopLine(spinner.getValue().toString());
					GridBagConstraints gbc_InningBox1 = new GridBagConstraints();
					gbc_InningBox1.insets = new Insets(0, 0, 0, 0);
					holder.add(b2, gbc_InningBox1);
					b2.setLayout(new FlowLayout(FlowLayout.LEFT, SideToSide, UpAndDown));
					b2.updateUI();

					
					fullBox.setLayout(new FlowLayout(FlowLayout.LEFT, SideToSide, UpAndDown));
					
					fullBox.setVisible(true);
					fullBox.updateUI();
					
					
					box.setVisible(false);
					bar.setVisible(false);
				}
			}
		});
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(211, 211, 211));
		panel_6.add(panel_17);
		
		JButton btnUpdateInfo = new JButton("UPDATE INFO");
		panel_17.add(btnUpdateInfo);
		btnUpdateInfo.setFocusable(false);
		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				bar.update(txtAscore.getText(), txtHscore.getText(), spinner.getValue().toString() );
				
				if(!txtHscore.getText().equals(""))
					hruns = txtHscore.getText();
				
				if(!txt_hh.getText().equals(""))
				hhits = txt_hh.getText();
				
				if(!txt_he.getText().equals(""))
				herrors = txt_he.getText();
				
				if(!txtAscore.getText().equals(""))
				aruns = txtAscore.getText();
				
				if(!txt_ah.getText().equals(""))
				ahits = txt_ah.getText();
				
				if(!txt_ae.getText().equals(""))
				aerrors = txt_ae.getText();
				
				lblAway_1.setText("("+aruns+","+ahits+","+aerrors+")");
				lblHome.setText("("+hruns+","+hhits+","+herrors+")");

				box.update(aruns, ahits, aerrors, hruns, hhits, herrors);
				
				innings = spinner.getValue().toString();
				
				if(radioButtonTopInning.isSelected())
					box.setTopLine("TOP OF " + innings);
				
				if(radioButtonBottomInning.isSelected())
					box.setTopLine("BOT OF " + innings);
				
				if(radioButtonMiddleInning.isSelected())
					box.setTopLine("MIDDLE OF " + innings);
				
				if(radioButtonEndInning.isSelected())
					box.setTopLine("END OF " + innings);
				
				fullBox.setInning((Integer) spinner.getValue());
				fullBox.updateUI();
				fullBox.setTopLine(spinner.getValue().toString());
				
			}
		});
		btnUpdateInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnUpdateInfo.setBackground(Color.LIGHT_GRAY);
		rootPane.setDefaultButton(btnUpdateInfo);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
