
public class Client implements CallBack, Runnable{

	int myID;
	boolean run = true;
	
	public Client(int id)
	{
		myID = id;
	}
	
	public boolean CallBackFunction(StringBuilder input)
	{		
		/* 
		 * Client Server Code which change Value of Found 
		 *  ---------- HERE -----------
		 */
		if (input.toString().equals("11"))
		{
			/* For Debugging: Print found Password */
			System.out.println("Password found: " + input.toString());
			/* Get Password to be send to server */
			Main.password = input.toString();
			Main.found[myID] = true;
		}
		else
		{
			Main.found[myID] = false;
		}
		 return Main.found[myID];
	}
	
	public void run() {
		
		while (true == run || Main.currentLength < Main.maxLength)
		{
			/* Search if any thread found the password */ 
			for(int i=0; i< Main.found.length; i++ )
			{
				if( true == Main.found[i])
				{
					/* if yes stop running  and break from for loop*/
					run = false;
					break; 
				}
			}	
			/* then break from while loop */
			if ( false == run)
			{
				break;
			}
			/* Create Generator Object */
			BruteForceGenerator myGenerator = new BruteForceGenerator();
			/* Set "Client" as call back */
			myGenerator.setCallBack(this);
			/* Generate Password at current length */
			myGenerator.crackPassword(Main.currentLength++);
		}
	}
}
