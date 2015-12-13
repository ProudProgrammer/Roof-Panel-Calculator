package tetofedes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class NyeregtetoDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	Tetofedes tulaj;
	
	private static boolean letezikE = false;
	
	private JPanel mainPanel = new JPanel();
	private JPanel settings1Panel = new JPanel();
	private JPanel settings2Panel = new JPanel();
	private JPanel megsemOkPanel = new JPanel();
	
	private OnlyNumberTextField tetoHosszTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField tetoElHosszTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField tetoElMasikHosszTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField lemezHosszTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField lemezHasznosTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField toldasTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField minhosszTF = new OnlyNumberTextField(9);
	
	private JRadioButton nemAzonosRB = new JRadioButton("A tetõélek nem azonosak", true);
	private JRadioButton azonosRB = new JRadioButton("A tetõélek azonosak", false);
	private ButtonGroup szabalyosBG = new ButtonGroup();

	private JRadioButton toldasIgenRB = new JRadioButton("Legyen toldás", true);
	private JRadioButton toldasNemRB = new JRadioButton("Ne legyen toldás", false);
	private ButtonGroup toldasBG = new ButtonGroup();
	
	private JRadioButton minhosszIgenRB = new JRadioButton("Be kell állítani", true);
	private JRadioButton minhosszNemRB = new JRadioButton("Nem kell beállítani", false);
	private ButtonGroup minhosszBG = new ButtonGroup();
	
	private JButton megsemButton = new JButton("Mégsem");
	private JButton okButton = new JButton("Ok");
	
	{
		szabalyosBG.add(nemAzonosRB);
		szabalyosBG.add(azonosRB);
		toldasBG.add(toldasIgenRB);
		toldasBG.add(toldasNemRB);
		minhosszBG.add(minhosszIgenRB);
		minhosszBG.add(minhosszNemRB);
		mainPanel.setLayout(new BorderLayout());
		settings1Panel.setLayout(new GridLayout(7,2));
		settings1Panel.setBorder(BorderFactory.createTitledBorder("Méretek"));
		settings2Panel.setLayout(new GridLayout(3,1));
		megsemOkPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
	}
	
	@SuppressWarnings("serial")
	public NyeregtetoDialog(Frame owner) {
		letezikE = true;
		tulaj = (Tetofedes)owner;
		
		setTitle("Nyeregtetõ");
		setBounds(Tetofedes.middleFramePosition);
		setModal(false);
		setResizable(false);
		
		getContentPane().add(mainPanel);
		
		mainPanel.add(settings1Panel, "West");
		mainPanel.add(settings2Panel, "Center");
		mainPanel.add(megsemOkPanel, "South");
		
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Tetõ hossza:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(tetoHosszTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Tetõél hossza:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(tetoElHosszTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Másik tetõél hossza:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(tetoElMasikHosszTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Lemezek teljes szélessége:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(lemezHosszTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Lemezek hasznos takarása:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(lemezHasznosTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Biztonsági toldás a lemezekhez:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(toldasTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Minimális lemezhosszúság:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(minhosszTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		
		settings2Panel.add(new JPanel() {
			{
				setLayout(new GridLayout(3,1));
				setBorder(BorderFactory.createTitledBorder("A két tetõél azonossága"));
				add(nemAzonosRB);
				add(azonosRB);
			}
		});
		settings2Panel.add(new JPanel() {
			{
				setLayout(new GridLayout(3,1));
				setBorder(BorderFactory.createTitledBorder("Biztonsági toldás a lemezekhez"));
				add(toldasIgenRB);
				add(toldasNemRB);
			}
		});
		settings2Panel.add(new JPanel() {
			{
				setLayout(new GridLayout(3,1));
				setBorder(BorderFactory.createTitledBorder("Minimális lemezhossz beállítása"));
				add(minhosszIgenRB);
				add(minhosszNemRB);
			}
		});
		
		megsemOkPanel.setBorder(BorderFactory.createEtchedBorder());
		megsemOkPanel.add(megsemButton, "South");
		megsemOkPanel.add(okButton, "South");
		
		nemAzonosRB.addActionListener(this);
		azonosRB.addActionListener(this);
		toldasIgenRB.addActionListener(this);
		toldasNemRB.addActionListener(this);
		minhosszIgenRB.addActionListener(this);
		minhosszNemRB.addActionListener(this);
		megsemButton.addActionListener(this);
		okButton.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				letezikE = false;
			}
		});
		
		setVisible(true);
	}

	public static boolean getLetezikE() {
		return letezikE;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == megsemButton) {
			setVisible(false);
			letezikE = false;
		}
		if (e.getSource() == nemAzonosRB) {
			tetoElMasikHosszTF.setEnabled(true);
			return;
		}
		if (e.getSource() == azonosRB) {
			tetoElMasikHosszTF.setEnabled(false);
			return;
		}
		if (e.getSource() == toldasIgenRB)
			toldasTF.setEnabled(true);
		if (e.getSource() == toldasNemRB)
			toldasTF.setEnabled(false);
		if (e.getSource() == minhosszIgenRB)
			minhosszTF.setEnabled(true);
		if (e.getSource() == minhosszNemRB)
			minhosszTF.setEnabled(false);
		if (e.getSource() == okButton) {
			int tetoHossz = 0;
			int tetoElHossz = 0; 
			int tetoElMasikHossz = 0;
			int lemezHossz = 0;
			int lemezHasznos = 0;
			int toldas = 0;
			int minhossz = 0;
			try {
				tetoHossz = Integer.parseInt(tetoHosszTF.getText());
				tetoElHossz = Integer.parseInt(tetoElHosszTF.getText());
				if (tetoElMasikHosszTF.isEnabled())
					tetoElMasikHossz = Integer.parseInt(tetoElMasikHosszTF.getText());
				lemezHossz = Integer.parseInt(lemezHosszTF.getText());
				lemezHasznos = Integer.parseInt(lemezHasznosTF.getText());
				if (toldasTF.isEnabled())
					toldas = Integer.parseInt(toldasTF.getText());
				if (minhosszTF.isEnabled())
					minhossz = Integer.parseInt(minhosszTF.getText());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nHiányzó adat.", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tetoHossz == 0 || tetoElHossz == 0 || (tetoElMasikHosszTF.isEnabled() & tetoElMasikHossz == 0) ||lemezHossz == 0 || lemezHasznos == 0 || (toldasTF.isEnabled() & toldas == 0) || (minhosszTF.isEnabled() & minhossz == 0)) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nA 0 érték nem elfogadható!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(lemezHossz < lemezHasznos) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nA lemezek teljes szélessége nem lehet kisebb, mint a hasznos takarásuk!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tetoElMasikHossz == 0)
				tetoElMasikHossz = tetoElHossz;
			tulaj.setTextNyeregteto(tetoHossz, tetoElHossz, tetoElMasikHossz, lemezHossz, lemezHasznos, toldas, minhossz);
		}
	}
}


