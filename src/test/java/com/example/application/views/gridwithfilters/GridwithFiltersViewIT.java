package com.example.application.views.gridwithfilters;

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
public class GridwithFiltersViewIT {

    Page page;

    @BeforeEach
    public void setup() {
        page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(!Boolean.getBoolean("headed"))).newContext().newPage();
        page.setDefaultTimeout(4000);
        page.navigate("http://localhost:8080/grid-with-filters");
    }

    @Test
    public void testInitialStateOfGridwithFiltersView() throws Exception {
        // Given the user is on the page GridwithFiltersView

        // Then the user should see an app layout with tag name 'vaadin-app-layout'
        Locator element = page.locator("vaadin-app-layout");
        PlaywrightAssertions.assertThat(element).isVisible();

        // And the user should see a vertical layout with tag name 'vaadin-vertical-layout'
        element = page.locator("vaadin-vertical-layout");
        PlaywrightAssertions.assertThat(element).isVisible();

        // And the user should see a horizontal layout with tag name 'vaadin-horizontal-layout'
//        element = page.locator("vaadin-horizontal-layout");
//        PlaywrightAssertions.assertThat(element).isVisible();

        // And the user should see an icon with tag name 'vaadin-icon' and attribute 'icon' with value 'lumo:plus'
//        element = page.locator("vaadin-icon");
//        PlaywrightAssertions.assertThat(element).isVisible();

        // And the user should see a span with text 'Filters'
//        element = page.getByText("Filters");
//        PlaywrightAssertions.assertThat(element).isVisible();

        // And the user should see a text field with role 'textbox' and label 'Name'
        Locator textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name"));
        PlaywrightAssertions.assertThat(textField).isVisible();

        // And the user should see a text field with role 'textbox' and label 'Phone'
        textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone"));
        PlaywrightAssertions.assertThat(textField).isVisible();

        // And the user should see a date picker with role 'combobox' and label 'Date of Birth' and placeholder 'From'
        Locator datePicker = page.locator("vaadin-date-picker").getByPlaceholder("From");
        PlaywrightAssertions.assertThat(datePicker).isVisible();

        // And the user should see a date picker with role 'combobox' and placeholder 'To'
//        datePicker = page.getByRole(AriaRole.COMBOBOX);
//        PlaywrightAssertions.assertThat(datePicker).isVisible();
        datePicker = page.locator("vaadin-date-picker").getByPlaceholder("To");
        PlaywrightAssertions.assertThat(datePicker).isVisible();

        // And the user should see a multi-select combo box with role 'combobox' and label 'Occupation'
        Locator comboBox = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Occupation"));
        PlaywrightAssertions.assertThat(comboBox).isVisible();

        // And the user should see a checkbox group with role 'group' and label 'Role'
        Locator checkboxGroup = page.getByRole(AriaRole.GROUP, new Page.GetByRoleOptions().setName("Role"));
        PlaywrightAssertions.assertThat(checkboxGroup).isVisible();

        // And the user should see a button with role 'button' and text 'Reset'
        Locator button = page.getByRole(AriaRole.BUTTON);
        button = button.filter(new Locator.FilterOptions().setHasText("Reset"));
        PlaywrightAssertions.assertThat(button).isVisible();

        // And the user should see a button with role 'button' and text 'Search'
        button = page.getByRole(AriaRole.BUTTON);
        button = button.filter(new Locator.FilterOptions().setHasText("Search"));
        PlaywrightAssertions.assertThat(button).isVisible();

        // And the user should see a grid with tag name 'vaadin-grid'
        Locator grid = page.locator("vaadin-grid");
        PlaywrightAssertions.assertThat(grid).isVisible();
    }

    @Test
    @Disabled
    public void testUserInteractsWithFiltersAndSearches() throws Exception {
        // Given the user is on the page GridwithFiltersView

        // When the user enters 'John' in the text field with role 'textbox' and label 'Name'
        Locator textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name"));
        textField.fill("John");

        // And the user enters '(123) 456-7890' in the text field with role 'textbox' and label 'Phone'
        textField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone"));
        textField.fill("(123) 456-7890");

        // And the user selects '1990-01-01' in the date picker with role 'combobox' and label 'Date of Birth' and placeholder 'From'
        Locator datePicker = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Date of Birth"));
        datePicker.selectOption("1990-01-01");

        // And the user selects '2000-12-31' in the date picker with role 'combobox' and placeholder 'To'
        datePicker = page.getByRole(AriaRole.COMBOBOX);
        datePicker.selectOption("2000-12-31");

        // And the user selects 'Insurance Clerk' in the multi-select combo box with role 'combobox' and label 'Occupation'
        Locator comboBox = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Occupation"));
        comboBox.click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Insurance Clerk")).click();

        // And the user selects 'Worker' in the checkbox group with role 'group' and label 'Role'
        Locator checkboxGroup = page.getByRole(AriaRole.GROUP, new Page.GetByRoleOptions().setName("Role"));
        checkboxGroup.selectOption("Worker");

        // When the user clicks on the button with role 'button' and text 'Search'
        Locator button = page.getByRole(AriaRole.BUTTON);
        button = button.filter(new Locator.FilterOptions().setHasText("Search"));
        button.click();

        // Then the grid with tag name 'vaadin-grid' should show filtered results
        Locator grid = page.locator("vaadin-grid");
        PlaywrightAssertions.assertThat(grid).isVisible();
    }
}