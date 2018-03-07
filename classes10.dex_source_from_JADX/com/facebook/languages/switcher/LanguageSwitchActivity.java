package com.facebook.languages.switcher;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;

/* compiled from: timeline_filter */
public class LanguageSwitchActivity extends Activity {
    public static final String f1365e = LanguageSwitchActivity.class.getSimpleName();
    @Inject
    @ForUiThread
    public ScheduledExecutorService f1366a;
    @Inject
    public AbstractFbErrorReporter f1367b;
    @Inject
    public LanguageSwitcher f1368c;
    @Inject
    public Locales f1369d;
    private final Handler f1370f = new Handler();

    /* compiled from: timeline_filter */
    class C02311 implements FutureCallback {
        final /* synthetic */ LanguageSwitchActivity f1364a;

        C02311(LanguageSwitchActivity languageSwitchActivity) {
            this.f1364a = languageSwitchActivity;
        }

        public void onSuccess(Object obj) {
            LanguageSwitchActivity.m1379b(this.f1364a);
        }

        public void onFailure(Throwable th) {
            this.f1364a.f1367b.a(LanguageSwitchActivity.f1365e, "Failed clearing locale caches");
            LanguageSwitchActivity.m1379b(this.f1364a);
        }
    }

    /* compiled from: timeline_filter */
    class RestartRunnable implements Runnable {
        public void run() {
            System.exit(0);
        }
    }

    private static <T extends Context> void m1377a(Class<T> cls, T t) {
        m1378a((Object) t, (Context) t);
    }

    public static void m1378a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        LanguageSwitchActivity languageSwitchActivity = (LanguageSwitchActivity) obj;
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        LanguageSwitcher a = LanguageSwitcher.a(fbInjector);
        Locales a2 = Locales.a(fbInjector);
        languageSwitchActivity.f1366a = scheduledExecutorService;
        languageSwitchActivity.f1367b = abstractFbErrorReporter;
        languageSwitchActivity.f1368c = a;
        languageSwitchActivity.f1369d = a2;
    }

    protected void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1045367508);
        super.onCreate(bundle);
        Class cls = LanguageSwitchActivity.class;
        m1378a((Object) this, (Context) this);
        setContentView(2130904998);
        Locale b = this.f1369d.b();
        String displayName = b.getDisplayName(b);
        FbTextView fbTextView = (FbTextView) findViewById(2131563344);
        fbTextView.setText(getResources().getString(2131240205, new Object[]{displayName}));
        Futures.a(this.f1368c.o, new C02311(this), this.f1366a);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1203187844, a);
    }

    public static void m1379b(LanguageSwitchActivity languageSwitchActivity) {
        HandlerDetour.b(languageSwitchActivity.f1370f, new RestartRunnable(), 5000, -1745253145);
    }
}
