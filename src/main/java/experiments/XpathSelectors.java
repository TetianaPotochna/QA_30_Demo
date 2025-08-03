package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsRadioButtonPage() {
        driver.get("https://demoqa.com/radio-button");
        //driver.manage().window().maximize();
        hideBanner();
        hideFooter();

        WebElement radioButtonYes1 = driver.findElement(By.cssSelector("*[for='yesRadio']"));
        WebElement radioButtonYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radioButtonYes.click();
        pause(2000);

        WebElement radioButtonImpress = driver.findElement(By.xpath("//*[@for='impressiveRadio']"));
        radioButtonImpress.click();
        pause(2000);

        driver.quit();
    }
    @Test
    public void selectorsTestBoxPage(){
        driver.get("https://demoqa.com/text-box");
        hideBanner();
        hideFooter();

        WebElement inputFullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        inputFullName.sendKeys("Monkey");
        //form/div[@id='userName-wrapper']/div[2]/input
        //form/div[@id='userName-wrapper']//input
        pause(2000);

        WebElement inputEmail = driver.findElement(By.xpath("//input[@type='email']"));
        inputEmail.sendKeys("monkey@gmail.com");
        pause(2000);

        WebElement textareaCurAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        textareaCurAddress.sendKeys("Monkey street 5");
        pause(2000);

        WebElement textareaPerAddress = driver.findElement(By.id("permanentAddress"));
        textareaPerAddress.sendKeys("Monkey Avenue 6");
        pause(2000);

        WebElement btnSubmit = driver.findElement(By.xpath("//button[text() ='Submit']"));
        btnSubmit.click();
        pause(2000);

        WebElement outputForm = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println(outputForm.getText());



        driver.quit();
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideBanner() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
