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

public class Task {
    private String uniqueTaskId;
    private String name;
    private String description;
    
    // CONSTRUCTORS
    public Task(String uniqueTaskId, String name, String desc) {
        setUniqueTaskId(uniqueTaskId);
        setName(name);
        setDescription(desc);
    }
    
    public Task(String uniqueTaskId) {
        setUniqueTaskId(uniqueTaskId);
        name = "";
        description = "";
    }
    
    public Task(String uniqueTaskId, String name) {
        setUniqueTaskId(uniqueTaskId);
        setName(name);
        description = "";
    }
    
    public Task() {
        uniqueTaskId = "";
        name = "";
        description = "";
    }
    
    // GETTERS & SETTERS
    public String getUniqueTaskId() {
        return uniqueTaskId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    // The task object shall have a required unique task ID String that
    // cannot be longer than 10 characters. The task ID shall not be
    // null and shall not be updatable.
    public void setUniqueTaskId(String uniqueTaskId) {
        assert uniqueTaskId != null && uniqueTaskId.length() <= 10 : "ERROR: `Id` must between 1-10 characters";
        this.uniqueTaskId = uniqueTaskId;
    }
    
    // The task object shall have a required name String field that cannot
    // be longer than 20 characters. The name field shall not be null.
    public void setName(String name) {
        assert name != null && name.length() <= 20 : "ERROR: `Name` must be between 1-20 characters";
        this.name = name;
    }
    
    // The task object shall have a required description String field that cannot
    // be longer than 50 characters. The description field shall not be null.
    public void setDescription(String description) {
        assert description != null && description.length() <= 50 : "ERROR: `Description` must be between 1-50 characters";
        this.description = description;
    }
}
