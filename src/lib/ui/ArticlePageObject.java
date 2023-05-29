package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
    TITLE = "org.wikipedia:id/view_page_title_text",
    FOOTER_ELEMENT = "//*[@text='View page in browser']",
    OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
    ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_OK_BUTTON = "//*[@text='OK']",
    CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
    FOLDER_IN_LISTS = "org.wikipedia:id/item_image_container";


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE),"Cannot  find article title on page", 30);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot  find the end of article",
                20
        );
    }

    public void addArticleToMyList (String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot  find button to open article options",
                5
        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot  find button option to add article to reading list",
                5
        );
        this.waitForElementAndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Cannot  find 'Go it' tip overlay",
                5
        );
        this.waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSetValue(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );
        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot press OK button",
                5
        );
    }

        public void closeArticle() {

            this.waitForElementAndClick(
                    By.xpath(CLOSE_ARTICLE_BUTTON),
                    "Cannot close article, cannot find X link",
                    5
            );
        }

    public void addSecondArticleToMyList () {
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot  find button to open article options",
                5
        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot  find button option to add article to reading list",
                5
        );
        waitForElementAndClick(
                By.id(FOLDER_IN_LISTS),
                "Cannot find folder name",
                5
        );
    }
        public void addArticleToMyList2()
        {
            waitForElementPresent(
                    By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Automation for Apps']"),
                    "Cannot delete saved article",
                    5
            );
            String title_before_delete = waitForElementAndGetAttribute(
                    By.xpath("//*[@text='Automation for Apps']"),
                    "text",
                    "Cannot find title of article",
                    15
            );
            waitForElementAndClick(
                    By.xpath("//*[@text='Automation for Apps']"),
                    "Cannot find title of article Automation for Apps ",
                    5
            );

            String title_after_delete = waitForElementAndGetAttribute(
                    By.id("org.wikipedia:id/view_page_subtitle_text"),
                    "text",
                    "Cannot find title of article2",
                    15
            );
            Assert.assertEquals(
                    "article title have been changed after open",
                    title_before_delete,
                    title_after_delete
            );
        }

}
