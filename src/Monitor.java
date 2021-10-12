import java.util.ArrayList;

public class Monitor {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(33,55,13);
        ArrayList<Monitor> monitorList = new ArrayList<Monitor>();
        Monitor monitor1 = new Monitor(Brand.LG,"65",Resolution.RESOLUTION_HD, dimensions, Diagonal.INCH_24);
        Monitor monitor2 = new Monitor(Brand.SAMSUNG, "32",Resolution.RESOLUTION_8K, dimensions, Diagonal.INCH_30);
        monitorList.add(monitor1);
        monitorList.add(monitor2);
    }

    public final Brand;
    String power;
    public final Resolution;
    public final Dimensions dimensions;
    public final Diagonal diagonal;

    public Monitor(String brand, String power, String resolution, Dimensions dimensions, Diagonal diagonal) {
        this.brand = brand;
        this.power = power;
        this.resolution = resolution;
        this.dimensions = dimensions;
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "brand='" + brand + '\'' +
                ", power='" + power + '\'' +
                ", resolution='" + resolution + '\'' +
                ", diagonal='" + diagonal + '\'' +
                '}';
    }

    public static ArrayList<Monitor> findByBrand(Brand brand, ArrayList<Monitor> monitorList){
        ArrayList<Monitor> resultList = new ArrayList<Monitor>();
        for (Monitor monitor:monitorList) {
            if (monitor.brand == brand)){
                resultList.add(monitor);
            }
        }
        if (!resultList.isEmpty()){
            return resultList;
        }
        return null;

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
