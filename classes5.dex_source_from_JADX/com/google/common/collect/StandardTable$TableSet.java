package com.google.common.collect;

import com.google.common.collect.Sets.ImprovedAbstractSet;

/* compiled from: bug_report_untracked_directory_deleted */
abstract class StandardTable$TableSet<T> extends ImprovedAbstractSet<T> {
    final /* synthetic */ StandardTable f7561b;

    public StandardTable$TableSet(StandardTable standardTable) {
        this.f7561b = standardTable;
    }

    public boolean isEmpty() {
        return this.f7561b.backingMap.isEmpty();
    }

    public void clear() {
        this.f7561b.backingMap.clear();
    }
}
