package com.facebook.adinterfaces.survey;

import android.content.Context;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.structuredsurvey.StructuredSurveyController;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: VaultSyncService onStartCommand */
public class AdInterfacesSurveyController {
    private static AdInterfacesSurveyController f22429e;
    private static final Object f22430f = new Object();
    public final Context f22431a;
    public final Provider<RapidFeedbackController> f22432b;
    public final Provider<StructuredSurveyController> f22433c;
    public boolean f22434d = false;

    private static AdInterfacesSurveyController m24301b(InjectorLike injectorLike) {
        return new AdInterfacesSurveyController((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 3253), IdBasedSingletonScopeProvider.a(injectorLike, 3480));
    }

    @Inject
    public AdInterfacesSurveyController(Context context, Provider<RapidFeedbackController> provider, Provider<StructuredSurveyController> provider2) {
        this.f22431a = context;
        this.f22432b = provider;
        this.f22433c = provider2;
    }

    public static AdInterfacesSurveyController m24300a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AdInterfacesSurveyController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22430f) {
                AdInterfacesSurveyController adInterfacesSurveyController;
                if (a2 != null) {
                    adInterfacesSurveyController = (AdInterfacesSurveyController) a2.a(f22430f);
                } else {
                    adInterfacesSurveyController = f22429e;
                }
                if (adInterfacesSurveyController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24301b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22430f, b3);
                        } else {
                            f22429e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = adInterfacesSurveyController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m24302b(ObjectiveType objectiveType) {
        return objectiveType == ObjectiveType.BOOST_POST;
    }
}
