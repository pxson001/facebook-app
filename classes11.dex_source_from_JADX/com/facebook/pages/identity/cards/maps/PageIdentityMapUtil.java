package com.facebook.pages.identity.cards.maps;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.maps.ExternalMapLauncher;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: privacy_checkup_info */
public class PageIdentityMapUtil {
    private static final String f3517a = PageIdentityMapUtil.class.getSimpleName();
    private static PageIdentityMapUtil f3518e;
    private static final Object f3519f = new Object();
    private final Context f3520b;
    private final AbstractFbErrorReporter f3521c;
    private final ExternalMapLauncher f3522d;

    private static PageIdentityMapUtil m4563b(InjectorLike injectorLike) {
        return new PageIdentityMapUtil((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ExternalMapLauncher.a(injectorLike));
    }

    @Inject
    public PageIdentityMapUtil(Context context, AbstractFbErrorReporter abstractFbErrorReporter, ExternalMapLauncher externalMapLauncher) {
        this.f3520b = context;
        this.f3521c = abstractFbErrorReporter;
        this.f3522d = externalMapLauncher;
    }

    public final void m4564a(PageContextItemHandlingData pageContextItemHandlingData) {
        if (pageContextItemHandlingData.g != null) {
            String str;
            ExternalMapLauncher externalMapLauncher = this.f3522d;
            Context context = this.f3520b;
            String curationSurface = CurationSurface.NATIVE_PAGE_PROFILE.toString();
            double a = pageContextItemHandlingData.g.a();
            double b = pageContextItemHandlingData.g.b();
            String str2 = pageContextItemHandlingData.e;
            if (pageContextItemHandlingData.h == null || TextUtils.isEmpty(pageContextItemHandlingData.h.c())) {
                str = null;
            } else {
                str = pageContextItemHandlingData.h.b();
            }
            externalMapLauncher.a(context, curationSurface, a, b, str2, str);
            return;
        }
        this.f3521c.b(f3517a, "Trying to link to a map without any address or location");
    }

    public final void m4565b(PageContextItemHandlingData pageContextItemHandlingData) {
        if (pageContextItemHandlingData.g != null) {
            String str;
            ExternalMapLauncher externalMapLauncher = this.f3522d;
            Context context = this.f3520b;
            String curationSurface = CurationSurface.NATIVE_PAGE_PROFILE.toString();
            double a = pageContextItemHandlingData.g.a();
            double b = pageContextItemHandlingData.g.b();
            String str2 = pageContextItemHandlingData.e;
            if (pageContextItemHandlingData.h == null || TextUtils.isEmpty(pageContextItemHandlingData.h.c())) {
                str = null;
            } else {
                str = pageContextItemHandlingData.h.b();
            }
            externalMapLauncher.b(context, curationSurface, a, b, str2, str);
            return;
        }
        this.f3521c.b(f3517a, "Trying to link to get directions without any address or location");
    }

    public static PageIdentityMapUtil m4562a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageIdentityMapUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3519f) {
                PageIdentityMapUtil pageIdentityMapUtil;
                if (a2 != null) {
                    pageIdentityMapUtil = (PageIdentityMapUtil) a2.a(f3519f);
                } else {
                    pageIdentityMapUtil = f3518e;
                }
                if (pageIdentityMapUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4563b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3519f, b3);
                        } else {
                            f3518e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageIdentityMapUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
