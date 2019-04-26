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
		/* For debugging only */
		System.out.println("Client number " + myRank + " Started");
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
		if ( 0 == myRank)
		{
			Request R1 = MPI.COMM_WORLD.Irecv(currentLength, 0, currentLength.length, MPI.INT, 1, 66);
			Request R2 = MPI.COMM_WORLD.Irecv(currentLength, 0, currentLength.length, MPI.INT, 2, 66);
			Request R3 = MPI.COMM_WORLD.Irecv(currentLength, 0, currentLength.length, MPI.INT, 3, 66);
			Request R4 = MPI.COMM_WORLD.Irecv(currentLength, 0, currentLength.length, MPI.INT, 4, 66);
						
			/* Broadcast the new length */
			MPI.COMM_WORLD.Bcast(currentLength, 0, currentLength.length, MPI.INT, 0);
			/* Increment the length */
			currentLength[0]++;
		}
		else
		{
			/* Get the new length */
			MPI.COMM_WORLD.Bcast(currentLength, 0, currentLength.length, MPI.INT, 0);
			/* Create Generator Object */
			System.out.println("current length" + currentLength[0]);
			BruteForceGenerator myGenerator = new BruteForceGenerator();
			/* Set "Client" as call back */
			myGenerator.setCallBack(this);
			/* Generate Password at current length */
			myGenerator.crackPassword(currentLength[0]);
		}
	}
}
