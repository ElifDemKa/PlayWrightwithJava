package pw_02;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

public class P05_PageCheckBox {
    public static void main(String[] args) throws InterruptedException {
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = scrSize.width;
        int height = scrSize.height;

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.setViewportSize(width, height);

        // Sayfayı aç
        page.navigate("https://the-internet.herokuapp.com/checkboxes");

        // İlk checkbox'ı işaretle
        page.check("(//input[@type='checkbox'])[1]");
        Thread.sleep(3000);

        // XPath alırken parantez hatası almış düzelttim*
        page.uncheck("(//input[@type='checkbox'])[2]"); //checkbox işaretini kaldirir

        Thread.sleep(5000);

        // Tarayıcıyı kapat
        page.close();
        browser.close();
        playwright.close();
    }
}
