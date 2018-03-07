package com.facebook.adinterfaces.objective;

import android.content.Context;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: [applinks]failed_to_start_intent */
public class AdInterfacesObjectiveRegistry {
    private static AdInterfacesObjectiveRegistry f21836b;
    private static final Object f21837c = new Object();
    public final Map<ObjectiveType, Provider<? extends AdInterfacesObjective>> f21838a = new HashMap();

    private static AdInterfacesObjectiveRegistry m22914b(InjectorLike injectorLike) {
        return new AdInterfacesObjectiveRegistry(IdBasedProvider.a(injectorLike, 4629), IdBasedProvider.a(injectorLike, 4624), IdBasedProvider.a(injectorLike, 4634), IdBasedProvider.a(injectorLike, 4628), IdBasedProvider.a(injectorLike, 4627), IdBasedProvider.a(injectorLike, 4623), IdBasedProvider.a(injectorLike, 4635), IdBasedProvider.a(injectorLike, 4636), IdBasedProvider.a(injectorLike, 4637), IdBasedProvider.a(injectorLike, 4638), IdBasedProvider.a(injectorLike, 4633), IdBasedProvider.a(injectorLike, 4632), IdBasedProvider.a(injectorLike, 4630), IdBasedProvider.a(injectorLike, 4631), IdBasedProvider.a(injectorLike, 4625));
    }

    @Inject
    public AdInterfacesObjectiveRegistry(Provider<BoostPostObjective> provider, Provider<BoostEventObjective> provider2, Provider<LocalAwarenessObjective> provider3, Provider<BoostPostInsightsObjective> provider4, Provider<BoostPostEditTargetingObjective> provider5, Provider<BoostEventEditTargetingObjective> provider6, Provider<PageLikePromotionObjective> provider7, Provider<PromoteCTAObjective> provider8, Provider<PromoteProductObjective> provider9, Provider<PromoteWebsiteObjective> provider10, Provider<BoostedComponentEditTargetingObjective> provider11, Provider<BoostedComponentEditDurationObjective> provider12, Provider<BoostedComponentEditBudgetObjective> provider13, Provider<BoostedComponentEditCreativeObjective> provider14, Provider<BoostPostBoostedComponentObjective> provider15) {
        this.f21838a.put(ObjectiveType.BOOST_POST, provider);
        this.f21838a.put(ObjectiveType.BOOSTED_COMPONENT_BOOST_POST, provider15);
        this.f21838a.put(ObjectiveType.BOOST_EVENT, provider2);
        this.f21838a.put(ObjectiveType.LOCAL_AWARENESS, provider3);
        this.f21838a.put(ObjectiveType.BOOST_POST_INSIGHTS, provider4);
        this.f21838a.put(ObjectiveType.BOOST_POST_EDIT_TARGETING, provider5);
        this.f21838a.put(ObjectiveType.BOOST_EVENT_EDIT_TARGETING, provider6);
        this.f21838a.put(ObjectiveType.PAGE_LIKE, provider7);
        this.f21838a.put(ObjectiveType.PROMOTE_WEBSITE, provider10);
        this.f21838a.put(ObjectiveType.PROMOTE_CTA, provider8);
        this.f21838a.put(ObjectiveType.PROMOTE_PRODUCT, provider9);
        this.f21838a.put(ObjectiveType.BOOSTED_COMPONENT_EDIT_TARGETING, provider11);
        this.f21838a.put(ObjectiveType.BOOSTED_COMPONENT_EDIT_DURATION, provider12);
        this.f21838a.put(ObjectiveType.BOOSTED_COMPONENT_EDIT_BUDGET, provider13);
        this.f21838a.put(ObjectiveType.PAGE_LIKE_EDIT_CREATIVE, provider14);
        this.f21838a.put(ObjectiveType.LOCAL_AWARENESS_EDIT_CREATIVE, provider14);
        this.f21838a.put(ObjectiveType.PROMOTE_WEBSITE_EDIT_CREATIVE, provider14);
        this.f21838a.put(ObjectiveType.PROMOTE_CTA_EDIT_CREATIVE, provider14);
        this.f21838a.put(ObjectiveType.PAGE_LIKE_EDIT_RUNNING_CREATIVE, provider14);
    }

    public static AdInterfacesObjectiveRegistry m22913a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AdInterfacesObjectiveRegistry b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21837c) {
                AdInterfacesObjectiveRegistry adInterfacesObjectiveRegistry;
                if (a2 != null) {
                    adInterfacesObjectiveRegistry = (AdInterfacesObjectiveRegistry) a2.a(f21837c);
                } else {
                    adInterfacesObjectiveRegistry = f21836b;
                }
                if (adInterfacesObjectiveRegistry == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22914b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21837c, b3);
                        } else {
                            f21836b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = adInterfacesObjectiveRegistry;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
