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
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: aldrin/ */
public class ReactionFigFooterGroupPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, HasReactionCardContainer> {
    private static ReactionFigFooterGroupPartDefinition f19698c;
    private static final Object f19699d = new Object();
    private final ReactionDividerUnitComponentPartDefinition f19700a;
    private final ReactionFigFooterPartDefinition f19701b;

    private static ReactionFigFooterGroupPartDefinition m23611b(InjectorLike injectorLike) {
        return new ReactionFigFooterGroupPartDefinition(ReactionDividerUnitComponentPartDefinition.m22997a(injectorLike), ReactionFigFooterPartDefinition.m23614a(injectorLike));
    }

    public final Object m23612a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        if (reactionUnitComponentNode.f18862b.aG()) {
            baseMultiRowSubParts.a(this.f19700a, null);
        }
        baseMultiRowSubParts.a(this.f19701b, reactionUnitComponentNode);
        return null;
    }

    public final boolean m23613a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    @Inject
    public ReactionFigFooterGroupPartDefinition(ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition, ReactionFigFooterPartDefinition reactionFigFooterPartDefinition) {
        this.f19700a = reactionDividerUnitComponentPartDefinition;
        this.f19701b = reactionFigFooterPartDefinition;
    }

    public static ReactionFigFooterGroupPartDefinition m23610a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFigFooterGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19699d) {
                ReactionFigFooterGroupPartDefinition reactionFigFooterGroupPartDefinition;
                if (a2 != null) {
                    reactionFigFooterGroupPartDefinition = (ReactionFigFooterGroupPartDefinition) a2.a(f19699d);
                } else {
                    reactionFigFooterGroupPartDefinition = f19698c;
                }
                if (reactionFigFooterGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23611b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19699d, b3);
                        } else {
                            f19698c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFigFooterGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
