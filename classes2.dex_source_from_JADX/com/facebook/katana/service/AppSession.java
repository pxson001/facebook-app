package com.facebook.katana.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.analytics.InteractionLogger;
import com.facebook.attribution.AttributionIdService;
import com.facebook.auth.broadcast.SsoLoginBroadcaster;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.login.AuthStateMachineMonitor;
import com.facebook.auth.login.AuthStateMachineMonitorMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.collect.ReentrantCallback;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessName;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.binding.sessioninfo.SessionInfoHelper;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.method.ApiMethod;
import com.facebook.katana.service.method.ServiceOperation;
import com.facebook.katana.urimap.fetchable.FqlGetUserServerSettings;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

@Deprecated
/* compiled from: short_term_cache_key_storyset */
public class AppSession {
    private static final AppSessionManager f4944b = new AppSessionManager();
    private static int f4945c;
    public ReentrantCallback<AppSessionListener> f4946a;
    public String f4947d;
    public Map<String, Intent> f4948e;
    public LoginStatus f4949f;
    public DisposableFutureCallback<OperationResult> f4950g;
    private boolean f4951h;
    public boolean f4952i;
    public FutureCallback<OperationResult> f4953j;
    public final FbSharedPreferences f4954k;
    private final MoreFileUtils f4955l;
    private final AbstractFbErrorReporter f4956m;
    public final LoggedInUserSessionManager f4957n;
    private final SessionInfoHelper f4958o;
    public final DefaultBlueServiceOperationFactory f4959p;
    public final ExecutorService f4960q;
    public final Context f4961r;
    public final AuthStateMachineMonitor f4962s;
    public final Lazy<SystemTrayNotificationManager> f4963t;

    /* compiled from: short_term_cache_key_storyset */
    public enum LoginStatus {
        STATUS_LOGGED_OUT,
        STATUS_LOGGING_IN,
        STATUS_LOGGED_IN,
        STATUS_LOGGING_OUT
    }

