
public class Main {
	public static void main(String[] args ) {
		CanvasWindow canvasWindow = new CanvasWindow(1200,800);
		canvasWindow.renderFractal(new MandelbrotFractal());
		canvasWindow.show();
	}
}