package gui.controller;
import gui.model.RecursionTool;
import gui.view.RecursionFrame;
import gui.model.CodeTimer;

public class RecursionController 
{
	private RecursionFrame baseFrame;
	private RecursionTool mathTool;
	private CodeTimer myTimer;
	private String calculatedValue;
	
	public RecursionController()
	{
		mathTool = new RecursionTool();
		baseFrame = new RecursionFrame(this);
		myTimer = new CodeTimer();
	}
	
	public void start()
	{
		calculatedValue = Integer.toString(mathTool.getFibNumber(0));
	}
	
	public String getCalculatedValue()
	{
		return calculatedValue;
	}
	
	public String doFibonacci(String inputValue)
	{
		myTimer.resetTimer();
		myTimer.startTimer();

		calculatedValue = "The Fibonacci sequence number of " + inputValue + 
				" is " + Integer.toString(mathTool.getFibNumber(Integer.parseInt(inputValue)));
		myTimer.stopTimer();
		
		return calculatedValue + myTimer.toString(); 
	}
	
	public String doFactorial(String inputValue)
	{
		myTimer.resetTimer();
		myTimer.startTimer();
		calculatedValue = "The factorial of" + inputValue + " is " +
	Double.toString(mathTool.getFactorialNumber(Double.parseDouble(inputValue)));
		myTimer.stopTimer();
		
		return myTimer.toString() + calculatedValue;
		
	}
}
