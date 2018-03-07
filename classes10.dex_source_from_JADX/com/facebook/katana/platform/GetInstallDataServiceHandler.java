package com.facebook.katana.platform;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper.InstallData;
import com.facebook.platform.common.service.AbstractPlatformServiceHandler;
import com.facebook.platform.common.service.PlatformServiceRequest;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: typeahead_model_state */
public class GetInstallDataServiceHandler extends AbstractPlatformServiceHandler<PlatformServiceGetInstallDataRequest> {
    private static final Class<?> f1081b = GetInstallDataServiceHandler.class;
    private static GetInstallDataServiceHandler f1082d;
    private static final Object f1083e = new Object();
    private final Context f1084c;

    private static GetInstallDataServiceHandler m1116b(InjectorLike injectorLike) {
        return new GetInstallDataServiceHandler(IdBasedProvider.a(injectorLike, 7351), (Context) injectorLike.getInstance(Context.class));
    }

    public final void m1117b(Message message, PlatformServiceRequest platformServiceRequest) {
        String e = ((PlatformServiceGetInstallDataRequest) platformServiceRequest).m1171e();
        if (message.replyTo != null) {
            Message b = PlatformServiceGetInstallDataRequest.m1168b(message);
            Messenger messenger = message.replyTo;
            Bundle a = InstallData.a(e, this.f1084c);
            if (a != null) {
                b.setData(a);
            }
            try {
                messenger.send(b);
            } catch (Throwable e2) {
                BLog.a(f1081b, "Unable to respond to get install data request", e2);
            }
        }
    }

    @Inject
    public GetInstallDataServiceHandler(Provider<PlatformServiceGetInstallDataRequest> provider, Context context) {
        super(provider, 65540);
        this.f1084c = context;
    }

    public static GetInstallDataServiceHandler m1115a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GetInstallDataServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1083e) {
                GetInstallDataServiceHandler getInstallDataServiceHandler;
                if (a2 != null) {
                    getInstallDataServiceHandler = (GetInstallDataServiceHandler) a2.a(f1083e);
                } else {
                    getInstallDataServiceHandler = f1082d;
                }
                if (getInstallDataServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1116b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1083e, b3);
                        } else {
                            f1082d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = getInstallDataServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
