package pw_06;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;

import java.nio.file.Path;
import java.nio.file.Paths;

public class P16_FileUpload extends BaseTest {   //txt ve pdf dosya yukleme
    @Test
    public void singleUploadTest() throws InterruptedException {
        page.navigate("https://the-internet.herokuapp.com/upload");
        Locator chooseFileButton= page.locator("input[id='file-upload']"); //locatını aldım
        chooseFileButton.setInputFiles(Paths.get("C:\\Users\\Sony\\IdeaProjects\\PlayWrightwithJava\\src\\test\\java\\utilities\\playwright deneme.pdf")); //absolute path olarak dosya yolunu ekledım
        page.locator("input[id='file-submit']").click();

        Thread.sleep(3500);

    }


    @Test
    public void multipleUploadTest() throws InterruptedException {
        page.navigate("https://demo.automationtesting.in/FileUpload.html");
        Locator browseButton= page.locator("input[id='input-4']");
        browseButton.setInputFiles(new Path[]{Paths.get("src/test/java/utilities/playwright deneme.pdf"),
         Paths.get("C:\\Users\\Sony\\IdeaProjects\\PlayWrightwithJava\\src\\test\\java\\utilities\\elif.txt")});
       //pdf de contentroot aldım txt de absolute path aldım
        Locator uploadButton=page.getByTitle("Upload selected files");
        uploadButton.click();



        Thread.sleep(3598);

    }
}
