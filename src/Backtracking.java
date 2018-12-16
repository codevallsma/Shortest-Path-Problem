import java.util.ArrayList;
import java.util.Optional;

public class Backtracking {
    private ArrayList<Point> nodes;

    public Backtracking(ArrayList<Point> nodes) {
        this.nodes = nodes;
    }

    public  Solution shortest_path(Point current, Point destination, Solution s, Solution best, boolean[]visited){
        //we check if we arrived at our destination
        if (current.getPoint_name().equals(destination.getPoint_name())){
            //we check if the path taken was the best path we've ever taken
            if(s.getTotal_cost()<best.getTotal_cost()){
                best=s;
                System.out.println(best.getPath());
            }
        }else{

            for(int i =0; i<visited.length;i++){

                if((!visited[i]) && s.getTotal_cost()+ current.getPaths().get(i).getDistance()<best.getTotal_cost()){
                    //we mark as visited the node
                    visited[i]=true;
                    //if we add the first element to the solution path, the path to itself is -1, we don't want to substract 1 to the final cost
                    //we add the total cost the current cost
                    if( current.getPaths().get(i).getDistance()!=-1){
                        s.setTotal_cost(s.getTotal_cost()+  current.getPaths().get(i).getDistance());
                    }
                    s.getPath().push(current);
                    //we look the next character after the name of our node, if called 'A' NEXT is 'B'
                    int charValue = current.getPoint_name().charAt(0);
                    final String next = String.valueOf( (char) (charValue + 1));
                    System.out.println(next);

                    Optional<Point> findNodes = nodes.
                            stream().filter(Point  -> Point.getPoint_name().equals((next)))
                            .findFirst();
                    best= shortest_path(findNodes.get(),destination, s, best, visited);

                    visited[i]=false;

                    if(s.getTotal_cost()!=-1) s.setTotal_cost(s.getTotal_cost()-current.getPaths().get(i).getDistance());
                    s.getPath().pop();

                }
              // s.setTotal_cost(s.getPath().get(i);
            }
        }
        return best;
    }
}
/*Another solution when finding theelement of the array
    //we look the next character after the name of our node, if called 'A' NEXT is 'B'
    int charValue = current.getPoint_name().charAt(0);
    final String next = String.valueOf( (char) (charValue + 1));
                    System.out.println(next);

                            Optional<Point> findNodes = nodes.
        stream().filter(Point  -> Point.getPoint_name().equals((next)))
        .findFirst();*/