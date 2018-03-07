package com.facebook.resources.impl.model;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.user.gender.Gender;
import javax.annotation.Nullable;

/* compiled from: th_TH */
public class StringsCollection {
    public static final StringsCollection f3083a = new C01941(null, null);
    private final SparseArray<StringEntry> f3084b;
    private final byte[] f3085c;

    /* compiled from: th_TH */
    public class StringEntry {
        public final int f3077a;
        public final SparseIntArray f3078b;

        public StringEntry(int i, SparseIntArray sparseIntArray) {
            this.f3077a = i;
            this.f3078b = sparseIntArray;
        }
    }

    /* compiled from: th_TH */
    final class C01941 extends StringsCollection {
        C01941(SparseArray sparseArray, byte[] bArr) {
            super(sparseArray, bArr);
        }

        public final String mo696a(int i, Gender gender) {
            return null;
        }
    }

    public StringsCollection(SparseArray<StringEntry> sparseArray, byte[] bArr) {
        this.f3084b = sparseArray;
        this.f3085c = bArr;
    }

    @Nullable
    public String mo696a(int i, Gender gender) {
        StringEntry stringEntry = (StringEntry) this.f3084b.get(i);
        if (stringEntry == null) {
            return null;
        }
        Object obj;
        if (stringEntry.f3078b.indexOfKey(gender.ordinal()) < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            gender = Gender.UNKNOWN;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < gender.ordinal()) {
            i3 += stringEntry.f3078b.get(i2);
            i2++;
        }
        return StringResourcesUtil.m5072a(this.f3085c, i3 + stringEntry.f3077a, stringEntry.f3078b.get(gender.ordinal()));
    }
}
