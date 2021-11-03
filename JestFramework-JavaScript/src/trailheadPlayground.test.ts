import { chromium } from "playwright";
describe('Launch Browser', () => {
    jest.setTimeout(60000);
    test('Login to trailHead', async () => {
        const browser = await chromium.launch({
            headless: false
        })
        const context = await browser.newContext();
        const page = await context.newPage();
        await page.goto('https://cunning-fox-tard9e-dev-ed.lightning.force.com/');
        await page.click("id=username");
        await page.fill("id=username",'sanbhowmick@cunning-fox-tard9e.com');
        await page.fill("id=password",'');
        await page.click("id=Login"); 

        await Promise.all([
            page.waitForNavigation(), // Waits for the next navigation
            page.click('div.slds-icon-waffle'), // Triggers a navigation after a timeout
        ]);
                await page.click('p:has-text("Service")');
        //Assertion
        const locator = page.locator('.title');
        //console.log(locator);
                await page.click('span:has-text("Accounts")');
        await Promise.all([
            page.waitForNavigation(), // Waits for the next navigation
            page.click('a.forceActionLink:first-child'), // Triggers a navigation after a timeout
        ]);
        //fill account details
        await page.fill('input[name=Name]','JonD-Account');
        await page.fill('input[name=Phone]','1231231234');
        await page.fill('input[name=AccountNumber]','3499876');
        await page.fill('input[name=AnnualRevenue]','6000000');
        await page.fill('textarea[name=street]','Park Avenue Road-800 - US');             
                
        await page.fill('textarea.slds-textarea:third-child','testing save button');
        await page.mouse.move(0,2500);
        await page.click('button:has-text("Save")');

})

})
