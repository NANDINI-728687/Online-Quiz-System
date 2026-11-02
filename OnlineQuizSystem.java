import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizSystem {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"implements", "extends", "inherits", "super"}, 2));
        questions.add(new Question("Which method is the entry point of a Java application?",
                new String[]{"start()", "run()", "main()", "init()"}, 3));
        questions.add(new Question("Which data type stores true or false?",
                new String[]{"int", "char", "String", "boolean"}, 4));
        questions.add(new Question("Which collection does not allow duplicate elements?",
                new String[]{"ArrayList", "HashSet", "LinkedList", "Vector"}, 2));
        questions.add(new Question("Which symbol ends most Java statements?",
                new String[]{".", ":", ";", ","}, 3));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("================================");
            System.out.println("       ONLINE QUIZ SYSTEM       ");
            System.out.println("================================");
            System.out.print("Enter your name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) name = "Student";

            int score = 0;
            for (int i = 0; i < questions.size(); i++) {
                Question question = questions.get(i);
                System.out.println("\nQuestion " + (i + 1) + ": " + question.getPrompt());
                String[] options = question.getOptions();
                for (int j = 0; j < options.length; j++) {
                    System.out.println((j + 1) + ". " + options[j]);
                }

                int answer = readAnswer(scanner);
                if (question.isCorrect(answer)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect.");
                }
            }

            System.out.println("\n========== RESULT ==========");
            System.out.println("Student: " + name);
            System.out.println("Score: " + score + " out of " + questions.size());
            System.out.printf("Percentage: %.2f%%%n", score * 100.0 / questions.size());
            System.out.println("Thank you for taking the quiz!");
        }
    }

    private static int readAnswer(Scanner scanner) {
        while (true) {
            System.out.print("Choose an option (1-4): ");
            String input = scanner.nextLine().trim();
            try {
                int answer = Integer.parseInt(input);
                if (answer >= 1 && answer <= 4) return answer;
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Please enter a number from 1 to 4.");
        }
    }
}
