package com.facebook.http.common;

import com.facebook.http.common.PriorityRequestQueue.Mutator;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: dominant_color */
class PriorityRequestEngine$AbortRequestsMutator implements Mutator {
    final /* synthetic */ PriorityRequestEngine f4940a;

    PriorityRequestEngine$AbortRequestsMutator(PriorityRequestEngine priorityRequestEngine) {
        this.f4940a = priorityRequestEngine;
    }

    public final void m9882a(List<PriorityRequestHolder> list, List<FbHttpRequest<?>> list2) {
        for (PriorityRequestHolder priorityRequestHolder : list) {
            this.f4940a.c.a(priorityRequestHolder.c);
            priorityRequestHolder.a.a(new IOException("Aborted request for: " + FbHttpUtils.m9866b(priorityRequestHolder.c)));
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            ((FbHttpRequest) it.next()).b.abort();
        }
    }
}
