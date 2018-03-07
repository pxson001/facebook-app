package com.facebook.messaging.threads.util;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.model.threads.ThreadSummaryByDateComparator;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/* compiled from: com.facebook.SessionState */
public class SmsMessengerThreadListMergeUtil {
    public static final Comparator<ThreadSummary> f17839a = new ThreadSummaryByDateComparator();
    private static final Comparator<PeekingIterator<ThreadSummary>> f17840b = new C21041();

    /* compiled from: com.facebook.SessionState */
    final class C21041 implements Comparator<PeekingIterator<ThreadSummary>> {
        C21041() {
        }

        public final int compare(Object obj, Object obj2) {
            PeekingIterator peekingIterator = (PeekingIterator) obj;
            PeekingIterator peekingIterator2 = (PeekingIterator) obj2;
            if (!peekingIterator.hasNext() && !peekingIterator2.hasNext()) {
                return 0;
            }
            if (!peekingIterator.hasNext()) {
                return 1;
            }
            if (peekingIterator2.hasNext()) {
                return SmsMessengerThreadListMergeUtil.f17839a.compare(peekingIterator.a(), peekingIterator2.a());
            }
            return -1;
        }
    }

    public static ThreadsCollection m17841a(Collection<ThreadsCollection> collection) {
        boolean z = false;
        Collection arrayList = new ArrayList();
        HashSet hashSet = new HashSet(collection.size());
        int i = 0;
        for (ThreadsCollection threadsCollection : collection) {
            ImmutableList immutableList = threadsCollection.c;
            arrayList.add(immutableList);
            i += immutableList.size();
            if (!(threadsCollection.d || immutableList.isEmpty())) {
                hashSet.add(((ThreadSummary) immutableList.get(immutableList.size() - 1)).a);
            }
        }
        ImmutableList a = m17842a(hashSet, arrayList);
        if (a.size() == i) {
            boolean z2;
            for (ThreadsCollection threadsCollection2 : collection) {
                if (!threadsCollection2.d) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            z = z2;
        }
        return new ThreadsCollection(a, z);
    }

    private static ImmutableList<ThreadSummary> m17842a(HashSet<ThreadKey> hashSet, Collection<ImmutableList<ThreadSummary>> collection) {
        int i = 0;
        PriorityQueue priorityQueue = new PriorityQueue(collection.size(), f17840b);
        ImmutableList<ThreadSummary> immutableList = null;
        ThreadSummary threadSummary = null;
        for (ImmutableList<ThreadSummary> immutableList2 : collection) {
            ImmutableList<ThreadSummary> immutableList22;
            ThreadSummary threadSummary2;
            if (immutableList22.isEmpty()) {
                immutableList22 = immutableList;
                threadSummary2 = threadSummary;
            } else if (immutableList22.size() == 1 && ThreadKey.e(((ThreadSummary) immutableList22.get(0)).a) && ((ThreadSummary) immutableList22.get(0)).k == -1) {
                threadSummary2 = (ThreadSummary) immutableList22.get(0);
            } else {
                priorityQueue.offer(Iterators.i(immutableList22.iterator()));
                threadSummary2 = threadSummary;
            }
            threadSummary = threadSummary2;
            immutableList = immutableList22;
        }
        if (priorityQueue.size() == 1 && immutableList != null && threadSummary == null) {
            return immutableList;
        }
        Builder builder = ImmutableList.builder();
        long j = 0;
        Object obj = null;
        while (!priorityQueue.isEmpty() && !hashSet.contains(r5)) {
            PeekingIterator peekingIterator = (PeekingIterator) priorityQueue.poll();
            threadSummary2 = (ThreadSummary) peekingIterator.next();
            builder.c(threadSummary2);
            i++;
            long j2 = threadSummary2.k;
            obj = threadSummary2.a;
            if (threadSummary == null || i != threadSummary.U - 1) {
                threadSummary2 = threadSummary;
            } else {
                builder.c(m17840a(threadSummary, j2));
                threadSummary2 = null;
            }
            if (peekingIterator.hasNext()) {
                priorityQueue.offer(peekingIterator);
            }
            threadSummary = threadSummary2;
            j = j2;
        }
        if (threadSummary != null) {
            builder.c(m17840a(threadSummary, j));
        }
        return builder.b();
    }

    private static ThreadSummary m17840a(ThreadSummary threadSummary, long j) {
        Preconditions.checkArgument(ThreadKey.e(threadSummary.a));
        ThreadSummaryBuilder a = ThreadSummary.newBuilder().a(threadSummary);
        a.k = j;
        a = a;
        a.K = j;
        a = a;
        a.l = j;
        return a.V();
    }
}
