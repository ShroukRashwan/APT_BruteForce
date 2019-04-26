import mpi.*;

public class Client implements CallBack{
	
	boolean found ;
	int currentLength;
	String[] args;
	int myRank;
	
	public Client(String[] args,boolean found,int currentLength)
	{
		/* Get Main arguments */
		this.args = args;
		/* Get Length to start generate at */
		this.currentLength = currentLength;
		/* Boolean which will determine when to stop */
		this.found = found;
		/* Initialize MPI */
		MPI.Init(args);	
		/* Get my Process Rank */
		myRank = MPI.COMM_WORLD.Rank();
	}
	
	public boolean CallBackFunction(StringBuilder input)
	{
		boolean returnValue = false;
		
		/* 
		 * Client Server Code which change Value of Found 
		 *  ---------- HERE -----------
		 */
		
		if (true == found)
		{
			/* Broadcast to all that the password found */
			MPI.COMM_WORLD.Bcast(Boolean.valueOf(found), 0,1, MPI.BOOLEAN, myRank);
			returnValue = true;
		}
		else
		{
			// Nothing
		}
		return returnValue;
	}
	
	public void start()
	{
		/* For debugging only */
		System.out.println("Client number " + myRank + " Started");
		/* Create Generator Object */
		BruteForceGenerator myGenerator = new BruteForceGenerator();
		/* Set "Client" as call back */
		myGenerator.setCallBack(this);
		/* Generate Password at current length */
		myGenerator.crackPassword(currentLength);
		/* Increment the length */
		currentLength++;
		/* Broadcast the new length */
		MPI.COMM_WORLD.Bcast(Integer.valueOf(currentLength), 0, currentLength*Integer.SIZE, MPI.INT, myRank);
	}
}
