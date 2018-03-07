package com.facebook.fbui.tinyclicks;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.tinyclicks.widget.MasterTouchDelegateFrameLayout;
import com.facebook.fbui.tinyclicks.widget.MasterTouchDelegateLayout;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.Sets;
import java.util.Set;

@ContextScoped
/* compiled from: nickname_suggestions */
public class MasterTouchDelegateController {
    private static MasterTouchDelegateController f10026e;
    private static final Object f10027f = new Object();
    public MasterTouchDelegateFrameLayout f10028a = null;
    public Set<MasterTouchDelegateLayout> f10029b = Sets.a();
    public boolean f10030c = true;
    public boolean f10031d = false;

    private static MasterTouchDelegateController m15716c() {
        return new MasterTouchDelegateController();
    }

    public static MasterTouchDelegateController m15715a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MasterTouchDelegateController c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10027f) {
                MasterTouchDelegateController masterTouchDelegateController;
                if (a2 != null) {
                    masterTouchDelegateController = (MasterTouchDelegateController) a2.a(f10027f);
                } else {
                    masterTouchDelegateController = f10026e;
                }
                if (masterTouchDelegateController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m15716c();
                        if (a2 != null) {
                            a2.a(f10027f, c);
                        } else {
                            f10026e = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = masterTouchDelegateController;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
