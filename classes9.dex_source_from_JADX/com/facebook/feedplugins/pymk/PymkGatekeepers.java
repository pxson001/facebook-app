package com.facebook.feedplugins.pymk;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TOP_FRIENDS */
public class PymkGatekeepers {
    private static PymkGatekeepers f24690e;
    private static final Object f24691f = new Object();
    public final boolean f24692a;
    public final boolean f24693b;
    public final boolean f24694c;
    public final boolean f24695d;

    private static PymkGatekeepers m26573b(InjectorLike injectorLike) {
        return new PymkGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PymkGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f24692a = gatekeeperStoreImpl.a(659, false);
        this.f24693b = gatekeeperStoreImpl.a(657, false);
        this.f24694c = gatekeeperStoreImpl.a(660, false);
        this.f24695d = gatekeeperStoreImpl.a(658, false);
    }

    public final boolean m26574a() {
        return this.f24692a;
    }

    public static PymkGatekeepers m26572a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymkGatekeepers b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24691f) {
                PymkGatekeepers pymkGatekeepers;
                if (a2 != null) {
                    pymkGatekeepers = (PymkGatekeepers) a2.a(f24691f);
                } else {
                    pymkGatekeepers = f24690e;
                }
                if (pymkGatekeepers == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26573b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24691f, b3);
                        } else {
                            f24690e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymkGatekeepers;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
