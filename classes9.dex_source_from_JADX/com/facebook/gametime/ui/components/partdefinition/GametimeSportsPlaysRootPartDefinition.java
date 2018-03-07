package com.facebook.gametime.ui.components.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition.Props;
import com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition.Style;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeDataFactFragment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TAIL_FETCH */
public class GametimeSportsPlaysRootPartDefinition extends BaseMultiRowGroupPartDefinition<GametimeDataFactFragment, Void, HasContext> {
    private static GametimeSportsPlaysRootPartDefinition f25148b;
    private static final Object f25149c = new Object();
    private final Lazy<GametimeSportsPlayUnitComponentPartDefinition> f25150a;

    private static GametimeSportsPlaysRootPartDefinition m27119b(InjectorLike injectorLike) {
        return new GametimeSportsPlaysRootPartDefinition(IdBasedLazy.a(injectorLike, 6772));
    }

    public final Object m27120a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f25150a.get(), new Props((GametimeDataFactFragment) obj, Style.SHOW_COMMENT));
        return null;
    }

    @Inject
    public GametimeSportsPlaysRootPartDefinition(Lazy<GametimeSportsPlayUnitComponentPartDefinition> lazy) {
        this.f25150a = lazy;
    }

    public final boolean m27121a(Object obj) {
        return true;
    }

    public static GametimeSportsPlaysRootPartDefinition m27118a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeSportsPlaysRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25149c) {
                GametimeSportsPlaysRootPartDefinition gametimeSportsPlaysRootPartDefinition;
                if (a2 != null) {
                    gametimeSportsPlaysRootPartDefinition = (GametimeSportsPlaysRootPartDefinition) a2.a(f25149c);
                } else {
                    gametimeSportsPlaysRootPartDefinition = f25148b;
                }
                if (gametimeSportsPlaysRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27119b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25149c, b3);
                        } else {
                            f25148b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeSportsPlaysRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
