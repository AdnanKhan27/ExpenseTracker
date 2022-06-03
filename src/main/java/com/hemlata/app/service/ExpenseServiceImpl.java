package com.hemlata.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemlata.app.dao.ExpenseRepository;
import com.hemlata.app.dao.ICostAndDateQuery;
import com.hemlata.app.dao.ICostAndMonthQuery;
import com.hemlata.app.dao.ICostAndYearQuery;
import com.hemlata.app.entity.ExpenseStorage;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;

	/*
	 * Function: Save the expense record in the database.
	 */
	public void save(ExpenseStorage theExpense) {
		expenseRepository.save(theExpense);
	}

	/*
	 * Function: get the expense list by month.
	 */
	public List<ExpenseStorage> getListByMonth(String MONTH, String YEAR) {
		return expenseRepository.findByMonth(MONTH, YEAR);
	}
	
	/*
	 * Function: Get the expense list by Id.
	 */
	public Optional<ExpenseStorage> findById(int id) {
		return expenseRepository.findById(id);
	}
	
	/*
	 * Function: Check whether the entry exists in the database or not.
	 */
	public boolean existById(int id) {
		return expenseRepository.existsById(id);
	}
	
	/*
	 * Function: Delete the entry by Id.
	 */
	public void deleteById(int id) {
		expenseRepository.deleteById(id);
	}
	
	/*
	 * Function: Retrieve the data for updating the exist entry in the database.
	 */
	@SuppressWarnings("deprecation")
	public ExpenseStorage retreiveForUpdate(int id) {
		return expenseRepository.getOne(id);
	}
	
	/*
	 * Function: Check whether the data with same entry already present or not.
	 */
	public boolean expenseEntryIsPresent(ExpenseStorage theExpenseStorage) {
		List<ExpenseStorage> expenseList = expenseRepository.expenseEntryIsPresent(theExpenseStorage.getOwner(), 
				theExpenseStorage.getProduct(), theExpenseStorage.getCost().toString(), 
				theExpenseStorage.getDate(), theExpenseStorage.getCategory());
		
		if(expenseList.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public List<ICostAndDateQuery>  getCostByDateList(String Month, String Year) {		
		return expenseRepository.getCostByDateList(Month, Year);
	}

	public List<ICostAndMonthQuery> getCostByMonthList() {
		return expenseRepository.getCostByMonthList();
	}
	
	public List<ICostAndYearQuery> getCostByYearList() {
		return expenseRepository.getCostByYearList();
	}
}
