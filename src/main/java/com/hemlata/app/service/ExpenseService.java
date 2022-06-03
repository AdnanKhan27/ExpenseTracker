package com.hemlata.app.service;

import java.util.List;
import java.util.Optional;

import com.hemlata.app.dao.ICostAndDateQuery;
import com.hemlata.app.dao.ICostAndMonthQuery;
import com.hemlata.app.dao.ICostAndYearQuery;
import com.hemlata.app.entity.ExpenseStorage;

public interface ExpenseService {

	public List<ExpenseStorage> getListByMonth(String MONTH, String YEAR);
	
	public void save(ExpenseStorage theExpense);
	
	public Optional<ExpenseStorage> findById(int id);
	
	public boolean existById(int id);
	
	public void deleteById(int id);
	
	public ExpenseStorage retreiveForUpdate(int id);
	
	public boolean expenseEntryIsPresent(ExpenseStorage theExpenseStorage);
	
	public List<ICostAndDateQuery>  getCostByDateList(String Month, String Year);
	
	public List<ICostAndMonthQuery> getCostByMonthList();
	
	public List<ICostAndYearQuery> getCostByYearList();
}
