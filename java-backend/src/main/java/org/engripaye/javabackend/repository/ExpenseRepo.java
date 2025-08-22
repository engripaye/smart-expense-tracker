package org.engripaye.javabackend.repository;

import org.engripaye.javabackend.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory(String category);
}
