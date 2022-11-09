public class Аppointment {
    private int appointmentId;
    private int patient_id;
    private String typeOfExamination;
    private String date;
    private String time;
    private int doctorId;

    public Аppointment(int appointmentId, int patient_id, String typeOfExamination, String date, String time, int doctorId) {
        this.appointmentId = appointmentId;
        this.patient_id = patient_id;
        this.typeOfExamination = typeOfExamination;
        this.date = date;
        this.time = time;
        this.doctorId = doctorId;
    }
}
