package com.facebook.vault.service;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.vault.protocol.FetchBlacklistedSyncPaths;
import javax.inject.Inject;

/* compiled from: tfbid_ */
public class VaultServiceHandler implements BlueServiceHandler {
    private static VaultServiceHandler f1922c;
    private static final Object f1923d = new Object();
    public final ApiMethodRunnerImpl f1924a;
    public final FetchBlacklistedSyncPaths f1925b;

    private static VaultServiceHandler m1980b(InjectorLike injectorLike) {
        return new VaultServiceHandler(ApiMethodRunnerImpl.a(injectorLike), new FetchBlacklistedSyncPaths());
    }

    @Inject
    public VaultServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, FetchBlacklistedSyncPaths fetchBlacklistedSyncPaths) {
        this.f1924a = apiMethodRunnerImpl;
        this.f1925b = fetchBlacklistedSyncPaths;
    }

    public final OperationResult m1981a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("fetch_blacklisted_sync_paths".equals(str)) {
            OperationResult a;
            String str2 = (String) this.f1924a.a(this.f1925b, null);
            if (str2 == null) {
                a = OperationResult.a(ErrorCode.OTHER);
            } else {
                a = OperationResult.a(str2);
            }
            return a;
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    public static VaultServiceHandler m1979a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VaultServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1923d) {
                VaultServiceHandler vaultServiceHandler;
                if (a2 != null) {
                    vaultServiceHandler = (VaultServiceHandler) a2.a(f1923d);
                } else {
                    vaultServiceHandler = f1922c;
                }
                if (vaultServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1980b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1923d, b3);
                        } else {
                            f1922c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = vaultServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
