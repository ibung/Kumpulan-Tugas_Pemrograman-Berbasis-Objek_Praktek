public class TestCylinder {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println("--- Cylinder 1 (default) ---");
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Height: " + c1.getHeight());
        System.out.println("Color: " + c1.getColor());
        System.out.println("Surface Area: " + c1.getArea());
        System.out.println("Volume: " + c1.getVolume());
        System.out.println(c1.toString());
        System.out.println();

        Cylinder c2 = new Cylinder(10.0);
        System.out.println("--- Cylinder 2 (height=10.0) ---");
        System.out.println("Radius: " + c2.getRadius());
        System.out.println("Height: " + c2.getHeight());
        System.out.println("Color: " + c2.getColor());
        System.out.println("Surface Area: " + c2.getArea());
        System.out.println("Volume: " + c2.getVolume());
        System.out.println(c2.toString());
        System.out.println();

        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("--- Cylinder 3 (radius=2.0, height=10.0) ---");
        System.out.println("Radius: " + c3.getRadius());
        System.out.println("Height: " + c3.getHeight());
        System.out.println("Color: " + c3.getColor());
        System.out.println("Surface Area: " + c3.getArea());
        System.out.println("Volume: " + c3.getVolume());
        System.out.println(c3.toString());
        System.out.println();
    }
}