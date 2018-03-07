package com.facebook.resources.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.resources.impl.loading.GetLanguagePackInfoMethod.NoLanguagePackInfoException;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fresh_feed_new_story_pill_shown */
public class WaitingForStringsActivity extends Activity implements PropertyBag, IFbResourcesNotRequired {
    public static final Class<?> f23226a = WaitingForStringsActivity.class;
    public StringResourcesDelegate f23227b;
    public View f23228c;
    public View f23229d;
    private ScheduledExecutorService f23230e;
    public FbResourcesLogger f23231f;
    private SecureContextHelper f23232g;
    public Provider<Boolean> f23233h;
    public Provider<Toaster> f23234i;
    private NetworkMonitor f23235j;
    private SelfRegistrableReceiverImpl f23236k;
    public View f23237l;
    public View f23238m;
    private View f23239n;
    private Intent f23240o;
    public boolean f23241p = false;
    public boolean f23242q = false;
    private final OnClickListener f23243r = new C09363(this);

    /* compiled from: fresh_feed_new_story_pill_shown */
    class C09363 implements OnClickListener {
        final /* synthetic */ WaitingForStringsActivity f23264a;

        C09363(WaitingForStringsActivity waitingForStringsActivity) {
            this.f23264a = waitingForStringsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2083976698);
            ((AnalyticsLogger) this.f23264a.f23231f.f1433b.get()).mo529a("fbresources_use_english");
            this.f23264a.f23227b.m2583g();
            this.f23264a.m31335c();
            Logger.a(2, EntryType.UI_INPUT_END, 1087424400, a);
        }
    }

    /* compiled from: fresh_feed_new_story_pill_shown */
    class C09371 implements OnClickListener {
        final /* synthetic */ WaitingForStringsActivity f23276a;

        C09371(WaitingForStringsActivity waitingForStringsActivity) {
            this.f23276a = waitingForStringsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1050234738);
            this.f23276a.f23242q = true;
            WaitingForStringsActivity.m31328a(this.f23276a, true);
            Logger.a(2, EntryType.UI_INPUT_END, 1380996950, a);
        }
    }

    /* compiled from: fresh_feed_new_story_pill_shown */
    class C09384 implements FutureCallback<Void> {
        final /* synthetic */ WaitingForStringsActivity f23277a;

        C09384(WaitingForStringsActivity waitingForStringsActivity) {
            this.f23277a = waitingForStringsActivity;
        }

        public void onSuccess(Object obj) {
            ((AnalyticsLogger) this.f23277a.f23231f.f1433b.get()).mo529a("fbresources_waiting_complete");
            this.f23277a.m31335c();
        }

        public void onFailure(Throwable th) {
            this.f23277a.f23241p = true;
            this.f23277a.f23229d.setVisibility(8);
            this.f23277a.f23228c.setVisibility(0);
            this.f23277a.f23231f.m2760i();
            boolean z = th instanceof NoLanguagePackInfoException;
            if (this.f23277a.f23242q || z) {
                this.f23277a.f23237l.setVisibility(0);
                this.f23277a.f23238m.setVisibility(8);
            } else {
                this.f23277a.f23237l.setVisibility(8);
                this.f23277a.f23238m.setVisibility(0);
            }
            if (((Boolean) this.f23277a.f23233h.get()).booleanValue()) {
                String str = "Could not fetch strings from server: ";
                ((Toaster) this.f23277a.f23234i.get()).m6456b(new ToastBuilder("Internal build only: " + str + th));
                BLog.b(WaitingForStringsActivity.f23226a, str, th);
            }
        }
    }

    /* compiled from: fresh_feed_new_story_pill_shown */
    class C09392 implements Runnable {
        final /* synthetic */ WaitingForStringsActivity f23278a;

        C09392(WaitingForStringsActivity waitingForStringsActivity) {
            this.f23278a = waitingForStringsActivity;
        }

        public void run() {
            WaitingForStringsActivity.m31328a(this.f23278a, false);
        }
    }

    private static <T extends Context> void m31329a(Class<T> cls, T t) {
        m31330a((Object) t, (Context) t);
    }

    public static void m31330a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((WaitingForStringsActivity) obj).m31327a(StringResourcesDelegate.m2562a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), FbResourcesLogger.m2736a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 3922), IdBasedProvider.m1811a(injectorLike, 3588), NetworkMonitor.m13133a(injectorLike));
    }

    protected void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 419550185);
        super.onCreate(bundle);
        Class cls = WaitingForStringsActivity.class;
        m31330a((Object) this, (Context) this);
        Intent intent = getIntent();
        if (intent != null) {
            this.f23240o = (Intent) intent.getParcelableExtra("return_intent");
        }
        setContentView(2130907761);
        this.f23228c = findViewById(2131568499);
        this.f23229d = findViewById(2131568497);
        Locale b = this.f23227b.m2578b();
        String displayName = b.getDisplayName(b);
        Resources resources = getResources();
        ((FbTextView) findViewById(2131568498)).setText(resources.getString(2131242549, new Object[]{displayName}));
        ((FbTextView) findViewById(2131568500)).setText(resources.getString(2131242550, new Object[]{displayName}));
        this.f23237l = findViewById(2131568501);
        this.f23237l.setOnClickListener(this.f23243r);
        this.f23238m = findViewById(2131568502);
        this.f23238m.setOnClickListener(this.f23243r);
        this.f23239n = findViewById(2131563533);
        this.f23239n.setOnClickListener(new C09371(this));
        m31333b();
        this.f23236k = this.f23235j.m13136a(State.CONNECTED, new C09392(this));
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 684514215, a);
    }

    @Inject
    private void m31327a(StringResourcesDelegate stringResourcesDelegate, ScheduledExecutorService scheduledExecutorService, FbResourcesLogger fbResourcesLogger, SecureContextHelper secureContextHelper, Provider<Boolean> provider, Provider<Toaster> provider2, NetworkMonitor networkMonitor) {
        this.f23227b = stringResourcesDelegate;
        this.f23230e = scheduledExecutorService;
        this.f23231f = fbResourcesLogger;
        this.f23232g = secureContextHelper;
        this.f23233h = provider;
        this.f23234i = provider2;
        this.f23235j = networkMonitor;
    }

    public static void m31328a(WaitingForStringsActivity waitingForStringsActivity, boolean z) {
        if (waitingForStringsActivity.f23241p) {
            waitingForStringsActivity.f23241p = false;
            if (z) {
                ((AnalyticsLogger) waitingForStringsActivity.f23231f.f1433b.get()).mo529a("fbresources_loading_retry");
            } else {
                ((AnalyticsLogger) waitingForStringsActivity.f23231f.f1433b.get()).mo529a("fbresources_auto_retry_loading");
            }
            waitingForStringsActivity.f23231f.m2758g();
            waitingForStringsActivity.f23227b.m2577a();
            waitingForStringsActivity.m31333b();
        }
    }

    private void m31333b() {
        this.f23229d.setVisibility(0);
        this.f23228c.setVisibility(8);
        ListenableFuture c = this.f23227b.m2580c();
        if (c == null) {
            c = Futures.m2452a(null);
        }
        Futures.m2458a(c, new C09384(this), this.f23230e);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1438699131);
        super.onResume();
        this.f23231f.m2758g();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1027977519, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1048544792);
        super.onPause();
        this.f23231f.m2759h();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1221919407, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1786952949);
        super.onDestroy();
        if (this.f23236k != null) {
            this.f23236k.m3297c();
            this.f23236k = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1511055100, a);
    }

    public final void mo822a(Object obj, @Nullable Object obj2) {
    }

    public final Object mo818a(Object obj) {
        return null;
    }

    public void onBackPressed() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        this.f23232g.mo665b(intent, this);
    }

    private void m31335c() {
        if (this.f23240o != null) {
            Intent intent = new Intent(this.f23240o);
            intent.setFlags(intent.getFlags() & -268435457);
            this.f23232g.mo662a(intent, this);
        }
        finish();
    }
}
