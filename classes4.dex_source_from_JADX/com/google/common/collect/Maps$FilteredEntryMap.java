package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: log_eligibility_waterfall */
public class Maps$FilteredEntryMap<K, V> extends Maps$AbstractFilteredMap<K, V> {
    final Set<Entry<K, V>> f10756c;

    /* compiled from: log_eligibility_waterfall */
    class EntrySet extends ForwardingSet<Entry<K, V>> {
        final /* synthetic */ Maps$FilteredEntryMap f10757a;

        protected final /* synthetic */ Collection mo731b() {
            return mo807a();
        }

        protected final /* synthetic */ Object mo733e() {
            return mo807a();
        }

        public EntrySet(Maps$FilteredEntryMap maps$FilteredEntryMap) {
            this.f10757a = maps$FilteredEntryMap;
        }

        protected final Set<Entry<K, V>> mo807a() {
            return this.f10757a.f10756c;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new TransformedIterator<Entry<K, V>, Entry<K, V>>(this, this.f10757a.f10756c.iterator()) {
                final /* synthetic */ EntrySet f10758a;

                final Object m11208a(Object obj) {
                    final Entry entry = (Entry) obj;
                    return new ForwardingMapEntry<K, V>(this) {
                        final /* synthetic */ C05011 f10760b;

                        protected final /* synthetic */ Object mo811e() {
                            return mo810a();
                        }

                        protected final Entry<K, V> mo810a() {
                            return entry;
                        }

                        public V setValue(V v) {
                            Preconditions.checkArgument(this.f10760b.f10758a.f10757a.m11197b(getKey(), v));
                            return super.setValue(v);
                        }
                    };
                }
            };
        }
    }

    /* compiled from: log_eligibility_waterfall */
    class KeySet extends com.google.common.collect.Maps.KeySet<K, V> {
        final /* synthetic */ Maps$FilteredEntryMap f10768a;

        KeySet(Maps$FilteredEntryMap maps$FilteredEntryMap) {
            this.f10768a = maps$FilteredEntryMap;
            super(maps$FilteredEntryMap);
        }

        public boolean remove(Object obj) {
            if (!this.f10768a.containsKey(obj)) {
                return false;
            }
            this.f10768a.f10754a.remove(obj);
            return true;
        }

        private boolean m11214a(Predicate<? super K> predicate) {
            return Iterables.a(this.f10768a.f10754a.entrySet(), Predicates.and(this.f10768a.f10755b, Maps.a(predicate)));
        }

        public boolean removeAll(Collection<?> collection) {
            return m11214a(Predicates.in(collection));
        }

        public boolean retainAll(Collection<?> collection) {
            return m11214a(Predicates.not(Predicates.in(collection)));
        }

        public Object[] toArray() {
            return Lists.a(iterator()).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return Lists.a(iterator()).toArray(tArr);
        }
    }

    public Maps$FilteredEntryMap(Map<K, V> map, Predicate<? super Entry<K, V>> predicate) {
        super(map, predicate);
        this.f10756c = Sets.a(map.entrySet(), this.f10755b);
    }

    protected final Set<Entry<K, V>> m11199a() {
        return new EntrySet(this);
    }

    Set<K> m11200b() {
        return new KeySet(this);
    }
}
