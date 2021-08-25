package Air_Bnb_Pages;
import Project_Base.Base.Page_Base;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Search_Results extends Page_Base {
    public Search_Results(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[1]/div/div[2]/div/div/div/div[1]/div/div/span/div/div[2]/div/div[5]/button/span[1]")
    WebElement More_Filters;
    @FindBy(xpath = "/html/body/div[12]/section/div/div/div[2]/div/div[2]/div[1]/section/div/div[2]/div/div[2]/button[2]")
    WebElement Bed_Room;
    //@FindBy(xpath = "/html/body/div[13]/section/div/div/div[2]/div/div[2]/div[1]/section/div/div[2]/div/div[2]/button[2]/span/svg")
    //WebElement Bed_Room;
    @FindBy(id="filterItem-facilities-checkbox-amenities-7-row-checkbox")
   //@FindBy(xpath = "/html/body/div[12]/section/div/div/div[2]/div/div[2]/div[5]/section/div[1]/div[4]/div/div/label/div/div[1]/span/input")
    WebElement Pool;
    @FindBy(xpath = "/html/body/div[12]/section/div/div/div[2]/div/footer/button")
    WebElement Show_Stays;

   /* @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[1]/div/div[1]/section/div[2]/h1")
    WebElement Page_Title;
    @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[1]/div/div[1]/section/div[1]")
    WebElement Result;*/
   // @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div/div/div[1]/main/div/div[1]/div[1]/div[2]/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[2]/a")

    //WebElement Properties;
    Actions action;
    public void Fill_More_Filters (WebDriver driver) throws InterruptedException, IOException, ParseException {

        Thread.sleep(1000);
        clickButton(More_Filters);
        Thread.sleep(1000);
        for(int i=0;i<5;i++) {
            clickButton(Bed_Room);
            Thread.sleep(500);
        }
        action = new Actions(driver);
        action.moveToElement(Pool).click().build().perform();
        //clickButton(Pool);
        Thread.sleep(1000);
        clickButton(Show_Stays);
        Thread.sleep(1000);
    }
/*
    public String VerifySearchResults_Location()
    {//Stays in Metropolitan City of Rome

        String Results_Verification_Location = Page_Title.getText();
        return Results_Verification_Location;
    }

    public String VerifySearchResults_ِAllData()
    {//300+ stays · Sep 24 - 30 · 3 guests


        String Results_Verification_Data = Result.getText();
        return Results_Verification_Data;
    }*/

    public String VerifyFirstProperty(WebDriver driver)
    {String First_Property_Data="";
        List<WebElement> Properties =  driver.findElements(By.className("_fhph4u"));
        if(Properties.size()!=0) {  First_Property_Data = Properties.get(0).getText();}
        return First_Property_Data;
    }
    public void Open_First_Property(WebDriver driver)
    {String First_Property="";
        List<WebElement> Properties =  driver.findElements(By.className("_fhph4u"));
        Properties.get(0).click();}

}
