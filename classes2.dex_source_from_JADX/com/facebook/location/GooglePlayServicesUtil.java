package com.facebook.location;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.resources.Resources_BaseResourcesMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: launcher_type */
public class GooglePlayServicesUtil {
    private static GooglePlayServicesUtil f17762b;
    private static final Object f17763c = new Object();
    private final Context f17764a;

    /* compiled from: launcher_type */
    public final class C07141 extends ContextWrapper {
        final /* synthetic */ Resources f17765a;

        public C07141(Context context, Resources resources) {
            this.f17765a = resources;
            super(context);
        }

        public final Resources getResources() {
            return this.f17765a;
        }
    }

    private static GooglePlayServicesUtil m24989b(InjectorLike injectorLike) {
        return new GooglePlayServicesUtil((Context) injectorLike.getInstance(Context.class), Resources_BaseResourcesMethodAutoProvider.m2599b(injectorLike));
    }

    @Inject
    public GooglePlayServicesUtil(Context context, Resources resources) {
        this.f17764a = new C07141(context, resources);
    }

    final int m24990a() {
        return com.google.android.gms.common.GooglePlayServicesUtil.m153a(this.f17764a);
    }

    public static GooglePlayServicesUtil m24988a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GooglePlayServicesUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f17763c) {
                GooglePlayServicesUtil googlePlayServicesUtil;
                if (a2 != null) {
                    googlePlayServicesUtil = (GooglePlayServicesUtil) a2.mo818a(f17763c);
                } else {
                    googlePlayServicesUtil = f17762b;
                }
                if (googlePlayServicesUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m24989b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f17763c, b3);
                        } else {
                            f17762b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = googlePlayServicesUtil;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
