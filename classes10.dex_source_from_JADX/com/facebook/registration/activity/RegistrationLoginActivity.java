package com.facebook.registration.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.ClientPeriodicEventReporterManager;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.credentials.PasswordCredentials.Type;
import com.facebook.auth.login.ipc.BackgroundAuthUtil;
import com.facebook.auth.login.ipc.LaunchAuthActivityUtil;
import com.facebook.backgroundtasks.BackgroundTaskManager;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.sessionless.Sessionless;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.nux.fragments.NUXProfilePhotoFragment;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.dbl.AuthLoginHelper;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.katana.service.AppSession;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.status.UpdateNuxStatusParams.Status;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.registration.logging.RegistrationPerfLogger;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.prefs.RegistrationPrefKeys;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: leave_conversation */
public class RegistrationLoginActivity extends FbFragmentActivity implements IAuthNotRequired {
    private ViewGroup f8694A;
    private String f8695B;
    private String f8696C;
    private SelfRegistrableReceiverImpl f8697D;
    public LoginState f8698E;
    private boolean f8699F = false;
    private int f8700G = 0;
    private boolean f8701H = false;
    private final Handler f8702I = new Handler();
    private final Runnable f8703J = new C12941(this);
    @Inject
    FbAndroidAuthActivityUtil f8704p;
    @Inject
    FbAndroidAuthActivityUtil f8705q;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f8706r;
    @Inject
    SimpleRegLogger f8707s;
    @Inject
    RegistrationPerfLogger f8708t;
    @Inject
    FbSharedPreferences f8709u;
    @Inject
    Lazy<BackgroundTaskManager> f8710v;
    @Inject
    @Sessionless
    GatekeeperStoreImpl f8711w;
    @Inject
    Lazy<ClientPeriodicEventReporterManager> f8712x;
    private FbTitleBar f8713y;
    private ViewGroup f8714z;

    /* compiled from: leave_conversation */
    class C12941 implements Runnable {
        final /* synthetic */ RegistrationLoginActivity f8685a;

        C12941(RegistrationLoginActivity registrationLoginActivity) {
            this.f8685a = registrationLoginActivity;
        }

        public void run() {
            if (this.f8685a.f8698E != LoginState.LOGIN_COMPLETE) {
                if (this.f8685a.f8698E == LoginState.AUTH_COMPLETE) {
                    this.f8685a.m8703a(LoginState.LOGIN_COMPLETE);
                } else {
                    this.f8685a.m8703a(LoginState.TIMEOUT);
                }
            }
        }
    }

    /* compiled from: leave_conversation */
    class C12952 implements ActionReceiver {
        final /* synthetic */ RegistrationLoginActivity f8686a;

