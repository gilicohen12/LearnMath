package cs3500.learnmath;

import java.util.ArrayList;
import java.util.Random;

/**
 * represents a problem set
 */
public class ProblemSet {
  private ArrayList<MathProblem> problemSet = new ArrayList<>();

  /**
   * Generate a set of math problems
   *
   * @param countToGenerate the number of problems to generate
   */
  public void generateProblems(int countToGenerate) {
    Random random = new Random();
    for (int i = 0; i < countToGenerate; i++) {

      int randomNumber = random.nextInt(2); // Generates either 0 or 1

      problemSet.add(selectProblemType(randomNumber));
    }
  }

  /**
   * generates a random problem based on number passed in
   *
   * @param num passes in value 0 = addition 1 = subtraction
   * @return an operation
   */
  public MathProblem selectProblemType(int num) {
    Random random = new Random();
    int first = random.nextInt(9) + 1;
    int second = random.nextInt(9) + 1;
    MathProblem operation;

    if (num == 0) {
      operation = new AdditionMathProblem(first, second);
    } else {
      int subFrom = Math.max(first, second);
      int subThis = Math.min(first, second);
      operation = new SubtractionMathProblem(subFrom, subThis);
    }
    return operation;
  }

}
