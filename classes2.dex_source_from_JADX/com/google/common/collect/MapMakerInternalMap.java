package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalence.Equals;
import com.google.common.base.Equivalence.Identity;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.collect.MapMaker.RemovalListener;
import com.google.common.collect.MapMaker.RemovalNotification;
import com.google.common.primitives.Ints;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: upcoming_birthdays?start_date=<q$1> */
public class MapMakerInternalMap<K, V> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    public static final ValueReference<Object, Object> f1834e = new C01251();
    public static final Queue<? extends Object> f1835f = new C01262();
    private static final Logger f1836j = Logger.getLogger(MapMakerInternalMap.class.getName());
    final transient int f1837a;
    final transient int f1838b;
    final transient Segment<K, V>[] f1839c;
    final int concurrencyLevel;
    final transient EntryFactory f1840d;
    final long expireAfterAccessNanos;
    public final long expireAfterWriteNanos;
    transient Set<K> f1841g;
    transient Collection<V> f1842h;
    transient Set<Entry<K, V>> f1843i;
    final Equivalence<Object> keyEquivalence;
    final Strength keyStrength;
    final int maximumSize;
    final RemovalListener<K, V> removalListener;
    final Queue<RemovalNotification<K, V>> removalNotificationQueue;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence = this.valueStrength.defaultEquivalence();
    final Strength valueStrength;

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    public enum Strength {
        STRONG {
            final <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v) {
                return new StrongValueReference(v);
            }

            final Equivalence<Object> defaultEquivalence() {
                return Equals.INSTANCE;
            }
        },
        SOFT {
            final <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v) {
                return new SoftValueReference(segment.valueReferenceQueue, v, referenceEntry);
            }

            final Equivalence<Object> defaultEquivalence() {
                return Identity.INSTANCE;
            }
        },
        WEAK {
            final Equivalence<Object> defaultEquivalence() {
                return Identity.INSTANCE;
            }

            final <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v) {
                return new WeakValueReference(segment.valueReferenceQueue, v, referenceEntry);
            }
        };

        public abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v);
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    final class C01251 implements ValueReference<Object, Object> {
        C01251() {
        }

        public final Object get() {
            return null;
        }

        public final ReferenceEntry<Object, Object> mo548a() {
            return null;
        }

        public final ValueReference<Object, Object> mo549a(ReferenceQueue<Object> referenceQueue, @Nullable Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        public final boolean mo550b() {
            return false;
        }

        public final void mo551c() {
        }
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    public interface ValueReference<K, V> {
        ReferenceEntry<K, V> mo548a();

        ValueReference<K, V> mo549a(ReferenceQueue<V> referenceQueue, @Nullable V v, ReferenceEntry<K, V> referenceEntry);

        boolean mo550b();

        void mo551c();

        V get();
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    final class C01262 extends AbstractQueue<Object> {
        public final Iterator<Object> iterator() {
            return Iterators.f693a;
        }

        C01262() {
        }

        public final boolean offer(Object obj) {
            return true;
        }

        public final Object peek() {
            return null;
        }

        public final Object poll() {
            return null;
        }

        public final int size() {
            return 0;
        }
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    public enum EntryFactory {
        STRONG {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry(k, i, referenceEntry);
            }
        },
        STRONG_EXPIRABLE {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongExpirableEntry(k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyExpirableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_EVICTABLE {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongEvictableEntry(k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyEvictableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_EXPIRABLE_EVICTABLE {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongExpirableEvictableEntry(k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyExpirableEntry(referenceEntry, copyEntry);
                copyEvictableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        },
        WEAK_EXPIRABLE {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakExpirableEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyExpirableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_EVICTABLE {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakEvictableEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyEvictableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_EXPIRABLE_EVICTABLE {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakExpirableEvictableEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyExpirableEntry(referenceEntry, copyEntry);
                copyEvictableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        
        static final EntryFactory[][] factories = null;

        abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry);

        static {
            r0 = new EntryFactory[3][];
            r0[0] = new EntryFactory[]{STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE};
            r0[1] = new EntryFactory[0];
            r0[2] = new EntryFactory[]{WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE};
            factories = r0;
        }

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            int i;
            int i2 = 0;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            if (z2) {
                i2 = 2;
            }
            return factories[strength.ordinal()][i2 | i];
        }

        <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        <K, V> void copyExpirableEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setExpirationTime(referenceEntry.getExpirationTime());
            MapMakerInternalMap.m3670a(referenceEntry.getPreviousExpirable(), (ReferenceEntry) referenceEntry2);
            MapMakerInternalMap.m3670a((ReferenceEntry) referenceEntry2, referenceEntry.getNextExpirable());
            MapMakerInternalMap.m3675d(referenceEntry);
        }

        <K, V> void copyEvictableEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            MapMakerInternalMap.m3674b(referenceEntry.getPreviousEvictable(), referenceEntry2);
            MapMakerInternalMap.m3674b(referenceEntry2, referenceEntry.getNextEvictable());
            MapMakerInternalMap.m3676e(referenceEntry);
        }
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    public class Segment<K, V> extends ReentrantLock {
        volatile int count;
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> evictionQueue;
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> expirationQueue;
        public final ReferenceQueue<K> keyReferenceQueue;
        @Weak
        public final MapMakerInternalMap<K, V> map;
        public final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        public volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        public int threshold;
        public final ReferenceQueue<V> valueReferenceQueue;

        Segment(MapMakerInternalMap<K, V> mapMakerInternalMap, int i, int i2) {
            Queue concurrentLinkedQueue;
            ReferenceQueue referenceQueue = null;
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            AtomicReferenceArray a = m3702a(i);
            this.threshold = (a.length() * 3) / 4;
            if (this.threshold == this.maxSegmentSize) {
                this.threshold++;
            }
            this.table = a;
            this.keyReferenceQueue = mapMakerInternalMap.m3684d() ? new ReferenceQueue() : null;
            if (mapMakerInternalMap.m3685e()) {
                referenceQueue = new ReferenceQueue();
            }
            this.valueReferenceQueue = referenceQueue;
            if (mapMakerInternalMap.m3679a() || mapMakerInternalMap.m3682c()) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
            } else {
                concurrentLinkedQueue = MapMakerInternalMap.f1835f;
            }
            this.recencyQueue = concurrentLinkedQueue;
            if (mapMakerInternalMap.m3679a()) {
                concurrentLinkedQueue = new EvictionQueue();
            } else {
                concurrentLinkedQueue = MapMakerInternalMap.f1835f;
            }
            this.evictionQueue = concurrentLinkedQueue;
            if (mapMakerInternalMap.m3681b()) {
                concurrentLinkedQueue = new ExpirationQueue();
            } else {
                concurrentLinkedQueue = MapMakerInternalMap.f1835f;
            }
            this.expirationQueue = concurrentLinkedQueue;
        }

        private static AtomicReferenceArray<ReferenceEntry<K, V>> m3702a(int i) {
            return new AtomicReferenceArray(i);
        }

        @GuardedBy("this")
        private ReferenceEntry<K, V> m3701a(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return this.map.f1840d.newEntry(this, k, i, referenceEntry);
        }

        @GuardedBy("this")
        private ReferenceEntry<K, V> m3700a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference valueReference = referenceEntry.getValueReference();
            Object obj = valueReference.get();
            if (obj == null && !valueReference.mo550b()) {
                return null;
            }
            ReferenceEntry<K, V> copyEntry = this.map.f1840d.copyEntry(this, referenceEntry, referenceEntry2);
            copyEntry.setValueReference(valueReference.mo549a(this.valueReferenceQueue, obj, copyEntry));
            return copyEntry;
        }

        @GuardedBy("this")
        private void m3705a(ReferenceEntry<K, V> referenceEntry, V v) {
            referenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, referenceEntry, v));
            m3715d(referenceEntry);
        }

        private void m3711c() {
            if (tryLock()) {
                try {
                    m3714d();
                } finally {
                    unlock();
                }
            }
        }

        @GuardedBy("this")
        private void m3714d() {
            int i;
            Reference poll;
            int i2;
            if (this.map.m3684d()) {
                i = 0;
                while (true) {
                    poll = this.keyReferenceQueue.poll();
                    if (poll == null) {
                        break;
                    }
                    this.map.m3677a((ReferenceEntry) poll);
                    i2 = i + 1;
                    if (i2 == 16) {
                        break;
                    }
                    i = i2;
                }
            }
            if (this.map.m3685e()) {
                i = 0;
                while (true) {
                    poll = this.valueReferenceQueue.poll();
                    if (poll != null) {
                        this.map.m3678a((ValueReference) poll);
                        i2 = i + 1;
                        if (i2 != 16) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        }

        private void m3718g() {
            if (this.map.m3684d()) {
                do {
                } while (this.keyReferenceQueue.poll() != null);
            }
            if (this.map.m3685e()) {
                do {
                } while (this.valueReferenceQueue.poll() != null);
            }
        }

        private void m3710b(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.m3682c()) {
                m3703a((ReferenceEntry) referenceEntry, this.map.expireAfterAccessNanos);
            }
            this.recencyQueue.add(referenceEntry);
        }

        @GuardedBy("this")
        private void m3712c(ReferenceEntry<K, V> referenceEntry) {
            this.evictionQueue.add(referenceEntry);
            if (this.map.m3682c()) {
                m3703a((ReferenceEntry) referenceEntry, this.map.expireAfterAccessNanos);
                this.expirationQueue.add(referenceEntry);
            }
        }

        @GuardedBy("this")
        private void m3715d(ReferenceEntry<K, V> referenceEntry) {
            m3719j();
            this.evictionQueue.add(referenceEntry);
            if (this.map.m3681b()) {
                m3703a((ReferenceEntry) referenceEntry, this.map.m3682c() ? this.map.expireAfterAccessNanos : this.map.expireAfterWriteNanos);
                this.expirationQueue.add(referenceEntry);
            }
        }

        @GuardedBy("this")
        private void m3719j() {
            while (true) {
                ReferenceEntry referenceEntry = (ReferenceEntry) this.recencyQueue.poll();
                if (referenceEntry != null) {
                    if (this.evictionQueue.contains(referenceEntry)) {
                        this.evictionQueue.add(referenceEntry);
                    }
                    if (this.map.m3682c() && this.expirationQueue.contains(referenceEntry)) {
                        this.expirationQueue.add(referenceEntry);
                    }
                } else {
                    return;
                }
            }
        }

        private void m3703a(ReferenceEntry<K, V> referenceEntry, long j) {
            referenceEntry.setExpirationTime(this.map.ticker.read() + j);
        }

        private void m3720k() {
            if (tryLock()) {
                try {
                    m3721l();
                } finally {
                    unlock();
                }
            }
        }

        @GuardedBy("this")
        private void m3721l() {
            m3719j();
            if (!this.expirationQueue.isEmpty()) {
                long read = this.map.ticker.read();
                ReferenceEntry referenceEntry;
                do {
                    referenceEntry = (ReferenceEntry) this.expirationQueue.peek();
                    if (referenceEntry == null || !MapMakerInternalMap.m3671a(referenceEntry, read)) {
                        return;
                    }
                } while (m3707a(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED));
                throw new AssertionError();
            }
        }

        private void m3704a(ReferenceEntry<K, V> referenceEntry, RemovalCause removalCause) {
            Object key = referenceEntry.getKey();
            referenceEntry.getHash();
            m3706a(key, referenceEntry.getValueReference().get(), removalCause);
        }

        private void m3706a(@Nullable K k, @Nullable V v, RemovalCause removalCause) {
            if (this.map.removalNotificationQueue != MapMakerInternalMap.f1835f) {
                this.map.removalNotificationQueue.offer(new RemovalNotification(k, v, removalCause));
            }
        }

        @GuardedBy("this")
        private boolean m3722m() {
            if (!this.map.m3679a() || this.count < this.maxSegmentSize) {
                return false;
            }
            m3719j();
            ReferenceEntry referenceEntry = (ReferenceEntry) this.evictionQueue.remove();
            if (m3707a(referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                return true;
            }
            throw new AssertionError();
        }

        private ReferenceEntry<K, V> m3713d(Object obj, int i) {
            if (this.count != 0) {
                AtomicReferenceArray atomicReferenceArray = this.table;
                for (ReferenceEntry<K, V> referenceEntry = (ReferenceEntry) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                    if (referenceEntry.getHash() == i) {
                        Object key = referenceEntry.getKey();
                        if (key == null) {
                            m3711c();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return referenceEntry;
                        }
                    }
                }
            }
            return null;
        }

        private ReferenceEntry<K, V> m3716e(Object obj, int i) {
            ReferenceEntry<K, V> d = m3713d(obj, i);
            if (d == null) {
                return null;
            }
            if (!this.map.m3681b() || !this.map.m3683c(d)) {
                return d;
            }
            m3720k();
            return null;
        }

        final V m3728a(Object obj, int i) {
            try {
                ReferenceEntry e = m3716e(obj, i);
                if (e == null) {
                    return null;
                }
                V v = e.getValueReference().get();
                if (v != null) {
                    m3710b(e);
                } else {
                    m3711c();
                }
                m3735b();
                return v;
            } finally {
                m3735b();
            }
        }

        final boolean m3736b(Object obj, int i) {
            boolean z = false;
            try {
                if (this.count != 0) {
                    ReferenceEntry e = m3716e(obj, i);
                    if (e != null) {
                        if (e.getValueReference().get() != null) {
                            z = true;
                        }
                        m3735b();
                    }
                } else {
                    m3735b();
                }
                return z;
            } finally {
                m3735b();
            }
        }

        final V m3730a(K k, int i, V v, boolean z) {
            lock();
            try {
                int i2;
                m3725r();
                int i3 = this.count + 1;
                if (i3 > this.threshold) {
                    m3723n();
                    i3 = this.count + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        Object obj = valueReference.get();
                        if (obj == null) {
                            this.modCount++;
                            m3705a(referenceEntry2, (Object) v);
                            if (!valueReference.mo550b()) {
                                m3706a((Object) k, obj, RemovalCause.COLLECTED);
                                i3 = this.count;
                            } else if (m3722m()) {
                                i3 = this.count + 1;
                            }
                            this.count = i3;
                            return null;
                        } else if (z) {
                            m3712c(referenceEntry2);
                            unlock();
                            m3726s();
                            return obj;
                        } else {
                            this.modCount++;
                            m3706a((Object) k, obj, RemovalCause.REPLACED);
                            m3705a(referenceEntry2, (Object) v);
                            unlock();
                            m3726s();
                            return obj;
                        }
                    }
                }
                this.modCount++;
                referenceEntry = m3701a((Object) k, i, referenceEntry);
                m3705a(referenceEntry, (Object) v);
                atomicReferenceArray.set(length, referenceEntry);
                if (m3722m()) {
                    i2 = this.count + 1;
                } else {
                    i2 = i3;
                }
                this.count = i2;
                unlock();
                m3726s();
                return null;
            } finally {
                unlock();
                m3726s();
            }
        }

        @GuardedBy("this")
        private void m3723n() {
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.count;
                AtomicReferenceArray a = m3702a(length << 1);
                this.threshold = (a.length() * 3) / 4;
                int length2 = a.length() - 1;
                int i2 = 0;
                while (i2 < length) {
                    int i3;
                    ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i2);
                    if (referenceEntry != null) {
                        ReferenceEntry next = referenceEntry.getNext();
                        int hash = referenceEntry.getHash() & length2;
                        if (next == null) {
                            a.set(hash, referenceEntry);
                            i3 = i;
                        } else {
                            ReferenceEntry referenceEntry2;
                            ReferenceEntry referenceEntry3 = referenceEntry;
                            while (next != null) {
                                i3 = next.getHash() & length2;
                                if (i3 != hash) {
                                    referenceEntry2 = next;
                                } else {
                                    i3 = hash;
                                    referenceEntry2 = referenceEntry3;
                                }
                                next = next.getNext();
                                referenceEntry3 = referenceEntry2;
                                hash = i3;
                            }
                            a.set(hash, referenceEntry3);
                            referenceEntry2 = referenceEntry;
                            i3 = i;
                            while (referenceEntry2 != referenceEntry3) {
                                int i4;
                                int hash2 = referenceEntry2.getHash() & length2;
                                referenceEntry = m3700a(referenceEntry2, (ReferenceEntry) a.get(hash2));
                                if (referenceEntry != null) {
                                    a.set(hash2, referenceEntry);
                                    i4 = i3;
                                } else {
                                    m3717e(referenceEntry2);
                                    i4 = i3 - 1;
                                }
                                referenceEntry2 = referenceEntry2.getNext();
                                i3 = i4;
                            }
                        }
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
                this.table = a;
                this.count = i;
            }
        }

        final boolean m3734a(K k, int i, V v, V v2) {
            lock();
            try {
                m3725r();
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        Object obj = valueReference.get();
                        if (obj == null) {
                            if (m3708a(valueReference)) {
                                int i2 = this.count;
                                this.modCount++;
                                m3706a(key, obj, RemovalCause.COLLECTED);
                                referenceEntry = m3709b(referenceEntry, referenceEntry2);
                                int i3 = this.count - 1;
                                atomicReferenceArray.set(length, referenceEntry);
                                this.count = i3;
                            }
                            unlock();
                            m3726s();
                            return false;
                        } else if (this.map.valueEquivalence.equivalent(v, obj)) {
                            this.modCount++;
                            m3706a((Object) k, obj, RemovalCause.REPLACED);
                            m3705a(referenceEntry2, (Object) v2);
                            unlock();
                            m3726s();
                            return true;
                        } else {
                            m3712c(referenceEntry2);
                            unlock();
                            m3726s();
                            return false;
                        }
                    }
                }
                unlock();
                m3726s();
                return false;
            } catch (Throwable th) {
                unlock();
                m3726s();
            }
        }

        final V m3729a(K k, int i, V v) {
            lock();
            try {
                m3725r();
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 == null) {
                            if (m3708a(valueReference)) {
                                int i2 = this.count;
                                this.modCount++;
                                m3706a(key, (Object) v2, RemovalCause.COLLECTED);
                                int i3 = this.count - 1;
                                atomicReferenceArray.set(length, m3709b(referenceEntry, referenceEntry2));
                                this.count = i3;
                            }
                            unlock();
                            m3726s();
                            return null;
                        }
                        this.modCount++;
                        m3706a((Object) k, (Object) v2, RemovalCause.REPLACED);
                        m3705a(referenceEntry2, (Object) v);
                        unlock();
                        m3726s();
                        return v2;
                    }
                }
                unlock();
                m3726s();
                return null;
            } catch (Throwable th) {
                unlock();
                m3726s();
            }
        }

        final V m3738c(Object obj, int i) {
            lock();
            try {
                m3725r();
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        RemovalCause removalCause;
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        V v = valueReference.get();
                        if (v != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (m3708a(valueReference)) {
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            unlock();
                            m3726s();
                            return null;
                        }
                        this.modCount++;
                        m3706a(key, (Object) v, removalCause);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, m3709b(referenceEntry, referenceEntry2));
                        this.count = i3;
                        return v;
                    }
                }
                unlock();
                m3726s();
                return null;
            } finally {
                unlock();
                m3726s();
            }
        }

        final boolean m3737b(Object obj, int i, Object obj2) {
            lock();
            try {
                m3725r();
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        RemovalCause removalCause;
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        Object obj3 = valueReference.get();
                        if (this.map.valueEquivalence.equivalent(obj2, obj3)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (m3708a(valueReference)) {
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            unlock();
                            m3726s();
                            return false;
                        }
                        this.modCount++;
                        m3706a(key, obj3, removalCause);
                        referenceEntry = m3709b(referenceEntry, referenceEntry2);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntry);
                        this.count = i3;
                        boolean z = removalCause == RemovalCause.EXPLICIT;
                        unlock();
                        m3726s();
                        return z;
                    }
                }
                unlock();
                m3726s();
                return false;
            } catch (Throwable th) {
                unlock();
                m3726s();
            }
        }

        final void m3731a() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = this.table;
                    if (this.map.removalNotificationQueue != MapMakerInternalMap.f1835f) {
                        for (int i = 0; i < atomicReferenceArray.length(); i++) {
                            for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                                if (!referenceEntry.getValueReference().mo550b()) {
                                    m3704a(referenceEntry, RemovalCause.EXPLICIT);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    m3718g();
                    this.evictionQueue.clear();
                    this.expirationQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    m3726s();
                }
            }
        }

        @GuardedBy("this")
        private ReferenceEntry<K, V> m3709b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            this.evictionQueue.remove(referenceEntry2);
            this.expirationQueue.remove(referenceEntry2);
            int i = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            ReferenceEntry next2;
            while (next2 != referenceEntry2) {
                int i2;
                ReferenceEntry<K, V> a = m3700a(next2, (ReferenceEntry) next);
                if (a != null) {
                    i2 = i;
                } else {
                    m3717e(next2);
                    ReferenceEntry<K, V> referenceEntry3 = next;
                    i2 = i - 1;
                    a = referenceEntry3;
                }
                next2 = next2.getNext();
                i = i2;
                next = a;
            }
            this.count = i;
            return next;
        }

        private void m3717e(ReferenceEntry<K, V> referenceEntry) {
            m3704a((ReferenceEntry) referenceEntry, RemovalCause.COLLECTED);
            this.evictionQueue.remove(referenceEntry);
            this.expirationQueue.remove(referenceEntry);
        }

        final boolean m3732a(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount++;
                        m3706a(referenceEntry3.getKey(), referenceEntry3.getValueReference().get(), RemovalCause.COLLECTED);
                        referenceEntry2 = m3709b(referenceEntry2, referenceEntry3);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntry2);
                        this.count = i3;
                        return true;
                    }
                }
                unlock();
                m3726s();
                return false;
            } finally {
                unlock();
                m3726s();
            }
        }

        final boolean m3733a(K k, int i, ValueReference<K, V> valueReference) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == valueReference) {
                        this.modCount++;
                        m3706a((Object) k, valueReference.get(), RemovalCause.COLLECTED);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, m3709b(referenceEntry, referenceEntry2));
                        this.count = i3;
                        return true;
                    } else {
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            m3726s();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    m3726s();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    m3726s();
                }
            }
        }

        @GuardedBy("this")
        private boolean m3707a(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            int i2 = this.count;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    m3706a(referenceEntry3.getKey(), referenceEntry3.getValueReference().get(), removalCause);
                    referenceEntry2 = m3709b(referenceEntry2, referenceEntry3);
                    int i3 = this.count - 1;
                    atomicReferenceArray.set(length, referenceEntry2);
                    this.count = i3;
                    return true;
                }
            }
            return false;
        }

        private static boolean m3708a(ValueReference<K, V> valueReference) {
            if (!valueReference.mo550b() && valueReference.get() == null) {
                return true;
            }
            return false;
        }

        final V m3727a(ReferenceEntry<K, V> referenceEntry) {
            if (referenceEntry.getKey() == null) {
                m3711c();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                m3711c();
                return null;
            } else if (!this.map.m3681b() || !this.map.m3683c(referenceEntry)) {
                return v;
            } else {
                m3720k();
                return null;
            }
        }

        final void m3735b() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                m3724q();
            }
        }

        private void m3724q() {
            m3725r();
            m3726s();
        }

        private void m3725r() {
            if (tryLock()) {
                try {
                    m3714d();
                    m3721l();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        private void m3726s() {
            if (!isHeldByCurrentThread()) {
                this.map.m3686i();
            }
        }
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int f5374a;
        final ReferenceEntry<K, V> f5375b;
        volatile ValueReference<K, V> f5376c = MapMakerInternalMap.f1834e;

        WeakEntry(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.f5374a = i;
            this.f5375b = referenceEntry;
        }

        public K getKey() {
            return get();
        }

        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ValueReference<K, V> getValueReference() {
            return this.f5376c;
        }

        public void setValueReference(ValueReference<K, V> valueReference) {
            ValueReference valueReference2 = this.f5376c;
            this.f5376c = valueReference;
            valueReference2.mo551c();
        }

        public int getHash() {
            return this.f5374a;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.f5375b;
        }
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    public interface ReferenceEntry<K, V> {
        long getExpirationTime();

        int getHash();

        K getKey();

        ReferenceEntry<K, V> getNext();

        ReferenceEntry<K, V> getNextEvictable();

        ReferenceEntry<K, V> getNextExpirable();

        ReferenceEntry<K, V> getPreviousEvictable();

        ReferenceEntry<K, V> getPreviousExpirable();

        ValueReference<K, V> getValueReference();

        void setExpirationTime(long j);

        void setNextEvictable(ReferenceEntry<K, V> referenceEntry);

        void setNextExpirable(ReferenceEntry<K, V> referenceEntry);

        void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry);

        void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry);

        void setValueReference(ValueReference<K, V> valueReference);
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    final class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V f5377a;

        StrongValueReference(V v) {
            this.f5377a = v;
        }

        public final V get() {
            return this.f5377a;
        }

        public final ReferenceEntry<K, V> mo548a() {
            return null;
        }

        public final ValueReference<K, V> mo549a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public final boolean mo550b() {
            return false;
        }

        public final void mo551c() {
        }
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    final class KeySet extends SafeToArraySet<K> {
        final /* synthetic */ MapMakerInternalMap f22113a;

        KeySet(MapMakerInternalMap mapMakerInternalMap) {
            this.f22113a = mapMakerInternalMap;
        }

        public final Iterator<K> iterator() {
            return new KeyIterator(this.f22113a);
        }

        public final int size() {
            return this.f22113a.size();
        }

        public final boolean isEmpty() {
            return this.f22113a.isEmpty();
        }

        public final boolean contains(Object obj) {
            return this.f22113a.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return this.f22113a.remove(obj) != null;
        }

        public final void clear() {
            this.f22113a.clear();
        }
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    abstract class SafeToArraySet<E> extends AbstractSet<E> {
        public Object[] toArray() {
            return MapMakerInternalMap.m3673b((Collection) this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return MapMakerInternalMap.m3673b((Collection) this).toArray(eArr);
        }
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    final class KeyIterator extends HashIterator<K> {
        final /* synthetic */ MapMakerInternalMap f22114a;

        KeyIterator(MapMakerInternalMap mapMakerInternalMap) {
            this.f22114a = mapMakerInternalMap;
            super(mapMakerInternalMap);
        }

        public final K next() {
            return m30001a().getKey();
        }
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    public abstract class HashIterator<E> implements Iterator<E> {
        int f22115b;
        int f22116c = -1;
        Segment<K, V> f22117d;
        AtomicReferenceArray<ReferenceEntry<K, V>> f22118e;
        ReferenceEntry<K, V> f22119f;
        WriteThroughEntry f22120g;
        WriteThroughEntry f22121h;
        final /* synthetic */ MapMakerInternalMap f22122i;

        HashIterator(MapMakerInternalMap mapMakerInternalMap) {
            this.f22122i = mapMakerInternalMap;
            this.f22115b = mapMakerInternalMap.f1839c.length - 1;
            m29998b();
        }

        private void m29998b() {
            this.f22120g = null;
            if (!m29999c() && !m30000d()) {
                while (this.f22115b >= 0) {
                    Segment[] segmentArr = this.f22122i.f1839c;
                    int i = this.f22115b;
                    this.f22115b = i - 1;
                    this.f22117d = segmentArr[i];
                    if (this.f22117d.count != 0) {
                        this.f22118e = this.f22117d.table;
                        this.f22116c = this.f22118e.length() - 1;
                        if (m30000d()) {
                            return;
                        }
                    }
                }
            }
        }

        private boolean m29999c() {
            if (this.f22119f != null) {
                this.f22119f = this.f22119f.getNext();
                while (this.f22119f != null) {
                    if (m29997a(this.f22119f)) {
                        return true;
                    }
                    this.f22119f = this.f22119f.getNext();
                }
            }
            return false;
        }

        private boolean m30000d() {
            while (this.f22116c >= 0) {
                AtomicReferenceArray atomicReferenceArray = this.f22118e;
                int i = this.f22116c;
                this.f22116c = i - 1;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i);
                this.f22119f = referenceEntry;
                if (referenceEntry != null && (m29997a(this.f22119f) || m29999c())) {
                    return true;
                }
            }
            return false;
        }

        private boolean m29997a(ReferenceEntry<K, V> referenceEntry) {
            try {
                Object key = referenceEntry.getKey();
                Object b = this.f22122i.m3680b((ReferenceEntry) referenceEntry);
                if (b != null) {
                    this.f22120g = new WriteThroughEntry(this.f22122i, key, b);
                    return true;
                }
                this.f22117d.m3735b();
                return false;
            } finally {
                this.f22117d.m3735b();
            }
        }

        public boolean hasNext() {
            return this.f22120g != null;
        }

        final WriteThroughEntry m30001a() {
            if (this.f22120g == null) {
                throw new NoSuchElementException();
            }
            this.f22121h = this.f22120g;
            m29998b();
            return this.f22121h;
        }

        public void remove() {
            CollectPreconditions.m617a(this.f22121h != null);
            this.f22122i.remove(this.f22121h.getKey());
            this.f22121h = null;
        }
    }

    /* compiled from: upcoming_birthdays?start_date=<q$1> */
    final class WriteThroughEntry extends AbstractMapEntry<K, V> {
        final K f24291a;
        V f24292b;
        final /* synthetic */ MapMakerInternalMap f24293c;

        WriteThroughEntry(MapMakerInternalMap mapMakerInternalMap, K k, V v) {
            this.f24293c = mapMakerInternalMap;
            this.f24291a = k;
            this.f24292b = v;
        }

        public final K getKey() {
            return this.f24291a;
        }

        public final V getValue() {
            return this.f24292b;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.f24291a.equals(entry.getKey()) && this.f24292b.equals(entry.getValue())) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.f24291a.hashCode() ^ this.f24292b.hashCode();
        }

        public final V setValue(V v) {
            V put = this.f24293c.put(this.f24291a, v);
            this.f24292b = v;
            return put;
        }
    }

    MapMakerInternalMap(MapMaker mapMaker) {
        long j;
        Queue queue;
        int i = 1;
        int i2 = 0;
        this.concurrencyLevel = Math.min(mapMaker.m1484d(), 65536);
        this.keyStrength = mapMaker.m1486f();
        this.valueStrength = (Strength) MoreObjects.firstNonNull(mapMaker.f750g, Strength.STRONG);
        this.keyEquivalence = (Equivalence) MoreObjects.firstNonNull(mapMaker.f754k, mapMaker.m1486f().defaultEquivalence());
        this.maximumSize = mapMaker.f748e;
        if (mapMaker.f752i == -1) {
            j = 0;
        } else {
            j = mapMaker.f752i;
        }
        this.expireAfterAccessNanos = j;
        this.expireAfterWriteNanos = mapMaker.m1488i();
        this.f1840d = EntryFactory.getFactory(this.keyStrength, m3681b(), m3679a());
        this.ticker = (Ticker) MoreObjects.firstNonNull(mapMaker.f755l, Ticker.SYSTEM_TICKER);
        this.removalListener = mapMaker.m1490a();
        if (this.removalListener == NullListener.INSTANCE) {
            queue = f1835f;
        } else {
            queue = new ConcurrentLinkedQueue();
        }
        this.removalNotificationQueue = queue;
        int min = Math.min(mapMaker.m1482c(), 1073741824);
        if (m3679a()) {
            min = Math.min(min, this.maximumSize);
        }
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.concurrencyLevel && (!m3679a() || i3 * 2 <= this.maximumSize)) {
            i4++;
            i3 <<= 1;
        }
        this.f1838b = 32 - i4;
        this.f1837a = i3 - 1;
        this.f1839c = new Segment[i3];
        i4 = min / i3;
        if (i4 * i3 < min) {
            min = i4 + 1;
        } else {
            min = i4;
        }
        while (i < min) {
            i <<= 1;
        }
        if (m3679a()) {
            min = (this.maximumSize / i3) + 1;
            i3 = this.maximumSize % i3;
            while (i2 < this.f1839c.length) {
                if (i2 == i3) {
                    min--;
                }
                this.f1839c[i2] = m3669a(i, min);
                i2++;
            }
            return;
        }
        while (i2 < this.f1839c.length) {
            this.f1839c[i2] = m3669a(i, -1);
            i2++;
        }
    }

    final boolean m3679a() {
        return this.maximumSize != -1;
    }

    final boolean m3681b() {
        return ((this.expireAfterWriteNanos > 0 ? 1 : (this.expireAfterWriteNanos == 0 ? 0 : -1)) > 0 ? 1 : null) != null || m3682c();
    }

    final boolean m3682c() {
        return this.expireAfterAccessNanos > 0;
    }

    final boolean m3684d() {
        return this.keyStrength != Strength.STRONG;
    }

    final boolean m3685e() {
        return this.valueStrength != Strength.STRONG;
    }

    static <K, V> void m3675d(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry referenceEntry2 = NullEntry.INSTANCE;
        referenceEntry.setNextExpirable(referenceEntry2);
        referenceEntry.setPreviousExpirable(referenceEntry2);
    }

    static <K, V> void m3676e(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry referenceEntry2 = NullEntry.INSTANCE;
        referenceEntry.setNextEvictable(referenceEntry2);
        referenceEntry.setPreviousEvictable(referenceEntry2);
    }

    private int m3668a(Object obj) {
        int hash = this.keyEquivalence.hash(obj);
        int i = ((hash << 15) ^ -12931) + hash;
        i ^= i >>> 10;
        i += i << 3;
        i ^= i >>> 6;
        i += (i << 2) + (i << 14);
        return i ^ (i >>> 16);
    }

    public final void m3678a(ValueReference<K, V> valueReference) {
        ReferenceEntry a = valueReference.mo548a();
        int hash = a.getHash();
        m3672b(hash).m3733a(a.getKey(), hash, (ValueReference) valueReference);
    }

    public final void m3677a(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        m3672b(hash).m3732a((ReferenceEntry) referenceEntry, hash);
    }

    private Segment<K, V> m3672b(int i) {
        return this.f1839c[(i >>> this.f1838b) & this.f1837a];
    }

    private Segment<K, V> m3669a(int i, int i2) {
        return new Segment(this, i, i2);
    }

    final V m3680b(ReferenceEntry<K, V> referenceEntry) {
        if (referenceEntry.getKey() == null) {
            return null;
        }
        V v = referenceEntry.getValueReference().get();
        if (v == null) {
            return null;
        }
        if (m3681b() && m3683c(referenceEntry)) {
            return null;
        }
        return v;
    }

    final boolean m3683c(ReferenceEntry<K, V> referenceEntry) {
        return m3671a((ReferenceEntry) referenceEntry, this.ticker.read());
    }

    static boolean m3671a(ReferenceEntry<K, V> referenceEntry, long j) {
        return j - referenceEntry.getExpirationTime() > 0;
    }

    static <K, V> void m3670a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextExpirable(referenceEntry2);
        referenceEntry2.setPreviousExpirable(referenceEntry);
    }

    final void m3686i() {
        while (true) {
            RemovalNotification removalNotification = (RemovalNotification) this.removalNotificationQueue.poll();
            if (removalNotification != null) {
                try {
                    this.removalListener.onRemoval(removalNotification);
                } catch (Throwable e) {
                    f1836j.log(Level.WARNING, "Exception thrown by removal listener", e);
                }
            } else {
                return;
            }
        }
    }

    static <K, V> void m3674b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextEvictable(referenceEntry2);
        referenceEntry2.setPreviousEvictable(referenceEntry);
    }

    public boolean isEmpty() {
        int i;
        Segment[] segmentArr = this.f1839c;
        long j = 0;
        for (i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            j += (long) segmentArr[i].modCount;
        }
        if (j != 0) {
            for (i = 0; i < segmentArr.length; i++) {
                if (segmentArr[i].count != 0) {
                    return false;
                }
                j -= (long) segmentArr[i].modCount;
            }
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        long j = 0;
        for (Segment segment : this.f1839c) {
            j += (long) segment.count;
        }
        return Ints.m4489b(j);
    }

    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int a = m3668a(obj);
        return m3672b(a).m3728a(obj, a);
    }

    public boolean containsKey(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        int a = m3668a(obj);
        return m3672b(a).m3736b(obj, a);
    }

    public boolean containsValue(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        Segment[] segmentArr = this.f1839c;
        int i = 0;
        long j = -1;
        while (i < 3) {
            long j2 = 0;
            for (Segment segment : segmentArr) {
                int i2 = segment.count;
                AtomicReferenceArray atomicReferenceArray = segment.table;
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i3); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                        Object a = segment.m3727a(referenceEntry);
                        if (a != null && this.valueEquivalence.equivalent(obj, a)) {
                            return true;
                        }
                    }
                }
                j2 += (long) segment.modCount;
            }
            if (j2 == j) {
                break;
            }
            i++;
            j = j2;
        }
        return false;
    }

    public V put(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int a = m3668a((Object) k);
        return m3672b(a).m3730a((Object) k, a, (Object) v, false);
    }

    public V putIfAbsent(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int a = m3668a((Object) k);
        return m3672b(a).m3730a((Object) k, a, (Object) v, true);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int a = m3668a(obj);
        return m3672b(a).m3738c(obj, a);
    }

    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int a = m3668a(obj);
        return m3672b(a).m3737b(obj, a, obj2);
    }

    public boolean replace(K k, @Nullable V v, V v2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int a = m3668a((Object) k);
        return m3672b(a).m3734a((Object) k, a, (Object) v, (Object) v2);
    }

    public V replace(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int a = m3668a((Object) k);
        return m3672b(a).m3729a((Object) k, a, (Object) v);
    }

    public void clear() {
        for (Segment a : this.f1839c) {
            a.m3731a();
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.f1841g;
        if (set != null) {
            return set;
        }
        set = new KeySet(this);
        this.f1841g = set;
        return set;
    }

    public Collection<V> values() {
        Collection<V> collection = this.f1842h;
        if (collection != null) {
            return collection;
        }
        collection = new Values(this);
        this.f1842h = collection;
        return collection;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.f1843i;
        if (set != null) {
            return set;
        }
        set = new EntrySet(this);
        this.f1843i = set;
        return set;
    }

    public static <E> ArrayList<E> m3673b(Collection<E> collection) {
        Collection arrayList = new ArrayList(collection.size());
        Iterators.m1411a(arrayList, collection.iterator());
        return arrayList;
    }

    Object writeReplace() {
        return new SerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this);
    }
}
