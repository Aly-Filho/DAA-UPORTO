import java.util.Scanner;

public class Problem_A{

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        int size_family = stdin.nextInt();
        int[] array_family = new int[size_family];
        boolean[] array_boolean = new boolean[size_family];
        for (int i = 0; i < size_family; i++){
            array_family[i] = stdin.nextInt();
        }
        int order = stdin.nextInt();
        int counter_members = 0;

        while (true) { 
            //Stop conditions.
            if ((array_family[order] < 0) || (array_family[order] >= size_family)){
                System.out.println("POLICIA");
                break;
            }
            if (array_boolean[order] == true){
                System.out.println("INCOMPETENTE");
                break;
            }
            if (array_family[order] == order){
                System.out.println(counter_members);
                break;
            }
            counter_members++;
            array_boolean[order] = true;
            order = array_family[order];
        }
    }
    
}