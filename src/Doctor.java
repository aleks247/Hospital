public class Doctor implements Login{
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

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }

    @Override
    public void login() {

    }
}
