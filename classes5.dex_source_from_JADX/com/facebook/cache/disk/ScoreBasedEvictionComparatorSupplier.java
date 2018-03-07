package com.facebook.cache.disk;

import com.facebook.common.internal.VisibleForTesting;

/* compiled from: android.intent.action.SEARCH */
public class ScoreBasedEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    private final float f10780a;
    private final float f10781b;

    /* compiled from: android.intent.action.SEARCH */
    class C10511 implements EntryEvictionComparator {
        long f10778a = System.currentTimeMillis();
        final /* synthetic */ ScoreBasedEvictionComparatorSupplier f10779b;

        C10511(ScoreBasedEvictionComparatorSupplier scoreBasedEvictionComparatorSupplier) {
            this.f10779b = scoreBasedEvictionComparatorSupplier;
        }

        public int compare(Object obj, Object obj2) {
            DefaultDiskStorage$EntryImpl defaultDiskStorage$EntryImpl = (DefaultDiskStorage$EntryImpl) obj2;
            float a = this.f10779b.m18802a((DefaultDiskStorage$EntryImpl) obj, this.f10778a);
            float a2 = this.f10779b.m18802a(defaultDiskStorage$EntryImpl, this.f10778a);
            if (a < a2) {
                return 1;
            }
            return a2 == a ? 0 : -1;
        }
    }

    public ScoreBasedEvictionComparatorSupplier(float f, float f2) {
        this.f10780a = f;
        this.f10781b = f2;
    }

    public final EntryEvictionComparator m18803a() {
        return new C10511(this);
    }

    @VisibleForTesting
    final float m18802a(DefaultDiskStorage$EntryImpl defaultDiskStorage$EntryImpl, long j) {
        long b = j - defaultDiskStorage$EntryImpl.m18796b();
        return (((float) b) * this.f10780a) + (this.f10781b * ((float) defaultDiskStorage$EntryImpl.m18797d()));
    }
}
