import java.util.ArrayList;

public class Main {

    public static void main(String arg[]) {
        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<Path>  path= new ArrayList<>();
        ArrayList<Point> Nodes= new ArrayList<>();
        int[][] costs = new int[][]{{-1,8,12,4,6},{8,-1,5,9,15},{12,5,-1,2,5},{4,9,2,-1,7},{6,15,5,7,-1}};

        //estructura de a
        //afegir b,c,d
        for(int i=0; i<costs.length;i++){

            for(int j=0; j<costs[i].length; j++){

            }
            Nodes.add(new Point(Character.toString(alfabet.charAt(i)), path));
        }

        /*Path a_pathP= new Path(2, "b");
        a_path.add(a_pathP);
        a_pathP.setDistance(6);
        a_pathP.setPoint("c");
        Point a= new Point("a", )*/
    }
}
