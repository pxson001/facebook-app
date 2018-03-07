package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: reaction_dialog_videos */
abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Entry<K, V>> {

    /* compiled from: reaction_dialog_videos */
    final class RegularEntrySet<K, V> extends ImmutableMapEntrySet<K, V> {
        @Weak
        private final transient ImmutableMap<K, V> f8062a;
        private final transient Entry<K, V>[] f8063b;

        RegularEntrySet(ImmutableMap<K, V> immutableMap, Entry<K, V>[] entryArr) {
            this.f8062a = immutableMap;
            this.f8063b = entryArr;
        }

        final ImmutableMap<K, V> mo1721a() {
            return this.f8062a;
        }

        public final UnmodifiableIterator<Entry<K, V>> iterator() {
            return asList().iterator();
        }

        final ImmutableList<Entry<K, V>> createAsList() {
            return new RegularImmutableAsList((ImmutableCollection) this, this.f8063b);
        }
    }

    abstract ImmutableMap<K, V> mo1721a();

    ImmutableMapEntrySet() {
    }

    public int size() {
        return mo1721a().size();
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object obj2 = mo1721a().get(entry.getKey());
        if (obj2 == null || !obj2.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    boolean isPartialView() {
        return mo1721a().isPartialView();
    }

    @GwtIncompatible("not used in GWT")
    boolean isHashCodeFast() {
        return mo1721a().isHashCodeFast();
    }

    public int hashCode() {
        return mo1721a().hashCode();
    }

    @GwtIncompatible("serialization")
    Object writeReplace() {
        return new EntrySetSerializedForm(mo1721a());
    }
}
