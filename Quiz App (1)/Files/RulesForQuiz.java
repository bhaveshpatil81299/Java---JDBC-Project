package quiz;

public class RulesForQuiz {

	// This are the rules of quiz
	public void displayRules() {
		System.out.println("Please read the following rules very carefully.");
		System.out.println("Rules for quiz competition:");
		System.out.println("1.You must select only one option among the four options displayed on the screen.");
		System.out.println(
				"2.For selecting the option you need to type the option for example if the answer is ‘option A’ then you must type "
				+ "'A' or 'a' to select the answer.");
		System.out.println("3.To confirm the answer press the enter key.");
		System.out.println(
				"4.Once the option is selected you cannot change the option, so please select the options carefully.");
		System.out.println(
				"5.If you select a wrong or invalid option, then your answer will be automatically marked as wrong and you will\n  "
				+ "not get other chance to correct your mistake. So please select the options carefully.");
	}

}
