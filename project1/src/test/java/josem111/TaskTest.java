package josem111;

import org.junit.jupiter.api.*;

import josem111.taskService.Task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {
    // Dependency injecting our task
    Task testTask;
    
    // DUMMY DATA
    String expectedID, expectedName, expectedDescription;
    String failingID, failingName, failingDescription;
    
    @BeforeEach
    void setUp() {
        expectedID = "1234567890";
        expectedName = "DEFAULT TESTING NAME";
        expectedDescription = "THIS IS THE TASK DESCRIPTION";
        failingID = "1234567890345678432";
        failingName = "THIS TASK NAME IS GOING TO FAIL BECAUSE IT IS WAY TO LONG INDEED";
        failingDescription = "ALWAYS AND FOREVER. EACH MOMENT WITH YOUUUU. ITS JUST LIKE A DREAM TO ME. LOL...THIS WILL FAIL";
    }
    
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll: TEST [TASK_TEST]-->BEGINS");
    }
    
    @AfterAll
    public static void tearDownAll() {
        System.out.println("tearDownAll: TEST [TASK_TEST]-->ENDS");
        System.out.println("\n[ ALL TEST PASSED [TASK_TEST] ✅]");
    }
    
    // GETTERS TESTS
    @Test
    void getUniqueTaskIDTest() {
        testTask = new Task(expectedID);
        assertEquals(expectedID, testTask.getUniqueTaskId());
    }
    
    @Test
    void getNameTest() {
        testTask = new Task(expectedID, expectedName);
        assertEquals(expectedName, testTask.getName());
    }
    
    @Test
    void getDescriptionTest() {
        testTask = new Task(expectedID, expectedName, expectedDescription);
        assertEquals(expectedDescription, testTask.getDescription());
    }
    
    // SETTERS TESTS
    @Test
    void setNameTest() {
        testTask = new Task();
        testTask.setName(expectedName);
        assertEquals(expectedName, testTask.getName());
    }
    
    
    
    @Test
    void setDescriptionTest() {
        testTask = new Task();
        testTask.setDescription(expectedDescription);
        assertEquals(expectedDescription, testTask.getDescription());
    }
    
    // PURPOSELY FAILING TEST
    @Test
    void failingUniqueIDTest() {
        assertThrows(AssertionError.class, () -> new Task(failingID));
    }
    
    @Test
    void failingNameTest() {
        testTask = new Task();
        assertThrows(AssertionError.class, () -> testTask.setName(failingName));
    }
    
    @Test
    void setFailingDescriptionTest() {
        testTask = new Task();
        assertThrows(AssertionError.class, () -> testTask.setDescription(failingDescription));
    }
    
    // NULL CHECK TESTS
    @Test
    void uniqueTaskIDNullTest() {
        assertThrows(AssertionError.class, () -> new Task(null));
    }
    
    @Test
    void nameNullTest() {
        testTask = new Task();
        assertThrows(AssertionError.class, () -> testTask.setName(null));
    }
    
    @Test
    void taskDescriptionNullTest() {
        testTask = new Task();
        assertThrows(AssertionError.class, () -> testTask.setDescription(null));
    }
}