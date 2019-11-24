package co.grandcircus.Capstone6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Capstone6.Model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
