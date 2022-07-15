import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class ClassTest {

    @BeforeClass
    @Step("Before class")
    public void setUp() {
        Configuration.screenshots = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true)
        );
    }

    @Test
    @Step("exactle test")
    public void test() {
        open("https://google.com");
        Selenide.screenshot("by hand");
        $x("q").shouldBe(visible);
    }
}
