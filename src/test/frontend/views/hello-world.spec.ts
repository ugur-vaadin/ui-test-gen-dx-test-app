import { test, expect } from '@playwright/test';

test.beforeEach(async ({ page }) => {
  page.setDefaultTimeout(10000);
  await page.goto('http://localhost:8080/hello-world');
});

test('Initial state of HelloWorldReactView', async ({ page }) => {
  // Given the user is on the page HelloWorldReactView
  // This is handled by the beforeEach hook

  // Then the user should see an app layout with tag name 'vaadin-app-layout'
  let element = page.locator('vaadin-app-layout');
  await expect(element).toBeVisible();

  // And the user should see a text field with role 'textbox' and label 'Your name'
  let textField = page.getByRole('textbox', { name: 'Your name' });
  await expect(textField).toBeVisible();

  // And the user should see a button with role 'button' and text 'Say hello'
  let button = page.getByRole('button');
  button = button.filter({ hasText: 'Say hello' });
  await expect(button).toBeVisible();
});

test('User enters name in the text field', async ({ page }) => {
  // Given the user is on the page HelloWorldReactView
  // This is handled by the beforeEach hook

  // When the user enters 'FOO' in the text field with role 'textbox' and label 'Your name'
  let textField = page.getByRole('textbox', { name: 'Your name' });
  await textField.fill('FOO');
});

test('User clicks on the "Say hello" button', async ({ page }) => {
  // Given the user is on the page HelloWorldReactView
  // This is handled by the beforeEach hook

  // And the user has entered 'FOO' in the text field with role 'textbox' and label 'Your name'
  let textField = page.getByRole('textbox', { name: 'Your name' });
  await textField.fill('FOO');

  // When the user clicks on the button with role 'button' and text 'Say hello'
  let button = page.getByRole('button');
  button = button.filter({ hasText: 'Say hello' });
  await button.click();

  // Then a notification with tag name 'vaadin-notification' and text 'Hello FOO!' should appear
  let notification = page.locator('vaadin-notification-container');
  await expect(notification).toContainText('Hello FOO');
});