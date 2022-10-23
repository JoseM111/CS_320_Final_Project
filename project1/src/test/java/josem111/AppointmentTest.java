package josem111;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import josem111.appointmentService.Appointment;

class AppointmentTest {
    // dependency injecting our `Appointment`
    Appointment testAppointment;
    
    // DUMMY DATA
    private String appointmentID, description;
    private Date appointmentDate;
    private String failingAppointmentID, failingDescription;
    private Date failingAppointmentDate;
    
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll: TEST [APPOINTMENT_TEST]-->BEGINS");
    }
    
    @AfterAll
    public static void tearDownAll() {
        System.out.println("tearDownAll: TEST [APPOINTMENT_TEST]-->ENDS");
        System.out.println("\n[ ALL TEST PASSED [APPOINTMENT_TEST] ✅]");
    }
    
    @SuppressWarnings("deprecation")
	@BeforeEach
    void setUp() {
        appointmentID = "1234567890";
        description = "THIS DESCRIPTION SHOULD PASS THE UNIT-TEST!";
        appointmentDate = new Date(2027, Calendar.APRIL, 17);
        
        failingAppointmentID = "01-THIS SHOULD FAIL";
        failingAppointmentDate = new Date(0);
        failingDescription = "THIS IS GONNA SERVE AS A FAILED TEST THAT MAKES THE DESCRIPTION FAR BEYOND 50 CHARACTERS";
    }
    
    // GETTER TEST
    @Test
    void getAppointmentIDTest() {
        testAppointment = new Appointment(appointmentID);
        assertNotNull(testAppointment.getAppointmentID());
        assertEquals(10, testAppointment.getAppointmentID().length());
    }
    
    @Test
    void getAppointmentDateTest() {
        testAppointment = new Appointment(appointmentID, appointmentDate);
        assertNotNull(testAppointment.getAppointmentDate());
        assertEquals(appointmentDate, testAppointment.getAppointmentDate());
    }
    
    @Test
    void getDescriptionTest() {
        testAppointment = new Appointment(appointmentID, appointmentDate, description);
        assertNotNull(testAppointment.getDescription());
        assertTrue(testAppointment.getDescription().length() < 51);
        assertEquals(description, testAppointment.getDescription());
    }
    
    // SETTER TEST
    @Test
    void setAppointmentIDTest() {
        testAppointment = new Appointment();
        testAppointment.setAppointmentID(appointmentID);
        
        assertEquals(appointmentID, testAppointment.getAppointmentID());
    }
    
    @Test
    void setAppointmentDateTest() {
        testAppointment = new Appointment();
        testAppointment.setAppointmentDate(appointmentDate);
        
        assertEquals(appointmentDate, testAppointment.getAppointmentDate());
    }
    
    
    @Test
    void setDescriptionTest() {
        testAppointment = new Appointment();
        testAppointment.setDescription(description);
        
        assertEquals(description, testAppointment.getDescription());
    }
    
    // PURPOSELY FAILING TEST
    @Test
    void failingSetAppointmentIDTest() {
        testAppointment = new Appointment();
        
        assertThrows(AssertionError.class, () -> {
            testAppointment.setAppointmentID(failingAppointmentID);
        });
    }
    
    @Test
    void failingSetAppointmentDateTest() {
        testAppointment = new Appointment();
        
        assertThrows(AssertionError.class, () -> {
            testAppointment.setAppointmentDate(failingAppointmentDate);
        });
    }
    
    @Test
    void failingSetDescriptionTest() {
        testAppointment = new Appointment();
        
        assertThrows(AssertionError.class, () -> {
            testAppointment.setDescription(failingDescription);
        });
    }
    
    // NULL TEST
    @Test
    void setAppointmentIDNullTest() {
        testAppointment = new Appointment();
        
        assertThrows(NullPointerException.class, () -> {
            testAppointment.setAppointmentID(null);
        });
    }
    
    @Test
    void setAppointmentDateNullTest() {
        testAppointment = new Appointment();
        
        assertThrows(NullPointerException.class, () -> {
            testAppointment.setAppointmentDate(null);
        });
    }
    
    @Test
    void setDescriptionNullTest() {
        testAppointment = new Appointment();
        
        assertThrows(NullPointerException.class, () -> {
            testAppointment.setDescription(null);
        });
    }
}
