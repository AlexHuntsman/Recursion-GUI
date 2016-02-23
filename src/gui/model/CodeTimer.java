package gui.model;

public class CodeTimer 
{
	
	private long executionTime;
	
	public CodeTimer()
	{
		this.executionTime = 0;
	}
	
	public void startTimer()
	{
		this.executionTime = System.nanoTime();
	}
}
