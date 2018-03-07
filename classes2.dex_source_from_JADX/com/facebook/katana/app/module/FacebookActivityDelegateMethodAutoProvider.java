package com.facebook.katana.app.module;

import android.content.Context;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.activity.FacebookActivityDelegate;

/* compiled from: substory */
public class FacebookActivityDelegateMethodAutoProvider extends AbstractProvider<FacebookActivityDelegate> {
    private static FacebookActivityDelegate f3887a;
    private static final Object f3888b = new Object();

    private static FacebookActivityDelegate m6474b(InjectorLike injectorLike) {
        return MainProcessModule.m4777a(ActivityMethodAutoProvider.m6475b(injectorLike));
    }

    public Object get() {
        return MainProcessModule.m4777a(ActivityMethodAutoProvider.m6475b(this));
    }

    public static FacebookActivityDelegate m6473a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FacebookActivityDelegate b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f3888b) {
                FacebookActivityDelegate facebookActivityDelegate;
                if (a2 != null) {
                    facebookActivityDelegate = (FacebookActivityDelegate) a2.mo818a(f3888b);
                } else {
                    facebookActivityDelegate = f3887a;
                }
                if (facebookActivityDelegate == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m6474b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f3888b, b3);
                        } else {
                            f3887a = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = facebookActivityDelegate;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
