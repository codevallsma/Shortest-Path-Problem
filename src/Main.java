import java.util.ArrayList;

public class Main {
    public static void main(String arg[]) {
        final float infinit=99999999;
        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        //ArrayList<Path>  path= new ArrayList<>();
        ArrayList<Point> Nodes= new ArrayList<>();
        //array of integers that gives us the information about all the costs between each node
        //cost[0][1], cost between A --> B,  which is 8, /cost[0][2], cost between A --> C, which is 12
        int[][] costs = new int[][]{{-1,8,12,4,6},{8,-1,5,9,15},{12,5,-1,2,5},{4,9,2,-1,7},{6,15,5,7,-1}};

        //estructura de a
        //Iterem per tots els possibles nodes, per aixi poguer creaar la seva estructura interior
        for(int i=0; i<costs.length;i++){

            ArrayList<Path>  path= new ArrayList<>();
            //Construim cada punt per aixi despres construir quins seran els seus nodes
            Point provisional= new Point(Character.toString(alfabet.charAt(i)), path);

            for(int j=0; j<costs[i].length; j++){

                //Verifiquem que no s'estigui referenciant a ell mateix
                //if(costs[i][j]!=-1){
                    Path opcio_camins= new Path(costs[i][j],Character.toString(alfabet.charAt(j)));
                    ArrayList<Path> camins_per_lletra= provisional.getPaths();
                    camins_per_lletra.add(opcio_camins);
                    provisional.setPaths(camins_per_lletra);
               // }
            }
            //We add to our Arraylist each node that interacts with our TSP problem
            Nodes.add(new Point(Character.toString(alfabet.charAt(i)), path));
        }
        //Inicialitzem la clase solutiion amb un cost molt gran per assegurar-nos que trobem una solucio millor
        Solution best= new Solution(infinit);
        Solution startingSolution= new Solution(0);
        //we will need an array of booleans in order to know if we have already visited the node we are inspecting inside the backtracking algorithm
        boolean []visited= new boolean[costs.length];
        Backtracking tsp= new Backtracking(Nodes);
        Point evaluate= Nodes.get(0);
        //we define our starting point "A", and destination point will be the last node added in the list of nodes, in this case "E"
        best = tsp.shortest_path(Nodes.get(0), Nodes.get(Nodes.size()-1), startingSolution, best, visited);
        System.out.println(best.getPath().toString());
    }
}
