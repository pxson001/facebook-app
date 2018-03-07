package com.facebook.quickinvite.protocol.service;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.quickinvite.protocol.methods.SendInviteMethod;
import com.facebook.quickinvite.protocol.methods.SendInviteMethod.Params;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: lightweight_event_create */
public class QuickInviteServiceHandler implements BlueServiceHandler {
    private static QuickInviteServiceHandler f8677c;
    private static final Object f8678d = new Object();
    private final ApiMethodRunnerImpl f8679a;
    private final SendInviteMethod f8680b;

    private static QuickInviteServiceHandler m8690b(InjectorLike injectorLike) {
        return new QuickInviteServiceHandler(ApiMethodRunnerImpl.a(injectorLike), new SendInviteMethod());
    }

    @Inject
    public QuickInviteServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, SendInviteMethod sendInviteMethod) {
        this.f8679a = apiMethodRunnerImpl;
        this.f8680b = sendInviteMethod;
    }

    private OperationResult m8689b(OperationParams operationParams) {
        try {
            this.f8679a.a(this.f8680b, (Params) operationParams.b().getParcelable("sendInviteMethodParams"));
            return OperationResult.a();
        } catch (Throwable e) {
            return OperationResult.a(e);
        }
    }

    private OperationResult m8691c(OperationParams operationParams) {
        int i = 0;
        List parcelableArrayList = operationParams.b().getParcelableArrayList("sendBatchInviteParams");
        Batch a = this.f8679a.a();
        for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
            a.a(BatchOperation.a(this.f8680b, parcelableArrayList.get(i2)).a("batch-invite-" + i2).a());
        }
        Throwable b;
        try {
            a.a("batchInvite", CallerContext.a(getClass()));
            while (i < parcelableArrayList.size()) {
                b = a.b("batch-invite-" + i);
                if (b != null) {
                    return OperationResult.a(b);
                }
                i++;
            }
            return OperationResult.a();
        } catch (Throwable b2) {
            return OperationResult.a(b2);
        }
    }

    public final OperationResult m8692a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("quickinvite_send_invite".equals(str)) {
            return m8689b(operationParams);
        }
        if ("quickinvite_send_batch_invite".equals(str)) {
            return m8691c(operationParams);
        }
        throw new IllegalArgumentException("Unknown operation type " + str);
    }

    public static QuickInviteServiceHandler m8688a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickInviteServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8678d) {
                QuickInviteServiceHandler quickInviteServiceHandler;
                if (a2 != null) {
                    quickInviteServiceHandler = (QuickInviteServiceHandler) a2.a(f8678d);
                } else {
                    quickInviteServiceHandler = f8677c;
                }
                if (quickInviteServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8690b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8678d, b3);
                        } else {
                            f8677c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickInviteServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
