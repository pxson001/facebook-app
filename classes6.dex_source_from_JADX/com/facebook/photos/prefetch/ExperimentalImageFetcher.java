package com.facebook.photos.prefetch;

import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.feed.photos.FeedImagesCacheStateMapper;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.photos.prefetch.BackgroundHandoffHelper.BackgroundHandoffConsumer;
import com.google.common.base.Functions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: has_submittable_content */
public class ExperimentalImageFetcher implements BackgroundHandoffConsumer, ImageFetcher {
    public final List<PrefetchParams> f13241a = new ArrayList();
    public final HashMap<PrefetchParams, ListenableFuture<?>> f13242b = new HashMap();
    public final ImagePipeline f13243c;
    public final ExecutorService f13244d;
    public final Set<PrefetchListener> f13245e;
    private final BackgroundHandoffHelper f13246f;
    private final MaybeLoadIntoMemoryCallback f13247g;

    /* compiled from: has_submittable_content */
    class MaybeLoadIntoMemoryCallback implements FutureCallback<PrefetchParams> {
        final /* synthetic */ ExperimentalImageFetcher f13240a;

        public MaybeLoadIntoMemoryCallback(ExperimentalImageFetcher experimentalImageFetcher) {
            this.f13240a = experimentalImageFetcher;
        }

        public void onSuccess(Object obj) {
            PrefetchParams prefetchParams = (PrefetchParams) obj;
            if (this.f13240a.f13241a.contains(prefetchParams)) {
                ExperimentalImageFetcher.m20918b(this.f13240a, prefetchParams);
            }
            for (FeedImagesCacheStateMapper a : this.f13240a.f13245e) {
                a.a(prefetchParams, true);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    @Inject
    public ExperimentalImageFetcher(ImagePipeline imagePipeline, ExecutorService executorService, Set<PrefetchListener> set, BackgroundHandoffHelperProvider backgroundHandoffHelperProvider) {
        this.f13243c = imagePipeline;
        this.f13244d = executorService;
        this.f13245e = set;
        this.f13246f = backgroundHandoffHelperProvider.a(executorService, this);
        this.f13247g = new MaybeLoadIntoMemoryCallback(this);
    }

    public final void m20920b(List<PrefetchParams> list, List<PrefetchParams> list2) {
        this.f13246f.a(list, list2);
    }

    public final void m20919a(List<PrefetchParams> list, List<PrefetchParams> list2) {
        this.f13241a.clear();
        this.f13241a.addAll(list);
        for (PrefetchParams b : list) {
            m20918b(this, b);
        }
        list.addAll(list2);
        Iterator it = this.f13242b.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (!list.contains(entry.getKey())) {
                ((ListenableFuture) entry.getValue()).cancel(false);
                it.remove();
            }
        }
        for (final PrefetchParams b2 : list) {
            if (!this.f13242b.containsKey(b2)) {
                ListenableFuture a = Futures.a(DataSourceToFutureAdapter.a(this.f13243c.f(b2.a, b2.b)), Functions.constant(b2), this.f13244d);
                Futures.a(a, this.f13247g, this.f13244d);
                this.f13242b.put(b2, a);
                a.a(new Runnable(this) {
                    final /* synthetic */ ExperimentalImageFetcher f13237b;

                    public void run() {
                        this.f13237b.f13242b.remove(b2);
                    }
                }, this.f13244d);
            }
        }
    }

    public static void m20918b(ExperimentalImageFetcher experimentalImageFetcher, final PrefetchParams prefetchParams) {
        if (!experimentalImageFetcher.f13243c.a(prefetchParams.a)) {
            Futures.a(DataSourceToFutureAdapter.a(experimentalImageFetcher.f13243c.b(prefetchParams.a)), new FutureCallback<Boolean>(experimentalImageFetcher) {
                final /* synthetic */ ExperimentalImageFetcher f13239b;

                public void onSuccess(Object obj) {
                    if (((Boolean) obj).booleanValue() && this.f13239b.f13241a.contains(prefetchParams)) {
                        this.f13239b.f13243c.e(prefetchParams.a, prefetchParams.b);
                    }
                }

                public void onFailure(Throwable th) {
                }
            }, experimentalImageFetcher.f13244d);
        }
    }
}
