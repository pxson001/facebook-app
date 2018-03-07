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
import com.facebook.multirow.api.MultiRowSubParts;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionExpandableSubComponentFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: alert dialog cancelled */
public class ReactionExpandableUnitComponentExpandedPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment> {
    private static ReactionExpandableUnitComponentExpandedPartDefinition f19649b;
    private static final Object f19650c = new Object();
    private final ReactionUnitComponentStyleMapper f19651a;

    private static ReactionExpandableUnitComponentExpandedPartDefinition m23576b(InjectorLike injectorLike) {
        return new ReactionExpandableUnitComponentExpandedPartDefinition(ReactionUnitComponentStyleMapper.m22890a(injectorLike));
    }

    public final Object m23577a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        m23574a(((ReactionUnitComponentModel) reactionUnitComponentNode.f18862b).dm(), baseMultiRowSubParts, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionUnitComponentNode.f18861a);
        return null;
    }

    @Inject
    public ReactionExpandableUnitComponentExpandedPartDefinition(ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper) {
        this.f19651a = reactionUnitComponentStyleMapper;
    }

    public static boolean m23575a(ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        if (reactionUnitComponentFields instanceof ReactionUnitComponentModel) {
            return ((ReactionUnitComponentModel) reactionUnitComponentFields).dm() != null;
        } else {
            return false;
        }
    }

    public static ReactionExpandableUnitComponentExpandedPartDefinition m23573a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionExpandableUnitComponentExpandedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19650c) {
                ReactionExpandableUnitComponentExpandedPartDefinition reactionExpandableUnitComponentExpandedPartDefinition;
                if (a2 != null) {
                    reactionExpandableUnitComponentExpandedPartDefinition = (ReactionExpandableUnitComponentExpandedPartDefinition) a2.a(f19650c);
                } else {
                    reactionExpandableUnitComponentExpandedPartDefinition = f19649b;
                }
                if (reactionExpandableUnitComponentExpandedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23576b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19650c, b3);
                        } else {
                            f19649b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionExpandableUnitComponentExpandedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m23574a(ReactionExpandableSubComponentFragment reactionExpandableSubComponentFragment, MultiRowSubParts<AnyEnvironment> multiRowSubParts, String str, String str2, String str3) {
        multiRowSubParts.a(this.f19651a.m22892a(reactionExpandableSubComponentFragment.a()), new ReactionUnitComponentNode(reactionExpandableSubComponentFragment, str, str2, str3));
    }
}
