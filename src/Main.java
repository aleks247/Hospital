import java.io.BufferedReader;
import java.io.FileReader;
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
            case 1 -> {
                String fileNameDoctors = "doctors.txt";  //doctors.csv
                readingAvailableInformation(fileNameDoctors);
            }
            case 2 -> {
                String fileNamePatient = "patients.csv";  //patient.csv
                readingAvailableInformation(fileNamePatient);
            }
            case 3 -> {
                String fileAppointments = "appointments.txt"; //appointments.csv
                readingAvailableInformation(fileAppointments);
            }
            case 0 -> System.out.println("EXIT !");
            default -> {
                System.out.println("Please enter a valid option ! ");
                printMenu();
            }
        }
    }

    public static void readingAvailableInformation(String fileName) { //четене от файл и разделяне по запетайки и изпращане на инф
        try {//към метода за създаване на обекти
           FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] personalInformation = line.split(",");
                if (fileName.equalsIgnoreCase("doctors.txt")) { //doctors.csv
                    creationListExcellentDoctors(personalInformation);
                } else if (fileName.equalsIgnoreCase("patients.csv")) { //patient.csv
                    createListExcellentPatients(personalInformation);
                } else {
                    createListExcellentAppointment(personalInformation); //appointments.csv
                }
            }
        } catch (Exception e) {
            System.out.println(e + "Error");
        }
    }

    public static void creationListExcellentDoctors(String[] doctorInf) { //създаване на обекти от подадена инф от метода за четене
        Doctor doctor = new Doctor(Integer.valueOf(doctorInf[0]), doctorInf[1], doctorInf[2], doctorInf[3]);
        System.out.println(doctor);
        entryForDoctors(doctor);
    }

    public static void createListExcellentPatients(String[] PatientInf) { //създаване на обекти от подадена инф от метода за четене
        Patient patient = new Patient(Integer.valueOf(PatientInf[0]), PatientInf[1], PatientInf[2], Integer.valueOf(PatientInf[3]));
        System.out.println(patient);
    }

    public static void createListExcellentAppointment(String[] appointmentInf) {//създаване на обекти от подадена инф от метода за четене
        Appointment appointment = new Appointment(Integer.valueOf(appointmentInf[0]), Integer.valueOf(appointmentInf[1]), appointmentInf[2], appointmentInf[3], appointmentInf[4], Integer.valueOf(appointmentInf[5]));
        System.out.println(appointment);
    }


    public static void entryForDoctors(Doctor doctor) {
        System.out.println("Enter your id: ");
        int IdDoctor= scanner.nextInt();
        System.out.println("enter your first name: ");
        String doctorName= scanner.next();
        boolean Id=doctor.getDoctorId()==IdDoctor;
        boolean name=doctor.getFirstName().equalsIgnoreCase(doctorName);

        // да се направи метод който да сравнява въведените параметри дали са еднакви с параметрите
        //от подадените файлове които сме ги създали като обекти в ArrayLıst за Doctor

    }

    public static void patientEntrance() {
        System.out.println("Enter your id: ");
        int IdPatient= scanner.nextInt();
        System.out.println("enter your first name: ");
        String patientName= scanner.next();
         // да се направи метод който да сравнява въведените параметри дали са еднакви с параметрите
        //от подадените файлове които сме ги създали като обекти в ArrayLıst за Patients
    }

    public static void main(String[] args) {
        printMenu();
        
    }
}

