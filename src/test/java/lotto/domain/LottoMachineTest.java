package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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




    @Test
    @DisplayName("FIRST_PRIZE test")
    public void test() {
        LottoPrize prize = lottoMachine.check(FIRST_PRIZE);

        Assertions.assertThat(prize).isEqualTo(LottoPrize.FIRST_PRIZE);
    }

    @Test
    @DisplayName("SECOND_PRIZE test")
    public void test2() {
        LottoPrize prize = lottoMachine.check(SECOND_PRIZE);
        Assertions.assertThat(prize).isEqualTo(LottoPrize.SECOND_PRIZE);
    }

    @Test
    @DisplayName("THIRD_PRIZE test")
    public void test3() {
        LottoPrize prize = lottoMachine.check(THIRD_PRIZE);
        Assertions.assertThat(prize).isEqualTo(LottoPrize.THIRD_PRIZE);
    }

    @Test
    @DisplayName("FOURTH_PRIZE")
    public void test4() {
        LottoPrize prize = lottoMachine.check(FOURTH_PRIZE);
        Assertions.assertThat(prize).isEqualTo(LottoPrize.FOURTH_PRIZE);
    }

    @Test
    @DisplayName("FIFTH_PRIZE")
    public void test5() {
        LottoPrize prize = lottoMachine.check(FIFTH_PRIZE);
        Assertions.assertThat(prize).isEqualTo(LottoPrize.FIFTH_PRIZE);
    }

    @Test
    @DisplayName("NONE_PRIZE")
    public void test6() {
        LottoPrize prize = lottoMachine.check(NONE_PRIZE);
        Assertions.assertThat(prize).isEqualTo(LottoPrize.NONE);
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









}