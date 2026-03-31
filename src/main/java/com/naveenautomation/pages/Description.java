package com.naveenautomation.pages;

public class Description {
	
	//Page Object Model design pattern says that for every web page that exist on the application, there we be coresponding page class will which will be creating in our framework and that page class
	//consists of web elements and all the actions that intend to perform on all the elements. For each web page  there will be corrspsponding test class.
	//POM design pattern says that every webpage that exist on your application there will be corresponding
		//page class where you will identify all the elements and you will create methods to perform actions over those webelements.
		//For each page class that resides in your project there will be coressponding test class where test cases will be written
		// and assertion will be performed.In this, we do some kind of abstraction between elements and test cases.
	
	
	
	//Q2. Why webdriver should be static in base class?
	//Ans.Webdriver is not dependent upon testbase class. It is not only the instance of test base class. it is something which will be same in the whole project. Once initialized It is the same value no matter
	//from where you are calling in the project.If its change then it will be change for whole project.Static means it is not dependent upon instance.
	
	
	
	
	//Q3. Soft Assertion: it means whenever test fails then it will not be terminated. It will go to next line.
	//    Hard Assertion: It means the test stops immediately  and throw showing exception.
	
	//Q4. What is page chaining model?
	//Ans: In this method of one page returns the object of another page on which we are performing any action. Basically we use this when need to navigate to another page.
	
	
   //Q5.Why pageFactory is inside the constructor of any page class?
	//Ans:because when the object is created of any class then it will first call the constructor of class and webElements got initialized with the driver of class.
	
	
	//When we get StaleElementException?
	//Ans. It happens because when a webdriver find an element using any locator, it assigns alpha-numeric id to the element. so, now for the whole script, the context of webdriver
	//will be with the refernce to that id not with that locator. When we refersh the page or we navigate b/w pages that reference needs to get updated as old 
	//reference does not exist there. If we do not reinitialize the webdriver to find all the elements, then we get this exception. To overcome this problem, Pagefactory
	//comes into picture by rerurning the object of that page which is opening.
	
	
	//Q what are the diff exceptions you have faced in automation???
	//Ans: NoSuchElementException, ElementClickInterceptedException,StaleElementreferenceException
	
	
	
	//When we running the script, we performed so many actions clicking button, open the tab, entering the text, select the option from dropdown etc, but we are not aware w
	//what is happening behind it.SO, to track all these activities, we need a logging. So, if we have 800 test cases and when I see report 400 test cases
	//are failed, So its very difficult to check every single test case one by one. So, we can check the logs at that time and do necessary action either webdriver is not
	//able to interact with the element or clicking on element will open the corresponding page etc.
	
	
	
	//What are the diff depencdencies you have used in your project?
	//testNG, Selenium, WebManager, 
}
