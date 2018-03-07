package com.facebook.auth.login;

import android.os.Bundle;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AccountSwitchingAuthenticationResult;
import com.facebook.auth.component.AuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.component.STATICDI_MULTIBIND_PROVIDER$AuthComponent;
import com.facebook.auth.component.persistent.PersistentComponent;
import com.facebook.auth.component.persistent.STATICDI_MULTIBIND_PROVIDER$PersistentComponent;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.credentials.WorkUserSwitchCredentials;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.AuthExpireSessionMethod;
import com.facebook.auth.protocol.AuthenticateDBLMethod;
import com.facebook.auth.protocol.AuthenticateMethod;
import com.facebook.auth.protocol.AuthenticateSsoMethod;
import com.facebook.auth.protocol.AuthenticateSsoMethod.Params;
import com.facebook.auth.protocol.ConfirmedMessengerCredentials;
import com.facebook.auth.protocol.CreateMessengerAccountCredentials;
import com.facebook.auth.protocol.CreateMessengerAccountMethod;
import com.facebook.auth.protocol.LoginBypassWithMessengerCredentialsMethod;
import com.facebook.auth.protocol.WorkAccountSwitchMethod;
import com.facebook.auth.protocol.WorkCommunityPeekMethod;
import com.facebook.auth.protocol.WorkCommunityPeekResult;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.work.auth.request.model.WorkCommunity;
import com.facebook.work.config.WorkPrefKeys;
import com.facebook.work.config.community.WorkCommunityConfigStore;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: taggable_activities */
public class AuthOperations {
    private static volatile AuthOperations f1335u;
    private final LoggedInUserSessionManager f1336a;
    public final FbSharedPreferences f1337b;
    private final Set<AuthComponent> f1338c;
    public final AuthenticateMethod f1339d;
    public final AuthenticateSsoMethod f1340e;
    public final Provider<SingleMethodRunner> f1341f;
    private final AuthExpireSessionMethod f1342g;
    private final LoginAfterAuthCoordinator f1343h;
    public final Provider<Boolean> f1344i;
    private final AuthDataStoreLogoutHelper f1345j;
    public final CreateMessengerAccountMethod f1346k;
    public final LoginBypassWithMessengerCredentialsMethod f1347l;
    private final WorkCommunityPeekMethod f1348m;
    public final WorkAccountSwitchMethod f1349n;
    private final Lazy<FbErrorReporter> f1350o;
    private final AuthStateMachineMonitor f1351p;
    public final Lazy<AuthenticateDBLMethod> f1352q;
    public final WorkCommunityConfigStore f1353r;
    private final Lazy<Set<PersistentComponent>> f1354s;
    private final Lazy<QuickPerformanceLogger> f1355t;

