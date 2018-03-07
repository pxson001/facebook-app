package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
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
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: add_contactpoint_type */
public class ReactionPaginatedVScrollGenericComponentsListPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment> {
    private static ReactionPaginatedVScrollGenericComponentsListPartDefinition f19913c;
    private static final Object f19914d = new Object();
    private final ReactionUnitComponentStyleMapper f19915a;
    private final ReactionDividerUnitComponentPartDefinition f19916b;

    private static ReactionPaginatedVScrollGenericComponentsListPartDefinition m23817b(InjectorLike injectorLike) {
        return new ReactionPaginatedVScrollGenericComponentsListPartDefinition(ReactionUnitComponentStyleMapper.m22890a(injectorLike), ReactionDividerUnitComponentPartDefinition.m22997a(injectorLike));
    }

    public final Object m23818a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ImmutableList d = ReactionUnitComponentUtil.m22904d(reactionUnitComponentNode);
        if (!CollectionUtil.a(d)) {
            ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentFields) d.get(0);
            int size = d.size();
            for (int i = 0; i < size; i++) {
                ReactionUnitComponentFields reactionUnitComponentFields2 = (ReactionUnitComponentFields) d.get(i);
                if (reactionUnitComponentFields2 != reactionUnitComponentFields) {
                    baseMultiRowSubParts.a(this.f19916b, null);
                }
                baseMultiRowSubParts.a(this.f19915a.m22892a(reactionUnitComponentFields2.a()), new ReactionUnitComponentNode(reactionUnitComponentFields2, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionUnitComponentNode.f18861a));
            }
        }
        return null;
    }

    public final boolean m23819a(Object obj) {
        return ReactionUnitComponentUtil.m22903c((ReactionUnitComponentNode) obj) != null;
    }

    @Inject
    public ReactionPaginatedVScrollGenericComponentsListPartDefinition(ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper, ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition) {
        this.f19915a = reactionUnitComponentStyleMapper;
        this.f19916b = reactionDividerUnitComponentPartDefinition;
    }

    public static ReactionPaginatedVScrollGenericComponentsListPartDefinition m23816a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPaginatedVScrollGenericComponentsListPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19914d) {
                ReactionPaginatedVScrollGenericComponentsListPartDefinition reactionPaginatedVScrollGenericComponentsListPartDefinition;
                if (a2 != null) {
                    reactionPaginatedVScrollGenericComponentsListPartDefinition = (ReactionPaginatedVScrollGenericComponentsListPartDefinition) a2.a(f19914d);
                } else {
                    reactionPaginatedVScrollGenericComponentsListPartDefinition = f19913c;
                }
                if (reactionPaginatedVScrollGenericComponentsListPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23817b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19914d, b3);
                        } else {
                            f19913c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPaginatedVScrollGenericComponentsListPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
