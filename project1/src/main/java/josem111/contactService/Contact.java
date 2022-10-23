/**
 * =============================================
 *
 * @Name_of_App : project-1
 * @Date 10-09-22
 * @Class : CS-320
 * @Author : Jose Martinez
 * =============================================
 */

package josem111.contactService;

public class Contact {
    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    
    // CONSTRUCTOR
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        // Since the condition is always true if the length
        // is >=10 then we do not need to do && != null
        if (contactID.length() > 10) return; // will return null
        this.contactID = contactID;
        
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phone);
        this.setAddress(address);
    }
    
    // GETTERS & SETTERS
    public String getContactID() {
        return contactID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    // Won't allow a first name > than a String of 10
    public void setFirstName(String firstName) {
        if (firstName.length() > 10) return;
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    // Won't allow a last name > than a String of 10
    public void setLastName(String lName) {
        if (lName.length() > 10) return; // will return null
        this.lastName = lName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    // phone number must be exactly a String of 10 (numbers) long
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10) return; // will return null
        this.phoneNumber = phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    // Address cannot be longer than a String 30
    public void setAddress(String address) {
        if (address.length() > 30) return; // will return null
        this.address = address;
    }
    
    @Override
    public String toString() {
        return Contact.toStrFormatter(
                contactID,
                firstName,
                lastName,
                phoneNumber,
                address
        );
    }
    
    // TO-STRING HELPER
    static String toStrFormatter(Object... args) {
        return (
                """
                \n=========================================================
                  Contact: {
                    contactID: %s
                    firstName: %s
                    lastName: %s
                    phoneNumber: %s
                    address: %s
                  }
              =========================================================\040\040
                         """
        ).formatted(args);
    }
}
