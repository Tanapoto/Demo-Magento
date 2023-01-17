package Setup.project.modals.Account;

import lombok.Data;

@Data
public class AccountModal {

    public static String email = "EMAIL";
    public static String password = "PASSWORD";
    public static String signInPageUrl = "SIGNIN_PAGE_URL";
    public static String homePageUrl = "HOME_PAGE_URL";
    public static String signOutPageUrl = "SIGNOUT_PAGE_URL";

    public static String firstName = "FIRST_NAME";
    public static String lastName = "LAST_NAME";
    public static String confirmPassword = "CONFIRM_PASSWORD";
    public static String signUpPageUrl = "SIGNUP_PAGE_URL";
    public static String accountUrl = "ACCOUNT_URL";
    public static String editContactInfoUrl = "EDIT_CONTACT_INFOR_URL";


    public static String getFirstName() {
        return firstName;
    }
    public static String getLastName() {
        return lastName;
    }
    public static String getConfirmPassword() {
        return confirmPassword;
    }
    public static String getSignUpPageUrl() {
        return signUpPageUrl;
    }
    public static String getAccountUrl() {
        return accountUrl;
    }

    public static String getEmail() {
        return email;
    }
    public static String getPassword() {
        return password;
    }
    public static String getSignInPageUrl() {
        return signInPageUrl;
    }
    public static String getHomePageUrl() {
        return homePageUrl;
    }
    public static String getSignOutPageUrl() {
        return signOutPageUrl;
    }
    public static String getEditContactInfoUrl() {
        return editContactInfoUrl;
    }



}