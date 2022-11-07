package baseball;

import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Integer> computer = Util.makeRandomNumbers();
        String input;
        System.out.println("숫자 야구 게임을 시작합니다.");

        outer:
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            List<Integer> inputNumbers = Util.toIntegerArray(input);
            String comment = takeTurn(computer, inputNumbers);
            break outer;
        }
    }

    private static String takeTurn(List<Integer> computer, List<Integer> inputNumbers) {
        String comment = "";
        comment += countBall(computer, inputNumbers);
        comment += countStrike(computer, inputNumbers);

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
        String strikeComment = String.format("%d스트라이크",strikes);
        if (strikes == 0) {
            strikeComment = "";
        }
        return strikeComment;
    }

    private static String countBall(List<Integer> computer, List<Integer> inputNumbers) {
        return " ";
    }
}