        C12952(RegistrationLoginActivity registrationLoginActivity) {
            this.f8686a = registrationLoginActivity;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -803870004);
            this.f8686a.m8704a(LoginState.AUTH_FAILED, intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 409604049, a);
        }
    }

    /* compiled from: leave_conversation */
    class C12963 implements ActionReceiver {
        final /* synthetic */ RegistrationLoginActivity f8687a;

        C12963(RegistrationLoginActivity registrationLoginActivity) {
            this.f8687a = registrationLoginActivity;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 703508817);
            this.f8687a.m8703a(LoginState.LOGIN_COMPLETE);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2065527608, a);
        }
    }

    /* compiled from: leave_conversation */
    class C12974 implements ActionReceiver {
        final /* synthetic */ RegistrationLoginActivity f8688a;

        C12974(RegistrationLoginActivity registrationLoginActivity) {
            this.f8688a = registrationLoginActivity;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1452087498);
            this.f8688a.m8703a(LoginState.AUTH_COMPLETE);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -945183022, a);
        }
    }

    /* compiled from: leave_conversation */
    class C12985 implements OnClickListener {
        final /* synthetic */ RegistrationLoginActivity f8689a;

        C12985(RegistrationLoginActivity registrationLoginActivity) {
            this.f8689a = registrationLoginActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            RegistrationLoginActivity.m8717i(this.f8689a);
        }
    }

    /* compiled from: leave_conversation */
    class C12996 implements OnClickListener {
        final /* synthetic */ RegistrationLoginActivity f8690a;

        C12996(RegistrationLoginActivity registrationLoginActivity) {
            this.f8690a = registrationLoginActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            RegistrationLoginActivity.m8718j(this.f8690a);
        }
    }

    /* compiled from: leave_conversation */
    class C13007 implements OnClickListener {
        final /* synthetic */ RegistrationLoginActivity f8691a;

        C13007(RegistrationLoginActivity registrationLoginActivity) {
            this.f8691a = registrationLoginActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            RegistrationLoginActivity.m8717i(this.f8691a);
        }
    }

    /* compiled from: leave_conversation */
    class C13018 extends OnToolbarButtonListener {
        final /* synthetic */ RegistrationLoginActivity f8692a;

        C13018(RegistrationLoginActivity registrationLoginActivity) {
            this.f8692a = registrationLoginActivity;
        }

        public final void m8698a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f8692a.m8702a(Status.SKIPPED);
            this.f8692a.f8707s.i();
            RegistrationLoginActivity.m8714b(this.f8692a, false);
            RegistrationLoginActivity.m8723o(this.f8692a);
        }
    }

    /* compiled from: leave_conversation */
    public class C13029 {
        final /* synthetic */ RegistrationLoginActivity f8693a;

        C13029(RegistrationLoginActivity registrationLoginActivity) {
            this.f8693a = registrationLoginActivity;
        }

        public final void m8699a(String str) {
            RegistrationLoginActivity.m8713b(this.f8693a, str);
            this.f8693a.m8702a(Status.COMPLETE);
            this.f8693a.f8707s.j();
            RegistrationLoginActivity.m8714b(this.f8693a, false);
            RegistrationLoginActivity.m8723o(this.f8693a);
        }
    }

    /* compiled from: leave_conversation */
    enum LoginState {
        LOGGING_IN,
        AUTH_COMPLETE,
        LOGIN_COMPLETE,
        AUTH_FAILED,
        TIMEOUT
    }

    private static <T extends Context> void m8710a(Class<T> cls, T t) {
        m8711a((Object) t, (Context) t);
    }

    public static void m8711a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RegistrationLoginActivity) obj).m8701a(FbAndroidAuthActivityUtil.b(injectorLike), FbAndroidAuthActivityUtil.b(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), SimpleRegLogger.b(injectorLike), RegistrationPerfLogger.m8873a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 384), GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 125));
    }

    protected final void m8725b(Bundle bundle) {
        super.b(bundle);
        Class cls = RegistrationLoginActivity.class;
        m8711a((Object) this, (Context) this);
        setContentView(2130906808);
        FbTitleBarUtil.b(this);
        this.f8713y = (FbTitleBar) findViewById(2131558563);
        this.f8714z = (ViewGroup) findViewById(2131566931);
        this.f8694A = (ViewGroup) findViewById(2131558429);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f8695B = extras.getString("extra_uid");
            this.f8696C = extras.getString("extra_pwd");
        }
        if (StringUtil.a(new CharSequence[]{this.f8695B, this.f8696C})) {
            m8717i(this);
            return;
        }
        m8714b(this, m8724p());
        m8718j(this);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -2045424280);
        m8719k();
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1625614162, a);
    }

    public static void m8717i(RegistrationLoginActivity registrationLoginActivity) {
        registrationLoginActivity.f8708t.f8899a.c(4194308, "RegistrationPerceivedLoginTime");
        registrationLoginActivity.f8705q.a(registrationLoginActivity);
    }

    public static void m8718j(RegistrationLoginActivity registrationLoginActivity) {
        registrationLoginActivity.f8700G++;
        registrationLoginActivity.f8701H = false;
        registrationLoginActivity.m8703a(LoginState.LOGGING_IN);
        HandlerDetour.b(registrationLoginActivity.f8702I, registrationLoginActivity.f8703J, 60000, -1252249348);
        registrationLoginActivity.m8720l();
        PasswordCredentials passwordCredentials = new PasswordCredentials(registrationLoginActivity.f8695B, registrationLoginActivity.f8696C, Type.PASSWORD);
        FbAndroidAuthActivityUtil fbAndroidAuthActivityUtil = registrationLoginActivity.f8704p;
        AuthLoginHelper.a(passwordCredentials, "auth", AppSession.a(registrationLoginActivity), null, null);
    }

    private void m8719k() {
        if (this.f8697D != null) {
            this.f8697D.c();
        }
        HandlerDetour.a(this.f8702I, this.f8703J);
    }

    private void m8720l() {
        this.f8697D = this.f8706r.a().a("com.facebook.orca.login.AuthStateMachineMonitor.AUTH_COMPLETE", new C12974(this)).a("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE", new C12963(this)).a("com.facebook.orca.login.AuthStateMachineMonitor.AUTH_FAILED", new C12952(this)).a();
        this.f8697D.b();
    }

    private void m8703a(LoginState loginState) {
        m8704a(loginState, null);
    }

    private void m8704a(LoginState loginState, @Nullable Intent intent) {
        String str = null;
        this.f8698E = loginState;
        switch (loginState) {
            case LOGGING_IN:
                this.f8707s.g();
                PerformanceLogger performanceLogger = this.f8708t.f8899a;
                MarkerConfig b = new MarkerConfig(4194307, "RegistrationLoginTime").b();
                b.n = true;
                performanceLogger.a(b, true);
                return;
            case LOGIN_COMPLETE:
                this.f8707s.e(LoginState.LOGIN_COMPLETE.name());
                this.f8708t.f8899a.c(4194307, "RegistrationLoginTime");
                ((ClientPeriodicEventReporterManager) this.f8712x.get()).a();
                if (!this.f8699F) {
                    m8717i(this);
                    return;
                }
                return;
            case AUTH_FAILED:
                String c;
                if (intent != null) {
                    Throwable th = (Throwable) intent.getSerializableExtra("AUTH_FAILED_THROWABLE");
                    if (th instanceof ApiException) {
                        ApiException apiException = (ApiException) th;
                        int a = apiException.b().a();
                        str = String.valueOf(a);
                        c = apiException.b().c();
                        if (a == 406 || a == 405) {
                            this.f8701H = true;
                        }
                    } else if (th != null) {
                        str = th.getClass().getSimpleName();
                        c = th.getMessage();
                    }
                    this.f8707s.c(loginState.name(), str, c);
                    this.f8708t.m8879h();
                    m8719k();
                    if (!this.f8699F) {
                        m8723o(this);
                        return;
                    }
                    return;
                }
                c = null;
                this.f8707s.c(loginState.name(), str, c);
                this.f8708t.m8879h();
                m8719k();
                if (!this.f8699F) {
                    m8723o(this);
                    return;
                }
                return;
            case TIMEOUT:
                this.f8707s.c(LoginState.TIMEOUT.name(), null, null);
                this.f8708t.m8879h();
                m8719k();
                if (!this.f8699F) {
                    m8721m();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m8721m() {
        this.f8708t.f8899a.f(4194308, "RegistrationPerceivedLoginTime");
        Builder a = new Builder(this).a(2131232474).b(2131232477).a(false);
        if (this.f8700G < 3) {
            a.a(2131230767, new C12996(this)).b(2131230728, new C12985(this));
        } else {
            a.a(2131230726, new C13007(this));
        }
        a.a().show();
    }

    public static void m8714b(RegistrationLoginActivity registrationLoginActivity, boolean z) {
        if (z) {
            registrationLoginActivity.f8699F = true;
            registrationLoginActivity.f8707s.h();
            String string = registrationLoginActivity.getResources().getString(2131236369);
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.g = string;
            a = a;
            a.j = string;
            TitleBarButtonSpec a2 = a.a();
            registrationLoginActivity.f8713y.setTitle(2131236355);
            registrationLoginActivity.f8713y.setButtonSpecs(ImmutableList.of(a2));
            registrationLoginActivity.f8713y.setOnToolbarButtonListener(new C13018(registrationLoginActivity));
            registrationLoginActivity.f8714z.setVisibility(8);
            registrationLoginActivity.f8694A.setVisibility(0);
            registrationLoginActivity.m8722n();
            return;
        }
        registrationLoginActivity.f8699F = false;
        PerformanceLogger performanceLogger = registrationLoginActivity.f8708t.f8899a;
        MarkerConfig b = new MarkerConfig(4194308, "RegistrationPerceivedLoginTime").b();
        b.n = true;
        performanceLogger.a(b, true);
        registrationLoginActivity.f8713y.setTitle(2131232484);
        registrationLoginActivity.f8713y.setButtonSpecs(RegularImmutableList.a);
        registrationLoginActivity.f8714z.setVisibility(0);
        registrationLoginActivity.f8694A.setVisibility(8);
    }

    private void m8722n() {
        NUXProfilePhotoFragment nUXProfilePhotoFragment = new NUXProfilePhotoFragment();
        nUXProfilePhotoFragment.ao = false;
        nUXProfilePhotoFragment.an = new C13029(this);
        kO_().a().a(2131558429, nUXProfilePhotoFragment).b();
    }

    public static void m8723o(RegistrationLoginActivity registrationLoginActivity) {
        if (registrationLoginActivity.f8698E == LoginState.LOGIN_COMPLETE) {
            m8717i(registrationLoginActivity);
        } else if (registrationLoginActivity.f8698E != LoginState.AUTH_FAILED && registrationLoginActivity.f8698E != LoginState.TIMEOUT) {
        } else {
            if (registrationLoginActivity.f8701H) {
                registrationLoginActivity.f8705q.a(registrationLoginActivity, registrationLoginActivity.getIntent().getExtras());
            } else {
                registrationLoginActivity.m8721m();
            }
        }
    }

    private void m8702a(Status status) {
        this.f8709u.edit().a(GrowthPrefKeys.c(this.f8695B), status.name()).commit();
    }

    public static void m8713b(RegistrationLoginActivity registrationLoginActivity, String str) {
        if (!StringUtil.a(str)) {
            registrationLoginActivity.f8709u.edit().a(RegistrationPrefKeys.b(registrationLoginActivity.f8695B), str).commit();
            ((BackgroundTaskManager) registrationLoginActivity.f8710v.get()).a();
        }
    }

    private boolean m8724p() {
        TriState a = this.f8711w.a(19);
        this.f8707s.a("reg_login_profile_pic", a, this.f8695B);
        return a.asBoolean(false);
    }

    private void m8701a(BackgroundAuthUtil backgroundAuthUtil, LaunchAuthActivityUtil launchAuthActivityUtil, FbBroadcastManager fbBroadcastManager, SimpleRegLogger simpleRegLogger, RegistrationPerfLogger registrationPerfLogger, FbSharedPreferences fbSharedPreferences, Lazy<BackgroundTaskManager> lazy, GatekeeperStore gatekeeperStore, Lazy<ClientPeriodicEventReporterManager> lazy2) {
        this.f8704p = backgroundAuthUtil;
        this.f8705q = launchAuthActivityUtil;
        this.f8706r = fbBroadcastManager;
        this.f8707s = simpleRegLogger;
        this.f8708t = registrationPerfLogger;
        this.f8709u = fbSharedPreferences;
        this.f8710v = lazy;
        this.f8711w = gatekeeperStore;
        this.f8712x = lazy2;
    }
}
