using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System.Linq;

namespace SampleWebDriverTest
{
    [TestFixture]
    public class SampleGoogleSearchTest
    {
        IWebDriver _driver;

        [OneTimeSetUp]
        public void OneTimeSetUp()
        {
            _driver = new ChromeDriver();
        }

        [OneTimeTearDown]
        public void OneTimeTearDown()
        {
            _driver.Quit();
        }

        [Test]
        public void SearchEpamTest()
        {
            _driver.Navigate().GoToUrl("https://www.google.com");
            _driver.FindElement(By.Id("lst-ib")).SendKeys("EPAM");
            _driver.FindElement(By.Id("lst-ib")).SendKeys(Keys.Escape);
            _driver.FindElement(By.Name("btnK")).Click();
            _driver.FindElements(By.CssSelector("#ires .g a")).First().Click();
            Assert.IsTrue(_driver.Url.StartsWith("https://careers.epam."));
        }
    }
}
