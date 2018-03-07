package com.google.common.cache;

import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Equivalence.Equals;
import com.google.common.base.Equivalence.Identity;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.CacheLoader.InvalidCacheLoadException;
import com.google.common.collect.Iterators;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@GwtCompatible
/* compiled from: zeroOptoutParams */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final Logger f570a = Logger.getLogger(LocalCache.class.getName());
    public static final ValueReference<Object, Object> f571u = new C00291();
    public static final Queue<? extends Object> f572v = new C00302();
    final int f573b;
    final int f574c;
    public final Segment<K, V>[] f575d;
    final int f576e;
    final Equivalence<Object> f577f;
    final Equivalence<Object> f578g;
    final Strength f579h;
    final Strength f580i;
    final long f581j;
    final Weigher<K, V> f582k;
    final long f583l;
    final long f584m;
    final long f585n;
    final Queue<RemovalNotification<K, V>> f586o;
    final RemovalListener<K, V> f587p;
    final Ticker f588q;
    final EntryFactory f589r;
    final AbstractCache$StatsCounter f590s;
    @Nullable
    public final CacheLoader<? super K, V> f591t;
    Set<K> f592w;
    Collection<V> f593x;
    Set<Entry<K, V>> f594y;

    /* compiled from: zeroOptoutParams */
    enum Strength {
        STRONG {
            final Equivalence<Object> defaultEquivalence() {
                return Equals.INSTANCE;
            }

            final <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new StrongValueReference(v) : new WeightedStrongValueReference(v, i);
            }
        },
        SOFT {
            final Equivalence<Object> defaultEquivalence() {
                return Identity.INSTANCE;
            }

            final <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new SoftValueReference(segment.valueReferenceQueue, v, referenceEntry) : new WeightedSoftValueReference(segment.valueReferenceQueue, v, referenceEntry, i);
            }
        },
        WEAK {
            final Equivalence<Object> defaultEquivalence() {
                return Identity.INSTANCE;
            }

            final <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new WeakValueReference(segment.valueReferenceQueue, v, referenceEntry) : new WeightedWeakValueReference(segment.valueReferenceQueue, v, referenceEntry, i);
            }
        };

        abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i);
    }

    /* compiled from: zeroOptoutParams */
    class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, (CacheLoader) Preconditions.checkNotNull(cacheLoader)));
        }

        public final V mo108c(K k) {
            LocalCache localCache = this.localCache;
            return localCache.m1185a((Object) k, localCache.f591t);
        }

        public final V mo109d(K k) {
            try {
                return mo108c(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        public final V apply(K k) {
            return mo109d(k);
        }

        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    /* compiled from: zeroOptoutParams */
    public class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        final LocalCache<K, V> localCache;

        LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        public LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }

        @Nullable
        public final V mo110a(Object obj) {
            return this.localCache.m1184a(obj);
        }

        public final V mo111a(K k, Callable<? extends V> callable) {
            Preconditions.checkNotNull(callable);
            return this.localCache.m1185a((Object) k, new 1(this, callable));
        }

        public final void mo114a(K k, V v) {
            this.localCache.put(k, v);
        }

        public final void mo116b(Object obj) {
            Preconditions.checkNotNull(obj);
            this.localCache.remove(obj);
        }

        public final void mo113a(Iterable<?> iterable) {
            LocalCache localCache = this.localCache;
            for (Object remove : iterable) {
                localCache.remove(remove);
            }
        }

        public final void mo112a() {
            this.localCache.clear();
        }

        public final ConcurrentMap<K, V> mo115b() {
            return this.localCache;
        }

        public final void mo117c() {
            for (Segment c : this.localCache.f575d) {
                c.m1262c();
            }
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }
    }

    /* compiled from: zeroOptoutParams */
    final class C00291 implements ValueReference<Object, Object> {
        C00291() {
        }

        public final Object get() {
            return null;
        }

        public final int mo129a() {
            return 0;
        }

        public final ReferenceEntry<Object, Object> mo132b() {
            return null;
        }

        public final ValueReference<Object, Object> mo130a(ReferenceQueue<Object> referenceQueue, @Nullable Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        public final boolean mo133c() {
            return false;
        }

        public final boolean mo134d() {
            return false;
        }

        public final Object mo135e() {
            return null;
        }

        public final void mo131a(Object obj) {
        }
    }

    /* compiled from: zeroOptoutParams */
    public interface ValueReference<K, V> {
        int mo129a();

        ValueReference<K, V> mo130a(ReferenceQueue<V> referenceQueue, @Nullable V v, ReferenceEntry<K, V> referenceEntry);

        void mo131a(@Nullable V v);

        @Nullable
        ReferenceEntry<K, V> mo132b();

        boolean mo133c();

        boolean mo134d();

        V mo135e();

        @Nullable
        V get();
    }

    /* compiled from: zeroOptoutParams */
    final class C00302 extends AbstractQueue<Object> {
        public final Iterator<Object> iterator() {
            return RegularImmutableSet.f688a.iterator();
        }

        C00302() {
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

    /* compiled from: zeroOptoutParams */
    public enum EntryFactory {
        STRONG {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry(k, i, referenceEntry);
            }
        },
        STRONG_ACCESS {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessEntry(k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_WRITE {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongWriteEntry(k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_ACCESS_WRITE {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessWriteEntry(k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        },
        WEAK_ACCESS {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_WRITE {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakWriteEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_ACCESS_WRITE {
            final <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            final <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        
        static final EntryFactory[] factories = null;

        abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry);

        static {
            factories = new EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
        }

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            int i;
            int i2 = 0;
            if (strength == Strength.WEAK) {
                i = 4;
            } else {
                i = 0;
            }
            int i3 = (z ? 1 : 0) | i;
            if (z2) {
                i2 = 2;
            }
            return factories[i2 | i3];
        }

        <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        <K, V> void copyAccessEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.m1170a(referenceEntry.getPreviousInAccessQueue(), (ReferenceEntry) referenceEntry2);
            LocalCache.m1170a((ReferenceEntry) referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.m1173b((ReferenceEntry) referenceEntry);
        }

        <K, V> void copyWriteEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.m1174b(referenceEntry.getPreviousInWriteQueue(), (ReferenceEntry) referenceEntry2);
            LocalCache.m1174b((ReferenceEntry) referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.m1176c((ReferenceEntry) referenceEntry);
        }
    }

    /* compiled from: zeroOptoutParams */
    public class Segment<K, V> extends ReentrantLock {
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> accessQueue;
        public volatile int count;
        public final ReferenceQueue<K> keyReferenceQueue;
        @Weak
        public final LocalCache<K, V> map;
        public final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache$StatsCounter statsCounter;
        public volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        public int threshold;
        @GuardedBy("this")
        long totalWeight;
        public final ReferenceQueue<V> valueReferenceQueue;
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> writeQueue;

        Segment(LocalCache<K, V> localCache, int i, long j, AbstractCache$StatsCounter abstractCache$StatsCounter) {
            Queue concurrentLinkedQueue;
            ReferenceQueue referenceQueue = null;
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = (AbstractCache$StatsCounter) Preconditions.checkNotNull(abstractCache$StatsCounter);
            AtomicReferenceArray a = m1222a(i);
            this.threshold = (a.length() * 3) / 4;
            if (!this.map.m1189b() && ((long) this.threshold) == this.maxSegmentWeight) {
                this.threshold++;
            }
            this.table = a;
            this.keyReferenceQueue = localCache.m1196h() ? new ReferenceQueue() : null;
            if (localCache.m1197i()) {
                referenceQueue = new ReferenceQueue();
            }
            this.valueReferenceQueue = referenceQueue;
            if (localCache.m1192d()) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
            } else {
                concurrentLinkedQueue = LocalCache.f572v;
            }
            this.recencyQueue = concurrentLinkedQueue;
            if (localCache.m1193e()) {
                concurrentLinkedQueue = new WriteQueue();
            } else {
                concurrentLinkedQueue = LocalCache.f572v;
            }
            this.writeQueue = concurrentLinkedQueue;
            if (localCache.m1192d()) {
                concurrentLinkedQueue = new AccessQueue();
            } else {
                concurrentLinkedQueue = LocalCache.f572v;
            }
            this.accessQueue = concurrentLinkedQueue;
        }

        private static AtomicReferenceArray<ReferenceEntry<K, V>> m1222a(int i) {
            return new AtomicReferenceArray(i);
        }

        @GuardedBy("this")
        private ReferenceEntry<K, V> m1217a(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return this.map.f589r.newEntry(this, Preconditions.checkNotNull(k), i, referenceEntry);
        }

        @GuardedBy("this")
        private ReferenceEntry<K, V> m1214a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference valueReference = referenceEntry.getValueReference();
            Object obj = valueReference.get();
            if (obj == null && valueReference.mo134d()) {
                return null;
            }
            ReferenceEntry<K, V> copyEntry = this.map.f589r.copyEntry(this, referenceEntry, referenceEntry2);
            copyEntry.setValueReference(valueReference.mo130a(this.valueReferenceQueue, obj, copyEntry));
            return copyEntry;
        }

        @GuardedBy("this")
        private void m1227a(ReferenceEntry<K, V> referenceEntry, K k, V v, long j) {
            ValueReference valueReference = referenceEntry.getValueReference();
            int weigh = this.map.f582k.weigh(k, v);
            Preconditions.checkState(weigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.f580i.referenceValue(this, referenceEntry, v, weigh));
            m1225a((ReferenceEntry) referenceEntry, weigh, j);
            valueReference.mo131a(v);
        }

        final V m1250a(K k, int i, CacheLoader<? super K, V> cacheLoader) {
            Preconditions.checkNotNull(k);
            Preconditions.checkNotNull(cacheLoader);
            try {
                V a;
                if (this.count != 0) {
                    ReferenceEntry d = m1239d(k, i);
                    if (d != null) {
                        long read = this.map.f588q.read();
                        Object a2 = m1248a(d, read);
                        if (a2 != null) {
                            m1237b(d, read);
                            this.statsCounter.mo120a(1);
                            a = m1218a(d, (Object) k, i, a2, read, (CacheLoader) cacheLoader);
                            m1258b();
                        } else {
                            ValueReference valueReference = d.getValueReference();
                            if (valueReference.mo133c()) {
                                a = m1219a(d, (Object) k, valueReference);
                                m1258b();
                            }
                        }
                        return a;
                    }
                }
                a = m1234b((Object) k, i, (CacheLoader) cacheLoader);
                m1258b();
                return a;
            } catch (ExecutionException e) {
                ExecutionException executionException = e;
                Throwable cause = executionException.getCause();
                if (cause instanceof Error) {
                    throw new ExecutionError((Error) cause);
                } else if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                } else {
                    throw executionException;
                }
            } catch (Throwable th) {
                m1258b();
            }
        }

        private V m1234b(K k, int i, CacheLoader<? super K, V> cacheLoader) {
            lock();
            try {
                Object obj;
                ValueReference valueReference;
                int i2;
                ValueReference loadingValueReference;
                LoadingValueReference loadingValueReference2;
                ValueReference valueReference2;
                V a;
                long read = this.map.f588q.read();
                m1241d(read);
                int i3 = this.count - 1;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.f577f.equivalent(k, key)) {
                        ValueReference valueReference3 = referenceEntry2.getValueReference();
                        if (valueReference3.mo133c()) {
                            obj = null;
                            valueReference = valueReference3;
                        } else {
                            V v = valueReference3.get();
                            if (v == null) {
                                m1228a(key, valueReference3, RemovalCause.COLLECTED);
                            } else if (this.map.m1190b(referenceEntry2, read)) {
                                m1228a(key, valueReference3, RemovalCause.EXPIRED);
                            } else {
                                m1238c(referenceEntry2, read);
                                this.statsCounter.mo120a(1);
                                unlock();
                                m1247o();
                                return v;
                            }
                            this.writeQueue.remove(referenceEntry2);
                            this.accessQueue.remove(referenceEntry2);
                            this.count = i3;
                            i2 = 1;
                            valueReference = valueReference3;
                        }
                        if (obj == null) {
                            loadingValueReference = new LoadingValueReference();
                            if (referenceEntry2 != null) {
                                referenceEntry = m1217a((Object) k, i, referenceEntry);
                                referenceEntry.setValueReference(loadingValueReference);
                                atomicReferenceArray.set(length, referenceEntry);
                                loadingValueReference2 = loadingValueReference;
                            } else {
                                referenceEntry2.setValueReference(loadingValueReference);
                                referenceEntry = referenceEntry2;
                                valueReference2 = loadingValueReference;
                            }
                        } else {
                            referenceEntry = referenceEntry2;
                            loadingValueReference2 = null;
                        }
                        unlock();
                        m1247o();
                        if (obj != null) {
                            return m1219a(referenceEntry, (Object) k, valueReference);
                        }
                        try {
                            synchronized (referenceEntry) {
                                a = m1221a((Object) k, i, loadingValueReference2, (CacheLoader) cacheLoader);
                            }
                            return a;
                        } finally {
                            a = this.statsCounter;
                            a.mo122b(1);
                        }
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                valueReference = null;
                i2 = 1;
                if (obj == null) {
                    referenceEntry = referenceEntry2;
                    loadingValueReference2 = null;
                } else {
                    loadingValueReference = new LoadingValueReference();
                    if (referenceEntry2 != null) {
                        referenceEntry2.setValueReference(loadingValueReference);
                        referenceEntry = referenceEntry2;
                        valueReference2 = loadingValueReference;
                    } else {
                        referenceEntry = m1217a((Object) k, i, referenceEntry);
                        referenceEntry.setValueReference(loadingValueReference);
                        atomicReferenceArray.set(length, referenceEntry);
                        loadingValueReference2 = loadingValueReference;
                    }
                }
                unlock();
                m1247o();
                if (obj != null) {
                    return m1219a(referenceEntry, (Object) k, valueReference);
                }
                synchronized (referenceEntry) {
                    a = m1221a((Object) k, i, loadingValueReference2, (CacheLoader) cacheLoader);
                }
                return a;
            } catch (Throwable th) {
                unlock();
                m1247o();
            }
        }

        private V m1219a(ReferenceEntry<K, V> referenceEntry, K k, ValueReference<K, V> valueReference) {
            if (valueReference.mo133c()) {
                Preconditions.checkState(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", k);
                try {
                    V e = valueReference.mo135e();
                    if (e == null) {
                        throw new InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                    }
                    m1237b((ReferenceEntry) referenceEntry, this.map.f588q.read());
                    return e;
                } finally {
                    this.statsCounter.mo122b(1);
                }
            } else {
                throw new AssertionError();
            }
        }

        private V m1221a(K k, int i, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) {
            return m1251a((Object) k, i, (LoadingValueReference) loadingValueReference, loadingValueReference.m1537a(k, cacheLoader));
        }

        private ListenableFuture<V> m1233b(K k, int i, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) {
            ListenableFuture<V> a = loadingValueReference.m1537a(k, cacheLoader);
            a.mo223a(new 1(this, k, i, loadingValueReference, a), DirectExecutor.INSTANCE);
            return a;
        }

        final V m1251a(K k, int i, LoadingValueReference<K, V> loadingValueReference, ListenableFuture<V> listenableFuture) {
            V v = null;
            try {
                v = Uninterruptibles.m1584a((Future) listenableFuture);
                if (v == null) {
                    throw new InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                }
                this.statsCounter.mo121a(loadingValueReference.m1545f());
                m1231a((Object) k, i, (LoadingValueReference) loadingValueReference, (Object) v);
                return v;
            } finally {
                if (v == null) {
                    v = this.statsCounter;
                    v.mo123b(loadingValueReference.m1545f());
                    m1230a((Object) k, i, (LoadingValueReference) loadingValueReference);
                }
            }
        }

        private V m1218a(ReferenceEntry<K, V> referenceEntry, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            if (!this.map.m1191c() || j - referenceEntry.getWriteTime() <= this.map.f585n || referenceEntry.getValueReference().mo133c()) {
                return v;
            }
            V a = m1220a((Object) k, i, (CacheLoader) cacheLoader, true);
            if (a != null) {
                return a;
            }
            return v;
        }

        @Nullable
        private V m1220a(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            V v = null;
            LoadingValueReference a = m1213a((Object) k, i, z);
            if (a != null) {
                Future b = m1233b(k, i, a, cacheLoader);
                if (b.isDone()) {
                    try {
                        v = Uninterruptibles.m1584a(b);
                    } catch (Throwable th) {
                    }
                }
            }
            return v;
        }

        @Nullable
        private LoadingValueReference<K, V> m1213a(K k, int i, boolean z) {
            lock();
            try {
                long read = this.map.f588q.read();
                m1241d(read);
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.f577f.equivalent(k, key)) {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        if (valueReference.mo133c() || (z && read - referenceEntry2.getWriteTime() < this.map.f585n)) {
                            unlock();
                            m1247o();
                            return null;
                        }
                        this.modCount++;
                        LoadingValueReference<K, V> loadingValueReference = new LoadingValueReference(valueReference);
                        referenceEntry2.setValueReference(loadingValueReference);
                        unlock();
                        m1247o();
                        return loadingValueReference;
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
                this.modCount++;
                ValueReference loadingValueReference2 = new LoadingValueReference();
                referenceEntry = m1217a((Object) k, i, referenceEntry);
                referenceEntry.setValueReference(loadingValueReference2);
                atomicReferenceArray.set(length, referenceEntry);
                unlock();
                m1247o();
                return loadingValueReference2;
            } catch (Throwable th) {
                unlock();
                m1247o();
            }
        }

        private void m1240d() {
            if (tryLock()) {
                try {
                    m1242e();
                } finally {
                    unlock();
                }
            }
        }

        @GuardedBy("this")
        private void m1242e() {
            int i;
            Reference poll;
            int i2;
            if (this.map.m1196h()) {
                i = 0;
                while (true) {
                    poll = this.keyReferenceQueue.poll();
                    if (poll == null) {
                        break;
                    }
                    this.map.m1186a((ReferenceEntry) poll);
                    i2 = i + 1;
                    if (i2 == 16) {
                        break;
                    }
                    i = i2;
                }
            }
            if (this.map.m1197i()) {
                i = 0;
                while (true) {
                    poll = this.valueReferenceQueue.poll();
                    if (poll != null) {
                        this.map.m1187a((ValueReference) poll);
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

        private void m1243h() {
            if (this.map.m1196h()) {
                do {
                } while (this.keyReferenceQueue.poll() != null);
            }
            if (this.map.m1197i()) {
                do {
                } while (this.valueReferenceQueue.poll() != null);
            }
        }

        private void m1237b(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.m1195g()) {
                referenceEntry.setAccessTime(j);
            }
            this.recencyQueue.add(referenceEntry);
        }

        @GuardedBy("this")
        private void m1238c(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.m1195g()) {
                referenceEntry.setAccessTime(j);
            }
            this.accessQueue.add(referenceEntry);
        }

        @GuardedBy("this")
        private void m1225a(ReferenceEntry<K, V> referenceEntry, int i, long j) {
            m1244k();
            this.totalWeight += (long) i;
            if (this.map.m1195g()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.map.m1194f()) {
                referenceEntry.setWriteTime(j);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        @GuardedBy("this")
        private void m1244k() {
            while (true) {
                ReferenceEntry referenceEntry = (ReferenceEntry) this.recencyQueue.poll();
                if (referenceEntry == null) {
                    return;
                }
                if (this.accessQueue.contains(referenceEntry)) {
                    this.accessQueue.add(referenceEntry);
                }
            }
        }

        private void m1223a(long j) {
            if (tryLock()) {
                try {
                    m1235b(j);
                } finally {
                    unlock();
                }
            }
        }

        @GuardedBy("this")
        private void m1235b(long j) {
            m1244k();
            ReferenceEntry referenceEntry;
            do {
                referenceEntry = (ReferenceEntry) this.writeQueue.peek();
                if (referenceEntry == null || !this.map.m1190b(referenceEntry, j)) {
                    do {
                        referenceEntry = (ReferenceEntry) this.accessQueue.peek();
                        if (referenceEntry == null || !this.map.m1190b(referenceEntry, j)) {
                            return;
                        }
                    } while (m1229a(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (m1229a(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        @GuardedBy("this")
        private void m1226a(ReferenceEntry<K, V> referenceEntry, RemovalCause removalCause) {
            Object key = referenceEntry.getKey();
            referenceEntry.getHash();
            m1228a(key, referenceEntry.getValueReference(), removalCause);
        }

        @GuardedBy("this")
        private void m1228a(@Nullable K k, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            this.totalWeight -= (long) valueReference.mo129a();
            if (removalCause.wasEvicted()) {
                this.statsCounter.mo119a();
            }
            if (this.map.f586o != LocalCache.f572v) {
                this.map.f586o.offer(new RemovalNotification(k, valueReference.get(), removalCause));
            }
        }

        @GuardedBy("this")
        private void m1224a(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.m1188a()) {
                m1244k();
                if (((long) referenceEntry.getValueReference().mo129a()) <= this.maxSegmentWeight || m1229a((ReferenceEntry) referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    while (this.totalWeight > this.maxSegmentWeight) {
                        ReferenceEntry l = m1245l();
                        if (!m1229a(l, l.getHash(), RemovalCause.SIZE)) {
                            throw new AssertionError();
                        }
                    }
                    return;
                }
                throw new AssertionError();
            }
        }

        @GuardedBy("this")
        private ReferenceEntry<K, V> m1245l() {
            for (ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().mo129a() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        @Nullable
        private ReferenceEntry<K, V> m1239d(Object obj, int i) {
            AtomicReferenceArray atomicReferenceArray = this.table;
            for (ReferenceEntry<K, V> referenceEntry = (ReferenceEntry) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                if (referenceEntry.getHash() == i) {
                    Object key = referenceEntry.getKey();
                    if (key == null) {
                        m1240d();
                    } else if (this.map.f577f.equivalent(obj, key)) {
                        return referenceEntry;
                    }
                }
            }
            return null;
        }

        @Nullable
        private ReferenceEntry<K, V> m1216a(Object obj, int i, long j) {
            ReferenceEntry<K, V> d = m1239d(obj, i);
            if (d == null) {
                return null;
            }
            if (!this.map.m1190b((ReferenceEntry) d, j)) {
                return d;
            }
            m1223a(j);
            return null;
        }

        final V m1248a(ReferenceEntry<K, V> referenceEntry, long j) {
            if (referenceEntry.getKey() == null) {
                m1240d();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                m1240d();
                return null;
            } else if (!this.map.m1190b((ReferenceEntry) referenceEntry, j)) {
                return v;
            } else {
                m1223a(j);
                return null;
            }
        }

        @Nullable
        final V m1249a(Object obj, int i) {
            V v = null;
            try {
                if (this.count != 0) {
                    long read = this.map.f588q.read();
                    ReferenceEntry a = m1216a(obj, i, read);
                    if (a != null) {
                        Object obj2 = a.getValueReference().get();
                        if (obj2 != null) {
                            m1237b(a, read);
                            v = m1218a(a, a.getKey(), i, obj2, read, this.map.f591t);
                            m1258b();
                        } else {
                            m1240d();
                        }
                    }
                    return v;
                }
                m1258b();
                return v;
            } finally {
                m1258b();
            }
        }

        final boolean m1259b(Object obj, int i) {
            boolean z = false;
            try {
                if (this.count != 0) {
                    ReferenceEntry a = m1216a(obj, i, this.map.f588q.read());
                    if (a != null) {
                        if (a.getValueReference().get() != null) {
                            z = true;
                        }
                        m1258b();
                    }
                } else {
                    m1258b();
                }
                return z;
            } finally {
                m1258b();
            }
        }

        @Nullable
        final V m1253a(K k, int i, V v, boolean z) {
            lock();
            try {
                int i2;
                ReferenceEntry referenceEntry;
                long read = this.map.f588q.read();
                m1241d(read);
                if (this.count + 1 > this.threshold) {
                    m1246m();
                    i2 = this.count;
                }
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
                for (referenceEntry = referenceEntry2; referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                    Object key = referenceEntry.getKey();
                    if (referenceEntry.getHash() == i && key != null && this.map.f577f.equivalent(k, key)) {
                        ValueReference valueReference = referenceEntry.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 == null) {
                            this.modCount++;
                            if (valueReference.mo134d()) {
                                m1228a((Object) k, valueReference, RemovalCause.COLLECTED);
                                m1227a(referenceEntry, (Object) k, (Object) v, read);
                                i2 = this.count;
                            } else {
                                m1227a(referenceEntry, (Object) k, (Object) v, read);
                                i2 = this.count + 1;
                            }
                            this.count = i2;
                            m1224a(referenceEntry);
                            return null;
                        } else if (z) {
                            m1238c(referenceEntry, read);
                            unlock();
                            m1247o();
                            return v2;
                        } else {
                            this.modCount++;
                            m1228a((Object) k, valueReference, RemovalCause.REPLACED);
                            m1227a(referenceEntry, (Object) k, (Object) v, read);
                            m1224a(referenceEntry);
                            unlock();
                            m1247o();
                            return v2;
                        }
                    }
                }
                this.modCount++;
                referenceEntry = m1217a((Object) k, i, referenceEntry2);
                m1227a(referenceEntry, (Object) k, (Object) v, read);
                atomicReferenceArray.set(length, referenceEntry);
                this.count++;
                m1224a(referenceEntry);
                unlock();
                m1247o();
                return null;
            } finally {
                unlock();
                m1247o();
            }
        }

        @GuardedBy("this")
        private void m1246m() {
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.count;
                AtomicReferenceArray a = m1222a(length << 1);
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
                                referenceEntry = m1214a(referenceEntry2, (ReferenceEntry) a.get(hash2));
                                if (referenceEntry != null) {
                                    a.set(hash2, referenceEntry);
                                    i4 = i3;
                                } else {
                                    m1236b(referenceEntry2);
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

        final boolean m1257a(K k, int i, V v, V v2) {
            lock();
            try {
                long read = this.map.f588q.read();
                m1241d(read);
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.f577f.equivalent(k, key)) {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        Object obj = valueReference.get();
                        if (obj == null) {
                            if (valueReference.mo134d()) {
                                int i2 = this.count;
                                this.modCount++;
                                ReferenceEntry a = m1215a(referenceEntry, referenceEntry2, key, i, valueReference, RemovalCause.COLLECTED);
                                int i3 = this.count - 1;
                                atomicReferenceArray.set(length, a);
                                this.count = i3;
                            }
                            unlock();
                            m1247o();
                            return false;
                        } else if (this.map.f578g.equivalent(v, obj)) {
                            this.modCount++;
                            m1228a((Object) k, valueReference, RemovalCause.REPLACED);
                            m1227a(referenceEntry2, (Object) k, (Object) v2, read);
                            m1224a(referenceEntry2);
                            unlock();
                            m1247o();
                            return true;
                        } else {
                            m1238c(referenceEntry2, read);
                            unlock();
                            m1247o();
                            return false;
                        }
                    }
                }
                unlock();
                m1247o();
                return false;
            } catch (Throwable th) {
                unlock();
                m1247o();
            }
        }

        @Nullable
        final V m1252a(K k, int i, V v) {
            lock();
            try {
                long read = this.map.f588q.read();
                m1241d(read);
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.f577f.equivalent(k, key)) {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 == null) {
                            if (valueReference.mo134d()) {
                                int i2 = this.count;
                                this.modCount++;
                                ReferenceEntry a = m1215a(referenceEntry, referenceEntry2, key, i, valueReference, RemovalCause.COLLECTED);
                                int i3 = this.count - 1;
                                atomicReferenceArray.set(length, a);
                                this.count = i3;
                            }
                            unlock();
                            m1247o();
                            return null;
                        }
                        this.modCount++;
                        m1228a((Object) k, valueReference, RemovalCause.REPLACED);
                        m1227a(referenceEntry2, (Object) k, (Object) v, read);
                        m1224a(referenceEntry2);
                        unlock();
                        m1247o();
                        return v2;
                    }
                }
                unlock();
                m1247o();
                return null;
            } catch (Throwable th) {
                unlock();
                m1247o();
            }
        }

        @Nullable
        final V m1261c(Object obj, int i) {
            lock();
            try {
                m1241d(this.map.f588q.read());
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.f577f.equivalent(obj, key)) {
                        RemovalCause removalCause;
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        V v = valueReference.get();
                        if (v != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (valueReference.mo134d()) {
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            unlock();
                            m1247o();
                            return null;
                        }
                        this.modCount++;
                        ReferenceEntry a = m1215a(referenceEntry, referenceEntry2, key, i, valueReference, removalCause);
                        i2 = this.count - 1;
                        atomicReferenceArray.set(length, a);
                        this.count = i2;
                        return v;
                    }
                }
                unlock();
                m1247o();
                return null;
            } finally {
                unlock();
                m1247o();
            }
        }

        private boolean m1231a(K k, int i, LoadingValueReference<K, V> loadingValueReference, V v) {
            lock();
            try {
                ReferenceEntry referenceEntry;
                long read = this.map.f588q.read();
                m1241d(read);
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    m1246m();
                    i2 = this.count + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
                for (referenceEntry = referenceEntry2; referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                    Object key = referenceEntry.getKey();
                    if (referenceEntry.getHash() == i && key != null && this.map.f577f.equivalent(k, key)) {
                        ValueReference valueReference = referenceEntry.getValueReference();
                        key = valueReference.get();
                        if (loadingValueReference == valueReference || (key == null && valueReference != LocalCache.f571u)) {
                            this.modCount++;
                            if (loadingValueReference.mo134d()) {
                                m1228a((Object) k, (ValueReference) loadingValueReference, key == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                                i2--;
                            }
                            m1227a(referenceEntry, (Object) k, (Object) v, read);
                            this.count = i2;
                            m1224a(referenceEntry);
                            return true;
                        }
                        m1228a((Object) k, new WeightedStrongValueReference(v, 0), RemovalCause.REPLACED);
                        unlock();
                        m1247o();
                        return false;
                    }
                }
                this.modCount++;
                referenceEntry = m1217a((Object) k, i, referenceEntry2);
                m1227a(referenceEntry, (Object) k, (Object) v, read);
                atomicReferenceArray.set(length, referenceEntry);
                this.count = i2;
                m1224a(referenceEntry);
                unlock();
                m1247o();
                return true;
            } finally {
                unlock();
                m1247o();
            }
        }

        final boolean m1260b(Object obj, int i, Object obj2) {
            lock();
            try {
                m1241d(this.map.f588q.read());
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.f577f.equivalent(obj, key)) {
                        RemovalCause removalCause;
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        Object obj3 = valueReference.get();
                        if (this.map.f578g.equivalent(obj2, obj3)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (obj3 == null && valueReference.mo134d()) {
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            unlock();
                            m1247o();
                            return false;
                        }
                        this.modCount++;
                        ReferenceEntry a = m1215a(referenceEntry, referenceEntry2, key, i, valueReference, removalCause);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, a);
                        this.count = i3;
                        boolean z = removalCause == RemovalCause.EXPLICIT;
                        unlock();
                        m1247o();
                        return z;
                    }
                }
                unlock();
                m1247o();
                return false;
            } catch (Throwable th) {
                unlock();
                m1247o();
            }
        }

        final void m1254a() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (referenceEntry.getValueReference().mo134d()) {
                                m1226a(referenceEntry, RemovalCause.EXPLICIT);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    m1243h();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    m1247o();
                }
            }
        }

        @GuardedBy("this")
        @Nullable
        private ReferenceEntry<K, V> m1215a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, @Nullable K k, int i, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            m1228a((Object) k, (ValueReference) valueReference, removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (!valueReference.mo133c()) {
                return m1232b((ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
            }
            valueReference.mo131a(null);
            return referenceEntry;
        }

        @GuardedBy("this")
        @Nullable
        private ReferenceEntry<K, V> m1232b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            ReferenceEntry next2;
            while (next2 != referenceEntry2) {
                int i2;
                ReferenceEntry<K, V> a = m1214a(next2, (ReferenceEntry) next);
                if (a != null) {
                    i2 = i;
                } else {
                    m1236b(next2);
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

        @GuardedBy("this")
        private void m1236b(ReferenceEntry<K, V> referenceEntry) {
            m1226a((ReferenceEntry) referenceEntry, RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        final boolean m1255a(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount++;
                        ReferenceEntry a = m1215a(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference(), RemovalCause.COLLECTED);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, a);
                        this.count = i3;
                        return true;
                    }
                }
                unlock();
                m1247o();
                return false;
            } finally {
                unlock();
                m1247o();
            }
        }

        final boolean m1256a(K k, int i, ValueReference<K, V> valueReference) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.f577f.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == valueReference) {
                        this.modCount++;
                        ReferenceEntry a = m1215a(referenceEntry, referenceEntry2, key, i, (ValueReference) valueReference, RemovalCause.COLLECTED);
                        i2 = this.count - 1;
                        atomicReferenceArray.set(length, a);
                        this.count = i2;
                        return true;
                    } else {
                        unlock();
                        if (isHeldByCurrentThread()) {
                            return false;
                        }
                        m1247o();
                        return false;
                    }
                }
                unlock();
                if (isHeldByCurrentThread()) {
                    return false;
                }
                m1247o();
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    m1247o();
                }
            }
        }

        private boolean m1230a(K k, int i, LoadingValueReference<K, V> loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.f577f.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == loadingValueReference) {
                        if (loadingValueReference.mo134d()) {
                            referenceEntry2.setValueReference(loadingValueReference.m1546g());
                        } else {
                            atomicReferenceArray.set(length, m1232b(referenceEntry, referenceEntry2));
                        }
                        unlock();
                        m1247o();
                        return true;
                    } else {
                        unlock();
                        m1247o();
                        return false;
                    }
                }
                unlock();
                m1247o();
                return false;
            } catch (Throwable th) {
                unlock();
                m1247o();
            }
        }

        @GuardedBy("this")
        private boolean m1229a(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            int i2 = this.count;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    ReferenceEntry a = m1215a(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference(), removalCause);
                    int i3 = this.count - 1;
                    atomicReferenceArray.set(length, a);
                    this.count = i3;
                    return true;
                }
            }
            return false;
        }

        final void m1258b() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                m1262c();
            }
        }

        public final void m1262c() {
            m1241d(this.map.f588q.read());
            m1247o();
        }

        private void m1241d(long j) {
            if (tryLock()) {
                try {
                    m1242e();
                    m1235b(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        private void m1247o() {
            if (!isHeldByCurrentThread()) {
                this.map.m1198m();
            }
        }
    }

    /* compiled from: zeroOptoutParams */
    final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> f595a = new C00391(this);

        /* compiled from: zeroOptoutParams */
        class C00391 extends AbstractReferenceEntry<K, V> {
            ReferenceEntry<K, V> f596a = this;
            ReferenceEntry<K, V> f597b = this;
            final /* synthetic */ AccessQueue f598c;

            C00391(AccessQueue accessQueue) {
                this.f598c = accessQueue;
            }

            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            public void setAccessTime(long j) {
            }

            public ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.f596a;
            }

            public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.f596a = referenceEntry;
            }

            public ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.f597b;
            }

            public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.f597b = referenceEntry;
            }
        }

        AccessQueue() {
        }

        public final boolean offer(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            LocalCache.m1170a(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.m1170a(this.f595a.getPreviousInAccessQueue(), referenceEntry);
            LocalCache.m1170a(referenceEntry, this.f595a);
            return true;
        }

        public final /* synthetic */ Object peek() {
            return m1263a();
        }

        private ReferenceEntry<K, V> m1263a() {
            ReferenceEntry<K, V> nextInAccessQueue = this.f595a.getNextInAccessQueue();
            return nextInAccessQueue == this.f595a ? null : nextInAccessQueue;
        }

        public final Object poll() {
            ReferenceEntry nextInAccessQueue = this.f595a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f595a) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        public final boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.m1170a(previousInAccessQueue, nextInAccessQueue);
            LocalCache.m1173b(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        public final boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        public final boolean isEmpty() {
            return this.f595a.getNextInAccessQueue() == this.f595a;
        }

        public final int size() {
            int i = 0;
            for (ReferenceEntry nextInAccessQueue = this.f595a.getNextInAccessQueue(); nextInAccessQueue != this.f595a; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }

        public final void clear() {
            ReferenceEntry nextInAccessQueue = this.f595a.getNextInAccessQueue();
            while (nextInAccessQueue != this.f595a) {
                ReferenceEntry nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                LocalCache.m1173b(nextInAccessQueue);
                nextInAccessQueue = nextInAccessQueue2;
            }
            this.f595a.setNextInAccessQueue(this.f595a);
            this.f595a.setPreviousInAccessQueue(this.f595a);
        }

        public final Iterator<ReferenceEntry<K, V>> iterator() {
            return new 2(this, m1263a());
        }
    }

    /* compiled from: zeroOptoutParams */
    abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        public int getHash() {
            throw new UnsupportedOperationException();
        }

        public K getKey() {
            throw new UnsupportedOperationException();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: zeroOptoutParams */
    public interface ReferenceEntry<K, V> {
        long getAccessTime();

        int getHash();

        @Nullable
        K getKey();

        @Nullable
        ReferenceEntry<K, V> getNext();

        ReferenceEntry<K, V> getNextInAccessQueue();

        ReferenceEntry<K, V> getNextInWriteQueue();

        ReferenceEntry<K, V> getPreviousInAccessQueue();

        ReferenceEntry<K, V> getPreviousInWriteQueue();

        ValueReference<K, V> getValueReference();

        long getWriteTime();

        void setAccessTime(long j);

        void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry);

        void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry);

        void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry);

        void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry);

        void setValueReference(ValueReference<K, V> valueReference);

        void setWriteTime(long j);
    }

    /* compiled from: zeroOptoutParams */
    class LoadingValueReference<K, V> implements ValueReference<K, V> {
        volatile ValueReference<K, V> f777a;
        final SettableFuture<V> f778b;
        final Stopwatch f779c;

        public LoadingValueReference() {
            this(LocalCache.f571u);
        }

        public LoadingValueReference(ValueReference<K, V> valueReference) {
            this.f778b = SettableFuture.m1547f();
            this.f779c = Stopwatch.createUnstarted();
            this.f777a = valueReference;
        }

        public final boolean mo133c() {
            return true;
        }

        public final boolean mo134d() {
            return this.f777a.mo134d();
        }

        public final int mo129a() {
            return this.f777a.mo129a();
        }

        public final boolean m1541b(@Nullable V v) {
            return FutureDetour.a(this.f778b, v, 1469579062);
        }

        public final boolean m1539a(Throwable th) {
            return this.f778b.mo222a(th);
        }

        public final void mo131a(@Nullable V v) {
            if (v != null) {
                m1541b(v);
            } else {
                this.f777a = LocalCache.f571u;
            }
        }

        public final ListenableFuture<V> m1537a(K k, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.f779c.start();
                Object obj = this.f777a.get();
                if (obj == null) {
                    obj = cacheLoader.mo118a(k);
                    if (m1541b(obj)) {
                        return this.f778b;
                    }
                    return Futures.m2452a(obj);
                }
                ListenableFuture a = cacheLoader.m1117a(k, obj);
                if (a == null) {
                    return Futures.m2452a(null);
                }
                return Futures.m2449a(a, new 1(this));
            } catch (Throwable th) {
                Throwable th2 = th;
                ListenableFuture<V> a2 = m1539a(th2) ? this.f778b : Futures.m2453a(th2);
                if (!(th2 instanceof InterruptedException)) {
                    return a2;
                }
                Thread.currentThread().interrupt();
                return a2;
            }
        }

        public final long m1545f() {
            return this.f779c.elapsed(TimeUnit.NANOSECONDS);
        }

        public final V mo135e() {
            return Uninterruptibles.m1584a(this.f778b);
        }

        public V get() {
            return this.f777a.get();
        }

        public final ValueReference<K, V> m1546g() {
            return this.f777a;
        }

        public final ReferenceEntry<K, V> mo132b() {
            return null;
        }

        public final ValueReference<K, V> mo130a(ReferenceQueue<V> referenceQueue, @Nullable V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }
    }

    /* compiled from: zeroOptoutParams */
    final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        volatile long f805a = Long.MAX_VALUE;
        ReferenceEntry<K, V> f806b = NullEntry.INSTANCE;
        ReferenceEntry<K, V> f807c = NullEntry.INSTANCE;

        WeakAccessEntry(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public final long getAccessTime() {
            return this.f805a;
        }

        public final void setAccessTime(long j) {
            this.f805a = j;
        }

        public final ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f806b;
        }

        public final void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f806b = referenceEntry;
        }

        public final ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f807c;
        }

        public final void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f807c = referenceEntry;
        }
    }

    /* compiled from: zeroOptoutParams */
    class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int f808g;
        final ReferenceEntry<K, V> f809h;
        volatile ValueReference<K, V> f810i = LocalCache.f571u;

        WeakEntry(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.f808g = i;
            this.f809h = referenceEntry;
        }

        public K getKey() {
            return get();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ValueReference<K, V> getValueReference() {
            return this.f810i;
        }

        public void setValueReference(ValueReference<K, V> valueReference) {
            this.f810i = valueReference;
        }

        public int getHash() {
            return this.f808g;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.f809h;
        }
    }

    /* compiled from: zeroOptoutParams */
    public enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        public final ValueReference<Object, Object> getValueReference() {
            return null;
        }

        public final void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        public final ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        public final int getHash() {
            return 0;
        }

        public final Object getKey() {
            return null;
        }

        public final long getAccessTime() {
            return 0;
        }

        public final void setAccessTime(long j) {
        }

        public final ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        public final void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        public final void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final long getWriteTime() {
            return 0;
        }

        public final void setWriteTime(long j) {
        }

        public final ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        public final void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public final ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        public final void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }
    }

    /* compiled from: zeroOptoutParams */
    class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> f817a;

        WeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.f817a = referenceEntry;
        }

        public int mo129a() {
            return 1;
        }

        public final ReferenceEntry<K, V> mo132b() {
            return this.f817a;
        }

        public final void mo131a(V v) {
        }

        public ValueReference<K, V> mo130a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(referenceQueue, v, referenceEntry);
        }

        public final boolean mo133c() {
            return false;
        }

        public final boolean mo134d() {
            return true;
        }

        public final V mo135e() {
            return get();
        }
    }

    /* compiled from: zeroOptoutParams */
    final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> f23888a = new C09741(this);

        /* compiled from: zeroOptoutParams */
        class C09741 extends AbstractReferenceEntry<K, V> {
            ReferenceEntry<K, V> f23889a = this;
            ReferenceEntry<K, V> f23890b = this;
            final /* synthetic */ WriteQueue f23891c;

            C09741(WriteQueue writeQueue) {
                this.f23891c = writeQueue;
            }

            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            public void setWriteTime(long j) {
            }

            public ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.f23889a;
            }

            public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.f23889a = referenceEntry;
            }

            public ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.f23890b;
            }

            public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.f23890b = referenceEntry;
            }
        }

        WriteQueue() {
        }

        public final boolean offer(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            LocalCache.m1174b(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.m1174b(this.f23888a.getPreviousInWriteQueue(), referenceEntry);
            LocalCache.m1174b(referenceEntry, this.f23888a);
            return true;
        }

        public final /* synthetic */ Object peek() {
            return m32278a();
        }

        private ReferenceEntry<K, V> m32278a() {
            ReferenceEntry<K, V> nextInWriteQueue = this.f23888a.getNextInWriteQueue();
            return nextInWriteQueue == this.f23888a ? null : nextInWriteQueue;
        }

        public final Object poll() {
            ReferenceEntry nextInWriteQueue = this.f23888a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f23888a) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        public final boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.m1174b(previousInWriteQueue, nextInWriteQueue);
            LocalCache.m1176c(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        public final boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        public final boolean isEmpty() {
            return this.f23888a.getNextInWriteQueue() == this.f23888a;
        }

        public final int size() {
            int i = 0;
            for (ReferenceEntry nextInWriteQueue = this.f23888a.getNextInWriteQueue(); nextInWriteQueue != this.f23888a; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }

        public final void clear() {
            ReferenceEntry nextInWriteQueue = this.f23888a.getNextInWriteQueue();
            while (nextInWriteQueue != this.f23888a) {
                ReferenceEntry nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                LocalCache.m1176c(nextInWriteQueue);
                nextInWriteQueue = nextInWriteQueue2;
            }
            this.f23888a.setNextInWriteQueue(this.f23888a);
            this.f23888a.setPreviousInWriteQueue(this.f23888a);
        }

        public final Iterator<ReferenceEntry<K, V>> iterator() {
            return new 2(this, m32278a());
        }
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @Nullable CacheLoader<? super K, V> cacheLoader) {
        Queue queue;
        int i = 0;
        this.f576e = Math.min(cacheBuilder.m1135d(), 65536);
        this.f579h = cacheBuilder.m1139h();
        this.f580i = cacheBuilder.m1142k();
        this.f577f = cacheBuilder.m1120a();
        this.f578g = cacheBuilder.m1128b();
        this.f581j = cacheBuilder.m1136e();
        this.f582k = cacheBuilder.m1137f();
        this.f583l = cacheBuilder.m1144m();
        this.f584m = cacheBuilder.m1143l();
        this.f585n = cacheBuilder.m1145n();
        this.f587p = cacheBuilder.m1146o();
        if (this.f587p == NullListener.INSTANCE) {
            queue = f572v;
        } else {
            queue = new ConcurrentLinkedQueue();
        }
        this.f586o = queue;
        this.f588q = cacheBuilder.m1121a(m1180q());
        this.f589r = EntryFactory.getFactory(this.f579h, m1182s(), m1181r());
        this.f590s = (AbstractCache$StatsCounter) cacheBuilder.m1147p().get();
        this.f591t = cacheLoader;
        int min = Math.min(cacheBuilder.m1134c(), 1073741824);
        if (m1188a() && !m1189b()) {
            min = Math.min(min, (int) this.f581j);
        }
        int i2 = 1;
        int i3 = 0;
        while (i2 < this.f576e && (!m1188a() || ((long) (i2 * 20)) <= this.f581j)) {
            i3++;
            i2 <<= 1;
        }
        this.f574c = 32 - i3;
        this.f573b = i2 - 1;
        this.f575d = m1177c(i2);
        i3 = min / i2;
        if (i3 * i2 < min) {
            min = i3 + 1;
        } else {
            min = i3;
        }
        int i4 = 1;
        while (i4 < min) {
            i4 <<= 1;
        }
        if (m1188a()) {
            long j = this.f581j % ((long) i2);
            long j2 = (this.f581j / ((long) i2)) + 1;
            while (i < this.f575d.length) {
                long j3;
                if (((long) i) == j) {
                    j3 = j2 - 1;
                } else {
                    j3 = j2;
                }
                this.f575d[i] = m1169a(i4, j3, (AbstractCache$StatsCounter) cacheBuilder.m1147p().get());
                i++;
                j2 = j3;
            }
            return;
        }
        while (i < this.f575d.length) {
            this.f575d[i] = m1169a(i4, -1, (AbstractCache$StatsCounter) cacheBuilder.m1147p().get());
            i++;
        }
    }

    final boolean m1188a() {
        return this.f581j >= 0;
    }

    public final boolean m1189b() {
        return this.f582k != OneWeigher.INSTANCE;
    }

    private boolean m1178o() {
        return this.f584m > 0;
    }

    private boolean m1179p() {
        return this.f583l > 0;
    }

    final boolean m1191c() {
        return this.f585n > 0;
    }

    final boolean m1192d() {
        return m1179p() || m1188a();
    }

    final boolean m1193e() {
        return m1178o();
    }

    final boolean m1194f() {
        return m1178o() || m1191c();
    }

    final boolean m1195g() {
        return m1179p();
    }

    private boolean m1180q() {
        return m1194f() || m1195g();
    }

    private boolean m1181r() {
        return m1193e() || m1194f();
    }

    private boolean m1182s() {
        return m1192d() || m1195g();
    }

    final boolean m1196h() {
        return this.f579h != Strength.STRONG;
    }

    final boolean m1197i() {
        return this.f580i != Strength.STRONG;
    }

    static <K, V> void m1173b(ReferenceEntry<K, V> referenceEntry) {
        NullEntry nullEntry = NullEntry.INSTANCE;
        referenceEntry.setNextInAccessQueue(nullEntry);
        referenceEntry.setPreviousInAccessQueue(nullEntry);
    }

    static <K, V> void m1176c(ReferenceEntry<K, V> referenceEntry) {
        NullEntry nullEntry = NullEntry.INSTANCE;
        referenceEntry.setNextInWriteQueue(nullEntry);
        referenceEntry.setPreviousInWriteQueue(nullEntry);
    }

    private int m1175c(@Nullable Object obj) {
        int hash = this.f577f.hash(obj);
        int i = ((hash << 15) ^ -12931) + hash;
        i ^= i >>> 10;
        i += i << 3;
        i ^= i >>> 6;
        i += (i << 2) + (i << 14);
        return i ^ (i >>> 16);
    }

    public final void m1187a(ValueReference<K, V> valueReference) {
        ReferenceEntry b = valueReference.mo132b();
        int hash = b.getHash();
        m1171b(hash).m1256a(b.getKey(), hash, (ValueReference) valueReference);
    }

    public final void m1186a(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        m1171b(hash).m1255a((ReferenceEntry) referenceEntry, hash);
    }

    private Segment<K, V> m1171b(int i) {
        return this.f575d[(i >>> this.f574c) & this.f573b];
    }

    private Segment<K, V> m1169a(int i, long j, AbstractCache$StatsCounter abstractCache$StatsCounter) {
        return new Segment(this, i, j, abstractCache$StatsCounter);
    }

    @Nullable
    final V m1183a(ReferenceEntry<K, V> referenceEntry, long j) {
        if (referenceEntry.getKey() == null) {
            return null;
        }
        V v = referenceEntry.getValueReference().get();
        if (v == null || m1190b((ReferenceEntry) referenceEntry, j)) {
            return null;
        }
        return v;
    }

    final boolean m1190b(ReferenceEntry<K, V> referenceEntry, long j) {
        Preconditions.checkNotNull(referenceEntry);
        if (m1179p() && j - referenceEntry.getAccessTime() >= this.f583l) {
            return true;
        }
        if (!m1178o() || j - referenceEntry.getWriteTime() < this.f584m) {
            return false;
        }
        return true;
    }

    static <K, V> void m1170a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    static <K, V> void m1174b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    final void m1198m() {
        while (true) {
            RemovalNotification removalNotification = (RemovalNotification) this.f586o.poll();
            if (removalNotification != null) {
                try {
                    this.f587p.onRemoval(removalNotification);
                } catch (Throwable th) {
                    f570a.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    private static Segment<K, V>[] m1177c(int i) {
        return new Segment[i];
    }

    public boolean isEmpty() {
        int i;
        Segment[] segmentArr = this.f575d;
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
        for (Segment segment : this.f575d) {
            j += (long) Math.max(0, segment.count);
        }
        return Ints.m4489b(j);
    }

    @Nullable
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int c = m1175c(obj);
        return m1171b(c).m1249a(obj, c);
    }

    @Nullable
    public final V m1184a(Object obj) {
        int c = m1175c(Preconditions.checkNotNull(obj));
        V a = m1171b(c).m1249a(obj, c);
        if (a == null) {
            this.f590s.mo122b(1);
        } else {
            this.f590s.mo120a(1);
        }
        return a;
    }

    public final V m1185a(K k, CacheLoader<? super K, V> cacheLoader) {
        int c = m1175c(Preconditions.checkNotNull(k));
        return m1171b(c).m1250a((Object) k, c, (CacheLoader) cacheLoader);
    }

    public boolean containsKey(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        int c = m1175c(obj);
        return m1171b(c).m1259b(obj, c);
    }

    public boolean containsValue(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        long read = this.f588q.read();
        Segment[] segmentArr = this.f575d;
        int i = 0;
        long j = -1;
        while (i < 3) {
            long j2 = 0;
            for (Segment segment : segmentArr) {
                int i2 = segment.count;
                AtomicReferenceArray atomicReferenceArray = segment.table;
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i3); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                        Object a = segment.m1248a(referenceEntry, read);
                        if (a != null && this.f578g.equivalent(obj, a)) {
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
        int c = m1175c((Object) k);
        return m1171b(c).m1253a((Object) k, c, (Object) v, false);
    }

    public V putIfAbsent(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int c = m1175c((Object) k);
        return m1171b(c).m1253a((Object) k, c, (Object) v, true);
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
        int c = m1175c(obj);
        return m1171b(c).m1261c(obj, c);
    }

    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int c = m1175c(obj);
        return m1171b(c).m1260b(obj, c, obj2);
    }

    public boolean replace(K k, @Nullable V v, V v2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int c = m1175c((Object) k);
        return m1171b(c).m1257a((Object) k, c, (Object) v, (Object) v2);
    }

    public V replace(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int c = m1175c((Object) k);
        return m1171b(c).m1252a((Object) k, c, (Object) v);
    }

    public void clear() {
        for (Segment a : this.f575d) {
            a.m1254a();
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.f592w;
        if (set != null) {
            return set;
        }
        set = new KeySet(this, this);
        this.f592w = set;
        return set;
    }

    public Collection<V> values() {
        Collection<V> collection = this.f593x;
        if (collection != null) {
            return collection;
        }
        collection = new Values(this, this);
        this.f593x = collection;
        return collection;
    }

    @GwtIncompatible("Not supported.")
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.f594y;
        if (set != null) {
            return set;
        }
        set = new EntrySet(this, this);
        this.f594y = set;
        return set;
    }

    public static <E> ArrayList<E> m1172b(Collection<E> collection) {
        Collection arrayList = new ArrayList(collection.size());
        Iterators.m1411a(arrayList, collection.iterator());
        return arrayList;
    }
}
