package com.facebook.feedplugins.offline.rows.ui;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.feed.util.composer.OfflinePostProgress;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: SQUARE */
public class OfflineProgressView extends CustomRelativeLayout implements OfflinePostProgress, HasOfflineHeaderView {
    @Inject
    public Clock f23715a;
    @Inject
    public PendingStoryStore f23716b;
    @Inject
    public OptimisticStoryStateCache f23717c;
    private final ProgressBar f23718d = ((ProgressBar) a(2131558408));
    public FutureCallback<GraphQLStory> f23719e;
    public FutureCallback<GraphQLStory> f23720f;

    public static void m25898a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        OfflineProgressView offlineProgressView = (OfflineProgressView) obj;
        Clock clock = (Clock) SystemClockMethodAutoProvider.a(fbInjector);
        PendingStoryStore a = PendingStoryStore.a(fbInjector);
        OptimisticStoryStateCache a2 = OptimisticStoryStateCache.a(fbInjector);
        offlineProgressView.f23715a = clock;
        offlineProgressView.f23716b = a;
        offlineProgressView.f23717c = a2;
    }

    public OfflineProgressView(Context context) {
        super(context);
        Class cls = OfflineProgressView.class;
        m25898a(this, getContext());
        setContentView(2130905540);
        this.f23718d.setMax(1000);
    }

    public void setProgress(int i) {
        Preconditions.checkArgument(i <= 1000, "argument must be less than 1000");
        this.f23718d.setProgress(i);
    }

    public final void mo1590a(GraphQLStory graphQLStory) {
        Optional d = this.f23716b.d(graphQLStory.T());
        if (d.isPresent()) {
            if (this.f23717c.a(graphQLStory) == GraphQLFeedOptimisticPublishState.FAILED) {
                ((PendingStory) d.get()).b(this.f23715a.a());
            }
            setProgress(((PendingStory) d.get()).a(this.f23715a.a()));
            if (!((PendingStory) d.get()).f() && this.f23719e != null) {
                this.f23719e.onSuccess(graphQLStory);
                this.f23719e = null;
            } else if (((PendingStory) d.get()).f() && this.f23720f != null) {
                this.f23720f.onSuccess(graphQLStory);
                this.f23720f = null;
            }
        }
    }

    public final void mo1589a() {
        setVisibility(8);
    }

    public View getOfflineHeaderView() {
        return this.f23718d;
    }
}
