/*
 * The following are the various imports require to creat the quiz GUI.
 */
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
public class QuizGUI2 extends JFrame 
/*
 * By: Evan NG
 * IC4UO-D1
 * 323058826
 */
{
    // The following are the various instance varibles used for the quiz.

    private JTextArea txtrWelcomeToThe;
    private JTextArea quizQuestions;
    private JTextArea showQuestion;

    private JLabel SortDescendingAnd;

    private JPanel startButtonPanel;
    private JPanel welcomePanel;
    private JPanel chooserOptions;
    private JPanel chooserOptions2;
    private JPanel chooserOptions3;
    private JPanel chooserOptions4;
    private JPanel chooserOptions5;
    private JPanel quizing;
    private JPanel quizing2;
    private JPanel finalPanel;

    private JButton startButton;
    private JButton sortDescent;
    private JButton sortAscent;
    private JButton beginQuiz;
    private JButton search;
    private JButton Continue;
    private JButton EasyButton;
    private JButton choosefile;
    private JButton confirmAnswer;
    private JButton med;
    private JButton hardbutton;
    private JButton Continue2;
    private JButton exit;
    private JButton BackToMain;
    private JButton restartQuiz;
    private JButton yes;
    private JButton no;

    private JRadioButton buttonA;
    private JRadioButton buttonB;
    private JRadioButton buttonC;
    private JRadioButton buttonD;    
    private JRadioButton buttonE;

    static int score=0;
    static int QuestionNum=0;
    static int QuestionNum2=0;
    private boolean accend= false;
    private boolean decend = false;

    private JLabel scoreText;
    private JLabel Difficulty;

    private static ArrayList<Questions> quest;
    private static ArrayList<Questions> searchArr=new ArrayList<Questions>();
    private static ArrayList<Questions> theFinal=new ArrayList<Questions>();
    private static ArrayList<Questions> theFinal2=new ArrayList<Questions>();
    private static ArrayList<String> answer =new ArrayList<String>();
    public QuizGUI2() 
    /*
     * Constructor 
     */
    {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        switchThis();
    }

    private void switchThis()
    /*
     * This method creats the main menu of the GUI and has 3 buttons. Start Button, an Exit Button, and a Choose file Button.
     */
    {

        setTitle("Quiz Name");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when user presses exit

        welcomePanel = new JPanel();
        getContentPane().add(welcomePanel, BorderLayout.NORTH); 

        txtrWelcomeToThe = new JTextArea();
        txtrWelcomeToThe.setFont(new Font("Monospaced", Font.BOLD, 30));
        txtrWelcomeToThe.setText("Welcome to the Quiz");
        welcomePanel.add(txtrWelcomeToThe);

        startButtonPanel = new JPanel();
        getContentPane().add(startButtonPanel, BorderLayout.CENTER);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                {
                    if(quest==null|| quest.size()==0)
                    {
                        JOptionPane.showMessageDialog(null,"Please Choose a File a Text File what is Compatible with the Quiz Before Starting ","Insructions",JOptionPane.INFORMATION_MESSAGE);
                        quest = File2.getQuiz();
                    }
                    else
                        switchToMain();

                }
            });

        choosefile= new JButton("Choose File");
        choosefile.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * ActionListener for choosing file.
                 */
                {       
                    ChooseFile();
                    quest = File2.getQuiz();
                }
            });

        exit= new JButton("Exit");
        exit.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * ActionListener for Exiting GUI.
                 */
                {
                    exit(); 
                }
            });

        startButtonPanel.add(startButton);
        startButtonPanel.add(exit);

        startButtonPanel.add(choosefile);
        setMinimumSize(new Dimension(850,400));
        pack();
        setVisible(true);

    }

    private void switchToMain()
    /*
     * This method switches to the next Panel where we see
     */
    {
        remove(welcomePanel);
        remove(startButtonPanel);
        chooserOptions = new JPanel();
        getContentPane().add(chooserOptions, BorderLayout.NORTH);
        chooserOptions.setLayout(new BoxLayout(chooserOptions,BoxLayout.Y_AXIS));

        SortDescendingAnd = new JLabel( "Sort Descending  And ascending Order ");
        SortDescendingAnd .setFont (new Font ("Helvetica", Font.BOLD, 12));
        chooserOptions.add( SortDescendingAnd);

        chooserOptions.add(Box.createVerticalStrut(25));

        sortDescent = new JButton("Sort in Descending Order ");

        chooserOptions.add(sortDescent);
        sortDescent.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * ActionListener for sorting in decending order
                 */
                {
                    File2.sortDecreasing(quest);
                    decend = true;
                    accend =false;
                    sortDescent.setText("Sorted in Decending order");
                    sortAscent.setText("Sort in Ascending order");
                }
            });

        sortAscent= new JButton("Sort in Ascending Order");
        chooserOptions.add(sortAscent);
        chooserOptions.add(Box.createVerticalGlue());
        sortAscent.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * ActionListener for sorting in ascending order
                 */
                {
                    File2.sortIncreasing(quest);
                    accend =true;
                    decend = false;
                    sortAscent.setText("Sorted in Ascending order");
                    sortDescent.setText("Sort in Decending order");
                }
            });
   
        chooserOptions.add(Box.createVerticalStrut(10));
        Difficulty = new JLabel("Difficulty and Search");
        Difficulty .setFont (new Font ("Helvetica", Font.BOLD, 12));
        chooserOptions.add( Difficulty);
        chooserOptions.add(Box.createVerticalStrut(25));

        getContentPane().add(chooserOptions, BorderLayout.NORTH);
        chooserOptions.setLayout(new BoxLayout(chooserOptions,BoxLayout.Y_AXIS));

        EasyButton = new JButton("Get Easy questions");
        chooserOptions.add(EasyButton);

        EasyButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * actionPerform for easy questions. 
                 */
                {
                    getEasy(quest);
                }
            });

        med = new JButton("Get Medium questions");
        chooserOptions.add(med);
        //chooserOptions2.add(Box.createVerticalGlue());
        med.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * actionPerform for Medium questions. 
                 */
                {
                    getMed(quest);
                }
            });

        hardbutton = new JButton("Get Hard questions");
        chooserOptions.add(hardbutton);
        
        hardbutton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * actionPerform for hard questions. 
                 */
                {
                    getHard(quest);

                    
                }
            });

        chooserOptions3 = new JPanel();
        getContentPane().add(chooserOptions3, BorderLayout.CENTER);
        chooserOptions3.setLayout(new BoxLayout(chooserOptions3,BoxLayout.Y_AXIS));

        search = new JButton("Search for Category");
        chooserOptions3.add(search);
        chooserOptions3.add(Box.createVerticalGlue());

        search.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args)
                /*
                 * ActionListener to search for questions.
                 */
                {
                    search();

                }
            });

        beginQuiz = new JButton("Begin Quiz");
        chooserOptions3.add(beginQuiz);
        chooserOptions3.add(Box.createVerticalGlue());

        beginQuiz.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * ActionListener to start quiz. In addtion does the final sorting for the quiz and writes the final draft of the quiz questions 
                 * and answers in t separate txt file by calling a method.
                 */
                {
                    if(searchArr.size()==0)
                    {
                        searchArr = quest;
                    }

                    theFinal = searchArr;
                    if(accend==true)
                    {
                        File2.sortIncreasing(theFinal);
                    }
                    else if(decend == true)
                    {
                        File2.sortDecreasing(theFinal);
                    }

                    QuuestionCheck();
                }
            });
            
             exit = new JButton("Exit");
        chooserOptions3.add(exit);
        chooserOptions3.add(Box.createVerticalGlue());
        exit.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * actionlistener for exiting GUI.
                 */
                {
                    exit();
                }
            });


        refresh();
    }
   
    private void QuuestionCheck()
    {
        remove(chooserOptions3);
        remove(chooserOptions);
        chooserOptions4=new JPanel();
        getContentPane().add(chooserOptions4, BorderLayout.NORTH);
        chooserOptions4.setLayout(new BoxLayout(chooserOptions4,BoxLayout.Y_AXIS));

        showQuestion = new JTextArea();
        showQuestion.setFont(new Font("Monospaced", Font.BOLD, 12));
        showQuestion.setText(theFinal.get(QuestionNum2).getQuestion());
        chooserOptions4.add(showQuestion);

        chooserOptions5= new JPanel();
        getContentPane().add(chooserOptions5, BorderLayout.CENTER);
        chooserOptions5.setLayout(new BoxLayout(chooserOptions5,BoxLayout.Y_AXIS));

        yes = new JButton("Keep Question");
        chooserOptions5.add(yes);
        yes.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * actionPerform for hard questions. 
                 */
                {
                  
                    if(QuestionNum2<theFinal.size())
                    {
                        theFinal2.add(theFinal.get(QuestionNum2));
                        theFinal.remove( QuestionNum2);
                        if(theFinal.size()!=0)
                            showQuestion.setText(theFinal.get(QuestionNum2).getQuestion());
                        else if(theFinal.size()==0)
                        {
                            if(accend==true)
                            {
                                File2.sortIncreasing(theFinal2);
                            }
                            else if(decend == true)
                            {
                                File2.sortDecreasing(theFinal2);
                            }
                            answers();
                            quiz();
                            try{
                                write();
                            }catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    } 

                }
            });

        no = new JButton("Discard");
        chooserOptions5.add(no);
        chooserOptions5.add(no,BorderLayout.CENTER);

        no.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * actionPerform for hard questions. 
                 */
                {           
                    if(QuestionNum2<theFinal.size())
                    {
                        theFinal.remove( QuestionNum2);
                        if(theFinal.size()!=0)
                            showQuestion.setText(theFinal.get(QuestionNum2).getQuestion());
                        else if(theFinal.size()==0)
                        {
                            if(accend==true)
                            {
                                File2.sortIncreasing(theFinal2);
                            }
                            else if(decend == true)
                            {
                                File2.sortDecreasing(theFinal2);
                            }

                            answers();
                            quiz();
                            try{
                                write();
                            }catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    } 
                }
            });
            
              
             exit = new JButton("Exit");
        chooserOptions5.add(exit);
        chooserOptions5.add(Box.createVerticalGlue());
        exit.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                /*
                 * actionlistener for exiting GUI.
                 */
                {
                    exit();
                }
            });

        refresh();
    }

    private void quiz()
    /*
     * This method is used to display the quiz questions as well as it's options. This is doen by creating a button group and a text area that 
     * changes contents everytime user hits the confirm button.
     * *Note that unanswered questions will be treated as an incorrect ansewer.
     */
    {
        remove(chooserOptions4);
        remove(chooserOptions5);

        quizing = new JPanel();
        getContentPane().add(quizing, BorderLayout.NORTH);
        quizing.setLayout(new BoxLayout(quizing,BoxLayout.Y_AXIS));

        quizQuestions = new JTextArea();
        quizQuestions.setFont(new Font("Monospaced", Font.BOLD, 12));
        quizQuestions.setText(theFinal2.get(QuestionNum).getQuestion());
        quizing.add(quizQuestions);

        quizing2 = new JPanel();
        getContentPane().add(quizing2, BorderLayout.CENTER);
        quizing2.setLayout(new BoxLayout(quizing2,BoxLayout.Y_AXIS));

        //Creating a button group for the quiz. Button group consists of five radio buttons. 
        ButtonGroup A = new ButtonGroup();
        buttonA = new JRadioButton();
        buttonB = new JRadioButton();
        buttonC = new JRadioButton();
        buttonD = new JRadioButton();
        buttonE = new JRadioButton();

        A.add(buttonA);
        A.add(buttonB);
        A.add(buttonC);
        A.add(buttonD);
        A.add(buttonE);

        buttonA.setText(theFinal2.get(QuestionNum).getOptionA());
        buttonB.setText(theFinal2.get(QuestionNum).getOptionB());
        buttonC.setText(theFinal2.get(QuestionNum).getOptionC());
        buttonD.setText(theFinal2.get(QuestionNum).getOptionD());
        buttonE.setText(theFinal2.get(QuestionNum).getOptionE());

        // adding to panel
        quizing2.add (buttonA);
        quizing2.add (buttonB);
        quizing2.add (buttonC);
        quizing2.add (buttonD);
        quizing2.add (buttonE);

        confirmAnswer = new JButton("Confirm") {
            {
                setSize(150, 50);
                setMaximumSize(getSize());
            }
        };
        quizing2.add(confirmAnswer);
        confirmAnswer.add(Box.createVerticalGlue());

        confirmAnswer.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                //ActionListener to check answer user inputed was correct.
                {
                    checkAnswers();

                }
            });

        exit = new JButton("Exit Quiz") {
            {
                setSize(150, 50);
                setMaximumSize(getSize());
            }
        };

        quizing2.add(exit,BorderLayout.SOUTH);
        exit.add(Box.createVerticalGlue());

        exit.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                //Action listener used to switch to the final panel.
                {                    
                    finalPanel();
                }
            });

        refresh();
    }

    private void finalPanel()
    /*
     * This panel is used to say thank you to the user for plaing the quiz. In addition, a window will display the user's 
     * results based on thire performance. User may then go back to the main menu and do another quiz or the user can take a re-test or exit.
     */
    {
        remove(quizing);
        remove(quizing2);

        finalPanel = new JPanel();
        getContentPane().add(finalPanel, BorderLayout.CENTER);
        finalPanel.setLayout(new BoxLayout(finalPanel,BoxLayout.Y_AXIS));

        scoreText = new JLabel("Thank you for Playing");

        scoreText.setFont (new Font ("Helvetica", Font.BOLD, 30));
        finalPanel.add(scoreText);

        JOptionPane.showMessageDialog(null,"You  got " + score + " out of "+theFinal2.size(),"Score",JOptionPane.PLAIN_MESSAGE);

        exit = new JButton("Exit");
        finalPanel.add(exit);
        finalPanel.add(Box.createHorizontalGlue());

        exit.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                //ActionListener for exiting.
                {

                    exit();
                }
            });

        restartQuiz= new JButton("Re-test");
        finalPanel.add(restartQuiz);
        finalPanel.add(Box.createHorizontalGlue());

        restartQuiz.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                //ActionListener for re-test.
                {
                    score=0;
                    QuestionNum=0;
                    remove(finalPanel);
                    quiz();
                }
            });

        BackToMain = new JButton("Back to Main Menu");
        finalPanel.add( BackToMain);
        finalPanel.add(Box.createHorizontalGlue());

        BackToMain.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent args) 
                //ActionListener for going back to main menu.
                {
                    backToMain();
                }
            });

        refresh();
    }

    private void refresh()
    {
        // refreshes the panel
        revalidate();
        repaint();
    }

    public static void search()
    /*
     * Goes through the arrayList of questions an uses the contains() to look for keywards that could match what the user want to be tested on.
     * Displays a message if the keyword that user inputed was invalid.
     */
    {
        String keyword = null;
        keyword= JOptionPane.showInputDialog("Input the Keyword");

        if(keyword!= null)
        {
            for(int i=0;i< quest.size();i++)
            {

                if(quest.get(i).getQuestion().toUpperCase().contains(keyword.toUpperCase()))
                {
                    searchArr.add(quest.get(i));
                    quest.remove(i);
                    i--;
                }

            }
            if(searchArr.size() ==0)
            { 
                JOptionPane.showMessageDialog(null,"There is no question that matches Keyword. Please try again","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void getEasy(ArrayList<Questions> arr)

    {
        /*
         * sorts through the array list to find medium leveled questions. it will then
         * store the questions in a new array dedicated for only easy leveled questions. 
         */

        for(int i =0; i<arr.size();i++)
        {
            if((arr.get(i).getDifficulty() >5))
            {
                quest.remove(i);
                i--;
            }
        }
    }

    public static void getMed(ArrayList<Questions> arr)
    {
        /*
         * sorts through the array list to find medium leveled questions. it will then
         * store the questions in a new array dedicated for only medium leveled questions. 
         */

        for(int i =0; i<arr.size();i++)
        {
            if(arr.get(i).getDifficulty() <5 )
            {
                quest.remove(i);
                i--;
            } 
            else if (arr.get(i).getDifficulty()>7)
            {
                quest.remove(i);
                i--;
            }

        }
    }

    public static void getHard(ArrayList<Questions> arr)
    {
        /*
         * sorts through the array list to find medium leveled questions. it will then
         * store the questions in a new array dedicated for only hard leveled questions. 
         */

        for(int i =0; i<arr.size();i++)
        {
            if((arr.get(i).getDifficulty() <7))
            {

                quest.remove(i);
                i--;
            }
        }
    }

    public  void exit()
    {
        /*
         * exits the quiz
         */
        setVisible(false);
        System.exit(0);
    }

    private void backToMain()
    {
        // this method is used to go back to the main menu.
        remove(finalPanel);
        reset();
        switchThis();
    }

    private void reset()
    {
        // resets all arraylists and varibles to play again. 
        score=0;
        QuestionNum=0;
        QuestionNum2=0;
        quest = new ArrayList<Questions>();
        searchArr=new ArrayList<Questions>();

        theFinal=new ArrayList<Questions>();
         theFinal2=new ArrayList<Questions>();
        answer =new ArrayList<String>();
        accend= false;
        decend = false;

    }

    private void answers()
    /*
     * Stores the quiz answerkey in an ArrayList.
     */
    {
        for(int i =0; i<theFinal2.size();i++)
        {
            answer.add(theFinal2.get(i).getAnswer()+"");
        }
    }

    private void ChooseFile()
    {
        /* 
         * Calls the file chooser so the user can pick and choose files from thire computer.
         */
        String X;
        try
        {
            X =  FileChooser.getFile();
            if(X!=null)
            {   
                File2.process(X);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void checkAnswers()
    /*
     * This method is used to record the users score based on thire performance. It does this by comparing the user's answer to the answer key.
     */
    {
        if(QuestionNum<theFinal2.size())
        {

            if(buttonA.isSelected())
            {
                if(answer.get(QuestionNum).toUpperCase().equalsIgnoreCase("A"))
                {
                    score++;
                }
            }
            else if(buttonB.isSelected())
            {
                if(answer.get(QuestionNum).toUpperCase().equalsIgnoreCase("B"))
                {
                    score++;
                }
            }
            else if(buttonC.isSelected())
            {
                if(answer.get(QuestionNum).toUpperCase().equalsIgnoreCase("C"))
                {
                    score++;
                }
            }
            else if(buttonD.isSelected())
            {
                if(answer.get(QuestionNum).toUpperCase().equalsIgnoreCase("D"))
                {
                    score++;
                }
            }
            else if(buttonE.isSelected())
            {
                if(answer.get(QuestionNum).toUpperCase().equalsIgnoreCase("E"))
                {
                    score++;
                }
            }

            QuestionNum++;
        }

        if(QuestionNum<theFinal2.size()&& QuestionNum!=theFinal2.size())
        {
            quizQuestions.setText(theFinal2.get(QuestionNum).getQuestion());

            buttonA.setText(theFinal2.get(QuestionNum).getOptionA());
            buttonB.setText(theFinal2.get(QuestionNum).getOptionB());
            buttonC.setText(theFinal2.get(QuestionNum).getOptionC());
            buttonD.setText(theFinal2.get(QuestionNum).getOptionD());
            buttonE.setText(theFinal2.get(QuestionNum).getOptionE());
        }	

        if((QuestionNum>=theFinal2.size()))
        {
            finalPanel();  
        }
    }

    private void write() throws Exception
    /*
     * This method is user to write the questions and answers to the quiz in a separate text file.
     */
    {
        // creats a PrintWriter to write into a txt file. 
        try{
            PrintWriter writer = new PrintWriter("UnitQuiz.txt", "UTF-8");

            for(int i=0; i<theFinal2.size(); i++)
            {
                writer.println(theFinal2.get(i).getQuestion());
                writer.println(theFinal2.get(i).getOptionA());
                writer.println(theFinal2.get(i).getOptionB());
                writer.println(theFinal2.get(i).getOptionC());
                writer.println(theFinal2.get(i).getOptionD());
                writer.println(theFinal2.get(i).getOptionE());
            }
            writer.close(); 
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

        try{
            PrintWriter writer2 = new PrintWriter("UnitQuizAnswers.txt", "UTF-8");
            for(int i=0; i<theFinal2.size(); i++)
            {
                writer2.println(theFinal2.get(i).getAnswer());
            }
            writer2.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}

