import java.util.ArrayList;

public class Solution {
    private float total_cost;
    private ArrayList<Point> path =new ArrayList<>();

    public float getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(float addCost) {
        this.total_cost += addCost;
    }

    public ArrayList<Point> getPath() {
        return path;
    }

    public void setPath(ArrayList<Point> path) {
        this.path = path;
    }
}
