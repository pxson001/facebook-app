package com.facebook.api.reportable_entity;

import android.content.Context;
import com.facebook.api.reportable_entity.NegativeFeedbackActionOnReportableEntityMethod.Params;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
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
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: video_broadcast_update */
public class NegativeFeedbackActionOnReportableEntityHandler implements BlueServiceHandler {
    private static NegativeFeedbackActionOnReportableEntityHandler f610c;
    private static final Object f611d = new Object();
    private final Provider<SingleMethodRunner> f612a;
    private final NegativeFeedbackActionOnReportableEntityMethod f613b;

    private static NegativeFeedbackActionOnReportableEntityHandler m708b(InjectorLike injectorLike) {
        return new NegativeFeedbackActionOnReportableEntityHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new NegativeFeedbackActionOnReportableEntityMethod());
    }

    @Inject
    public NegativeFeedbackActionOnReportableEntityHandler(Provider<SingleMethodRunner> provider, NegativeFeedbackActionOnReportableEntityMethod negativeFeedbackActionOnReportableEntityMethod) {
        this.f612a = provider;
        this.f613b = negativeFeedbackActionOnReportableEntityMethod;
    }

    public final OperationResult m709a(OperationParams operationParams) {
        ((AbstractSingleMethodRunner) this.f612a.get()).a(this.f613b, (Params) operationParams.c.getParcelable("negativeFeedbackActionOnReportableEntityParams"));
        return OperationResult.a;
    }

    public static NegativeFeedbackActionOnReportableEntityHandler m707a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NegativeFeedbackActionOnReportableEntityHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f611d) {
                NegativeFeedbackActionOnReportableEntityHandler negativeFeedbackActionOnReportableEntityHandler;
                if (a2 != null) {
                    negativeFeedbackActionOnReportableEntityHandler = (NegativeFeedbackActionOnReportableEntityHandler) a2.a(f611d);
                } else {
                    negativeFeedbackActionOnReportableEntityHandler = f610c;
                }
                if (negativeFeedbackActionOnReportableEntityHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m708b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f611d, b3);
                        } else {
                            f610c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = negativeFeedbackActionOnReportableEntityHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
