package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel;

@ContextScoped
/* compiled from: small */
public class VideoHomeLoadingMorePartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment, View> {
    private static VideoHomeLoadingMorePartDefinition f3083a;
    private static final Object f3084b = new Object();

    private static VideoHomeLoadingMorePartDefinition m2957b() {
        return new VideoHomeLoadingMorePartDefinition();
    }

    public final boolean m2959a(Object obj) {
        PaginatedComponentsModel c = ReactionUnitComponentUtil.c((ReactionUnitComponentNode) obj);
        if (c == null) {
            return false;
        }
        DefaultPageInfoFields b = c.c().b();
        if (b == null || !b.b()) {
            return false;
        }
        return true;
    }

    public final ViewType m2958a() {
        return VideoHomeSpinnerPartDefinition.f3177a;
    }

    public static VideoHomeLoadingMorePartDefinition m2956a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeLoadingMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3084b) {
                VideoHomeLoadingMorePartDefinition videoHomeLoadingMorePartDefinition;
                if (a2 != null) {
                    videoHomeLoadingMorePartDefinition = (VideoHomeLoadingMorePartDefinition) a2.a(f3084b);
                } else {
                    videoHomeLoadingMorePartDefinition = f3083a;
                }
                if (videoHomeLoadingMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m2957b();
                        if (a2 != null) {
                            a2.a(f3084b, b3);
                        } else {
                            f3083a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeLoadingMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
