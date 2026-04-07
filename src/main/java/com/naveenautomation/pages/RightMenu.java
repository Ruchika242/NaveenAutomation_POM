package com.naveenautomation.pages;

public enum RightMenu {
	
		
		MYACC("My Account"),
		EDIT("Edit Account"),
		PWD("Password"),
	    ADDBOOK("Address Book"),
	    WISHLIST("Wish List"),
	    ORDERHISTORY("Order History"),
	    DOWNLOAD("Downloads"),
	    RECURRINGPAYMENT("Recurring payments"),
	    REWARDS("Reward Points"),
	    RETURN("Returns"),
	    TRANSACTION("Transactions"),
	    NEWSLETTER("Newsletter");
	    
	
	    private String value; 
		
		RightMenu(String value) {
			this.value=value;
		}

	
		public String getValue() {
			return value;
		}

}
