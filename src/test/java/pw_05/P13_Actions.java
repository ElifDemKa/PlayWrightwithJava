package pw_05;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

public class P13_Actions {

    public static void main(String[] args) throws InterruptedException {

        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width= screenSize.width;
        int height = screenSize.height;

        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); //false yazılmazsa true olur
        // ya da hiç setHeadles yazılmazsa true olur,
        // yani pencere acılmaz testler çalıştırır kapanır

        Page page= browser.newPage();
        page.setViewportSize(width,height);
        page.navigate("https://www.ebay.com");
        page.getByPlaceholder("Search for anything").fill("bicycle"); //searh kutusuna tıkla ve stringi yazdır
        Thread.sleep(2000);

        //Enter tuşuna basilir
        // page.getByPlaceholder("Search for anything").press("Enter"); // bu sekilde de enter  tusuna basılır
        page.keyboard().press("Enter");
        Thread.sleep(2000);
        page.goBack(); //anasayfaya tekrar dön

        page.getByText("register").first().click();
        //Birden fazla seçenek varsa first() ilkini, last() sonuncusunu, nth(indexNo) ile elemente ulaşabiliriz
        Thread.sleep(3000);


        page.navigate("https://the-internet.herokuapp.com/checkboxes");
        //page.waitForLoadState(LoadState.LOAD);
        if (page.locator("(//input[@type='checkbox'])[1]").isChecked()){
            System.out.println("checkbox zaten işaretli");
        }else{
            page.locator("(//input[@type='checkbox'])[1]").check();
        }

        if (page.locator("(//input[@type='checkbox'])[2]").isChecked()){
            System.out.println("checkbox2 zaten işaretli");
        }else{
            page.locator("(//input[@type='checkbox'])[2]").check();
        }


        Thread.sleep(3000);

        page.close();
        browser.close();




    }

}
