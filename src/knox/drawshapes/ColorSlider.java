package knox.drawshapes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorSlider extends JFrame {
	public ColorSlider() {
		getContentPane().add(new TrueColor());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String arg[]) {
		ColorSlider colorSlider;
		colorSlider = new ColorSlider();
	} 
}

//final class cannot be extended/inherited
//To prevent the class from being subclassed
//To prevent the subclass from changing the value
final class TrueColor extends JPanel {
	DrawingCanvas canvas = new DrawingCanvas();
	JSlider Rslider;
	JSlider Gslider;
	JSlider Bslider;

	public TrueColor() {
		Rslider = GetColorSlider(0, 255, 0, 50, 5);
		Gslider = GetColorSlider(0, 255, 0, 50, 5);
		Bslider = GetColorSlider(0, 255, 0, 50, 5);
		JPanel panel = new JPanel();
		//hgap: the width of the horizontal gaps between columns
		//vgap: the height of the vertical gaps between rows
		panel.setLayout(new GridLayout(5, 2, 5, 5));
		panel.add(new JLabel("Custom Colors"));
		panel.add(Rslider);
		panel.add(Gslider);
		panel.add(Bslider);
		add(panel);
		add(canvas);
		canvas.setSize(new Dimension(80, 80));
	}

	public JSlider GetColorSlider(int min, int max, int start, int numInterval, int interval) {
		JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, start);

		slider.setPaintTicks(true); //true: make tick marks visible
		//Major tick: the longer of the tick marks (0, 50 100...)
		//Minor tick: the shorter of the tick marks (others)
		slider.setMajorTickSpacing(numInterval); 
		slider.setMinorTickSpacing(interval);
		slider.setPaintLabels(true); //true: make numbers visible
		slider.addChangeListener(new SliderListener());
		return slider;
	}

	final class DrawingCanvas extends Canvas {
		Color color;
		int RValue;
		int GValue;
		int BValue;

		public DrawingCanvas() {
			setSize(10, 10);
			color = new Color(0, 0, 0);
			setBackgroundColor();
		}

		public void setBackgroundColor() {
			color = new Color(RValue, GValue, BValue); 
			setBackground(color);
		}
	}

	class SliderListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider slider = (JSlider) e.getSource();
			if (slider == Rslider) {
				canvas.RValue = slider.getValue();
				display_RGB_Color();
			} else if (slider == Gslider) {
				canvas.GValue = slider.getValue();
				display_RGB_Color();
			} else if (slider == Bslider) {
				canvas.BValue = slider.getValue();
				display_RGB_Color();
			} 
			canvas.repaint();
		}

		public void display_RGB_Color() {
			canvas.setBackgroundColor();
		}
	}
}
