package com.facebook.feed.ui.fullscreenvideoplayer;

import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.data.FeedStorySubscriber.OnStoryChangeListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Title */
public class InlineToFullscreenVideoTransitionManager {
    private final LayoutParams f21945a;
    public final Lazy<FeedStorySubscriber> f21946b;
    private boolean f21947c = false;
    private boolean f21948d;
    public RichVideoPlayerParams f21949e;
    public VideoTransitionNode f21950f;
    public VideoTransitionNode f21951g;
    public List<RichVideoPlayerPlugin> f21952h;
    public RichVideoPlayerCallbackListener f21953i;
    private FullscreenRichVideoPlayerPluginSelector f21954j;
    private WatchAndBrowseRichVideoPlayerPluginSelector f21955k;
    public OnStoryChangeListener f21956l;

    /* compiled from: Title */
    public enum FullscreenType {
        FULLSCREEN,
        WATCH_AND_BROWSE
    }

    /* compiled from: Title */
    public class StoryChangeListener implements OnStoryChangeListener {
        final /* synthetic */ InlineToFullscreenVideoTransitionManager f21944a;

        public StoryChangeListener(InlineToFullscreenVideoTransitionManager inlineToFullscreenVideoTransitionManager) {
            this.f21944a = inlineToFullscreenVideoTransitionManager;
        }

        public final void mo1522a(GraphQLStory graphQLStory) {
            this.f21944a.f21949e = Builder.a(this.f21944a.f21949e).a("GraphQLStoryProps", FeedProps.c(graphQLStory)).b();
        }
    }

