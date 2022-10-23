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

import java.util.HashMap;

public class ContactService {
    public HashMap<String, Contact> contactHashMap = new HashMap<>();
    int uniqueID = 0;
    
    public void addNewContact(String firstName, String lastName, String phoneNumber, String address) {
        uniqueID++;
        String newUniqueID = Integer.toString(uniqueID);
        
        Contact newContact = new Contact(newUniqueID, firstName, lastName, phoneNumber, address);
        contactHashMap.put(newContact.getContactID(), newContact);
    }
    
    //Deletes a Contact object.
    public void deleteContact(String uniqueID) {
        contactHashMap.remove(uniqueID);
    }
    
    //Updates an already established first name.
    public void updateFirstName(String uniqueID, String firstName) {
        if (!contactHashMap.containsKey(String.valueOf(ContactService.this.uniqueID))) return;
        contactHashMap.get(uniqueID).setFirstName(firstName);
    }
    
    //Updates an already established last name.
    public void updateLastName(String uniqueID, String lastName) {
        if (!contactHashMap.containsKey(String.valueOf(ContactService.this.uniqueID))) return;
        contactHashMap.get(uniqueID).setLastName(lastName);
    }
    
    //Updates an already established phone number.
    public void updatePhoneNumber(String uniqueID, String phoneNumber) {
        if (!contactHashMap.containsKey(String.valueOf(ContactService.this.uniqueID))) return;
        contactHashMap.get(uniqueID).setPhoneNumber(phoneNumber);
    }
    
    //Updates an already established address.
    public void updateAddress(String uniqueID, String address) {
        if (!contactHashMap.containsKey(String.valueOf(ContactService.this.uniqueID))) return;
        contactHashMap.get(uniqueID).setAddress(address);
    }
}

