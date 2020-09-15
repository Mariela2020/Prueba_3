package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
@RunWith(value = Cucumber.class)
@CucumberOptions(
                 features = "src/test/java/features",
                 glue = ("seleniumgluecode"),
                 plugin = {"json:test/report/cucumber_report.json"},
                 snippets = SnippetType.CAMELCASE,
                 tags = {"@funtional"}

)


public class Testrunner {

    @AfterClass
    public static void finish(){

        try{
            System.out.println("Generando reporte");
            String[]cmd ={"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("Reporte generado satisfactoriamente! ");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
