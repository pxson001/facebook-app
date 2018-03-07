package com.facebook.video.channelfeed;

import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.calls.VideoChannelFollowInputData.Surface;
import com.facebook.graphql.calls.VideoChannelSubscribeInputData;
import com.facebook.graphql.calls.VideoChannelUnfollowInputData;
import com.facebook.graphql.calls.VideoChannelUnsubscribeInputData;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.video.followvideos.VideoHomeFollowVideosButton;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tabInfo */
public class ChannelFeedHeaderView extends CustomFrameLayout implements CanFocusDim {
    public static final CallerContext f2331b = CallerContext.a(ChannelFeedHeaderView.class, "video_channel_feed");
    @Inject
    public Lazy<GraphQLSubscriptionHolder> f2332a;
    private final ValueAnimator f2333c;
    public FbDraweeView f2334d;
    private TextView f2335e;
    private TextView f2336f;
    private TextView f2337g;
    private VideoHomeFollowVideosButton f2338h;
    private boolean f2339i;
    @Nullable
    private ModelUpdateCallback f2340j;

    /* compiled from: tabInfo */
    class ModelUpdateCallback implements FutureCallback<GraphQLResult<GraphQLVisitableModel>> {
        final /* synthetic */ ChannelFeedHeaderView f2330a;

        public ModelUpdateCallback(ChannelFeedHeaderView channelFeedHeaderView) {
            this.f2330a = channelFeedHeaderView;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && (graphQLResult.e instanceof GraphQLActor)) {
                GraphQLActor graphQLActor = (GraphQLActor) graphQLResult.e;
                ChannelFeedHeaderView.m2295a(this.f2330a, graphQLActor.aB(), graphQLActor.H());
                if (graphQLActor.aJ()) {
                    ChannelFeedHeaderView.m2294a(this.f2330a, graphQLActor.aI());
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    public static void m2296a(Object obj, Context context) {
        ((ChannelFeedHeaderView) obj).f2332a = IdBasedLazy.a(FbInjector.get(context), 2169);
    }

    public ChannelFeedHeaderView(Context context) {
        this(context, null);
    }

    private ChannelFeedHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ChannelFeedHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2333c = new ValueAnimator();
        Class cls = ChannelFeedHeaderView.class;
        m2296a((Object) this, getContext());
        setContentView(2130903538);
        this.f2334d = (FbDraweeView) c(2131559671);
        this.f2335e = (TextView) c(2131558927);
        this.f2336f = (TextView) c(2131558926);
        this.f2337g = (TextView) c(2131560278);
        this.f2338h = (VideoHomeFollowVideosButton) c(2131560277);
        this.f2333c.setInterpolator(new AccelerateDecelerateInterpolator());
        setClipChildren(false);
    }

    public final void m2298a(ChannelFeedHeaderParams channelFeedHeaderParams) {
        Preconditions.checkNotNull(channelFeedHeaderParams);
        String str = channelFeedHeaderParams.f2264e;
        if (StringUtil.c(str)) {
            this.f2334d.setVisibility(8);
        } else {
            this.f2334d.a(Uri.parse(str), f2331b);
            this.f2334d.setVisibility(0);
        }
        m2292a(this.f2335e, channelFeedHeaderParams.f2261b);
        m2292a(this.f2336f, channelFeedHeaderParams.f2262c);
        setBadgeText(channelFeedHeaderParams.f2263d);
        if (channelFeedHeaderParams.f2267h) {
            if (channelFeedHeaderParams.f2271l != null) {
                this.f2338h.a(channelFeedHeaderParams.f2265f, channelFeedHeaderParams.f2269j, channelFeedHeaderParams.f2270k, channelFeedHeaderParams.f2271l);
            } else {
                m2295a(this, channelFeedHeaderParams.f2265f, channelFeedHeaderParams.f2260a);
                if (channelFeedHeaderParams.f2268i) {
                    m2294a(this, channelFeedHeaderParams.f2266g);
                }
                m2293a(channelFeedHeaderParams.f2272m);
            }
            this.f2338h.setVisibility(0);
            return;
        }
        this.f2338h.setVisibility(8);
    }

    public static void m2295a(ChannelFeedHeaderView channelFeedHeaderView, boolean z, String str) {
        channelFeedHeaderView.f2338h.a(z, str, Surface.VIDEO_CHANNEL_HEADER, VideoChannelUnfollowInputData.Surface.VIDEO_CHANNEL_HEADER);
    }

    public static void m2294a(ChannelFeedHeaderView channelFeedHeaderView, boolean z) {
        channelFeedHeaderView.f2338h.a(z, VideoChannelSubscribeInputData.Surface.VIDEO_CHANNEL_HEADER, VideoChannelUnsubscribeInputData.Surface.VIDEO_CHANNEL_HEADER);
    }

    public void setBadgeText(String str) {
        m2292a(this.f2337g, str);
    }

    private static void m2292a(TextView textView, String str) {
        textView.setText(str);
        textView.setVisibility(StringUtil.c(str) ? 8 : 0);
    }

    private void m2293a(@Nullable GraphQLVisitableModel graphQLVisitableModel) {
        if (graphQLVisitableModel instanceof GraphQLActor) {
            String H = ((GraphQLActor) graphQLVisitableModel).H();
            if (H != null && !((GraphQLSubscriptionHolder) this.f2332a.get()).a(H)) {
                if (this.f2340j == null) {
                    this.f2340j = new ModelUpdateCallback(this);
                }
                ImmutableSet of = ImmutableSet.of(H);
                ((GraphQLSubscriptionHolder) this.f2332a.get()).a(of);
                ((GraphQLSubscriptionHolder) this.f2332a.get()).a(this.f2340j, H, new GraphQLResult(graphQLVisitableModel, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, of));
            }
        }
    }

    public final void mo66a() {
        if (!this.f2339i) {
            this.f2339i = true;
            ChannelFeedDimmingUtil.m2139a(this.f2339i, this.f2333c, this);
        }
    }

    public final void mo67b() {
        if (this.f2339i) {
            this.f2339i = false;
            ChannelFeedDimmingUtil.m2139a(this.f2339i, this.f2333c, this);
        }
    }
}
