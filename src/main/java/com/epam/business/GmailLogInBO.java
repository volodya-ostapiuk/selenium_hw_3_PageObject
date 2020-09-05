package com.epam.business;

import com.epam.pages.gmail.GmailHomePage;
import com.epam.pages.gmail.GmailLoginPage;
import com.epam.pages.gmail.GmailPasswordPage;
import com.epam.utils.DriverProvider;

public class GmailLogInBO {
    private GmailLoginPage loginPage;
    private GmailPasswordPage passwordPage;
    private GmailHomePage homePage;

    public GmailLogInBO() {
        loginPage = new GmailLoginPage();
        passwordPage = new GmailPasswordPage();
        homePage = new GmailHomePage();
    }

    public void logIn(String userEmail, String userPassword) {
        loginPage.enterEmail(userEmail);
        passwordPage.enterPassword(userPassword);
    }

    public String getPageTitle() {
        homePage.waitOnMailLogoToBeClickable();
        return DriverProvider.getInstance().getTitle().toLowerCase();
    }
}
