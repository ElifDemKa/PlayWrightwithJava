package pw_06;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;

import java.util.List;

public class P17_MultipleWindow extends BaseTest { // birden fazla pencere acmak istersek

    @Test
    public void tets(){
        page.navigate("https://demoqa.com/browser-windows"); //adrese git
        page.waitForLoadState(LoadState.LOAD);

        Page popup=page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(
                p-> p.context().pages().size()==2),()->{page.getByText("New Window").first().click();});
        // bir tane poup pencersi olustur ve sayfa acıla kadar bekle

        List<Page> pages=popup.context().pages(); //acılan sayfa liste yazdır
        System.out.println(popup.title());
        System.out.println(page.title());
        System.out.println(pages.size());

    }




}
