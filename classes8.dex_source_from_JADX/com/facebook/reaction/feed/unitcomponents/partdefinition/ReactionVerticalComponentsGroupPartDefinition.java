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
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accountRecoveryValidateCode */
public class ReactionVerticalComponentsGroupPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitFragment, Void, AnyEnvironment> {
    private static ReactionVerticalComponentsGroupPartDefinition f20119d;
    private static final Object f20120e = new Object();
    private final ReactionVerticalComponentsNoBottomGapGroupPartDefinition f20121a;
    private final ReactionVerticalComponentsGapPartDefinition f20122b;
    private final ReactionUnitValidator f20123c;

    private static ReactionVerticalComponentsGroupPartDefinition m24012b(InjectorLike injectorLike) {
        return new ReactionVerticalComponentsGroupPartDefinition(ReactionVerticalComponentsNoBottomGapGroupPartDefinition.m24015a(injectorLike), ReactionVerticalComponentsGapPartDefinition.m24007a(injectorLike), ReactionUnitValidator.m22908b(injectorLike));
    }

    public final Object m24013a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        baseMultiRowSubParts.a(this.f20121a, reactionUnitFragment);
        baseMultiRowSubParts.a(this.f20122b, reactionUnitFragment);
        return null;
    }

    public final boolean m24014a(Object obj) {
        return "SUCCESS".equals(this.f20123c.m22916a((ReactionUnitFragment) obj));
    }

    @Inject
    public ReactionVerticalComponentsGroupPartDefinition(ReactionVerticalComponentsNoBottomGapGroupPartDefinition reactionVerticalComponentsNoBottomGapGroupPartDefinition, ReactionVerticalComponentsGapPartDefinition reactionVerticalComponentsGapPartDefinition, ReactionUnitValidator reactionUnitValidator) {
        this.f20121a = reactionVerticalComponentsNoBottomGapGroupPartDefinition;
        this.f20122b = reactionVerticalComponentsGapPartDefinition;
        this.f20123c = reactionUnitValidator;
    }

    public static ReactionVerticalComponentsGroupPartDefinition m24011a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionVerticalComponentsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20120e) {
                ReactionVerticalComponentsGroupPartDefinition reactionVerticalComponentsGroupPartDefinition;
                if (a2 != null) {
                    reactionVerticalComponentsGroupPartDefinition = (ReactionVerticalComponentsGroupPartDefinition) a2.a(f20120e);
                } else {
                    reactionVerticalComponentsGroupPartDefinition = f20119d;
                }
                if (reactionVerticalComponentsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24012b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20120e, b3);
                        } else {
                            f20119d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionVerticalComponentsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
