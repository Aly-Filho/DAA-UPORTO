import java.util.Scanner;

public class Problem_B{

    public static void main(String[] args) {
        
        Scanner stdin = new Scanner(System.in);
        int[] array_coins = new int[201];

        for (int i = 0; i < 6; i++){ //Read the initial status of the machine.
            if (i == 0){
                array_coins[200] = stdin.nextInt();
            }
            if (i == 1){
                array_coins[100] = stdin.nextInt();
            }
            if (i == 2){
                array_coins[50] = stdin.nextInt();
            }
            if (i == 3){
                array_coins[20] = stdin.nextInt();
            }
            if (i == 4){
                array_coins[10] = stdin.nextInt();
            }
            if (i == 5){
                array_coins[5] = stdin.nextInt();
            }
        }
        
        int number_transactions = 0;
        int number_transactions_steal = 0;
        int stolen_value = 0;

        while(true){
            int euro = stdin.nextInt() * 100; //Read the transaction information.
            int cents = stdin.nextInt();
            if (euro == 0 && cents == 0){ //Stop condition and Stop prints.
                System.out.println(stolen_value/100 + " " + stolen_value%100);
                System.out.println(number_transactions_steal + "/" + number_transactions);
                break;
            }
            int inserted_value = 0;
            int inserted_coin = -1;
            while(inserted_coin != 0){ //Fill the array of coins with the coins inserted.
                inserted_coin = stdin.nextInt();
                if (inserted_coin == 2){
                    array_coins[200]++;
                    inserted_value += 200;
                }
                if (inserted_coin == 1){
                    array_coins[100]++;
                    inserted_value += 100;
                }
                if (inserted_coin == 50){
                    array_coins[50]++;
                    inserted_value += 50;
                }
                if (inserted_coin == 20){
                    array_coins[20]++;
                    inserted_value += 20;
                }
                if (inserted_coin == 10){
                    array_coins[10]++;
                    inserted_value += 10;
                }
                if (inserted_coin == 5){
                    array_coins[5]++;
                    inserted_value += 5;
                }
            }
            //Start of the transaction change.
            int total_price = euro + cents;
            number_transactions++;
            //System.out.println("inserted value: " + inserted_value + ".....total price: " + total_price);
            int change = inserted_value - total_price;
            while(change >= 200 && array_coins[200] > 0){
                change -= 200;
                array_coins[200]--;
            }
            while(change >= 100 && array_coins[100] > 0){
                change -= 100;
                array_coins[100]--;
            }
            while(change >= 50 && array_coins[50] > 0){
                change -= 50;
                array_coins[50]--;
            }
            while(change >= 20 && array_coins[20] > 0){
                change -= 20;
                array_coins[20]--;
            }
            while(change >= 10 && array_coins[10] > 0){
                change -= 10;
                array_coins[10]--;
            }
            while(change >= 5 && array_coins[5] > 0){
                change -= 5;
                array_coins[5]--;
            }
            if (change != 0){
                number_transactions_steal++;
                stolen_value += change;
            }
        }
    }
}