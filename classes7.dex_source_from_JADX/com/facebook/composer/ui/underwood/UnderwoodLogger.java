package com.facebook.composer.ui.underwood;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import javax.inject.Inject;

@ContextScoped
/* compiled from: commercial_break_confirm */
public class UnderwoodLogger {
    private static UnderwoodLogger f17232b;
    private static final Object f17233c = new Object();
    public final DefaultPhotoFlowLogger f17234a;

    private static UnderwoodLogger m21168b(InjectorLike injectorLike) {
        return new UnderwoodLogger(DefaultPhotoFlowLogger.b(injectorLike));
    }

    @Inject
    public UnderwoodLogger(DefaultPhotoFlowLogger defaultPhotoFlowLogger) {
        this.f17234a = defaultPhotoFlowLogger;
    }

    public static UnderwoodLogger m21167a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UnderwoodLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17233c) {
                UnderwoodLogger underwoodLogger;
                if (a2 != null) {
                    underwoodLogger = (UnderwoodLogger) a2.a(f17233c);
                } else {
                    underwoodLogger = f17232b;
                }
                if (underwoodLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m21168b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17233c, b3);
                        } else {
                            f17232b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = underwoodLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
