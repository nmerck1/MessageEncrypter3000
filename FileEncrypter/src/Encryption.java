import java.util.*;

public class Encryption {

    // constants
    private final char DEFAULT_CHAR = ' ';
    // variables
    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;
    private char[] secretLetters;
    private String savedMessage;

    Encryption() {
        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList<>();
        shuffledList = new ArrayList<>();
        character = DEFAULT_CHAR;
        savedMessage = "";

        newKey();
        askQuestion();
    }

    private void askQuestion() {
        while (true) {
            System.out.print("\n ------------------------------------------------------------------------------");
            System.out.print("\n What do you want to do? ");
            System.out.print("\n (N)ew Key, (G)et Key, Get Saved (M)essage, Set (S)ave Message, (E)ncrypt, (D)ecrypt, (Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (response) {
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'M':
                    getSavedMessage();
                    break;
                case 'S':
                    saveMessage();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("\n Invalid option. Try again.");

            }
        }
    }

    private void getSavedMessage() {
        System.out.println("Your saved Message: ");
        System.out.println(savedMessage);
    }

    private void saveMessage() {
        System.out.println("Enter a message to be saved: ");
        savedMessage = scanner.nextLine();
    }

    private void newKey(){

        character = ' ';
        list.clear();
        shuffledList.clear();

        for(int i=32;i<127;i++) {
            list.add(Character.valueOf(character));
            character++;
        }

        shuffledList = new ArrayList(list);
        Collections.shuffle(shuffledList);
        System.out.println("*A new key has been generated*");

    }
    private void getKey(){
        System.out.println("Key: ");
        for(Character x : list) {
            System.out.print(x);
        }
        System.out.println();
        for(Character x : shuffledList) {
            System.out.print(x);
        }
        System.out.println();
    }
    private void encrypt(){
        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for(int i =0;i<letters.length;i++) {

            for(int j =0;j<list.size();j++) {
                if(letters[i]==list.get(j)) {
                    letters[i]=shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted: ");
        for(char x : letters) {
            System.out.print(x);
        }
        System.out.println();
    }
    private void decrypt(){
        System.out.println("Enter a message to be decrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for(int i =0;i<letters.length;i++) {

            for(int j =0;j<shuffledList.size();j++) {
                if(letters[i]==shuffledList.get(j)) {
                    letters[i]=list.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted: ");
        for(char x : letters) {
            System.out.print(x);
        }
        System.out.println();
    }
    private void quit(){
        System.out.println("Thank you for using FileEncrypter3000!");
        System.exit(0);
    }
}
