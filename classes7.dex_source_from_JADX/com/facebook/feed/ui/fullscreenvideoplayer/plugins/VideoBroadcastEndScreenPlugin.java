package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.graphql.calls.VideoChannelFollowInputData.Surface;
import com.facebook.graphql.calls.VideoChannelSubscribeInputData;
import com.facebook.graphql.calls.VideoChannelUnfollowInputData;
import com.facebook.graphql.calls.VideoChannelUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.followvideos.VideoHomeFollowVideosButton;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.StubbableRichVideoPlayerPlugin;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: This method should be called outside the lock. */
public class VideoBroadcastEndScreenPlugin extends StubbableRichVideoPlayerPlugin {
    private static final CallerContext f22175d = CallerContext.a(VideoBroadcastEndScreenPlugin.class);
    @Inject
    public Lazy<UriIntentMapper> f22176b;
    @Inject
    public Lazy<SecureContextHelper> f22177c;
    public View f22178l;
    private GraphQLActor f22179m;
    public GraphQLActor f22180n;
    public GraphQLMedia f22181o;
    private ImmutableList<GraphQLExploreFeed> f22182p;

    /* compiled from: This method should be called outside the lock. */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ VideoBroadcastEndScreenPlugin f22174a;

        public PlayerStateChangedEventSubscriber(VideoBroadcastEndScreenPlugin videoBroadcastEndScreenPlugin) {
            this.f22174a = videoBroadcastEndScreenPlugin;
        }

        public final void m24826b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (this.f22174a.f22181o != null && this.f22174a.f22181o.b().equals(rVPPlayerStateChangedEvent.a) && rVPPlayerStateChangedEvent.b == State.PLAYBACK_COMPLETE) {
                this.f22174a.m24833f();
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m24825a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public static void m24827a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        VideoBroadcastEndScreenPlugin videoBroadcastEndScreenPlugin = (VideoBroadcastEndScreenPlugin) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 2436);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 968);
        videoBroadcastEndScreenPlugin.f22176b = b;
        videoBroadcastEndScreenPlugin.f22177c = b2;
    }

    @DoNotStrip
    public VideoBroadcastEndScreenPlugin(Context context) {
        this(context, null);
    }

    private VideoBroadcastEndScreenPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private VideoBroadcastEndScreenPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = VideoBroadcastEndScreenPlugin.class;
        m24827a((Object) this, getContext());
        this.f.add(new PlayerStateChangedEventSubscriber(this));
    }

    private void m24828k() {
        if (this.c) {
            this.f22178l.setVisibility(8);
        }
    }

    protected final boolean m24834j() {
        return true;
    }

    protected final boolean m24831a(RichVideoPlayerParams richVideoPlayerParams) {
        return true;
    }

    protected int getLayoutToInflate() {
        return 2130907656;
    }

    protected void setupPlugin(RichVideoPlayerParams richVideoPlayerParams) {
    }

    protected void setupViews(View view) {
        CharSequence aa;
        this.f22178l = FindViewUtil.b(view, 2131568295);
        FindViewUtil.b(view, 2131568297).setBackgroundDrawable(new VideoBroadcastEndScreenOverlayDrawable(getResources()));
        FbDraweeView fbDraweeView = (FbDraweeView) FindViewUtil.b(view, 2131568296);
        if (this.f22181o.S() == null || this.f22181o.S().b() == null) {
            fbDraweeView.setVisibility(8);
        } else {
            fbDraweeView.a(Uri.parse(this.f22181o.S().b()), f22175d);
        }
        fbDraweeView = (FbDraweeView) FindViewUtil.b(view, 2131568298);
        if (this.f22179m.ai() == null || this.f22179m.ai().b() == null) {
            fbDraweeView.setVisibility(8);
        } else {
            fbDraweeView.a(Uri.parse(this.f22179m.ai().b()), f22175d);
        }
        TextView textView = (TextView) FindViewUtil.b(view, 2131568299);
        if (this.f22180n == null || this.f22180n.aF() == null) {
            aa = this.f22179m.aa();
        } else {
            aa = this.f22180n.aF().a();
        }
        textView.setText(aa);
        if (this.f22180n != null) {
            if (this.f22180n.aE() != null) {
                TextView textView2 = (TextView) FindViewUtil.b(this.f22178l, 2131568300);
                textView2.setText(this.f22180n.aE().a());
                textView2.setVisibility(0);
            }
            if (this.f22180n.ay()) {
                VideoHomeFollowVideosButton videoHomeFollowVideosButton = (VideoHomeFollowVideosButton) FindViewUtil.b(this.f22178l, 2131568301);
                videoHomeFollowVideosButton.setVisibility(0);
                videoHomeFollowVideosButton.m19635a(this.f22180n.aB(), this.f22180n.H(), Surface.UNKNOWN, VideoChannelUnfollowInputData.Surface.UNKNOWN);
                if (this.f22180n.aJ()) {
                    videoHomeFollowVideosButton.m19634a(this.f22180n.aI(), VideoChannelSubscribeInputData.Surface.UNKNOWN, VideoChannelUnsubscribeInputData.Surface.UNKNOWN);
                }
            }
        }
        m24829m();
    }

    protected final void m24830a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        m24828k();
        if (richVideoPlayerParams.b != null && richVideoPlayerParams.b.containsKey("GraphQLStoryProps") && (richVideoPlayerParams.b.get("GraphQLStoryProps") instanceof FeedProps)) {
            FeedProps feedProps = (FeedProps) richVideoPlayerParams.b.get("GraphQLStoryProps");
            if (feedProps != null) {
                GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
                ImmutableList b = ((GraphQLStory) feedProps.a).b();
                if (!CollectionUtil.a(b)) {
                    this.f22179m = (GraphQLActor) b.get(0);
                    this.f22182p = graphQLStory.Z() != null ? graphQLStory.Z().a() : null;
                    this.f22181o = RichVideoPlayerParamsUtil.a(richVideoPlayerParams);
                    if (this.f22181o != null && this.f22181o.aq() && (this.f22181o.br() == GraphQLVideoBroadcastStatus.LIVE_STOPPED || this.f22181o.br() == GraphQLVideoBroadcastStatus.SEAL_STARTED)) {
                        m24833f();
                    }
                    this.f22180n = this.f22181o.aF();
                }
            }
        }
    }

    protected final void m24832c() {
        m24828k();
        super.c();
    }

    public final void m24833f() {
        if (d()) {
            this.f22178l.setVisibility(0);
        }
    }

    private void m24829m() {
        if (this.f22182p != null && !this.f22182p.isEmpty() && this.f22182p.get(0) != null) {
            ((ViewStub) FindViewUtil.b(this.f22178l, 2131568302)).inflate();
            LinearLayout linearLayout = (LinearLayout) FindViewUtil.b(this.f22178l, 2131568303);
            int size = this.f22182p.size();
            for (int i = 0; i < size; i++) {
                final GraphQLExploreFeed graphQLExploreFeed = (GraphQLExploreFeed) this.f22182p.get(i);
                if (graphQLExploreFeed.F() != null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(2130907658, linearLayout, false);
                    textView.setText(graphQLExploreFeed.F().a());
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ VideoBroadcastEndScreenPlugin f22173b;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 1454511835);
                            ((SecureContextHelper) this.f22173b.f22177c.get()).a(((UriIntentMapper) this.f22173b.f22176b.get()).a(this.f22173b.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.gb, graphQLExploreFeed.n())), this.f22173b.getContext());
                            Logger.a(2, EntryType.UI_INPUT_END, -1688920733, a);
                        }
                    });
                    linearLayout.addView(textView);
                }
            }
        }
    }
}
