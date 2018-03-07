package com.facebook.auth.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.auth.component.LoginComponent;
import com.facebook.auth.component.persistent.PersistentComponent;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.credentials.WorkUserSwitchCredentials;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.protocol.ConfirmedMessengerCredentials;
import com.facebook.auth.protocol.CreateMessengerAccountCredentials;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.ApiMethodRunnerParams.HttpConfig;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: t%d.indexed_data GLOB '%s*') */
public class AuthServiceHandler implements BlueServiceHandler {
    private static AuthServiceHandler f1367c;
    private static final Object f1368d = new Object();
    private final AuthOperations f1369a;
    private final LoginOperations f1370b;

    private static AuthServiceHandler m1611b(InjectorLike injectorLike) {
        return new AuthServiceHandler(AuthOperations.m1574a(injectorLike), LoginOperations.m1613a(injectorLike));
    }

    @Inject
    public AuthServiceHandler(AuthOperations authOperations, LoginOperations loginOperations) {
        this.f1369a = authOperations;
        this.f1370b = loginOperations;
    }

    public final OperationResult m1612a(OperationParams operationParams) {
        String str = operationParams.b;
        if (str.equals("auth_sso")) {
            return OperationResult.a(this.f1369a.m1584a(operationParams.c.getString("accessToken")));
        }
        Bundle bundle;
        if (str.equals("auth_work_sso")) {
            bundle = operationParams.c;
            return OperationResult.a(this.f1369a.m1585a(bundle.getString("accessToken"), bundle.getString("targetWorkEmail")));
        } else if (str.equals("auth_password")) {
            return OperationResult.a(this.f1369a.m1580a((PasswordCredentials) operationParams.c.getParcelable("passwordCredentials")));
        } else if (str.equals("auth_password_work")) {
            Bundle bundle2 = operationParams.c;
            return OperationResult.a(this.f1369a.m1588b((PasswordCredentials) bundle2.getParcelable("passwordCredentials"), bundle2.getString("targetWorkEmail")));
        } else if (str.equals("auth_work_user_switch")) {
            return OperationResult.a(this.f1369a.m1581a((WorkUserSwitchCredentials) operationParams.c.getParcelable("workUserSwitchCredentials")));
        } else if (str.equals("auth_logout")) {
            this.f1369a.m1589b(null);
            return OperationResult.a;
        } else if ("login".equals(str)) {
            BatchComponent a;
            LoginOperations loginOperations = this.f1370b;
            Preconditions.checkState(loginOperations.f1372a instanceof LoggedInUserSessionManager, "handleLogin can only be used with LoggedInUserSessionManager");
            List a2 = Lists.a();
            for (LoginComponent a3 : loginOperations.f1374c) {
                a = a3.mo143a();
                if (a != null) {
                    a2.add(a);
                }
            }
            for (PersistentComponent persistentComponent : loginOperations.f1375d) {
                persistentComponent.mo94a();
                a = persistentComponent.mo95c();
                if (a != null) {
                    a2.add(a);
                }
            }
            ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
            apiMethodRunnerParams.a(HttpConfig.BOOTSTRAP);
            loginOperations.f1373b.m1567a("handleLogin", CallerContext.a(loginOperations.getClass()), a2, apiMethodRunnerParams);
            return OperationResult.a;
        } else if ("auth_create_messenger_account".equals(str)) {
            return OperationResult.a(this.f1369a.m1583a((CreateMessengerAccountCredentials) operationParams.c.getParcelable("createAccountParams"), operationParams.c.getBoolean("search_for_soft_matched_account", false), operationParams.c.getString("account_recovery_id")));
        } else if ("auth_login_bypass_with_messenger_credentials".equals(str)) {
            return OperationResult.a(this.f1369a.m1582a((ConfirmedMessengerCredentials) operationParams.c.getParcelable("loginMessengerAccountParams")));
        } else if ("auth_switch_accounts".equals(str)) {
            return OperationResult.a(this.f1369a.m1579a((PasswordCredentials) operationParams.c.getParcelable("passwordCredentials"), operationParams.c.getString("alternative_token_app_id")));
        } else if ("auth_switch_accounts_sso".equals(str)) {
            return OperationResult.a(this.f1369a.m1587b(operationParams.c.getString("accessToken"), operationParams.c.getString("alternative_token_app_id")));
        } else if ("auth_switch_accounts_dbl".equals(str)) {
            return OperationResult.a(this.f1369a.m1578a((DeviceBasedLoginCredentials) operationParams.c.getParcelable("dblCredentials"), operationParams.c.getString("alternative_token_app_id")));
        } else if ("auth_temporary_login_nonce".equals(str)) {
            bundle = operationParams.c;
            return OperationResult.a(this.f1369a.m1590c(bundle.getString("user_id"), bundle.getString("temporary_login_nonce")));
        } else {
            throw new IllegalArgumentException("Unhandled operation type: " + str);
        }
    }

    public static AuthServiceHandler m1610a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AuthServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1368d) {
                AuthServiceHandler authServiceHandler;
                if (a2 != null) {
                    authServiceHandler = (AuthServiceHandler) a2.a(f1368d);
                } else {
                    authServiceHandler = f1367c;
                }
                if (authServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1611b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1368d, b3);
                        } else {
                            f1367c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = authServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
