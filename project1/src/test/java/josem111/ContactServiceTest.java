package josem111;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import josem111.contactService.ContactService;

class ContactServiceTest {
    // Dependency injecting our contact service
    ContactService testContactService;
    
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll: TEST [CONTACT_SERVICE_TEST]-->BEGINS");
    }
    
    @BeforeEach
    public void setup() {
        testContactService = new ContactService();
    }
    
    @AfterAll
    public static void tearDownAll() {
        System.out.println("tearDownAll: TEST [CONTACT_SERVICE_TEST]-->ENDS");
        System.out.println("\n[ ALL TEST PASSED ✅]");
    }
    
    @Test
    public void testAddContact() {
        // uniqueID auto increments so this has an ID = 1
        testContactService.addNewContact("Bobby", "Shumrda", "1653346886", "105 The truth st");
        // uniqueID auto increments so this has an ID = 2
        testContactService.addNewContact("Lady", "Luck", "2323875564", "1 battle road");
        
        // Should be uniqueID: 1 = `Bobby`
        assertEquals("1", testContactService.contactHashMap.get("1").getContactID());
        // Should be uniqueID: 2 = `Lady`
        assertEquals("2", testContactService.contactHashMap.get("2").getContactID());
        
        // Making sure each ID is unique
        assertNotEquals(
                testContactService.contactHashMap.get("1").getContactID(),
                testContactService.contactHashMap.get("2").getContactID()
        );
    }
    
    @Test
    public void testDeleteContact() {
        // uniqueID auto increments so this has an ID = 1
        testContactService.addNewContact("Lionel", "Richie", "1212345655", "12 hello st");
        // uniqueID auto increments so this has an ID = 2
        testContactService.addNewContact("Kobe", "Bryant", "3426221176", "13 cross over road");
        
        // Should delete ID = 1
        testContactService.deleteContact("1");
        
        // Should not be a part of the hashMap anymore: name = Lionel
        assertFalse(testContactService.contactHashMap.containsKey("1"));
        // Should still be a part of the hashMap: name = Kobe
        assertTrue(testContactService.contactHashMap.containsKey("2"));
    }
    
    @Test
    public void testUpdateFirstName() {
        // New contact with an ID = 1
        testContactService.addNewContact("Lionel", "Richie", "1212345655", "12 hello st");
        // Updates first name
        testContactService.updateFirstName("1", "Rich");
        
        assertEquals("Rich", testContactService.contactHashMap.get("1").getFirstName());
    }
    
    @Test
    public void testUpdateLastName() {
        // New contact with an ID = 1
        testContactService.addNewContact("Kobe", "Bryant", "3426221176", "13 cross over road");
        // Updates first name
        testContactService.updateLastName("1", "Mamba");
        
        assertEquals("Mamba", testContactService.contactHashMap.get("1").getLastName());
    }
    
    @Test
    public void testUpdatePhoneNumber() {
        // New contact with an ID = 1
        testContactService.addNewContact("Kobe", "Bryant", "3426221176", "13 cross over road");
        // Updates phone number
        testContactService.updatePhoneNumber("1", "4545123499");
        
        assertEquals("4545123499", testContactService.contactHashMap.get("1").getPhoneNumber());
    }
    
    @Test
    public void testUpdateAddress() {
        // New contact with an ID = 1
        testContactService.addNewContact("Kobe", "Bryant", "3426221176", "13 cross over road");
        // Updates phone number
        testContactService.updateAddress("1", "Mamba's LA walkway");
        
        assertEquals("Mamba's LA walkway", testContactService.contactHashMap.get("1").getAddress());
    }
}

