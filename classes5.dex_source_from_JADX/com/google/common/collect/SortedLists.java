package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
/* compiled from: bug_reporting/ */
public final class SortedLists {

    /* compiled from: bug_reporting/ */
    public enum KeyAbsentBehavior {
        NEXT_LOWER {
            final int resultIndex(int i) {
                return i - 1;
            }
        },
        NEXT_HIGHER {
            public final int resultIndex(int i) {
                return i;
            }
        },
        INVERTED_INSERTION_INDEX {
            public final int resultIndex(int i) {
                return i ^ -1;
            }
        };

        abstract int resultIndex(int i);
    }

    /* compiled from: bug_reporting/ */
    public enum KeyPresentBehavior {
        ANY_PRESENT {
            final <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return i;
            }
        },
        LAST_PRESENT {
            final <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                int size = list.size() - 1;
                while (i < size) {
                    int i2 = ((i + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i2), e) > 0) {
                        size = i2 - 1;
                    } else {
                        i = i2;
                    }
                }
                return i;
            }
        },
        FIRST_PRESENT {
            final <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                int i2 = 0;
                while (i2 < i) {
                    int i3 = (i2 + i) >>> 1;
                    if (comparator.compare(list.get(i3), e) < 0) {
                        i2 = i3 + 1;
                    } else {
                        i = i3;
                    }
                }
                return i2;
            }
        },
        FIRST_AFTER {
            public final <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e, list, i) + 1;
            }
        },
        LAST_BEFORE {
            public final <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e, list, i) - 1;
            }
        };

        abstract <E> int resultIndex(Comparator<? super E> comparator, E e, List<? extends E> list, int i);
    }

    private SortedLists() {
    }

    public static <E, K> int m13659a(List<E> list, Function<? super E, K> function, @Nullable K k, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return m13660a(Lists.a(list, function), k, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int m13660a(List<? extends E> list, @Nullable E e, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(keyPresentBehavior);
        Preconditions.checkNotNull(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.a(list);
        }
        int i = 0;
        int size = list.size() - 1;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int compare = comparator.compare(e, list.get(i2));
            if (compare < 0) {
                size = i2 - 1;
            } else if (compare <= 0) {
                return keyPresentBehavior.resultIndex(comparator, e, list.subList(i, size + 1), i2 - i) + i;
            } else {
                i = i2 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i);
    }
}
