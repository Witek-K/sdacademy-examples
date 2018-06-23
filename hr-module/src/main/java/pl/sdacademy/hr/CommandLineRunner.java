package pl.sdacademy.hr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandLineRunner {
	static void load(String[] args, HrManager hrManager) {
		if (containsAllArguments(args))

			hrManager.create(extractArgument(args[0], "firstName"), extractArgument(args[1], "lastName"),
				extractArgument(args[2], "dateOfBirth"));
		else {
			throw new IllegalArgumentException();

		}

	}
	private static boolean containsAllArguments(String[] args) {
		return Stream.of(args).allMatch(arg ->
			arg.contains("firstName") || arg.contains("lastName") || arg.contains("dateOfBirth"));
		 //&& args.length == 3

	}

	private static String extractArgument(String argument, String argumentKey){
		return argument.split(argumentKey + "=")[1];
	}

	public static List<String> list(HrManager hrManager) {

		return hrManager.findAll().stream().map(Employee::toString).collect(Collectors.toList());
	}
}
