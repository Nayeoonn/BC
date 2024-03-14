package Day08.Ex02_Shape;

public class Trianlge extends Shape {
	
	double width, height;

	// 기본 생성자
	public Trianlge() {
	}
	
	// 매개변수가 있는 생성자
	public Trianlge(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	double area() {
		// 가로 * 세로 / 2
		return width * height / 2;
	}

	@Override
	double round() {
		// 정삼각형 : 한변의 길이 * 3
		return width * 3;
	}

	// getter, setter
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// toString
	@Override
	public String toString() {
		return "Trianlge [width=" + width + ", height=" + height + "]";
	}
	
	

}
