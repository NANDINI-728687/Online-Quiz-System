public class Question {
    private final String prompt;
    private final String[] options;
    private final int correctOption;

    public Question(String prompt, String[] options, int correctOption) {
        if (options == null || options.length != 4 || correctOption < 1 || correctOption > 4) {
            throw new IllegalArgumentException("A question must have four options and a correct option from 1 to 4.");
        }
        this.prompt = prompt;
        this.options = options.clone();
        this.correctOption = correctOption;
    }

    public String getPrompt() { return prompt; }
    public String[] getOptions() { return options.clone(); }
    public boolean isCorrect(int answer) { return answer == correctOption; }
}
