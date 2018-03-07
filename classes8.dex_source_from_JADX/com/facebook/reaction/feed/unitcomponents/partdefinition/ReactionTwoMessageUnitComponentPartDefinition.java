package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.rows.subparts.ReactionTitleAndLabelViewPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionTitleAndLabelViewPartDefinition.Props;
import com.facebook.reaction.feed.rows.ui.ReactionTitleAndLabelView;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: account_logout */
public class ReactionTwoMessageUnitComponentPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment, ReactionTitleAndLabelView> {
    public static final ViewType<ReactionTitleAndLabelView> f20108a = ViewType.a(2130906689);
    private static ReactionTwoMessageUnitComponentPartDefinition f20109c;
    private static final Object f20110d = new Object();
    private final ReactionTitleAndLabelViewPartDefinition f20111b;

    private static ReactionTwoMessageUnitComponentPartDefinition m23998b(InjectorLike injectorLike) {
        return new ReactionTwoMessageUnitComponentPartDefinition(ReactionTitleAndLabelViewPartDefinition.m23428a(injectorLike));
    }

    public static boolean m23997a(ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.cI() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.cI().a())) ? false : true;
    }

    public final Object m24000a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        subParts.a(this.f20111b, new Props(reactionUnitComponentNode.f18862b.bv().a(), reactionUnitComponentNode.f18862b.cI().a(), 2131624396, 2131625836));
        return null;
    }

    @Inject
    public ReactionTwoMessageUnitComponentPartDefinition(ReactionTitleAndLabelViewPartDefinition reactionTitleAndLabelViewPartDefinition) {
        this.f20111b = reactionTitleAndLabelViewPartDefinition;
    }

    public final ViewType<ReactionTitleAndLabelView> m23999a() {
        return f20108a;
    }

    public static ReactionTwoMessageUnitComponentPartDefinition m23996a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionTwoMessageUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20110d) {
                ReactionTwoMessageUnitComponentPartDefinition reactionTwoMessageUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionTwoMessageUnitComponentPartDefinition = (ReactionTwoMessageUnitComponentPartDefinition) a2.a(f20110d);
                } else {
                    reactionTwoMessageUnitComponentPartDefinition = f20109c;
                }
                if (reactionTwoMessageUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23998b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20110d, b3);
                        } else {
                            f20109c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionTwoMessageUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
