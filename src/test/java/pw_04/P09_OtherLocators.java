package pw_04;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.awt.*;

public class P09_OtherLocators {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        Dimension scr=Toolkit.getDefaultToolkit().getScreenSize(); //sayfayi tam sayfa yapıyoruz
        int width= scr.width;
        int height=scr.height;
        page.setViewportSize(width,height);

        page.navigate("https://getir.com");
        System.out.println(page.title()+"\n");
        page.waitForLoadState(LoadState.LOAD);

        //CSS locatorlar içinde gecer: matching by text
        //1-has-text için
        Locator loginText=page.locator("h5:has-text('Giriş yap veya kayıt ol')"); //'h5' tagımızı yazmamız ve hastext yazmamız gerekir
        System.out.println("1.Text Yöntemi: "+loginText.innerText());

        //2-text
        System.out.println("1.Text Yöntemi: "+page.locator("h5:text('Giriş yap veya kayıt ol')").innerText());

        //CSS : elements matching
        Locator loginButton= page.locator("button:has-text('Telefon numarası ile devam et'),button:has-text('login button')");
        System.out.println(loginButton.innerText());

        //Locator LoginBox =page.locator(":nth-match(:text('Giriş Yap'),1"); //giris yap butonun birincisi
        Locator LoginBox =page.locator("(//button[@type='button'])[5]");
        Locator LoginBox2 =page.locator("(//button[@type='button'])").nth(4); //nth si 5 ise 4. index element aldık
        System.out.println(LoginBox.innerText());
        System.out.println(LoginBox2.innerText());





        page.close();browser.close();playwright.close();
    }

    }

