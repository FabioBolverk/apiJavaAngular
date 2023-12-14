package oi.github.cursofabio.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import oi.github.cursofabio.todo.model.Todo;

public interface todoRepository extends JpaRepository<Todo,Long>{

}
