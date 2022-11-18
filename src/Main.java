import java.io.BufferedReader;
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
        System.out.println("Appointments -> 3");
        System.out.print("Choose your role : ");
        selectionMenu();
    }

    public static void selectionMenu() {
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                String fileNameDoctors = "doctors.txt";  //doctors.csv
                readingAvailableInformation(fileNameDoctors);
                break;
            case 2:
                String fileNamePatient = "patients.txt";  //patient.csv
                readingAvailableInformation(fileNamePatient);
                break;
            case 3:
                String fileAppointments = "appointments.txt"; //appointments.csv
                readingAvailableInformation(fileAppointments);
            case 0:
                System.out.println("EXIT !");
                break;
            default:
                System.out.println("Please enter a valid option ! ");
                printMenu();
                break;
        }
    }

    public static void readingAvailableInformation(String fileName) { //четене от файл и разделяне по запетайки и изпращане на инф
        try {                                                         //към метода за създаване на обекти
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] personalInformation = line.split(",");
                if (fileName.equalsIgnoreCase("doctors.txt")) { //doctors.csv
                    creationListExcellentDoctors(personalInformation);
                } else if (fileName.equalsIgnoreCase("patients.txt")) { //patient.csv
                    createListExcellentPatients(personalInformation);
                } else {
                    createListExcellentAppointment(personalInformation); //appointments.csv
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Doctor> creationListExcellentDoctors(String[] doctorInf) { //създаване на обекти от подадена инф от метода за четене
        List<Doctor> doctorsList = new ArrayList<>();
        Doctor doctor = new Doctor(Integer.valueOf(doctorInf[0]), doctorInf[1], doctorInf[2], doctorInf[3]);
        doctorsList.add(doctor);
        for (int i = 0; i < doctorsList.size(); i++) {
            System.out.println(doctorsList.get(i));
        }
        return doctorsList;
    }

    public static List<Patient> createListExcellentPatients(String[] PatientInf) { //създаване на обекти от подадена инф от метода за четене
        List<Patient> patientList = new ArrayList<>();
        Patient patient = new Patient(Integer.valueOf(PatientInf[0]), PatientInf[1], PatientInf[2], Integer.valueOf(PatientInf[3]));
        patientList.add(patient);
        for (int i = 0; i < patientList.size(); i++) {
            System.out.println(patientList.get(i));
        }
        return patientList;
    }

    public static List<Appointment> createListExcellentAppointment(String[] appointmentInf) {//създаване на обекти от подадена инф от метода за четене
        List<Appointment> appointmentsList = new ArrayList<>();
        Appointment appointment = new Appointment(Integer.valueOf(appointmentInf[0]), Integer.valueOf(appointmentInf[1]), appointmentInf[2], appointmentInf[3], appointmentInf[4], Integer.valueOf(appointmentInf[5]));
        appointmentsList.add(appointment);
        for (int i = 0; i < appointmentsList.size(); i++) {
            System.out.println(appointmentsList.get(i));
        }
        return appointmentsList;
    }


    public static void entryForDoctors() {
        // да се направи метод който да сравнява въведените параметри дали са еднакви с параметрите
        //от подадените файлове които сме ги създали като обекти в ArrayLıst за Doctor

    }

    public static void patientEntrance() {
         // да се направи метод който да сравнява въведените параметри дали са еднакви с параметрите
        //от подадените файлове които сме ги създали като обекти в ArrayLıst за Patients
    }

    public static void main(String[] args) {
        printMenu();



    }
}

