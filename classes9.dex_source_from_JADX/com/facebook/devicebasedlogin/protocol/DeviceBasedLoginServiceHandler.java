package com.facebook.devicebasedlogin.protocol;

import android.content.Context;
import android.os.Bundle;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.DBLChangeNonceMethod;
import com.facebook.auth.protocol.DBLChangeNonceUsingPasswordMethod;
import com.facebook.auth.protocol.DBLCheckNonceMethod;
import com.facebook.auth.protocol.DBLCheckPasswordMethod;
import com.facebook.auth.protocol.DBLRemoveNonceMethod;
import com.facebook.auth.protocol.DBLRemoveNonceMethod.Params;
import com.facebook.auth.protocol.SetNonceMethod;
import com.facebook.auth.protocol.SetNonceMethod.DeviceBasedLoginParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.config.application.PlatformAppConfig;
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
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: person */
public class DeviceBasedLoginServiceHandler implements BlueServiceHandler {
    public static final CallerContext f6633a = CallerContext.a(DeviceBasedLoginServiceHandler.class);
    private static DeviceBasedLoginServiceHandler f6634j;
    private static final Object f6635k = new Object();
    public final Provider<SingleMethodRunner> f6636b;
    private final SetNonceMethod f6637c;
    public final DBLRemoveNonceMethod f6638d;
    private final DBLChangeNonceMethod f6639e;
    public final DBLCheckNonceMethod f6640f;
    public final DBLCheckPasswordMethod f6641g;
    public final DBLChangeNonceUsingPasswordMethod f6642h;
    public final FbSharedPreferences f6643i;

    private static DeviceBasedLoginServiceHandler m6951b(InjectorLike injectorLike) {
        return new DeviceBasedLoginServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), SetNonceMethod.b(injectorLike), new DBLRemoveNonceMethod((PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class)), DBLChangeNonceMethod.b(injectorLike), new DBLCheckNonceMethod((PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class)), new DBLCheckPasswordMethod((PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class)), DBLChangeNonceUsingPasswordMethod.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public DeviceBasedLoginServiceHandler(Provider<SingleMethodRunner> provider, SetNonceMethod setNonceMethod, DBLRemoveNonceMethod dBLRemoveNonceMethod, DBLChangeNonceMethod dBLChangeNonceMethod, DBLCheckNonceMethod dBLCheckNonceMethod, DBLCheckPasswordMethod dBLCheckPasswordMethod, DBLChangeNonceUsingPasswordMethod dBLChangeNonceUsingPasswordMethod, FbSharedPreferences fbSharedPreferences) {
        this.f6636b = provider;
        this.f6637c = setNonceMethod;
        this.f6638d = dBLRemoveNonceMethod;
        this.f6639e = dBLChangeNonceMethod;
        this.f6640f = dBLCheckNonceMethod;
        this.f6641g = dBLCheckPasswordMethod;
        this.f6642h = dBLChangeNonceUsingPasswordMethod;
        this.f6643i = fbSharedPreferences;
    }

    public final OperationResult m6952a(OperationParams operationParams) {
        String str = operationParams.b;
        Bundle bundle = operationParams.c;
        if ("set_nonce".equals(str)) {
            return m6949a(bundle.getString("machine_id"), bundle.getString("pin"), bundle.getString("nonce_to_keep"));
        }
        if ("remove_nonce".equals(str)) {
            return OperationResult.a(((Boolean) ((AbstractSingleMethodRunner) this.f6636b.get()).a(this.f6638d, new Params(this.f6643i.a(AuthPrefKeys.f, null), bundle.getString("account_id"), bundle.getString("nonce")), f6633a)).toString());
        } else if ("change_nonce".equals(str)) {
            return m6950a(bundle.getString("account_id"), bundle.getString("nonce"), bundle.getString("old_pin"), bundle.getString("new_pin"));
        } else {
            if ("check_nonce".equals(str)) {
                return OperationResult.a(((Boolean) ((AbstractSingleMethodRunner) this.f6636b.get()).a(this.f6640f, new DBLCheckNonceMethod.Params(bundle.getString("account_id"), this.f6643i.a(AuthPrefKeys.f, null), bundle.getString("nonce"), bundle.getString("pin")), f6633a)).toString());
            } else if ("check_password".equals(str)) {
                return OperationResult.a(((Boolean) ((AbstractSingleMethodRunner) this.f6636b.get()).a(this.f6641g, new DBLCheckPasswordMethod.Params(operationParams.c.getString("account_id"), this.f6643i.a(AuthPrefKeys.f, null), operationParams.c.getString("password")), f6633a)).toString());
            } else if (!"change_nonce_using_password".equals(str)) {
                return OperationResult.a(ErrorCode.ORCA_SERVICE_UNKNOWN_OPERATION);
            } else {
                return OperationResult.a((DBLFacebookCredentials) ((AbstractSingleMethodRunner) this.f6636b.get()).a(this.f6642h, new DBLChangeNonceUsingPasswordMethod.Params(operationParams.c.getString("account_id"), this.f6643i.a(AuthPrefKeys.f, null), operationParams.c.getString("password"), operationParams.c.getString("new_pin")), f6633a));
            }
        }
    }

    public static DeviceBasedLoginServiceHandler m6948a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DeviceBasedLoginServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6635k) {
                DeviceBasedLoginServiceHandler deviceBasedLoginServiceHandler;
                if (a2 != null) {
                    deviceBasedLoginServiceHandler = (DeviceBasedLoginServiceHandler) a2.a(f6635k);
                } else {
                    deviceBasedLoginServiceHandler = f6634j;
                }
                if (deviceBasedLoginServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6951b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6635k, b3);
                        } else {
                            f6634j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = deviceBasedLoginServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private OperationResult m6949a(String str, String str2, String str3) {
        if (str == null) {
            str = this.f6643i.a(AuthPrefKeys.f, null);
        }
        return OperationResult.a((DBLFacebookCredentials) ((AbstractSingleMethodRunner) this.f6636b.get()).a(this.f6637c, new DeviceBasedLoginParams(str, str2, str3, null), f6633a));
    }

    private OperationResult m6950a(String str, String str2, String str3, String str4) {
        return OperationResult.a((DBLFacebookCredentials) ((AbstractSingleMethodRunner) this.f6636b.get()).a(this.f6639e, new DBLChangeNonceMethod.Params(str, this.f6643i.a(AuthPrefKeys.f, null), str2, str3, str4), f6633a));
    }
}
