package com.google.common.base;

import com.google.common.base.Splitter.SplittingIterator;
import com.google.common.base.Splitter.Strategy;
import java.util.Iterator;

/* compiled from: can't use .skipNulls() with maps */
final class Splitter$2 implements Strategy {
    final /* synthetic */ String val$separator;

    Splitter$2(String str) {
        this.val$separator = str;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator(Splitter splitter, CharSequence charSequence) {
        return new SplittingIterator(splitter, charSequence) {
            public int separatorStart(int i) {
                int length = Splitter$2.this.val$separator.length();
                int length2 = this.toSplit.length() - length;
                int i2 = i;
                while (i2 <= length2) {
                    int i3 = 0;
                    while (i3 < length) {
                        if (this.toSplit.charAt(i3 + i2) == Splitter$2.this.val$separator.charAt(i3)) {
                            i3++;
                        } else {
                            i2++;
                        }
                    }
                    return i2;
                }
                return -1;
            }

            public int separatorEnd(int i) {
                return Splitter$2.this.val$separator.length() + i;
            }
        };
    }
}
