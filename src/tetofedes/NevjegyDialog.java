package tetofedes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NevjegyDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel mainPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel appNamePanel	= new JPanel();
	private JPanel authorPanel = new JPanel();
	private JPanel systemPanel = new JPanel();
	
	{
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(centerPanel, "Center");
		centerPanel.setLayout(new GridLayout(3, 1));
		centerPanel.add(appNamePanel);
		centerPanel.add(authorPanel);
		centerPanel.add(systemPanel);
		appNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		authorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		systemPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	public NevjegyDialog(Frame owner) {
		setTitle("Névjegy");
		setBounds(framePosition());
		setResizable(false);
		setModal(true);
		
		getContentPane().add(mainPanel);
		
		appNamePanel.add(new JLabel("Tetõlemez kalkulátor 1.02"));
		authorPanel.add(new JLabel("2011 Gábor Balázs"));
		systemPanel.add(new JLabel(System.getProperty("os.name")));
		
		setVisible(true);
	}
	
	private static Rectangle framePosition() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int width = 250;
		int height = 180;
		int x = (screenSize.width - width) / 2;
		int y = (screenSize.height - height) / 2;
		return (new Rectangle(x, y, width, height));
	}
}
