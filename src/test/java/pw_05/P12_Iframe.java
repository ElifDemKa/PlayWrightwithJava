package pw_05;

import com.microsoft.playwright.*;

import java.awt.*;

public class P12_Iframe {
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

        page.navigate("https://babayigit.net/test/iframe/");

        //Iframe içine geçiş yapılır
        FrameLocator iframe= page.frameLocator("#testIframe"); //locatın içine giriş yapılır
        Thread.sleep(2000);
        iframe.locator("body").clear(); // ıframe içindeki locate alınır body.clear ile yazı temızlenır
        Thread.sleep(2000);
        iframe.locator("body").fill("Ne yaparsan yap AŞK ile yap");
        Thread.sleep(2000);

        System.out.println(page.locator("h1").innerText()); //ıframe içindeki baslık

        page.close();browser.close();playwright.close();


    }




    }

