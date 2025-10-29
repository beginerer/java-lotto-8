package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {

        System.out.printf("%d개를 구매했습니다.\n".formatted(purchasedLottos.size()));

        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto);
        }
    }

    public static void printWinningResult(LottoResult lottoResult) {

        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoPrize prize : LottoPrize.reversePrizes()) {
            int sameCount = prize.getSameNumberCount();
            int amount = prize.getAmount();


            String moneyFormated = String.format("%,d원", amount);

            String format = resolvePrizeOutput(prize, sameCount, moneyFormated, lottoResult.getPrizeCount(prize));

            System.out.println(format);
        }

        System.out.printf("총 수익률은 %.2f%%입니다.", lottoResult.getProfitRate());
    }

    private static String resolvePrizeOutput(LottoPrize prize, int sameCount, String moneyFormated, int prizeCount) {
        if(prize == LottoPrize.SECOND_PRIZE) {
            return String.format("%d개 일치, 보너스 볼 일치 %s - %d개",sameCount, moneyFormated, prizeCount);
        }
        return String.format("%d개 일치, %s - %d개",sameCount, moneyFormated, prizeCount);
    }
}
