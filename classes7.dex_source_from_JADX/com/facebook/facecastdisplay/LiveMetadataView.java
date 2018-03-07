package com.facebook.facecastdisplay;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayout;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitleSpannableBuilder;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.graphql.calls.VideoChannelFollowInputData.Surface;
import com.facebook.graphql.calls.VideoChannelSubscribeInputData;
import com.facebook.graphql.calls.VideoChannelUnfollowInputData;
import com.facebook.graphql.calls.VideoChannelUnsubscribeInputData;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.video.followvideos.VideoHomeFollowVideosButton;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: audio/x-unknown */
public class LiveMetadataView extends ImageBlockLayout {
    private static final CallerContext f18905k = CallerContext.a(LiveMetadataView.class);
    @Inject
    FeedHighlighter f18906h;
    @Inject
    HeaderTitleSpannableBuilder f18907i;
    @Inject
    DefaultHeaderPartDataProviderForTextLayout f18908j;
    private final FbDraweeView f18909l;
    private final TextView f18910m;
    private final TextView f18911n;
    private final VideoHomeFollowVideosButton f18912o;
    private final TextPaint f18913p;
    private final Paint f18914q;
    @Nullable
    private FeedProps<GraphQLStory> f18915r;

    private static <T extends View> void m22511a(Class<T> cls, T t) {
        m22512a((Object) t, t.getContext());
    }

    private static void m22512a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((LiveMetadataView) obj).m22510a(FeedHighlighter.a(fbInjector), HeaderTitleSpannableBuilder.a(fbInjector), DefaultHeaderPartDataProviderForTextLayout.a(fbInjector));
    }

    private void m22510a(FeedHighlighter feedHighlighter, HeaderTitleSpannableBuilder headerTitleSpannableBuilder, DefaultHeaderPartDataProviderForTextLayout defaultHeaderPartDataProviderForTextLayout) {
        this.f18906h = feedHighlighter;
        this.f18907i = headerTitleSpannableBuilder;
        this.f18908j = defaultHeaderPartDataProviderForTextLayout;
    }

    public LiveMetadataView(Context context) {
        this(context, null);
    }

    public LiveMetadataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMetadataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22511a(LiveMetadataView.class, (View) this);
        setContentView(2130905086);
        this.f18909l = (FbDraweeView) getView(2131563488);
        this.f18910m = (TextView) getView(2131563489);
        this.f18911n = (TextView) getView(2131563490);
        this.f18912o = (VideoHomeFollowVideosButton) getView(2131563491);
        this.f18913p = new TextPaint(1);
        this.f18913p.setTextSize((float) context.getResources().getDimensionPixelSize(2131427400));
        this.f18914q = new Paint(1);
        this.f18914q.setColor(-1447187);
    }

    public void setStoryProps(FeedProps<GraphQLStory> feedProps) {
        this.f18915r = feedProps;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        CharSequence c = this.f18907i.a(feedProps).a().b().c();
        this.f18910m.setText(FeedHighlighter.a(graphQLStory) ? this.f18906h.a(graphQLStory, c) : c);
        m22513a();
    }

    public final void m22513a() {
        if (this.f18915r != null) {
            this.f18911n.setText(this.f18908j.a(this.f18915r, this.f18913p, this.f18914q, 0).b);
        }
    }

    public void setTitle(String str) {
        if (str != null) {
            this.f18910m.setVisibility(0);
            this.f18910m.setText(str);
            return;
        }
        this.f18910m.setVisibility(8);
    }

    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f18911n.setVisibility(8);
            return;
        }
        this.f18911n.setVisibility(0);
        this.f18911n.setText(str);
    }

    public void setProfilePicture(String str) {
        if (str != null) {
            this.f18909l.setVisibility(0);
            this.f18909l.a(Uri.parse(str), f18905k);
            return;
        }
        this.f18909l.setVisibility(8);
    }

    public final void m22515f() {
        this.f18912o.setVisibility(8);
    }

    public final void m22514a(GraphQLActor graphQLActor, boolean z) {
        this.f18912o.m19635a(graphQLActor.aB(), graphQLActor.H(), Surface.UNKNOWN, VideoChannelUnfollowInputData.Surface.UNKNOWN);
        if (z) {
            this.f18912o.m19636a(graphQLActor.aI(), graphQLActor.aa(), VideoChannelSubscribeInputData.Surface.UNKNOWN, VideoChannelUnsubscribeInputData.Surface.UNKNOWN);
        }
        this.f18912o.setVisibility(0);
    }

    public void setTextColor(int i) {
        this.f18910m.setTextColor(i);
        this.f18911n.setTextColor(i);
    }

    public final void m22516g() {
        this.f18912o.m19633a();
    }

    public final void m22517h() {
        this.f18910m.setSingleLine(true);
        this.f18911n.setSingleLine(true);
    }
}
