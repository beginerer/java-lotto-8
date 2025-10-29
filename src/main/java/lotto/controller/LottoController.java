package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoSeller;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private LottoSeller lottoSeller;

    public LottoController() {
        this.lottoSeller = new LottoSeller();
    }

    public void run() {


        //구매 금액 입력
        List<Lotto> purchasedLottos = purchaseLottos();

        // 당첨 번호 입력
        List<Integer> winningNumbers = inputWinningNumbers();

        // 보너스 번호 입력
        int bonusNumber = inputBonusNumber();

        LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoMachine.check(purchasedLottos);

        // 결과 출력
        OutputView.printWinningResult(lottoResult);

    }

    private List<Lotto> purchaseLottos() {
        while(true) {
            try {
                //구매 금액 입력
                int purchaseAmount = InputView.readPurchaseAmount();
                List<Lotto> purchasedLottos = lottoSeller.purchaseLotto(purchaseAmount);
                OutputView.printPurchasedLottos(purchasedLottos);
                return purchasedLottos;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = InputView.readLottoNumbers();
                return winningNumbers;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private int inputBonusNumber() {
        while(true) {
            try {
                int bonusNumber = InputView.readBonusNumber();
                return bonusNumber;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
