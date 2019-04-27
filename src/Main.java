/* Main Class */
public class Main {
	
	/* Fields need to be public for MPI */
	static boolean found[] = {false};
	static int[] currentLength = {0};

	public static void main(String[] args) 
	{
		/* an Object of the TestClass */
		//TestClass myTest = new TestClass();
		/* An Object of the Generator Class */
		//BruteForceGenerator myGenerator = new BruteForceGenerator();
		
		/* Setting the CallBackFunction with your TestClass Object */
		//myGenerator.setCallBack(myTest);
		/* Calling the Generator to Generate Passwords with Length = 3,
		 * and it will implicitly call your "CallBackFunction" in your "TestClass"
		 * and if you return true, it will end the function and if not, it will continue
		 * recursing until your CallBackFunction returns true
		 */
		//myGenerator.crackPassword(3);
		
		/* Create new Client Object */
		Client client = new Client(args,found,currentLength);
	    client.start();
	}
}
