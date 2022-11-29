import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Patient implements Login {
    private int patientId;
    private String firstName;
    private String lastName;
    private int age;

    private static Scanner scan = new Scanner(System.in);

    Patient(int patientId, String firstName, String lastName, int age) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void seeAllHours(List<Appointment> appointmentList) {
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getPatient_id() == getPatientId() - 1) {
                System.out.println(appointmentList.get(i));
            }
        }
    }

    private Appointment createListOfOnePatientAppointments(List<Appointment> appointmentList, int appointmentID) {
        Appointment appointment = null;
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getAppointmentId() == appointmentID) {
                if (appointmentList.get(i).getPatient_id() == getPatientId() - 1) {
                    appointment = appointmentList.get(i);
                }
            }
        }
        return appointment;
    }

    public String ReturnReadyFileTextChangeDate(String fileName, int appointmentId) {
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            Scanner input = new Scanner(System.in);
            String result = "";

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] split_data = data.split(",");
                if (split_data[0].equals(Integer.toString(appointmentId))) {
                    System.out.println("Input Date");
                    split_data[3] = input.nextLine();
                    System.out.println("The date has been set to " + split_data[3]);
                }
                result = result + Arrays.toString(split_data) + "\n";
            }
            return result;
        } catch (Exception e) {
            return e + "Error";
        }
    }

    public void changeDateForAppointmentMainMethod(int appointment_id, List<Appointment> appointmentList, Appointment appointment) {
        try {
            String fileName = "appointments.csv";
            File file = new File(fileName);

            String ready_text = ReturnReadyFileTextChangeDate("appointments.csv", appointment.getAppointmentId());

            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(ready_text);
            myWriter.close();
        } catch (Exception e) {
            System.out.println(e + "Error");
        }// Трябва да се напрви така че след всяко ползване на този метод да се махат квадратните скоби от appointments.csv
    }

    public void changeDateForAppointment(List<Appointment> appointmentList) {
        Appointment appointment = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Appointment ID");
        int appointment_id = input.nextInt();
        boolean isAppointmentExisting = false;

        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getAppointmentId() == appointment_id) {
                if (appointmentList.get(i).getPatient_id() == getPatientId() - 1) {
                    isAppointmentExisting = true;
                    appointment = appointmentList.get(i);
                    changeDateForAppointmentMainMethod(appointment_id, appointmentList, appointment);
                } else {
                    System.out.println("This appointment isn't on your ID !");
                }
            }
        }

        if (isAppointmentExisting = false) {
            System.out.println("This appointment isn't existing !");
        }
    }

    public String ReturnReadyFileText(String fileName, int appointmentId) {
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            String result = "";

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] split_data = data.split(",");
                if (!split_data[0].equals(Integer.toString(appointmentId))) {
                    result = result + data + "\n";
                }
            }
            return result;
        } catch (Exception e) {
            return e + "Error";
        }
    }

    public void cancelRegisteredAppointmentMainMethod(int appointment_id, List<Appointment> appointmentList, Appointment appointment) {
        try {
            String fileName = "appointments.csv";
            File file = new File(fileName);

            String ready_text = ReturnReadyFileText("appointments.csv", appointment.getAppointmentId());

            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(ready_text);
            myWriter.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void declineRecordedTime(List<Appointment> appointmentList) {
        Appointment appointment = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Appointment ID");
        int appointmentID = input.nextInt();
        boolean isAppointmentExisting = false;

        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getAppointmentId() == appointmentID) {
                if (appointmentList.get(i).getPatient_id() == getPatientId()) {
                    isAppointmentExisting = true;
                    appointment = appointmentList.get(i);
                    cancelRegisteredAppointmentMainMethod(appointmentID, appointmentList, appointment);
                } else {
                    System.out.println("This appointment isn't on your ID !");
                }
            }
        }
        if (isAppointmentExisting = false) {
            System.out.println("This appointment isn't existing !");
        }
    }

    @Override
    public void login() {

    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
//Вход като пациент:
//	•	Системата подканва потребителя да въведе своето уникално patient_id и първото си име
//	•	При неуспешен вход, потребителят отново се поканва да въведе своите данни до успешно въведена комбинация
//	•	При успешен вход (пациент с такова потребителско име и парола съществува) на потребителя се дава възможност за следните операции:
//	◦	Визуализация на всички записани часове за текущия пациент !!
//	◦	Промяна на датата/часа на записан час (по подадено appointment_id)
//	◦	Отказване от записан час (по подадено appointment_id)
