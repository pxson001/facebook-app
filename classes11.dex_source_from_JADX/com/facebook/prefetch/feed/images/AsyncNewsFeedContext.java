package com.facebook.prefetch.feed.images;

import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.feed.rows.NewsFeedRootGroupPartDefinition;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: TASK_ADD_CONTACT */
public class AsyncNewsFeedContext extends ContextWrapper {
    @Inject
    public MultiRowAdapterBuilder f10833a;
    @Inject
    public Lazy<NewsFeedRootGroupPartDefinition> f10834b;
    @Inject
    @ForUiThread
    public ListeningExecutorService f10835c;

    public static void m11301a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AsyncNewsFeedContext asyncNewsFeedContext = (AsyncNewsFeedContext) obj;
        MultiRowAdapterBuilder b = MultiRowAdapterBuilder.b(fbInjector);
        Lazy a = IdBasedLazy.a(fbInjector, 1480);
        ListeningExecutorService listeningExecutorService = (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        asyncNewsFeedContext.f10833a = b;
        asyncNewsFeedContext.f10834b = a;
        asyncNewsFeedContext.f10835c = listeningExecutorService;
    }

    public AsyncNewsFeedContext(Context context) {
        super(context);
        Class cls = AsyncNewsFeedContext.class;
        m11301a(this, this);
    }
}
