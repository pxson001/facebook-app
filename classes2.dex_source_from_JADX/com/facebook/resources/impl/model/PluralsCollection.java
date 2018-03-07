package com.facebook.resources.impl.model;

import android.util.SparseArray;
import com.facebook.resources.impl.model.StringResources.Plural;
import com.facebook.user.gender.Gender;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: textlink_promote_instagram_friend_count_50 */
public class PluralsCollection {
    public static final PluralsCollection f3090a = new C01951(null, null);
    private final SparseArray<GenderedPluralEntry> f3091b;
    private final byte[] f3092c;

    /* compiled from: textlink_promote_instagram_friend_count_50 */
    public class PluralEntry {
        public final int f3086a;
        public final int[] f3087b;
        public final int[] f3088c;

        public PluralEntry(int i, int[] iArr, int[] iArr2) {
            this.f3086a = i;
            this.f3087b = iArr;
            this.f3088c = iArr2;
        }
    }

    /* compiled from: textlink_promote_instagram_friend_count_50 */
    public class GenderedPluralEntry {
        public final SparseArray<PluralEntry> f3089a;

        public GenderedPluralEntry(SparseArray<PluralEntry> sparseArray) {
            this.f3089a = sparseArray;
        }
    }

    /* compiled from: textlink_promote_instagram_friend_count_50 */
    final class C01951 extends PluralsCollection {
        C01951(SparseArray sparseArray, byte[] bArr) {
            super(sparseArray, bArr);
        }

        public final Plural mo697a(int i, Gender gender) {
            return null;
        }
    }

    public PluralsCollection(SparseArray<GenderedPluralEntry> sparseArray, byte[] bArr) {
        this.f3091b = sparseArray;
        this.f3092c = bArr;
    }

    public Plural mo697a(int i, Gender gender) {
        int i2 = 0;
        GenderedPluralEntry genderedPluralEntry = (GenderedPluralEntry) this.f3091b.get(i);
        if (genderedPluralEntry == null) {
            return null;
        }
        Object obj;
        if (genderedPluralEntry.f3089a.indexOfKey(gender.ordinal()) < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            gender = Gender.UNKNOWN;
        }
        PluralEntry pluralEntry = (PluralEntry) genderedPluralEntry.f3089a.get(gender.ordinal());
        Builder builder = ImmutableMap.builder();
        int i3 = 0;
        while (i2 < pluralEntry.f3087b.length) {
            String a = StringResourcesUtil.m5072a(this.f3092c, pluralEntry.f3086a + i3, pluralEntry.f3088c[i2]);
            i3 += pluralEntry.f3088c[i2];
            builder.m609b(PluralCategory.of(pluralEntry.f3087b[i2]), a);
            i2++;
        }
        return new Plural(builder.m610b());
    }
}
