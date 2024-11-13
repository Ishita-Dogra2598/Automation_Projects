package demo.wrappers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




import java.time.Duration;

public class Wrappers  {
    /*
     * Write your selenium wrappers here
     */
      ChromeDriver driver;
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      public Wrappers( ChromeDriver driver)
      {
         this.driver=driver;
      }
      public void openUrl(String url)

      {
        driver.get(url);
      }
      
      public void  implicitWait()
      {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      }

      private  static void clickaction(ChromeDriver driver,WebElement element)
      {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
      }


      private void enterinput(String input ,WebElement element)
      {
           element.sendKeys(input);
      }


      private String  DateChanger()
      {
        LocalDate currDate=LocalDate.now();
        LocalDate minus7days=currDate.minusDays(7);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatDate=minus7days.format(formatter);
        return formatDate;
      }

      public void NameQuestion( String Answer)
      {
        try {
          WebElement NameTextbox = driver.findElement(By.xpath("//div[text()='Your answer']//preceding-sibling::input"));
          Thread.sleep(1000);
          enterinput(Answer, NameTextbox);
          
        } catch (Exception e) {
          System.out.println(e);
        }
       
      }

      public void practicingAutomationQuestion(String Answer)
      {
        try{
        long epoch = System.currentTimeMillis() / 1000;
        String EpochTime = String.valueOf(epoch);
        WebElement PracticeAutomationTextbox = driver.findElement(By.xpath("//textarea[@aria-label='Your answer']"));
        Thread.sleep(1000);
        enterinput(Answer+ EpochTime, PracticeAutomationTextbox);
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }

      public void ExpirenceinAutomationQuestion(String option)
      {
        try{
        WebElement Radiot=driver.findElement(By.xpath("//div[@data-value='"+option+"']"));
        Thread.sleep(2000);
        clickaction(driver, Radiot);
        }
        catch(Exception e){
          System.out.println(e);
        }
      }

      public void ToolsLearnedQuestion(String option1,String option2,String option3)
      {
        String[] arr={option1,option2,option3};
        for(int i=0;i<3;i++)
        {
          
          WebElement ToolBox=driver.findElement(By.xpath("//div[@data-answer-value='"+arr[i]+"']"))   ; 
          clickaction(driver, ToolBox);
        }
      }

            


      public void SalutationQuestion()
      {
        try {
          WebElement ParentDropdownLocator = driver.findElement(By.xpath("//div[contains(@class,'DEh1R')]"));
          clickaction(driver, ParentDropdownLocator);
          Thread.sleep(1000);
          WebElement DropdownOptions = driver.findElement(By.xpath("//div[@role='option' and @data-value='Ms']"));
          clickaction(driver, DropdownOptions);
           Thread.sleep(1000);
          
        } catch (Exception e) {
          System.out.println(e);
        } 
      
      }

      public void PreviousDateQuestion()
      {

        WebElement Prevdate=driver.findElement(By.xpath("//input[@max='2074-01-01']"));     
        enterinput(DateChanger(), Prevdate);
      }


      public void TimeQuestion(String Hour,String Minutes)
      {
        WebElement HourText = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        wait.until(ExpectedConditions.visibilityOf(HourText));
        HourText.sendKeys(Hour);
        WebElement MinText = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        wait.until(ExpectedConditions.visibilityOf(MinText));
        MinText.sendKeys(Minutes);
      }

      public void SubmitButton()
      {
        try {
          WebElement Submit=driver.findElement(By.xpath("//div[@aria-label='Submit']"));
        Thread.sleep(3000);
        clickaction(driver,Submit);
        WebElement Message=driver.findElement(By.xpath("//div[@class='vHW8K']"));
        Thread.sleep(3000);
        System.out.println(Message.getText());
          
        } catch (Exception e) {
          System.out.println(e);
        }
        
      }



}
