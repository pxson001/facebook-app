package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: account_search_use_query_now */
public class ReactionSingleButtonUnitComponentPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment, View> {
    public static final ViewType f20065a = new C21461();
    private static ReactionSingleButtonUnitComponentPartDefinition f20066d;
    private static final Object f20067e = new Object();
    private final BasicReactionActionPartDefinition f20068b;
    private final TextPartDefinition f20069c;

    /* compiled from: account_search_use_query_now */
    final class C21461 extends ViewType {
        C21461() {
        }

        public final View m23955a(Context context) {
            return LayoutInflater.from(context).inflate(2130906650, null, false);
        }
    }

    private static ReactionSingleButtonUnitComponentPartDefinition m23957b(InjectorLike injectorLike) {
        return new ReactionSingleButtonUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23959a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) reactionUnitComponentNode.f18862b.w().get(0);
        subParts.a(2131566690, this.f20069c, reactionStoryAttachmentActionFragmentModel.fU_().a());
        subParts.a(this.f20068b, new Props(reactionStoryAttachmentActionFragmentModel, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        subParts.a(2131566690, this.f20068b, new Props(reactionStoryAttachmentActionFragmentModel, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        return null;
    }

    public final boolean m23960a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.a() != GraphQLReactionUnitComponentStyle.SINGLE_BUTTON || reactionUnitComponentFields.w().isEmpty() || ((ReactionStoryAttachmentActionFragmentModel) reactionUnitComponentFields.w().get(0)).fU_() == null || Strings.isNullOrEmpty(((ReactionStoryAttachmentActionFragmentModel) reactionUnitComponentFields.w().get(0)).fU_().a())) ? false : true;
    }

    @Inject
    public ReactionSingleButtonUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, TextPartDefinition textPartDefinition) {
        this.f20068b = basicReactionActionPartDefinition;
        this.f20069c = textPartDefinition;
    }

    public static ReactionSingleButtonUnitComponentPartDefinition m23956a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSingleButtonUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20067e) {
                ReactionSingleButtonUnitComponentPartDefinition reactionSingleButtonUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionSingleButtonUnitComponentPartDefinition = (ReactionSingleButtonUnitComponentPartDefinition) a2.a(f20067e);
                } else {
                    reactionSingleButtonUnitComponentPartDefinition = f20066d;
                }
                if (reactionSingleButtonUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23957b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20067e, b3);
                        } else {
                            f20066d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSingleButtonUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23958a() {
        return f20065a;
    }
}
