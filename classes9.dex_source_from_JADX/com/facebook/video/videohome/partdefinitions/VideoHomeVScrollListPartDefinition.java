package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
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
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: signingInGoogleApiClients */
public class VideoHomeVScrollListPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment> {
    private static VideoHomeVScrollListPartDefinition f3210d;
    private static final Object f3211e = new Object();
    private final VideoHomeLoadingMorePartDefinition f3212a;
    private final ReactionDividerUnitComponentPartDefinition f3213b;
    private final VideoHomeVideoChannelFeedUnitGroupPartDefinition f3214c;

    private static VideoHomeVScrollListPartDefinition m3061b(InjectorLike injectorLike) {
        return new VideoHomeVScrollListPartDefinition(VideoHomeLoadingMorePartDefinition.m2956a(injectorLike), ReactionDividerUnitComponentPartDefinition.a(injectorLike), VideoHomeVideoChannelFeedUnitGroupPartDefinition.m3069a(injectorLike));
    }

    public final Object m3062a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ImmutableList d = ReactionUnitComponentUtil.d(reactionUnitComponentNode);
        if (!CollectionUtil.a(d)) {
            ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentFields) d.get(0);
            int size = d.size();
            for (int i = 0; i < size; i++) {
                ReactionUnitComponentFields reactionUnitComponentFields2 = (ReactionUnitComponentFields) d.get(i);
                if (reactionUnitComponentFields2 != reactionUnitComponentFields) {
                    baseMultiRowSubParts.a(this.f3213b, null);
                }
                baseMultiRowSubParts.a(this.f3214c, new ReactionUnitComponentNode(reactionUnitComponentFields2, reactionUnitComponentNode.c, reactionUnitComponentNode.d, reactionUnitComponentNode.a));
            }
        }
        baseMultiRowSubParts.a(this.f3212a, reactionUnitComponentNode);
        return null;
    }

    @Inject
    public VideoHomeVScrollListPartDefinition(VideoHomeLoadingMorePartDefinition videoHomeLoadingMorePartDefinition, ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition, VideoHomeVideoChannelFeedUnitGroupPartDefinition videoHomeVideoChannelFeedUnitGroupPartDefinition) {
        this.f3212a = videoHomeLoadingMorePartDefinition;
        this.f3213b = reactionDividerUnitComponentPartDefinition;
        this.f3214c = videoHomeVideoChannelFeedUnitGroupPartDefinition;
    }

    public static boolean m3060a(ReactionUnitComponentNode reactionUnitComponentNode) {
        return ReactionUnitComponentUtil.c(reactionUnitComponentNode) != null && reactionUnitComponentNode.b.a() == GraphQLReactionUnitComponentStyle.PAGINATED_V_SCROLL_GENERIC_COMPONENTS_LIST;
    }

    public static VideoHomeVScrollListPartDefinition m3059a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeVScrollListPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3211e) {
                VideoHomeVScrollListPartDefinition videoHomeVScrollListPartDefinition;
                if (a2 != null) {
                    videoHomeVScrollListPartDefinition = (VideoHomeVScrollListPartDefinition) a2.a(f3211e);
                } else {
                    videoHomeVScrollListPartDefinition = f3210d;
                }
                if (videoHomeVScrollListPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3061b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3211e, b3);
                        } else {
                            f3210d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeVScrollListPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
