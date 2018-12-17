import java.util.ArrayList;
import java.util.Optional;

public class Backtracking {
    private ArrayList<Point> nodes;
    private Point next_point;
    public Backtracking(ArrayList<Point> nodes) {
        this.nodes = nodes;
    }


    private boolean allVisited(boolean []visited) {

        for (boolean v : visited)
            if (!v) return false;

        return true;
    }

    public  Solution shortest_path(Point current, Point destination, Solution s, Solution best, boolean[]visited){
        //we check if we arrived at our destination
        if (current.getPoint_name().equals(destination.getPoint_name())){
            //s.getPath().push(current);
            System.out.println("Another solution has been found with cost " + s.getTotal_cost());
            //we check if the path taken was the best path we've ever taken
            if(s.getTotal_cost()<best.getTotal_cost()){
                best = s.clone();
                best.getPath().push(current);
                System.out.println("Solution found:" + best.getPath());
            }
        }else{

            for(int i =0; i<visited.length;i++){

                if(!visited[i]) {
                    if (s.getTotal_cost()+ current.getPaths().get(i).getDistance()<best.getTotal_cost()) {
                        //we mark as visited the node
                        visited[i] = true;
                        //if we add the first element to the solution path, the path to itself is -1, we don't want to substract 1 to the final cost
                        //we add the total cost the current cost
                        if (current.getPaths().get(i).getDistance() != -1) {
                            s.setTotal_cost(s.getTotal_cost() + current.getPaths().get(i).getDistance());
                        }

                        s.getPath().push(current);
                        //we look the next character after the name of our node, if called 'A' NEXT is 'B'
                        int charValue = current.getPaths().get(i).getPoint().charAt(0);
                        //we check if the next node has already been visited
                        final String next = String.valueOf((char) (charValue));
                        //System.out.println(next);
                        Optional<Point> findNodes = nodes.
                                stream().filter(Point -> Point.getPoint_name().equals((next)))
                                .findFirst();
                        next_point = findNodes.get();

                        best = shortest_path(next_point, destination, s, best, visited);
                        visited[i] = false;
                        if (s.getTotal_cost() != -1)
                            s.setTotal_cost(s.getTotal_cost() - current.getPaths().get(i).getDistance());
                        s.getPath().pop();
                    }
                    else System.out.println("Is not promising");
                }
            }
        }
        return best;
    }
}