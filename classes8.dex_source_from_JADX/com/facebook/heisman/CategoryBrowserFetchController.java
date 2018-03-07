package com.facebook.heisman;

import android.os.Handler;
import android.widget.TextView;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.Callbacks;
import com.facebook.graphql.connection.ConnectionTailLoaderManagerProvider;
import com.facebook.graphql.connection.SingletonConnectionFetcher;
import com.facebook.graphql.connection.SingletonConnectionFetcherProvider;
import com.facebook.graphql.connection.configuration.Configuration;
import com.facebook.graphql.connection.configuration.SingleBatchConfiguration;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManagerProvider;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.recyclerview.cursor.CursorRecyclerViewAdapter;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: video_cover_image_width */
public class CategoryBrowserFetchController {
    public static final Class<?> f574a = CategoryBrowserFetchController.class;
    private final Callbacks f575b = new C00721(this);
    public final CategoryBrowserFragment f576c;
    public final SingletonConnectionFetcher f577d;
    @Inject
    @Lazy
    @ForUiThread
    public com.facebook.inject.Lazy<Handler> f578e = UltralightRuntime.b;
    @Inject
    public CategoryBrowserConnectionConfiguration f579f;
    @Inject
    public CategoryBrowserSearchConnectionConfigurationProvider f580g;
    @Nullable
    private SearchTask f581h;

    /* compiled from: video_cover_image_width */
    class C00721 implements Callbacks {
        final /* synthetic */ CategoryBrowserFetchController f570a;

        C00721(CategoryBrowserFetchController categoryBrowserFetchController) {
            this.f570a = categoryBrowserFetchController;
        }

        public final void mo8a(@Nullable ModelCursor modelCursor) {
            CategoryBrowserFragment categoryBrowserFragment = this.f570a.f576c;
            if (categoryBrowserFragment.f590e != null) {
                CursorRecyclerViewAdapter cursorRecyclerViewAdapter = categoryBrowserFragment.f590e;
                if (cursorRecyclerViewAdapter.f564a != null) {
                    cursorRecyclerViewAdapter.f564a.close();
                    cursorRecyclerViewAdapter.f564a = null;
                }
                cursorRecyclerViewAdapter.f564a = modelCursor;
                cursorRecyclerViewAdapter.notifyDataSetChanged();
            } else if (modelCursor != null) {
                modelCursor.close();
            }
        }

        public final void mo9a(Throwable th) {
            BLog.b(CategoryBrowserFetchController.f574a, "network error", th);
        }

        public final void mo10a(boolean z) {
            CategoryBrowserFragment categoryBrowserFragment = this.f570a.f576c;
            if (categoryBrowserFragment.f590e != null && categoryBrowserFragment.f593h != null && categoryBrowserFragment.f592g != null) {
                if (categoryBrowserFragment.f590e.aZ_() != 0) {
                    categoryBrowserFragment.f593h.c();
                    categoryBrowserFragment.f592g.setVisibility(0);
                    categoryBrowserFragment.f592g.b();
                } else if (z) {
                    categoryBrowserFragment.f593h.c();
                    categoryBrowserFragment.f592g.setVisibility(0);
                    categoryBrowserFragment.f592g.a();
                } else {
                    categoryBrowserFragment.f592g.setVisibility(8);
                    ((TextView) categoryBrowserFragment.f593h.a()).setVisibility(0);
                }
            }
        }
    }

    /* compiled from: video_cover_image_width */
    public class SearchTask implements Runnable {
        final /* synthetic */ CategoryBrowserFetchController f571a;
        private final CharSequence f572b;
        public boolean f573c;

        public SearchTask(CategoryBrowserFetchController categoryBrowserFetchController, CharSequence charSequence) {
            this.f571a = categoryBrowserFetchController;
            this.f572b = charSequence;
        }

        public void run() {
            if (!this.f573c) {
                CategoryBrowserFetchController categoryBrowserFetchController = this.f571a;
                String a = StringFormatUtil.a("ProfilePictureOverlayCategoryBrowser_%s", new Object[]{this.f572b.toString()});
                CategoryBrowserSearchConnectionConfigurationProvider categoryBrowserSearchConnectionConfigurationProvider = categoryBrowserFetchController.f580g;
                Configuration categoryBrowserSearchConnectionConfiguration = new CategoryBrowserSearchConnectionConfiguration(r1);
                Provider a2 = IdBasedSingletonScopeProvider.a(categoryBrowserSearchConnectionConfigurationProvider, 494);
                Provider a3 = IdBasedSingletonScopeProvider.a(categoryBrowserSearchConnectionConfigurationProvider, 3478);
                categoryBrowserSearchConnectionConfiguration.f599a = a2;
                categoryBrowserSearchConnectionConfiguration.f600b = a3;
                categoryBrowserFetchController.f577d.m207a(a, new SingleBatchConfiguration(categoryBrowserSearchConnectionConfiguration, 86400));
            }
        }
    }

    @Inject
    public CategoryBrowserFetchController(@Assisted CategoryBrowserFragment categoryBrowserFragment, SingletonConnectionFetcherProvider singletonConnectionFetcherProvider) {
        this.f576c = categoryBrowserFragment;
        this.f577d = new SingletonConnectionFetcher(this.f575b, (ConnectionTailLoaderManagerProvider) singletonConnectionFetcherProvider.getOnDemandAssistedProviderForStaticDi(ConnectionTailLoaderManagerProvider.class), (LocalModelCursorLoaderManagerProvider) singletonConnectionFetcherProvider.getOnDemandAssistedProviderForStaticDi(LocalModelCursorLoaderManagerProvider.class));
    }

    public final void m630a() {
        this.f577d.m207a("ProfilePictureOverlayCategoryBrowserInitialLoad", new SingleBatchConfiguration(this.f579f, 86400));
    }

    public final void m631a(CharSequence charSequence) {
        m629d();
        if (StringUtil.a(charSequence)) {
            m630a();
            return;
        }
        this.f581h = new SearchTask(this, charSequence);
        HandlerDetour.b((Handler) this.f578e.get(), this.f581h, 500, 758682444);
    }

    public final void m632b() {
        m629d();
        HandlerDetour.a((Handler) this.f578e.get(), null);
        this.f577d.m206a();
    }

    private void m629d() {
        if (this.f581h != null) {
            HandlerDetour.a((Handler) this.f578e.get(), this.f581h);
            this.f581h.f573c = true;
        }
    }
}
