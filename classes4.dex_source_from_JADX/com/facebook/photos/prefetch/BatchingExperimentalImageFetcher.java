package com.facebook.photos.prefetch;

import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.feed.photos.FeedImagesCacheStateMapper;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.prefetch.BackgroundHandoffHelper.BackgroundHandoffConsumer;
import com.facebook.photos.prefetch.STATICDI_MULTIBIND_PROVIDER.PrefetchListener;
import com.facebook.photos.prefetch.qe.ExperimentsForPrefetchModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: video_home_badge_check_interval_s */
public class BatchingExperimentalImageFetcher implements BackgroundHandoffConsumer, ImageFetcher {
    private final Queue<PrefetchParams> f277a = new ArrayDeque();
    public final List<PrefetchParams> f278b = new ArrayList();
    public final HashMap<PrefetchParams, ListenableFuture<?>> f279c = new HashMap();
    public final ImagePipeline f280d;
    private final ExecutorService f281e;
    public final Set<PrefetchListener> f282f;
    private final BackgroundHandoffHelper f283g;
    private final int f284h;

    /* compiled from: video_home_badge_check_interval_s */
    class DiskFetchCallback implements FutureCallback<Void> {
        final /* synthetic */ BatchingExperimentalImageFetcher f7505a;
        private final PrefetchParams f7506b;

        public DiskFetchCallback(BatchingExperimentalImageFetcher batchingExperimentalImageFetcher, PrefetchParams prefetchParams) {
            this.f7505a = batchingExperimentalImageFetcher;
            this.f7506b = prefetchParams;
        }

        public void onSuccess(Object obj) {
            for (FeedImagesCacheStateMapper a : this.f7505a.f282f) {
                a.a(this.f7506b, true);
            }
            if (this.f7505a.f278b.contains(this.f7506b)) {
                BatchingExperimentalImageFetcher.m378b(this.f7505a, this.f7506b);
            }
            this.f7505a.f279c.remove(this.f7506b);
            BatchingExperimentalImageFetcher.m376a(this.f7505a);
        }

        public void onFailure(Throwable th) {
            this.f7505a.f279c.remove(this.f7506b);
            BatchingExperimentalImageFetcher.m376a(this.f7505a);
        }
    }

    public static BatchingExperimentalImageFetcher m377b(InjectorLike injectorLike) {
        return new BatchingExperimentalImageFetcher(ImagePipelineMethodAutoProvider.a(injectorLike), ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(injectorLike), PrefetchListener.a(injectorLike), (BackgroundHandoffHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BackgroundHandoffHelperProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BatchingExperimentalImageFetcher(ImagePipeline imagePipeline, ExecutorService executorService, Set<PrefetchListener> set, BackgroundHandoffHelperProvider backgroundHandoffHelperProvider, QeAccessor qeAccessor) {
        this.f280d = imagePipeline;
        this.f281e = executorService;
        this.f282f = set;
        this.f283g = backgroundHandoffHelperProvider.m644a(executorService, this);
        this.f284h = qeAccessor.a(ExperimentsForPrefetchModule.c, 2);
    }

    public final void m380b(List<PrefetchParams> list, List<PrefetchParams> list2) {
        this.f283g.m647a((List) list, (List) list2);
    }

    public final void mo21a(List<PrefetchParams> list, List<PrefetchParams> list2) {
        this.f277a.clear();
        this.f277a.addAll(list);
        this.f277a.addAll(list2);
        this.f277a.removeAll(this.f279c.keySet());
        this.f278b.clear();
        this.f278b.addAll(list);
        for (PrefetchParams b : this.f278b) {
            m378b(this, b);
        }
        if (this.f279c.size() < this.f284h) {
            m376a(this);
        }
    }

    public static void m376a(BatchingExperimentalImageFetcher batchingExperimentalImageFetcher) {
        while (batchingExperimentalImageFetcher.f279c.size() < batchingExperimentalImageFetcher.f284h && !batchingExperimentalImageFetcher.f277a.isEmpty()) {
            PrefetchParams prefetchParams = (PrefetchParams) batchingExperimentalImageFetcher.f277a.poll();
            ListenableFuture a = DataSourceToFutureAdapter.m7803a(batchingExperimentalImageFetcher.f280d.f(prefetchParams.a, prefetchParams.b));
            Futures.a(a, new DiskFetchCallback(batchingExperimentalImageFetcher, prefetchParams), batchingExperimentalImageFetcher.f281e);
            batchingExperimentalImageFetcher.f279c.put(prefetchParams, a);
        }
    }

    public static void m378b(BatchingExperimentalImageFetcher batchingExperimentalImageFetcher, PrefetchParams prefetchParams) {
        if (!batchingExperimentalImageFetcher.f280d.a(prefetchParams.a)) {
            ImageRequestBuilder a = ImageRequestBuilder.a(prefetchParams.a);
            a.b = RequestLevel.DISK_CACHE;
            batchingExperimentalImageFetcher.f280d.e(a.m(), prefetchParams.b);
        }
    }
}
