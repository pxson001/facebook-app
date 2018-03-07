package com.facebook.confirmation.task;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.confirmation.logging.ConfirmationAnalyticsLogger;
import com.facebook.confirmation.logging.ConfirmationLoggingEventType;
import com.facebook.confirmation.prefs.AccountConfirmationPrefKeys;
import com.facebook.confirmation.protocol.OpenIDConnectEmailConfirmationMethod;
import com.facebook.confirmation.protocol.OpenIDConnectEmailConfirmationMethod.Params;
import com.facebook.confirmation.protocol.OpenIDConnectFlow;
import com.facebook.confirmation.protocol.OpenIDConnectProvider;
import com.facebook.confirmation.task.BackgroundConfirmationHelper.ConfirmationMethod;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.model.Contactpoint;
import com.facebook.growth.model.ContactpointType;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fb_logo_badge_count */
public class OpenIDConnectEmailConfirmationBackgroundTask extends AbstractBackgroundTask {
    private static final Class<?> f12009a;
    private static final CallerContext f12010b;
    private static volatile OpenIDConnectEmailConfirmationBackgroundTask f12011n;
    private final Context f12012c;
    private final Clock f12013d;
    private final Lazy<SingleMethodRunner> f12014e;
    private final Lazy<OpenIDConnectEmailConfirmationMethod> f12015f;
    private final BackgroundConfirmationHelper f12016g;
    private final ConfirmationAnalyticsLogger f12017h;
    private final RuntimePermissionsUtil f12018i;
    private final GatekeeperStoreImpl f12019j;
    private final Lazy<FbBroadcastManager> f12020k;
    public final FbSharedPreferences f12021l;
    private final AppStateManager f12022m;

