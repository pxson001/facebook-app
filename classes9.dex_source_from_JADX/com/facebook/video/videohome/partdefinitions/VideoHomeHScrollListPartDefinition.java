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
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPaginatedHScrollUnitComponentPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: smil.xml */
public class VideoHomeHScrollListPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment> {
    private static VideoHomeHScrollListPartDefinition f3073b;
    private static final Object f3074c = new Object();
    private final ReactionPaginatedHScrollUnitComponentPartDefinition f3075a;

    private static VideoHomeHScrollListPartDefinition m2945b(InjectorLike injectorLike) {
        return new VideoHomeHScrollListPartDefinition(ReactionPaginatedHScrollUnitComponentPartDefinition.a(injectorLike));
    }

    public final Object m2946a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f3075a, (ReactionUnitComponentNode) obj);
        return null;
    }

    public static boolean m2944a(ReactionUnitComponentNode reactionUnitComponentNode) {
        return reactionUnitComponentNode.b.a() == GraphQLReactionUnitComponentStyle.PAGINATED_H_SCROLL_GENERIC_COMPONENTS_LIST;
    }

    @Inject
    public VideoHomeHScrollListPartDefinition(ReactionPaginatedHScrollUnitComponentPartDefinition reactionPaginatedHScrollUnitComponentPartDefinition) {
        this.f3075a = reactionPaginatedHScrollUnitComponentPartDefinition;
    }

    public static VideoHomeHScrollListPartDefinition m2943a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeHScrollListPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3074c) {
                VideoHomeHScrollListPartDefinition videoHomeHScrollListPartDefinition;
                if (a2 != null) {
                    videoHomeHScrollListPartDefinition = (VideoHomeHScrollListPartDefinition) a2.a(f3074c);
                } else {
                    videoHomeHScrollListPartDefinition = f3073b;
                }
                if (videoHomeHScrollListPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2945b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3074c, b3);
                        } else {
                            f3073b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeHScrollListPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
