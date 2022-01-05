package summative.mcq;

import java.util.Arrays;
import java.util.Scanner;

public class Question extends McqSystem {
    private String currentAnswer;
    private String currentValueAnswer;
    private String[][] userAnswer;
    private int currentQuestion;

    public Question (int currentTotalQuestion) {
        userAnswer = new String[currentTotalQuestion][3];
    }

    public Question () {}

    public void inputUserAnswer (int currentQuestion) {
        this.currentQuestion = currentQuestion;
        Scanner input = new Scanner(System.in);
        System.out.print("Your Answer is : ");
        currentAnswer = input.nextLine();

        userAnswer[currentQuestion - 1][0] = currentAnswer;
    }

    public String getCurrentAnswer () {
        return this.currentAnswer;
    }

    public void setCurrentValueAnswer(String currentValueAnswer) {
        userAnswer[currentQuestion - 1][1] = currentValueAnswer;
        this.currentValueAnswer = currentValueAnswer;
    }

    public String[][] isAnswerCorrect (int questionAnswer, int userAnswer, String correctAnswer) {
        this.userAnswer[currentQuestion - 1][2] = questionAnswer == userAnswer ? "correct" : "incorrect";
        if (this.userAnswer[currentQuestion - 1][2] == "correct") {
            System.out.printf("Your answer is correct, %s. %s %n%n", currentAnswer, currentValueAnswer);
        } else {
            System.out.printf("Your answer is wrong, the correct answer is %s. %s %n%n", super.alphabet[questionAnswer], correctAnswer);
        }

        return this.userAnswer;
    }

    public String[][] getUserAnswer() {
        return this.userAnswer;
    }

    public void setUserAnswer(String[][] userAnswer) {
        System.out.println("WHYYYYY" + Arrays.deepToString(userAnswer));
        this.userAnswer = userAnswer;
    }
}
