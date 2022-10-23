/**
 * =============================================
 *
 * @Name_of_App : project-1
 * @Date 10-09-22
 * @Class : CS-320
 * @Author : Jose Martinez
 * =============================================
 */

package josem111.appointmentService;

import java.util.Date;
import java.util.Objects;

public class Appointment {
    // initialize variables
    private String appointmentID;
    private Date appointmentDate;
    private String description;
    
    // DEFAULT CONSTRUCTOR
    public Appointment() {
        Date today = new Date();
        appointmentID = "";
        appointmentDate = today;
        description = "";
    }
    
    // CONSTRUCTOR FOR APPOINTMENT_ID
    public Appointment(String appointmentID) {
        Date today = new Date();
        setAppointmentID(appointmentID);
        this.appointmentDate = today;
        description = "";
    }
    
    // CONSTRUCTOR FOR APPOINTMENT_DATE
    public Appointment(String appointmentID, Date date) {
        setAppointmentID(appointmentID);
        setAppointmentDate(date);
        description = "";
    }
    
    // CONSTRUCTOR FOR DESCRIPTION
    public Appointment(String appointmentID, Date date, String description) {
        setAppointmentID(appointmentID);
        setAppointmentDate(date);
        setDescription(description);
    }
    
    // GETTERS & SETTERS
    public String getAppointmentID() {
        return appointmentID;
    }
    
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setAppointmentID(String appointmentID) {
        Objects.requireNonNull(appointmentID, "[ERROR]: must have an appointment ID");
        assert appointmentID.length() <= 10 : "[ERROR]: appointment ID cannot be longer than 10 characters";
        
        this.appointmentID = appointmentID;
    }
    
    public void setAppointmentDate(Date date) {
        Objects.requireNonNull(date, "[ERROR]: date can't be null");
        assert !date.before(new Date()) : "[ERROR]: the date cannot be before today's date";
        
        this.appointmentDate = date;
    }
    public void setDescription(String description) {
        Objects.requireNonNull(description, "[ERROR]: description can't be null.");
        assert description.length() <= 50 : "ERROR: description cannot be longer than 50 characters.";
        
        this.description = description;
    }
}
