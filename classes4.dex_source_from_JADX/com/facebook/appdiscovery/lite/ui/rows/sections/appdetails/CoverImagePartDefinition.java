package com.facebook.appdiscovery.lite.ui.rows.sections.appdetails;

import android.content.Context;
import android.view.View;
import com.facebook.appdiscovery.lite.analytics.LiteInstallLogger;
import com.facebook.appdiscovery.lite.common.util.AppInstallClickListenerFactory;
import com.facebook.appdiscovery.lite.common.util.AppInstallClickListenerFactoryProvider;
import com.facebook.appdiscovery.lite.model.unit.AppDetailsFeedUnit;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
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
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: nux_finish */
public class CoverImagePartDefinition<E extends HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<AppDetailsFeedUnit, Void, E, FbDraweeView> {
    public static final ViewType f6502a = new C02941();
    private static final CallerContext f6503b = CallerContext.a(CoverImagePartDefinition.class);
    private static CoverImagePartDefinition f6504f;
    private static final Object f6505g = new Object();
    private final ClickListenerPartDefinition f6506c;
    private final AppInstallClickListenerFactory f6507d;
    private final FbDraweePartDefinition<E> f6508e;

    /* compiled from: nux_finish */
    final class C02941 extends ViewType {
        C02941() {
        }

        public final View m6926a(Context context) {
            return new FbDraweeView(context);
        }
    }

    private static CoverImagePartDefinition m6922b(InjectorLike injectorLike) {
        return new CoverImagePartDefinition(ClickListenerPartDefinition.a(injectorLike), (AppInstallClickListenerFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppInstallClickListenerFactoryProvider.class), (Context) injectorLike.getInstance(Context.class), LiteInstallLogger.a(injectorLike), FbDraweePartDefinition.a(injectorLike));
    }

    public final Object m6924a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        AppDetailsFeedUnit appDetailsFeedUnit = (AppDetailsFeedUnit) obj;
        Builder a = FbDraweePartDefinition.a().a(appDetailsFeedUnit.o().b());
        a.c = f6503b;
        a = a;
        float c = (float) appDetailsFeedUnit.o().c();
        float a2 = (float) appDetailsFeedUnit.o().a();
        if (c > 0.0f && a2 > 0.0f) {
            a.b = c / a2;
        }
        subParts.a(this.f6508e, a.a());
        subParts.a(this.f6506c, this.f6507d.a(appDetailsFeedUnit));
        return null;
    }

    public final boolean m6925a(Object obj) {
        return ((AppDetailsFeedUnit) obj).o() != null;
    }

    @Inject
    public CoverImagePartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, AppInstallClickListenerFactoryProvider appInstallClickListenerFactoryProvider, Context context, LiteInstallLogger liteInstallLogger, FbDraweePartDefinition fbDraweePartDefinition) {
        this.f6506c = clickListenerPartDefinition;
        this.f6507d = appInstallClickListenerFactoryProvider.a(context, liteInstallLogger);
        this.f6508e = fbDraweePartDefinition;
    }

    public static CoverImagePartDefinition m6921a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CoverImagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6505g) {
                CoverImagePartDefinition coverImagePartDefinition;
                if (a2 != null) {
                    coverImagePartDefinition = (CoverImagePartDefinition) a2.a(f6505g);
                } else {
                    coverImagePartDefinition = f6504f;
                }
                if (coverImagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6922b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6505g, b3);
                        } else {
                            f6504f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = coverImagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m6923a() {
        return f6502a;
    }
}
