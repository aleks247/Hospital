public class Appointment {

    private int appointmentId;
    private int patient_id;
    private String typeOfExamination;
    private String date;
    private String time;
    private int doctorId;

      Appointment(int appointmentId, int patient_id, String typeOfExamination, String date, String time, int doctorId) {
        this.appointmentId = appointmentId;
        this.patient_id = patient_id;
        this.typeOfExamination = typeOfExamination;
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;
    }

    public int getPatient_id() { return patient_id; }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patient_id=" + patient_id +
                ", typeOfExamination='" + typeOfExamination + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", doctorId=" + doctorId +
                '}';
    }
}
