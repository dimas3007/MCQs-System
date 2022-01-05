package summative.mcq;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class McqSystem {
    private String userName;
    private String[][] userAnswer;
    private int currentMcqSet = 1;
    private int filesLength;
    String[] files;
    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g"};

    public void displayMcqList (String userName) {
        this.userName = userName;

        FileHandler file = new FileHandler();
        file.getListFiles();
        files = file.getNewFiles();

        System.out.println("Choose your Multiple Choice Question Set. The Options are : ");
        for (int i = 0; i < files.length; i++) {
            System.out.printf("%d. %s %n", i + 1, files[i].replace(".csv", "").replace("_", " ").toUpperCase(Locale.ROOT));
        }

        this.filesLength = files.length;
    }

    public void inputUserMcqSet () {
        Scanner input = new Scanner(System.in);
        System.out.printf("Choose your Multiple Choice Question Set (1 - %d) : ", filesLength);
        currentMcqSet = input.nextInt();
        while (currentMcqSet > filesLength || currentMcqSet < 1) {
            System.out.printf("Choose options between (1 - %d) %n", filesLength);
            System.out.printf("Choose your Multiple Choice Question Set (1 - %d) : ", filesLength);
            currentMcqSet = input.nextInt();
        }
        System.out.println("\n=======================================");
        System.out.printf("%s %n", files[currentMcqSet - 1].replace(".csv", "").replace("_", " ").toUpperCase(Locale.ROOT));
        System.out.println("=======================================\n");
    }

    public void displayQuestion() {
        FileHandler file = new FileHandler();

        List<List<String>> questions = file.readCsvFile(files[currentMcqSet - 1]);
        Question question = new Question(questions.size());

        int lineNo = 1;
        for(List<String> line: questions) {
            int columnNo = 1;
            int questionAnswer = 99;
            for (String value: line) {
                if (columnNo == 1)
                    System.out.printf("%d. %s %n", lineNo, value);
                else if (columnNo == line.size()) {
                    System.out.println("");
                    questionAnswer = Integer.parseInt(line.get(line.size() - 1));
                }
                else {
                    System.out.printf("\t %s. %s %n", alphabet[columnNo - 2], value);
                }
                columnNo++;
            }

            question.inputUserAnswer(lineNo);

            int indexAnswer = Arrays.asList(alphabet).indexOf(question.getCurrentAnswer());
            question.setCurrentValueAnswer(line.get(indexAnswer + 1));

            String[][] userAnswer = question.isAnswerCorrect(questionAnswer, indexAnswer, line.get(questionAnswer + 1));
//            question.setUserAnswer(userAnswer);
            this.userAnswer = userAnswer;
            lineNo++;
        }
    }

    public void displayResult () {
        int correctAnswer = 0;
        int incorrectAnswer = 0;
        for (int i = 0; i < this.userAnswer.length; i++) {
            if (this.userAnswer[i][2] == "correct") {
                correctAnswer++;
            } else {
                incorrectAnswer++;
            }
        }

        double score = (double) correctAnswer / this.userAnswer.length * 100;

        System.out.println("========================================================================================");
        System.out.printf("%s, you answered %d Question Right, %d Question wrong for a Total of %d Question. %n", this.userName, correctAnswer, incorrectAnswer, this.userAnswer.length);
        System.out.printf("You scored %d %n", (int) score);
        System.out.println("========================================================================================");
    }
}
