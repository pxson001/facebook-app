package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: account_profile */
public class ReactionTextWithInlineFacepileGroupPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment> {
    private static ReactionTextWithInlineFacepileGroupPartDefinition f20098c;
    private static final Object f20099d = new Object();
    private final ReactionDividerUnitComponentPartDefinition f20100a;
    private final ReactionTextWithInlineFacepileUnitComponentPartDefinition f20101b;

    private static ReactionTextWithInlineFacepileGroupPartDefinition m23987b(InjectorLike injectorLike) {
        return new ReactionTextWithInlineFacepileGroupPartDefinition(ReactionDividerUnitComponentPartDefinition.m22997a(injectorLike), ReactionTextWithInlineFacepileUnitComponentPartDefinition.m23990a(injectorLike));
    }

    public final Object m23988a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        baseMultiRowSubParts.a(this.f20101b, reactionUnitComponentNode);
        if (reactionUnitComponentNode.f18862b.aD()) {
            baseMultiRowSubParts.a(this.f20100a, reactionUnitComponentNode);
        }
        return null;
    }

    public final boolean m23989a(Object obj) {
        return ReactionTextWithInlineFacepileUnitComponentPartDefinition.m23991a((ReactionUnitComponentNode) obj);
    }

    @Inject
    public ReactionTextWithInlineFacepileGroupPartDefinition(ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition, ReactionTextWithInlineFacepileUnitComponentPartDefinition reactionTextWithInlineFacepileUnitComponentPartDefinition) {
        this.f20100a = reactionDividerUnitComponentPartDefinition;
        this.f20101b = reactionTextWithInlineFacepileUnitComponentPartDefinition;
    }

    public static ReactionTextWithInlineFacepileGroupPartDefinition m23986a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionTextWithInlineFacepileGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20099d) {
                ReactionTextWithInlineFacepileGroupPartDefinition reactionTextWithInlineFacepileGroupPartDefinition;
                if (a2 != null) {
                    reactionTextWithInlineFacepileGroupPartDefinition = (ReactionTextWithInlineFacepileGroupPartDefinition) a2.a(f20099d);
                } else {
                    reactionTextWithInlineFacepileGroupPartDefinition = f20098c;
                }
                if (reactionTextWithInlineFacepileGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23987b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20099d, b3);
                        } else {
                            f20098c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionTextWithInlineFacepileGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
