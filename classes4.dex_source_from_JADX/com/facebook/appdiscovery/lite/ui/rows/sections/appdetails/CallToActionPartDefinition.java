package com.facebook.appdiscovery.lite.ui.rows.sections.appdetails;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.appdiscovery.lite.analytics.LiteInstallLogger;
import com.facebook.appdiscovery.lite.common.util.AppInstallClickListenerFactory;
import com.facebook.appdiscovery.lite.common.util.AppInstallClickListenerFactoryProvider;
import com.facebook.appdiscovery.lite.model.unit.AppDetailsFeedUnit;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: num_unseen_stories_in_cache */
public class CallToActionPartDefinition extends MultiRowSinglePartDefinition<AppDetailsFeedUnit, Void, AnyEnvironment, LinearLayout> {
    public static final ViewType f6524a = ViewType.a(2130903482);
    private static CallToActionPartDefinition f6525d;
    private static final Object f6526e = new Object();
    private final AppInstallClickListenerFactory f6527b;
    private final ClickListenerPartDefinition f6528c;

    private static CallToActionPartDefinition m6945b(InjectorLike injectorLike) {
        return new CallToActionPartDefinition((Context) injectorLike.getInstance(Context.class), LiteInstallLogger.a(injectorLike), (AppInstallClickListenerFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppInstallClickListenerFactoryProvider.class), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m6947a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f6528c, this.f6527b.a((AppDetailsFeedUnit) obj));
        return null;
    }

    public final boolean m6948a(Object obj) {
        return !StringUtil.a(((AppDetailsFeedUnit) obj).k());
    }

    @Inject
    public CallToActionPartDefinition(Context context, LiteInstallLogger liteInstallLogger, AppInstallClickListenerFactoryProvider appInstallClickListenerFactoryProvider, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f6527b = appInstallClickListenerFactoryProvider.a(context, liteInstallLogger);
        this.f6528c = clickListenerPartDefinition;
    }

    public static CallToActionPartDefinition m6944a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6526e) {
                CallToActionPartDefinition callToActionPartDefinition;
                if (a2 != null) {
                    callToActionPartDefinition = (CallToActionPartDefinition) a2.a(f6526e);
                } else {
                    callToActionPartDefinition = f6525d;
                }
                if (callToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6945b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6526e, b3);
                        } else {
                            f6525d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = callToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m6946a() {
        return f6524a;
    }
}
