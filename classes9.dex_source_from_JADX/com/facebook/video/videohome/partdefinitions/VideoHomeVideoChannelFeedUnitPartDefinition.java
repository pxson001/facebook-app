package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoChannelFeedUnitPruneBehavior;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ExpandingFixedAspectRatioFrameLayoutPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.video.channelfeed.VideoHomePublisherInfoPartDefinition;
import com.facebook.video.channelfeed.VideoHomePublisherInfoPartDefinition.Props.Builder;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.video.videohome.environment.CanKnowPosition;
import com.facebook.video.videohome.liveupdates.LiveUpdatesManager;
import com.facebook.video.videohome.partdefinitions.VideoHomePlayFullscreenVideoPartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: signed_pre_key_signature */
public class VideoHomeVideoChannelFeedUnitPartDefinition<E extends CanKnowPosition> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, View> {
    public static final ViewType<View> f3225a = ViewType.a(2130907732);
    private static VideoHomeVideoChannelFeedUnitPartDefinition f3226k;
    private static final Object f3227l = new Object();
    private final VisibilityPartDefinition f3228b;
    private final VideoHomeVideoPlayerPartDefinition f3229c;
    private final VideoHomePlayFullscreenVideoPartDefinition f3230d;
    private final ExpandingFixedAspectRatioFrameLayoutPartDefinition f3231e;
    private final VideoHomePublisherInfoPartDefinition f3232f;
    private final VideoHomeSingleLineDescriptionPartDefinition f3233g;
    private final VideoHomeTagsPartDefinition f3234h;
    public final LiveUpdatesManager f3235i;
    private final QeAccessor f3236j;

    private static VideoHomeVideoChannelFeedUnitPartDefinition m3077b(InjectorLike injectorLike) {
        return new VideoHomeVideoChannelFeedUnitPartDefinition(VisibilityPartDefinition.a(injectorLike), VideoHomeVideoPlayerPartDefinition.m3107a(injectorLike), VideoHomePlayFullscreenVideoPartDefinition.m2988a(injectorLike), ExpandingFixedAspectRatioFrameLayoutPartDefinition.a(injectorLike), VideoHomePublisherInfoPartDefinition.m2586a(injectorLike), VideoHomeSingleLineDescriptionPartDefinition.m3018a(injectorLike), VideoHomeTagsPartDefinition.m3029a(injectorLike), LiveUpdatesManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public static VideoHomeVideoChannelFeedUnitPartDefinition m3075a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeVideoChannelFeedUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3227l) {
                VideoHomeVideoChannelFeedUnitPartDefinition videoHomeVideoChannelFeedUnitPartDefinition;
                if (a2 != null) {
                    videoHomeVideoChannelFeedUnitPartDefinition = (VideoHomeVideoChannelFeedUnitPartDefinition) a2.a(f3227l);
                } else {
                    videoHomeVideoChannelFeedUnitPartDefinition = f3226k;
                }
                if (videoHomeVideoChannelFeedUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3077b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3227l, b3);
                        } else {
                            f3226k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeVideoChannelFeedUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoHomeVideoChannelFeedUnitPartDefinition(VisibilityPartDefinition visibilityPartDefinition, VideoHomeVideoPlayerPartDefinition videoHomeVideoPlayerPartDefinition, VideoHomePlayFullscreenVideoPartDefinition videoHomePlayFullscreenVideoPartDefinition, ExpandingFixedAspectRatioFrameLayoutPartDefinition expandingFixedAspectRatioFrameLayoutPartDefinition, VideoHomePublisherInfoPartDefinition videoHomePublisherInfoPartDefinition, VideoHomeSingleLineDescriptionPartDefinition videoHomeSingleLineDescriptionPartDefinition, VideoHomeTagsPartDefinition videoHomeTagsPartDefinition, LiveUpdatesManager liveUpdatesManager, QeAccessor qeAccessor) {
        this.f3228b = visibilityPartDefinition;
        this.f3229c = videoHomeVideoPlayerPartDefinition;
        this.f3230d = videoHomePlayFullscreenVideoPartDefinition;
        this.f3231e = expandingFixedAspectRatioFrameLayoutPartDefinition;
        this.f3232f = videoHomePublisherInfoPartDefinition;
        this.f3233g = videoHomeSingleLineDescriptionPartDefinition;
        this.f3234h = videoHomeTagsPartDefinition;
        this.f3235i = liveUpdatesManager;
        this.f3236j = qeAccessor;
    }

    private Void m3076a(SubParts<E> subParts, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        int i = 0;
        GraphQLStory ax = reactionUnitComponentNode.f().ax();
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(ax);
        FeedProps c = FeedProps.c(ax);
        FeedProps a = c.a(o);
        int a2 = e.a(reactionUnitComponentNode.k());
        subParts.a(2131568378, this.f3229c, reactionUnitComponentNode);
        subParts.a(2131568378, this.f3230d, new Props(a, reactionUnitComponentNode.l(), a2, reactionUnitComponentNode.k()));
        subParts.a(this.f3231e, Double.valueOf(m3074a((double) ((1.0f * ((float) o.r().bo())) / ((float) o.r().R())))));
        VideoHomePublisherInfoPartDefinition videoHomePublisherInfoPartDefinition = this.f3232f;
        Builder a3 = VideoHomePublisherInfoPartDefinition.Props.m2585a(ax);
        a3.f2690f = reactionUnitComponentNode.l();
        a3 = a3;
        a3.f2692h = a2;
        subParts.a(videoHomePublisherInfoPartDefinition, a3.m2584a());
        subParts.a(this.f3233g, c);
        subParts.a(2131568434, this.f3228b, Integer.valueOf(8));
        int i2 = VideoHomeSingleLineDescriptionPartDefinition.m3019a(c) ? 1 : 0;
        VisibilityPartDefinition visibilityPartDefinition = this.f3228b;
        if (i2 == 0) {
            i = 8;
        }
        subParts.a(2131568435, visibilityPartDefinition, Integer.valueOf(i));
        return null;
    }

    public final boolean m3080a(ReactionUnitComponentNode reactionUnitComponentNode) {
        if (VideoHomeVideoPlayerPartDefinition.m3111a(reactionUnitComponentNode)) {
            GraphQLStory ax = reactionUnitComponentNode.b.ax();
            GraphQLVideoChannelFeedUnitPruneBehavior ce = reactionUnitComponentNode.b.ce();
            Object obj = 1;
            if (ax != null) {
                if (ce == GraphQLVideoChannelFeedUnitPruneBehavior.NONE) {
                    obj = null;
                } else {
                    GraphQLStoryAttachment o = StoryAttachmentHelper.o(ax);
                    if (!(o == null || o.r() == null)) {
                        boolean a = this.f3235i.a(o.r());
                        if (ce == GraphQLVideoChannelFeedUnitPruneBehavior.SEAL) {
                            a |= o.r().br() == GraphQLVideoBroadcastStatus.VOD_READY ? 1 : 0;
                        }
                        if (a) {
                            obj = null;
                        }
                    }
                }
            }
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public final ViewType<View> m3078a() {
        return f3225a;
    }

    private double m3074a(double d) {
        return Math.max(d, (double) this.f3236j.a(ExperimentsForVideoHomeAbTestModule.D, 1.0f));
    }
}
