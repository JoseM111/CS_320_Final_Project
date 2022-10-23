/**
 * =============================================
 *
 * @Name_of_App : project-1
 * @Date 10-09-22
 * @Class : CS-320
 * @Author : Jose Martinez
 * =============================================
 */

package josem111.taskService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
    // task list to store our task
    private final List<Task> taskList = new ArrayList<>();
    
    // Generates a random unique ID
    private String generateUUID() {
        return UUID.randomUUID().toString().substring(0, 10);
    }
    
    // searches our task in the taskList
    private Task searchForTask(String id) throws Exception {
        int index = 0;
        
        while (index < taskList.size()) {
            if (id.equals(taskList.get(index).getUniqueTaskId())) {
                return taskList.get(index);
            }
            
            index++;
        }
        
        throw new Exception("[ERROR] - The Task id is invalid. Please try again...");
    }
    
    // The task service shall be able to add tasks with a unique ID
    public void addNewTask() {
        Task task = new Task(generateUUID());
        taskList.add(task);
    }
    
    // addNewTask overload method
    public void addNewTask(String name) {
        Task task = new Task(generateUUID(), name);
        taskList.add(task);
    }
    
    // addNewTask overload method
    public void addNewTask(String name, String description) {
        Task task = new Task(generateUUID(), name, description);
        taskList.add(task);
    }
    
    // he task service shall be able to delete tasks per task ID.
    public void deleteTask(String id) {
        try {
            taskList.remove(searchForTask(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // The task service shall be able to update task fields per task ID.
    // The following fields are updatable: name
    public void updateName(String id, String name) {
        try {
            searchForTask(id).setName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // The task service shall be able to update task fields per task ID.
    // The following fields are updatable: description
    public void updateDescription(String id, String desc) {
        try {
            searchForTask(id).setDescription(desc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // returns the entire taskList
    public List<Task> getTasks() {
        return taskList;
    }
}





