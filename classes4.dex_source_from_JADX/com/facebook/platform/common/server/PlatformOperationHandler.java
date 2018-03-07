package com.facebook.platform.common.server;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getAllFriendsWithCap */
public class PlatformOperationHandler implements BlueServiceHandler {
    private static final Class<?> f11243a = PlatformOperationHandler.class;
    private static PlatformOperationHandler f11244c;
    private static final Object f11245d = new Object();
    private final Map<String, PlatformOperation> f11246b = Maps.c();

    private static PlatformOperationHandler m11666b(InjectorLike injectorLike) {
        return new PlatformOperationHandler(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PlatformOperation(injectorLike)));
    }

    @Inject
    public PlatformOperationHandler(Set<PlatformOperation> set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractPlatformOperation abstractPlatformOperation = (AbstractPlatformOperation) it.next();
            this.f11246b.put(abstractPlatformOperation.f11251a, abstractPlatformOperation);
        }
    }

    public final OperationResult m11667a(OperationParams operationParams) {
        AbstractPlatformOperation abstractPlatformOperation = (AbstractPlatformOperation) this.f11246b.get(operationParams.b);
        if (abstractPlatformOperation != null) {
            return abstractPlatformOperation.mo836a(operationParams);
        }
        throw new Exception("Unknown operation");
    }

    public static PlatformOperationHandler m11665a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlatformOperationHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11245d) {
                PlatformOperationHandler platformOperationHandler;
                if (a2 != null) {
                    platformOperationHandler = (PlatformOperationHandler) a2.a(f11245d);
                } else {
                    platformOperationHandler = f11244c;
                }
                if (platformOperationHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11666b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11245d, b3);
                        } else {
                            f11244c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = platformOperationHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
