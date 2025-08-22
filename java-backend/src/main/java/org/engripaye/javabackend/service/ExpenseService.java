package org.engripaye.javabackend.service;

import lombok.RequiredArgsConstructor;
import org.engripaye.javabackend.model.Expense;
import org.engripaye.javabackend.repository.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepo expenseRepo;

    // create or save a new expense
    public Expense saveExpense(Expense expense){
        return expenseRepo.save(expense);
    }

    // get all expense
    public List<Expense> getAllExpense() {
        return expenseRepo.findAll();
    }

    // find expense by ID
    public Optional<Expense> getExpenseById(Long id){
        return expenseRepo.findById(id);
    }

    // update an existing expense
    public Expense updateExpense(Long id, Expense updatedExpense){
        return expenseRepo.findById(id)
                .map(exising -> {
                    exising.setCategory(updatedExpense.getCategory());
                    exising.setAmount(updatedExpense.getAmount());
                    exising.setDate(updatedExpense.getDate());
                    return expenseRepo.save(exising);
                }).orElseThrow(() -> new RuntimeException("Expense not found with id; " + id));
    }

    // delete expense by Id
    public void deleteExpense(Long id) {
        if(!expenseRepo.existsById(id)){
            throw new RuntimeException("Expense not found with id: " + id);
        }
        expenseRepo.deleteById(id);
    }

    // Get expense by category
    public List<Expense> getExpenseByCategory(String category){
        return expenseRepo.findByCategory(category);
    }
}
