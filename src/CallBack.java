/* Just a small Interface for CallBack to be used as implemented in TestClass */
public interface CallBack 
{
	/* CallBackFunction Prototype returns boolean and takes
	 * input as string builder object. 
	 * Warning: NOT MODIFYABLE! 
	 * */
	public boolean CallBackFunction(StringBuilder input);
}
