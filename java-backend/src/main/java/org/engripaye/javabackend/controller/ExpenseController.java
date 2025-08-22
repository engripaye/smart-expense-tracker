package org.engripaye.javabackend.controller;

import lombok.RequiredArgsConstructor;
import org.engripaye.javabackend.model.Expense;
import org.engripaye.javabackend.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    // create a new expense
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense){
        return expenseService.saveExpense(expense);
    }

    // get all expenses
    @GetMapping
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpense();
    }

    // get a single expenses by id
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
    }

    // update an existing expense
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense){
        return expenseService.updateExpense(id, expense);
    }

    // delete an expense by Id
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return "expense with id " + id + " deleted successfully";
    }

    // get expense by category
    @GetMapping("/category/{category}")
    public List<Expense> getByCategory(@PathVariable String category){
        return expenseService.getExpenseByCategory(category);
    }

    // call python services for analytics
    @GetMapping("/summary")
    public String getExpenseBySummary() {
        RestTemplate restTemplate = new RestTemplate();
        String pythonServiceUrl = "http://localhost:8001/analyze"; // Python FastAPI endpoint
        return restTemplate.getForObject(pythonServiceUrl, String.class);
    }
}

