package workingWithtestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethod {
		@Test(dependsOnMethods = "register")
		public void createAccount() {
			Reporter.log("FROM CREATEACCOUNT", true);
		}
		@Test
		public void modifyAccount() {
			Reporter.log("MODIFY ACCOUNT", true);
		}
		@Test
		public void register() {
			Reporter.log("FROM REGISTER", true);
		}
		@Test//(dependsOnMethods = "createAccount")
		public void amountTransfer() {
			Reporter.log("FROM AMOUNT TRANSFER", true);
		}
		@Test
		public void deleteAccount() {
			Reporter.log("FROM DELETE ACCOUNT", true);
		}
}


 