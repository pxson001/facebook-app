package com.facebook.saved.common.protocol;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.saved.common.sync.SavedEventHandler;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: setDisableFriendTagging */
public class SavedServiceHandler implements BlueServiceHandler {
    private static SavedServiceHandler f4843d;
    private static final Object f4844e = new Object();
    public final Provider<SingleMethodRunner> f4845a;
    public final UpdateSavedStateMethod f4846b;
    public final SavedEventHandler f4847c;

    private static SavedServiceHandler m7655b(InjectorLike injectorLike) {
        return new SavedServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), UpdateSavedStateMethod.m7657b(injectorLike), SavedEventHandler.m7671b(injectorLike));
    }

    @Inject
    public SavedServiceHandler(Provider<SingleMethodRunner> provider, UpdateSavedStateMethod updateSavedStateMethod, SavedEventHandler savedEventHandler) {
        this.f4845a = provider;
        this.f4846b = updateSavedStateMethod;
        this.f4847c = savedEventHandler;
    }

    public final OperationResult m7656a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("update_saved_state".equals(str)) {
            OperationResult operationResult;
            if (((Boolean) ((AbstractSingleMethodRunner) this.f4845a.get()).a(this.f4846b, (UpdateSavedStateParams) operationParams.c.getParcelable("update_saved_state_params"))).booleanValue()) {
                this.f4847c.m7672a();
                operationResult = OperationResult.a;
            } else {
                operationResult = OperationResult.a(ErrorCode.OTHER);
            }
            return operationResult;
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    public static SavedServiceHandler m7654a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4844e) {
                SavedServiceHandler savedServiceHandler;
                if (a2 != null) {
                    savedServiceHandler = (SavedServiceHandler) a2.a(f4844e);
                } else {
                    savedServiceHandler = f4843d;
                }
                if (savedServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7655b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4844e, b3);
                        } else {
                            f4843d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
