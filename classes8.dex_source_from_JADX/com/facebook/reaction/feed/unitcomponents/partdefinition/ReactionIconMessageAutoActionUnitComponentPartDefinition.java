package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionDelayedActionPartDefinition;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionIconMessageWithMenuPartDefinition;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: aggregated_claim_count */
public class ReactionIconMessageAutoActionUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, LinearLayout> {
    public static final ViewType f19783a = ViewType.a(2130906630);
    private static ReactionIconMessageAutoActionUnitComponentPartDefinition f19784d;
    private static final Object f19785e = new Object();
    private final ReactionDelayedActionPartDefinition f19786b;
    private final ReactionIconMessageWithMenuPartDefinition f19787c;

    private static ReactionIconMessageAutoActionUnitComponentPartDefinition m23692b(InjectorLike injectorLike) {
        return new ReactionIconMessageAutoActionUnitComponentPartDefinition(ReactionDelayedActionPartDefinition.m24302a(injectorLike), ReactionIconMessageWithMenuPartDefinition.m24325a(injectorLike));
    }

    public final Object m23694a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        subParts.a(this.f19787c, reactionUnitComponentNode);
        if (reactionUnitComponentNode.f18862b.v() != null) {
            subParts.a(this.f19786b, reactionUnitComponentNode);
        }
        return null;
    }

    public final boolean m23695a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    @Inject
    public ReactionIconMessageAutoActionUnitComponentPartDefinition(ReactionDelayedActionPartDefinition reactionDelayedActionPartDefinition, ReactionIconMessageWithMenuPartDefinition reactionIconMessageWithMenuPartDefinition) {
        this.f19786b = reactionDelayedActionPartDefinition;
        this.f19787c = reactionIconMessageWithMenuPartDefinition;
    }

    public final ViewType m23693a() {
        return f19783a;
    }

    public static ReactionIconMessageAutoActionUnitComponentPartDefinition m23691a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconMessageAutoActionUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19785e) {
                ReactionIconMessageAutoActionUnitComponentPartDefinition reactionIconMessageAutoActionUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionIconMessageAutoActionUnitComponentPartDefinition = (ReactionIconMessageAutoActionUnitComponentPartDefinition) a2.a(f19785e);
                } else {
                    reactionIconMessageAutoActionUnitComponentPartDefinition = f19784d;
                }
                if (reactionIconMessageAutoActionUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23692b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19785e, b3);
                        } else {
                            f19784d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconMessageAutoActionUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
