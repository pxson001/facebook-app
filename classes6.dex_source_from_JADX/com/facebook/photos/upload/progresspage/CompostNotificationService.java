package com.facebook.photos.upload.progresspage;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.facebook.base.service.FbBackgroundService;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: getViewport */
public class CompostNotificationService extends FbBackgroundService {
    @Inject
    CompostNotificationManager f13863b;
    @Inject
    QeAccessor f13864c;
    @Inject
    @ForUiThread
    ScheduledExecutorService f13865d;
    @Inject
    SecureContextHelper f13866e;
    @Inject
    WindowManager f13867f;
    public Snackbar f13868g;
    public Object f13869h;

    /* compiled from: getViewport */
    class C08982 implements OnClickListener {
        final /* synthetic */ CompostNotificationService f13861a;

        C08982(CompostNotificationService compostNotificationService) {
            this.f13861a = compostNotificationService;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 132396518);
            Intent intent = new Intent(this.f13861a, CompostActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("source", CompostSourceType.SNACKBAR);
            this.f13861a.f13866e.a(intent, this.f13861a);
            Logger.a(2, EntryType.UI_INPUT_END, -1382476867, a);
        }
    }

    /* compiled from: getViewport */
    class C08993 implements Runnable {
        final /* synthetic */ CompostNotificationService f13862a;

        C08993(CompostNotificationService compostNotificationService) {
            this.f13862a = compostNotificationService;
        }

        public void run() {
            this.f13862a.f13863b.m21627a();
            this.f13862a.f13869h = null;
            if (CompostNotificationService.m21639q(this.f13862a)) {
                this.f13862a.stopSelf();
            }
        }
    }

    private static <T extends Context> void m21632a(Class<T> cls, T t) {
        m21633a((Object) t, (Context) t);
    }

    public static void m21633a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CompostNotificationService) obj).m21631a(CompostNotificationManager.m21626b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), WindowManagerMethodAutoProvider.b(fbInjector));
    }

    private void m21631a(CompostNotificationManager compostNotificationManager, QeAccessor qeAccessor, ScheduledExecutorService scheduledExecutorService, SecureContextHelper secureContextHelper, WindowManager windowManager) {
        this.f13863b = compostNotificationManager;
        this.f13864c = qeAccessor;
        this.f13865d = scheduledExecutorService;
        this.f13866e = secureContextHelper;
        this.f13867f = windowManager;
    }

    protected final Looper m21641c() {
        return null;
    }

    protected final void m21642d() {
        Class cls = CompostNotificationService.class;
        m21633a((Object) this, (Context) this);
        setTheme(2131624474);
    }

    protected final void m21640a(Intent intent) {
        if (m21635m()) {
            m21636n();
        }
        if (m21637o()) {
            m21638p();
        }
    }

    private boolean m21635m() {
        return this.f13868g == null && checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0 && this.f13864c.a(ExperimentsForCompostAbTestModule.f8090i, false);
    }

    private void m21636n() {
        final View coordinatorLayout = new CoordinatorLayout(this);
        LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, 2003, 8, -2);
        layoutParams.gravity = 80;
        this.f13867f.addView(coordinatorLayout, layoutParams);
        Snackbar a = Snackbar.m10173a(coordinatorLayout, this.f13864c.a(ExperimentsForCompostAbTestModule.f8092k, 2131236108, getResources()), 0).m10179a(this.f13864c.a(ExperimentsForCompostAbTestModule.f8091j, 2131236109, getResources()), new C08982(this));
        a.f7079f = new Callback(this) {
            final /* synthetic */ CompostNotificationService f13860b;

            public final void mo1143a(Snackbar snackbar, int i) {
                super.mo1143a(snackbar, i);
                if (coordinatorLayout.getWindowToken() != null) {
                    this.f13860b.f13867f.removeView(coordinatorLayout);
                }
                this.f13860b.f13868g = null;
                if (CompostNotificationService.m21639q(this.f13860b)) {
                    this.f13860b.stopSelf();
                }
            }
        };
        this.f13868g = a;
        this.f13868g.m10180b();
    }

    private boolean m21637o() {
        return this.f13869h == null && this.f13864c.a(ExperimentsForCompostAbTestModule.f8089h, false);
    }

    private void m21638p() {
        this.f13869h = this.f13865d.schedule(new C08993(this), this.f13864c.a(ExperimentsForCompostAbTestModule.f8087f, TimeUnit.HOURS.toMinutes(4)), TimeUnit.MINUTES);
    }

    public static boolean m21639q(CompostNotificationService compostNotificationService) {
        return compostNotificationService.f13868g == null && compostNotificationService.f13869h == null;
    }
}
