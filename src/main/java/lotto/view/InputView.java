package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";


    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");

        String input = Console.readLine();

        if(input == null)
            throw new IllegalArgumentException("[ERROR] 입력이 null 입니다.");

        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요. input=%s".formatted(input));
        }
    }


    public static List<Integer> readLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");

        String input = Console.readLine();

        if(input == null)
            throw new IllegalArgumentException("[ERROR] 입력이 null 입니다.");

        try {
            return Arrays.stream(input.split(DELIMITER)).map(Integer::parseInt).toList();
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요. input=%s".formatted(input));
        }
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String input = Console.readLine();

        if(input == null)
            throw new IllegalArgumentException("[ERROR] 입력이 null 입니다.");

        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요. input=%s".formatted(input));
        }
    }



}
