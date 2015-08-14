import java.util.Scanner;

public class ConsoleProgram{

	private Scanner scanner;

	public static void main(String[] args){
		// Assume the class name is passed in as the first argument.

		if(args.length == 0){
			System.out.println("Please provide the name of the main class as an argument.");
			return;
		}

		String mainClassName = args[0];

		try{
			Class mainClass = Class.forName(mainClassName);
			Object obj = mainClass.newInstance();
			ConsoleProgram program = (ConsoleProgram)obj;
			program.run();
		} catch (IllegalAccessException ex) {
			System.out.println("Error in program. Make sure you extend ConsoleProgram");
		} catch (InstantiationException ex) {
			System.out.println("Error in program. Make sure you extend ConsoleProgram");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error in program. Make sure you extend ConsoleProgram");
		}
	}

	/**
	 * The run method is overwritten by the subclass. This is the main entry point for
	 * ConsolePrograms. There is no main method in student programs that extend ConsoleProgram,
	 * instead they write their application starting like this:
	 * 
	 * 		public void run()
	 * 		{
	 * 			// student code here
	 * 		}
	 * 
	 * The main method of ConsoleProgram calls this run method when it begins.
	 */
	public void run(){
		/* Overridden by subclass */
	}

	/**
	 * Constructor for Console program. Create a scanner instance to be used for user input.
	 */
	public ConsoleProgram(){
		scanner = new Scanner(System.in);
	}

	/**
	 * This method reads a line of input from the user, given a prompt. 
	 * 
	 * @param prompt	A prompt to the user to get input
	 * @return	A String of the user input.
	 */
	public String readLine(String prompt){
		System.out.print(prompt);
		return scanner.nextLine();
	}

	/**
	 * This method reads a boolean value from the user, asking them for either
	 * a true or false value. This makes use of the readLine method.
	 * 
	 * @param prompt	A prompt to the user to read a boolean value
	 * @return	A boolean value read from the user.
	 */
	public boolean readBoolean(String prompt){

		while(true){
			String input = readLine(prompt);

			if(input.equalsIgnoreCase("true")){
				return true;
			}

			if(input.equalsIgnoreCase("false")){
				return false;
			}
		}
	}

	/**
	 * This method reads a double value from the user, given a prompt.
	 * 
	 * @param prompt	A prompt to the user to ask for a a double.
	 * @return	A double value read from the user.
	 */
	public double readDouble(String prompt){

		while(true){
			String input = readLine(prompt);
			try {
				double n = Double.valueOf(input).doubleValue();
				return n;
			} catch (NumberFormatException e){

			}
		}
	}

	/**
	 * This method reads a int value from the user, given a prompt.
	 * 
	 * @param prompt	A prompt to the user to ask for an int
	 * @return	The int value read from the user.
	 */
	public int readInt(String prompt){

		while(true){
			String input = readLine(prompt);
			try {
				int n = Integer.parseInt(input);
				return n;
			} catch (NumberFormatException e){

			}
		}
	}

}