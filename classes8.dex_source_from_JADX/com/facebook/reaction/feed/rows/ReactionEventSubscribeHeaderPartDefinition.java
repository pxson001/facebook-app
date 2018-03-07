package com.facebook.reaction.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.rows.subparts.BasicReactionHeaderPartDefinition;
import com.facebook.reaction.feed.rows.subparts.BasicReactionHeaderPartDefinition.Props;
import com.facebook.reaction.feed.rows.subparts.ReactionEventSubscribeButtonPartDefinition;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: article_chaining_ID */
public class ReactionEventSubscribeHeaderPartDefinition<E extends CanLaunchReactionIntent & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionCardNode, Void, E, ImageBlockLayout> {
    public static final ViewType f19209a = ViewType.a(2130906629);
    private static ReactionEventSubscribeHeaderPartDefinition f19210d;
    private static final Object f19211e = new Object();
    private final BasicReactionHeaderPartDefinition f19212b;
    private final ReactionEventSubscribeButtonPartDefinition f19213c;

    private static ReactionEventSubscribeHeaderPartDefinition m23224b(InjectorLike injectorLike) {
        return new ReactionEventSubscribeHeaderPartDefinition(BasicReactionHeaderPartDefinition.m23394a(injectorLike), ReactionEventSubscribeButtonPartDefinition.m23407a(injectorLike));
    }

    public final Object m23226a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        subParts.a(this.f19212b, new Props(reactionCardNode.mo1117k().fw_(), reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n()));
        subParts.a(2131566654, this.f19213c, reactionCardNode);
        return null;
    }

    public final boolean m23227a(Object obj) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        return (fw_ == null || fw_.fA_() == null || Strings.isNullOrEmpty(fw_.fA_().a()) || fw_.b() == null || fw_.b().j() != GraphQLReactionStoryActionStyle.EVENTS_SUBSCRIBE) ? false : true;
    }

    @Inject
    public ReactionEventSubscribeHeaderPartDefinition(BasicReactionHeaderPartDefinition basicReactionHeaderPartDefinition, ReactionEventSubscribeButtonPartDefinition reactionEventSubscribeButtonPartDefinition) {
        this.f19212b = basicReactionHeaderPartDefinition;
        this.f19213c = reactionEventSubscribeButtonPartDefinition;
    }

    public final ViewType m23225a() {
        return f19209a;
    }

    public static ReactionEventSubscribeHeaderPartDefinition m23223a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionEventSubscribeHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19211e) {
                ReactionEventSubscribeHeaderPartDefinition reactionEventSubscribeHeaderPartDefinition;
                if (a2 != null) {
                    reactionEventSubscribeHeaderPartDefinition = (ReactionEventSubscribeHeaderPartDefinition) a2.a(f19211e);
                } else {
                    reactionEventSubscribeHeaderPartDefinition = f19210d;
                }
                if (reactionEventSubscribeHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23224b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19211e, b3);
                        } else {
                            f19210d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionEventSubscribeHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
