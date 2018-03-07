package com.facebook.redspace.data;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: PrivacyCheckupAppsDataFetch */
public class RedSpaceNewsFeedTitle {
    private static RedSpaceNewsFeedTitle f11846b;
    private static final Object f11847c = new Object();
    public CharSequence f11848a;

    private static RedSpaceNewsFeedTitle m12306b(InjectorLike injectorLike) {
        return new RedSpaceNewsFeedTitle(RedSpaceStrings.a(injectorLike));
    }

    @Inject
    private RedSpaceNewsFeedTitle(RedSpaceStrings redSpaceStrings) {
        this.f11848a = redSpaceStrings.k();
    }

    public static RedSpaceNewsFeedTitle m12305a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceNewsFeedTitle b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11847c) {
                RedSpaceNewsFeedTitle redSpaceNewsFeedTitle;
                if (a2 != null) {
                    redSpaceNewsFeedTitle = (RedSpaceNewsFeedTitle) a2.a(f11847c);
                } else {
                    redSpaceNewsFeedTitle = f11846b;
                }
                if (redSpaceNewsFeedTitle == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12306b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11847c, b3);
                        } else {
                            f11846b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceNewsFeedTitle;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
