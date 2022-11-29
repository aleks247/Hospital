import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    public void returnReadyFileTextChangeDate() {
        Patient patient = new Patient(1, "Ivan", "Dimitrov", 28);
    }
}