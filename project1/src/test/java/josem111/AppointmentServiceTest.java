package josem111;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import josem111.appointmentService.AppointmentService;

class AppointmentServiceTest {
    // dependency injecting our `AppointmentService`
    AppointmentService testAppointmentService;
    
    // DUMMY DATA
    private String appointmentID, description;
    private Date appointmentDate;
    
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll: TEST [APPOINTMENT_SERVICE_TEST]-->BEGINS");
    }
    
    @AfterAll
    public static void tearDownAll() {
        System.out.println("tearDownAll: TEST [APPOINTMENT_SERVICE_TEST]-->ENDS");
        System.out.println("\n[ ALL TEST PASSED [APPOINTMENT_SERVICE_TEST] ✅]");
    }
    
    @SuppressWarnings("deprecation")
	@BeforeEach
    void setUp() {
        appointmentID = "1234567890";
        description = "THIS DESCRIPTION SHOULD PASS THE UNIT-TEST!";
        //noinspection deprecation
        appointmentDate = new Date(2027, Calendar.APRIL, 17);
    }
    
    // CREATE AN APPOINTMENT TEST
    @Test
    void createNewAppointmentTest() {
        // Instantiate new instance of AppointmentService
        testAppointmentService = new AppointmentService();
        
        // Test the generation of a valid new appointment with ID
        testAppointmentService.createNewAppointment();
        testAppointmentService.createNewAppointment(appointmentDate);
        testAppointmentService.createNewAppointment(appointmentDate, description);
        
        // Test if each getAppointmentID works
        assertNotNull(testAppointmentService.getAllAppointments().get(0).getAppointmentID());
        assertNotNull(testAppointmentService.getAllAppointments().get(1).getAppointmentID());
        assertNotNull(testAppointmentService.getAllAppointments().get(2).getAppointmentID());
        
        // Test if each getAppointmentDate works
        assertNotNull(testAppointmentService.getAllAppointments().get(0).getAppointmentDate());
        assertNotNull(testAppointmentService.getAllAppointments().get(1).getAppointmentDate());
        assertNotNull(testAppointmentService.getAllAppointments().get(2).getAppointmentDate());
        
        // Test if each getDescription() works
        assertNotNull(testAppointmentService.getAllAppointments().get(0).getDescription());
        assertNotNull(testAppointmentService.getAllAppointments().get(1).getDescription());
        assertNotNull(testAppointmentService.getAllAppointments().get(2).getDescription());
    }
    
    // REMOVE AN APPOINTMENT TEST
    @Test
    void cancelAppointmentTest() throws Exception {
        // Instantiate new instance of AppointmentService
        testAppointmentService = new AppointmentService();
    
        testAppointmentService.createNewAppointment();
        testAppointmentService.createNewAppointment();
        testAppointmentService.createNewAppointment();
    
        // Creating an ID for our appointment
        String appointmentID1 = testAppointmentService.getAllAppointments().get(0).getAppointmentID();
        
        // Canceling the appointmentID1 by ID and ensure that it was cancelled
        testAppointmentService.cancelAppointment(appointmentID1);
        
        assertThrows(Exception.class, () -> {
            testAppointmentService.cancelAppointment(appointmentID1);
        });
        
        assertNotEquals(
                appointmentID1,
                testAppointmentService.getAllAppointments()
                        .get(0).getAppointmentID()
        );
    }
    
    // CHECKING FOR DUPLICATE APPOINTMENTS TEST
    @Test
    void duplicateAppointmentTest() {
        testAppointmentService = new AppointmentService();
        
        // Call three new appointments
        testAppointmentService.createNewAppointment();
        testAppointmentService.createNewAppointment();
        testAppointmentService.createNewAppointment();
        
        // Create variables for each id of each new appointment
        String appointmentID1 = testAppointmentService.getAllAppointments().get(0).getAppointmentID();
        String appointmentID2 = testAppointmentService.getAllAppointments().get(1).getAppointmentID();
        String appointmentID3 = testAppointmentService.getAllAppointments().get(2).getAppointmentID();
        
        // Ensure that there are no duplicates
        assertNotEquals(appointmentID, appointmentID1);
        assertNotEquals(appointmentID, appointmentID2);
        assertNotEquals(appointmentID, appointmentID3);
        assertNotEquals(appointmentID1, appointmentID2);
        assertNotEquals(appointmentID1, appointmentID3);
        assertNotEquals(appointmentID2, appointmentID3);
    }
}