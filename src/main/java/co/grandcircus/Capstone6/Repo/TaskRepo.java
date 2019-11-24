package co.grandcircus.Capstone6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.grandcircus.Capstone6.Model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer>{
}
