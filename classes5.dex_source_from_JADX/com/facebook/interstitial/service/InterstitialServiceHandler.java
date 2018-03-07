package com.facebook.interstitial.service;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.interstitial.api.FetchInterstitialsMethod;
import com.facebook.interstitial.api.FetchInterstitialsParams;
import com.facebook.interstitial.manager.InterstitialManager;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TOPIC_BAR */
public class InterstitialServiceHandler implements BlueServiceHandler {
    private static InterstitialServiceHandler f13882d;
    private static final Object f13883e = new Object();
    public final AbstractSingleMethodRunner f13884a;
    public final FetchInterstitialsMethod f13885b;
    public final InterstitialManager f13886c;

    private static InterstitialServiceHandler m23265b(InjectorLike injectorLike) {
        return new InterstitialServiceHandler((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), FetchInterstitialsMethod.b(injectorLike), InterstitialManager.a(injectorLike));
    }

    @Inject
    public InterstitialServiceHandler(AbstractSingleMethodRunner abstractSingleMethodRunner, FetchInterstitialsMethod fetchInterstitialsMethod, InterstitialManager interstitialManager) {
        this.f13884a = abstractSingleMethodRunner;
        this.f13885b = fetchInterstitialsMethod;
        this.f13886c = interstitialManager;
    }

    public final OperationResult m23266a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("interstitials_fetch_and_update".equals(str)) {
            FetchInterstitialsParams fetchInterstitialsParams = (FetchInterstitialsParams) operationParams.c.getParcelable("fetchAndUpdateInterstitialsParams");
            this.f13886c.a(fetchInterstitialsParams.a, (List) this.f13884a.a(this.f13885b, fetchInterstitialsParams));
            return OperationResult.a;
        }
        throw new IllegalStateException("Unknown type: " + str);
    }

    public static InterstitialServiceHandler m23264a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InterstitialServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13883e) {
                InterstitialServiceHandler interstitialServiceHandler;
                if (a2 != null) {
                    interstitialServiceHandler = (InterstitialServiceHandler) a2.a(f13883e);
                } else {
                    interstitialServiceHandler = f13882d;
                }
                if (interstitialServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23265b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13883e, b3);
                        } else {
                            f13882d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = interstitialServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
