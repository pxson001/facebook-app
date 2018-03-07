package com.facebook.redspace.entry;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
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
/* compiled from: should_post_to_marketplace_by_default */
public class RedSpaceEntryDescriptionHelper {
    private static RedSpaceEntryDescriptionHelper f4387c;
    private static final Object f4388d = new Object();
    @Inject
    public Resources f4389a;
    @Inject
    public RedSpaceStrings f4390b;

    private static RedSpaceEntryDescriptionHelper m6461b(InjectorLike injectorLike) {
        RedSpaceEntryDescriptionHelper redSpaceEntryDescriptionHelper = new RedSpaceEntryDescriptionHelper();
        RedSpaceStrings a = RedSpaceStrings.a(injectorLike);
        redSpaceEntryDescriptionHelper.f4389a = ResourcesMethodAutoProvider.a(injectorLike);
        redSpaceEntryDescriptionHelper.f4390b = a;
        return redSpaceEntryDescriptionHelper;
    }

    public final String m6462a(int i) {
        if (i == 0) {
            return this.f4390b.a();
        }
        return this.f4389a.getString(2131235595, new Object[]{Integer.valueOf(i)});
    }

    public static RedSpaceEntryDescriptionHelper m6460a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceEntryDescriptionHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4388d) {
                RedSpaceEntryDescriptionHelper redSpaceEntryDescriptionHelper;
                if (a2 != null) {
                    redSpaceEntryDescriptionHelper = (RedSpaceEntryDescriptionHelper) a2.a(f4388d);
                } else {
                    redSpaceEntryDescriptionHelper = f4387c;
                }
                if (redSpaceEntryDescriptionHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6461b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4388d, b3);
                        } else {
                            f4387c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceEntryDescriptionHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
