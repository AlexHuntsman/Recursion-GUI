package gui.view;

import gui.controller.RecursionController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class RecursionPanel extends JPanel
{
	private RecursionController baseController;
	private JButton fibonacciButton;
	private JButton factorialButton;
	private JTextField inputField;
	private JTextArea resultsArea;
	private SpringLayout baseLayout;
	
	public RecursionPanel(RecursionController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		fibonacciButton = new JButton("Get the Fibonacci sequence for this number");
		factorialButton = new JButton("Gen n!");
		inputField = new JTextField(20);
		resultsArea = new JTextArea(10 , 20);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(fibonacciButton);
		this.add(factorialButton);
		this.add(inputField);
		this.add(resultsArea);
		this.setBackground(Color.CYAN);
		resultsArea.setWrapStyleWord(true);
		resultsArea.setLineWrap(true);
		resultsArea.setEditable(false);
		resultsArea.setText(baseController.getCalculatedValue());
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, fibonacciButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, fibonacciButton, 0, SpringLayout.NORTH, factorialButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, factorialButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, factorialButton, -25, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, resultsArea, 35, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, resultsArea, -100, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 26, SpringLayout.SOUTH, resultsArea);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, 0, SpringLayout.EAST, resultsArea);
		
	}
	
	private void setupListeners()
	{
		fibonacciButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userInput = inputField.getText();
				if(checkInput(userInput))
				{
					resultsArea.setText(baseController.doFibonacci(userInput));
				}
			}
		});
		
		factorialButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			String userInput = inputField.getText();
				if(checkInput(userInput))
				{
					resultsArea.append(baseController.doFactorial(userInput));
				}
			}
		});
		
		
	}
	
	private boolean checkInput(String input)
	{
		boolean isNumber = false;
		
		try
		{
			Integer.parseInt(input);
			isNumber = true;
		}
		catch(Exception numberException)
		{
			resultsArea.setText("type in a number!!!!");
		}
		return isNumber;
	}
}