    public static com.facebook.confirmation.task.OpenIDConnectEmailConfirmationBackgroundTask m12674a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12011n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.confirmation.task.OpenIDConnectEmailConfirmationBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12011n;	 Catch:{ all -> 0x003a }
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
        r0 = m12678b(r0);	 Catch:{ all -> 0x0035 }
        f12011n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12011n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.confirmation.task.OpenIDConnectEmailConfirmationBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.confirmation.task.OpenIDConnectEmailConfirmationBackgroundTask");
    }

    private static OpenIDConnectEmailConfirmationBackgroundTask m12678b(InjectorLike injectorLike) {
        return new OpenIDConnectEmailConfirmationBackgroundTask((Context) injectorLike.getInstance(Context.class, ForAppContext.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2289), IdBasedLazy.a(injectorLike, 5318), BackgroundConfirmationHelper.m12689b(injectorLike), ConfirmationAnalyticsLogger.m12704b(injectorLike), RuntimePermissionsUtil.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 401), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), AppStateManager.a(injectorLike));
    }

    static {
        Class cls = OpenIDConnectEmailConfirmationBackgroundTask.class;
        f12009a = cls;
        f12010b = CallerContext.a(cls);
    }

    @Inject
    public OpenIDConnectEmailConfirmationBackgroundTask(@ForAppContext Context context, Clock clock, Lazy<SingleMethodRunner> lazy, Lazy<OpenIDConnectEmailConfirmationMethod> lazy2, BackgroundConfirmationHelper backgroundConfirmationHelper, ConfirmationAnalyticsLogger confirmationAnalyticsLogger, RuntimePermissionsUtil runtimePermissionsUtil, GatekeeperStore gatekeeperStore, Lazy<FbBroadcastManager> lazy3, FbSharedPreferences fbSharedPreferences, AppStateManager appStateManager) {
        super("OPENID_CONNECT_EMAIL_CONFIRMATION_TASK");
        this.f12012c = context;
        this.f12013d = clock;
        this.f12014e = lazy;
        this.f12015f = lazy2;
        this.f12016g = backgroundConfirmationHelper;
        this.f12017h = confirmationAnalyticsLogger;
        this.f12018i = runtimePermissionsUtil;
        this.f12019j = gatekeeperStore;
        this.f12020k = lazy3;
        this.f12021l = fbSharedPreferences;
        this.f12022m = appStateManager;
    }

    public final Set<Prerequisite> mo594h() {
        return ImmutableSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final boolean mo595i() {
        Map k = m12679k();
        List arrayList = new ArrayList();
        int i = 0;
        for (Entry entry : k.entrySet()) {
            if (this.f12013d.a() - ((Long) entry.getValue()).longValue() <= 86400000) {
                i = true;
            } else {
                arrayList.add(entry.getKey());
            }
        }
        if (!arrayList.isEmpty()) {
            this.f12016g.m12695a(ConfirmationMethod.OPENID_CONNECT_EMAIL_CONFIRMATION, (Contactpoint[]) arrayList.toArray(new Contactpoint[0]));
        }
        if (i == 0 || !this.f12019j.a(628, true)) {
            return false;
        }
        return true;
    }

    public final long mo593f() {
        if (!mo595i()) {
            return -1;
        }
        return (((long) (this.f12022m.j() ? 20 : 5)) * 60000) + this.f12021l.a(AccountConfirmationPrefKeys.f13084g, 0);
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        if (!this.f12019j.a(628, false)) {
            return Futures.a(new BackgroundResult(true));
        }
        this.f12021l.edit().a(AccountConfirmationPrefKeys.f13084g, this.f12013d.a()).commit();
        Set<Contactpoint> keySet = m12679k().keySet();
        List arrayList = new ArrayList();
        m12680l();
        for (Contactpoint contactpoint : keySet) {
            int a = this.f12021l.a((PrefKey) AccountConfirmationPrefKeys.f13085h.a(contactpoint.normalized), 0) + 1;
            this.f12021l.edit().a((PrefKey) AccountConfirmationPrefKeys.f13085h.a(contactpoint.normalized), a).commit();
            if (a > 3 || contactpoint.type != ContactpointType.EMAIL) {
                arrayList.add(contactpoint);
            } else {
                Account a2 = m12673a(contactpoint.normalized);
                if (a2 == null) {
                    arrayList.add(contactpoint);
                } else {
                    OpenIDConnectProvider b = m12677b(a2.type);
                    if (b == null) {
                        this.f12017h.m12709a("NO_OPENID_CONNECT_PROVIDER");
                        arrayList.add(contactpoint);
                    } else {
                        Object a3 = m12675a(a2, b);
                        if (!StringUtil.a(a3) && m12676a(contactpoint, a3, b)) {
                            arrayList.add(contactpoint);
                        }
                    }
                }
            }
        }
        this.f12016g.m12695a(ConfirmationMethod.OPENID_CONNECT_EMAIL_CONFIRMATION, (Contactpoint[]) arrayList.toArray(new Contactpoint[0]));
        return Futures.a(new BackgroundResult(true));
    }

    private Map<Contactpoint, Long> m12679k() {
        return this.f12016g.m12692a(ConfirmationMethod.OPENID_CONNECT_EMAIL_CONFIRMATION);
    }

    private Account m12673a(String str) {
        if (this.f12018i.a("android.permission.GET_ACCOUNTS")) {
            for (Account account : AccountManager.get(this.f12012c).getAccountsByType("com.google")) {
                if (account.name.equalsIgnoreCase(str)) {
                    return account;
                }
            }
            this.f12017h.m12709a("NO_ACCOUNT_IN_DEVICE");
            return null;
        }
        this.f12017h.m12709a("GET_ACCOUNTS_PERMISSION_NOT_AVAILABLE");
        return null;
    }

    private static OpenIDConnectProvider m12677b(String str) {
        for (OpenIDConnectProvider openIDConnectProvider : OpenIDConnectProvider.values()) {
            if (openIDConnectProvider.type.equals(str)) {
                return openIDConnectProvider;
            }
        }
        return null;
    }

    private String m12675a(Account account, OpenIDConnectProvider openIDConnectProvider) {
        Exception exception;
        Exception exception2;
        String str = "audience:server:client_id:" + openIDConnectProvider.clientId;
        String str2 = null;
        try {
            str2 = GoogleAuthUtil.a(this.f12012c, account, str);
            try {
                GoogleAuthUtil.a(this.f12012c, str2);
                str = GoogleAuthUtil.a(this.f12012c, account, str);
            } catch (Exception e) {
                exception = e;
                str = str2;
                exception2 = exception;
                this.f12017h.m12709a("Get ID token method exception: " + exception2.getMessage());
                return str;
            }
        } catch (Exception e2) {
            exception = e2;
            str = str2;
            exception2 = exception;
            this.f12017h.m12709a("Get ID token method exception: " + exception2.getMessage());
            return str;
        }
        return str;
    }

    private boolean m12676a(Contactpoint contactpoint, String str, OpenIDConnectProvider openIDConnectProvider) {
        boolean z;
        Exception exception;
        try {
            boolean booleanValue = ((Boolean) ((AbstractSingleMethodRunner) this.f12014e.get()).a((ApiMethod) this.f12015f.get(), new Params(contactpoint, str, OpenIDConnectFlow.ANDROID_CLIFF_CONFIRMATION, openIDConnectProvider), f12010b)).booleanValue();
            if (booleanValue) {
                try {
                    this.f12017h.m12705a();
                    ((BaseFbBroadcastManager) this.f12020k.get()).a(new Intent("action_background_contactpoint_confirmed").putExtra("extra_background_confirmed_contactpoint", contactpoint));
                    return booleanValue;
                } catch (Exception e) {
                    Exception exception2 = e;
                    z = booleanValue;
                    exception = exception2;
                    this.f12017h.m12709a("Confirm email method exception: " + exception.getMessage());
                    return z;
                }
            }
            this.f12017h.m12709a("CONFIRM_EMAIL_METHOD_FAILED");
            return booleanValue;
        } catch (Exception e2) {
            exception = e2;
            z = false;
            this.f12017h.m12709a("Confirm email method exception: " + exception.getMessage());
            return z;
        }
    }

    private void m12680l() {
        String obj;
        ImmutableList copyOf = ImmutableList.copyOf(m12679k().keySet());
        String obj2 = Lists.a(copyOf, new 1(this)).toString();
        if (this.f12018i.a("android.permission.GET_ACCOUNTS")) {
            obj = Lists.a(ImmutableList.copyOf(AccountManager.get(this.f12012c).getAccountsByType("com.google")), new 2(this)).toString();
        } else {
            obj = "GET_ACCOUNTS_PERMISSION_NOT_AVAILABLE";
        }
        ConfirmationAnalyticsLogger confirmationAnalyticsLogger = this.f12017h;
        int size = copyOf.size();
        HoneyClientEventFast a = confirmationAnalyticsLogger.f12031a.a(ConfirmationLoggingEventType.BACKGROUND_EMAIL_CONFIRMATION_TASK_START.getAnalyticsName(), true);
        if (a.a()) {
            a.a("confirmation");
            a.a("pending_contactpoint_count", size);
            a.a("pending_contactpoints", obj2);
            a.a("google_accounts", obj);
            a.b();
        }
    }
}
