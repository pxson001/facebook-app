package com.facebook.reaction.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import javax.inject.Inject;

@ContextScoped
/* compiled from: article_aggregate_view_time */
public class ReactionFacepileHeaderSelectorPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPositionInformation & HasReactionAnalyticsParams & HasReactionSession> extends BaseMultiRowGroupPartDefinition<ReactionCardNode, Void, E> {
    private static ReactionFacepileHeaderSelectorPartDefinition f19214c;
    private static final Object f19215d = new Object();
    private final ReactionSingleFacepileHeaderPartDefinition f19216a;
    private final ReactionMultiFacepileHeaderPartDefinition<E> f19217b;

    private static ReactionFacepileHeaderSelectorPartDefinition m23229b(InjectorLike injectorLike) {
        return new ReactionFacepileHeaderSelectorPartDefinition(ReactionMultiFacepileHeaderPartDefinition.m23275a(injectorLike), ReactionSingleFacepileHeaderPartDefinition.m23286a(injectorLike));
    }

    public final Object m23230a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f19217b, reactionCardNode).a(this.f19216a, reactionCardNode);
        return null;
    }

    @Inject
    public ReactionFacepileHeaderSelectorPartDefinition(ReactionMultiFacepileHeaderPartDefinition reactionMultiFacepileHeaderPartDefinition, ReactionSingleFacepileHeaderPartDefinition reactionSingleFacepileHeaderPartDefinition) {
        this.f19216a = reactionSingleFacepileHeaderPartDefinition;
        this.f19217b = reactionMultiFacepileHeaderPartDefinition;
    }

    public final boolean m23231a(Object obj) {
        return true;
    }

    public static ReactionFacepileHeaderSelectorPartDefinition m23228a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFacepileHeaderSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19215d) {
                ReactionFacepileHeaderSelectorPartDefinition reactionFacepileHeaderSelectorPartDefinition;
                if (a2 != null) {
                    reactionFacepileHeaderSelectorPartDefinition = (ReactionFacepileHeaderSelectorPartDefinition) a2.a(f19215d);
                } else {
                    reactionFacepileHeaderSelectorPartDefinition = f19214c;
                }
                if (reactionFacepileHeaderSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23229b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19215d, b3);
                        } else {
                            f19214c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFacepileHeaderSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
