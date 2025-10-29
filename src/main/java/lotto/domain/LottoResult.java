package lotto.domain;

import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<LottoPrize, Integer> winningResult;

    private final long totalPrizeAmount;

    private final double profitRate;

    private final int purchasedCount;

    private final int lottoPrice;



    public LottoResult(EnumMap<LottoPrize, Integer> input, int purchasedCount, int lottoPrice) {
        validateWinningResult(input);
        validatePurchaseCount(purchasedCount);
        validateLottoPrice(lottoPrice);

        this.winningResult = buildWinningResult(input);
        this.lottoPrice = lottoPrice;
        this.purchasedCount = purchasedCount;
        this.totalPrizeAmount = calculateTotalPrizeAmount();
        this.profitRate = calculateProfitRatio();
    }

    public int getPrizeCount(LottoPrize prize) {
        return winningResult.getOrDefault(prize, 0);
    }


    public long getTotalPrizeAmount() {
        return totalPrizeAmount;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public int getPurchasedCount() {
        return purchasedCount;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }



    private long calculateTotalPrizeAmount() {
        int totalAmount = 0;

        for (var lottoPrizeEntry : winningResult.entrySet()) {
            LottoPrize prize = lottoPrizeEntry.getKey();
            int count = lottoPrizeEntry.getValue();

            totalAmount += prize.getAmount() * count;
        }

        return totalAmount;
    }


    private double calculateProfitRatio() {
        long purchaseAmount = (long) lottoPrice * purchasedCount;


        double value = ((double) totalPrizeAmount)/ purchaseAmount;

        return value * 100;
    }




    private EnumMap<LottoPrize, Integer> buildWinningResult(EnumMap<LottoPrize, Integer> input) {
        EnumMap<LottoPrize, Integer> winingResult = new EnumMap<>(LottoPrize.class);

        for (LottoPrize prize : LottoPrize.values()) {
            winingResult.put(prize, input.getOrDefault(prize, 0));
        }

        return winingResult;
    }

    private void validateWinningResult(EnumMap<LottoPrize, Integer> winningResult) {
        if(winningResult == null)
            throw new IllegalArgumentException("[ERROR] winningResult가 null입니다.");

        for (LottoPrize prize : winningResult.keySet()) {
            Integer count = winningResult.get(prize);

            if(count == null)
                throw new IllegalArgumentException("[ERROR] %s 당첨횟수가 null입니다.".
                        formatted(prize));

            if(count < 0)
                throw new IllegalArgumentException("[ERROR] 당첨횟수가 음수입니다. value=%d".
                        formatted(count));
        }
    }

    private void validatePurchaseCount(int purchasedCount) {
        if (purchasedCount <= 0 )
            throw new IllegalArgumentException("[ERROR] 구매 횟수는 0보다 커야 합니다. value=%d".
                    formatted(purchasedCount));
    }

    private void validateLottoPrice(int lottoPrice) {
        if(lottoPrice <= 0)
            throw new IllegalArgumentException("[ERROR] 로또 가격은 0보다 커야 합니다. value=%s".
                    formatted(lottoPrice));
    }
}
