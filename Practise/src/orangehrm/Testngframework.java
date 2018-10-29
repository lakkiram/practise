package orangehrm;

import org.testng.annotations.Test;

public class Testngframework {
	@Test
	public void frameworkexmp() {
		
Framework fw=new Framework();
fw.configDriver("Chrome");
fw.openAAPS("http://apps.qaplanet.in/qahrm/login.php");
fw.loginTOOrangeHRM("qaplanet1","lab1");


}
}