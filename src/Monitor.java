import java.util.ArrayList;

public class Monitor {
    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(33,55,13);
        Dimensions dimensions2 = new Dimensions(24,80,90);

        ArrayList<Monitor> monitorList = new ArrayList<Monitor>();
        Monitor monitor1 = new Monitor(Brand.LG,"65",Resolution.RESOLUTION_HD, dimensions, Diagonal.INCH_24);
        monitor1.changePower("90");
        Monitor monitor2 = new Monitor(Brand.SAMSUNG, "32",Resolution.RESOLUTION_8K, dimensions2, Diagonal.INCH_30);
        monitorList.add(monitor1);
        monitorList.add(monitor2);
        System.out.println(findByBrand(Brand.LG, monitorList));
        System.out.println(monitor1.dimensions);
        System.out.println(monitor2.dimensions);
        System.out.println(findLastMonitorByHeight(dimensions.height, monitorList));

    }

    public final Brand brand;
    private String power;
    public final Resolution resolution;
    public final Dimensions dimensions;
    public final Diagonal diagonal;

    public Monitor(Brand brand, String power, Resolution resolution, Dimensions dimensions, Diagonal diagonal) {
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
    }

    public static ArrayList<Monitor> findByResolution(Resolution resolution, ArrayList<Monitor> monitorList){
        ArrayList<Monitor> resultList = new ArrayList<Monitor>();
        for (Monitor monitor:monitorList) {
            if (monitor.resolution == resolution){
                resultList.add(monitor);
            }
        }
        return resultList;
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

        @Override
        public String toString() {
            return "Dimensions{" +
                    "length=" + length +
                    ", wide=" + wide +
                    ", height=" + height +
                    '}';
        }
    }

    public enum Diagonal{
        INCH_24,
        INCH_27,
        INCH_30;
    }

    public enum Brand{
        LG,
        SAMSUNG,
        AOC;
    }

    public enum Resolution{
        RESOLUTION_HD,
        RESOLUTION_FULL_HD,
        RESOLUTION_2K,
        RESOLUTION_4K,
        RESOLUTION_8K;
    }
}
