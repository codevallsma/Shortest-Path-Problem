import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    private float total_cost;
    private Stack<Point> path;

    public Solution(float total_cost) {
        this.total_cost = total_cost;
        this.path = new Stack<>();
    }


    public float getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(float addCost) {
        this.total_cost = addCost;
    }

    public Stack<Point> getPath() {
        return path;
    }

    public void setPath(Stack<Point> path) {
        this.path = path;
    }

    public Solution clone() {

        Solution copy = new Solution(this.total_cost);
        for (Point p : this.path)
            copy.path.push(p);

        return copy;
    }
}
