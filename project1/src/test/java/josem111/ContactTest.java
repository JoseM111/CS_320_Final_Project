package josem111;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import josem111.contactService.Contact;

class ContactTest {
    // Dependency injecting our contact
    Contact testContact;
    
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll: TEST [CONTACT_TEST]-->BEGINS");
    }
    
    @AfterAll
    public static void tearDownAll() {
        System.out.println("tearDownAll: TEST [CONTACT_TEST]-->ENDS");
        System.out.println("\n[ ALL TEST PASSED ✅]");
    }
    
    @BeforeEach
    public void setup() {
        testContact = new Contact(
                "001",
                "Jose",
                "Martinez",
                "1234567897",
                "21 Jump St"
        );
    }
    
    @Test
    void testGetContactID() {
        assertEquals("001", testContact.getContactID());
    }
    
    @Test
    void testGetFirstName() {
        assertEquals("Jose", testContact.getFirstName());
    }
    
    @Test
    void testGetLastName() {
        assertEquals("Martinez", testContact.getLastName());
    }
    
    @Test
    void testGetPhoneNumber() {
        assertEquals("1234567897", testContact.getPhoneNumber());
    }
    
    @Test
    void testGetAddress() {
        assertEquals("21 Jump St", testContact.getAddress());
    }
    
    @Test
    void testToString() {
        assertEquals("""
                          \n=========================================================
                            Contact: {
                              contactID: 001
                              firstName: Jose
                              lastName: Martinez
                              phoneNumber: 1234567897
                              address: 21 Jump St
                            }
                        =========================================================\040\040
                                   """,
                testContact.toString()
        );
    }
}

