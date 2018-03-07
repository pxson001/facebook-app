package com.facebook.attachments.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewStub;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: upload_hd */
public class AttachmentViewVideo extends CustomFrameLayout {
    @Inject
    public PendingCommentCache f1008a;
    private FeedProps<GraphQLStoryAttachment> f1009b;
    public RichVideoPlayer f1010c;
    private View f1011d;
    private float f1012e;

    private static <T extends View> void m983a(Class<T> cls, T t) {
        m984a((Object) t, t.getContext());
    }

    private static void m984a(Object obj, Context context) {
        ((AttachmentViewVideo) obj).f1008a = PendingCommentCache.a(FbInjector.get(context));
    }

    public AttachmentViewVideo(Context context) {
        this(context, null, 0);
    }

    public AttachmentViewVideo(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AttachmentViewVideo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m981a();
    }

    private void m981a() {
        m983a(AttachmentViewVideo.class, (View) this);
        setContentView(2130903305);
        this.f1010c = (RichVideoPlayer) c(2131559719);
        this.f1010c.a(new VideoPlugin(getContext()));
        this.f1010c.a(new CoverImagePlugin(getContext()));
        this.f1010c.a(new SinglePlayIconPlugin(getContext()));
        this.f1010c.a(new LoadingSpinnerPlugin(getContext()));
    }

    public RichVideoPlayer getPlayer() {
        return this.f1010c;
    }

    public final void m987a(FeedProps<GraphQLStoryAttachment> feedProps) {
        this.f1009b = feedProps;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().S() == null) {
            setVisibility(8);
            return;
        }
        GraphQLImage S = graphQLStoryAttachment.r().S();
        this.f1012e = m980a(S.c(), S.a());
        setVisibility(0);
        requestLayout();
        m985b();
    }

    private void m982a(PendingCommentCache pendingCommentCache) {
        this.f1008a = pendingCommentCache;
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int paddingLeft = (int) (((float) ((size - getPaddingLeft()) - getPaddingRight())) / this.f1012e);
        setMeasuredDimension(size, paddingLeft);
        measureChildren(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824));
    }

    public static float m980a(int i, int i2) {
        float f;
        if (i == 0 || i2 == 0) {
            f = 0.0f;
        } else {
            f = (((float) i) * 1.0f) / ((float) i2);
        }
        if (f == 0.0f) {
            return 1.3333334f;
        }
        return f;
    }

    private void m985b() {
        if (!m986e()) {
            if (this.f1011d == null) {
                this.f1011d = ((ViewStub) c(2131559718)).inflate();
            }
            this.f1011d.setVisibility(0);
        } else if (this.f1011d != null) {
            this.f1011d.setVisibility(8);
        }
    }

    private boolean m986e() {
        GraphQLComment h = AttachmentProps.h(this.f1009b);
        if (h == null) {
            return false;
        }
        GraphQLFeedOptimisticPublishState c = this.f1008a.c(h.H());
        if (c == GraphQLFeedOptimisticPublishState.RETRYING_IN_BACKGROUND || c == GraphQLFeedOptimisticPublishState.POSTING) {
            return false;
        }
        return true;
    }
}
