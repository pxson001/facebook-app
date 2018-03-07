package com.facebook.messaging.inbox2.trendinggifs;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.messaging.inbox2.items.InboxUnitViewWithRecyclerView;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLFetcher;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLRequest.ResultType;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLResponse;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLResult;
import com.facebook.messaging.media.externalmedia.MediaParams.MediaType;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: selected_time_filter */
public class TrendingGifsView extends CustomFrameLayout implements InboxUnitViewWithRecyclerView {
    public static final ImmutableList<ResultType> f2982d = ImmutableList.of(ResultType.ANIMATION);
    public static final ImmutableList<MediaType> f2983e = ImmutableList.of(MediaType.WEBP, MediaType.GIF);
    @Inject
    public ExternalMediaGraphQLFetcher f2984a;
    @Inject
    @ForUiThread
    public Executor f2985b;
    @Inject
    public TrendingGifsAdapter f2986c;
    public BetterRecyclerView f2987f = ((BetterRecyclerView) c(2131563115));
    public View f2988g = c(2131563116);
    public TrendingGifsInboxItem f2989h;
    public TrendingGifsUnitListener f2990i;

    /* compiled from: selected_time_filter */
    public class C04881 implements TrendingGifsUnitListener {
        final /* synthetic */ TrendingGifsView f2977a;

        public C04881(TrendingGifsView trendingGifsView) {
            this.f2977a = trendingGifsView;
        }

        public final void mo104a(TrendingGifInboxItem trendingGifInboxItem) {
            if (this.f2977a.f2990i != null) {
                this.f2977a.f2990i.mo104a(trendingGifInboxItem);
            }
        }
    }

    /* compiled from: selected_time_filter */
    public class C04903 implements FutureCallback<ExternalMediaGraphQLResponse> {
        final /* synthetic */ TrendingGifsView f2981a;

        public C04903(TrendingGifsView trendingGifsView) {
            this.f2981a = trendingGifsView;
        }

        public void onSuccess(@Nullable Object obj) {
            ImmutableList immutableList;
            ExternalMediaGraphQLResponse externalMediaGraphQLResponse = (ExternalMediaGraphQLResponse) obj;
            if (externalMediaGraphQLResponse != null) {
                immutableList = externalMediaGraphQLResponse.a;
            } else {
                immutableList = RegularImmutableList.a;
            }
            TrendingGifsAdapter trendingGifsAdapter = this.f2981a.f2986c;
            TrendingGifsView trendingGifsView = this.f2981a;
            Builder builder = new Builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                TrendingGifInboxItem trendingGifInboxItem = new TrendingGifInboxItem(trendingGifsView.f2989h.d, (ExternalMediaGraphQLResult) immutableList.get(i));
                trendingGifInboxItem.a(0);
                builder.c(trendingGifInboxItem);
            }
            trendingGifsAdapter.f2975c = builder.b();
            trendingGifsAdapter.notifyDataSetChanged();
        }

        public void onFailure(Throwable th) {
            TrendingGifsView trendingGifsView = this.f2981a;
            trendingGifsView.f2988g.setVisibility(0);
            trendingGifsView.f2987f.setVisibility(8);
        }
    }

    public static void m2976a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        TrendingGifsView trendingGifsView = (TrendingGifsView) obj;
        ExternalMediaGraphQLFetcher b = ExternalMediaGraphQLFetcher.b(fbInjector);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        TrendingGifsAdapter trendingGifsAdapter = new TrendingGifsAdapter(FbDraweeControllerBuilder.b(fbInjector));
        trendingGifsView.f2984a = b;
        trendingGifsView.f2985b = executor;
        trendingGifsView.f2986c = trendingGifsAdapter;
    }

    public TrendingGifsView(Context context) {
        super(context);
        Class cls = TrendingGifsView.class;
        m2976a(this, getContext());
        setContentView(2130904889);
        this.f2987f.setLayoutManager(new LinearLayoutManager(0, false));
        this.f2987f.setAdapter(this.f2986c);
        this.f2986c.f2976d = new C04881(this);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(2131433871);
        final int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131433872);
        this.f2987f.a(new ItemDecoration(this) {
            final /* synthetic */ TrendingGifsView f2980c;

            public final void m2975a(Rect rect, View view, RecyclerView recyclerView, State state) {
                int d = RecyclerView.d(view);
                rect.set(d == 0 ? dimensionPixelSize : dimensionPixelSize2, 0, d == state.e() + -1 ? dimensionPixelSize : dimensionPixelSize2, 0);
            }
        });
    }

    public BetterRecyclerView getRecyclerView() {
        return this.f2987f;
    }

    public InboxAdapter getInboxAdapter() {
        return this.f2986c;
    }
}
