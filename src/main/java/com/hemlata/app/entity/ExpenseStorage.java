package com.hemlata.app.entity;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
 * Class: This is the entity class which is linked with the database.
 */

@Entity
@Table(name="expense")
public class ExpenseStorage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@NotBlank(message="This field is mandatory.")	
	@Column(name="owner")
	public String owner;

	@NotBlank(message="This field is mandatory.")
	@Column(name="product")
	public String product;

	@NotNull(message="This field is mandatory.")
	@Min(value=0, message="must be greater than or equal to zero")
	@Column(name="cost")
	public Integer cost;

	@NotBlank(message="This field is mandatory.")
	@Column(name="date")
	public String date;

	@Column(name="category")
	public String category;

	@Transient
	private String errorMsg;

	public ExpenseStorage() {
		errorMsg = "";
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		Date dateObj = new Date();
		this.date = formatter.format(dateObj); 
	}

	public ExpenseStorage(@NotBlank(message = "This field is mandatory.") String owner,
			@NotBlank(message = "This field is mandatory.") String product,
			@NotNull(message = "This field is mandatory.") @Min(value = 0, message = "must be greater than or equal to zero") Integer cost,
			@NotBlank(message = "This field is mandatory.") String date, String category) {
		this.owner = owner;
		this.product = product;
		this.cost = cost;
		this.date = date;
		this.category = category;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getProduct() {		
		return product;
	}
	public void setProduct(String product) {	
		this.product = product;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {				
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/*
	 * Function: Convert the date in the given format. 
	 */
	public void setDateInSpecificFormat(String requiredFormat) {
		if(this.date != null) {
			List<String> dateFormats = Arrays.asList("MM/dd/yyyy", "yyyy-MM-dd");
			for(String dateFormat: dateFormats) {
				try {
					Date parsedDate = new SimpleDateFormat(dateFormat).parse(this.date);				
					this.date = new SimpleDateFormat(requiredFormat).format(parsedDate);
				} catch (ParseException e) {
					System.out.println("Unable to parse the date = " + this.date);					
				}
			}
		} 
	}


	@Override
	public String toString() {
		return "ExpenseStorage [id=" + id + ", owner=" + owner + ", product=" + product + ", cost=" + cost + ", date="
				+ date + ", category=" + category + "]";
	}


}
