package com.facebook.reaction.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import javax.inject.Inject;

@ContextScoped
/* compiled from: article_ID */
public class ReactionIconHeaderSelectorPartDefinition<E extends CanLaunchReactionIntent & HasReactionInteractionTracker & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends BaseMultiRowGroupPartDefinition<ReactionCardNode, Void, E> {
    private static ReactionIconHeaderSelectorPartDefinition f19222d;
    private static final Object f19223e = new Object();
    private final ReactionIconHeaderPartDefinition<E> f19224a;
    private final ReactionIconHeaderWithActionPartDefinition<E> f19225b;
    private final ReactionIconMenuHeaderPartDefinition<E> f19226c;

    private static ReactionIconHeaderSelectorPartDefinition m23238b(InjectorLike injectorLike) {
        return new ReactionIconHeaderSelectorPartDefinition(ReactionIconHeaderPartDefinition.m23232a(injectorLike), ReactionIconHeaderWithActionPartDefinition.m23241a(injectorLike), ReactionIconMenuHeaderPartDefinition.m23256a(injectorLike));
    }

    public final Object m23239a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f19226c, reactionCardNode).a(this.f19225b, reactionCardNode).a(this.f19224a, reactionCardNode);
        return null;
    }

    @Inject
    public ReactionIconHeaderSelectorPartDefinition(ReactionIconHeaderPartDefinition reactionIconHeaderPartDefinition, ReactionIconHeaderWithActionPartDefinition reactionIconHeaderWithActionPartDefinition, ReactionIconMenuHeaderPartDefinition reactionIconMenuHeaderPartDefinition) {
        this.f19224a = reactionIconHeaderPartDefinition;
        this.f19225b = reactionIconHeaderWithActionPartDefinition;
        this.f19226c = reactionIconMenuHeaderPartDefinition;
    }

    public final boolean m23240a(Object obj) {
        return true;
    }

    public static ReactionIconHeaderSelectorPartDefinition m23237a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconHeaderSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19223e) {
                ReactionIconHeaderSelectorPartDefinition reactionIconHeaderSelectorPartDefinition;
                if (a2 != null) {
                    reactionIconHeaderSelectorPartDefinition = (ReactionIconHeaderSelectorPartDefinition) a2.a(f19223e);
                } else {
                    reactionIconHeaderSelectorPartDefinition = f19222d;
                }
                if (reactionIconHeaderSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23238b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19223e, b3);
                        } else {
                            f19222d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconHeaderSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
