package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static Random rand = new Random();
    public Scanner scanner = new Scanner(System.in);
    public List<Integer> bingoList = new ArrayList<Integer>(5);
    public List<Integer> randomList = new ArrayList<Integer>(5);

    public static void main(String[] args) {
        new Bingo().menu();
    }

    void menu(){
        System.out.println("******************************************");
        System.out.println("* BINGO");
        System.out.println("******************************************");
        System.out.println("* 1) Create a Bingo card basically set of numbers which the first person has would win!!");
        System.out.println("* 2) Draw a number");
        System.out.println("* 3) Check Bingo card");
        System.out.println("* 9) Exit");
        System.out.println("******************************************");
        System.out.println("Select a menu option: ");

        int choice = scanner.nextInt();

        if(choice == 1){
            createBingo();
        }
        if( choice == 2){
            drawNumber();
        }
        if(choice == 3){
            checkBingo();
        }
        if(choice == 9){
            exitMenu();
        }
    }

    private void checkBingo() {
        if(bingoList.isEmpty()){
            System.out.println("You must first create a Bingo card before drawing a number!");
            menu();
        }
        else
            System.out.println(compareList(bingoList, randomList));
    }

    public static boolean compareList(List<Integer> ls1, List<Integer> ls2) {
        return ls1.toString().contentEquals(ls2.toString());
    }

    private void exitMenu(){
        System.exit(0);
    }

    private void createBingo() {
        int field = 0;
        field++;
        System.out.println("Enter a value for field between 0 and 20. "+ field + ":");
        for(int i = 0; i < 5; i++){
            String s = scanner.nextLine();
            if (s.isEmpty()) break;
            bingoList.add(Integer.parseInt(s));
        }
        for(int i = 0; i < 5; i++){
            System.out.println(bingoList.get(i).toString());
        }
        menu();
    }

    private void drawNumber()
    {
        randomList = getRandomNonRepeatingIntegers(5,0,5);
        for (Integer aRandomList : randomList) {
            System.out.println("" + aRandomList);

        }
        menu();
    }

    public List<Integer> getRandomNonRepeatingIntegers(int size, int min, int max) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (numbers.size() < size) {
            int random = getRandomInt(min, max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return numbers;
    }

    public static int getRandomInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}
