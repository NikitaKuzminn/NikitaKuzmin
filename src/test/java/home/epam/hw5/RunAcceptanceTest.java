package home.epam.hw5;

import home.epam.hw5.config.Listener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
@CucumberOptions(plugin = {"pretty"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
