import java.util.ArrayList;

public class Monitor {
    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(33,55,13);
        Dimensions dimensions2 = new Dimensions(24,80,90);

        ArrayList<Monitor> monitorList = new ArrayList<Monitor>();
        Monitor monitor1 = new Monitor(Brand.AOC,"65",Resolution.RESOLUTION_HD, dimensions, Diagonal.INCH_24);
        monitor1.changePower("90");
        Monitor monitor2 = new Monitor(Brand.SAMSUNG, "32",Resolution.RESOLUTION_8K, dimensions2, Diagonal.INCH_30);
        Monitor monitor3 = new Monitor(Brand.SAMSUNG, "32",Resolution.RESOLUTION_4K, dimensions2, Diagonal.INCH_30);
        Monitor monitor4 = new Monitor(Brand.AOC, "64",Resolution.RESOLUTION_2K, dimensions, Diagonal.INCH_27);
        Monitor monitor5 = new Monitor(Brand.AOC, "32",Resolution.RESOLUTION_FULL_HD, dimensions2, Diagonal.INCH_24);
        Monitor monitor6 = new Monitor(Brand.SAMSUNG, "32",Resolution.RESOLUTION_HD, dimensions2, Diagonal.INCH_30);

        monitorList.add(monitor1);
        monitorList.add(monitor2);
        monitorList.add(monitor3);
        monitorList.add(monitor4);
        monitorList.add(monitor5);
        monitorList.add(monitor6);

        ArrayList<Monitor> resultList = findByBrand(Brand.SAMSUNG,monitorList);
        System.out.println("I");
        displayList(resultList);

        System.out.println("II");
        System.out.println((monitor1.dimensions) + "/n");
        System.out.println();
        System.out.println("III");
        System.out.println(monitor2.dimensions);
        System.out.println();
        System.out.println("IV");
        System.out.println(findLastMonitorByHeight(0, monitorList));
        System.out.println();
        System.out.println("V");
        System.out.println(findByResolution(Resolution.RESOLUTION_4K,monitorList));
        System.out.println("VI");

        resultList = findByAtLeastResolution(Resolution.RESOLUTION_2K, monitorList);
        displayList(resultList);

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

    public void changePower(String power){
        this.power = power;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "brand=" + brand +
                ", power='" + power + '\'' +
                ", resolution=" + resolution +
                ", dimensions=" + dimensions +
                ", diagonal=" + diagonal +
                '}';
    }

    public static ArrayList<Monitor> returnNullIfListEmpty(ArrayList<Monitor> resultList) {
        if (!resultList.isEmpty()){
            return resultList;
        }
        return null;
    }

    public static void displayList(ArrayList<Monitor>resultList){
        if (resultList != null){
            for (Monitor m : resultList){
                System.out.println(resultList.indexOf(m) +1);
                System.out.println(m);
            }
        }
    }

    public static Monitor findLastMonitorByHeight(int height, ArrayList<Monitor> monitorList){
        ArrayList<Monitor> resultList = new ArrayList<Monitor>();
        for (Monitor monitor:monitorList) {
            if (monitor.dimensions.height == height){
                resultList.add(monitor);
            }
        }
        return resultList.get(resultList.size()-1);
    }

    public static ArrayList<Monitor> findByBrand(Brand brand, ArrayList<Monitor> monitorList){
        ArrayList<Monitor> resultList = new ArrayList<Monitor>();
        for (Monitor monitor:monitorList) {
            if (monitor.brand == brand){
                resultList.add(monitor);
            }
        }
        return returnNullIfListEmpty(resultList);
    }

    public static ArrayList<Monitor> findByResolution(Resolution resolution, ArrayList<Monitor> monitorList){
        ArrayList<Monitor> resultList = new ArrayList<Monitor>();
        for (Monitor monitor:monitorList) {
            if (monitor.resolution == resolution){
                resultList.add(monitor);
            }
        }
        return returnNullIfListEmpty(resultList);
    }

    public static ArrayList<Monitor> findByAtLeastResolution(Resolution resolution, ArrayList<Monitor> monitorList){
        ArrayList<Monitor> resultList = new ArrayList<Monitor>();
        for (Monitor monitor:monitorList) {
            if (resolution.ordinal() <= monitor.resolution.ordinal()){
                resultList.add(monitor);
            }
        }
        return returnNullIfListEmpty(resultList);
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
        INCH_30
    }

    public enum Brand{
        LG,
        SAMSUNG,
        AOC
    }

    public enum Resolution{
        RESOLUTION_HD,
        RESOLUTION_FULL_HD,
        RESOLUTION_2K,
        RESOLUTION_4K,
        RESOLUTION_8K
    }
}
