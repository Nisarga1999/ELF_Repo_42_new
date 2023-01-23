package locators;


		import java.util.*;
		import java.util.concurrent.TimeUnit;

		import org.omg.PortableInterceptor.INACTIVE;
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.StaleElementReferenceException;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;
		/***
		 * 
		 * @author nisarga
		 *
		 */
		public class ToAddAndRemoveItemsFromFlipKart {

			public static void main(String[]args) {

				//User Input for number of phones and brandname
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the number of lipsticks");
				int number = sc.nextInt();
				String brandName[] = new String[number];
				System.out.println("Enter the brand names");
				for(int i=0;i<number;i++) {
					brandName[i] = sc.next();
				}

				//opening browser and website
				System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
				WebDriverWait explicitwait = new WebDriverWait(driver, 15);
				System.out.println("chrome browser opened");

				driver.get("https://www.flipkart.com/");
				Map<Integer, String> product = new TreeMap<Integer, String>();
				driver.findElement(By.xpath("//button[text()='✕']")).click();

				//homepage
				String parentWindowId = driver.getWindowHandle();


				//search for product
				String productName="";
				String name="";
				for(int i=0;i<number;i++) {
					driver.findElement(By.name("q")).sendKeys(Keys.CONTROL+"a");
					driver.findElement(By.name("q")).sendKeys(Keys.DELETE);
					driver.findElement(By.name("q")).sendKeys(brandName[i]+" product");
					driver.findElement(By.xpath("//button[@type='submit']")).submit();
					System.out.println("selected p"+(i+1));

					//selecting product
					try {
						WebElement selectproduct = driver.findElement(By.xpath("//div[contains(@data-tkid,'.SEARCH')]/a"));
						
						explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-tkid,'.SEARCH')]/a")));
						productName=driver.findElement(By.xpath(".//div[contains(@data-tkid,'.SEARCH')]/a[@class='slQ9rs'}")).getText();
						name = productName.substring(0, 10);
						//lWebElement product1;
						selectproduct.click();
					}
					catch(Exception e) {
						driver.navigate().refresh();
						WebElement catchproduct = driver.findElement(By.xpath("//div[contains(@data-tkid,'.SEARCH')]/a"));
						explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-tkid,'.SEARCH')]/a")));
						productName=driver.findElement(By.xpath(".//div[contains(@data-tkid,'.SEARCH')]/a[@class='slQ9rs'}")).getText();
						name = productName.substring(0, 10);
						catchproduct.click();
					}

					//navigating to child tab
					Set<String> windowIds = driver.getWindowHandles();
					windowIds.remove(parentWindowId);
					for(String windowid:windowIds) {
						driver.switchTo().window(windowid);
					}

					//get productPrice and pName
					System.out.println("product name: "+productName);
					String ProductPrice = driver.findElement(By.xpath("(//div[contains(text(),'₹')])[1]")).getText();
					System.out.println("product price: "+ProductPrice);
					ProductPrice=ProductPrice.replaceAll("[^0-9]","");
					int Price = Integer.parseInt(ProductPrice);

					//adding ProductName and productPrice to map
					product.put(Price, name);

					//add producte to cart
					driver.findElement(By.xpath("//button[text()='Add to cart' or text()='GO TO CART']")).click();
					System.out.println("product added to cart");
					explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Place Order']")));

					//close child tab
					driver.close();
					driver.switchTo().window(parentWindowId);
				}

				//sorting according to phonePrice and getting the lowest price
				Integer minimum = 0;
				Set<Integer>cost=product.keySet();
				for(Integer highCost:cost) {
					int maximum = (int)highCost;
				}
				String maximum = null;
				//String maximum = null;
				System.out.println("highest price: "+maximum);
				String actualproductName = product.get(maximum);
				System.out.println("highest priced phone: "+actualproductName );

				//opening cart
				System.out.println("opened cart page");
				driver.findElement(By.xpath("//span[text()='Cart']")).click();

				//Remove the cheapest phone from cart
				int k=3;
				for(;;) {
					try {
						String titleInCart = driver.findElement(By.xpath("//div[@class='_1AtVbE col-12-12']["+(k++)+"]//a[text()]")).getText();
						if(titleInCart.equals(actualproductName)) {
							driver.findElement(By.xpath("//a[text()='"+actualproductName+"']/../../../..//div[text()='Remove']")).click();
							driver.findElement(By.xpath("//div[contains(text(),'remove this item?')]/..//div[text()='Remove']")).click();
							System.out.println("deleted the product");
							break;
						}
					}
					catch(Exception e) {
						((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
						k--;
					}
				}
				
				//quit
				System.out.println("quit application");
				//driver.quit();
			}
}
