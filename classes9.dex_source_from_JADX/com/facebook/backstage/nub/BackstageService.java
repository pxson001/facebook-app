package com.facebook.backstage.nub;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.backstage.app.BackstageUnhandledExceptionHandler;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.nub.NubController.NubService;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.init.AppInitLock.Listener;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: request_nux_banner_dismiss_count */
public class BackstageService extends Service implements NubService {
    public static final String f5393e = BackstageService.class.getSimpleName();
    @Inject
    FloatingWindowManager f5394a;
    @Inject
    AppInitLock f5395b;
    @Inject
    BackstageTrayNotificationManager f5396c;
    @Inject
    NubController f5397d;
    private final C05661 f5398f = new C05661(this);
    private BackstageUnhandledExceptionHandler f5399g;
    private BackstageSystemIntentReceiver f5400h;
    private Listener f5401i;

    /* compiled from: request_nux_banner_dismiss_count */
    public class C05661 {
        final /* synthetic */ BackstageService f5391a;

        C05661(BackstageService backstageService) {
            this.f5391a = backstageService;
        }

        public final void m5624a(BackstageEventListener$EventType backstageEventListener$EventType) {
            boolean inKeyguardRestrictedInputMode = ((KeyguardManager) this.f5391a.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
            if (inKeyguardRestrictedInputMode) {
                this.f5391a.f5396c.m5633a(this.f5391a);
            } else {
                this.f5391a.f5396c.m5634b(this.f5391a);
            }
            String str = BackstageService.f5393e;
            new StringBuilder("Service : ").append(backstageEventListener$EventType.name());
            this.f5391a.f5394a.m5646a(backstageEventListener$EventType, inKeyguardRestrictedInputMode);
        }
    }

    /* compiled from: request_nux_banner_dismiss_count */
    class C05672 extends Listener {
        final /* synthetic */ BackstageService f5392a;

        C05672(BackstageService backstageService) {
            this.f5392a = backstageService;
        }

        public final void m5625a() {
            BackstageService.m5632c(this.f5392a);
        }
    }

    private static <T extends Context> void m5629a(Class<T> cls, T t) {
        m5630a((Object) t, (Context) t);
    }

    public static void m5630a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BackstageService) obj).m5628a(new FloatingWindowManager((Context) fbInjector.getInstance(Context.class), WindowManagerMethodAutoProvider.b(fbInjector), ScreenUtil.m4547a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), RuntimePermissionsUtil.b(fbInjector)), AppInitLock.a(fbInjector), new BackstageTrayNotificationManager((Context) fbInjector.getInstance(Context.class), ResourcesMethodAutoProvider.a(fbInjector)), NubController.m5673a(fbInjector));
    }

    private void m5628a(FloatingWindowManager floatingWindowManager, AppInitLock appInitLock, BackstageTrayNotificationManager backstageTrayNotificationManager, NubController nubController) {
        this.f5394a = floatingWindowManager;
        this.f5395b = appInitLock;
        this.f5396c = backstageTrayNotificationManager;
        this.f5397d = nubController;
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -985681443);
        super.onCreate();
        Class cls = BackstageService.class;
        m5630a((Object) this, (Context) this);
        if (this.f5395b.c()) {
            m5632c(this);
        } else {
            m5631b();
        }
        LogUtils.d(1265462141, a);
    }

    public void onDestroy() {
        Object obj;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 650726237);
        if (this.f5394a != null) {
            FloatingWindowManager.m5645d(this.f5394a);
        }
        if (this.f5400h != null) {
            unregisterReceiver(this.f5400h.f5405c);
        }
        if (this.f5399g != null) {
            UncaughtExceptionHandler uncaughtExceptionHandler = this.f5399g;
            if (uncaughtExceptionHandler.f4304b != uncaughtExceptionHandler) {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler.f4304b);
            } else {
                Thread.setDefaultUncaughtExceptionHandler(null);
                BLog.b(BackstageUnhandledExceptionHandler.f4303a, "Default handler is lost. Unable to destroy correctly.");
            }
            uncaughtExceptionHandler.f4304b = null;
            uncaughtExceptionHandler.f4305c = null;
        }
        if (this.f5396c != null) {
            this.f5396c.m5634b(this);
        }
        if (this == this.f5397d.f5452a.get()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f5397d.f5452a = new WeakReference(null);
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 196686396, a);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void m5631b() {
        if (this.f5401i == null) {
            this.f5401i = new C05672(this);
            this.f5395b.a(this.f5401i);
        }
    }

    public static void m5632c(BackstageService backstageService) {
        backstageService.f5396c.m5633a(backstageService);
        backstageService.f5400h = new BackstageSystemIntentReceiver(backstageService.f5398f);
        backstageService.f5399g = new BackstageUnhandledExceptionHandler(backstageService.f5398f);
        BackstageSystemIntentReceiver backstageSystemIntentReceiver = backstageService.f5400h;
        backstageService.registerReceiver(backstageSystemIntentReceiver.f5405c, backstageSystemIntentReceiver.f5406d);
        backstageService.f5397d.f5452a = new WeakReference(backstageService);
        FloatingWindowManager floatingWindowManager = backstageService.f5394a;
        floatingWindowManager.m5646a(BackstageEventListener$EventType.SERVICE_STARTED, ((KeyguardManager) floatingWindowManager.f5424f.getSystemService("keyguard")).inKeyguardRestrictedInputMode());
    }
}
