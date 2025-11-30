package pw_01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

public class P02_FirstTest {
    public static void main(String[] args) throws InterruptedException {
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=screenSize.width;
        int height= screenSize.height;
        Playwright playwright= Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        //setHeadless(true):hic pencere acmadan testi tamamlar
        //setHeadless(false):browser acarak testi tamamlar
        Page page= browser.newPage();
        page.navigate("https://www.babayigit.net/test");
        System.out.println(page.title());
        page.setViewportSize(width,height);
        Thread.sleep(15000);

            //not:trysiz yaparsak bu 3 ünü kullanmamız gerekir
        page.close();
        browser.close();
        playwright.close();
        //bu sekilde de acilan pencere kapatılabilir





    }
}
