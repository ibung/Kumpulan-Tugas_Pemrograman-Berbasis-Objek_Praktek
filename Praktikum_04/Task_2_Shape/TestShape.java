public class TestShape {
    public static void main(String[] args) {
        // Test Shape
        Shape s1 = new Shape("green", false);
        System.out.println("--- Shape ---");
        System.out.println(s1);
        System.out.println();

        // Test Circle
        Circle c1 = new Circle(5.0, "blue", true);
        System.out.println("--- Circle ---");
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());
        System.out.println();

        // Test Rectangle
        Rectangle r1 = new Rectangle(2.0, 4.0, "yellow", false);
        System.out.println("--- Rectangle ---");
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        System.out.println();

        // Test Square
        Square sq1 = new Square(6.0, "black", true);
        System.out.println("--- Square ---");
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Perimeter: " + sq1.getPerimeter());
        
        // Test setting side
        sq1.setSide(8.0);
        System.out.println("After setting side to 8.0:");
        System.out.println(sq1);
        System.out.println("New Area: " + sq1.getArea());
    }
}