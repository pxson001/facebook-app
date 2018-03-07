package com.facebook.ui.titlebar.search;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.entry.RedSpaceDivebarButtonSpecUtil;
import com.facebook.redspace.entry.RedSpaceEntryPointCapability;
import javax.inject.Inject;

@ContextScoped
/* compiled from: should_set_simple_result */
public class DivebarButtonSpecUtil {
    private static DivebarButtonSpecUtil f4921b;
    private static final Object f4922c = new Object();
    public final RedSpaceDivebarButtonSpecUtil f4923a;

    private static DivebarButtonSpecUtil m8811b(InjectorLike injectorLike) {
        return new DivebarButtonSpecUtil(new RedSpaceDivebarButtonSpecUtil(RedSpaceEntryPointCapability.m7792b(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), RedSpaceStrings.m8812a(injectorLike)));
    }

    @Inject
    public DivebarButtonSpecUtil(RedSpaceDivebarButtonSpecUtil redSpaceDivebarButtonSpecUtil) {
        this.f4923a = redSpaceDivebarButtonSpecUtil;
    }

    public static DivebarButtonSpecUtil m8810a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DivebarButtonSpecUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f4922c) {
                DivebarButtonSpecUtil divebarButtonSpecUtil;
                if (a2 != null) {
                    divebarButtonSpecUtil = (DivebarButtonSpecUtil) a2.mo818a(f4922c);
                } else {
                    divebarButtonSpecUtil = f4921b;
                }
                if (divebarButtonSpecUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m8811b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f4922c, b3);
                        } else {
                            f4921b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = divebarButtonSpecUtil;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
