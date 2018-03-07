package com.facebook.pager;

import com.facebook.pager.PagerViewController.C21281;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: cd */
public class PagerDataSetObservable<T> {
    protected final List<PagerDataSetObserver<T>> f18373a = Lists.a();

    public synchronized void mo714a(PagerDataSetObserver<T> pagerDataSetObserver) {
        this.f18373a.add(Preconditions.checkNotNull(pagerDataSetObserver));
    }

    public synchronized boolean mo716b(C21281 c21281) {
        return this.f18373a.remove(Preconditions.checkNotNull(c21281));
    }
}
