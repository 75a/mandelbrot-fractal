import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class CanvasWindow extends JComponent {

	private static final long serialVersionUID = 1L;

	public int width;
	public int height;
	public BufferedImage buffer;
	public FractalInterface fractal;
	
	public CanvasWindow(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void renderFractal(FractalInterface fractal) {
		this.fractal = fractal;
		buffer = fractal.getBufferedFractalImage(width, height);
		repaint();
	}
	

	public void show() {
		JFrame frame = new JFrame ();
		frame.setPreferredSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(buffer,  0, 0, null);
	}


}
