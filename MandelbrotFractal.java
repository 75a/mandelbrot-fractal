import java.awt.Color;
import java.awt.image.BufferedImage;

public class MandelbrotFractal implements FractalInterface{

	public int iterations = 150;
	public float hueOffset = 1f;
	int defScale = 300;
	int xOffset = -150;
	int yOffset = 20;
	
	@Override
	public BufferedImage getBufferedFractalImage(int width, int height) {
		BufferedImage fractalBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for(int x = 0; x < width; x++) {
			for (int y = 0; y < height;y ++) {
				int color = calculateMandelbrotSetPointColor(
					((x+xOffset) - width/2f)/defScale,
					((y+yOffset) - height/2f)/defScale
				);
				fractalBuffer.setRGB(x, y, color);
			}
		}
		return fractalBuffer;
	}
	
	private int calculateMandelbrotSetPointColor(float x, float y) {
		float cx = x;
		float cy = y;
		
		int i;
		for (i =0; i < iterations; i++) {
			float nx = x*x - y*y + cx;
			float ny = 2*x*y+cy;
			x = nx;
			y = ny;
			if (x*x + y*y > 10)
				break;
		}
		
		if (i == iterations) {
			return 0;
		}
		
		return Color.HSBtoRGB(((float)i / iterations * hueOffset), 1f, 1);
	}	
}