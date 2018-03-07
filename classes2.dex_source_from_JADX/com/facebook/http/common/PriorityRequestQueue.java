package com.facebook.http.common;

import com.facebook.http.common.prioritization.FbHttpRequestComparator;
import com.facebook.http.common.prioritization.PolicyChecker;
import com.facebook.http.common.prioritization.PrioritizationPolicy;
import com.facebook.http.common.prioritization.UnblockableRequestChecker;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: readstamp */
public class PriorityRequestQueue {
    private final PolicyChecker f7921a;
    @GuardedBy("this")
    private final TreeSet<PriorityRequestHolder> f7922b;
    @GuardedBy("this")
    private final PriorityInflightRequests f7923c;
    @GuardedBy("this")
    private PrioritizationPolicy f7924d;

    /* compiled from: readstamp */
    public interface Mutator {
        void mo2700a(List<PriorityRequestHolder> list, List<FbHttpRequest<?>> list2);
    }

    @Inject
    public PriorityRequestQueue(PriorityInflightRequests priorityInflightRequests, PolicyChecker policyChecker, UnblockableRequestChecker unblockableRequestChecker, @Assisted PrioritizationPolicy prioritizationPolicy) {
        this.f7923c = priorityInflightRequests;
        this.f7921a = policyChecker;
        this.f7924d = prioritizationPolicy;
        this.f7922b = new TreeSet(new FbHttpRequestComparator(unblockableRequestChecker));
    }

    public final synchronized void m12507a(PrioritizationPolicy prioritizationPolicy) {
        this.f7924d = prioritizationPolicy;
        ObjectDetour.c(this, -312534015);
    }

    public final synchronized PrioritizationPolicy m12504a() {
        return this.f7924d;
    }

    public final synchronized void m12505a(PriorityRequestHolder priorityRequestHolder) {
        this.f7922b.add(priorityRequestHolder);
        ObjectDetour.c(this, -513570731);
    }

    public final synchronized PriorityRequestHolder m12503a(FbHttpRequest<?> fbHttpRequest) {
        PriorityRequestHolder priorityRequestHolder;
        Iterator it = this.f7922b.iterator();
        while (it.hasNext()) {
            priorityRequestHolder = (PriorityRequestHolder) it.next();
            if (priorityRequestHolder.f11888c == fbHttpRequest) {
                it.remove();
                break;
            }
        }
        priorityRequestHolder = null;
        return priorityRequestHolder;
    }

    public final synchronized PriorityRequestHolder m12508b() {
        PriorityRequestHolder d;
        while (true) {
            d = m12502d();
            if (d == null) {
                ObjectDetour.a(this, 1701799169);
            } else {
                this.f7922b.remove(d);
                this.f7923c.m12513a(d.f11888c);
            }
        }
        return d;
    }

    public final synchronized void m12509b(PriorityRequestHolder priorityRequestHolder) {
        this.f7923c.m12515b(priorityRequestHolder.f11888c);
    }

    public final synchronized RequestProcessorSnapshot m12510c() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f7922b.iterator();
        while (it.hasNext()) {
            arrayList.add(((PriorityRequestHolder) it.next()).f11888c);
        }
        return new RequestProcessorSnapshot(this.f7923c.m12516c(), arrayList);
    }

    public final synchronized void m12506a(Mutator mutator) {
        mutator.mo2700a(Lists.m1298a(this.f7922b), this.f7923c.m12516c());
    }

    private synchronized PriorityRequestHolder m12502d() {
        PriorityRequestHolder priorityRequestHolder;
        Iterator it = this.f7922b.iterator();
        while (it.hasNext()) {
            priorityRequestHolder = (PriorityRequestHolder) it.next();
            if (this.f7921a.m12529a(priorityRequestHolder, this.f7923c, this.f7924d)) {
                break;
            }
        }
        priorityRequestHolder = null;
        return priorityRequestHolder;
    }
}
