package lotto.domain;

import java.util.Map;

public enum LottoPrize {
    FIRST_PRIZE(6, false,2000000000),
    SECOND_PRIZE(5, true,30000000),
    THIRD_PRIZE(5, false, 1500000),
    FOURTH_PRIZE(4, false, 50000),
    FIFTH_PRIZE(3,false,5000),
    NONE(0,false,0);



    private final int sameNumberCount;

    private final boolean needBonus;

    private final int amount;


    LottoPrize(int sameNumberCount, boolean needBonus, int amount) {
        this.sameNumberCount = sameNumberCount;
        this.needBonus = needBonus;
        this.amount = amount;
    }


    public static final LottoPrize[] prizes() {
        return new LottoPrize[]{FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE, FOURTH_PRIZE, FIFTH_PRIZE};
    }

    public static final LottoPrize[] reversePrizes() {
        return new LottoPrize[]{FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE};
    }


    public static LottoPrize getPrize(int sameNumberCount, boolean bonusMatched) {
        if(sameNumberCount < 0)
            throw new IllegalArgumentException("[ERROR] 번호 일치 개수는 음수가 될 수 없습니다. value=%d".formatted(sameNumberCount));

        if(sameNumberCount == SECOND_PRIZE.getSameNumberCount() && bonusMatched == SECOND_PRIZE.isNeedBonus())
            return SECOND_PRIZE;

        LottoPrize prize = base.get(sameNumberCount);

        if(prize != null)
            return prize;

        return LottoPrize.NONE;
    }


    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public boolean isNeedBonus() {
        return needBonus;
    }

    public int getAmount() {
        return amount;
    }

    // SECOND_PRIZE 제외
    private static final Map<Integer, LottoPrize> base = Map.of(
            LottoPrize.FIRST_PRIZE.sameNumberCount, LottoPrize.FIRST_PRIZE,
            LottoPrize.THIRD_PRIZE.sameNumberCount, LottoPrize.THIRD_PRIZE,
            LottoPrize.FOURTH_PRIZE.sameNumberCount, LottoPrize.FOURTH_PRIZE,
            LottoPrize.FIFTH_PRIZE.sameNumberCount, LottoPrize.FIFTH_PRIZE
    );

}
