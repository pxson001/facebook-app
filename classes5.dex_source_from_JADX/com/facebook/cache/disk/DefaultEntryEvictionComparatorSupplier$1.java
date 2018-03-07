package com.facebook.cache.disk;

/* compiled from: android.intent.action.VIEW */
class DefaultEntryEvictionComparatorSupplier$1 implements EntryEvictionComparator {
    final /* synthetic */ DefaultEntryEvictionComparatorSupplier f10775a;

    DefaultEntryEvictionComparatorSupplier$1(DefaultEntryEvictionComparatorSupplier defaultEntryEvictionComparatorSupplier) {
        this.f10775a = defaultEntryEvictionComparatorSupplier;
    }

    public int compare(Object obj, Object obj2) {
        DefaultDiskStorage$EntryImpl defaultDiskStorage$EntryImpl = (DefaultDiskStorage$EntryImpl) obj2;
        long b = ((DefaultDiskStorage$EntryImpl) obj).m18796b();
        long b2 = defaultDiskStorage$EntryImpl.m18796b();
        if (b < b2) {
            return -1;
        }
        return b2 == b ? 0 : 1;
    }
}
