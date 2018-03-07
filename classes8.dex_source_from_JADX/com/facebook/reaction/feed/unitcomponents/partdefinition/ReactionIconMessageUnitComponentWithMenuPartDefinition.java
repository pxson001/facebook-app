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
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionIconMessageWithMenuPartDefinition;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ads_invoice */
public class ReactionIconMessageUnitComponentWithMenuPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, LinearLayout> {
    public static final ViewType f19803a = ViewType.a(2130906630);
    private static ReactionIconMessageUnitComponentWithMenuPartDefinition f19804d;
    private static final Object f19805e = new Object();
    private final BasicReactionActionPartDefinition f19806b;
    private final ReactionIconMessageWithMenuPartDefinition f19807c;

    private static ReactionIconMessageUnitComponentWithMenuPartDefinition m23717b(InjectorLike injectorLike) {
        return new ReactionIconMessageUnitComponentWithMenuPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), ReactionIconMessageWithMenuPartDefinition.m24325a(injectorLike));
    }

    public final Object m23719a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        subParts.a(this.f19807c, reactionUnitComponentNode);
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentNode.f18862b.v();
        if (v != null) {
            subParts.a(this.f19806b, new Props(v, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return null;
    }

    public final boolean m23720a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.cu().isEmpty()) ? false : true;
    }

    @Inject
    public ReactionIconMessageUnitComponentWithMenuPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ReactionIconMessageWithMenuPartDefinition reactionIconMessageWithMenuPartDefinition) {
        this.f19806b = basicReactionActionPartDefinition;
        this.f19807c = reactionIconMessageWithMenuPartDefinition;
    }

    public final ViewType m23718a() {
        return f19803a;
    }

    public static ReactionIconMessageUnitComponentWithMenuPartDefinition m23716a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconMessageUnitComponentWithMenuPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19805e) {
                ReactionIconMessageUnitComponentWithMenuPartDefinition reactionIconMessageUnitComponentWithMenuPartDefinition;
                if (a2 != null) {
                    reactionIconMessageUnitComponentWithMenuPartDefinition = (ReactionIconMessageUnitComponentWithMenuPartDefinition) a2.a(f19805e);
                } else {
                    reactionIconMessageUnitComponentWithMenuPartDefinition = f19804d;
                }
                if (reactionIconMessageUnitComponentWithMenuPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23717b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19805e, b3);
                        } else {
                            f19804d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconMessageUnitComponentWithMenuPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
