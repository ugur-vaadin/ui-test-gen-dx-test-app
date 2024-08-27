import { test, expect } from '@playwright/test';

test.beforeEach(async ({ page }) => {
  page.setDefaultTimeout(10000);
  await page.goto('http://localhost:8080/person');
});

test.describe('UI Testing PersonFormView', () => {

  test('Initial state of PersonFormView', async ({ page }) => {
    // Given the user is on the page PersonFormView
    // This is handled by the beforeEach hook

    // Then the user should see an app layout with tag name 'vaadin-app-layout'
    let element = page.locator('vaadin-app-layout');
    await expect(element).toBeVisible();

    // And the user should see a text field with role 'textbox' and label 'First name'
    let textField = page.getByRole('textbox', { name: 'First name' });
    await expect(textField).toBeVisible();

    // And the user should see a text field with role 'textbox' and label 'Middle name'
    textField = page.getByRole('textbox', { name: 'Middle name' });
    await expect(textField).toBeVisible();

    // And the user should see a text field with role 'textbox' and label 'Last name'
    textField = page.getByRole('textbox', { name: 'Last name' });
    await expect(textField).toBeVisible();

    // And the user should see a text field with role 'textbox' and label 'Phone number'
    textField = page.getByRole('textbox', { name: 'Phone number' });
    await expect(textField).toBeVisible();

    // And the user should see a select with role 'button' and label 'Country'
    let button = page.getByRole('button', { name: 'Country' });
    await expect(button).toBeVisible();

    // And the user should see a radio group with role 'radiogroup' and label 'Favourite animal'
    element = page.getByRole('radiogroup', { name: 'Favourite animal' });
    await expect(element).toBeVisible();

    // And the user should see a number field with role 'spinbutton' and label 'Age'
    button = page.getByRole('spinbutton', { name: 'Age' });
    await expect(button).toBeVisible();

    // And the user should see a text area with role 'textbox' and label 'Few words about yourself'
    let textArea = page.getByRole('textbox', { name: 'Few words about yourself' });
    await expect(textArea).toBeVisible();

    // And the user should see an email field with role 'textbox' and label 'Email'
    let emailField = page.getByRole('textbox', { name: 'Email' });
    await expect(emailField).toBeVisible();

    // And the user should see a password field with role 'textbox' and label 'Password'
    let passwordField = page.getByRole('textbox', { name: 'Password' });
    await expect(passwordField).toBeVisible();

    // And the user should see a tab sheet with tag name 'vaadin-tabsheet'
    let tabs = page.locator('vaadin-tabsheet');
    await expect(tabs).toBeVisible();

    // And the user should see a checkbox with role 'checkbox' and label 'I accept terms above and hereby promise to download and use Vaadin and provide feedback'
    let checkbox = page.getByRole('checkbox', { name: 'I accept terms above and hereby promise to download and use Vaadin and provide feedback' });
    await expect(checkbox).toBeVisible();

    // And the user should see a button with role 'button' and text 'Cancel'
    button = page.getByRole('button');
    button = button.filter({ hasText: 'Cancel' });
    await expect(button).toBeVisible();

    // And the user should see a button with role 'button' and text 'Save'
    button = page.getByRole('button');
    button = button.filter({ hasText: 'Save' });
    await expect(button).toBeVisible();
  });

  test('User enters first name', async ({ page }) => {
    // Given the user is on the page PersonFormView
    // This is handled by the beforeEach hook

    // When the user enters 'John' in the text field with role 'textbox' and label 'First name'
    let textField = page.getByRole('textbox', { name: 'First name' });
    await textField.fill('John');
  });

  test('User selects country', async ({ page }) => {
    // Given the user is on the page PersonFormView
    // This is handled by the beforeEach hook

    // When the user selects 'Finland' in the select with role 'button' and label 'Country'
//    let button = page.getByRole('searchbox', { name: 'Country' });
//    await button.selectOption('Finland');
    await page.getByLabel('Country').click();
		await page.getByRole('option', { name: 'Finland' }).locator('div').click();
		
  });

  test('User sets favourite animal', async ({ page }) => {
    // Given the user is on the page PersonFormView
    // This is handled by the beforeEach hook

    // When the user selects 'Dog' in the radio group with role 'radiogroup' and label 'Favourite animal'
//    let select = page.getByRole('radiogroup', { name: 'Favourite animal' });
//    await select.selectOption('Dog');
		await page.getByLabel('Dog').check();
  });

  test('User sets age', async ({ page }) => {
    // Given the user is on the page PersonFormView
    // This is handled by the beforeEach hook

    // When the user enters '25' in the number field with role 'spinbutton' and label 'Age'
    let button = page.getByRole('spinbutton', { name: 'Age' });
    await button.fill('25');
  });

  test('User sets email', async ({ page }) => {
    // Given the user is on the page PersonFormView
    // This is handled by the beforeEach hook

    // When the user enters 'john.doe@example.com' in the email field with role 'textbox' and label 'Email'
    let emailField = page.getByRole('textbox', { name: 'Email' });
    await emailField.fill('john.doe@example.com');
  });

  test('User sets password', async ({ page }) => {
    // Given the user is on the page PersonFormView
    // This is handled by the beforeEach hook

    // When the user enters 'password123' in the password field with role 'textbox' and label 'Password'
    let passwordField = page.getByRole('textbox', { name: 'Password' });
    await passwordField.fill('password123');
  });

  test('User accepts terms', async ({ page }) => {
    // Given the user is on the page PersonFormView
    // This is handled by the beforeEach hook

    // When the user clicks on the checkbox with role 'checkbox' and label 'I accept terms above and hereby promise to download and use Vaadin and provide feedback'
    let checkbox = page.getByRole('checkbox', { name: 'I accept terms above and hereby promise to download and use Vaadin and provide feedback' });
    await checkbox.click();
  });

  test('User clicks Save button', async ({ page }) => {
    // Given the user is on the page PersonFormView
    // This is handled by the beforeEach hook

    // When the user clicks on the button with role 'button' and text 'Save'
    let button = page.getByRole('button');
    button = button.filter({ hasText: 'Save' });
    await button.click();
  });

});