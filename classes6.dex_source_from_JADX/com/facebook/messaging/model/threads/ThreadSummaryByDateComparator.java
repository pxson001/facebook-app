package com.facebook.messaging.model.threads;

import com.google.common.base.Strings;
import java.util.Comparator;

/* compiled from: upcoming_invited_count */
public class ThreadSummaryByDateComparator implements Comparator<ThreadSummary> {
    public int compare(Object obj, Object obj2) {
        ThreadSummary threadSummary = (ThreadSummary) obj;
        ThreadSummary threadSummary2 = (ThreadSummary) obj2;
        if (threadSummary.f2329k > threadSummary2.f2329k) {
            return -1;
        }
        if (threadSummary2.f2329k > threadSummary.f2329k) {
            return 1;
        }
        return Strings.nullToEmpty(threadSummary.f2319a.toString()).compareTo(Strings.nullToEmpty(threadSummary2.f2319a.toString()));
    }
}
