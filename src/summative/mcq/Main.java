package summative.mcq;

public class Main {

    public static void main(String[] args) {
        System.out.println("============================");
        System.out.println("Welcome to the MCQs System");
        System.out.println("============================\n");

        User user = new User();
        McqSystem mcqSystem = new McqSystem();

        // Input User Name
        String name = user.inputUserName();

        // Display Mcq List
        mcqSystem.displayMcqList(name);

        // Input User Mcq Set Options
        mcqSystem.inputUserMcqSet();

        // Display Question
        mcqSystem.displayQuestion();

        // Display Result
        mcqSystem.displayResult();
    }
}
