package WebSite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUrl {

    public   WebDriver webDriver;
    // First Test Case How To open Search Google and write Amazon Egypt and open website


    public void OpenUrl()
    {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        webDriver=new ChromeDriver(co);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com/?hl=ar");
        webDriver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Amazon.com" ,Keys.RETURN);

      webDriver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();



    }
    // Test Case 2 how to  write in search

    public  void SeacrchOnTab()
    {
        OpenUrl();
        webDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone X" , Keys.RETURN);
    }
    // test case 3 how to select price


    public void price()
    {
        SeacrchOnTab();
        webDriver.findElement(By.id("low-price")).sendKeys("600" );
        webDriver.findElement(By.id("high-price")).sendKeys("1000");
        webDriver.findElement(By.className("a-button-input")).submit();
    }

    // test case 4 how to select item from list

    public  void selectItem()
    {
        price();
        //webDriver.findElement(By.linkText("Apple iPhone XS, US Version, 256GB, Space Gray - Unlocked (Renewed)")).click();
        webDriver.findElement(By.linkText("iPhone 13 Pro Max, 128GB, Silver - Unlocked (Renewed Premium)")).click();
    }

    // test case 5 how to determine


    public  void determinequantity()
    {
        selectItem();
       Select select= new Select(webDriver.findElement(By.cssSelector("#selectQuantity #quantity")));
       select.selectByValue("2");
       select.selectByIndex(1);
       select.selectByVisibleText("2");

    }
    // add-to-cart-button
    // test case 6 how to add card


   public  void addcard()
    {
        determinequantity();
        webDriver.findElement(By.id("add-to-cart-button")).click();

    }


    public static void main(String[] args) {
        TestUrl testUrl= new TestUrl();
       testUrl.addcard();

    }

}
