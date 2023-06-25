package runners;

import configuration.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",//path to feature files
        glue = "steps",//package path
        tags = "@CERTIFICATE",//list feature files for run
        dryRun = false,
        publish = true
)

public class TestRunner {
    @BeforeClass
    public static void create() {
        System.setProperty("CUCUMBER_PUBLISH_ENABLED", "3645cec6-6f99-4742-a18b-aea2642ed904");
        BaseClass.create();
    }

    @AfterClass
    public static void end() throws InterruptedException {
        BaseClass.end();
    }
}