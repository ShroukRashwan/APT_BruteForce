/* Main Class */
public class Main {

	public static void main(String[] args) 
	{
		/* an Object of the TestClass */
		TestClass myTest = new TestClass();
		/* An Object of the Generator Class */
		BruteForceGenerator myGenerator = new BruteForceGenerator();
		
		/* Setting the CallBackFunction with your TestClass Object */
		myGenerator.setCallBack(myTest);
		/* Calling the Generator to Generate Passwords with Length = 3,
		 * and it will implicitly call your "CallBackFunction" in your "TestClass"
		 * and if you return true, it will end the function and if not, it will continue
		 * recursing until your CallBackFunction returns true
		 */
		myGenerator.crackPassword(3);
	}

}
