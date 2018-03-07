package com.facebook.gametime.ui.components.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition.Props;
import com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition.Style;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: TASK_GEOCODE_ADDRESS */
public class GametimeSingleSportsPlayGroupPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, HasContext> {
    private static GametimeSingleSportsPlayGroupPartDefinition f25112b;
    private static final Object f25113c = new Object();
    private final GametimeSportsPlayUnitComponentPartDefinition f25114a;

    private static GametimeSingleSportsPlayGroupPartDefinition m27100b(InjectorLike injectorLike) {
        return new GametimeSingleSportsPlayGroupPartDefinition(GametimeSportsPlayUnitComponentPartDefinition.m27111a(injectorLike));
    }

    public final Object m27101a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f25114a, new Props(((ReactionUnitComponentNode) obj).b.cz(), Style.WITH_INSET_BORDER));
        return null;
    }

    public final boolean m27102a(Object obj) {
        return ((ReactionUnitComponentNode) obj).b.cz() != null;
    }

    @Inject
    public GametimeSingleSportsPlayGroupPartDefinition(GametimeSportsPlayUnitComponentPartDefinition gametimeSportsPlayUnitComponentPartDefinition) {
        this.f25114a = gametimeSportsPlayUnitComponentPartDefinition;
    }

    public static GametimeSingleSportsPlayGroupPartDefinition m27099a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeSingleSportsPlayGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25113c) {
                GametimeSingleSportsPlayGroupPartDefinition gametimeSingleSportsPlayGroupPartDefinition;
                if (a2 != null) {
                    gametimeSingleSportsPlayGroupPartDefinition = (GametimeSingleSportsPlayGroupPartDefinition) a2.a(f25113c);
                } else {
                    gametimeSingleSportsPlayGroupPartDefinition = f25112b;
                }
                if (gametimeSingleSportsPlayGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27100b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25113c, b3);
                        } else {
                            f25112b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeSingleSportsPlayGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
