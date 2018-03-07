package com.facebook.widget.springbutton;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ig_pff_install */
public class SpringFactory {
    private static final SpringConfig f20576a = SpringConfig.m7842a(40.0d, 4.0d);
    private static SpringFactory f20577c;
    private static final Object f20578d = new Object();
    private final SpringSystem f20579b;

    private static SpringFactory m28320b(InjectorLike injectorLike) {
        return new SpringFactory(SpringSystem.m7835b(injectorLike));
    }

    @Inject
    public SpringFactory(SpringSystem springSystem) {
        this.f20579b = springSystem;
    }

    public final Spring m28321a() {
        Spring b = this.f20579b.m7838a().m7813a(1.0d).m7818b(1.0d);
        b.f4225l = 0.0010000000474974513d;
        b = b;
        b.f4224k = 0.0010000000474974513d;
        return b.m7814a(f20576a);
    }

    public static SpringFactory m28319a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SpringFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20578d) {
                SpringFactory springFactory;
                if (a2 != null) {
                    springFactory = (SpringFactory) a2.mo818a(f20578d);
                } else {
                    springFactory = f20577c;
                }
                if (springFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28320b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20578d, b3);
                        } else {
                            f20577c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = springFactory;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
