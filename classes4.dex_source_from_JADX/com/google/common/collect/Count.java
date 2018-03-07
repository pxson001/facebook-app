package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: page_identity/ */
public final class Count implements Serializable {
    public int value;

    Count(int i) {
        this.value = i;
    }

    public final int m5934b(int i) {
        int i2 = this.value + i;
        this.value = i2;
        return i2;
    }

    public final int m5935d(int i) {
        int i2 = this.value;
        this.value = i;
        return i2;
    }

    public final int hashCode() {
        return this.value;
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj instanceof Count) && ((Count) obj).value == this.value;
    }

    public final String toString() {
        return Integer.toString(this.value);
    }
}
