package co.grandcircus.Capstone6.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.grandcircus.Capstone6.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	List<User> findByEmailIgnoreCase(String email);
}
