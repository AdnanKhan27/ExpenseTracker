package com.hemlata.app.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hemlata.app.dao.ExpenseRepository;
import com.hemlata.app.entity.ExpenseStorage;

@Component
public class ScheduledTasks {

	@Autowired
	private ExpenseRepository theExpenseRepository;
	
	/**
     * Method for deleting all record from all the tables
     * every 15 minutes
     */
    @Scheduled(fixedRate = 900000)
    public void databaseCleanUp() {	
    	theExpenseRepository.deleteAll();
    	
    	theExpenseRepository.save(new ExpenseStorage("Me","Soap",3, "2020-01-21", "Utilities"));
    	theExpenseRepository.save(new ExpenseStorage("Mom","Food", 120, "2020-02-17", "Groceries"));
    	theExpenseRepository.save(new ExpenseStorage("Bro","Movie", 12, "2020-05-12", "Entertainment"));
    	theExpenseRepository.save(new ExpenseStorage("Dad","Bus ticket", 10, "2020-06-22", "Transportation"));
    	theExpenseRepository.save(new ExpenseStorage("Me","Vegetables", 30, "2020-03-18", "Groceries"));
    	theExpenseRepository.save(new ExpenseStorage("Me","Flight Ticket", 200, "2020-09-04", "Transportation"));
    	theExpenseRepository.save(new ExpenseStorage("Me","Movie",20, "2020-01-28", "Entertainment"));
    	theExpenseRepository.save(new ExpenseStorage("Me","XBOX",300, "2020-12-21", "Entertainment"));
    }
}
