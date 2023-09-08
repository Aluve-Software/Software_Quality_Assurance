package tech.aluvesoftware.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web",
        glue="tech/aluvesoftware/steps/web",
        tags="@register"
)
public class RunCucumberIT {
}
