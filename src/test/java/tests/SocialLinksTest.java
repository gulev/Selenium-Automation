package tests;

import org.junit.After;
import org.junit.Test;
import com.practice.webpages.FacebookPage;
import com.practice.webpages.TwitterPage;
import com.practice.webpages.YoutubePage;
import com.practice.webpages.FooterPage;
import com.practice.webpages.GooglePlusPage;
import org.junit.jupiter.api.Assertions;

public class SocialLinksTest extends BaseTest {

    @After
    public void closeTabs() {
        FooterPage footerPage = new FooterPage();
        footerPage.killTab();
    }

    @Test
    public void visitFacebook(){
        FooterPage footerPage = new FooterPage();
        footerPage.clickOnFacebookLink();
        FacebookPage facebookPage = new FacebookPage();
        footerPage.moveToTheNextTab();
        Assertions.assertTrue(facebookPage.isFacebookPage());
    }

    @Test
    public void visitTwitter(){
        FooterPage footerPage = new FooterPage();
        footerPage.clickOnTwitterLink();
        TwitterPage twitterPage = new TwitterPage();
        footerPage.moveToTheNextTab();
        Assertions.assertTrue(twitterPage.isTwitterPage());
    }

    @Test
    public void visitYouTube(){
        FooterPage footerPage = new FooterPage();
        footerPage.clickOnYouTubeLink();
        YoutubePage youtubePage = new YoutubePage();
        footerPage.moveToTheNextTab();
        Assertions.assertTrue(youtubePage.isYouTubePage());
    }

    @Test
    public void visitGooglePlus(){
        FooterPage footerPage = new FooterPage();
        footerPage.clickOnGooglePlusLink();
        GooglePlusPage googlePlusPage = new GooglePlusPage();
        footerPage.moveToTheNextTab();
        Assertions.assertTrue(googlePlusPage.isGooglePlusPage());
    }
}
