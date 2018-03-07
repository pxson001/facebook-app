package com.facebook.katana.server.handler;

import android.location.Location;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.component.STATICDI_MULTIBIND_PROVIDER$AuthComponent;
import com.facebook.auth.component.persistent.PersistentComponent;
import com.facebook.auth.component.persistent.STATICDI_MULTIBIND_PROVIDER$PersistentComponent;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials;
import com.facebook.auth.credentials.FacebookCredentials;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.login.AuthDataStoreLogoutHelper;
import com.facebook.auth.login.AuthOperations;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.AuthExpireSessionMethod;
import com.facebook.auth.protocol.AuthenticateDBLMethod;
import com.facebook.auth.protocol.AuthenticateMethod;
import com.facebook.auth.protocol.AuthenticateMethod.Params;
import com.facebook.auth.protocol.AuthenticateSsoMethod;
import com.facebook.auth.protocol.AuthenticationResultImpl;
import com.facebook.auth.protocol.SetNonceMethod;
import com.facebook.auth.protocol.SetNonceMethod.DeviceBasedLoginParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner$Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.http.protocol.BootstrapTierUtil;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.server.login.LoginDataFetchHelper;
import com.facebook.katana.server.login.LoginDataFetchHelper.C01031;
import com.facebook.katana.server.protocol.GetSsoUserMethod;
import com.facebook.katana.server.protocol.GetSsoUserMethod.Result;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: task */
public class Fb4aAuthHandler implements BlueServiceHandler {
    public static final CallerContext f1275a = CallerContext.a(Fb4aAuthHandler.class);
    public final Lazy<Set<AuthComponent>> f1276b;
    private final Lazy<Set<PersistentComponent>> f1277c;
    public final GetSsoUserMethod f1278d;
    private final AuthenticateSsoMethod f1279e;
    private final AuthenticateMethod f1280f;
    private final AuthenticateDBLMethod f1281g;
    private final AuthExpireSessionMethod f1282h;
    public final AbstractSingleMethodRunner f1283i;
    private final AuthDataStoreLogoutHelper f1284j;
    private final LoggedInUserSessionManager f1285k;
    private final AbstractFbErrorReporter f1286l;
    private final FbSharedPreferences f1287m;
    private final SetNonceMethod f1288n;
    public final LoginDataFetchHelper f1289o;
    private final Lazy<ApiMethodRunner> f1290p;
    private final BootstrapTierUtil f1291q;
    private final PerformanceLogger f1292r;
    private final FbLocationCache f1293s;
    private final GatekeeperStoreImpl f1294t;
    private final ExecutorService f1295u;
    private final AuthOperations f1296v;
    private final Lazy<QuickPerformanceLogger> f1297w;

