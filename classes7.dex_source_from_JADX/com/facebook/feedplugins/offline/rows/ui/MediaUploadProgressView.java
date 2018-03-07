package com.facebook.feedplugins.offline.rows.ui;

import android.content.Context;
import android.widget.ProgressBar;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.popover.PopoverListViewWindow;
import com.facebook.feed.util.composer.OfflinePostProgress;
import com.facebook.feedplugins.offline.rows.MediaUploadProgressPartDefinition.MenuCancelListener;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: STARS_DISMISS */
public class MediaUploadProgressView extends CustomRelativeLayout implements OfflinePostProgress {
    @Inject
    public Clock f23697a;
    @Inject
    public OptimisticStoryStateCache f23698b;
    public FutureCallback<GraphQLStory> f23699c;
    public FutureCallback<GraphQLStory> f23700d;
    private ProgressBar f23701e = ((ProgressBar) a(2131558408));
    public FbTextView f23702f;
    public PopoverListViewWindow f23703g;
    public GlyphView f23704h;
    public Optional<PendingStory> f23705i;
    public MenuCancelListener f23706j;

    public static void m25890a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MediaUploadProgressView mediaUploadProgressView = (MediaUploadProgressView) obj;
        Clock clock = (Clock) SystemClockMethodAutoProvider.a(fbInjector);
        OptimisticStoryStateCache a = OptimisticStoryStateCache.a(fbInjector);
        mediaUploadProgressView.f23697a = clock;
        mediaUploadProgressView.f23698b = a;
    }

    public MediaUploadProgressView(Context context) {
        super(context);
        Class cls = MediaUploadProgressView.class;
        m25890a(this, getContext());
        setContentView(2130907613);
        this.f23701e.setMax(1000);
        this.f23702f = (FbTextView) a(2131568200);
        this.f23704h = (GlyphView) a(2131568201);
        this.f23702f.setText(getResources().getString(2131235676, new Object[]{Integer.valueOf(0)}));
    }

    public void setProgress(int i) {
        this.f23701e.setProgress(i);
        float max = (100.0f * ((float) i)) / ((float) this.f23701e.getMax());
        this.f23702f.setText(getResources().getString(2131235677, new Object[]{Float.valueOf(max)}));
    }

    public final void mo1590a(GraphQLStory graphQLStory) {
        if (this.f23705i.isPresent()) {
            if (this.f23698b.a(graphQLStory) == GraphQLFeedOptimisticPublishState.FAILED) {
                ((PendingStory) this.f23705i.get()).b(this.f23697a.a());
            }
            setProgress(((PendingStory) this.f23705i.get()).a(this.f23697a.a()));
            if (!((PendingStory) this.f23705i.get()).f() && this.f23699c != null) {
                this.f23699c.onSuccess(graphQLStory);
                this.f23699c = null;
            } else if (((PendingStory) this.f23705i.get()).f() && this.f23700d != null) {
                this.f23700d.onSuccess(graphQLStory);
                this.f23700d = null;
            }
        }
    }

    public final void mo1589a() {
        if (this.f23703g != null) {
            this.f23703g.l();
        }
        setVisibility(8);
    }
}
