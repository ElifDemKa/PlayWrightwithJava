package pw_01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class P01_FirstTest {
    public static void main(String[] args) {
        try (Playwright playwright= Playwright.create()) { //try kullanmamızın nedeni testi durdurmak için
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));//istenilen browser ismi kullanılır
        // pencereyi acıp açmaması -true false- ile saglanabilir
        Page page= browser.newPage(); // Seleniumdaki eşdegeri driver
        page.navigate("https://www.testotomasyonu.com");
        System.out.println(page.title()+ "\n" +page.url());
        //Not: Bu sekilde calistirildiginda pencere acılır fakat kapanmadıgından create ederken try eklenir


}
    }
}
