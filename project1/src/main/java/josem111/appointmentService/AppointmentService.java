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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
    // A LIST TO STORE ALL THE APPOINTMENTS
    public List<Appointment> appointmentList = new ArrayList<>();
    
    // RETRIEVES ALL THE APPOINTMENTS
    public List<Appointment> getAllAppointments() {
        return appointmentList;
    }
    
    // GENERATES A UNIQUE ID FO EACH APPOINTMENT CREATED
    private String generateAppointmentUUID() {
        return UUID.randomUUID().toString().substring(0, 10);
    }
    
    // CREATES A NEW APPOINTMENT
    public void createNewAppointment() {
        Appointment appointment = new Appointment(generateAppointmentUUID());
        appointmentList.add(appointment);
    }
    
    // CREATES A NEW APPOINTMENT BASED ON THE DATE (OVER-LOADED METHOD)
    public void createNewAppointment(Date date) {
        Appointment appointment = new Appointment(generateAppointmentUUID(), date);
        appointmentList.add(appointment);
    }
    
    // CREATES A NEW APPOINTMENT BASED ON THE DATE & DESCRIPTION (OVER-LOADED METHOD)
    public void createNewAppointment(Date date, String description) {
        Appointment appointment = new Appointment(generateAppointmentUUID(), date, description);
        appointmentList.add(appointment);
    }
    
    // DELETES AN APPOINTMENT FROM THE APPOINTMENT LIST
    public void cancelAppointment(String id) throws Exception {
        appointmentList.remove(searchForAppointment(id));
    }
    
    // SEARCHES FOR A SPECIFIC APPOINTMENT BY ID (HELPER METHOD)
    private Appointment searchForAppointment(String id) throws Exception {
        int index = 0;
        
        while (index < appointmentList.size()) {
            if (id.equals(appointmentList.get(index).getAppointmentID())) {
                return appointmentList.get(index);
            }
            
            index++;
        }
        
        throw new Exception("The appointment does not exist!");
    }
}
