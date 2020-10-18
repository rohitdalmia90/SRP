package seleniumDesign.test.srp;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumDesign.srp.main.GoogleMainPage;
import seleniumDesign.srp.result.GoogleResultPage;
import seleniumDesign.test.BaseTest;

public class GoogleTest extends BaseTest {
    
    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;
    
    
    @BeforeTest
    public void setUpPage() {
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
        
    }
    
    @Test(dataProvider = "getData")
    public void googleWorkFlow(String keyword, int index) {
       /* String keyword = "selenium Webdriver";
        int index = 3;*/
        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());
        
        
        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());
        
        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());
        
        
        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());
        
        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);
        
        googleResultPage.getNavigationBar().goToNews();
        
        System.out.println(googleResultPage.getResultStat().getStat());
        
    }
    
    
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
            {"selenium", 3},
            {"dockers", 2}
        };
    }
}
