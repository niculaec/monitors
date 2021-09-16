import java.util.ArrayList;

public class Monitor {
    public static void main(String[] args) {
        ArrayList<Monitor> monitor = new ArrayList<Monitor>();
        Monitor monitor1 = new Monitor("Lg","27","65","4k", Diagonal.diagonal24);
        Monitor monitor2 = new Monitor("Samsung", "32","80","fullHD",Diagonal.diagonal30);

    }
    String brand;
    String dimension;
    String power;
    String resolution;
    public final Diagonal diagonal ;

    public Monitor(String brand, String dimension, String power, String resolution, Diagonal diagonal) {
        this.brand = brand;
        this.dimension = dimension;
        this.power = power;
        this.resolution = resolution;
        this.diagonal = diagonal;
    }


    public String getBrand() {
        return brand;
    }

    public String getDimension() {
        return dimension;
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
                ", dimension='" + dimension + '\'' +
                ", power='" + power + '\'' +
                ", resolution='" + resolution + '\'' +
                //", diagonal='" + diagonal + '\'' +
                '}';
    }

    public enum Diagonal{
        diagonal24,
        diagonal27,
        diagonal30;

    }



}
