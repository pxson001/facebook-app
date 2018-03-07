package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionRatingBarPartDefinition.Prop;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.PageModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_source */
public class ReactionReviewComposerUnitComponentPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, HasContext, LinearLayout> {
    public static final ViewType<LinearLayout> f20027a = ViewType.a(2130906648);
    private static ReactionReviewComposerUnitComponentPartDefinition f20028d;
    private static final Object f20029e = new Object();
    private final ReactionRatingBarPartDefinition f20030b;
    private final TextOrHiddenPartDefinition f20031c;

    private static ReactionReviewComposerUnitComponentPartDefinition m23915b(InjectorLike injectorLike) {
        return new ReactionReviewComposerUnitComponentPartDefinition(ReactionRatingBarPartDefinition.m23909a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike));
    }

    public final Object m23917a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        subParts.a(2131566686, this.f20031c, reactionUnitComponentNode.f18862b.cU().a());
        TextOrHiddenPartDefinition textOrHiddenPartDefinition = this.f20031c;
        DefaultTextWithEntitiesFields cL = reactionUnitComponentNode.f18862b.cL();
        if (cL == null || Strings.isNullOrEmpty(cL.a())) {
            str = null;
        } else {
            str = cL.a();
        }
        subParts.a(2131566687, textOrHiddenPartDefinition, str);
        subParts.a(2131566689, this.f20031c, reactionUnitComponentNode.f18862b.aA().a());
        subParts.a(2131566688, this.f20030b, new Prop(reactionUnitComponentNode.f18862b.bI().b(), reactionUnitComponentNode.f18862b.bI().c(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        return null;
    }

    public final boolean m23918a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        DefaultTextWithEntitiesFields cU = reactionUnitComponentNode.f18862b.cU();
        DefaultTextWithEntitiesFields aA = reactionUnitComponentNode.f18862b.aA();
        PageModel bI = reactionUnitComponentNode.f18862b.bI();
        return (cU == null || Strings.isNullOrEmpty(cU.a()) || aA == null || Strings.isNullOrEmpty(aA.a()) || bI == null || Strings.isNullOrEmpty(bI.b()) || Strings.isNullOrEmpty(bI.c())) ? false : true;
    }

    @Inject
    public ReactionReviewComposerUnitComponentPartDefinition(ReactionRatingBarPartDefinition reactionRatingBarPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition) {
        this.f20030b = reactionRatingBarPartDefinition;
        this.f20031c = textOrHiddenPartDefinition;
    }

    public static ReactionReviewComposerUnitComponentPartDefinition m23914a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionReviewComposerUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20029e) {
                ReactionReviewComposerUnitComponentPartDefinition reactionReviewComposerUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionReviewComposerUnitComponentPartDefinition = (ReactionReviewComposerUnitComponentPartDefinition) a2.a(f20029e);
                } else {
                    reactionReviewComposerUnitComponentPartDefinition = f20028d;
                }
                if (reactionReviewComposerUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23915b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20029e, b3);
                        } else {
                            f20028d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionReviewComposerUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<LinearLayout> m23916a() {
        return f20027a;
    }
}
