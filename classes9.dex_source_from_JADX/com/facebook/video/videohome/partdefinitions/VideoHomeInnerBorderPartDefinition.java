package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitStaticAggregationComponentFields;

@ContextScoped
/* compiled from: smil */
public class VideoHomeInnerBorderPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment, View> {
    private static VideoHomeInnerBorderPartDefinition f3076a;
    private static final Object f3077b = new Object();

    private static VideoHomeInnerBorderPartDefinition m2949b() {
        return new VideoHomeInnerBorderPartDefinition();
    }

    public final boolean m2951a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        if (reactionUnitComponentNode.b instanceof ReactionUnitStaticAggregationComponentFields) {
            return ((ReactionUnitStaticAggregationComponentFields) reactionUnitComponentNode.b).aF();
        }
        return false;
    }

    public final ViewType m2950a() {
        return VideoHomeTopBorderPartDefinition.f3184a;
    }

    public static VideoHomeInnerBorderPartDefinition m2948a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeInnerBorderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3077b) {
                VideoHomeInnerBorderPartDefinition videoHomeInnerBorderPartDefinition;
                if (a2 != null) {
                    videoHomeInnerBorderPartDefinition = (VideoHomeInnerBorderPartDefinition) a2.a(f3077b);
                } else {
                    videoHomeInnerBorderPartDefinition = f3076a;
                }
                if (videoHomeInnerBorderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m2949b();
                        if (a2 != null) {
                            a2.a(f3077b, b3);
                        } else {
                            f3076a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeInnerBorderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
