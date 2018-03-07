package com.facebook.search.util.keyword;

import com.google.common.base.Objects;

/* compiled from: megaphone_icon */
public class HighlightRange {
    public final int f8954a;
    public final int f8955b;

    public HighlightRange(int i, int i2) {
        this.f8954a = i;
        this.f8955b = i2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HighlightRange)) {
            return false;
        }
        HighlightRange highlightRange = (HighlightRange) obj;
        if (this.f8954a == highlightRange.f8954a && this.f8955b == highlightRange.f8955b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f8954a), Integer.valueOf(this.f8955b)});
    }
}
