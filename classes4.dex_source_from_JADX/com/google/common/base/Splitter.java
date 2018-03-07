package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.AbstractIterator.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckReturnValue;

@GwtCompatible
/* compiled from: wtf */
public final class Splitter {
    public final int limit;
    public final boolean omitEmptyStrings;
    public final Strategy strategy;
    public final CharMatcher trimmer;

    /* compiled from: wtf */
    final class C00041 implements Strategy {
        final /* synthetic */ CharMatcher val$separatorMatcher;

        C00041(CharMatcher charMatcher) {
            this.val$separatorMatcher = charMatcher;
        }

        public final /* bridge */ /* synthetic */ Iterator iterator(Splitter splitter, CharSequence charSequence) {
            return new SplittingIterator(splitter, charSequence) {
                int separatorStart(int i) {
                    return C00041.this.val$separatorMatcher.indexIn(this.toSplit, i);
                }

                int separatorEnd(int i) {
                    return i + 1;
                }
            };
        }
    }

    /* compiled from: wtf */
    interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }

    /* compiled from: wtf */
    public abstract class SplittingIterator extends AbstractIterator<String> {
        public int limit;
        public int offset = 0;
        public final boolean omitEmptyStrings;
        public final CharSequence toSplit;
        public final CharMatcher trimmer;

        public abstract int separatorEnd(int i);

        public abstract int separatorStart(int i);

        protected /* bridge */ /* synthetic */ Object computeNext() {
            String charSequence;
            int i = this.offset;
            while (this.offset != -1) {
                int separatorStart = separatorStart(this.offset);
                if (separatorStart == -1) {
                    separatorStart = this.toSplit.length();
                    this.offset = -1;
                } else {
                    this.offset = separatorEnd(separatorStart);
                }
                if (this.offset == i) {
                    this.offset++;
                    if (this.offset >= this.toSplit.length()) {
                        this.offset = -1;
                    }
                } else {
                    int i2 = i;
                    while (i2 < separatorStart && this.trimmer.matches(this.toSplit.charAt(i2))) {
                        i2++;
                    }
                    i = separatorStart;
                    while (i > i2 && this.trimmer.matches(this.toSplit.charAt(i - 1))) {
                        i--;
                    }
                    if (this.omitEmptyStrings && i2 == i) {
                        i = this.offset;
                    } else {
                        if (this.limit == 1) {
                            i = this.toSplit.length();
                            this.offset = -1;
                            while (i > i2 && this.trimmer.matches(this.toSplit.charAt(i - 1))) {
                                i--;
                            }
                        } else {
                            this.limit--;
                        }
                        charSequence = this.toSplit.subSequence(i2, i).toString();
                        return charSequence;
                    }
                }
            }
            this.state = State.DONE;
            charSequence = (String) null;
            return charSequence;
        }

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = charSequence;
        }
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.NONE, Integer.MAX_VALUE);
    }

    public Splitter(Strategy strategy, boolean z, CharMatcher charMatcher, int i) {
        this.strategy = strategy;
        this.omitEmptyStrings = z;
        this.trimmer = charMatcher;
        this.limit = i;
    }

    @CheckReturnValue
    public static Splitter on(char c) {
        return on(CharMatcher.is(c));
    }

    @CheckReturnValue
    public static Splitter on(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new C00041(charMatcher));
    }

    @CheckReturnValue
    public static Splitter on(String str) {
        boolean z;
        if (str.length() != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new 2(str));
    }

    @CheckReturnValue
    public final Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    @CheckReturnValue
    public final Splitter limit(int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "must be greater than zero: %s", new Object[]{Integer.valueOf(i)});
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i);
    }

    @CheckReturnValue
    public final Splitter trimResults() {
        CharMatcher charMatcher = CharMatcher.WHITESPACE;
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    @CheckReturnValue
    public final Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return Splitter.splittingIterator(Splitter.this, charSequence);
            }

            public String toString() {
                return Joiner.on(", ").appendTo(new StringBuilder("["), this).append(']').toString();
            }
        };
    }

    public static Iterator splittingIterator(Splitter splitter, CharSequence charSequence) {
        return splitter.strategy.iterator(splitter, charSequence);
    }

    @CheckReturnValue
    @Beta
    public final List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator splittingIterator = splittingIterator(this, charSequence);
        List arrayList = new ArrayList();
        while (splittingIterator.hasNext()) {
            arrayList.add(splittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
