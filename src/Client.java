import mpi.*;

public class Client implements CallBack{
	
	boolean[] found ;
	int[] currentLength;
	String[] args;
	int myRank;
	
	public Client(String[] args,boolean[] found,int[] currentLength)
	{
		/* Get Main arguments */
		this.args = args;
		/* Get Length to start generate at */
		this.currentLength = currentLength;
		/* Boolean which will determine when to stop */
		this.found = found;
		/* Initialize MPI */
		if (false == MPI.Initialized())
		{
			MPI.Init(args);	
		}
		else
		{
			//nothing
		}
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
		
		if (true == found[0])
		{
			/* Broadcast to all that the password found */
			MPI.COMM_WORLD.Bcast(found, 0,found.length, MPI.BOOLEAN, myRank);
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
		/* Increment the length */
		currentLength[0]++;
		/* Broadcast the new length */
		MPI.COMM_WORLD.Bcast(currentLength, 0, currentLength.length, MPI.INT, myRank);
		/* Generate Password at current length */
		myGenerator.crackPassword(currentLength[0]);
	}
}
