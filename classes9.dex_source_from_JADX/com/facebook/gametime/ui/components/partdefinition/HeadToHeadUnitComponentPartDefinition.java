package com.facebook.gametime.ui.components.partdefinition;

import android.content.Context;
import android.graphics.Color;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.gametime.ui.components.partdefinition.HeadToHeadTextPartDefinition.Props;
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
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TAB_ORION_REQUEST */
public class HeadToHeadUnitComponentPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment> {
    private static HeadToHeadUnitComponentPartDefinition f25159c;
    private static final Object f25160d = new Object();
    private final HeadToHeadTextPartDefinition f25161a;
    private final TwoColorBarPartDefinition f25162b;

    private static HeadToHeadUnitComponentPartDefinition m27129b(InjectorLike injectorLike) {
        return new HeadToHeadUnitComponentPartDefinition(HeadToHeadTextPartDefinition.m27123a(injectorLike), TwoColorBarPartDefinition.m27133a(injectorLike));
    }

    public final Object m27130a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        int parseColor = Color.parseColor("#" + reactionUnitComponentFields.bk());
        int parseColor2 = Color.parseColor("#" + reactionUnitComponentFields.cp());
        baseMultiRowSubParts.a(this.f25161a, new Props(reactionUnitComponentFields.cU().a(), reactionUnitComponentFields.bl(), reactionUnitComponentFields.cq(), parseColor, parseColor2));
        baseMultiRowSubParts.a(this.f25162b, new TwoColorBarPartDefinition.Props(parseColor, parseColor2, (float) reactionUnitComponentFields.bm(), (float) reactionUnitComponentFields.cr(), 2131434011));
        return null;
    }

    public final boolean m27131a(Object obj) {
        ReactionUnitComponentFields f = ((ReactionUnitComponentNode) obj).f();
        try {
            Color.parseColor("#" + f.bk());
            Color.parseColor("#" + f.cp());
            if (f.cU() == null || Strings.isNullOrEmpty(f.cU().a()) || Strings.isNullOrEmpty(f.bl()) || Strings.isNullOrEmpty(f.cq()) || f.bm() < 0.0d || f.cr() < 0.0d) {
                return false;
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Inject
    public HeadToHeadUnitComponentPartDefinition(HeadToHeadTextPartDefinition headToHeadTextPartDefinition, TwoColorBarPartDefinition twoColorBarPartDefinition) {
        this.f25161a = headToHeadTextPartDefinition;
        this.f25162b = twoColorBarPartDefinition;
    }

    public static HeadToHeadUnitComponentPartDefinition m27128a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeadToHeadUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25160d) {
                HeadToHeadUnitComponentPartDefinition headToHeadUnitComponentPartDefinition;
                if (a2 != null) {
                    headToHeadUnitComponentPartDefinition = (HeadToHeadUnitComponentPartDefinition) a2.a(f25160d);
                } else {
                    headToHeadUnitComponentPartDefinition = f25159c;
                }
                if (headToHeadUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27129b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25160d, b3);
                        } else {
                            f25159c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = headToHeadUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
