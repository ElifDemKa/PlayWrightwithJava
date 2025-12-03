package pw_03;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

import java.awt.*;

public class P09_OtherLocators {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        Dimension scr=Toolkit.getDefaultToolkit().getScreenSize();
        int width= scr.width;
        int height=scr.height;
        page.setViewportSize(width,height);
        page.navigate("https://getir.com");
        System.out.println(page.title()+"\n");
        page.waitForLoadState(LoadState.LOAD);

    }
}
