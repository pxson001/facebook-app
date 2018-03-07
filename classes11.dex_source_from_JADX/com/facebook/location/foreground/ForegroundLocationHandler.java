package com.facebook.location.foreground;

import android.content.Context;
import com.facebook.common.hardware.CellDiagnosticsSerializer;
import com.facebook.common.hardware.WifiDiagnosticsSerializer;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Unknown drawerLockMode  */
public class ForegroundLocationHandler implements BlueServiceHandler {
    private static ForegroundLocationHandler f10436c;
    private static final Object f10437d = new Object();
    public final AbstractSingleMethodRunner f10438a;
    public final UpdateForegroundLocationMethod f10439b;

    private static ForegroundLocationHandler m10840b(InjectorLike injectorLike) {
        return new ForegroundLocationHandler((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new UpdateForegroundLocationMethod(UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 704), IdBasedProvider.a(injectorLike, 705), CellDiagnosticsSerializer.a(injectorLike), WifiDiagnosticsSerializer.a(injectorLike), LocationAgeUtil.a(injectorLike)));
    }

    @Inject
    public ForegroundLocationHandler(AbstractSingleMethodRunner abstractSingleMethodRunner, UpdateForegroundLocationMethod updateForegroundLocationMethod) {
        this.f10438a = abstractSingleMethodRunner;
        this.f10439b = updateForegroundLocationMethod;
    }

    public final OperationResult m10841a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("update_foreground_location".equals(str)) {
            this.f10438a.a(this.f10439b, (ImmutableLocation) operationParams.c.getParcelable("location"));
            return OperationResult.a;
        }
        throw new IllegalArgumentException("Unexpected operation type " + str);
    }

    public static ForegroundLocationHandler m10839a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ForegroundLocationHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10437d) {
                ForegroundLocationHandler foregroundLocationHandler;
                if (a2 != null) {
                    foregroundLocationHandler = (ForegroundLocationHandler) a2.a(f10437d);
                } else {
                    foregroundLocationHandler = f10436c;
                }
                if (foregroundLocationHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10840b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10437d, b3);
                        } else {
                            f10436c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = foregroundLocationHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
