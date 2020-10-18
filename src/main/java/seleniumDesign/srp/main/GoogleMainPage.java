package seleniumDesign.srp.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import seleniumDesign.srp.common.SearchSuggestion;
import seleniumDesign.srp.common.SearchWidget;

public class GoogleMainPage {
    
    
    private WebDriver webDriver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    
    
    public GoogleMainPage(WebDriver driver) {
        this.webDriver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    }
    
    public void goTo() {
        this.webDriver.get("https://www.google.com");
    }
    
    public SearchWidget getSearchWidget() {
        return searchWidget;
    }
    
    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}
