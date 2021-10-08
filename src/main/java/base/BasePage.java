package base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;



public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    Actions action= new Actions(driver);

    static{
        System.setProperty("webdriver.chrome.driver", "C://BrowserDrivers/chromedriver.exe");
        driver= new ChromeDriver();
        wait= new WebDriverWait(driver, 30);
    }

    public BasePage(WebDriver driver){
        BasePage.driver= driver;
        wait= new WebDriverWait(driver, 30);
    }
    public void navigateTo(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void clickElement(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void sendInput(By locator, String textToInput){
        driver.findElement(locator).sendKeys(textToInput);
    }

    public String getPageTitle(){
       return driver.getTitle();
    }

    public String getTextFromElement(By locator){
        return driver.findElement(locator).getText();
    }

    public void closeAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void confirmAlert(){
        driver.switchTo().alert().accept();
    }

    public void alertInput(String inputText){
        driver.switchTo().alert().sendKeys(inputText);
    }

    public void switchToIFrame(String nameOrID){
        driver.switchTo().frame(nameOrID);
    }

    public void exitIFrame(){
        driver.switchTo().parentFrame();
    }

    public void scrollToElement(By element){
        action.moveToElement(driver.findElement(element)).perform();
    }

    public void dragAnElementByCoordinates(By elementToDrag, int targetX, int targetY){
        action.dragAndDropBy(driver.findElement(elementToDrag), targetX, targetY ).perform();
    }

    public void hoverOverElement(By element){
        action.moveToElement(driver.findElement(element)).perform();
    }

    
}