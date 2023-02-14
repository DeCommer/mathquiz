package com.mathquiz;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.text.DecimalFormat; 

public class mathQuiz2 {
   static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
      Random random = new Random();
      /*
       *  work in progress
       *  issues to solve
       * 1. response when user enters a non-numberic character ✅
       * 2. fix division operation ✅
       * 3. fix division by 0 ✅
       * 4. add got out of ... score
       * 5. profit?
       * 
       */
      double num1;
      double num2;
      double answer;
      double percent = 0;
      int score = 0;
      int questionNum = 0;
      int loopNum = 10; //number of questions
      DecimalFormat df = new DecimalFormat("0.00");  
      String response = "";
      boolean tryAgain = true;

      System.out.println("*************************");
      System.out.println("******* Math Quiz *******");
      System.out.println("*************************");

      while(tryAgain) {
         for(questionNum = 1; questionNum <= loopNum; questionNum++){   
            try{
               num1 = (int)random.nextInt(10);
               num2 = (int)random.nextInt(10);
               String[] operator = {" + ", " - ", " * ", " ÷ "};
               String randOp = operator[(int) (Math.random() * operator.length)];
               System.out.print("\nQ." + questionNum + ": What is " + (int)num1 + randOp + (int)num2 +"? ");
               double userAns = input.nextDouble();               
               if(randOp.equals(" + ")) {
                  answer = (int) (num1 + num2);
                  if(userAns == answer) {
                     System.out.print(right(response, random));
                     score++;
                  } else {
                     System.out.print(wrong(response, random) + ", The correct answer is: " + (int)answer);
                  }  
                  }else if(randOp.equals(" - ")) {
                     answer = (int) (num1 - num2);
                     if(userAns == answer) {
                        System.out.print(right(response, random) );
                        score++;
                     } else {
                        System.out.print(wrong(response, random) + ", The correct answer is: " + (int)answer);
                     }  
                  }else if(randOp.equals(" * ")) {
                     answer =  (int) (num1 * num2);
                     if(userAns == answer) {
                        System.out.print(right(response, random));
                        score++;
                     } else {
                        System.out.print(wrong(response, random) + ", The correct answer is: " + (int)answer);
                     }  
                  }else if(randOp.equals(" ÷ ")) {
                     answer = div(num1, num2);
                     String ans2 = df.format(answer);
                     Double ans3 = Double.parseDouble(ans2);
                     if(userAns == ans3) {
                        System.out.print(right(response, random));
                        score++;
                     } else {
                        System.out.print(wrong(response, random) + ", The correct answer is: " + ans3);
                     }  
            }
            if(loopNum == questionNum) {
               tryAgain = false;
               quizEnd(percent, score, loopNum);
         }
            } catch(InputMismatchException e){
               System.out.print("Invalid");
               input.next();
               if(loopNum == questionNum) {
                  tryAgain = false;
                  quizEnd(percent, score, loopNum);
               }
            }
         }
      }   
   }
   public static String wrong(String response, Random random){
      switch(random.nextInt(4) + 1) {
         case 1: response = "Wrong"; break;
         case 2: response = "Incorrect"; break;
         case 3: response = "Nope, not right"; break;
         case 4: response = "Sorry, wrong"; break;
      }
      return response;
   }
   public static String right(String response, Random random) {
      switch(random.nextInt(4) + 1) {
         case 1: response = "Right!"; break;
         case 2: response = "Correct!"; break;
         case 3: response = "You got it right!"; break;
         case 4: response = "Yes!"; break;
      }
      return response;
   }
   public static Double div(double num1, double num2) {
      double divAnswer = num1 / num2;
      if(num2 == 0) {
         divAnswer = 0.0;
      }
      return divAnswer;
   }
   public static void quizEnd(double percent, int score, int loopNum) {
      System.out.println("\n*************************");
      System.out.println("You got " + score + " out of " + loopNum + " correct");
      System.out.print("Your score is: " );
      percent = (double)score / (double)loopNum*100;
      System.out.printf("%.0f", percent);
      System.out.print("% ");

      switch((int)percent) {
         case 100: System.out.println(", Great!"); break;
         case 90: System.out.println(", Pretty good"); break;
         case 80: System.out.println(", Not bad."); break;
         case 70: System.out.println(", Okay."); break;
         case 60: System.out.println(". Not good"); break;
         default: System.out.println(", You failed");
   }
}
}