package tech.aluvesoftware.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/rest",
        glue="tech/aluvesoftware/steps/rest",
        tags="@register"
)
public class RunCucumberIT {
}
