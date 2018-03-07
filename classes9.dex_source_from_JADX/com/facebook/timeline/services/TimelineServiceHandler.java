package com.facebook.timeline.services;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Provider;

/* compiled from: unable to update  */
public abstract class TimelineServiceHandler implements BlueServiceHandler {
    private final Provider<SingleMethodRunner> f1126a;
    private final AbstractFbErrorReporter f1127b;

    public TimelineServiceHandler(Provider<SingleMethodRunner> provider, FbErrorReporter fbErrorReporter) {
        this.f1126a = provider;
        this.f1127b = fbErrorReporter;
    }

    protected final OperationResult m1200a(Bundle bundle, ApiMethod apiMethod) {
        return m1198a(bundle, apiMethod, null);
    }

    private OperationResult m1198a(Bundle bundle, ApiMethod apiMethod, ApiMethodRunnerParams apiMethodRunnerParams) {
        Parcelable parcelable = bundle.getParcelable("operationParams");
        TracerDetour.a("TimelineServiceHandler.handleSingleMethod", -1837590185);
        try {
            try {
                OperationResult a = OperationResult.a((Parcelable) ((AbstractSingleMethodRunner) this.f1126a.get()).a(apiMethod, parcelable, apiMethodRunnerParams));
                return a;
            } catch (Exception e) {
                m1199a(e, parcelable);
                throw e;
            }
        } finally {
            TracerDetour.a(461803489);
        }
    }

    public OperationResult m1202a(OperationParams operationParams) {
        throw new ApiMethodNotFoundException(operationParams.b);
    }

    protected final OperationResult m1201a(Bundle bundle, ApiMethod apiMethod, String str) {
        Parcelable parcelable;
        if (str != null) {
            parcelable = bundle.getParcelable(str);
        } else {
            parcelable = null;
        }
        try {
            return OperationResult.a((String) ((AbstractSingleMethodRunner) this.f1126a.get()).a(apiMethod, parcelable));
        } catch (Exception e) {
            m1199a(e, parcelable);
            throw e;
        }
    }

    private void m1199a(Exception exception, Parcelable parcelable) {
        String message = exception.getMessage();
        if (parcelable != null) {
            message = message + " with: " + parcelable.toString();
        }
        this.f1127b.a("TimelineServiceHandler_" + exception.getClass().getName(), message, exception);
    }
}
