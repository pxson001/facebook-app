package com.facebook.reaction.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg_page_id */
public class ReactionIconInlineActionHeaderSelectorPartDefinition<E extends CanLaunchReactionIntent & HasReactionInteractionTracker & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends BaseMultiRowGroupPartDefinition<ReactionCardNode, Void, E> {
    private static ReactionIconInlineActionHeaderSelectorPartDefinition f19240c;
    private static final Object f19241d = new Object();
    private final ReactionIconInlineActionHeaderPartDefinition<E> f19242a;
    private final ReactionEventSubscribeHeaderPartDefinition<E> f19243b;

    private static ReactionIconInlineActionHeaderSelectorPartDefinition m23252b(InjectorLike injectorLike) {
        return new ReactionIconInlineActionHeaderSelectorPartDefinition(ReactionEventSubscribeHeaderPartDefinition.m23223a(injectorLike), ReactionIconInlineActionHeaderPartDefinition.m23246a(injectorLike));
    }

    public final Object m23253a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f19243b, reactionCardNode).a(this.f19242a, reactionCardNode);
        return null;
    }

    @Inject
    public ReactionIconInlineActionHeaderSelectorPartDefinition(ReactionEventSubscribeHeaderPartDefinition reactionEventSubscribeHeaderPartDefinition, ReactionIconInlineActionHeaderPartDefinition reactionIconInlineActionHeaderPartDefinition) {
        this.f19242a = reactionIconInlineActionHeaderPartDefinition;
        this.f19243b = reactionEventSubscribeHeaderPartDefinition;
    }

    public final boolean m23254a(Object obj) {
        return true;
    }

    public static ReactionIconInlineActionHeaderSelectorPartDefinition m23251a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconInlineActionHeaderSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19241d) {
                ReactionIconInlineActionHeaderSelectorPartDefinition reactionIconInlineActionHeaderSelectorPartDefinition;
                if (a2 != null) {
                    reactionIconInlineActionHeaderSelectorPartDefinition = (ReactionIconInlineActionHeaderSelectorPartDefinition) a2.a(f19241d);
                } else {
                    reactionIconInlineActionHeaderSelectorPartDefinition = f19240c;
                }
                if (reactionIconInlineActionHeaderSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23252b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19241d, b3);
                        } else {
                            f19240c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconInlineActionHeaderSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
