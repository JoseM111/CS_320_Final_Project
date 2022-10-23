package josem111;

import org.junit.jupiter.api.*;

import josem111.taskService.TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskServiceTest {
    // dependency injecting our `TaskService`
    TaskService testTaskService;
    // DUMMY DATA
    private String name, description;
    private String failingName, failingDescription;
    
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll: TEST [TASK_SERVICE_TEST]-->BEGINS");
    }
    
    @AfterAll
    public static void tearDownAll() {
        System.out.println("tearDownAll: TEST [TASK_SERVICE_TEST]-->ENDS");
        System.out.println("\n[ ALL TEST PASSED [TASK_SERVICE_TEST] ✅]");
    }
    
    @BeforeEach
    void setUp() {
        name = "MAKING SURE THIS-20";
        description = "WE ARE TRYING TO MAKE SURE THIS IS LESS 50";
        failingName = "THIS SHOULD FAIL BIG TIME FOR SURE...";
        failingDescription = "QWERTYUIOPLKJHGFDSAZXCVBNMKLKJHGFDSAQWERTYUIOPPPPPPPLKJHGFDSAZXCVBNMKLOIUYTREWSDFGTBHJ";
    }
    
    // CREATE OR DELETE TEST
    @Test
    void newTaskTest() {
        testTaskService = new TaskService();
        TaskServiceTest.this.testTaskService.addNewTask();
        
        Assertions.assertNotNull(TaskServiceTest.this.testTaskService.getTasks().get(0).getUniqueTaskId());
        Assertions.assertNotEquals("", TaskServiceTest.this.testTaskService.getTasks().get(0).getUniqueTaskId());
    }
    
    @Test
    void deleteTaskTest() {
        testTaskService = new TaskService();
        TaskServiceTest.this.testTaskService.addNewTask();
        
        assertEquals(1, TaskServiceTest.this.testTaskService.getTasks().size());
        TaskServiceTest.this.testTaskService.deleteTask(TaskServiceTest.this.testTaskService.getTasks().get(0).getUniqueTaskId());
        assertEquals(0, TaskServiceTest.this.testTaskService.getTasks().size());
    }
    
    // GETTER TEST
    @Test
    void taskNameTest() {
        testTaskService = new TaskService();
        TaskServiceTest.this.testTaskService.addNewTask(name);
        Assertions.assertNotNull(TaskServiceTest.this.testTaskService.getTasks().get(0).getName());
        Assertions.assertEquals(name, TaskServiceTest.this.testTaskService.getTasks().get(0).getName());
    }
    
    @Test
    void taskDescriptionTest() {
        testTaskService = new TaskService();
        TaskServiceTest.this.testTaskService.addNewTask(name, description);
        Assertions.assertNotNull(TaskServiceTest.this.testTaskService.getTasks().get(0).getDescription());
        Assertions.assertEquals(description, TaskServiceTest.this.testTaskService.getTasks().get(0).getDescription());
    }
    
    // UPDATE TEST
    @Test
    void updateNameTest() {
        testTaskService = new TaskService();
        TaskServiceTest.this.testTaskService.addNewTask();
        
        TaskServiceTest.this.testTaskService.updateName(TaskServiceTest.this.testTaskService.getTasks().get(0).getUniqueTaskId(), name);
        assertEquals(name, TaskServiceTest.this.testTaskService.getTasks().get(0).getName());
    }
    
    @Test
    void updateDescriptionTest() {
        testTaskService = new TaskService();
        TaskServiceTest.this.testTaskService.addNewTask();
        
        TaskServiceTest.this.testTaskService.updateDescription(
                TaskServiceTest.this.testTaskService.getTasks().get(0).getUniqueTaskId(),
                description
        );
        assertEquals(description, TaskServiceTest.this.testTaskService.getTasks().get(0).getDescription());
    }
    
    // PURPOSELY FAILING TEST
    @Test
    void failingNameTest() {
        testTaskService = new TaskService();
        assertThrows(AssertionError.class, () -> {
            TaskServiceTest.this.testTaskService.addNewTask(failingName);
        });
    }
    
    @Test
    void failingDescriptionTest() {
        testTaskService = new TaskService();
        
        assertThrows(AssertionError.class, () -> {
            TaskServiceTest.this.testTaskService.addNewTask(name, failingDescription);
        });
    }
    
    // NULL TEST
    @Test
    void taskNameNullTest() {
        testTaskService = new TaskService();
        
        assertThrows(AssertionError.class, () -> {
            TaskServiceTest.this.testTaskService.addNewTask(null);
        });
    }
    
    @Test
    void nullDescriptionTest() {
        testTaskService = new TaskService();
        
        assertThrows(AssertionError.class, () -> {
            TaskServiceTest.this.testTaskService.addNewTask(name, null);
        });
    }
    
}




















