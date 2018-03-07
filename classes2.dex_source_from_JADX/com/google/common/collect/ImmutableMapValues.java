package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicates;
import com.google.j2objc.annotations.Weak;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: messenger_inline_video_playback_android */
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    @Weak
    public final ImmutableMap<K, V> map;

    /* compiled from: messenger_inline_video_playback_android */
    class C09161 extends UnmodifiableIterator<V> {
        final UnmodifiableIterator<Entry<K, V>> f22489a = this.f22490b.map.entrySet().iterator();
        final /* synthetic */ ImmutableMapValues f22490b;

        C09161(ImmutableMapValues immutableMapValues) {
            this.f22490b = immutableMapValues;
        }

        public boolean hasNext() {
            return this.f22489a.hasNext();
        }

        public V next() {
            return ((Entry) this.f22489a.next()).getValue();
        }
    }

    ImmutableMapValues(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    public final int size() {
        return this.map.size();
    }

    public final UnmodifiableIterator<V> iterator() {
        return new C09161(this);
    }

    public final boolean contains(@Nullable Object obj) {
        return obj != null && Iterators.m1422c(iterator(), Predicates.equalTo(obj));
    }

    final boolean isPartialView() {
        return true;
    }

    final ImmutableList<V> createAsList() {
        final ImmutableList asList = this.map.entrySet().asList();
        return new ImmutableAsList<V>() {
            public V get(int i) {
                return ((Entry) asList.get(i)).getValue();
            }

            final ImmutableCollection<V> mo1722a() {
                return ImmutableMapValues.this;
            }
        };
    }

    @GwtIncompatible("serialization")
    final Object writeReplace() {
        return new SerializedForm(this.map);
    }
}