    public static com.facebook.auth.login.AuthOperations m1574a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1335u;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.auth.login.AuthOperations.class;
        monitor-enter(r1);
        r0 = f1335u;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m1577b(r0);	 Catch:{ all -> 0x0035 }
        f1335u = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1335u;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.login.AuthOperations.a(com.facebook.inject.InjectorLike):com.facebook.auth.login.AuthOperations");
    }

    private static AuthOperations m1577b(InjectorLike injectorLike) {
        return new AuthOperations(LoggedInUserSessionManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), STATICDI_MULTIBIND_PROVIDER$AuthComponent.m1527b(injectorLike), AuthenticateMethod.m1537a(injectorLike), AuthenticateSsoMethod.m1532a(injectorLike), AuthExpireSessionMethod.m1545a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2289), LoginAfterAuthCoordinator.m1591a(injectorLike), IdBasedProvider.a(injectorLike, 3904), AuthDataStoreLogoutHelper.m1548a(injectorLike), CreateMessengerAccountMethod.m1594a(injectorLike), LoginBypassWithMessengerCredentialsMethod.m1597a(injectorLike), WorkCommunityPeekMethod.m1600a(injectorLike), WorkAccountSwitchMethod.m1605a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), AuthStateMachineMonitorMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 359), WorkCommunityConfigStore.m1608a(injectorLike), STATICDI_MULTIBIND_PROVIDER$PersistentComponent.m1528a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3229));
    }

    @Inject
    public AuthOperations(LoggedInUserSessionManager loggedInUserSessionManager, FbSharedPreferences fbSharedPreferences, Set<AuthComponent> set, AuthenticateMethod authenticateMethod, AuthenticateSsoMethod authenticateSsoMethod, AuthExpireSessionMethod authExpireSessionMethod, Provider<SingleMethodRunner> provider, LoginAfterAuthCoordinator loginAfterAuthCoordinator, Provider<Boolean> provider2, AuthDataStoreLogoutHelper authDataStoreLogoutHelper, CreateMessengerAccountMethod createMessengerAccountMethod, LoginBypassWithMessengerCredentialsMethod loginBypassWithMessengerCredentialsMethod, WorkCommunityPeekMethod workCommunityPeekMethod, WorkAccountSwitchMethod workAccountSwitchMethod, Lazy<FbErrorReporter> lazy, AuthStateMachineMonitor authStateMachineMonitor, Lazy<AuthenticateDBLMethod> lazy2, WorkCommunityConfigStore workCommunityConfigStore, Lazy<Set<PersistentComponent>> lazy3, Lazy<QuickPerformanceLogger> lazy4) {
        this.f1336a = loggedInUserSessionManager;
        this.f1337b = fbSharedPreferences;
        this.f1338c = set;
        this.f1339d = authenticateMethod;
        this.f1340e = authenticateSsoMethod;
        this.f1342g = authExpireSessionMethod;
        this.f1341f = provider;
        this.f1343h = loginAfterAuthCoordinator;
        this.f1344i = provider2;
        this.f1345j = authDataStoreLogoutHelper;
        this.f1346k = createMessengerAccountMethod;
        this.f1347l = loginBypassWithMessengerCredentialsMethod;
        this.f1348m = workCommunityPeekMethod;
        this.f1349n = workAccountSwitchMethod;
        this.f1350o = lazy;
        this.f1351p = authStateMachineMonitor;
        this.f1352q = lazy2;
        this.f1353r = workCommunityConfigStore;
        this.f1354s = lazy3;
        this.f1355t = lazy4;
    }

    public final AuthenticationResult m1584a(String str) {
        return m1570a(new SsoAuthOperation(this, str));
    }

    public final AuthenticationResult m1585a(String str, @Nullable String str2) {
        return m1572a(new SsoAuthOperation(this, str), str2);
    }

    public final AuthenticationResult m1580a(PasswordCredentials passwordCredentials) {
        return m1570a(new PasswordAuthOperation(this, passwordCredentials));
    }

    public final AccountSwitchingAuthenticationResult m1579a(PasswordCredentials passwordCredentials, @Nullable String str) {
        return m1568a(new PasswordAuthOperation(this, passwordCredentials).a(), str);
    }

    public final AccountSwitchingAuthenticationResult m1587b(String str, @Nullable String str2) {
        return m1568a(new SsoAuthOperation(this, str).a(), str2);
    }

    public final AccountSwitchingAuthenticationResult m1578a(DeviceBasedLoginCredentials deviceBasedLoginCredentials, @Nullable String str) {
        return m1568a(new DblAuthOperation(this, deviceBasedLoginCredentials).a(), str);
    }

    private AccountSwitchingAuthenticationResult m1568a(AuthenticationResult authenticationResult, @Nullable String str) {
        String str2;
        String str3;
        String str4;
        ViewerContext a = this.f1336a.a();
        if (a != null) {
            str2 = this.f1336a.a().mUserId;
        } else {
            str2 = null;
        }
        if (a != null) {
            str3 = a.mAuthToken;
        } else {
            str3 = null;
        }
        if (str == null || str3 == null) {
            str4 = null;
        } else {
            str4 = ((AuthenticationResult) ((AbstractSingleMethodRunner) this.f1341f.get()).a(this.f1340e, new Params(str3, this.f1337b.a(AuthPrefKeys.f, null), str, false), CallerContext.b(getClass(), "AuthOperations"))).mo89b().f1490b;
        }
        this.f1337b.edit().putBoolean(AuthPrefKeys.w, true).commit();
        m1589b(null);
        this.f1351p.c();
        AuthenticationResult a2 = m1570a(new 1(this, authenticationResult));
        this.f1337b.edit().a(AuthPrefKeys.w).commit();
        return new AccountSwitchingAuthenticationResult(str2, str4, a2);
    }

    public final AuthenticationResult m1588b(PasswordCredentials passwordCredentials, @Nullable String str) {
        return m1572a(new PasswordAuthOperation(this, passwordCredentials), str);
    }

    public final AuthenticationResult m1581a(WorkUserSwitchCredentials workUserSwitchCredentials) {
        return m1569a(workUserSwitchCredentials, null);
    }

    public final AuthenticationResult m1590c(String str, String str2) {
        return m1570a(new 2(this, str, str2));
    }

    private AuthenticationResult m1569a(WorkUserSwitchCredentials workUserSwitchCredentials, @Nullable WorkCommunity workCommunity) {
        return m1571a(new 3(this, workUserSwitchCredentials), workCommunity);
    }

    public final AuthenticationResult m1583a(CreateMessengerAccountCredentials createMessengerAccountCredentials, boolean z, String str) {
        return m1570a(new 4(this, createMessengerAccountCredentials, z, str));
    }

    public final AuthenticationResult m1582a(ConfirmedMessengerCredentials confirmedMessengerCredentials) {
        return m1570a(new 5(this, confirmedMessengerCredentials));
    }

    public final void m1589b(String str) {
        QuickPerformanceLogger quickPerformanceLogger = (QuickPerformanceLogger) this.f1355t.get();
        quickPerformanceLogger.b(9699329);
        this.f1336a.j();
        try {
            quickPerformanceLogger.b(9699330);
            for (AbstractAuthComponent abstractAuthComponent : this.f1338c) {
                quickPerformanceLogger.b(9699331);
                quickPerformanceLogger.a(9699331, abstractAuthComponent.getClass().getName());
                abstractAuthComponent.c();
                quickPerformanceLogger.b(9699331, (short) 2);
            }
            for (PersistentComponent persistentComponent : (Set) this.f1354s.get()) {
                quickPerformanceLogger.b(9699331);
                quickPerformanceLogger.a(9699331, persistentComponent.getClass().getName());
                persistentComponent.mo97d();
                quickPerformanceLogger.b(9699331, (short) 2);
            }
            quickPerformanceLogger.b(9699330, (short) 2);
            quickPerformanceLogger.b(9699332);
            for (AbstractAuthComponent abstractAuthComponent2 : this.f1338c) {
                quickPerformanceLogger.b(9699333);
                quickPerformanceLogger.a(9699333, abstractAuthComponent2.getClass().getName());
                abstractAuthComponent2.d();
                quickPerformanceLogger.b(9699333, (short) 2);
            }
            quickPerformanceLogger.b(9699332, (short) 2);
            quickPerformanceLogger.b(9699334);
            try {
                ((AbstractSingleMethodRunner) this.f1341f.get()).a(this.f1342g, new AuthExpireSessionMethod.Params(str), CallerContext.b(getClass(), "AuthOperations"));
                quickPerformanceLogger.b(9699334, (short) 2);
            } catch (Throwable e) {
                Throwable th = e;
                quickPerformanceLogger.b(9699334, (short) 3);
                ((AbstractFbErrorReporter) this.f1350o.get()).a("AuthExpireSession failure", th);
            }
            quickPerformanceLogger.b(9699335);
            this.f1345j.m1549a(new 6(this));
            quickPerformanceLogger.b(9699335, (short) 2);
            quickPerformanceLogger.b(9699336);
            for (AbstractAuthComponent abstractAuthComponent22 : this.f1338c) {
                quickPerformanceLogger.b(9699337);
                quickPerformanceLogger.a(9699337, abstractAuthComponent22.getClass().getName());
                abstractAuthComponent22.g();
                quickPerformanceLogger.b(9699337, (short) 2);
            }
            quickPerformanceLogger.b(9699336, (short) 2);
            quickPerformanceLogger.b(9699338);
            for (AbstractAuthComponent abstractAuthComponent222 : this.f1338c) {
                quickPerformanceLogger.b(9699339);
                quickPerformanceLogger.a(9699339, abstractAuthComponent222.getClass().getName());
                abstractAuthComponent222.h();
                quickPerformanceLogger.b(9699339, (short) 2);
            }
            quickPerformanceLogger.b(9699338, (short) 2);
        } finally {
            this.f1336a.k();
            quickPerformanceLogger.b(9699329, (short) 2);
        }
    }

    public final void m1586a() {
        QuickPerformanceLogger quickPerformanceLogger = (QuickPerformanceLogger) this.f1355t.get();
        quickPerformanceLogger.b(9699340);
        for (AbstractAuthComponent abstractAuthComponent : this.f1338c) {
            try {
                quickPerformanceLogger.b(9699341);
                quickPerformanceLogger.a(9699341, abstractAuthComponent.getClass().getName());
                abstractAuthComponent.e();
                quickPerformanceLogger.b(9699341, (short) 2);
            } catch (Throwable e) {
                Throwable th = e;
                quickPerformanceLogger.b(9699341, (short) 3);
                ((AbstractFbErrorReporter) this.f1350o.get()).a("ClearPrivacyCriticalKeys failure", abstractAuthComponent.getClass().getSimpleName(), th);
            }
        }
        quickPerformanceLogger.b(9699340, (short) 2);
        quickPerformanceLogger.b(9699342);
        for (AbstractAuthComponent abstractAuthComponent2 : this.f1338c) {
            try {
                quickPerformanceLogger.b(9699343);
                quickPerformanceLogger.a(9699343, abstractAuthComponent2.getClass().getName());
                abstractAuthComponent2.f();
                quickPerformanceLogger.b(9699343, (short) 2);
            } catch (Throwable e2) {
                th = e2;
                quickPerformanceLogger.b(9699343, (short) 3);
                ((AbstractFbErrorReporter) this.f1350o.get()).a("ClearUserData failure", abstractAuthComponent2.getClass().getSimpleName(), th);
            }
        }
        quickPerformanceLogger.b(9699342, (short) 2);
        quickPerformanceLogger.b(9699344);
        this.f1336a.f();
        quickPerformanceLogger.b(9699344, (short) 2);
    }

    private AuthenticationResult m1573a(Callable<AuthenticationResult> callable, boolean z, @Nullable String str, @Nullable WorkCommunity workCommunity) {
        try {
            if (this.f1336a.a() != null) {
                m1586a();
                ((AbstractFbErrorReporter) this.f1350o.get()).a("LogoutDidNotComplete", "Trying to login, but logout did not complete.");
            }
            for (AbstractAuthComponent a : this.f1338c) {
                a.a();
            }
            AuthenticationResult authenticationResult = (AuthenticationResult) callable.call();
            if (authenticationResult.mo90c() != null) {
                Editor edit = this.f1337b.edit();
                edit.a(AuthPrefKeys.f, authenticationResult.mo90c());
                edit.commit();
            }
            this.f1343h.m1593a();
            this.f1336a.a(authenticationResult.mo89b());
            this.f1336a.l();
            if (z) {
                return m1576b(authenticationResult, str);
            }
            m1575a(authenticationResult, workCommunity);
            return authenticationResult;
        } catch (Exception e) {
            Exception exception = e;
            for (AbstractAuthComponent a2 : this.f1338c) {
                a2.b();
            }
            throw exception;
        }
    }

    private AuthenticationResult m1570a(Callable<AuthenticationResult> callable) {
        return m1573a(callable, false, null, null);
    }

    private AuthenticationResult m1571a(Callable<AuthenticationResult> callable, @Nullable WorkCommunity workCommunity) {
        return m1573a(callable, true, null, workCommunity);
    }

    private AuthenticationResult m1572a(Callable<AuthenticationResult> callable, @Nullable String str) {
        return m1573a(callable, true, str, null);
    }

    private void m1575a(AuthenticationResult authenticationResult, @Nullable WorkCommunity workCommunity) {
        if (workCommunity != null) {
            WorkCommunityConfigStore workCommunityConfigStore = this.f1353r;
            String str = workCommunity.b;
            String str2 = workCommunity.a;
            workCommunityConfigStore.f1366a.edit().a(WorkPrefKeys.f849d, str).a(WorkPrefKeys.f850e, str2).a(WorkPrefKeys.f851f, workCommunity.e).commit();
        }
        for (AbstractAuthComponent a : this.f1338c) {
            a.a(authenticationResult);
        }
    }

    private AuthenticationResult m1576b(AuthenticationResult authenticationResult, @Nullable String str) {
        int i = 0;
        try {
            WorkCommunityPeekResult workCommunityPeekResult = (WorkCommunityPeekResult) ((AbstractSingleMethodRunner) this.f1341f.get()).a(this.f1348m, null, CallerContext.b(getClass(), "AuthOperations"));
            ImmutableList e = workCommunityPeekResult.e();
            if (workCommunityPeekResult.c()) {
                m1575a(authenticationResult, workCommunityPeekResult.d());
                return authenticationResult;
            } else if (e == null || e.isEmpty()) {
                throw new WorkLoginException(ErrorCode.WORK_AUTH_FAILED);
            } else if (str != null) {
                int size = e.size();
                while (i < size) {
                    r0 = (WorkCommunity) e.get(i);
                    if (str.equalsIgnoreCase(r0.c())) {
                        return m1569a(new WorkUserSwitchCredentials(r0.a(), r0.b(), authenticationResult.mo89b().m1699b()), r0);
                    }
                    i++;
                }
                throw new WorkLoginException(ErrorCode.WORK_AUTH_FAILED);
            } else if (e.size() == 1) {
                r0 = (WorkCommunity) e.get(0);
                return m1569a(new WorkUserSwitchCredentials(r0.a(), r0.b(), authenticationResult.mo89b().m1699b()), r0);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("username", authenticationResult.mo89b().m1703f());
                bundle.putString("token", authenticationResult.mo89b().m1699b());
                bundle.putParcelableArrayList("work_communities_param", new ArrayList(e));
                throw new WorkLoginException(ErrorCode.WORK_AUTH_COMMUNITY_ID_REQUIRED, bundle);
            }
        } catch (Exception e2) {
            throw new WorkLoginException(ErrorCode.CONNECTION_FAILURE);
        }
    }
}
