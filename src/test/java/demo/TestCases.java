package demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.wrappers.Wrappers;


import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation.
     * Follow `testCase01` `testCase02`... format or what is provided in
     * instructions
     */

    /*
     * Do not change the provided methods unless necessary, they will help in
     * automation and assessment
     */
    @BeforeTest
    public void startBrowser() {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

    }

    @AfterTest
    public void endTest() {
        driver.close();
        driver.quit();

    }

    @Test
    public void testCase01() {
        Wrappers wrap=new Wrappers(driver) ;
        //Open the website
        wrap.openUrl("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        //wait for the page to load 
        wrap.implicitWait();
        //1st Question  ---- Name
        wrap.NameQuestion("Crio Learner");
        //2nd Question ----Why are you practicing Automation?
        wrap.practicingAutomationQuestion("I want to be the best QA Engineer!");
        //3rd Question ---How much experience do you have in Automation Testing?
        wrap.ExpirenceinAutomationQuestion("0 - 2");
        //4th Question -----Which of the following have you learned in Crio.Do for Automation Testing?
        wrap.ToolsLearnedQuestion("Java", "Selenium", "TestNG");
        //5th Question ----How should you be addressed?
          wrap.SalutationQuestion();
        //6th Question ----What was the date 7 days ago?
        wrap.PreviousDateQuestion();
        //7th Question ----What is the time right now?
        wrap.TimeQuestion("7", "30");
        //Submit Button
        wrap.SubmitButton();
        //Success Message Check

    }
}