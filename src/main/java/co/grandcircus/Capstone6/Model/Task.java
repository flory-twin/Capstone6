package co.grandcircus.Capstone6.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task
{
   private static final String taskInfoFormat = "%14s: %-50s\n";
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private User creator;
   private String taskDescription;
   //TODO While the date doesn't have any specified functionality, may want to swap for Java Date and DateFormat.
   private String dateDue;
   //TODO Swap for enum so the logic is a little more transparent.
   private boolean completion;
   
   
   public Task() {
      super();
   }
   
   public Task(User creator, String taskDescription, String date, boolean completion) {
      this();
      this.creator = creator;
      this.taskDescription = taskDescription;
      this.dateDue = date;
      this.completion = completion;
   }
   
   public Task(Integer id, User creator, String taskDescription, String date, boolean completion) {
	   this(creator, taskDescription, date, completion);
	   this.id = id;
   }
   
   
   
   
   public String getTaskDescription() {
		return taskDescription;
	}
	
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	public String getDateDue() {
		return dateDue;
	}
	
	public void setDateDue(String dateDue) {
		this.dateDue = dateDue;
	}
	
	public boolean isComplete() {
		return completion;
	}
	
	public void setIsComplete(boolean completeIfTrue) {
		this.completion = completeIfTrue;
	}
	
	public Integer getId() {
		return id;
	}
	
	public User getCreator() {
		return creator;
	}

   /*
    * Override this so task equality checks work...
    * They should be by value, NOT by identity. The TaskList is for tracking/manipulating any semantics around the identity of a Task.  
    */
   @Override
   public boolean equals(Object RHS)
   {
      // BOILERPLATE:
      //  Is the other Object null? We know that this one isn't...
      if (RHS == null)
      {
         return false;
      }
      //  Is the other Object of the same class?
      if((RHS.getClass() != this.getClass())) {
         return false;
      }
      
      // SEMANTICS:
      //  Are all data fields the same?
      Task RHSasTask = (Task) RHS;
      
      if (this.isComplete()          == RHSasTask.isComplete() &&
          this.getCreator().equals(     RHSasTask.getCreator()) &&
          this.getId()               == RHSasTask.getId() &&
          this.getTaskDescription()  == RHSasTask.getTaskDescription() &&
          this.getDateDue()          == RHSasTask.getDateDue())
      {
         return true;
      }

      // If no other path has returned, return false.
      return false;
   }
   
   /*
   public String toString() {
      return "  TASK: \n" +
             String.format(taskInfoFormat, "Complete", this.getCompletionStatus() ) +
             String.format(taskInfoFormat, "Due Date", this.getDueDate() ) +
             String.format(taskInfoFormat, "Assigned To", this.getAssignedUser() ) +
             String.format(taskInfoFormat, "Description", this.getDescription() );
   }
   */
}
