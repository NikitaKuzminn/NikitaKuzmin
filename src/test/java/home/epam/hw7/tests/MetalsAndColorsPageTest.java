package home.epam.hw7.tests;

import static home.epam.hw7.site.JdiTestSite.homePage;
import static home.epam.hw7.site.JdiTestSite.metalsAndColorsPage;
import static home.epam.hw7.site.components.util.HeaderItem.MetalsAndColors;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

import home.epam.hw7.data.DataParser;
import home.epam.hw7.entities.MetalsAndColorsData;
import home.epam.hw7.entities.User;
import home.epam.hw7.site.JdiTestSite;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MetalsAndColorsPageTest implements TestInit {

    @BeforeMethod
    public void setUp() {
        homePage.shouldBeOpened();
    }

    @AfterMethod
    public void tearDown() {
        JdiTestSite.shouldBeLoggedOut(metalsAndColorsPage);
    }

    @DataProvider
    public Object[][] metalsAndColorsFormTestData() throws IOException {
        return DataParser.getMetalsAndColorsTestData();
    }

    @Test(dataProvider = "metalsAndColorsFormTestData")
    public void metalsAndColorsFormTest(MetalsAndColorsData testData) {
        JdiTestSite.loginAsDefaultUser();
        homePage.isUserLoggedIn(User.DEFAULT_USER);
        homePage.navigateToItemInHeaderMenu(MetalsAndColors);
        assertTrue(metalsAndColorsPage.isOpened());
        metalsAndColorsPage.fillMetalsAndColorsForm(testData);
        metalsAndColorsPage.submit();
        assertThat(metalsAndColorsPage.getResult().toString())
            .containsIgnoringCase(testData.getExpectedResult().toString());
    }
}