    public static InlineToFullscreenVideoTransitionManager m24548b(InjectorLike injectorLike) {
        return new InlineToFullscreenVideoTransitionManager(IdBasedLazy.a(injectorLike, 5840), new FullscreenRichVideoPlayerPluginSelector((Context) injectorLike.getInstance(Context.class), Video360PlayerConfig.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), FacecastUtil.m3107b(injectorLike), Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(injectorLike), CommercialBreakConfig.a(injectorLike)), WatchAndBrowseRichVideoPlayerPluginSelector.m24556b(injectorLike));
    }

    public static InlineToFullscreenVideoTransitionManager m24547a(InjectorLike injectorLike) {
        return m24548b(injectorLike);
    }

    @Inject
    public InlineToFullscreenVideoTransitionManager(Lazy<FeedStorySubscriber> lazy, FullscreenRichVideoPlayerPluginSelector fullscreenRichVideoPlayerPluginSelector, WatchAndBrowseRichVideoPlayerPluginSelector watchAndBrowseRichVideoPlayerPluginSelector) {
        this.f21946b = lazy;
        this.f21945a = new LayoutParams(-1, -1);
        this.f21954j = fullscreenRichVideoPlayerPluginSelector;
        this.f21955k = watchAndBrowseRichVideoPlayerPluginSelector;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.video.player.RichVideoPlayer m24549a(com.facebook.video.player.VideoTransitionNode r9, com.facebook.video.player.VideoTransitionNode r10, com.facebook.video.player.RichVideoPlayerParams r11, com.facebook.feed.ui.fullscreenvideoplayer.InlineToFullscreenVideoTransitionManager.FullscreenType r12, @javax.annotation.Nullable com.facebook.video.player.environment.AnyPlayerEnvironment r13) {
        /*
        r8 = this;
        r3 = 0;
        r8.f21950f = r9;
        r8.f21951g = r10;
        r8.f21949e = r11;
        r1 = 0;
        if (r9 == 0) goto L_0x0076;
    L_0x000a:
        r0 = r8.f21947c;
        if (r0 != 0) goto L_0x0076;
    L_0x000e:
        r0 = r9.i();
        r2 = r0.l();
        if (r2 != 0) goto L_0x0076;
    L_0x0018:
        if (r0 == 0) goto L_0x0061;
    L_0x001a:
        r1 = 1;
        r8.f21948d = r1;
        r1 = r8.f21945a;
        r0.setLayoutParams(r1);
        r10.a(r0);
        r1 = r0.j();
        r8.f21952h = r1;
        r4 = r0.v;
        r1 = r4;
        r8.f21953i = r1;
        r4 = r8.f21949e;
        r4 = r4.b;
        if (r4 == 0) goto L_0x0050;
    L_0x0036:
        r4 = r8.f21949e;
        r4 = r4.b;
        r5 = "GraphQLStoryProps";
        r4 = r4.containsKey(r5);
        if (r4 == 0) goto L_0x0050;
    L_0x0042:
        r4 = r8.f21949e;
        r4 = r4.b;
        r5 = "GraphQLStoryProps";
        r4 = r4.get(r5);
        r4 = r4 instanceof com.facebook.feed.rows.core.props.FeedProps;
        if (r4 != 0) goto L_0x0078;
    L_0x0050:
        r1 = com.facebook.feed.ui.fullscreenvideoplayer.InlineToFullscreenVideoTransitionManager.FullscreenType.WATCH_AND_BROWSE;
        if (r12 != r1) goto L_0x0070;
    L_0x0054:
        r1 = r8.f21955k;
        r1.a(r0, r11, r13);
    L_0x0059:
        r1 = r10.getPlayerType();
        r0.setPlayerType(r1);
        return r0;
    L_0x0061:
        r8.f21948d = r3;
        r0 = r10.j();
        r1 = "Not reusing player but no default player provided.";
        com.google.common.base.Preconditions.checkNotNull(r0, r1);
        r0.setVisibility(r3);
        goto L_0x0050;
    L_0x0070:
        r1 = r8.f21954j;
        r1.a(r0, r11, r13);
        goto L_0x0059;
    L_0x0076:
        r0 = r1;
        goto L_0x0018;
    L_0x0078:
        r4 = r8.f21949e;
        r4 = r4.b;
        r5 = "GraphQLStoryProps";
        r4 = r4.get(r5);
        r4 = (com.facebook.feed.rows.core.props.FeedProps) r4;
        r7 = r4.a;
        r4 = r7;
        r4 = (com.facebook.graphql.model.GraphQLStory) r4;
        if (r4 == 0) goto L_0x0050;
    L_0x008b:
        r5 = r4.c();
        if (r5 == 0) goto L_0x0050;
    L_0x0091:
        r5 = r8.f21956l;
        if (r5 != 0) goto L_0x00a9;
    L_0x0095:
        r5 = new com.facebook.feed.ui.fullscreenvideoplayer.InlineToFullscreenVideoTransitionManager$StoryChangeListener;
        r6 = 0;
        r5.<init>(r8);
        r8.f21956l = r5;
        r5 = r8.f21946b;
        r5 = r5.get();
        r5 = (com.facebook.feed.data.FeedStorySubscriber) r5;
        r6 = r8.f21956l;
        r5.f19187d = r6;
    L_0x00a9:
        r5 = r8.f21946b;
        r5 = r5.get();
        r5 = (com.facebook.feed.data.FeedStorySubscriber) r5;
        r6 = 1;
        r5.m22699a(r4, r6);
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.ui.fullscreenvideoplayer.InlineToFullscreenVideoTransitionManager.a(com.facebook.video.player.VideoTransitionNode, com.facebook.video.player.VideoTransitionNode, com.facebook.video.player.RichVideoPlayerParams, com.facebook.feed.ui.fullscreenvideoplayer.InlineToFullscreenVideoTransitionManager$FullscreenType, com.facebook.video.player.environment.AnyPlayerEnvironment):com.facebook.video.player.RichVideoPlayer");
    }

    public final void m24550a() {
        RichVideoPlayer i;
        if (this.f21948d) {
            i = this.f21951g.i();
            i.setPlayerType(this.f21950f.getPlayerType());
            i.v = this.f21953i;
            i.j();
            i.a(this.f21952h);
            i.a(this.f21949e);
            i.setShouldCropToFit(true);
            this.f21950f.a(i);
            this.f21952h.clear();
            this.f21952h = null;
            this.f21953i = null;
            ((FeedStorySubscriber) this.f21946b.get()).m22700b();
        } else {
            i = this.f21951g.j();
            Preconditions.checkNotNull(i, "Not reusing player but no default player provided.");
            i.setVisibility(8);
            i.g();
            i.j();
        }
        this.f21950f = null;
        this.f21951g = null;
        this.f21949e = null;
    }
}
