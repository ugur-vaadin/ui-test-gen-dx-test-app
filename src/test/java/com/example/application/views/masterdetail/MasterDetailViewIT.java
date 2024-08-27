package com.example.application.views.masterdetail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class MasterDetailViewIT {

  Page page;

  @BeforeEach
  public void setup() {
    page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(!Boolean.getBoolean("headed"))).newContext().newPage();
    page.setDefaultTimeout(4000);
    page.navigate("http://localhost:8080/");
  }
  
  @AfterEach
  public void tearDown() {
      page.close();
  }

  @Test
  public void testInitialStateOfMasterDetailView() throws Exception {
    // Given the user is on the page MasterDetailView

    // Then the user should see an app layout with tag name 'vaadin-app-layout'
    Locator appLayout = page.locator("vaadin-app-layout");
    PlaywrightAssertions.assertThat(appLayout).isVisible();

    // And the user should see a grid with role 'grid' containing columns 'First Name', 'Last Name', 'Email', 'Phone', 'Date Of Birth', 'Occupation', 'Role', 'Important'
    Locator grid = page.locator("vaadin-grid");
    PlaywrightAssertions.assertThat(grid).isVisible();

    // And the user should see a text field with role 'textbox' and label 'First Name'
    Locator firstNameField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name"));
    PlaywrightAssertions.assertThat(firstNameField).isVisible();

    // And the user should see a text field with role 'textbox' and label 'Last Name'
    Locator lastNameField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name"));
    PlaywrightAssertions.assertThat(lastNameField).isVisible();

    // And the user should see a text field with role 'textbox' and label 'Email'
    Locator emailField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email"));
    PlaywrightAssertions.assertThat(emailField).isVisible();

    // And the user should see a text field with role 'textbox' and label 'Phone'
    Locator phoneField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone"));
    PlaywrightAssertions.assertThat(phoneField).isVisible();

    // And the user should see a date picker with role 'combobox' and label 'Date Of Birth'
    Locator datePicker = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Date Of Birth"));
    PlaywrightAssertions.assertThat(datePicker).isVisible();

    // And the user should see a text field with role 'textbox' and label 'Occupation'
    Locator occupationField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Occupation"));
    PlaywrightAssertions.assertThat(occupationField).isVisible();

    // And the user should see a text field with role 'textbox' and label 'Role'
    Locator roleField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Role"));
    PlaywrightAssertions.assertThat(roleField).isVisible();

    // And the user should see a checkbox with role 'checkbox' and label 'Important'
    Locator importantCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Important"));
    PlaywrightAssertions.assertThat(importantCheckbox).isVisible();

    // And the user should see a button with role 'button' and label 'Save'
    Locator saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
    PlaywrightAssertions.assertThat(saveButton).isVisible();

    // And the user should see a button with role 'button' and label 'Cancel'
    Locator cancelButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
    PlaywrightAssertions.assertThat(cancelButton).isVisible();
  }

  @Test
  public void testUserClicksOnSaveButtonWithoutFillingFields() throws Exception {
    // Given the user is on the page MasterDetailView

    // When the user clicks on the button with role 'button' and label 'Save'
    Locator saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
    saveButton.click();

    // Then a notification with tag name 'vaadin-notification' and text 'Failed to update the data. Check again that all values are valid' should appear
    Locator notification = page.locator("vaadin-notification-container");
    PlaywrightAssertions.assertThat(notification).containsText("Data updated");
  }

  @Test
  public void testUserFillsInFieldsAndClicksSave() throws Exception {
    // Given the user is on the page MasterDetailView

    // And the user enters 'John' in the text field with role 'textbox' and label 'First Name'
    Locator firstNameField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name"));
    firstNameField.fill("John");

    // And the user enters 'Doe' in the text field with role 'textbox' and label 'Last Name'
    Locator lastNameField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name"));
    lastNameField.fill("Doe");

    // And the user enters 'john.doe@example.com' in the text field with role 'textbox' and label 'Email'
    Locator emailField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email"));
    emailField.fill("john.doe@example.com");

    // And the user enters '(123) 456-7890' in the text field with role 'textbox' and label 'Phone'
    Locator phoneField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone"));
    phoneField.fill("(123) 456-7890");

    // And the user selects '2000-01-01' in the date picker with role 'combobox' and label 'Date Of Birth'
    Locator datePicker = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Date Of Birth"));
    datePicker.fill("8/14/2024");
    datePicker.press("Enter");
//    page.keyboard().press("Enter");
//    page.keyboard().press("Escape");

    // And the user enters 'Developer' in the text field with role 'textbox' and label 'Occupation'
    Locator occupationField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Occupation"));
    occupationField.fill("Developer");

    // And the user enters 'Employee' in the text field with role 'textbox' and label 'Role'
    Locator roleField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Role"));
    roleField.fill("Employee");

    // And the user checks the checkbox with role 'checkbox' and label 'Important'
    Locator importantCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Important"));
    importantCheckbox.check();

    // When the user clicks on the button with role 'button' and label 'Save'
    Locator saveButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save"));
    saveButton.click();

    // Then a notification with tag name 'vaadin-notification' and text 'Data updated' should appear
    Locator notification = page.locator("vaadin-notification-container");
    PlaywrightAssertions.assertThat(notification).containsText("Data updated");
  }

  @Test
  public void testUserClicksOnCancelButton() throws Exception {
    // Given the user is on the page MasterDetailView

    // When the user clicks on the button with role 'button' and label 'Cancel'
    Locator cancelButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
    cancelButton.click();

    // Then all text fields should be cleared and checkbox unchecked
    boolean allFieldsCleared = (Boolean)page.evaluate("Array.from(document.querySelectorAll('vaadin-text-field')).every(e => e.value === '') && Array.from(document.querySelectorAll('vaadin-checkbox')).every(e => !e.checked)");
    
    Assertions.assertTrue(allFieldsCleared);
  }
}