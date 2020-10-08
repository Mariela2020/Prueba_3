package seleniumgluecode;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import runner.browser_manager.DriverType;

import java.util.concurrent.TimeUnit;


public class Hooks {

    private static WebDriver driver;
    private static int numerOfCase = 0;
    private DriverManager driverManager;

    @Before("@browser")
    public void setup(){
        numerOfCase ++;
        System.out.println("Se esta ejecutando el escenario nro: " + numerOfCase);
        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ww2.toctoc.com/gestioncorredor/");
        driver.manage().window().maximize();
    }

    @After("@producto")
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
            System.out.println("El escenario nro; " + numerOfCase + " se ejecuto correctamente.");
            //driverManager.quitDriver();

    }

    public static WebDriver getDriver(){
        return driver;

    }





}
