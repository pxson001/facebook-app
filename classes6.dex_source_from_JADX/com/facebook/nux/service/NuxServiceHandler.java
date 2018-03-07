package com.facebook.nux.service;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.interstitial.api.FetchInterstitialsParams;
import com.facebook.nux.status.ResetNuxStatusMethod;
import com.facebook.nux.status.UpdateNuxStatusMethod;
import com.facebook.nux.status.UpdateNuxStatusParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: isFlipped */
public class NuxServiceHandler implements BlueServiceHandler {
    private static NuxServiceHandler f12257e;
    private static final Object f12258f = new Object();
    public final Provider<SingleMethodRunner> f12259a;
    public final Lazy<UpdateNuxStatusMethod> f12260b;
    public final Lazy<ResetNuxStatusMethod> f12261c;
    public final DefaultBlueServiceOperationFactory f12262d;

    private static NuxServiceHandler m19161b(InjectorLike injectorLike) {
        return new NuxServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), IdBasedLazy.a(injectorLike, 8753), IdBasedLazy.a(injectorLike, 8752), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public NuxServiceHandler(Provider<SingleMethodRunner> provider, Lazy<UpdateNuxStatusMethod> lazy, Lazy<ResetNuxStatusMethod> lazy2, BlueServiceOperationFactory blueServiceOperationFactory) {
        this.f12259a = provider;
        this.f12260b = lazy;
        this.f12261c = lazy2;
        this.f12262d = blueServiceOperationFactory;
    }

    public final OperationResult m19162a(OperationParams operationParams) {
        String str = operationParams.b;
        OperationResult operationResult;
        if ("update_nux_status".equals(str)) {
            UpdateNuxStatusParams updateNuxStatusParams = (UpdateNuxStatusParams) operationParams.c.getParcelable("updateNuxStatusParams");
            if (((Boolean) ((AbstractSingleMethodRunner) this.f12259a.get()).a((ApiMethod) this.f12260b.get(), updateNuxStatusParams)).booleanValue()) {
                String str2 = updateNuxStatusParams.f12264b;
                if (str2 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fetchAndUpdateInterstitialsParams", new FetchInterstitialsParams(ImmutableList.of(str2)));
                    FutureUtils.a(BlueServiceOperationFactoryDetour.a(this.f12262d, "interstitials_fetch_and_update", bundle, 27897014).c());
                }
                operationResult = OperationResult.a;
            } else {
                operationResult = OperationResult.a(ErrorCode.OTHER);
            }
            return operationResult;
        } else if ("reset_nux_status".equals(str)) {
            if (((Boolean) ((AbstractSingleMethodRunner) this.f12259a.get()).a((ApiMethod) this.f12261c.get(), null)).booleanValue()) {
                operationResult = OperationResult.a;
            } else {
                operationResult = OperationResult.a(ErrorCode.OTHER);
            }
            return operationResult;
        } else {
            throw new IllegalArgumentException("Unknown operation type: " + str);
        }
    }

    public static NuxServiceHandler m19160a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NuxServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12258f) {
                NuxServiceHandler nuxServiceHandler;
                if (a2 != null) {
                    nuxServiceHandler = (NuxServiceHandler) a2.a(f12258f);
                } else {
                    nuxServiceHandler = f12257e;
                }
                if (nuxServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19161b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12258f, b3);
                        } else {
                            f12257e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nuxServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
