import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static Scanner scan = new Scanner(System.in);
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUWXYZ";

    public static void main(String[] args) {
        System.out.println("Podaj tekst do zaszyfrowania:");
        String phrase = getPhrase();

        System.out.println("Podaj ilość kolumn:");
        int columns = getColumns(phrase);

        System.out.println("Czy chcesz zmienić kolejność kolumn?(T/N)");
        int [] columnOrder = getColumnOrder(columns);

        System.out.println("Zakodowany tekst:");
        String encryptedText = encryptPhrase(phrase,columns,columnOrder);
        System.out.println(encryptedText);

    }
    public static String getPhrase(){
        String phrase = scan.nextLine().toUpperCase();
        String reducedPhrase = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (alphabet.contains(String.valueOf(phrase.charAt(i)))){
                reducedPhrase = reducedPhrase.concat(String.valueOf(phrase.charAt(i)));
            }
        } return reducedPhrase;
    }

    public static int getColumns(String phrase){
        int columns = scan.nextInt();
        while (columns > phrase.length()) {
            System.out.println("Podaj prawdidłową ilość kolumn:");
            columns = scan.nextInt();
        } return columns;
    }

    public static int[] getColumnOrder(int columns){
        int columnArray [] = new int[columns];
        if (scan.next().equalsIgnoreCase("T")){
            System.out.println("Podaj kolejność kolumn:");
            for (int i = 0; i < columns; i++) {
                System.out.printf("Podaj %d kolumnę()\n",i+1);
                columnArray[i] = scan.nextInt();
            }
        } else {
            for (int i = 0; i < columns; i++) columnArray[i] = i;
        }
         return columnArray;
    }
    public static String encryptPhrase(String phrase, int columns, int[] columnOrder){
        String encryptedPhrase = "";
        String array[] = new String[columns];
        Arrays.fill(array, "");
        for (int i = 0; i < phrase.length(); i++) {
            array[i%columns] = array[i%columns].concat(String.valueOf(phrase.charAt(i)));
        }
        for (int i = 0; i < columns; i++) encryptedPhrase = encryptedPhrase.concat(array[columnOrder[i]]);
        return encryptedPhrase;
    }

}
