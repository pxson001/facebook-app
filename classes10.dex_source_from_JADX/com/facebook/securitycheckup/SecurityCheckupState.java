package com.facebook.securitycheckup;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.securitycheckup.inner.SecurityCheckupInnerItem;
import java.util.List;

@ContextScoped
/* compiled from: inbox_filter_selected_filter */
public class SecurityCheckupState {
    private static SecurityCheckupState f9713i;
    private static final Object f9714j = new Object();
    public List<SecurityCheckupInnerItem> f9715a;
    public SecurityCheckupInnerItem f9716b;
    public SecurityCheckupInnerItem f9717c;
    public SecurityCheckupInnerItem f9718d;
    public boolean f9719e = false;
    public boolean f9720f = false;
    public boolean f9721g = false;
    public boolean f9722h = false;

    private static SecurityCheckupState m9933j() {
        return new SecurityCheckupState();
    }

    public static SecurityCheckupState m9932a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SecurityCheckupState j;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9714j) {
                SecurityCheckupState securityCheckupState;
                if (a2 != null) {
                    securityCheckupState = (SecurityCheckupState) a2.a(f9714j);
                } else {
                    securityCheckupState = f9713i;
                }
                if (securityCheckupState == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        j = m9933j();
                        if (a2 != null) {
                            a2.a(f9714j, j);
                        } else {
                            f9713i = j;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    j = securityCheckupState;
                }
            }
            return j;
        } finally {
            a.c(b);
        }
    }

    public final boolean m9934i() {
        return (this.f9716b != null && this.f9716b.f9779e) || ((this.f9717c != null && this.f9717c.f9779e) || (this.f9718d != null && this.f9718d.f9779e));
    }
}
