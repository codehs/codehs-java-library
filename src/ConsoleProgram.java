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

	public void run(){
		/* Overridden by subclass */
	}

	public ConsoleProgram(){
		scanner = new Scanner(System.in);

	}

	public String readLine(String prompt){
		System.out.print(prompt);
		return scanner.nextLine();
	}

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

	// Allow the user to get an integer.
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