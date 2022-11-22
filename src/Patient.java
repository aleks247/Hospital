import java.util.Scanner;

public class Patient implements Login{
    private int patientId;
    private String firstName;
    private String lastName;
    private int age;
    Patient(int patientId, String firstName, String lastName, int age){
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void seeAllHours(){

    }
    public void changeDateForViewing(int appointmentId){

    }
    public void declineRecordedTime(int appointmentId){

    }
    public void sortAllSavedClasses(){

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
