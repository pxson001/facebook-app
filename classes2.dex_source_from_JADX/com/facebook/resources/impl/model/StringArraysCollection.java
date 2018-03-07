package com.facebook.resources.impl.model;

import android.util.SparseArray;
import com.facebook.user.gender.Gender;

/* compiled from: textlink_promote_instagram_friend_count_25 */
public class StringArraysCollection {
    public static final StringArraysCollection f3096a = new C01961(null, null);
    private final SparseArray<GenderedStringArrayEntry> f3097b;
    private final byte[] f3098c;

    /* compiled from: textlink_promote_instagram_friend_count_25 */
    public class StringArrayEntry {
        public final int f3093a;
        public final int[] f3094b;

        public StringArrayEntry(int i, int[] iArr) {
            this.f3093a = i;
            this.f3094b = iArr;
        }
    }

    /* compiled from: textlink_promote_instagram_friend_count_25 */
    public class GenderedStringArrayEntry {
        public final SparseArray<StringArrayEntry> f3095a;

        public GenderedStringArrayEntry(SparseArray<StringArrayEntry> sparseArray) {
            this.f3095a = sparseArray;
        }
    }

    /* compiled from: textlink_promote_instagram_friend_count_25 */
    final class C01961 extends StringArraysCollection {
        C01961(SparseArray sparseArray, byte[] bArr) {
            super(sparseArray, bArr);
        }

        public final String[] mo698a(int i, Gender gender) {
            return null;
        }
    }

    public StringArraysCollection(SparseArray<GenderedStringArrayEntry> sparseArray, byte[] bArr) {
        this.f3097b = sparseArray;
        this.f3098c = bArr;
    }

    public String[] mo698a(int i, Gender gender) {
        int i2 = 0;
        GenderedStringArrayEntry genderedStringArrayEntry = (GenderedStringArrayEntry) this.f3097b.get(i);
        if (genderedStringArrayEntry == null) {
            return null;
        }
        Object obj;
        if (genderedStringArrayEntry.f3095a.indexOfKey(gender.ordinal()) < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            gender = Gender.UNKNOWN;
        }
        StringArrayEntry stringArrayEntry = (StringArrayEntry) genderedStringArrayEntry.f3095a.get(gender.ordinal());
        String[] strArr = new String[stringArrayEntry.f3094b.length];
        int i3 = 0;
        while (i2 < stringArrayEntry.f3094b.length) {
            strArr[i2] = StringResourcesUtil.m5072a(this.f3098c, stringArrayEntry.f3093a + i3, stringArrayEntry.f3094b[i2]);
            i3 += stringArrayEntry.f3094b[i2];
            i2++;
        }
        return strArr;
    }
}
