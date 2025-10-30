package lotto.domain;


import java.util.EnumMap;
import java.util.List;


public class LottoMachine {

    private final Lotto winningLotto;

    private final int bonusNumber;


    public LottoMachine(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoMachine(List<Integer> lottoNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(lottoNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }



    public LottoPrize check(Lotto purchasedLotto) {
        if(purchasedLotto == null)
            throw new IllegalArgumentException("[ERROR] purchasedLotto가 null입니다.");

        int sameNumberCount = winningLotto.getSameNumberCount(purchasedLotto);
        boolean bonusMatched = purchasedLotto.hasNumber(bonusNumber);

        return LottoPrize.getPrize(sameNumberCount, bonusMatched);
    }


    public LottoResult check(List<Lotto> purchasedLottos) {
        if(purchasedLottos == null)
            throw new IllegalArgumentException("[ERROR] purchasedLottos가 null입니다.");

        EnumMap<LottoPrize, Integer> winningResult = new EnumMap<>(LottoPrize.class);

        for(Lotto purchasedLotto : purchasedLottos) {
            LottoPrize prize = check(purchasedLotto);

            winningResult.put(prize, winningResult.getOrDefault(prize, 0) + 1);
        }
        return new LottoResult(winningResult, purchasedLottos.size(), LottoSeller.LOTTO_PRICE);
    }


    private void validateBonusNumber(int bonusNumber) {
        if(bonusNumber > Lotto.MAX_NUMBER || bonusNumber < Lotto.MIN_NUMBER)
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 범위를 벗어났습니다. bonusNumber=%d".formatted(bonusNumber));

        if(winningLotto.hasNumber(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 로또 번호와 중복됩니다. %s, bonusNumber=%d".formatted(winningLotto, bonusNumber));
    }

}
