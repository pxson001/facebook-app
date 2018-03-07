package com.facebook.reaction.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg_dialog_height */
public class ReactionStoryFooterSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionCardNode, Void, AnyEnvironment> {
    private static ReactionStoryFooterSelectorPartDefinition f19289c;
    private static final Object f19290d = new Object();
    private final Lazy<ReactionMultiActionFooterPartDefinition> f19291a;
    private final Lazy<ReactionSingleActionFooterPartDefinition> f19292b;

    private static ReactionStoryFooterSelectorPartDefinition m23297b(InjectorLike injectorLike) {
        return new ReactionStoryFooterSelectorPartDefinition(IdBasedLazy.a(injectorLike, 9899), IdBasedLazy.a(injectorLike, 9901));
    }

    public final Object m23298a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        SubPartsSelector.a(baseMultiRowSubParts, (MultiRowSinglePartDefinition) this.f19291a.get(), reactionCardNode).a((MultiRowSinglePartDefinition) this.f19292b.get(), reactionCardNode);
        return null;
    }

    public final boolean m23299a(Object obj) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        if (!(reactionCardNode.mo1117k().fx_() == null || reactionCardNode.mo1117k().fx_().a().isEmpty())) {
            Object obj2;
            ImmutableList a = reactionCardNode.mo1117k().fx_().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) a.get(i);
                if (reactionStoryAttachmentActionFragmentModel.fU_() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionFragmentModel.fU_().a())) {
                    obj2 = 1;
                    break;
                }
            }
            obj2 = null;
            if (obj2 == null) {
                return true;
            }
        }
        return false;
    }

    @Inject
    public ReactionStoryFooterSelectorPartDefinition(Lazy<ReactionMultiActionFooterPartDefinition> lazy, Lazy<ReactionSingleActionFooterPartDefinition> lazy2) {
        this.f19291a = lazy;
        this.f19292b = lazy2;
    }

    public static ReactionStoryFooterSelectorPartDefinition m23296a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionStoryFooterSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19290d) {
                ReactionStoryFooterSelectorPartDefinition reactionStoryFooterSelectorPartDefinition;
                if (a2 != null) {
                    reactionStoryFooterSelectorPartDefinition = (ReactionStoryFooterSelectorPartDefinition) a2.a(f19290d);
                } else {
                    reactionStoryFooterSelectorPartDefinition = f19289c;
                }
                if (reactionStoryFooterSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23297b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19290d, b3);
                        } else {
                            f19289c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionStoryFooterSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
