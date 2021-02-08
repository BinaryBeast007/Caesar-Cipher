import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CaesarCipher obj = new CaesarCipher();
        System.out.print("Choose a method below :\n1. Encrypt Text\n2. Decrypt Text\n\nEnter your choice : ");
        Scanner input = new Scanner(System.in);
        char choice = input.next().charAt(0);
        while((choice < '1' || choice > '2')){  // Validating input 
            System.out.println("Invalid input. Try again");
            choice = input.next().charAt(0);
        }

        if(choice == '1') {
            System.out.println("Enter your text to encrypt : ");
            obj.setText(input.next());
            System.out.println("Enter your key or shift : ");
            obj.setShift(input.nextInt());
            obj.setCipher(obj.encrypt(obj.getText(), obj.getShift()%26));
            obj.showResult("Encrypted");
        }else if(choice == '2') {
            System.out.println("Enter your text to decrypt : ");
            obj.setText(input.next());
            System.out.println("Enter your key or shift : ");
            obj.setShift(input.nextInt());
            obj.setDecipher(obj.decrypt(obj.getText(), obj.getShift()%26));
            obj.showResult("Decrypted");
        }
        input.close();
    }
}
