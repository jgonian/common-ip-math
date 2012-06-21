package net.ripe.commons.ip;

public class StartAndSizeComparator<C extends Rangeable<C>, R extends AbstractRange<C, R>>
        implements RangeComparator<C, R> {

    private static StartAndSizeComparator<?, ?> instance;

    @SuppressWarnings({"unchecked"})
    public static <C extends Rangeable<C>, R extends AbstractRange<C, R>> RangeComparator<C, R> getInstance() {
        if (instance == null) {
            instance = new StartAndSizeComparator<C, R>();
        }
        return (StartAndSizeComparator<C, R>) instance;
    }

    private StartAndSizeComparator() {
    }

    @Override
    public int compare(AbstractRange<C, R> left, AbstractRange<C, R> right) {
        int result = left.start().compareTo(right.start());
        if (result == 0) {
            result = left.end().compareTo(right.end());
        }
        return result;
    }
}