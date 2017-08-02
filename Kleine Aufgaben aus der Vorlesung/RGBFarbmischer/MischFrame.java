package RGBFarbmischer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MischFrame extends JFrame  {

	
	// Globale Variablen
		private JSlider redSlider;
		private JSlider greenSlider;
		private JSlider blueSlider;
		
		private JLabel redLabel;
		private JLabel greenLabel;
		private JLabel blueLabel;
		
		private JPanel colorPanel; 
		private JPanel settings;
		private JPanel textPanel;
		private JPanel fieldPanel;
		private JPanel sliderPanel;
		
		
		private JTextField redField;
		private JTextField greenField;
		private JTextField blueField;
	
	public MischFrame(){
	
		settings = new JPanel();
		// Beschriftungen der Slider
		redLabel = new JLabel("rot: ");
		greenLabel = new JLabel("grün: ");
		blueLabel = new JLabel("blau: ");

		redSlider = new JSlider(0,255,0);
		greenSlider = new JSlider(0,255,0);
		blueSlider = new JSlider(0,255,0);
		
		redField = new JTextField("0",3);
		greenField = new JTextField("0",3);
		blueField = new JTextField("0",3);
		

		event e = new event();
		redSlider.addChangeListener(e);
		greenSlider.addChangeListener(e);
		blueSlider.addChangeListener(e);
		
		
		textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(3,1));
		textPanel.add (redLabel);
		textPanel.add (greenLabel);
		textPanel.add (blueLabel);
	
		// Slider, mit denen man die Farben einstellen soll
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridLayout(3,1));
		sliderPanel.add (redSlider);
		sliderPanel.add(greenSlider);
		sliderPanel.add (blueSlider);
		
		fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(3,1));
		fieldPanel.add(redField);
		fieldPanel.add(greenField);
		fieldPanel.add(blueField);
		
		add (settings, BorderLayout.SOUTH);
		colorPanel = new JPanel();
		colorPanel.setBackground(Color.BLACK);
		add (colorPanel, BorderLayout.CENTER);
		
		settings.add (textPanel, BorderLayout.WEST);
		settings.add (sliderPanel, BorderLayout.CENTER);
		settings.add(fieldPanel, BorderLayout.EAST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,300);
		setVisible(true);
	}

	public class event implements ChangeListener{
	@Override
		public void stateChanged(ChangeEvent e) {
			int r = redSlider.getValue();
				int g = greenSlider.getValue();
				int b = blueSlider.getValue();
				
				redField.setText(Integer.toString(r));
				greenField.setText(Integer.toString(g));
				blueField.setText(Integer.toString(b));
				colorPanel.setBackground(new Color(r,g,b));
		}
	}

}
