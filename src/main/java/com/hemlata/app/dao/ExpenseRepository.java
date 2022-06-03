package com.hemlata.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hemlata.app.entity.ExpenseStorage;

public interface ExpenseRepository extends JpaRepository<ExpenseStorage, Integer> {

	@Query(value="SELECT id, owner, product, cost, DATE_FORMAT(date, '%m-%d-%Y') as 'date',"
			+ " category FROM expense where month(date) = :MONTH AND year(date) = :YEAR",
			nativeQuery = true)
	public List<ExpenseStorage> findByMonth(@Param("MONTH") String MONTH, @Param("YEAR") String YEAR);

	@Query(value="SELECT id, owner, product, cost, DATE_FORMAT(date, '%m-%d-%Y') as 'date',"
			+ " category FROM expense where owner = :OWNER AND product = :PRODUCT AND cost = :COST AND"
			+ " date = :DATE AND category = :CATEGORY",
			nativeQuery = true)
	public List<ExpenseStorage> expenseEntryIsPresent(@Param("OWNER") String OWNER,@Param("PRODUCT")
	String PRODUCT,@Param("COST") String COST, @Param("DATE") String DATE, @Param("CATEGORY") String CATEGORY);
	
	@Query(value="SELECT sum(cost) as 'cost', DATE_FORMAT(e.date, '%m-%d-%Y') as 'date' FROM "
			+ "expense as e where month(e.date) = :MONTH AND year(e.date) = :YEAR GROUP BY date",
			nativeQuery = true)
	public List<ICostAndDateQuery> getCostByDateList(@Param("MONTH") String MONTH, @Param("YEAR") String YEAR);
	
	@Query(value="SELECT sum(cost) as 'cost', month(date) as 'month' FROM expense GROUP BY month",
			nativeQuery = true)
	public List<ICostAndMonthQuery> getCostByMonthList();
	
	@Query(value="SELECT sum(cost) as 'cost', year(date) as 'year' FROM expense GROUP BY year",
			nativeQuery = true)
	public List<ICostAndYearQuery> getCostByYearList();
}
