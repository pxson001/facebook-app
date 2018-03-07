package com.facebook.photos.prefetch;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LruCache;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.feed.photos.FeedImagesCacheStateMapper;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: pages/comments/%s */
public class OldImageFetcher implements ImageFetcher {
    private final ImagePipeline f10463a;
    private final ExecutorService f10464b;
    private final ExecutorService f10465c;
    private final Set<PrefetchListener> f10466d;
    public final LruCache<String, Boolean> f10467e = new LruCache(64);
    public final Object f10468f = new Object();
    @GuardedBy("mLock")
    public final ArrayList<PrefetchParams> f10469g = new ArrayList();
    @GuardedBy("mLock")
    public final ArrayList<PrefetchParams> f10470h = new ArrayList();
    public final AtomicBoolean f10471i = new AtomicBoolean(true);
    private final RequestStarter f10472j = new RequestStarter(this);

    /* compiled from: pages/comments/%s */
    class RequestStarter implements Runnable {
        final /* synthetic */ OldImageFetcher f11080a;
        private final ArrayList<PrefetchParams> f11081b = new ArrayList();
        private final ArrayList<PrefetchParams> f11082c = new ArrayList();
        private final ArrayMap<PrefetchParams, DataSource> f11083d = new ArrayMap();

        public RequestStarter(OldImageFetcher oldImageFetcher) {
            this.f11080a = oldImageFetcher;
        }

        public synchronized void run() {
            this.f11081b.clear();
            this.f11082c.clear();
            synchronized (this.f11080a.f10468f) {
                this.f11081b.addAll(this.f11080a.f10469g);
                this.f11082c.addAll(this.f11080a.f10470h);
            }
            this.f11080a.f10471i.set(true);
            int i = 0;
            while (i < this.f11083d.size()) {
                int i2;
                PrefetchParams prefetchParams = (PrefetchParams) this.f11083d.b(i);
                if (this.f11081b.contains(prefetchParams) || this.f11082c.contains(prefetchParams)) {
                    i2 = i;
                } else {
                    ((DataSource) this.f11083d.c(i)).mo2782g();
                    this.f11083d.d(i);
                    i2 = i - 1;
                }
                i = i2 + 1;
            }
            for (i = 0; i < this.f11081b.size(); i++) {
                prefetchParams = (PrefetchParams) this.f11081b.get(i);
                if (this.f11080a.f10467e.m4432a(prefetchParams.m29725c()) == null && !this.f11083d.containsKey(prefetchParams)) {
                    this.f11083d.put(prefetchParams, OldImageFetcher.m15542a(this.f11080a, prefetchParams, false));
                }
            }
            for (i = 0; i < this.f11082c.size(); i++) {
                prefetchParams = (PrefetchParams) this.f11082c.get(i);
                if (!this.f11083d.containsKey(prefetchParams)) {
                    this.f11083d.put(prefetchParams, OldImageFetcher.m15542a(this.f11080a, prefetchParams, true));
                }
            }
        }
    }

    public static DataSource m15542a(OldImageFetcher oldImageFetcher, PrefetchParams prefetchParams, boolean z) {
        DataSource e;
        ImageRequest imageRequest = prefetchParams.f21908a;
        if (z) {
            e = oldImageFetcher.f10463a.m16075e(imageRequest, prefetchParams.f21909b);
        } else {
            e = oldImageFetcher.f10463a.m16076f(imageRequest, prefetchParams.f21909b);
        }
        if (e.mo2784b()) {
            e.mo2782g();
            oldImageFetcher.f10467e.m4433a(prefetchParams.m29725c(), Boolean.TRUE);
            m15543b(oldImageFetcher, prefetchParams, true);
        } else {
            e.mo2783a(new DataSubscriber(oldImageFetcher, prefetchParams), oldImageFetcher.f10465c);
        }
        return e;
    }

    @Inject
    public OldImageFetcher(ImagePipeline imagePipeline, IdleExecutor idleExecutor, ExecutorService executorService, Set<PrefetchListener> set) {
        this.f10463a = imagePipeline;
        this.f10465c = idleExecutor;
        this.f10464b = executorService;
        this.f10466d = set;
    }

    public final void mo2003b(List<PrefetchParams> list, List<PrefetchParams> list2) {
        synchronized (this.f10468f) {
            this.f10470h.clear();
            this.f10469g.clear();
            this.f10470h.addAll(list);
            this.f10469g.addAll(list2);
        }
        if (this.f10471i.compareAndSet(true, false)) {
            ExecutorDetour.a(this.f10464b, this.f10472j, 1664592399);
        }
    }

    public static void m15543b(OldImageFetcher oldImageFetcher, PrefetchParams prefetchParams, boolean z) {
        for (FeedImagesCacheStateMapper a : oldImageFetcher.f10466d) {
            a.m14220a(prefetchParams, z);
        }
    }
}
