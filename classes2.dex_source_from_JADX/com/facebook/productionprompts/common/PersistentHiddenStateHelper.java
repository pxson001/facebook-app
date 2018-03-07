package com.facebook.productionprompts.common;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

@ContextScoped
/* compiled from: netego_promote_instagram_friend_count_50 */
public class PersistentHiddenStateHelper {
    private static PersistentHiddenStateHelper f12821b;
    private static final Object f12822c = new Object();
    public final FbSharedPreferences f12823a;

    private static PersistentHiddenStateHelper m18840b(InjectorLike injectorLike) {
        return new PersistentHiddenStateHelper(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public PersistentHiddenStateHelper(FbSharedPreferences fbSharedPreferences) {
        this.f12823a = fbSharedPreferences;
    }

    public static PersistentHiddenStateHelper m18839a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersistentHiddenStateHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f12822c) {
                PersistentHiddenStateHelper persistentHiddenStateHelper;
                if (a2 != null) {
                    persistentHiddenStateHelper = (PersistentHiddenStateHelper) a2.mo818a(f12822c);
                } else {
                    persistentHiddenStateHelper = f12821b;
                }
                if (persistentHiddenStateHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m18840b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f12822c, b3);
                        } else {
                            f12821b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = persistentHiddenStateHelper;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
