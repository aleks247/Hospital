
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Appointment implements Comparable<Appointment>{

    private int appointmentId;
    private int patient_id;
    private String typeOfExamination;
    private String date;
    private String time;
    private int doctorId;

    public int getDoctorId() {
        return doctorId;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public String getDate() {
        return date;
    }


    Appointment(int appointmentId, int patient_id, String typeOfExamination, String date, String time, int doctorId) {
        this.appointmentId = appointmentId;
        this.patient_id = patient_id;
        this.typeOfExamination = typeOfExamination;
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "Аppointment{" +
                "appointmentId=" + appointmentId +
                ", patient_id=" + patient_id +
                ", typeOfExamination='" + typeOfExamination + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", doctorId=" + doctorId +
                '}';
    }

    public void sortID(List<Appointment>appointmentList){
        List<Appointment>sortedListAppointment=new ArrayList<>();
        for (int i = 0; i <appointmentList.size() ; i++) {
            sortedListAppointment.add(appointmentList.get(i));
        }
        Collections.sort(sortedListAppointment);
        for (int i = 0; i <sortedListAppointment.size() ; i++) {
            System.out.println(sortedListAppointment.get(i));
        }
    }

    @Override
    public int compareTo(Appointment a) {
        return this.patient_id-a.getPatient_id();
    }


}
