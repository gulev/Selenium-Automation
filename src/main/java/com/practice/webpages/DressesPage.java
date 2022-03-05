package com.practice.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;


public class DressesPage {
    private WebDriver driver;
    static final Logger logger = Logger.getLogger(DressesPage.class);

    @FindBy(css = "#categories_block_left .title_block")
    private WebElement heading;

    @FindBy(linkText = "JOIN TOPTAL")
    private WebElement joinToptalButton;

    //Constructor
    public DressesPage(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //We will use this boolean for assertion. To check if page is opened
    public boolean isPageOpened(){
        logger.info(heading.getText().toString());
        return heading.getText().toString().contains("Dresses");
    }

    public void clikOnJoin(){
        joinToptalButton.click();
    }
}