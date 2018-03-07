package com.facebook.feed.ui.imageloader;

import android.content.Context;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.ListViewPreloader;
import com.facebook.widget.listview.ScrollingViewProxy;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@ContextScoped
/* compiled from: The view to measure cannot be null */
public class FeedImageLoaderFactory {
    private static FeedImageLoaderFactory f22200g;
    private static final Object f22201h = new Object();
    public final FeedImageLoader f22202a;
    private final FeedImagePreloaderProvider f22203b;
    private final AnalyticsTagger f22204c;
    private final DefaultUserInteractionController f22205d;
    private final NewPipelinePrefetcher f22206e;
    @ForUiThread
    private final Executor f22207f;

    private static FeedImageLoaderFactory m24851b(InjectorLike injectorLike) {
        return new FeedImageLoaderFactory(FeedImageLoader.a(injectorLike), (FeedImagePreloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedImagePreloaderProvider.class), NewPipelinePrefetcher.m24865a(injectorLike), DefaultUserInteractionController.a(injectorLike), AnalyticsTagger.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FeedImageLoaderFactory(FeedImageLoader feedImageLoader, FeedImagePreloaderProvider feedImagePreloaderProvider, NewPipelinePrefetcher newPipelinePrefetcher, DefaultUserInteractionController defaultUserInteractionController, AnalyticsTagger analyticsTagger, Executor executor) {
        this.f22202a = feedImageLoader;
        this.f22203b = feedImagePreloaderProvider;
        this.f22206e = newPipelinePrefetcher;
        this.f22205d = defaultUserInteractionController;
        this.f22204c = analyticsTagger;
        this.f22207f = executor;
    }

    public final FeedImageLoader m24852a() {
        return this.f22202a;
    }

    public final ListViewPreloader m24853a(ScrollingViewProxy scrollingViewProxy, BasicAdapter basicAdapter) {
        return new FeedImagePrefetchViewPreloader(scrollingViewProxy, basicAdapter, this.f22203b, this.f22206e, this.f22205d, this.f22207f, AnalyticsTagger.b(scrollingViewProxy.ix_()));
    }

    public static FeedImageLoaderFactory m24850a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedImageLoaderFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22201h) {
                FeedImageLoaderFactory feedImageLoaderFactory;
                if (a2 != null) {
                    feedImageLoaderFactory = (FeedImageLoaderFactory) a2.a(f22201h);
                } else {
                    feedImageLoaderFactory = f22200g;
                }
                if (feedImageLoaderFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24851b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22201h, b3);
                        } else {
                            f22200g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = feedImageLoaderFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
