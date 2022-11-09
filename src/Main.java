import java.util.Scanner;

public class Main {
    public static int choiceDoctorOrPatient() {
        Scanner scanner = new Scanner(System.in);
        int choice ;
        System.out.println("Exit -> 0 ");
        System.out.println("Doctor -> 1 ");
        System.out.println("Patient -> 2");
        System.out.print("Choose your role : ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                entryForDoctors();
            case 2:
                patientEntrance();
            case 0:
                System.out.println("exit");
            default:
                System.out.println("Please enter a valid option ! ");
                choiceDoctorOrPatient();
        }
        return choice;
    }

    public static void entryForDoctors() {


    }
    public static void patientEntrance() {


    }

    public static void main(String[] args) {

        
        choiceDoctorOrPatient();
        
    }
}
