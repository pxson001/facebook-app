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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: alert dialog discard button */
public class ReactionExpandableUnitComponentCollapsedPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, HasContext> {
    private static ReactionExpandableUnitComponentCollapsedPartDefinition f19645c;
    private static final Object f19646d = new Object();
    private final ReactionExpandableUnitComponentPromptPartDefinition f19647a;
    private final ReactionUnitComponentStyleMapper f19648b;

    private static ReactionExpandableUnitComponentCollapsedPartDefinition m23570b(InjectorLike injectorLike) {
        return new ReactionExpandableUnitComponentCollapsedPartDefinition(ReactionExpandableUnitComponentPromptPartDefinition.m23583a(injectorLike), ReactionUnitComponentStyleMapper.m22890a(injectorLike));
    }

    public final Object m23571a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentNode a = ReactionUnitComponentUtil.m22895a(reactionUnitComponentNode);
        MultiRowPartWithIsNeeded a2 = this.f19648b.m22892a(a.f18862b.a());
        SubPartsSelector a3 = SubPartsSelector.a(baseMultiRowSubParts, this.f19647a, reactionUnitComponentNode);
        if (!a3.b) {
            a3.b = a3.a.a(a2, a);
        }
        return null;
    }

    @Inject
    public ReactionExpandableUnitComponentCollapsedPartDefinition(ReactionExpandableUnitComponentPromptPartDefinition reactionExpandableUnitComponentPromptPartDefinition, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper) {
        this.f19647a = reactionExpandableUnitComponentPromptPartDefinition;
        this.f19648b = reactionUnitComponentStyleMapper;
    }

    public static boolean m23569a(ReactionUnitComponentNode reactionUnitComponentNode) {
        return ReactionUnitComponentUtil.m22895a(reactionUnitComponentNode) != null;
    }

    public static ReactionExpandableUnitComponentCollapsedPartDefinition m23568a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionExpandableUnitComponentCollapsedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19646d) {
                ReactionExpandableUnitComponentCollapsedPartDefinition reactionExpandableUnitComponentCollapsedPartDefinition;
                if (a2 != null) {
                    reactionExpandableUnitComponentCollapsedPartDefinition = (ReactionExpandableUnitComponentCollapsedPartDefinition) a2.a(f19646d);
                } else {
                    reactionExpandableUnitComponentCollapsedPartDefinition = f19645c;
                }
                if (reactionExpandableUnitComponentCollapsedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23570b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19646d, b3);
                        } else {
                            f19645c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionExpandableUnitComponentCollapsedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
