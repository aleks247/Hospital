import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("Exit -> 0 ");
        System.out.println("Doctor -> 1 ");
        System.out.println("Patient -> 2");
        System.out.print("Choose your role : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                checkingAvailableDoctors();
                break;
            case 2:
                patientEntrance();
                break;
            case 0:
                System.out.println("exit");
                break;
            default:
                System.out.println("Please enter a valid option ! ");
                printMenu();
                break;
        }
    }

    public static void checkingAvailableDoctors() {
        File doctorsFile = new File("doctors.txt");
        try {
            FileReader fileReader = new FileReader(doctorsFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(",");
                doctorspurvired(words);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

public static void doctorspurvired(String[]words){

    for (int i = 0; i < words.length; i++) {
        System.out.println(words[i]);
       // Doctor doctor=new Doctor((Integer.getInteger(words[i]),words[i],words[i],words[i],words[i]);


    }

}
    public static void entryForDoctors() {

    }

    public static void patientEntrance() {

    }

    public static void main(String[] args) {
        printMenu();

    }
}

