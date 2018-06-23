package pl.sdacademy.hr;

public class Main {
	public static void main(String[] args) {
		HrManager hrManager = new HrManager();
		CommandLineRunner.load(args, new HrManager());
		CommandLineRunner.list(hrManager).forEach(System.out::println);


	}
}
