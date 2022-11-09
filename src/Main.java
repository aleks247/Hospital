import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("Exit -> 0 ");
        System.out.println("Doctor -> 1 ");
        System.out.println("Patient -> 2");
        System.out.print("Choose your role : ");
    }

    public static void entryForDoctors() {

    }

    public static void patientEntrance() {

    }

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    entryForDoctors();
                    break;
                case 2:
                    patientEntrance();
                    break;
                case 0:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("Please enter a valid option ! ");
                    break;
            }
        }
    }
}

