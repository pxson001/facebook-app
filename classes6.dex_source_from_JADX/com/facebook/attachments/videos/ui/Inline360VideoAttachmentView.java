package com.facebook.attachments.videos.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.spherical.model.SphericalVideoParams;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.IsVideoSpecDisplayEnabled;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.player.plugins.DebugConsolePlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.List;
import javax.inject.Inject;

/* compiled from: profile_intro_card_set */
public class Inline360VideoAttachmentView extends CustomFrameLayout implements VideoPlayerAttachment, VideoTransitionNode, RecyclerViewKeepAttached {
    @Inject
    @IsVideoSpecDisplayEnabled
    public Boolean f7354a;
    public RichVideoPlayer f7355b;
    private final LayoutParams f7356c;
    private ViewGroup.LayoutParams f7357d;
    public boolean f7358e;
    private String f7359f;

    public static void m10457a(Object obj, Context context) {
        ((Inline360VideoAttachmentView) obj).f7354a = Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(FbInjector.get(context));
    }

    public Inline360VideoAttachmentView(Context context) {
        this(context, null, 0);
    }

    private Inline360VideoAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7358e = true;
        Class cls = Inline360VideoAttachmentView.class;
        m10457a((Object) this, getContext());
        setContentView(2130904928);
        this.f7355b = (RichVideoPlayer) c(2131562414);
        if (this.f7354a.booleanValue()) {
            this.f7355b.a(new DebugConsolePlugin(context));
        }
        this.f7355b.setShouldCropToFit(true);
        this.f7356c = new LayoutParams(-1, -1);
    }

    public final boolean gK_() {
        return true;
    }

    public final void m10458a(int i, int i2) {
        if (getRichVideoPlayer().getParent() == this) {
            int i3 = (int) (((float) i) / 1.7777778f);
            if (this.f7357d == null) {
                this.f7357d = new FrameLayout.LayoutParams(i, i3);
            }
            this.f7357d.width = i;
            this.f7357d.height = i3;
            getRichVideoPlayer().setLayoutParams(this.f7357d);
        }
    }

    public final void m10461b(int i, int i2) {
    }

    public DraweeController getCoverController() {
        return null;
    }

    public void setCoverController(DraweeController draweeController) {
    }

    public void setBackgroundResource(int i) {
    }

    public final void m10459a(VideoPlayerParams videoPlayerParams, FeedProps<GraphQLStoryAttachment> feedProps) {
        if (this.f7358e) {
            ImageRequest imageRequest;
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
            boolean z = (videoPlayerParams == null || graphQLStoryAttachment == null) ? false : true;
            Preconditions.checkArgument(z);
            if (videoPlayerParams.b != this.f7359f) {
                if (this.f7355b.m()) {
                    this.f7355b.b(EventTriggerType.BY_PLAYER);
                }
                this.f7355b.g();
                this.f7359f = videoPlayerParams.b;
            }
            GraphQLStory F = graphQLStoryAttachment.r().F();
            if (!(F == null || StoryActorHelper.b(F) == null)) {
                StoryActorHelper.b(F).aa();
            }
            Builder builder = new Builder();
            Builder b = builder.b("GraphQLStoryProps", AttachmentProps.e(feedProps));
            String str = "CoverImageParamsKey";
            Preconditions.checkNotNull(graphQLStoryAttachment);
            if (graphQLStoryAttachment.r() == null || !GraphQLStoryAttachmentUtil.p(graphQLStoryAttachment) || graphQLStoryAttachment.r().S() == null) {
                imageRequest = null;
            } else {
                imageRequest = ImageRequest.a(graphQLStoryAttachment.r().S().b());
            }
            b.b(str, imageRequest).b("VideoAspectRatioKey", Double.valueOf(1.7777777910232544d));
            RichVideoPlayerParams.Builder builder2 = new RichVideoPlayerParams.Builder();
            builder2.a = videoPlayerParams;
            RichVideoPlayerParams b2 = builder2.a(builder.b()).b();
            if (this.f7354a.booleanValue()) {
                SphericalVideoParams sphericalVideoParams = b2.a.s;
                StringBuilder stringBuilder = new StringBuilder(50);
                if (TextUtils.isEmpty(sphericalVideoParams.f16204b)) {
                    stringBuilder.append("cubemap ");
                } else {
                    stringBuilder.append(sphericalVideoParams.f16204b.toLowerCase()).append(" ");
                }
                stringBuilder.append("yaw:").append(sphericalVideoParams.f16205c).append(" ");
                stringBuilder.append("pitch:").append(sphericalVideoParams.f16206d).append(" ");
                stringBuilder.append("roll:").append(sphericalVideoParams.f16207e);
                this.f7355b.a("360 Meta", stringBuilder.toString());
            }
            getRichVideoPlayer().a(b2);
        }
    }

    public final void m10460a(RichVideoPlayer richVideoPlayer) {
        this.f7355b = richVideoPlayer;
        attachRecyclableViewToParent(richVideoPlayer, 0, this.f7357d);
        this.f7358e = true;
    }

    public final RichVideoPlayer m10462i() {
        detachRecyclableViewFromParent(getRichVideoPlayer());
        this.f7358e = false;
        getRichVideoPlayer().setLayoutParams(this.f7356c);
        return this.f7355b;
    }

    public final RichVideoPlayer m10463j() {
        return this.f7355b;
    }

    public RichVideoPlayer getRichVideoPlayer() {
        return this.f7355b;
    }

    public PlayerType getPlayerType() {
        return PlayerType.INLINE_PLAYER;
    }

    public List<RichVideoPlayerPlugin> getAdditionalPlugins() {
        return null;
    }
}
