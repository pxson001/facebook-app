package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import javax.inject.Inject;

@ContextScoped
/* compiled from: admin_count */
public class ReactionImageWithTextOverlayUnitComponentGroupPartDefinition<E extends HasContext & HasReactionCardContainer & HasReactionInteractionTracker & HasPrefetcher & HasRowKey> extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, E> {
    private static ReactionImageWithTextOverlayUnitComponentGroupPartDefinition f19853c;
    private static final Object f19854d = new Object();
    private final ReactionLargeImageUnitComponentPartDefinition f19855a;
    private final ReactionTwoMessageUnitComponentPartDefinition f19856b;

    private static ReactionImageWithTextOverlayUnitComponentGroupPartDefinition m23759b(InjectorLike injectorLike) {
        return new ReactionImageWithTextOverlayUnitComponentGroupPartDefinition(ReactionLargeImageUnitComponentPartDefinition.m23777a(injectorLike), ReactionTwoMessageUnitComponentPartDefinition.m23996a(injectorLike));
    }

    public final Object m23760a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        baseMultiRowSubParts.a(this.f19855a, reactionUnitComponentNode);
        baseMultiRowSubParts.a(this.f19856b, reactionUnitComponentNode);
        return null;
    }

    public final boolean m23761a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return ReactionLargeImageUnitComponentPartDefinition.m23778a(reactionUnitComponentNode) && ReactionTwoMessageUnitComponentPartDefinition.m23997a(reactionUnitComponentNode);
    }

    @Inject
    public ReactionImageWithTextOverlayUnitComponentGroupPartDefinition(ReactionLargeImageUnitComponentPartDefinition reactionLargeImageUnitComponentPartDefinition, ReactionTwoMessageUnitComponentPartDefinition reactionTwoMessageUnitComponentPartDefinition) {
        this.f19855a = reactionLargeImageUnitComponentPartDefinition;
        this.f19856b = reactionTwoMessageUnitComponentPartDefinition;
    }

    public static ReactionImageWithTextOverlayUnitComponentGroupPartDefinition m23758a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionImageWithTextOverlayUnitComponentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19854d) {
                ReactionImageWithTextOverlayUnitComponentGroupPartDefinition reactionImageWithTextOverlayUnitComponentGroupPartDefinition;
                if (a2 != null) {
                    reactionImageWithTextOverlayUnitComponentGroupPartDefinition = (ReactionImageWithTextOverlayUnitComponentGroupPartDefinition) a2.a(f19854d);
                } else {
                    reactionImageWithTextOverlayUnitComponentGroupPartDefinition = f19853c;
                }
                if (reactionImageWithTextOverlayUnitComponentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23759b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19854d, b3);
                        } else {
                            f19853c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionImageWithTextOverlayUnitComponentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
