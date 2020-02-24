/**
 * @author Hansen Li
 *
 * @date Jul 27, 2019
*/

// heavy assistance from CS mentor regarding tokens
// based off sample code from rosettacode.org 
// imports linked list and stack for existing code and operations
import java.util.LinkedList;
import java.util.Stack;

public class CalculationStack {
	
	// removes everything besides operators and whitespace
	private static String removeNonOperators(String input) {
		
		return input.replaceAll("[^\\^\\*\\+\\-\\d/\\s\\%\\(\\)]", "");
	}
	
	// converts the infix input into post fix notation
	public static String conversion(String infixInput) {
		
		// contains operation variables
		String operators = "()^%*/+-";
		
		// for building the post fix notation expression
		StringBuilder postFixNotationString = new StringBuilder();
		
		// stack that keeps track of number of elements
		Stack<Integer> intStack = new Stack<>();

		// removes white space from infix input and iterates through each element from input
		for (String token : infixInput.split("\\s")) {
			
			char currentChar = token.charAt(0);
			int indexOfChar = operators.indexOf(currentChar);

			if (indexOfChar != -1) {
				
				// check to see if there are no operators
				if (intStack.isEmpty())
					intStack.push(indexOfChar);

				else {
					// iterates while the int stack still has values
					while (!intStack.isEmpty()) {
						
						// converts infix index values to compare
						int prec2 = intStack.peek() / 2;
						int prec1 = indexOfChar / 2;
						
						// compares the converted infix index values to determine whether to append to postfix string
						if (prec2 > prec1 || (prec2 == prec1 && currentChar != '^')) {
							// appends the operators to string 
							postFixNotationString.append(operators.charAt(intStack.pop())).append(' ');
						}
						else {
							break;
						}
					}
					// pushes the value onto stack to update number of elements total
					intStack.push(indexOfChar);
				}
			} 
			else {
				// appends the element to the string as token iterates
				postFixNotationString.append(token).append(' ');
			}
		}
		// creates loop for while int stack isn't empty
		while (!intStack.isEmpty()) {
			// appends the operators from stack onto string
			postFixNotationString.append(operators.charAt(intStack.pop())).append(' ');
		}
		// returns the postfix notation string
		return postFixNotationString.toString();
	}
	
	// evaluates the post fix notation string
	public static Double postfixEval(String inputPostFix) {
		
		// cleans the input string
		inputPostFix = removeNonOperators(inputPostFix);
		
		// creates linked list for doubles to push operands
		LinkedList<Double> operatorStack = new LinkedList<Double>();
		
		// token iterates through elements in string
		for (String token : inputPostFix.split("\\s")) {
			
			Double tokenNum = null;
			
			// try catch block for token
			// CS mentor assisted with block
			try {
				tokenNum = Double.parseDouble(token);
			} 
			catch (NumberFormatException e) {
			}
			
			// evaluates the operators in stack
			if (tokenNum != null) {
				operatorStack.push(Double.parseDouble(token + ""));
				
			} 
			else if (token.equals("^")) {
				double secondOperand = operatorStack.pop();
				double firstOperand = operatorStack.pop();
				operatorStack.push(Math.pow(firstOperand, secondOperand));

			} 
			else if (token.equals("%")) {
				double secondOperand = operatorStack.pop();
				double firstOperand = operatorStack.pop();
				operatorStack.push(firstOperand % secondOperand);
			}
			
			else if (token.equals("*")) {
				double secondOperand = operatorStack.pop();
				double firstOperand = operatorStack.pop();
				operatorStack.push(firstOperand * secondOperand);
				
			} 
			else if (token.equals("/")) {
				double secondOperand = operatorStack.pop();
				double firstOperand = operatorStack.pop();
				operatorStack.push(firstOperand / secondOperand);
				
			} 
			else if (token.equals("-")) {
				double secondOperand = operatorStack.pop();
				double firstOperand = operatorStack.pop();
				operatorStack.push(firstOperand - secondOperand);
				
			} 
			else if (token.equals("+")) {
				double secondOperand = operatorStack.pop();
				double firstOperand = operatorStack.pop();
				operatorStack.push(firstOperand + secondOperand);
			}
			// if something goes wrong 
			else {
				System.out.println("Error");
				return null;
			}
		}
		
		return operatorStack.pop();
	}
}