package com.facebook.auth.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.login.ipc.LaunchAuthActivityUtil;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.SafeLocalBroadcastReceiver;
import com.facebook.common.activitylistener.annotations.AuthNotRequiredHelper;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbservice.ops.CriticalServiceExceptionChecker;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.Lazy;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: subscribeGenericTopics */
public class AuthenticatedActivityHelper {
    private static final Set<String> f3928b = ImmutableSet.of(FBLinks.f2171s);
    public SafeLocalBroadcastReceiver f3929a;
    private final LoggedInUserSessionManager f3930c;
    private final AppInitLock f3931d;
    private final CriticalServiceExceptionChecker f3932e;
    public final Lazy<LaunchAuthActivityUtil> f3933f;
    private final Provider<String> f3934g;
    private final FbSharedPreferences f3935h;
    public final BaseFbBroadcastManager f3936i;
    private final ExecutorService f3937j;
    public String f3938k;
    public SelfRegistrableReceiverImpl f3939l;
    public AlertDialog f3940m;

    @Inject
    public AuthenticatedActivityHelper(LoggedInUserAuthDataStore loggedInUserAuthDataStore, AppInitLock appInitLock, CriticalServiceExceptionChecker criticalServiceExceptionChecker, Lazy<LaunchAuthActivityUtil> lazy, Provider<String> provider, FbSharedPreferences fbSharedPreferences, FbBroadcastManager fbBroadcastManager, ExecutorService executorService) {
        this.f3930c = loggedInUserAuthDataStore;
        this.f3931d = appInitLock;
        this.f3932e = criticalServiceExceptionChecker;
        this.f3933f = lazy;
        this.f3934g = provider;
        this.f3935h = fbSharedPreferences;
        this.f3936i = fbBroadcastManager;
        this.f3937j = executorService;
    }

    public final void m6533a(Activity activity, @Nullable Bundle bundle) {
        if (this.f3935h.mo284a()) {
            this.f3938k = (String) this.f3934g.get();
            if (bundle != null && bundle.containsKey("loggedInUser")) {
                this.f3938k = bundle.getString("loggedInUser");
            }
            if (!m6531e(activity)) {
                ((FbAndroidAuthActivityUtil) this.f3933f.get()).a(activity);
                activity.finish();
            }
        }
    }

    public final void m6532a(final Activity activity) {
        if (!AuthNotRequiredHelper.m6539a(activity)) {
            ExecutorDetour.a(this.f3937j, new Runnable(this) {
                final /* synthetic */ AuthenticatedActivityHelper f8325b;

                /* compiled from: subscribeGenericTopics */
                class C03632 implements ActionReceiver {
                    final /* synthetic */ C03591 f8345a;

                    C03632(C03591 c03591) {
                        this.f8345a = c03591;
                    }

                    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2005183128);
                        AuthenticatedActivityHelper.m6530d(this.f8345a.f8325b, activity);
                        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 546783585, a);
                    }
                }

                public void run() {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("com.facebook.orca.login.AuthStateMachineMonitor.LOGOUT_COMPLETE");
                    this.f8325b.f3929a = new SafeLocalBroadcastReceiver(this, activity, intentFilter) {
                        final /* synthetic */ C03591 f8336a;

                        public final void mo1730a(Context context, Intent intent) {
                            activity.finish();
                        }
                    };
                    this.f8325b.f3929a.m12857a();
                    this.f8325b.f3939l = this.f8325b.f3936i.m2951a().mo506a("ACTION_MQTT_NO_AUTH", new C03632(this)).mo503a();
                    this.f8325b.f3939l.m3296b();
                }
            }, -1523484706);
        }
    }

    public final void m6534b(Activity activity) {
        if (!m6531e(activity)) {
            ((FbAndroidAuthActivityUtil) this.f3933f.get()).a(activity);
            activity.finish();
        }
    }

    public static void m6530d(AuthenticatedActivityHelper authenticatedActivityHelper, Activity activity) {
        if (!activity.isFinishing()) {
            Object obj;
            if (authenticatedActivityHelper.f3940m == null || !authenticatedActivityHelper.f3940m.isShowing()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                authenticatedActivityHelper.f3940m = new FbAlertDialogBuilder(activity).a(2131230873).b(2131230874).a(2131230875, new 2(authenticatedActivityHelper, activity)).a(false).b();
            }
        }
    }

    private boolean m6531e(Activity activity) {
        if (AuthNotRequiredHelper.m6539a(activity)) {
            return true;
        }
        if (!this.f3931d.m2278c()) {
            return true;
        }
        if (this.f3930c.m2522b() && Objects.equal(this.f3934g.get(), this.f3938k)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (!(intent == null || StringUtil.m3589a(intent.getDataString()))) {
            String dataString = intent.getDataString();
            for (String startsWith : f3928b) {
                if (dataString.startsWith(startsWith)) {
                    return true;
                }
            }
        }
        return false;
    }
}
