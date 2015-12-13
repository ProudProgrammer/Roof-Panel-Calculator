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
	
	private JRadioButton nemAzonosRB = new JRadioButton("A tet��lek nem azonosak", true);
	private JRadioButton azonosRB = new JRadioButton("A tet��lek azonosak", false);
	private ButtonGroup szabalyosBG = new ButtonGroup();

	private JRadioButton toldasIgenRB = new JRadioButton("Legyen told�s", true);
	private JRadioButton toldasNemRB = new JRadioButton("Ne legyen told�s", false);
	private ButtonGroup toldasBG = new ButtonGroup();
	
	private JRadioButton minhosszIgenRB = new JRadioButton("Be kell �ll�tani", true);
	private JRadioButton minhosszNemRB = new JRadioButton("Nem kell be�ll�tani", false);
	private ButtonGroup minhosszBG = new ButtonGroup();
	
	private JButton megsemButton = new JButton("M�gsem");
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
		settings1Panel.setBorder(BorderFactory.createTitledBorder("M�retek"));
		settings2Panel.setLayout(new GridLayout(3,1));
		megsemOkPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
	}
	
	@SuppressWarnings("serial")
	public NyeregtetoDialog(Frame owner) {
		letezikE = true;
		tulaj = (Tetofedes)owner;
		
		setTitle("Nyeregtet�");
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
						add(new JLabel("Tet� hossza:"));
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
						add(new JLabel("Tet��l hossza:"));
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
						add(new JLabel("M�sik tet��l hossza:"));
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
						add(new JLabel("Lemezek teljes sz�less�ge:"));
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
						add(new JLabel("Lemezek hasznos takar�sa:"));
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
						add(new JLabel("Biztons�gi told�s a lemezekhez:"));
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
						add(new JLabel("Minim�lis lemezhossz�s�g:"));
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
				setBorder(BorderFactory.createTitledBorder("A k�t tet��l azonoss�ga"));
				add(nemAzonosRB);
				add(azonosRB);
			}
		});
		settings2Panel.add(new JPanel() {
			{
				setLayout(new GridLayout(3,1));
				setBorder(BorderFactory.createTitledBorder("Biztons�gi told�s a lemezekhez"));
				add(toldasIgenRB);
				add(toldasNemRB);
			}
		});
		settings2Panel.add(new JPanel() {
			{
				setLayout(new GridLayout(3,1));
				setBorder(BorderFactory.createTitledBorder("Minim�lis lemezhossz be�ll�t�sa"));
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
				JOptionPane.showMessageDialog(this, "Hib�s bevitel!\nHi�nyz� adat.", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tetoHossz == 0 || tetoElHossz == 0 || (tetoElMasikHosszTF.isEnabled() & tetoElMasikHossz == 0) ||lemezHossz == 0 || lemezHasznos == 0 || (toldasTF.isEnabled() & toldas == 0) || (minhosszTF.isEnabled() & minhossz == 0)) {
				JOptionPane.showMessageDialog(this, "Hib�s bevitel!\nA 0 �rt�k nem elfogadhat�!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(lemezHossz < lemezHasznos) {
				JOptionPane.showMessageDialog(this, "Hib�s bevitel!\nA lemezek teljes sz�less�ge nem lehet kisebb, mint a hasznos takar�suk!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tetoElMasikHossz == 0)
				tetoElMasikHossz = tetoElHossz;
			tulaj.setTextNyeregteto(tetoHossz, tetoElHossz, tetoElMasikHossz, lemezHossz, lemezHasznos, toldas, minhossz);
		}
	}
}


