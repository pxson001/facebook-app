package com.facebook.feed.rows.core.preparer;

import com.facebook.common.executors.IncrementalRunnable;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.feed.rows.core.AdaptersCollection;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: ne */
public class TopDownAdapterPreparer<T> implements AdapterPreparer {
    public final AdaptersCollection<T> f12952a;
    private final DefaultProcessIdleExecutor f12953b;
    private PrepareTask f12954c;
    public int f12955d = 0;

    /* compiled from: ne */
    class PrepareTask extends IncrementalRunnable {
        final /* synthetic */ TopDownAdapterPreparer f13452a;
        private final TopDownAdapterPreparer f13453b;

        public PrepareTask(TopDownAdapterPreparer topDownAdapterPreparer, TopDownAdapterPreparer topDownAdapterPreparer2, ExecutorService executorService) {
            this.f13452a = topDownAdapterPreparer;
            super(executorService);
            this.f13453b = topDownAdapterPreparer2;
        }

        public final void mo2638b() {
            TopDownAdapterPreparer topDownAdapterPreparer = this.f13453b;
            while (topDownAdapterPreparer.f12955d < topDownAdapterPreparer.f12952a.mo2521b()) {
                BoundedAdapter a = topDownAdapterPreparer.f12952a.mo2519a(topDownAdapterPreparer.f12955d);
                boolean f = a.f13446a.m19053f(a.f13447b);
                topDownAdapterPreparer.f12955d++;
                if (f) {
                    return;
                }
            }
        }

        public final boolean mo2639c() {
            TopDownAdapterPreparer topDownAdapterPreparer = this.f13453b;
            return topDownAdapterPreparer.f12955d < topDownAdapterPreparer.f12952a.mo2521b();
        }
    }

    @Inject
    public TopDownAdapterPreparer(@Assisted AdaptersCollection<T> adaptersCollection, IdleExecutor idleExecutor) {
        this.f12952a = adaptersCollection;
        this.f12953b = idleExecutor;
    }

    public final void mo2533a() {
        mo2534b();
        this.f12954c = new PrepareTask(this, this, this.f12953b);
        ExecutorDetour.a(this.f12953b, this.f12954c, 1124664929);
    }

    public final void mo2534b() {
        if (this.f12954c != null) {
            this.f12954c.m19816a();
            this.f12955d = 0;
        }
    }
}
