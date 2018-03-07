package com.facebook.reaction.feed.unitcomponents.partdefinition;

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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import javax.inject.Inject;

@ContextScoped
/* compiled from: advanced_filters */
public class ReactionIconMessageUnitComponentSelector<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, E> {
    private static ReactionIconMessageUnitComponentSelector f19799c;
    private static final Object f19800d = new Object();
    private final ReactionIconMessageUnitComponentPartDefinition<E> f19801a;
    private final ReactionIconMessageUnitComponentWithMenuPartDefinition<E> f19802b;

    private static ReactionIconMessageUnitComponentSelector m23713b(InjectorLike injectorLike) {
        return new ReactionIconMessageUnitComponentSelector(ReactionIconMessageUnitComponentPartDefinition.m23706a(injectorLike), ReactionIconMessageUnitComponentWithMenuPartDefinition.m23716a(injectorLike));
    }

    public final Object m23714a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f19802b, reactionUnitComponentNode).a(this.f19801a, reactionUnitComponentNode);
        return null;
    }

    @Inject
    public ReactionIconMessageUnitComponentSelector(ReactionIconMessageUnitComponentPartDefinition reactionIconMessageUnitComponentPartDefinition, ReactionIconMessageUnitComponentWithMenuPartDefinition reactionIconMessageUnitComponentWithMenuPartDefinition) {
        this.f19801a = reactionIconMessageUnitComponentPartDefinition;
        this.f19802b = reactionIconMessageUnitComponentWithMenuPartDefinition;
    }

    public final boolean m23715a(Object obj) {
        return true;
    }

    public static ReactionIconMessageUnitComponentSelector m23712a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconMessageUnitComponentSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19800d) {
                ReactionIconMessageUnitComponentSelector reactionIconMessageUnitComponentSelector;
                if (a2 != null) {
                    reactionIconMessageUnitComponentSelector = (ReactionIconMessageUnitComponentSelector) a2.a(f19800d);
                } else {
                    reactionIconMessageUnitComponentSelector = f19799c;
                }
                if (reactionIconMessageUnitComponentSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23713b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19800d, b3);
                        } else {
                            f19799c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconMessageUnitComponentSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
