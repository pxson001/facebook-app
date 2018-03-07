package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: signed_pre_keys */
public class VideoHomeVerticalListPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment> {
    private static VideoHomeVerticalListPartDefinition f3215e;
    private static final Object f3216f = new Object();
    private final VideoHomeTopBorderPartDefinition f3217a;
    private final VideoHomeInnerBorderPartDefinition f3218b;
    private final VideoHomeBottomBorderPartDefinition f3219c;
    private final VideoHomeVideoChannelFeedUnitGroupPartDefinition f3220d;

    private static VideoHomeVerticalListPartDefinition m3066b(InjectorLike injectorLike) {
        return new VideoHomeVerticalListPartDefinition(VideoHomeTopBorderPartDefinition.m3035a(injectorLike), VideoHomeInnerBorderPartDefinition.m2948a(injectorLike), VideoHomeBottomBorderPartDefinition.m2906a(injectorLike), VideoHomeVideoChannelFeedUnitGroupPartDefinition.m3069a(injectorLike));
    }

    public final Object m3067a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ImmutableList b = ReactionUnitComponentUtil.b(reactionUnitComponentNode);
        baseMultiRowSubParts.a(this.f3217a, reactionUnitComponentNode);
        for (int i = 0; i < b.size(); i++) {
            ReactionUnitComponentNode reactionUnitComponentNode2 = new ReactionUnitComponentNode((ReactionUnitComponentFields) b.get(i), reactionUnitComponentNode.c, reactionUnitComponentNode.d, reactionUnitComponentNode.a);
            if (i > 0) {
                baseMultiRowSubParts.a(this.f3218b, reactionUnitComponentNode);
            }
            baseMultiRowSubParts.a(this.f3220d, reactionUnitComponentNode2);
        }
        baseMultiRowSubParts.a(this.f3219c, reactionUnitComponentNode);
        return null;
    }

    public static boolean m3065a(ReactionUnitComponentNode reactionUnitComponentNode) {
        return reactionUnitComponentNode.b.a() == GraphQLReactionUnitComponentStyle.VERTICAL_COMPONENTS_LIST && ReactionUnitComponentUtil.b(reactionUnitComponentNode) != null;
    }

    @Inject
    public VideoHomeVerticalListPartDefinition(VideoHomeTopBorderPartDefinition videoHomeTopBorderPartDefinition, VideoHomeInnerBorderPartDefinition videoHomeInnerBorderPartDefinition, VideoHomeBottomBorderPartDefinition videoHomeBottomBorderPartDefinition, VideoHomeVideoChannelFeedUnitGroupPartDefinition videoHomeVideoChannelFeedUnitGroupPartDefinition) {
        this.f3217a = videoHomeTopBorderPartDefinition;
        this.f3218b = videoHomeInnerBorderPartDefinition;
        this.f3219c = videoHomeBottomBorderPartDefinition;
        this.f3220d = videoHomeVideoChannelFeedUnitGroupPartDefinition;
    }

    public static VideoHomeVerticalListPartDefinition m3064a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeVerticalListPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3216f) {
                VideoHomeVerticalListPartDefinition videoHomeVerticalListPartDefinition;
                if (a2 != null) {
                    videoHomeVerticalListPartDefinition = (VideoHomeVerticalListPartDefinition) a2.a(f3216f);
                } else {
                    videoHomeVerticalListPartDefinition = f3215e;
                }
                if (videoHomeVerticalListPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3066b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3216f, b3);
                        } else {
                            f3215e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeVerticalListPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
