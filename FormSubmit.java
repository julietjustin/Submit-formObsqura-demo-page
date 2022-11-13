package com.obsqura.TestNGAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormSubmit extends BaseFormSubmitPage {
	@Test(description="click on form submit link")
	public void ClickFormSubmitLink() {
		driver.findElement(By.xpath("//a[@href='form-submit.php']")).click();
		Assert.assertTrue(true);
	}
	@Test(description="Check headder of the page")
	public void checkHeadder() {
		String inputHeadder="Form with validations",outputHeadder;
		outputHeadder=driver.findElement(By.xpath("(//div[@class='card-header'])[2]")).getText();
		Assert.assertTrue(outputHeadder.equals(inputHeadder), "Not Same");
	}
	@Test(description="fields")
	public void checkingField(){
		String inputMessage="Form has been submitted successfully!",outputMessage;
		boolean buttonEnable;
		boolean flag=false;
		driver.findElement(By.xpath("//input[@id='validationCustom01']")).sendKeys("Juliet");
		driver.findElement(By.xpath("//input[@id='validationCustom02']")).sendKeys("Justin");
		driver.findElement(By.xpath("//input[@id='validationCustomUsername']")).sendKeys("julietjustin");
		driver.findElement(By.xpath("//input[@id='validationCustom03']")).sendKeys("Alappuzha");
		driver.findElement(By.xpath("//input[@id='validationCustom04']")).sendKeys("Kerala");
		driver.findElement(By.xpath("//input[@id='validationCustom05']")).sendKeys("688505");
		driver.findElement(By.xpath("//input[@id='invalidCheck']")).click();
		buttonEnable=driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isEnabled();
		if(buttonEnable==true) {
			flag=true;
		}
		Assert.assertTrue(flag, "Button Is Not Enabled");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		outputMessage=driver.findElement(By.xpath("//div[@id='message-one']")).getText();
		Assert.assertTrue(inputMessage.equals(outputMessage), "The message is not correct");
	}
	@Test(description="placing of Agree to terms and conditions")
	public void textPlacing() {
		boolean flag=false;
		Point location1=driver.findElement(By.xpath("//label[@class='form-check-label']")).getLocation();
		int locationY1=location1.getY();
		Point location2=driver.findElement(By.xpath("//button[@class='btn btn-primary']")).getLocation();
		int locationY2=location2.getY();
		if(locationY1<locationY2) {
			flag=true;
		}
		Assert.assertTrue(flag, "Text Is Not In The Correct Placing");
	}
	@Test(description="Using getSize")
	public void getSize() {
		Dimension size;//variable initialized using dimention
		size=driver.findElement(By.xpath("//button[@class='btn btn-primary']")).getSize();
		Assert.assertTrue(true);
	}
	@Test(description="Checking Submit Form Button colour using css value")
	public void buttonBackgroundColour(){
		String backGroundColour,inputBackColour="rgba(0, 123, 255, 1)";
		backGroundColour=driver.findElement(By.xpath("//button[@class='btn btn-primary']")).getCssValue("background-color");
		Assert.assertTrue(backGroundColour.equals(inputBackColour), "Colour Not Matching");
	}
	@Test(description="Checking Submit Form Button Text colour using css value")
	public void buttonTextColour() {
		String textColour,inputColour="rgba(255, 255, 255, 1)";
		textColour=driver.findElement(By.xpath("//button[@class='btn btn-primary']")).getCssValue("color");
		Assert.assertTrue(textColour.equals(inputColour), "The Colours are not matching");
		
	}
	@Test(description="Using isDisplayed,isSelected")
	public void checkingButton() {
		boolean displayed,selected;
		boolean flag=false;
		displayed=driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isDisplayed();
		if(displayed==true) {
			flag=true;
		}
		Assert.assertTrue(flag, "Not Displaying");
		selected=driver.findElement(By.xpath("//button[@class='btn btn-primary']")).isSelected();
		if(selected==false) {
			flag=true;
		}
		Assert.assertTrue(flag, "Not Selected");
	}
	@Test(description="checking button tagname")
	public void getTagName() {
		String outputTagName,inputTagname="button";
		outputTagName=driver.findElement(By.xpath("//button[@class='btn btn-primary']")).getTagName();
		Assert.assertTrue(outputTagName.equals(inputTagname), "TagName Not Correct");
	}
	@Test(description="checking button attribute")
	public void getAttributeClass() {
		String outputAttributeClass,inputAttributeClass="btn btn-primary";
		outputAttributeClass=driver.findElement(By.xpath("//button[@class='btn btn-primary']")).getAttribute("class");
		Assert.assertTrue(outputAttributeClass.equals(inputAttributeClass), "Attribute name not correct");
	}
	
}
	
