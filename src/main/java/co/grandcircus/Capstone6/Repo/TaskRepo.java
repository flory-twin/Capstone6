package co.grandcircus.Capstone6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Capstone6.Model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer>{

}
