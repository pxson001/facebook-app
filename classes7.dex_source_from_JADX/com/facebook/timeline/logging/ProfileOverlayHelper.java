package com.facebook.timeline.logging;

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
import com.facebook.timeline.prefs.TimelinePreferencesKeys;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: favorite_media_picker */
public class ProfileOverlayHelper {
    private static ProfileOverlayHelper f14618e;
    private static final Object f14619f = new Object();
    private final FbSharedPreferences f14620a;
    private Map<String, Long> f14621b;
    public Map<String, Long> f14622c;
    public final boolean f14623d = this.f14620a.a(TimelinePreferencesKeys.f14695c, false);

    private static ProfileOverlayHelper m18526b(InjectorLike injectorLike) {
        return new ProfileOverlayHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public ProfileOverlayHelper(FbSharedPreferences fbSharedPreferences) {
        this.f14620a = fbSharedPreferences;
        if (this.f14623d) {
            this.f14621b = new HashMap();
            this.f14622c = new HashMap();
        }
    }

    public final void m18527a(String str) {
        if (this.f14623d) {
            this.f14621b.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void m18528b(String str) {
        if (this.f14623d && this.f14621b.containsKey(str)) {
            this.f14622c.put(str, Long.valueOf(System.currentTimeMillis() - ((Long) this.f14621b.remove(str)).longValue()));
        }
    }

    public static ProfileOverlayHelper m18525a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfileOverlayHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14619f) {
                ProfileOverlayHelper profileOverlayHelper;
                if (a2 != null) {
                    profileOverlayHelper = (ProfileOverlayHelper) a2.a(f14619f);
                } else {
                    profileOverlayHelper = f14618e;
                }
                if (profileOverlayHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18526b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14619f, b3);
                        } else {
                            f14618e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = profileOverlayHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