    public AppSession(Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        this.f4956m = FbErrorReporterImpl.m2317a(injectorLike);
        this.f4954k = FbSharedPreferencesImpl.m1826a(injectorLike);
        if (!this.f4954k.mo284a()) {
            this.f4956m.m2340a("AppSession created before initialization was completed, t2045339", "t2045339");
        }
        AppInitLockHelper.m8874a(context);
        DefaultProcessUtil a = DefaultProcessUtil.m2387a(injectorLike);
        String str = "";
        boolean z = false;
        ProcessName a2 = a.m2389a();
        if (a2 == null) {
            BLog.a(DefaultProcessUtil.f1239a, "Couldn't find own process name");
        } else {
            String str2 = a2.b;
            if (str2.startsWith(a.f1241b.getPackageName())) {
                z = Objects.equal(str, str2.substring(a.f1241b.getPackageName().length()));
            } else {
                BLog.a(DefaultProcessUtil.f1239a, "Process name doesn't start with package name");
            }
        }
        if (!z) {
            this.f4956m.m2340a("non_main_process_accesses_appsession", "AppSession should not be accessed from process " + a.m2389a());
        }
        this.f4955l = MoreFileUtils.m5023a(injectorLike);
        this.f4957n = LoggedInUserSessionManager.m2511a(injectorLike);
        this.f4958o = SessionInfoHelper.m8877b(injectorLike);
        this.f4959p = DefaultBlueServiceOperationFactory.m3782b(injectorLike);
        this.f4960q = ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike);
        this.f4961r = (Context) injectorLike.getApplicationInjector().getInstance(Context.class);
        this.f4962s = AuthStateMachineMonitorMethodAutoProvider.m8883a(injectorLike);
        this.f4963t = IdBasedSingletonScopeProvider.m1810b(injectorLike, 2841);
        m8861a();
    }

    public final synchronized void m8861a() {
        this.f4952i = false;
        this.f4951h = false;
        this.f4947d = m8859k();
        this.f4948e = Maps.m843e();
        if (this.f4950g != null) {
            this.f4950g.jc_();
            this.f4950g = null;
        }
        this.f4946a = new ReentrantCallback();
        this.f4949f = LoginStatus.STATUS_LOGGED_OUT;
    }

    public static AppSession m8847a(Context context) {
        return f4944b.m8873b(context);
    }

    private static AppSession m8856d(Context context, boolean z) {
        AppSession a = f4944b.m8871a(context, z);
        if (a != null) {
            return a;
        }
        throw new InvalidAppSessionException("Active app session is null");
    }

    @Deprecated
    @Nullable
    public static AppSession m8848a(Context context, boolean z) {
        return f4944b.m8871a(context, z);
    }

    @Deprecated
    @Nullable
    public static AppSession m8853b(Context context, boolean z) {
        AppSession a = m8848a(context, z);
        return (a == null || !a.m8868c()) ? null : a;
    }

    public final FacebookSessionInfo m8864b() {
        FacebookSessionInfo a = this.f4958o.m8882a();
        if (!FacebookSessionInfo.a(a)) {
            this.f4956m.m2350b("SessionInfo", "Invalid Session Info encountered");
        }
        return a;
    }

    public final boolean m8868c() {
        return FacebookSessionInfo.a(this.f4958o.m8882a());
    }

    public static boolean m8854b(Context context) {
        return f4944b.m8872a(context);
    }

    public final void m8863a(AppSessionListener appSessionListener) {
        this.f4946a.m8894a(appSessionListener);
    }

    public final void m8866b(AppSessionListener appSessionListener) {
        this.f4946a.m8896b(appSessionListener);
    }

    public final LoginStatus m8869d() {
        return this.f4949f;
    }

    public static void m8851a(AppSession appSession, LoginStatus loginStatus) {
        if (appSession.f4949f == null || !appSession.f4949f.equals(loginStatus)) {
            appSession.f4949f = loginStatus;
        }
    }

    public final void m8862a(Context context, LogoutReason logoutReason) {
        InteractionLogger.m6498a(FbInjector.get(context)).f3904c.m5520d();
        m8851a(this, LoginStatus.STATUS_LOGGING_OUT);
        Bundle bundle = new Bundle();
        bundle.putString("logout_reason_param", logoutReason.toString());
        Futures.m2458a(BlueServiceOperationFactoryDetour.a(this.f4959p, "logout", bundle, 787440016).mo3452a(), new LogoutCallback(this, this.f4946a.m8893a()), this.f4960q);
    }

    public static void m8850a(Context context, Intent intent, int i, String str, @Nullable Exception exception, @Nullable Object obj, @Nullable Object obj2) {
        String stringExtra = intent.getStringExtra("sid");
        int intExtra = intent.getIntExtra("type", -1);
        AppSession b = f4944b.m8873b(context);
        if (b.f4949f == LoginStatus.STATUS_LOGGED_OUT) {
            BLog.b("onServiceOperationComplete", "Ignoring reply because user is logged out for type: " + intExtra);
        } else if (stringExtra != null && stringExtra.equals(b.f4947d)) {
            b.m8849a(context, intent, i, str, exception, obj);
        }
    }

    public final void m8870e() {
        this.f4962s.m8890a();
        TracerDetour.a("AppSession.doLogin", -1196616953);
        try {
            m8867c(this.f4961r, true);
            for (AppSessionListener a : this.f4946a.m8893a()) {
                a.a(null);
            }
        } finally {
            TracerDetour.a(-383407058);
        }
    }

    private void m8855c(Context context, LogoutReason logoutReason) {
        if (this.f4957n.m2522b()) {
            try {
                m8856d(context, false).m8865b(context, logoutReason);
            } catch (InvalidAppSessionException e) {
            }
        }
    }

    public final void m8865b(Context context, LogoutReason logoutReason) {
        this.f4956m.m2340a("FORCED_LOGOUT", logoutReason.toString());
        this.f4952i = true;
        m8862a(context, logoutReason);
    }

    private void m8849a(Context context, Intent intent, int i, String str, @Nullable Exception exception, @Nullable Object obj) {
        int intExtra = intent.getIntExtra("type", -1);
        if (ApiMethod.a(exception) && m8868c()) {
            FacebookSessionInfo b = m8864b();
            boolean a = StringUtil.m3590a(intent.getStringExtra("session_key"), b.sessionKey);
            boolean a2 = StringUtil.m3590a(intent.getStringExtra("access_token"), b.oAuthToken);
            if ((a || a2) && !this.f4951h) {
                m8855c(context, LogoutReason.FORCED_ERROR_INVALID_SESSION);
                this.f4951h = true;
            }
        }
        String stringExtra = intent.getStringExtra("rid");
        if (stringExtra != null) {
            this.f4948e.remove(stringExtra);
        }
        switch (intExtra) {
            case 1001:
                ((FqlGetUserServerSettings) obj).a(context, i);
                break;
        }
        if (this.f4948e.size() == 0) {
            context.stopService(new Intent(context, FacebookService.class));
            FacebookService.a.clear();
        }
    }

    final void m8867c(final Context context, boolean z) {
        InjectorLike injectorLike = FbInjector.get(context);
        this.f4951h = false;
        m8851a(this, LoginStatus.STATUS_LOGGED_IN);
        if (z) {
            SsoLoginBroadcaster.b(injectorLike).a();
            ListenableFuture a = BlueServiceOperationFactoryDetour.a(this.f4959p, "login_data_fetch", new Bundle(), ErrorPropagation.BY_EXCEPTION, CallerContext.m9060a(AppSession.class), 2101713853).mo3452a();
            if (this.f4953j != null) {
                Futures.m2458a(a, this.f4953j, this.f4960q);
                this.f4953j = null;
            }
        } else {
            InteractionLogger.m6498a(injectorLike).m6502a();
        }
        ExecutorDetour.a(IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(injectorLike), new Runnable(this) {
            final /* synthetic */ AppSession f4991b;

            public void run() {
                TracerDetour.a("AppSession.runOnLoginNonCritical", 590203848);
                try {
                    AppSession.m8857d(this.f4991b, context);
                } finally {
                    TracerDetour.a(410107761);
                }
            }
        }, 1993821992);
    }

    @Deprecated
    public static void m8857d(AppSession appSession, Context context) {
        if (appSession.f4949f == LoginStatus.STATUS_LOGGED_IN) {
            ((SystemTrayNotificationManager) appSession.f4963t.get()).a(NotificationType.AUTHENTICATION_FAILED);
            ((SystemTrayNotificationManager) appSession.f4963t.get()).a(10004);
        }
        ViewerContext a = appSession.f4957n.m2517a();
        if (a != null) {
            AttributionIdService.m20243a(context.getApplicationContext(), Long.parseLong(a.mUserId));
        }
    }

    public static void m8858e(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
    }

    public static boolean m8852a(Intent intent) {
        if (1 == intent.getIntExtra("type", -1)) {
            return true;
        }
        return false;
    }

    public final String m8860a(Context context, ServiceOperation serviceOperation, int i, int i2, @Nullable Bundle bundle) {
        String k = m8859k();
        Intent intent = new Intent(context, FacebookService.class);
        intent.putExtra("type", i);
        intent.putExtra("rid", k);
        intent.putExtra("sid", this.f4947d);
        intent.putExtra("extended_type", i2);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (m8868c()) {
            String str = m8864b().oAuthToken;
            if (str != null) {
                intent.putExtra("access_token", str);
            }
        }
        if (LoginStatus.STATUS_LOGGING_IN != this.f4949f || m8852a(intent)) {
            this.f4948e.put(k, intent);
            FacebookService.a.put(k, serviceOperation);
            context.startService(intent);
        }
        return k;
    }

    public static synchronized String m8859k() {
        String stringBuilder;
        synchronized (AppSession.class) {
            StringBuilder stringBuilder2 = new StringBuilder();
            int i = f4945c;
            f4945c = i + 1;
            stringBuilder = stringBuilder2.append(i).toString();
        }
        return stringBuilder;
    }
}
