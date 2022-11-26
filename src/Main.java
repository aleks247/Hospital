import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Doctor> doctorsList = new ArrayList<>();
    static List<Patient> patientList = new ArrayList<>();
    static List<Appointment> appointmentList = new ArrayList<>();

    public static void printMenu() {
        System.out.println("Exit -> 0 ");
        System.out.println("Doctor -> 1 ");
        System.out.println("Patient -> 2");
        System.out.println("Appointments -> 3");
        System.out.print("Choose your role : ");
        selectionMenu();
    }

    public static void loadListsOfObjects(){
        String fileNameDoctors = "doctors.csv";
        readingAvailableInformation(fileNameDoctors);

        String fileNamePatient = "patients.csv";
        readingAvailableInformation(fileNamePatient);

        String filenameAppointment = "appointments.csv";
        readingAvailableInformation(filenameAppointment);
    }

    public static void selectionMenu() {
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                entryForDoctor();
            }
            case 2 -> {
                entryForPatient();
            }
            case 0 -> {
                System.out.println("EXIT !");
            }
            default -> {
                System.out.println("Please enter a valid option ! ");
                printMenu();
            }
        }
    }

    public static void readingAvailableInformation(String fileName) { //четене от файл и разделяне по запетайки и изпращане на инф
        try {                                                         //към метода за създаване на обекти
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] personalInformation = line.split(",");
                if (fileName.equalsIgnoreCase("doctors.csv")) {
                    creationListExcellentDoctors(personalInformation);
                } else if (fileName.equalsIgnoreCase("patients.csv")) {
                    createListExcellentPatients(personalInformation);
                } else {
                    createListExcellentAppointment(personalInformation);
                }
            }
        } catch (Exception e) {
            System.out.println(e + "Error");
        }
    }

    public static void creationListExcellentDoctors(String[] doctorInf) { //създаване на обекти от подадена инф от метода за четене
        Doctor doctor = new Doctor(Integer.parseInt(doctorInf[0]), doctorInf[1], doctorInf[2], doctorInf[3]);
        doctorsList.add(doctor);
    }

    public static void createListExcellentPatients(String[] PatientInf) { //създаване на обекти от подадена инф от метода за четене
        Patient patient = new Patient(Integer.parseInt(PatientInf[0]), PatientInf[1], PatientInf[2], Integer.parseInt(PatientInf[3]));
        patientList.add(patient);
    }

    public static void createListExcellentAppointment(String[] appointmentInf) {//създаване на обекти от подадена инф от метода за четене
        Appointment appointment = new Appointment(Integer.parseInt(appointmentInf[0]), Integer.parseInt(appointmentInf[1]), appointmentInf[2], appointmentInf[3], appointmentInf[4], Integer.parseInt(appointmentInf[5]));
        appointmentList.add(appointment);
    }

    public static void entryForDoctor() {
        boolean successfulLogin = false;
        while (!successfulLogin) {
            System.out.println("Entry ID number: ");
            int id = scanner.nextInt();
            System.out.println("Entry name: ");
            String name = scanner.next();

            for (int i = 0; i < doctorsList.size(); i++) {
                if (doctorsList.get(i).getDoctorId() == id && doctorsList.get(i).getFirstName().equalsIgnoreCase(name)) {
                    doctorsMenu(id);
                    successfulLogin = true;
                }
            }
            if (!successfulLogin) {
                System.out.println("Invalid doctor data...");
            }
        }
    }

    public static void doctorsMenu(int id) {
        System.out.println("to group patients -> 1 ");
        System.out.println("Sort by all reserved appointments of doctor -> 2");
        System.out.println("see all hours -> 3");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                doctorsList.get(id).groupingOfPatients();
            }
            case 2 -> {
                doctorsList.get(id).sortAllSavedClasses();
            }
            case 3 -> {
                doctorsList.get(id).seeAllHours();
            }
            default -> {
                patientMenu(id);
            }
        }
    }

    public static void entryForPatient() {
        boolean successfulLogin = false;
        while (!successfulLogin) {
            System.out.println("Entry ID");
            int id = scanner.nextInt();
            System.out.println("entry name");
            String name = scanner.next();

            for (int i = 0; i < patientList.size(); i++) {
                if (patientList.get(i).getPatientId() == id && patientList.get(i).getFirstName().equalsIgnoreCase(name)) {
                    patientMenu(id);
                    successfulLogin = true;
                }
            }
            if (!successfulLogin){
                System.out.println("Invalid patient data...");
            }
        }
    }

    public static void patientMenu(int id) {
        System.out.println("to change date for viewing -> 1 ");
        System.out.println("decline recorded Time -> 2");
        System.out.println("see all hours -> 3");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                patientList.get(id).changeDateForViewing(appointmentList);
            }
            case 2 -> {
                patientList.get(id).declineRecordedTime(appointmentList);
            }
            case 3 -> {// Готово
                patientList.get(id).seeAllHours(appointmentList);
            }
            default -> {
                patientMenu(id);
            }
        }
    }

    public static void main(String[] args) {
        loadListsOfObjects();
        printMenu();
    }
}
