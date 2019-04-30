import mpi.*;

public class MPIClient implements CallBack{
	
	boolean[] found ;
	int[] currentLength;
	String[] args;
	int myRank;
	
	public MPIClient(String[] args,boolean[] found,int[] currentLength)
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
			//MPI.COMM_WORLD.Bcast(found, 0,found.length, MPI.BOOLEAN, 0);
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
		while (false == found[0])
		{
			if ( 0 == myRank)
			{
				
				/* Send new length to process 1 */
				MPI.COMM_WORLD.Isend(currentLength, 0, currentLength.length, MPI.INT, 1, 22);
				/* Increment the length */
				currentLength[0]++;
	
				/* Send new length to process 2 */
				MPI.COMM_WORLD.Isend(currentLength, 0, currentLength.length, MPI.INT, 2, 22);
				/* Increment the length */
				currentLength[0]++;
	
				/* Send new length to process 3 */
				MPI.COMM_WORLD.Isend(currentLength, 0, currentLength.length, MPI.INT, 3, 22);
				/* Increment the length */
				currentLength[0]++;
	
				/* Send new length to process 3 */
				MPI.COMM_WORLD.Isend(currentLength, 0, currentLength.length, MPI.INT, 4, 22);
				/* Increment the length */
				currentLength[0]++;	
			}
			else
			{	
	            /* Get the new length */
				Request R = MPI.COMM_WORLD.Irecv(currentLength, 0, currentLength.length, MPI.INT, 0, 22);
				R.Wait();
				/* For debugging only */
				//System.out.println("current length: " + currentLength[0] + " My Rank: " + myRank);			
				/* Create Generator Object */
				BruteForceGenerator myGenerator = new BruteForceGenerator();
				/* Set "Client" as call back */
				myGenerator.setCallBack(this);
				/* Generate Password at current length */
				myGenerator.crackPassword(currentLength[0]);
			}
		}
	}
}
