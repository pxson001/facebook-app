package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [A-F0-9]+ */
public class ReactionIconMessageWithMenuPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends BaseSinglePartDefinition<ReactionUnitComponentNode, Void, E, LinearLayout> {
    private static ReactionIconMessageWithMenuPartDefinition f20631d;
    private static final Object f20632e = new Object();
    private final ReactionChevronMenuPartDefinition f20633a;
    private final ReactionUriIconPartDefinition f20634b;
    private final TextPartDefinition f20635c;

    private static ReactionIconMessageWithMenuPartDefinition m24326b(InjectorLike injectorLike) {
        return new ReactionIconMessageWithMenuPartDefinition(ReactionChevronMenuPartDefinition.m24297a(injectorLike), ReactionUriIconPartDefinition.m24360a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m24327a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(2131566648, this.f20635c, reactionUnitComponentFields.bv().a());
        if (reactionUnitComponentFields.aP() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.aP().b())) {
            obj2 = null;
        } else {
            obj2 = reactionUnitComponentFields.aP().b();
        }
        subParts.a(2131566655, this.f20634b, obj2);
        subParts.a(2131566656, this.f20633a, reactionUnitComponentNode);
        return null;
    }

    public final /* bridge */ /* synthetic */ void m24328a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -134655573);
        ((LinearLayout) view).findViewById(2131566653).setVisibility(8);
        Logger.a(8, EntryType.MARK_POP, -1031717928, a);
    }

    @Inject
    public ReactionIconMessageWithMenuPartDefinition(ReactionChevronMenuPartDefinition reactionChevronMenuPartDefinition, ReactionUriIconPartDefinition reactionUriIconPartDefinition, TextPartDefinition textPartDefinition) {
        this.f20633a = reactionChevronMenuPartDefinition;
        this.f20634b = reactionUriIconPartDefinition;
        this.f20635c = textPartDefinition;
    }

    public static ReactionIconMessageWithMenuPartDefinition m24325a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconMessageWithMenuPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20632e) {
                ReactionIconMessageWithMenuPartDefinition reactionIconMessageWithMenuPartDefinition;
                if (a2 != null) {
                    reactionIconMessageWithMenuPartDefinition = (ReactionIconMessageWithMenuPartDefinition) a2.a(f20632e);
                } else {
                    reactionIconMessageWithMenuPartDefinition = f20631d;
                }
                if (reactionIconMessageWithMenuPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24326b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20632e, b3);
                        } else {
                            f20631d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconMessageWithMenuPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
