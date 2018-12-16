import java.util.ArrayList;

public class Point {
    private String Point_name;
    private ArrayList<Path> paths;

    public Point(String Point_name, ArrayList<Path> paths) {
        this.Point_name = Point_name;
        this.paths = paths;
    }

    public String getPoint_name() {
        return Point_name;
    }

    public void setPoint_name(String point_name) {
        Point_name = point_name;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<Path> paths) {
        this.paths = paths;
    }

    @Override
    public String toString() {
        return "Point{" +
                "Point_name='" + Point_name + '\'' +
                '}';
    }
}
