package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
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
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: albumName */
public class ReactionFormattedParagraphUnitComponentPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, CanLaunchReactionIntent, View> {
    public static final ViewType f19719a = ViewType.a(2130906623);
    private static ReactionFormattedParagraphUnitComponentPartDefinition f19720d;
    private static final Object f19721e = new Object();
    private final ReactionTextWithEntitiesPartDefinition f19722b;
    private final BasicReactionActionPartDefinition f19723c;

    private static ReactionFormattedParagraphUnitComponentPartDefinition m23640b(InjectorLike injectorLike) {
        return new ReactionFormattedParagraphUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), ReactionTextWithEntitiesPartDefinition.m23423a(injectorLike));
    }

    public final Object m23642a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(2131566648, this.f19722b, new Props(reactionUnitComponentFields.bv(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        if (reactionUnitComponentFields.v() != null) {
            subParts.a(this.f19723c, new BasicReactionActionPartDefinition.Props(reactionUnitComponentFields.v(), reactionUnitComponentFields.bv().a(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return null;
    }

    public final boolean m23643a(Object obj) {
        return ((ReactionUnitComponentNode) obj).f18862b.bv() != null;
    }

    @Inject
    public ReactionFormattedParagraphUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ReactionTextWithEntitiesPartDefinition reactionTextWithEntitiesPartDefinition) {
        this.f19723c = basicReactionActionPartDefinition;
        this.f19722b = reactionTextWithEntitiesPartDefinition;
    }

    public final ViewType m23641a() {
        return f19719a;
    }

    public static ReactionFormattedParagraphUnitComponentPartDefinition m23639a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFormattedParagraphUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19721e) {
                ReactionFormattedParagraphUnitComponentPartDefinition reactionFormattedParagraphUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionFormattedParagraphUnitComponentPartDefinition = (ReactionFormattedParagraphUnitComponentPartDefinition) a2.a(f19721e);
                } else {
                    reactionFormattedParagraphUnitComponentPartDefinition = f19720d;
                }
                if (reactionFormattedParagraphUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23640b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19721e, b3);
                        } else {
                            f19720d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFormattedParagraphUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
