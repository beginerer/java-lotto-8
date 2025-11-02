package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottoMachineTest {

    private final List<Integer> winingNumbers = List.of(1,2,3,4,5,6);

    private final int bonusNumber = 7;

    private final LottoMachine lottoMachine = new LottoMachine(winingNumbers, bonusNumber);

    private final Lotto FIRST_PRIZE = new Lotto(List.of(1,2,3,4,5,6));
    private final Lotto SECOND_PRIZE = new Lotto(List.of(1,2,3,4,5,7));
    private final Lotto THIRD_PRIZE = new Lotto(List.of(1,2,3,4,5,9));
    private final Lotto FOURTH_PRIZE = new Lotto(List.of(1,2,3,4,7,8));
    private final Lotto FIFTH_PRIZE = new Lotto(List.of(1,2,3,7,8,9));
    private final Lotto NONE_PRIZE = new Lotto(List.of(1,2,7,8,9,10));

    private final List<Lotto> lottos = List.of(
            FIRST_PRIZE,SECOND_PRIZE,THIRD_PRIZE,FOURTH_PRIZE,FIFTH_PRIZE,NONE_PRIZE
    );




    @Test
    @DisplayName("FIRST_PRIZE test")
    public void test() {

        LottoPrize prize = lottoMachine.check(FIRST_PRIZE);
        LottoResult result = lottoMachine.check(List.of(FIRST_PRIZE));

        int purchaseAmount = LottoSeller.LOTTO_PRICE;
        long expectPrizeAmount = LottoPrize.FIRST_PRIZE.getAmount();
        double profitRatio = ((double) expectPrizeAmount / purchaseAmount) * 100;

        // Prize
        Assertions.assertThat(prize).isEqualTo(LottoPrize.FIRST_PRIZE);

        // LottoResult
        Assertions.assertThat(result.getPurchaseAmount()).isEqualTo(purchaseAmount);
        Assertions.assertThat(result.getPurchasedCount()).isEqualTo(1);
        Assertions.assertThat(result.getTotalPrizeAmount()).isEqualTo(LottoPrize.FIRST_PRIZE.getAmount());
        Assertions.assertThat(result.getProfitRate()).isEqualTo(profitRatio);

    }

    @Test
    @DisplayName("SECOND_PRIZE test")
    public void test2() {

        LottoPrize prize = lottoMachine.check(SECOND_PRIZE);
        LottoResult result = lottoMachine.check(List.of(SECOND_PRIZE));

        int purchaseAmount = LottoSeller.LOTTO_PRICE;
        long expectPrizeAmount = LottoPrize.SECOND_PRIZE.getAmount();
        double profitRatio = ((double) expectPrizeAmount / purchaseAmount) * 100;


        // Prize
        Assertions.assertThat(prize).isEqualTo(LottoPrize.SECOND_PRIZE);

        // LottoResult
        Assertions.assertThat(result.getPurchaseAmount()).isEqualTo(purchaseAmount);
        Assertions.assertThat(result.getPurchasedCount()).isEqualTo(1);
        Assertions.assertThat(result.getTotalPrizeAmount()).isEqualTo(LottoPrize.SECOND_PRIZE.getAmount());
        Assertions.assertThat(result.getProfitRate()).isEqualTo(profitRatio);
    }

    @Test
    @DisplayName("THIRD_PRIZE test")
    public void test3() {
        LottoPrize prize = lottoMachine.check(THIRD_PRIZE);
        LottoResult result = lottoMachine.check(List.of(THIRD_PRIZE));

        int purchaseAmount = LottoSeller.LOTTO_PRICE;
        long expectPrizeAmount = LottoPrize.THIRD_PRIZE.getAmount();
        double profitRatio = ((double) expectPrizeAmount / purchaseAmount) * 100;

        // Prize
        Assertions.assertThat(prize).isEqualTo(LottoPrize.THIRD_PRIZE);

        // LottoResult
        Assertions.assertThat(result.getPurchaseAmount()).isEqualTo(purchaseAmount);
        Assertions.assertThat(result.getPurchasedCount()).isEqualTo(1);
        Assertions.assertThat(result.getTotalPrizeAmount()).isEqualTo(LottoPrize.THIRD_PRIZE.getAmount());
        Assertions.assertThat(result.getProfitRate()).isEqualTo(profitRatio);
    }

    @Test
    @DisplayName("FOURTH_PRIZE")
    public void test4() {
        LottoPrize prize = lottoMachine.check(FOURTH_PRIZE);
        LottoResult result = lottoMachine.check(List.of(FOURTH_PRIZE));

        int purchaseAmount = LottoSeller.LOTTO_PRICE;
        long expectPrizeAmount = LottoPrize.FOURTH_PRIZE.getAmount();
        double profitRatio = ((double) expectPrizeAmount / purchaseAmount) * 100;


        // Prize
        Assertions.assertThat(prize).isEqualTo(LottoPrize.FOURTH_PRIZE);

        // LottoResult
        Assertions.assertThat(result.getPurchaseAmount()).isEqualTo(purchaseAmount);
        Assertions.assertThat(result.getPurchasedCount()).isEqualTo(1);
        Assertions.assertThat(result.getTotalPrizeAmount()).isEqualTo(LottoPrize.FOURTH_PRIZE.getAmount());
        Assertions.assertThat(result.getProfitRate()).isEqualTo(profitRatio);
    }

    @Test
    @DisplayName("FIFTH_PRIZE")
    public void test5() {
        LottoPrize prize = lottoMachine.check(FIFTH_PRIZE);
        LottoResult result = lottoMachine.check(List.of(FIFTH_PRIZE));

        int purchaseAmount = LottoSeller.LOTTO_PRICE;
        long expectPrizeAmount = LottoPrize.FIFTH_PRIZE.getAmount();
        double profitRatio = ((double) expectPrizeAmount / purchaseAmount) * 100;


        // Prize
        Assertions.assertThat(prize).isEqualTo(LottoPrize.FIFTH_PRIZE);

        // LottoResult
        Assertions.assertThat(result.getPurchaseAmount()).isEqualTo(purchaseAmount);
        Assertions.assertThat(result.getPurchasedCount()).isEqualTo(1);
        Assertions.assertThat(result.getTotalPrizeAmount()).isEqualTo(LottoPrize.FIFTH_PRIZE.getAmount());
        Assertions.assertThat(result.getProfitRate()).isEqualTo(profitRatio);
    }

    @Test
    @DisplayName("NONE_PRIZE")
    public void test6() {
        LottoPrize prize = lottoMachine.check(NONE_PRIZE);
        LottoResult result = lottoMachine.check(List.of(NONE_PRIZE));

        int purchaseAmount = LottoSeller.LOTTO_PRICE;
        long expectPrizeAmount = LottoPrize.NONE.getAmount();
        double profitRatio = ((double) expectPrizeAmount / purchaseAmount) * 100;


        // Prize
        Assertions.assertThat(prize).isEqualTo(LottoPrize.NONE);

        // LottoResult
        Assertions.assertThat(result.getPurchaseAmount()).isEqualTo(purchaseAmount);
        Assertions.assertThat(result.getPurchasedCount()).isEqualTo(1);
        Assertions.assertThat(result.getTotalPrizeAmount()).isEqualTo(LottoPrize.NONE.getAmount());
        Assertions.assertThat(result.getProfitRate()).isEqualTo(profitRatio);
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호 범위를 벗어나면 예외가 발생한다.")
    public void test7() {
        Assertions.assertThatThrownBy(() -> new LottoMachine(winingNumbers, 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호가 범위를 벗어났습니다. ");
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호가 중복된다면 예외가 발생한다.")
    public void test8() {
        Assertions.assertThatThrownBy(() -> new LottoMachine(winingNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호가 로또 번호와 중복됩니다.");
    }

    @Test
    @DisplayName("LottoResult test")
    public void test9() {
        LottoResult lottoResult = lottoMachine.check(lottos);


        Assertions.assertThat(lottoResult.getPrizeCount(LottoPrize.FIRST_PRIZE)).isEqualTo(1);
        Assertions.assertThat(lottoResult.getPrizeCount(LottoPrize.SECOND_PRIZE)).isEqualTo(1);
        Assertions.assertThat(lottoResult.getPrizeCount(LottoPrize.THIRD_PRIZE)).isEqualTo(1);
        Assertions.assertThat(lottoResult.getPrizeCount(LottoPrize.FOURTH_PRIZE)).isEqualTo(1);
        Assertions.assertThat(lottoResult.getPrizeCount(LottoPrize.FIFTH_PRIZE)).isEqualTo(1);
        Assertions.assertThat(lottoResult.getPrizeCount(LottoPrize.NONE)).isEqualTo(1);

        long totalPrize = Arrays.stream(LottoPrize.prizes()).mapToLong(LottoPrize::getAmount).sum();
        double profitRatio = (double) totalPrize / ( LottoSeller.LOTTO_PRICE * lottos.size()) * 100;

        Assertions.assertThat(lottoResult.getPurchasedCount()).isEqualTo(lottos.size());
        Assertions.assertThat(lottoResult.getPurchaseAmount()).isEqualTo(lottos.size() * LottoSeller.LOTTO_PRICE);

        Assertions.assertThat(lottoResult.getTotalPrizeAmount()).isEqualTo(totalPrize);
        Assertions.assertThat(lottoResult.getProfitRate()).isEqualTo(profitRatio);
    }









}