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

public class TetoHaromszogDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	Tetofedes tulaj;
	
	private static boolean letezikE = false;
	
	private JPanel mainPanel = new JPanel();
	private JPanel settings1Panel = new JPanel();
	private JPanel settings2Panel = new JPanel();
	private JPanel megsemOkPanel = new JPanel();
	
	private OnlyNumberTextField szar1TF = new OnlyNumberTextField(9);
	private OnlyNumberTextField szar2TF = new OnlyNumberTextField(9);
	private OnlyNumberTextField alapTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField lemezTakarasTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField lemezHasznosTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField toldasTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField minhosszTF = new OnlyNumberTextField(9);
	
	private JRadioButton nemAzonosRB = new JRadioButton("Szárai nem azonosak", true);
	private JRadioButton azonosRB = new JRadioButton("Szárai azonosak", false);
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
	public TetoHaromszogDialog(Frame owner) {
		letezikE = true;
		tulaj = (Tetofedes)owner;
		
		setTitle("Tetõháromszög");
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
						add(new JLabel("Háromszög egyik szára:"));
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
						add(szar1TF);
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
						add(new JLabel("Háromszög másik szára:"));
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
						add(szar2TF);
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
						add(new JLabel("Háromszög alapja:"));
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
						add(alapTF);
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
						add(lemezTakarasTF);
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
				setBorder(BorderFactory.createTitledBorder("Egyenlõ szárú háromszög"));
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
		
		azonosRB.addActionListener(this);
		nemAzonosRB.addActionListener(this);
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
		if (e.getSource() == azonosRB)
			szar2TF.setEnabled(false);
		if (e.getSource() == nemAzonosRB)
			szar2TF.setEnabled(true);
		if (e.getSource() == toldasIgenRB)
			toldasTF.setEnabled(true);
		if (e.getSource() == toldasNemRB)
			toldasTF.setEnabled(false);
		if (e.getSource() == minhosszIgenRB)
			minhosszTF.setEnabled(true);
		if (e.getSource() == minhosszNemRB)
			minhosszTF.setEnabled(false);
		if (e.getSource() == okButton) {
			int szar1 = 0;
			int szar2 = 0; 
			int alap = 0;
			int lemezTakaras = 0;
			int lemezHasznos = 0;
			int toldas = 0;
			int minhossz = 0;
			try {
				szar1 = Integer.parseInt(szar1TF.getText());
				if (szar2TF.isEnabled())
					szar2 = Integer.parseInt(szar2TF.getText());
				alap = Integer.parseInt(alapTF.getText());
				lemezTakaras = Integer.parseInt(lemezTakarasTF.getText());
				lemezHasznos = Integer.parseInt(lemezHasznosTF.getText());
				if (toldasTF.isEnabled())
					toldas = Integer.parseInt(toldasTF.getText());
				if (minhosszTF.isEnabled())
					minhossz = Integer.parseInt(minhosszTF.getText());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nHiányzó adat.", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(szar1 == 0 || (szar2TF.isEnabled() & szar2 == 0) || alap == 0 || lemezTakaras == 0 || lemezHasznos == 0 || (toldasTF.isEnabled() & toldas == 0) || (minhosszTF.isEnabled() & minhossz == 0)) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nA 0 érték nem elfogadható!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			} 
			if(szar2 == 0)
				szar2 = szar1;
			if((alap >= (szar1 + szar2)) || (szar1 >= (alap + szar2)) || (szar2 >= (szar1 + alap))) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nA háromszög bármelyik oldalának kisebbnek kell lennie a másik két oldal összegénél!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(((szar1 > alap) & (szar2 < alap)) || ((szar2 > alap) & (szar1 < alap))) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nHa az egyik szár nagyobb mint az alap akkor a másik szár nem lehet kisebb mint az alap!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(lemezTakaras < lemezHasznos) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nA lemezek teljes szélessége nem lehet kisebb, mint a hasznos takarásuk!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			tulaj.setTextTetoHaromszog(alap, szar1, szar2, lemezTakaras, lemezHasznos, toldas, minhossz);
		}
	}
}
