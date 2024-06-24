package com.scm.Supply.chain.apis.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
}
