import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
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
                readingAvailableDoctоrs();
                break;
            case 2:
                patientEntrance();
                break;
            case 0:
                System.out.println("EXIT");
                break;
            default:
                System.out.println("Please enter a valid option ! ");
                printMenu();
                break;
        }
    }

    public static void readingAvailableDoctоrs() {
        File doctorsFile = new File("doctors.txt");
        try {
            FileReader fileReader = new FileReader(doctorsFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] doctorInf = line.split(",");
                creationListExcellentDoctors(doctorInf);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Doctor> creationListExcellentDoctors(String[] doctorInf) {
            List<Doctor> doctorsList = new ArrayList<>();
            Doctor doctor = new Doctor(Integer.valueOf(doctorInf[0]), doctorInf[1], doctorInf[2], doctorInf[3]);
            doctorsList.add(doctor);
            for (int i = 0; i < doctorsList.size(); i++) {
                System.out.println(doctorsList.get(i));
            }
        return doctorsList;
    }

    public static void entryForDoctors() {

    }

    public static void patientEntrance() {

    }

    public static void main(String[] args) {
        printMenu();







    }
}

