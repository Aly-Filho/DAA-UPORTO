import java.util.Scanner;

class Route{

    int n;
    int[] local;
    int[] free_spaces;
    int[] problem;
    int problem_counter = 0;
    boolean possible_travel = false;
    boolean possible_places = true;
    int min_places = 500;
    

    public Route(int size, Scanner stdin, int origin, int destiny, int n_people, int x) { //fill the routes and and already check if its possible.
        this.local = new int[size];
        this.free_spaces = new int[size-1];
        this.problem = new int[size-1];
        boolean aux = false; //Flying babbeeeeee
        this.n = x+1;
        for (int i = 0; i < size; i++){
            this.local[i] = stdin.nextInt(); 
            if ((this.local[i] == destiny) && (aux == true)){
                this.possible_travel = true;
                aux = false;
            }
            if(local[i] == origin && this.possible_travel == false){
                aux = true;
            }
            if (i == size - 1) break;
            this.problem[i] = stdin.nextInt();
            //if (aux == true && this.problem[i] == 1){ // We're flying babe
            //    this.problem_counter++;
            //}
            if(this.problem[i] == 1 && this.possible_travel == false) this.problem_counter++;
            this.free_spaces[i] = stdin.nextInt();
            if (aux){
                if (this.free_spaces[i] >= n_people){
                    if(this.min_places > this.free_spaces[i]) this.min_places = free_spaces[i];
                } else {
                    possible_places = false;
                    aux = false; //eficiency.
                }
            }
        }
    }
}

public class Problem_C{

    public static void main(String[] args) {
        
        Scanner stdin = new Scanner(System.in);
        int n_routes = stdin.nextInt(); int n_people = stdin.nextInt(); int origin = stdin.nextInt(); int destiny = stdin.nextInt();
        Route[] array_routes = new Route[n_routes];
        for (int i = 0; i < n_routes; i++){
            int size = stdin.nextInt();
            Route r = new Route(size, stdin, origin, destiny, n_people, i);
            array_routes[i] = r;
        }
        //Check for the answer
        int aux = 0;
        Route[] array_possible = new Route[n_routes];
        for (int i = 0; i < n_routes; i++){
            if (array_routes[i].possible_travel == true && array_routes[i].possible_places == true){
                array_possible[aux++] = array_routes[i];
            }
        }
        if (array_possible[0] == null){
            System.out.println("Impossivel");
        } else {

        Route[] array_possible_problems = new Route[aux];
        int min_problems = 31; //Check the greater problem.
        for (int i = 0; i < aux; i++){
            if (array_possible[i].problem_counter < min_problems) min_problems = array_possible[i].problem_counter;
        }
        int aux2 = 0; //fill the array with only the min problem routes.
        for (int i = 0; i < aux; i++){
            if (array_possible[i].problem_counter == min_problems) array_possible_problems[aux2++] = array_possible[i];
        }
        int max_seats = 0; //check the max_seats avaible.
        for (int i = 0; i < aux2; i++){
            if (array_possible_problems[i].min_places > max_seats) max_seats = array_possible_problems[i].min_places;
        }
        for (int i = 0; i < aux2; i++){
            if (array_possible_problems[i].min_places == max_seats){
            array_possible[0] = array_possible_problems[i];
            break;
            }
        }
        System.out.println("Rota = " + array_possible[0].n + " Probs = " + array_possible[0].problem_counter + " Lugares = " + array_possible[0].min_places);
        }
    }
}