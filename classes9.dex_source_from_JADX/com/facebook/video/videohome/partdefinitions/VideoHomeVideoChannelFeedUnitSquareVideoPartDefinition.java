package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ExpandingFixedAspectRatioFrameLayoutPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.video.videohome.environment.CanKnowPosition;
import com.facebook.video.videohome.partdefinitions.VideoHomePlayFullscreenVideoPartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: signed_pre_key_id */
public class VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition<E extends CanKnowPosition> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, View> {
    public static final ViewType<View> f3242a = ViewType.a(2130907731);
    private static VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition f3243e;
    private static final Object f3244f = new Object();
    private final VideoHomeVideoPlayerPartDefinition f3245b;
    private final VideoHomePlayFullscreenVideoPartDefinition f3246c;
    private final ExpandingFixedAspectRatioFrameLayoutPartDefinition f3247d;

    private static VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition m3091b(InjectorLike injectorLike) {
        return new VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition(VideoHomeVideoPlayerPartDefinition.m3107a(injectorLike), VideoHomePlayFullscreenVideoPartDefinition.m2988a(injectorLike), ExpandingFixedAspectRatioFrameLayoutPartDefinition.a(injectorLike));
    }

    public final Object m3093a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanKnowPosition canKnowPosition = (CanKnowPosition) anyEnvironment;
        GraphQLStory ax = reactionUnitComponentNode.b.ax();
        FeedProps a = FeedProps.c(ax).a(StoryAttachmentHelper.o(ax));
        int a2 = canKnowPosition.a(reactionUnitComponentNode.c);
        subParts.a(2131568378, this.f3245b, reactionUnitComponentNode);
        subParts.a(2131568378, this.f3246c, new Props(a, reactionUnitComponentNode.d, a2, reactionUnitComponentNode.c));
        subParts.a(this.f3247d, Double.valueOf(1.0d));
        return null;
    }

    public final boolean m3094a(Object obj) {
        return VideoHomeVideoPlayerPartDefinition.m3111a((ReactionUnitComponentNode) obj);
    }

    @Inject
    public VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition(VideoHomeVideoPlayerPartDefinition videoHomeVideoPlayerPartDefinition, VideoHomePlayFullscreenVideoPartDefinition videoHomePlayFullscreenVideoPartDefinition, ExpandingFixedAspectRatioFrameLayoutPartDefinition expandingFixedAspectRatioFrameLayoutPartDefinition) {
        this.f3245b = videoHomeVideoPlayerPartDefinition;
        this.f3246c = videoHomePlayFullscreenVideoPartDefinition;
        this.f3247d = expandingFixedAspectRatioFrameLayoutPartDefinition;
    }

    public static VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition m3090a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3244f) {
                VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition videoHomeVideoChannelFeedUnitSquareVideoPartDefinition;
                if (a2 != null) {
                    videoHomeVideoChannelFeedUnitSquareVideoPartDefinition = (VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition) a2.a(f3244f);
                } else {
                    videoHomeVideoChannelFeedUnitSquareVideoPartDefinition = f3243e;
                }
                if (videoHomeVideoChannelFeedUnitSquareVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3091b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3244f, b3);
                        } else {
                            f3243e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeVideoChannelFeedUnitSquareVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<View> m3092a() {
        return f3242a;
    }
}
