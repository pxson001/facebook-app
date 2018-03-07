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
/* compiled from: android.hardware.wifi */
public class ReactionActionListGroupPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment> {
    private static ReactionActionListGroupPartDefinition f19539c;
    private static final Object f19540d = new Object();
    private final ReactionActionListUnitComponentPartDefinition f19541a;
    private final ReactionDividerUnitComponentPartDefinition f19542b;

    private static ReactionActionListGroupPartDefinition m23476b(InjectorLike injectorLike) {
        return new ReactionActionListGroupPartDefinition(ReactionActionListUnitComponentPartDefinition.m23479a(injectorLike), ReactionDividerUnitComponentPartDefinition.m22997a(injectorLike));
    }

    public final Object m23477a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        if (reactionUnitComponentNode.f18862b.aG()) {
            baseMultiRowSubParts.a(this.f19542b, reactionUnitComponentNode);
        }
        baseMultiRowSubParts.a(this.f19541a, reactionUnitComponentNode);
        return null;
    }

    public final boolean m23478a(Object obj) {
        return this.f19541a.m23483a((ReactionUnitComponentNode) obj);
    }

    @Inject
    public ReactionActionListGroupPartDefinition(ReactionActionListUnitComponentPartDefinition reactionActionListUnitComponentPartDefinition, ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition) {
        this.f19541a = reactionActionListUnitComponentPartDefinition;
        this.f19542b = reactionDividerUnitComponentPartDefinition;
    }

    public static ReactionActionListGroupPartDefinition m23475a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionActionListGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19540d) {
                ReactionActionListGroupPartDefinition reactionActionListGroupPartDefinition;
                if (a2 != null) {
                    reactionActionListGroupPartDefinition = (ReactionActionListGroupPartDefinition) a2.a(f19540d);
                } else {
                    reactionActionListGroupPartDefinition = f19539c;
                }
                if (reactionActionListGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23476b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19540d, b3);
                        } else {
                            f19539c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionActionListGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
