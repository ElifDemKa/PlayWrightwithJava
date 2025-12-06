package pw_04;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class P11_LocatorAssertions {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        Dimension scr = Toolkit.getDefaultToolkit().getScreenSize(); //sayfayi tam sayfa yapıyoruz
        int width = scr.width;
        int height = scr.height;
        page.setViewportSize(width, height);

        page.navigate("https://www.ebay.com/");
        page.waitForLoadState(LoadState.LOAD); //sayfa yüklenene kadar bekle

        Locator signInButton= page.getByText("Sign in");
        assertThat(signInButton).containsText("Sign");

        Locator searchBox=page.getByPlaceholder("Search for anything");
        assertThat(searchBox).hasAttribute("type","text");

        assertThat(searchBox).isEditable();
        System.out.println(searchBox.isEditable());

    }



}