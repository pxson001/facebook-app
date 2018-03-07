package com.facebook.feed.rows.core.preparer;

import com.facebook.common.executors.IncrementalRunnable;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.feed.rows.core.AdaptersCollection;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.qe.RangePreparerExperimentHelper;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: fetch_zero_token_not_bootstrap */
public class RangeAdapterPreparer<T> implements AdapterPreparer {
    public int f23799a;
    public final AdaptersCollection<T> f23800b;
    private final DefaultProcessIdleExecutor f23801c;
    public final ScrollingViewProxy f23802d;
    private final int f23803e;
    private PrepareTask f23804f;
    public int f23805g = 0;
    public int f23806h = 1;
    public int f23807i = 0;
    public boolean f23808j = true;

    /* compiled from: fetch_zero_token_not_bootstrap */
    class PrepareTask extends IncrementalRunnable {
        final /* synthetic */ RangeAdapterPreparer f23810a;
        private final RangeAdapterPreparer f23811b;

        public PrepareTask(RangeAdapterPreparer rangeAdapterPreparer, RangeAdapterPreparer rangeAdapterPreparer2, ExecutorService executorService) {
            this.f23810a = rangeAdapterPreparer;
            super(executorService);
            this.f23811b = rangeAdapterPreparer2;
        }

        public final void mo2638b() {
            if (this.f23810a.f23808j) {
                RangeAdapterPreparer rangeAdapterPreparer = this.f23810a;
                int q = rangeAdapterPreparer.f23802d.mo2402q();
                int r = rangeAdapterPreparer.f23802d.mo2403r();
                if (rangeAdapterPreparer.f23802d.mo2343C() && q >= 0 && r >= 0 && q <= r) {
                    rangeAdapterPreparer.f23808j = false;
                    q = (q + r) / 2;
                    rangeAdapterPreparer.f23807i = q;
                    rangeAdapterPreparer.f23805g = q;
                    rangeAdapterPreparer.f23806h = q + 1;
                    rangeAdapterPreparer.f23799a = 1;
                }
            }
            if (!this.f23810a.f23808j) {
                int i;
                int i2 = this.f23810a.f23805g >= 0 ? 1 : 0;
                if (this.f23810a.f23806h < this.f23810a.f23800b.mo2521b()) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i2 != 0 && (this.f23810a.f23799a == 1 || i == 0)) {
                    this.f23810a.f23799a = 0;
                    if (this.f23810a.f23805g >= RangeAdapterPreparer.m32200g(this.f23810a) || this.f23810a.f23805g < 40) {
                        RangeAdapterPreparer.m32195a(this.f23810a, this.f23810a.f23799a);
                    } else {
                        RangeAdapterPreparer.m32196b(this.f23810a, this.f23810a.f23799a);
                    }
                } else if (i != 0) {
                    this.f23810a.f23799a = 1;
                    if (this.f23810a.f23806h <= RangeAdapterPreparer.m32199f(this.f23810a) || this.f23810a.f23806h < 40) {
                        RangeAdapterPreparer.m32195a(this.f23810a, this.f23810a.f23799a);
                    } else {
                        RangeAdapterPreparer.m32196b(this.f23810a, this.f23810a.f23799a);
                    }
                }
            }
        }

        public final boolean mo2639c() {
            RangeAdapterPreparer rangeAdapterPreparer = this.f23811b;
            boolean z = rangeAdapterPreparer.f23808j || rangeAdapterPreparer.f23805g >= 0 || rangeAdapterPreparer.f23806h < rangeAdapterPreparer.f23800b.mo2521b();
            return z;
        }
    }

    @Inject
    public RangeAdapterPreparer(@Assisted AdaptersCollection<T> adaptersCollection, @Assisted ScrollingViewProxy scrollingViewProxy, IdleExecutor idleExecutor, RangePreparerExperimentHelper rangePreparerExperimentHelper) {
        this.f23800b = adaptersCollection;
        this.f23801c = idleExecutor;
        this.f23802d = scrollingViewProxy;
        this.f23803e = rangePreparerExperimentHelper.m10052b();
    }

    public final void mo2533a() {
        mo2534b();
        this.f23808j = true;
        this.f23804f = new PrepareTask(this, this, this.f23801c);
        ExecutorDetour.a(this.f23801c, this.f23804f, -1661989409);
    }

    public final void mo2534b() {
        if (this.f23804f != null) {
            this.f23804f.m19816a();
        }
    }

    public static void m32195a(RangeAdapterPreparer rangeAdapterPreparer, int i) {
        boolean z = false;
        int f;
        Object obj;
        if (i == 1) {
            f = m32199f(rangeAdapterPreparer);
            while (!z) {
                if (rangeAdapterPreparer.f23806h > f) {
                    if (rangeAdapterPreparer.f23806h >= 40 || rangeAdapterPreparer.f23806h >= rangeAdapterPreparer.f23800b.mo2521b()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        return;
                    }
                }
                int i2 = rangeAdapterPreparer.f23806h;
                rangeAdapterPreparer.f23806h = i2 + 1;
                z = rangeAdapterPreparer.m32197c(i2);
            }
            return;
        }
        f = m32200g(rangeAdapterPreparer);
        while (!z) {
            if (rangeAdapterPreparer.f23805g < f) {
                if (rangeAdapterPreparer.f23805g >= 40 || rangeAdapterPreparer.f23805g < 0) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    return;
                }
            }
            i2 = rangeAdapterPreparer.f23805g;
            rangeAdapterPreparer.f23805g = i2 - 1;
            z = rangeAdapterPreparer.m32197c(i2);
        }
    }

    public static void m32196b(RangeAdapterPreparer rangeAdapterPreparer, int i) {
        boolean z = false;
        if (i == 1) {
            int b = rangeAdapterPreparer.f23800b.mo2521b();
            while (!z && rangeAdapterPreparer.f23806h < b) {
                int i2 = rangeAdapterPreparer.f23806h;
                rangeAdapterPreparer.f23806h = i2 + 1;
                z = rangeAdapterPreparer.m32198d(i2);
            }
            return;
        }
        while (!z && rangeAdapterPreparer.f23805g >= 40) {
            i2 = rangeAdapterPreparer.f23805g;
            rangeAdapterPreparer.f23805g = i2 - 1;
            z = rangeAdapterPreparer.m32198d(i2);
        }
    }

    public static int m32199f(RangeAdapterPreparer rangeAdapterPreparer) {
        return Math.min(rangeAdapterPreparer.f23800b.mo2521b(), rangeAdapterPreparer.f23807i + rangeAdapterPreparer.f23803e);
    }

    public static int m32200g(RangeAdapterPreparer rangeAdapterPreparer) {
        return Math.max(0, rangeAdapterPreparer.f23807i - rangeAdapterPreparer.f23803e);
    }

    private boolean m32197c(int i) {
        BoundedAdapter a = this.f23800b.mo2519a(i);
        return a.f13446a.m19053f(a.f13447b);
    }

    private boolean m32198d(int i) {
        BoundedAdapter a = this.f23800b.mo2519a(i);
        return a.f13446a.m19055i(a.f13447b);
    }
}
