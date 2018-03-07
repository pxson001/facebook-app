package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.HiddenUnitGroupPartDefinition;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: signed_pre_key_with_id */
public class VideoHomeVideoChannelFeedUnitGroupPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment> {
    private static VideoHomeVideoChannelFeedUnitGroupPartDefinition f3221c;
    private static final Object f3222d = new Object();
    private final VideoHomeVideoChannelFeedUnitPartDefinition f3223a;
    private final HiddenUnitGroupPartDefinition f3224b;

    private static VideoHomeVideoChannelFeedUnitGroupPartDefinition m3070b(InjectorLike injectorLike) {
        return new VideoHomeVideoChannelFeedUnitGroupPartDefinition(VideoHomeVideoChannelFeedUnitPartDefinition.m3075a(injectorLike), HiddenUnitGroupPartDefinition.a(injectorLike));
    }

    public final Object m3071a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f3224b, FeedProps.c(reactionUnitComponentNode.b.ax())).a(this.f3223a, reactionUnitComponentNode);
        return null;
    }

    @Inject
    public VideoHomeVideoChannelFeedUnitGroupPartDefinition(VideoHomeVideoChannelFeedUnitPartDefinition videoHomeVideoChannelFeedUnitPartDefinition, HiddenUnitGroupPartDefinition hiddenUnitGroupPartDefinition) {
        this.f3223a = videoHomeVideoChannelFeedUnitPartDefinition;
        this.f3224b = hiddenUnitGroupPartDefinition;
    }

    public final boolean m3072a(ReactionUnitComponentNode reactionUnitComponentNode) {
        if (reactionUnitComponentNode.b != null && reactionUnitComponentNode.b.a() == GraphQLReactionUnitComponentStyle.VIDEO_CHANNEL_FEED_UNIT && this.f3223a.m3080a(reactionUnitComponentNode)) {
            return true;
        }
        return false;
    }

    public static VideoHomeVideoChannelFeedUnitGroupPartDefinition m3069a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeVideoChannelFeedUnitGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3222d) {
                VideoHomeVideoChannelFeedUnitGroupPartDefinition videoHomeVideoChannelFeedUnitGroupPartDefinition;
                if (a2 != null) {
                    videoHomeVideoChannelFeedUnitGroupPartDefinition = (VideoHomeVideoChannelFeedUnitGroupPartDefinition) a2.a(f3222d);
                } else {
                    videoHomeVideoChannelFeedUnitGroupPartDefinition = f3221c;
                }
                if (videoHomeVideoChannelFeedUnitGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3070b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3222d, b3);
                        } else {
                            f3221c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeVideoChannelFeedUnitGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
