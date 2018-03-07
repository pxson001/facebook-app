package com.google.common.collect;

import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables.ImmutableCell;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: bug_report_untracked_directory_deleted */
class StandardTable$CellIterator implements Iterator<Cell<R, C, V>> {
    final Iterator<Entry<R, Map<C, V>>> f7549a = this.f7552d.backingMap.entrySet().iterator();
    Entry<R, Map<C, V>> f7550b;
    Iterator<Entry<C, V>> f7551c = Iterators.b;
    final /* synthetic */ StandardTable f7552d;

    public StandardTable$CellIterator(StandardTable standardTable) {
        this.f7552d = standardTable;
    }

    public boolean hasNext() {
        return this.f7549a.hasNext() || this.f7551c.hasNext();
    }

    public Object next() {
        if (!this.f7551c.hasNext()) {
            this.f7550b = (Entry) this.f7549a.next();
            this.f7551c = ((Map) this.f7550b.getValue()).entrySet().iterator();
        }
        Entry entry = (Entry) this.f7551c.next();
        return new ImmutableCell(this.f7550b.getKey(), entry.getKey(), entry.getValue());
    }

    public void remove() {
        this.f7551c.remove();
        if (((Map) this.f7550b.getValue()).isEmpty()) {
            this.f7549a.remove();
        }
    }
}
