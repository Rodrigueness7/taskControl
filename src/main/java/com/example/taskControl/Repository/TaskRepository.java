package com.example.taskControl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskControl.Model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
