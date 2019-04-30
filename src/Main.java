/* Main Class */
public class Main {
	
	/* Fields need to be public for Threading */
	static public boolean[] found ;
	static public String password = "";
	/*********** Inputs From user ******************/
	/* Current Length starting from minimum length */
	static public int currentLength = 0;
	/* Max length of passwords to stop at*/
	static public int maxLength = 0;
	/* Number of threads to search */
	static int numberOfClients = 1;

	public static void main(String[] args) throws InterruptedException 
	{
		/* Initialize  the found Array */
		found = new boolean[numberOfClients];
		
		for (int i=0 ; i< numberOfClients; i ++)
		{
			/* initialize it's found boolean by false */
			found[i] = false;
			/* Create new Client Object */
			Client client = new Client(i);
			/* Create thread with client object */
			Thread T = new Thread(client);
			/* Set Thread Name */
			T.setName(String.valueOf(i));
			/* Start the Thread */
			T.start();
		}
		
	}
}
