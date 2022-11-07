package baseball;

import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }
    public static void startGame() {
        List<Integer> computer = Util.makeRandomNumbers();
        String input;

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();

            List<Integer> inputNumbers = Util.toIntegerArray(input);
            String comment = takeTurn(computer, inputNumbers);
            System.out.println(comment);
            if (isEnd(comment)) {
                break;
            }
        }
    }

    private static boolean isEnd(String comment) {
        return comment.contains("게임 종료");
    }

    private static void askContinueOrEnd(String comment) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        answerContinueOrEnd(input);
    }

    private static void answerContinueOrEnd(String input) {

    }

    private static String takeTurn(List<Integer> computer, List<Integer> inputNumbers) {
        String comment = "";
        comment += countBall(computer, inputNumbers);
        comment += countStrike(computer, inputNumbers);
        return checkComment(comment);
    }

    private static String checkComment(String comment) {
        if (comment.isEmpty()) {
            comment = "낫싱";
        }
        if (comment.contains("3스트라이크")) {
            comment += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return comment;
    }

    private static String countStrike(List<Integer> computer, List<Integer> inputNumbers) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(inputNumbers.get(i))) {
                strikes++;
            }
        }
        return setStrikeComment(strikes);
    }

    private static String setStrikeComment(int strikes) {
        String strikeComment = String.format("%d스트라이크", strikes);
        if (strikes == 0) {
            strikeComment = "";
        }
        return strikeComment;
    }

    private static String countBall(List<Integer> computer, List<Integer> inputNumbers) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            Integer inputNumber = inputNumbers.get(i);
            if (!computer.get(i).equals(inputNumber) && computer.contains(inputNumber)) {
                balls++;
            }
        }
        return setBallComment(balls);
    }

    private static String setBallComment(int balls) {
        String ballComment = String.format("%d볼 ", balls);
        if (balls == 0) {
            ballComment = "";
        }
        return ballComment;
    }
}
