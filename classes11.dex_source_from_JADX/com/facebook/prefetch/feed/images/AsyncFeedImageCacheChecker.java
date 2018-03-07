package com.facebook.prefetch.feed.images;

import android.content.Context;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: TASK_CANCEL_REQUEST */
public class AsyncFeedImageCacheChecker {
    private static final String f10826a = AsyncFeedImageCacheChecker.class.getSimpleName();
    private static final Runnable f10827b = new C12841();
    private final AsyncNewsFeedContext f10828c;
    private final AsyncNewsFeedEnvironmentProvider f10829d;
    private final ImagePipeline f10830e;
    private final DbFeedHomeStoriesHandler f10831f;
    private final ListeningExecutorService f10832g;

    /* compiled from: TASK_CANCEL_REQUEST */
    final class C12841 implements Runnable {
        C12841() {
        }

        public final void run() {
        }
    }

    private static AsyncFeedImageCacheChecker m11300b(InjectorLike injectorLike) {
        return new AsyncFeedImageCacheChecker((Context) injectorLike.getInstance(Context.class), (AsyncNewsFeedEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AsyncNewsFeedEnvironmentProvider.class), ImagePipelineMethodAutoProvider.a(injectorLike), DbFeedHomeStoriesHandler.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AsyncFeedImageCacheChecker(Context context, AsyncNewsFeedEnvironmentProvider asyncNewsFeedEnvironmentProvider, ImagePipeline imagePipeline, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, ListeningExecutorService listeningExecutorService) {
        this(new AsyncNewsFeedContext(context), asyncNewsFeedEnvironmentProvider, imagePipeline, dbFeedHomeStoriesHandler, listeningExecutorService);
    }

    private AsyncFeedImageCacheChecker(AsyncNewsFeedContext asyncNewsFeedContext, AsyncNewsFeedEnvironmentProvider asyncNewsFeedEnvironmentProvider, ImagePipeline imagePipeline, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, ListeningExecutorService listeningExecutorService) {
        this.f10828c = asyncNewsFeedContext;
        this.f10829d = asyncNewsFeedEnvironmentProvider;
        this.f10830e = imagePipeline;
        this.f10831f = dbFeedHomeStoriesHandler;
        this.f10832g = listeningExecutorService;
    }
}
