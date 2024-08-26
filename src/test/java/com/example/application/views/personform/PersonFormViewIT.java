package com.example.application.views.personform;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@UsePlaywright
public class PersonFormViewIT {

  Page page;

  @BeforeEach
  public void setup() {
    page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();
    page.setDefaultTimeout(4000);
    page.navigate("http://localhost:8080/person-form");
  }

  @Test
  public void initialStateOfPersonFormView() throws Exception {
    // Given the user is on the page PersonFormView

    // Then the user should see a heading with tag name 'h3' and text 'Personal Information'
    Locator element = page.locator("h3");
    element = element.filter(new Locator.FilterOptions().setHasText("Personal Information"));
    PlaywrightAssertions.assertThat(element).isVisible();

    // And the user should see a text field with role 'textbox' and label 'First Name'
    Locator textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name"));
    PlaywrightAssertions.assertThat(textField).isVisible();

    // And the user should see a text field with role 'textbox' and label 'Last Name'
    textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name"));
    PlaywrightAssertions.assertThat(textField).isVisible();

    // And the user should see a date picker with role 'combobox' and label 'Birthday'
    Locator datePicker = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Birthday"));
    PlaywrightAssertions.assertThat(datePicker).isVisible();

    // And the user should see a text field with role 'textbox' and label 'Phone Number'
    textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number"));
    PlaywrightAssertions.assertThat(textField).isVisible();

    // And the user should see an email field with role 'textbox' and label 'Email'
    Locator emailField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email"));
    PlaywrightAssertions.assertThat(emailField).isVisible();

    // And the user should see a text field with role 'textbox' and label 'Occupation'
    textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Occupation"));
    PlaywrightAssertions.assertThat(textField).isVisible();

    // And the user should see a button with role 'button' and label 'Save'
    Locator button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
    PlaywrightAssertions.assertThat(button).isVisible();

    // And the user should see a button with role 'button' and label 'Cancel'
    button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
    PlaywrightAssertions.assertThat(button).isVisible();
  }

  @Test
  public void userEntersAndSavesPersonalInformation() throws Exception {
    // Given the user is on the page PersonFormView

    // And the user enters 'John' in the text field with role 'textbox' and label 'First Name'
    Locator textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name"));
    textField.fill("John");

    // And the user enters 'Doe' in the text field with role 'textbox' and label 'Last Name'
    textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name"));
    textField.fill("Doe");

    // And the user enters '1980-01-01' in the date picker with role 'combobox' and label 'Birthday'
    Locator datePicker = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Birthday"));
    datePicker.fill("01/01/1980");
    datePicker.press("Enter");

    // And the user enters '555-555-5555' in the text field with role 'textbox' and label 'Phone Number'
    textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number"));
    textField.fill("555-555-5555");

    // And the user enters 'john.doe@example.com' in the email field with role 'textbox' and label 'Email'
    Locator emailField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email"));
    emailField.fill("john.doe@example.com");

    // And the user enters 'Engineer' in the text field with role 'textbox' and label 'Occupation'
    textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Occupation"));
    textField.fill("Engineer");

    // When the user clicks on the button with role 'button' and label 'Save'
    Locator button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
    button.click();

    // Then a notification with tag name 'vaadin-notification' and text 'Information saved' should appear
    Locator notification = page.locator("vaadin-notification-container");
    notification = notification.filter(new Locator.FilterOptions().setHasText("Information saved"));
    PlaywrightAssertions.assertThat(notification).isVisible();
  }

  @Test
  public void userCancelsTheForm() throws Exception {
    // Given the user is on the page PersonFormView

    // When the user clicks on the button with role 'button' and label 'Cancel'
    Locator button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
    button.click();

    // Then the form fields should be cleared
    // This step is not implemented yet
  }
}