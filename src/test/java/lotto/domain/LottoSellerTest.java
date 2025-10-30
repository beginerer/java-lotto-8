package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoSellerTest {



    @Test
    @DisplayName("구매 금액이 음수라면 예외가 발생한다.")
    public void test() {
        LottoSeller lottoSeller = new LottoSeller();

        Assertions.assertThatThrownBy(() ->lottoSeller.purchaseLotto(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매금액은 양수여야 합니다. ");
    }

    @Test
    @DisplayName("구매 금액이 로또 금액단위로 나누어 떨어지지 않는다면 예외가 발생한다.")
    public void test2() {
        LottoSeller lottoSeller = new LottoSeller();
        Assertions.assertThatThrownBy(() -> lottoSeller.purchaseLotto(12334))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매금액은 로또 가격단위로 나누어 떨어져야 합니다.");
    }

    @Test
    @DisplayName("구매금액이 0이라면 예외가 발생한다.")
    public void test3() {
        LottoSeller lottoSeller = new LottoSeller();
        Assertions.assertThatThrownBy(() -> lottoSeller.purchaseLotto(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매금액은 양수여야 합니다.");
    }


}