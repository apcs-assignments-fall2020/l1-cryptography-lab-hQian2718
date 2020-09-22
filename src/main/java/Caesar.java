import java.util.Scanner;

public class Caesar {

    public static final int upperBase = 65;
    public static final int lowerBase = 97;

    public static String encryptCaesar(String message) {
        char[] r = message.toCharArray();

        for(int i = 0; i < message.length(); i ++){
            if(r[i] > 64 && r[i] < 91){   //if a uppercase letter 
                r[i] -= 13;      //makes it so that r[i] % 26 = 0;
                r[i] += 3;
                r[i] = (char) ((r[i] % 26) + 65);
            }else if(r[i] > 96 && r[i] < 123){
                r[i] -= 19;
                r[i] += 3;
                r[i] = (char) ((r[i] % 26) + 97);
            }
        }
    return new String(r);
    }

    public static String decryptCaesar(String message) {
       char[] r = message.toCharArray();

        for(int i = 0; i < message.length(); i ++){
            if(r[i] > 64 && r[i] < 91){   //if a uppercase letter 
                r[i] -= 13;      //makes it so that r[i] % 26 = 0;
                r[i] -= 3;
                r[i] = (char) ((r[i] % 26) + 65);
            }else if(r[i] > 96 && r[i] < 123){
                r[i] -= 19;
                r[i] -= 3;
                r[i] = (char) ((r[i] % 26) + 97);
            }
        }
    return new String(r); 
    }

    public static String encryptCaesarKey(String message, int key) {
               char[] r = message.toCharArray();

        for(int i = 0; i < message.length(); i ++){
            if(r[i] > 64 && r[i] < 91){   //if a uppercase letter 
                r[i] -= 13;      //makes it so that r[i] % 26 = 0;
                r[i] += (key % 26);
                r[i] = (char) ((r[i] % 26) + 65);
            }else if(r[i] > 96 && r[i] < 123){
                r[i] -= 19;
                r[i] += (key % 26);
                r[i] = (char) ((r[i] % 26) + 97);
            }
        }
    return new String(r);
    }

    public static String decryptCaesarKey(String message, int key) {
        char[] r = message.toCharArray();

        for(int i = 0; i < message.length(); i ++){
            if(r[i] > 64 && r[i] < 91){   //if a uppercase letter 
                r[i] -= 13;      //makes it so that r[i] % 26 = 0;
                r[i] -= (key % 26);
                r[i] = (char) ((r[i] % 26) + 65);
            }else if(r[i] > 96 && r[i] < 123){
                r[i] -= 19;
                r[i] -= (key % 26);
                r[i] = (char) ((r[i] % 26) + 97);
            }
        }
    return new String(r);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = 0;

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();

            System.out.println("Please enter your key, a number between 0 and 25!");
                key = scan.nextInt();


            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();

            System.out.println("Please enter your key, a number between 0 and 25!");
                key = scan.nextInt();


            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesarKey(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
