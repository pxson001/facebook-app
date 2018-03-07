package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps.ViewCachingAbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: bug_report_untracked_directory_deleted */
public class StandardTable$RowMap extends ViewCachingAbstractMap<R, Map<C, V>> {
    final /* synthetic */ StandardTable f7563a;

    /* compiled from: bug_report_untracked_directory_deleted */
    class EntrySet extends StandardTable$TableSet<Entry<R, Map<C, V>>> {
        final /* synthetic */ StandardTable$RowMap f7562a;

        /* compiled from: bug_report_untracked_directory_deleted */
        class C08491 implements Function<R, Map<C, V>> {
            final /* synthetic */ EntrySet f7560a;

            C08491(EntrySet entrySet) {
                this.f7560a = entrySet;
            }

            public Object apply(Object obj) {
                return this.f7560a.f7562a.f7563a.b(obj);
            }
        }

        EntrySet(StandardTable$RowMap standardTable$RowMap) {
            this.f7562a = standardTable$RowMap;
            super(standardTable$RowMap.f7563a);
        }

        public Iterator<Entry<R, Map<C, V>>> iterator() {
            return Maps.a(this.f7562a.f7563a.backingMap.keySet(), new C08491(this));
        }

        public int size() {
            return this.f7562a.f7563a.backingMap.size();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (entry.getKey() != null && (entry.getValue() instanceof Map) && Collections2.a(this.f7562a.f7563a.backingMap.entrySet(), entry)) {
                return true;
            }
            return false;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (entry.getKey() != null && (entry.getValue() instanceof Map) && this.f7562a.f7563a.backingMap.entrySet().remove(entry)) {
                return true;
            }
            return false;
        }
    }

    public StandardTable$RowMap(StandardTable standardTable) {
        this.f7563a = standardTable;
    }

    public boolean containsKey(Object obj) {
        return this.f7563a.a(obj);
    }

    public Object get(Object obj) {
        return this.f7563a.a(obj) ? this.f7563a.b(obj) : null;
    }

    public Object remove(Object obj) {
        return obj == null ? null : (Map) this.f7563a.backingMap.remove(obj);
    }

    protected final Set<Entry<R, Map<C, V>>> m13669a() {
        return new EntrySet(this);
    }
}
