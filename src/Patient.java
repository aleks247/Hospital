import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient implements Login{
    private int patientId;
    private String firstName;
    private String lastName;
    private int age;

    private static Scanner scan = new Scanner(System.in);
    
    Patient(int patientId, String firstName, String lastName, int age){
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

    public void seeAllHours(List<Appointment> appointmentList){
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getPatient_id() == getPatientId()-1){
                System.out.println(appointmentList.get(i));
            }
        }
    }

    private Object createListOfOnePatientAppointments(List<Appointment>appointmentList, int appointmentID){
        Appointment appointment = null;
        for (int i = 0; i < appointmentList.size(); i++) {
            if(appointmentList.get(i).getAppointmentId() == appointmentID){
                if (appointmentList.get(i).getPatient_id() == getPatientId()-1){
                    appointment = appointmentList.get(i);
                }else { System.out.println("This appointment isn't on your ID !"); }
            }else { System.out.println("This appointment isn't existing !"); }
        }return appointment;
    }

    public void changeDateForViewing(List<Appointment>appointmentList){
    }
    public void declineRecordedTime(List<Appointment>appointmentList){
        System.out.println("Enter appointment id: ");
        int appointmentId = scan.nextInt();
        createListOfOnePatientAppointments(appointmentList, appointmentId);
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
