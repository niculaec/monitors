import java.util.ArrayList;

public class Monitor {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(33,55,13);
        ArrayList<Monitor> monitor = new ArrayList<Monitor>();
        Monitor monitor1 = new Monitor("Lg","27","65","4k", Diagonal.diagonal24);
        Monitor monitor2 = new Monitor("Samsung", "32","80","fullHD",Diagonal.diagonal30);

    }
    String brand;
    String power;
    String resolution;
    public final Diagonal diagonal ;

    public Monitor(String brand, String dimension, String power, String resolution, Diagonal diagonal) {
        this.brand = brand;
        this.power = power;
        this.resolution = resolution;
        this.diagonal = diagonal;
    }


    public String getBrand() {
        return brand;
    }


    public String getPower() {
        return power;
    }

    public String getResolution() {
        return resolution;
    }

    public Diagonal getDiagonal() {
        return diagonal;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "brand='" + brand + '\'' +
                ", power='" + power + '\'' +
                ", resolution='" + resolution + '\'' +
                //", diagonal='" + diagonal + '\'' +
                '}';
    }

    static class Dimensions {
        int length;
        int wide;
        int height;

        public Dimensions(int length, int wide, int height) {
            this.length = length;
            this.wide = wide;
            this.height = height;
        }

    }

    public enum Diagonal{
        diagonal24,
        diagonal27,
        diagonal30;

    }



}
