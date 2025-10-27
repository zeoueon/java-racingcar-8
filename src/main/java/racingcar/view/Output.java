package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.dto.RoundResultDto;

public class Output {

    public static void printRoundResults(List<RoundResultDto> roundResultDtoList) {
        printBlankLine();
        System.out.println("실행 결과");

        for (RoundResultDto roundResultDto : roundResultDtoList) {
            printRoundResult(roundResultDto);
            printBlankLine();
        }
    }

    public static void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

    private static void printRoundResult(RoundResultDto roundResultDto) {
        Map<String, Integer> result = roundResultDto.getRoundResult();

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            printEntry(entry);
        }
    }

    private static void printEntry(Map.Entry<String, Integer> entry) {
        System.out.print(entry.getKey() + " : ");
        System.out.println("-".repeat(entry.getValue()));
    }

    private static void printBlankLine() {
        System.out.println();
    }
}
