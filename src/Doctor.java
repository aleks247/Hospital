

import java.util.List;

public class Doctor implements AllHours, Sortable {
    private int doctorId;
    private String firstName;
    private String lastName;

    private String speciality;

    Doctor(int doctorId, String firstName, String lastName, String speciality) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    public int getDoctorId() {
        return doctorId;
    }


    public String getFirstName() {
        return firstName;
    }


    @Override
    public void seeAllHours(List<Appointment> appointmentList, int doctorId) {
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getDoctorId() == doctorId) {
                System.out.println(appointmentList.get(i));
            }
        }
        System.out.println();
    }


    @Override
    public void sortAllSavedClasses(List<Appointment> appointmentList, int id) {
        System.out.println("to Patient ID: a-z -> 1");
        System.out.println("to DATE: -> 2 ");

        appointmentList.get(id).sortID(appointmentList);



    }

    @Override
    public void groupingOfPatients(List<Appointment> appointmentList, int id) {

    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }


}
