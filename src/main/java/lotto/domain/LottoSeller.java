package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoSeller {

    public static final int LOTTO_PRICE = 1000;

    private final NumberGenerator numberGenerator;


    public LottoSeller() {
        this(new RandomNumberGenerator());
    }

    public LottoSeller(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }



    public List<Lotto> purchaseLotto(int purchaseAmount) {
        if(purchaseAmount <= 0 )
            throw new IllegalArgumentException("[ERROR] 구매금액은 양수여야 합니다. value=%s".
                    formatted(purchaseAmount));

        if(purchaseAmount % LOTTO_PRICE != 0 )
            throw new IllegalArgumentException("[ERROR] 구매금액은 로또 가격단위로 나누어 떨어져야 합니다. 구매금액=%d".
                    formatted(purchaseAmount));

        int count = purchaseAmount / LOTTO_PRICE;

        return publish(count);
    }


    private List<Lotto> publish(int count) {
        if(count <= 0)
            throw new IllegalArgumentException("[ERROR] 발행 횟수는 0보다 커야 합니다.");

        return IntStream.range(0, count).mapToObj(i -> numberGenerator.generate()).
                map(Lotto::new).toList();
    }
}
