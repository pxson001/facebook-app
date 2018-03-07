package com.facebook.profile.inforequest.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.profile.inforequest.protocol.DeleteInfoRequestMethod;
import com.facebook.profile.inforequest.protocol.InfoRequestMethod;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: loadAndSetEmojiAndButtonOnFront */
public class InfoRequestServiceHandler implements BlueServiceHandler {
    private static InfoRequestServiceHandler f8577e;
    private static final Object f8578f = new Object();
    private final AbstractFbErrorReporter f8579a;
    private final Provider<SingleMethodRunner> f8580b;
    private final Provider<InfoRequestMethod> f8581c;
    private final Provider<DeleteInfoRequestMethod> f8582d;

    private static InfoRequestServiceHandler m8488b(InjectorLike injectorLike) {
        return new InfoRequestServiceHandler((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2289), IdBasedProvider.a(injectorLike, 9734), IdBasedProvider.a(injectorLike, 9733));
    }

    @Inject
    public InfoRequestServiceHandler(FbErrorReporter fbErrorReporter, Provider<SingleMethodRunner> provider, Provider<InfoRequestMethod> provider2, Provider<DeleteInfoRequestMethod> provider3) {
        this.f8579a = fbErrorReporter;
        this.f8580b = provider;
        this.f8581c = provider2;
        this.f8582d = provider3;
    }

    public final OperationResult m8489a(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        String str = operationParams.b;
        if ("timeline_delete_info_request".equals(str)) {
            return m8485a(bundle, (ApiMethod) this.f8582d.get());
        }
        if ("timeline_send_info_request".equals(str)) {
            return m8485a(bundle, (ApiMethod) this.f8581c.get());
        }
        throw new ApiMethodNotFoundException(str);
    }

    public static InfoRequestServiceHandler m8486a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InfoRequestServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8578f) {
                InfoRequestServiceHandler infoRequestServiceHandler;
                if (a2 != null) {
                    infoRequestServiceHandler = (InfoRequestServiceHandler) a2.a(f8578f);
                } else {
                    infoRequestServiceHandler = f8577e;
                }
                if (infoRequestServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8488b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8578f, b3);
                        } else {
                            f8577e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = infoRequestServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private OperationResult m8485a(Bundle bundle, ApiMethod apiMethod) {
        Parcelable parcelable = bundle.getParcelable("operationParams");
        try {
            return OperationResult.a((Parcelable) ((AbstractSingleMethodRunner) this.f8580b.get()).a(apiMethod, parcelable));
        } catch (Exception e) {
            m8487a(e, parcelable);
            throw e;
        }
    }

    private void m8487a(Exception exception, Parcelable parcelable) {
        String message = exception.getMessage();
        if (parcelable != null) {
            message = message + " with: " + parcelable.toString();
        }
        this.f8579a.a("InfoRequestServiceHandler_" + exception.getClass().getName(), message, exception);
    }
}
