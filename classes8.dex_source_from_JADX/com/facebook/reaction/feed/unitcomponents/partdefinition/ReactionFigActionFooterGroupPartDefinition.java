package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import javax.inject.Inject;

@ContextScoped
/* compiled from: aldrin_status_last_fetch_fail_cooldown_time */
public class ReactionFigActionFooterGroupPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, HasReactionCardContainer> {
    private static ReactionFigActionFooterGroupPartDefinition f19686c;
    private static final Object f19687d = new Object();
    private final ReactionDividerUnitComponentPartDefinition f19688a;
    private final ReactionFigActionFooterPartDefinition f19689b;

    private static ReactionFigActionFooterGroupPartDefinition m23602b(InjectorLike injectorLike) {
        return new ReactionFigActionFooterGroupPartDefinition(ReactionDividerUnitComponentPartDefinition.m22997a(injectorLike), ReactionFigActionFooterPartDefinition.m23605a(injectorLike));
    }

    public final Object m23603a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        if (reactionUnitComponentNode.f18862b.aG()) {
            baseMultiRowSubParts.a(this.f19688a, null);
        }
        baseMultiRowSubParts.a(this.f19689b, reactionUnitComponentNode);
        return null;
    }

    @Inject
    public ReactionFigActionFooterGroupPartDefinition(ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition, ReactionFigActionFooterPartDefinition reactionFigActionFooterPartDefinition) {
        this.f19688a = reactionDividerUnitComponentPartDefinition;
        this.f19689b = reactionFigActionFooterPartDefinition;
    }

    public final boolean m23604a(Object obj) {
        return true;
    }

    public static ReactionFigActionFooterGroupPartDefinition m23601a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFigActionFooterGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19687d) {
                ReactionFigActionFooterGroupPartDefinition reactionFigActionFooterGroupPartDefinition;
                if (a2 != null) {
                    reactionFigActionFooterGroupPartDefinition = (ReactionFigActionFooterGroupPartDefinition) a2.a(f19687d);
                } else {
                    reactionFigActionFooterGroupPartDefinition = f19686c;
                }
                if (reactionFigActionFooterGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23602b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19687d, b3);
                        } else {
                            f19686c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFigActionFooterGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
