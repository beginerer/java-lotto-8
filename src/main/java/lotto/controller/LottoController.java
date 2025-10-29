package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoSeller;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void run() {

        LottoSeller lottoSeller = new LottoSeller();

        //구매 금액 입력
        int purchaseAmount = InputView.readPurchaseAmount();
        List<Lotto> purchasedLottos = lottoSeller.purchaseLotto(purchaseAmount);
        OutputView.printPurchasedLottos(purchasedLottos);


        // 당첨 번호 입력
        List<Integer> winningNumbers = InputView.readLottoNumbers();

        // 보너스 번호 입력
        int bonusNumber = InputView.readBonusNumber();

        LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoMachine.check(purchasedLottos);

        // 결과 출력
        OutputView.printWinningResult(lottoResult);
    }
}
