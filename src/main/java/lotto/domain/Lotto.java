package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    public static final int MIN_NUMBER = 1;

    public static final int MAX_NUMBER = 45;


    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        if(numbers == null)
            throw new IllegalArgumentException("[ERROR] numbers가 null입니다.");

        validateNumberSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = getSortedList(numbers);
    }


    public int getSameNumberCount(Lotto lotto) {
        int count = 0;

        for(int num : numbers) {
            if(lotto.hasNumber(num))
                count++;
        }
        return count;
    }


    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }


    private List<Integer> getSortedList(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);

        Collections.sort(sorted);
        return sorted;
    }


    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다. required=%d, current=%d".
                    formatted(LOTTO_SIZE, numbers.size()));
    }


    private void validateNumberRange(List<Integer> numbers) {
        for (int num : numbers) {
            if(num < MIN_NUMBER || num > MAX_NUMBER)
                throw new IllegalArgumentException("[ERROR] 번호가 로또 번호 범위를 벗어났습니다. value=%d".
                        formatted(num));
        }
    }


    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> seen = new HashSet<>(numbers);

        if(seen.size() != numbers.size())
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다. numbers=%s".
                    formatted(numbers));
    }



    @Override
    public String toString() {
        return numbers.toString();
    }
}
