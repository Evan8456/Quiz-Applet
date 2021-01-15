public class Questions
/*
 * By: Evan NG
 * IC4UO-D1
 * 323058826
 */
{
    public Questions(String questions, String possibleA, String possibleB, String possibleC,String possibleD,String possibleE,
    char answers, int diff )
    /*
     * This constructor is used to assign the questions, options, answers, and difficulties of each question to one of the instance varibles.
     */
    { 
        question= questions;
        optionA = possibleA;
        optionB= possibleB;
        optionC=possibleC;
        optionD= possibleD; 
        optionE = possibleE;
        answer = answers;
        difficulty= diff;
    }

    public Questions(){}

    public String getQuestion()
     /*
     * The methods below are all methods that return the data stored in each instance varible.
     */
    {
        return question;
    }

    public String getOptionA()
    {
        return optionA;
    }

    public String getOptionB()
    {
        return optionB;
    }

    public String getOptionC()
    {
        return optionC;
    }

    public String getOptionD()
    {
        return optionD;
    }

    public String getOptionE()
    {
        return optionE;
    }

    public int getDifficulty()
    {
        return difficulty;
    }

    public char getAnswer()
    {
        return answer;
    }
     /*
     * The code below are my instance varibles.
     */
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private char  answer;
    private int difficulty;
}