    public static Fb4aAuthHandler m1522b(InjectorLike injectorLike) {
        return new Fb4aAuthHandler(STATICDI_MULTIBIND_PROVIDER$AuthComponent.m1526a(injectorLike), STATICDI_MULTIBIND_PROVIDER$PersistentComponent.m1528a(injectorLike), GetSsoUserMethod.m1529a(injectorLike), AuthenticateSsoMethod.m1532a(injectorLike), AuthenticateMethod.m1537a(injectorLike), AuthenticateDBLMethod.m1541a(injectorLike), AuthExpireSessionMethod.m1545a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), AuthDataStoreLogoutHelper.m1548a(injectorLike), LoggedInUserSessionManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SetNonceMethod.m1556a(injectorLike), LoginDataFetchHelper.m1560a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2279), BootstrapTierUtil.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), FbLocationCache.a(injectorLike), GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), AuthOperations.m1574a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3229));
    }

    public final OperationResult m1525a(OperationParams operationParams) {
        String str = operationParams.b;
        if (str.equals("get_sso_user")) {
            return OperationResult.a((Result) this.f1283i.a(this.f1278d, operationParams.c.getString("get_sso_user_params"), f1275a));
        } else if (str.equals("sso")) {
            return m1518a(operationParams.c.getString("sso_auth_token"), operationParams.c.getString("sso_username"));
        } else {
            if (str.equals("auth")) {
                return m1517a((PasswordCredentials) operationParams.c.getParcelable("passwordCredentials"), operationParams.c.getString("error_detail_type_param"));
            }
            if (str.equals("login_data_fetch")) {
                LoginDataFetchHelper loginDataFetchHelper = this.f1289o;
                CallerContext callerContext = f1275a;
                loginDataFetchHelper.f1326g.b(2293764);
                loginDataFetchHelper.f1323d.m1564a(callerContext);
                ExecutorDetour.a(loginDataFetchHelper.f1321b, new C01031(loginDataFetchHelper, callerContext), -459667207);
                loginDataFetchHelper.f1326g.b(2293764, (short) 2);
                return OperationResult.a;
            } else if (str.equals("logout")) {
                this.f1296v.m1589b(operationParams.c.getString("logout_reason_param"));
                return OperationResult.a;
            } else if (str.equals("logged_out_set_nonce")) {
                return m1521b((PasswordCredentials) operationParams.c.getParcelable("passwordCredentials"), operationParams.c.getString("error_detail_type_param"));
            } else {
                return str.equals("device_based_login") ? m1516a((DeviceBasedLoginCredentials) operationParams.c.getParcelable("passwordCredentials"), operationParams.c.getString("error_detail_type_param")) : OperationResult.a(ErrorCode.ORCA_SERVICE_UNKNOWN_OPERATION);
            }
        }
    }

    @Inject
    public Fb4aAuthHandler(Lazy<Set<AuthComponent>> lazy, Lazy<Set<PersistentComponent>> lazy2, GetSsoUserMethod getSsoUserMethod, AuthenticateSsoMethod authenticateSsoMethod, AuthenticateMethod authenticateMethod, AuthenticateDBLMethod authenticateDBLMethod, AuthExpireSessionMethod authExpireSessionMethod, SingleMethodRunner singleMethodRunner, AuthDataStoreLogoutHelper authDataStoreLogoutHelper, LoggedInUserSessionManager loggedInUserSessionManager, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, SetNonceMethod setNonceMethod, LoginDataFetchHelper loginDataFetchHelper, Lazy<ApiMethodRunner> lazy3, BootstrapTierUtil bootstrapTierUtil, PerformanceLogger performanceLogger, FbLocationCache fbLocationCache, GatekeeperStore gatekeeperStore, ExecutorService executorService, AuthOperations authOperations, Lazy<QuickPerformanceLogger> lazy4) {
        this.f1276b = lazy;
        this.f1277c = lazy2;
        this.f1278d = getSsoUserMethod;
        this.f1279e = authenticateSsoMethod;
        this.f1280f = authenticateMethod;
        this.f1281g = authenticateDBLMethod;
        this.f1282h = authExpireSessionMethod;
        this.f1283i = singleMethodRunner;
        this.f1284j = authDataStoreLogoutHelper;
        this.f1285k = loggedInUserSessionManager;
        this.f1286l = fbErrorReporter;
        this.f1287m = fbSharedPreferences;
        this.f1288n = setNonceMethod;
        this.f1289o = loginDataFetchHelper;
        this.f1290p = lazy3;
        this.f1291q = bootstrapTierUtil;
        this.f1292r = performanceLogger;
        this.f1293s = fbLocationCache;
        this.f1294t = gatekeeperStore;
        this.f1295u = executorService;
        this.f1296v = authOperations;
        this.f1297w = lazy4;
    }

    private OperationResult m1517a(PasswordCredentials passwordCredentials, @Nullable String str) {
        Location location = null;
        String a = this.f1287m.a(AuthPrefKeys.f, null);
        ImmutableLocation b = m1523b();
        AuthenticateMethod authenticateMethod = this.f1280f;
        if (b != null) {
            location = b.l();
        }
        return OperationResult.a(m1515a(authenticateMethod, new Params(passwordCredentials, a, location, true, str), "password"));
    }

    private OperationResult m1518a(String str, String str2) {
        try {
            AuthenticationResult authenticationResult = (AuthenticationResult) this.f1283i.a(this.f1279e, new AuthenticateSsoMethod.Params(str, this.f1287m.a(AuthPrefKeys.f, null), true), f1275a);
            FacebookCredentials b = authenticationResult.mo89b();
            String a = authenticationResult.mo88a();
            AuthenticationResult authenticationResultImpl = new AuthenticationResultImpl(a, new FacebookCredentials(b.m1698a(), b.m1699b(), b.m1701d(), b.m1700c(), b.m1702e(), str2), authenticationResult.mo90c(), authenticationResult.mo91d(), authenticationResult.mo92e(), authenticationResult.mo93f());
            if (authenticationResultImpl.mo90c() != null) {
                Editor edit = this.f1287m.edit();
                edit.a(AuthPrefKeys.f, authenticationResultImpl.mo90c());
                edit.commit();
            }
            this.f1285k.a(authenticationResultImpl.mo89b());
            m1519a(this, authenticationResultImpl);
            return OperationResult.a(authenticationResult);
        } catch (Exception e) {
            m1524b(e);
            throw e;
        }
    }

    private <PARAMS> AuthenticationResult m1515a(ApiMethod<PARAMS, AuthenticationResult> apiMethod, @Nullable PARAMS params, String str) {
        final AuthenticationResult b = m1520b(apiMethod, params, str);
        ExecutorDetour.a(this.f1295u, new Runnable(this) {
            final /* synthetic */ Fb4aAuthHandler f1502b;

            public void run() {
                Fb4aAuthHandler.m1519a(this.f1502b, b);
            }
        }, 886810483);
        return b;
    }

    private <PARAMS> AuthenticationResult m1520b(ApiMethod<PARAMS, AuthenticationResult> apiMethod, @Nullable PARAMS params, String str) {
        try {
            if (this.f1285k.a() != null) {
                this.f1296v.m1586a();
                this.f1286l.a("LogoutDidNotComplete", "Trying to login, but logout did not complete.");
            }
            for (AbstractAuthComponent a : (Set) this.f1276b.get()) {
                a.a();
            }
            ((QuickPerformanceLogger) this.f1297w.get()).b(2293780);
            ((QuickPerformanceLogger) this.f1297w.get()).a(2293780, str);
            try {
                AuthenticationResult authenticationResult = (AuthenticationResult) this.f1283i.a(apiMethod, params, f1275a);
                ((QuickPerformanceLogger) this.f1297w.get()).b(2293780, (short) 2);
                if (authenticationResult.mo90c() != null) {
                    Editor edit = this.f1287m.edit();
                    edit.a(AuthPrefKeys.f, authenticationResult.mo90c());
                    edit.commit();
                }
                this.f1285k.a(authenticationResult.mo89b());
                return authenticationResult;
            } catch (Exception e) {
                Exception exception = e;
                String message = exception.getMessage();
                QuickPerformanceLogger quickPerformanceLogger = (QuickPerformanceLogger) this.f1297w.get();
                if (message == null) {
                    message = exception.toString();
                }
                quickPerformanceLogger.a(2293780, message);
                ((QuickPerformanceLogger) this.f1297w.get()).b(2293780, (short) 3);
                throw exception;
            }
        } catch (Exception e2) {
            m1524b(e2);
            throw e2;
        }
    }

    public static void m1519a(Fb4aAuthHandler fb4aAuthHandler, AuthenticationResult authenticationResult) {
        ((QuickPerformanceLogger) fb4aAuthHandler.f1297w.get()).b(5111811);
        for (AbstractAuthComponent abstractAuthComponent : (Set) fb4aAuthHandler.f1276b.get()) {
            try {
                abstractAuthComponent.a(authenticationResult);
            } catch (Throwable e) {
                BLog.b(abstractAuthComponent.getClass(), "AuthComponent.authComplete failure", e);
            } catch (Throwable e2) {
                fb4aAuthHandler.f1286l.b("AuthComponent.authComplete failure", e2);
                String message = e2.getMessage();
                QuickPerformanceLogger quickPerformanceLogger = (QuickPerformanceLogger) fb4aAuthHandler.f1297w.get();
                if (message == null) {
                    message = e2.toString();
                }
                quickPerformanceLogger.a(5111811, message);
            }
        }
        ((QuickPerformanceLogger) fb4aAuthHandler.f1297w.get()).b(5111811, (short) 2);
    }

    private void m1524b(Exception exception) {
        for (AbstractAuthComponent b : (Set) this.f1276b.get()) {
            b.b();
        }
        this.f1285k.f();
    }

    private OperationResult m1516a(DeviceBasedLoginCredentials deviceBasedLoginCredentials, @Nullable String str) {
        Location location = null;
        String a = this.f1287m.a(AuthPrefKeys.f, null);
        ImmutableLocation b = m1523b();
        AuthenticateDBLMethod authenticateDBLMethod = this.f1281g;
        if (b != null) {
            location = b.l();
        }
        return OperationResult.a(m1515a(authenticateDBLMethod, new AuthenticateDBLMethod.Params(deviceBasedLoginCredentials, a, location, true, str), "dbl"));
    }

    private OperationResult m1521b(PasswordCredentials passwordCredentials, String str) {
        Location location = null;
        String a = this.f1287m.a(AuthPrefKeys.f, null);
        ImmutableLocation b = m1523b();
        DeviceBasedLoginParams deviceBasedLoginParams = new DeviceBasedLoginParams(a, null, null, passwordCredentials.f775a);
        if (b != null) {
            location = b.l();
        }
        Params params = new Params(passwordCredentials, a, location, true, str);
        ApiMethodRunner$Batch a2 = ((ApiMethodRunnerImpl) this.f1290p.get()).a();
        Builder a3 = BatchOperation.m12541a(this.f1280f, params);
        a3.f11927c = "authenticate";
        a2.mo888a(a3.m12549a());
        a3 = BatchOperation.m12541a(this.f1288n, deviceBasedLoginParams);
        a3.f11927c = "set_nonce";
        a3 = a3;
        a3.f11928d = "authenticate";
        a3 = a3;
        a3.f11931g = "?access_token={result=authenticate:$.access_token}";
        a2.mo888a(a3.m12549a());
        a2.mo884a("logged_out_set_nonce", f1275a, this.f1291q.a());
        return OperationResult.a((DBLFacebookCredentials) a2.mo887a("set_nonce"));
    }

    private ImmutableLocation m1523b() {
        return this.f1294t.a(10, false) ? this.f1293s.a() : null;
    }
}
