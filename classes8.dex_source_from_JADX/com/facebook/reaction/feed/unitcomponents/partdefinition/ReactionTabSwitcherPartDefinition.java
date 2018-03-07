package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
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
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import com.facebook.reaction.feed.persistentstate.ReactionTabSwitcherKey;
import com.facebook.reaction.feed.persistentstate.ReactionTabSwitcherPersistentState;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionTabSwitcherComponentFragmentModel.TabsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionTabSwitcherComponentFragmentModel.TabsModel.ComponentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: account_recovery */
public class ReactionTabSwitcherPartDefinition<E extends HasPersistentState> extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, E> {
    private static ReactionTabSwitcherPartDefinition f20093d;
    private static final Object f20094e = new Object();
    private final ReactionDividerUnitComponentPartDefinition f20095a;
    private final ReactionUnitComponentStyleMapper f20096b;
    private final ReactionScrollingLabelPartDefinition f20097c;

    private static ReactionTabSwitcherPartDefinition m23983b(InjectorLike injectorLike) {
        return new ReactionTabSwitcherPartDefinition(ReactionDividerUnitComponentPartDefinition.m22997a(injectorLike), ReactionUnitComponentStyleMapper.m22890a(injectorLike), ReactionScrollingLabelPartDefinition.m23932a(injectorLike));
    }

    public final Object m23984a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        int i = 0;
        ImmutableList dn = ((ReactionUnitComponentModel) reactionUnitComponentNode.f18862b).dn();
        int i2 = ((ReactionTabSwitcherPersistentState) hasPersistentState.a(new ReactionTabSwitcherKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode)).f19183a;
        if (i2 < 0 || i2 >= dn.size()) {
            i2 = 0;
        }
        ComponentModel a = ((TabsModel) dn.get(i2)).a();
        if (a.aG()) {
            baseMultiRowSubParts.a(this.f20095a, a);
        }
        if (reactionUnitComponentNode.f18862b.a() == GraphQLReactionUnitComponentStyle.TAB_SWITCHER_LABELS_AS_HEADER) {
            baseMultiRowSubParts.a(this.f20097c, reactionUnitComponentNode);
        }
        ImmutableList cF = a.cF();
        while (i < cF.size()) {
            ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentFields) cF.get(i);
            if (i > 0 && a.aF()) {
                baseMultiRowSubParts.a(this.f20095a, a);
            }
            MultiRowPartWithIsNeeded a2 = this.f20096b.m22892a(reactionUnitComponentFields.a());
            if (a2 != null) {
                baseMultiRowSubParts.a(a2, new ReactionUnitComponentNode(reactionUnitComponentFields, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionUnitComponentNode.f18861a));
            }
            i++;
        }
        if (a.aD()) {
            baseMultiRowSubParts.a(this.f20095a, a);
        }
        if (reactionUnitComponentNode.f18862b.a() == GraphQLReactionUnitComponentStyle.TAB_SWITCHER_LABELS_ON_BOTTOM) {
            baseMultiRowSubParts.a(this.f20097c, reactionUnitComponentNode);
        }
        return null;
    }

    public final boolean m23985a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        if (!(reactionUnitComponentFields instanceof ReactionUnitComponentModel)) {
            return false;
        }
        ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) reactionUnitComponentFields;
        if (CollectionUtil.a(reactionUnitComponentModel.dn())) {
            return false;
        }
        ImmutableList dn = reactionUnitComponentModel.dn();
        int size = dn.size();
        for (int i = 0; i < size; i++) {
            TabsModel tabsModel = (TabsModel) dn.get(i);
            if (tabsModel.b() == null || Strings.isNullOrEmpty(tabsModel.b().a()) || tabsModel.a() == null) {
                return false;
            }
        }
        return true;
    }

    public static ReactionTabSwitcherPartDefinition m23982a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionTabSwitcherPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20094e) {
                ReactionTabSwitcherPartDefinition reactionTabSwitcherPartDefinition;
                if (a2 != null) {
                    reactionTabSwitcherPartDefinition = (ReactionTabSwitcherPartDefinition) a2.a(f20094e);
                } else {
                    reactionTabSwitcherPartDefinition = f20093d;
                }
                if (reactionTabSwitcherPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23983b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20094e, b3);
                        } else {
                            f20093d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionTabSwitcherPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionTabSwitcherPartDefinition(ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper, ReactionScrollingLabelPartDefinition reactionScrollingLabelPartDefinition) {
        this.f20095a = reactionDividerUnitComponentPartDefinition;
        this.f20096b = reactionUnitComponentStyleMapper;
        this.f20097c = reactionScrollingLabelPartDefinition;
    }
}
