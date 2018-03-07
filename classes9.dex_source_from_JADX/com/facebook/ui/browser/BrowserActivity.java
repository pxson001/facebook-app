package com.facebook.ui.browser;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.apptab.state.TabTag;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.FragmentBaseActivity;
import com.facebook.common.activitycleaner.ActivityStackManager;
import com.facebook.common.activitycleaner.ActivityStackManager.OnApplicationEnteredListener;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.feed.NewsFeedIntentUriBuilder;
import com.facebook.feed.data.FeedDataLoaderInitializer;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.intent.internal.InternalIntentSigner;
import com.facebook.katana.intent.Fb4aInternalIntentSigner;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.richdocument.logging.RichDocumentSessionTracker;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.browser.event.BrowserEventBus;
import com.facebook.ui.browser.event.BrowserEvents.BrowserActivityOnActivityCreateEvent;
import com.facebook.ui.browser.event.BrowserEvents.BrowserActivityOnPauseEvent;
import com.facebook.ui.browser.gating.IsLogBrowserOpenTimesEnabled;
import com.facebook.ui.browser.gating.IsNativeCrashLastFlagEnabled;
import com.facebook.ui.browser.logging.BrowserLoggingConstants;
import com.facebook.ui.browser.logging.BrowserSequences;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@Deprecated
/* compiled from: topics_bootstrapped */
public class BrowserActivity extends FbFragmentActivity implements AnalyticsActivityWithExtraData, IAuthNotRequired {
    public static final Class<?> f1476G = BrowserActivity.class;
    private static int f1477H = 0;
    @Inject
    @IsLogBrowserOpenTimesEnabled
    Provider<TriState> f1478A;
    @Inject
    MoreFileUtils f1479B;
    @Inject
    AbstractFbErrorReporter f1480C;
    @Inject
    BrowserEventBus f1481D;
    @Inject
    RichDocumentSessionTracker f1482E;
    @Inject
    TopicFeedsTestUtil f1483F;
    @Inject
    ActivityStackManager f1484p;
    @Inject
    @FragmentBaseActivity
    Provider<ComponentName> f1485q;
    @Inject
    SecureContextHelper f1486r;
    @Inject
    InternalIntentSigner f1487s;
    @Inject
    FeedDataLoaderInitializer f1488t;
    @Inject
    NewsFeedIntentUriBuilder f1489u;
    @Inject
    SequenceLogger f1490v;
    @Inject
    InteractionTTILogger f1491w;
    @Inject
    MonotonicClock f1492x;
    @BackgroundExecutorService
    @Inject
    ExecutorService f1493y;
    @Inject
    @IsNativeCrashLastFlagEnabled
    Provider<TriState> f1494z;

    /* compiled from: topics_bootstrapped */
    class C01471 implements OnApplicationEnteredListener {
        final /* synthetic */ BrowserActivity f1470a;

        C01471(BrowserActivity browserActivity) {
            this.f1470a = browserActivity;
        }

        public final void m1558a() {
            this.f1470a.m1571i();
        }
    }

    /* compiled from: topics_bootstrapped */
    class C01493 implements Runnable {
        final /* synthetic */ BrowserActivity f1473a;

        C01493(BrowserActivity browserActivity) {
            this.f1473a = browserActivity;
        }

        public void run() {
            synchronized (BrowserActivity.class) {
                try {
                    File m = BrowserActivity.m1568m(this.f1473a);
                    if (m.exists()) {
                        m.delete();
                    }
                } catch (Exception e) {
                    this.f1473a.f1480C.a(SoftError.a(BrowserActivity.f1476G + ".removeFromLastActivity()", "Fail to remove the file").a(e.getCause()).g());
                }
            }
        }
    }

    private static <T extends Context> void m1561a(Class<T> cls, T t) {
        m1562a((Object) t, (Context) t);
    }

    public static void m1562a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BrowserActivity) obj).m1560a(ActivityStackManager.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 11), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (InternalIntentSigner) Fb4aInternalIntentSigner.a(fbInjector), FeedDataLoaderInitializer.a(fbInjector), NewsFeedIntentUriBuilder.a(fbInjector), (SequenceLogger) SequenceLoggerImpl.a(fbInjector), InteractionTTILogger.a(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 789), IdBasedProvider.a(fbInjector, 788), MoreFileUtils.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), BrowserEventBus.m1600a(fbInjector), RichDocumentSessionTracker.a(fbInjector), TopicFeedsTestUtil.a(fbInjector));
    }

    public final void m1569b(@Nullable Bundle bundle) {
        super.b(bundle);
        long uptimeMillis = SystemClock.uptimeMillis();
        Class cls = BrowserActivity.class;
        m1562a((Object) this, (Context) this);
        this.f1482E.a(this);
        Sequence e = this.f1490v.e(BrowserSequences.f1605a);
        if (e != null) {
            SequenceLoggerDetour.a(e, "browser_activity_starts", 1480857896);
        }
        overridePendingTransition(2130968739, 2130968614);
        if (e != null) {
            SequenceLoggerDetour.b(e, "browser_activity_starts", -1428110779);
        }
        this.f1484p.k = new C01471(this);
        int i = f1477H + 1;
        f1477H = i;
        m1563b(i);
        this.f1491w.a(f1476G.getSimpleName(), uptimeMillis);
        this.f1481D.a(new BrowserActivityOnActivityCreateEvent());
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 2044521759);
        this.f1491w.c(f1476G.getSimpleName());
        super.onStart();
        this.f1491w.d(f1476G.getSimpleName());
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 25088074, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1736162968);
        this.f1491w.e(f1476G.getSimpleName());
        super.onResume();
        this.f1491w.f(f1476G.getSimpleName());
        this.f1491w.b("LoadWebView");
        m1564b(BrowserActivity.class.toString());
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 477808720, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1372852190);
        this.f1491w.a();
        super.onPause();
        this.f1481D.a(new BrowserActivityOnPauseEvent());
        m1567l();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1422132230, a);
    }

    public final void m1571i() {
        long d = this.f1484p.d();
        if (d != 0 && this.f1483F.j() && this.f1492x.now() - d >= this.f1483F.k() * 60000) {
            m1566k();
        }
    }

    private void m1566k() {
        Parcelable a = this.f1489u.a(this, FBLinks.bT);
        if (a == null) {
            BLog.a(f1476G, "Could not get intent for feed uir from BrowserActivity.");
            return;
        }
        String name = TabTag.Feed.name();
        a.putExtra("target_tab_name", name);
        a.putExtra("jump_to_top", true);
        Intent intent = new Intent();
        intent.putExtra("tabbar_target_intent", a);
        intent.putExtra("extra_launch_uri", this.f1484p.m);
        intent.putExtra("POP_TO_ROOT", true);
        intent.setComponent((ComponentName) this.f1485q.get());
        this.f1487s.a(intent);
        this.f1486r.a(intent, this);
        if (name.equals(TabTag.Feed.name())) {
            this.f1488t.b();
        }
        this.f1491w.a();
        finish();
    }

    public final String am_() {
        return "webview";
    }

    public final Map<String, Object> m1570c() {
        return BrowserLoggingConstants.m1629a(getIntent().getDataString());
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968724, 2130968740);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 663630806);
        super.onDestroy();
        if (this.f1484p != null) {
            this.f1484p.k = null;
        }
        if (this.f1482E != null) {
            this.f1482E.b(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 741821845, a);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(2130968750, 2130968614);
    }

    private void m1564b(final String str) {
        if (((TriState) this.f1494z.get()).asBoolean(false)) {
            ExecutorDetour.a(this.f1493y, new Runnable(this) {
                final /* synthetic */ BrowserActivity f1472b;

                public void run() {
                    synchronized (BrowserActivity.class) {
                        try {
                            MoreFileUtils.a(str, BrowserActivity.m1568m(this.f1472b));
                        } catch (Exception e) {
                            this.f1472b.f1480C.a(SoftError.a(BrowserActivity.f1476G + ".logLastActivity()", "Fail to write to file").a(e.getCause()).g());
                        }
                    }
                }
            }, -187749147);
        }
    }

    private void m1567l() {
        if (((TriState) this.f1494z.get()).asBoolean(false)) {
            ExecutorDetour.a(this.f1493y, new C01493(this), 530924785);
        }
    }

    public static File m1568m(BrowserActivity browserActivity) {
        return new File(browserActivity.getApplicationContext().getFilesDir(), "last_activity_opened");
    }

    private void m1563b(final int i) {
        if (((TriState) this.f1478A.get()).asBoolean(false)) {
            ExecutorDetour.a(this.f1493y, new Runnable(this) {
                final /* synthetic */ BrowserActivity f1475b;

                public void run() {
                    synchronized (BrowserActivity.class) {
                        try {
                            MoreFileUtils.a(Integer.toString(i), new File(this.f1475b.getApplicationContext().getFilesDir(), "iab_open_times"));
                        } catch (Exception e) {
                            this.f1475b.f1480C.a(SoftError.a(BrowserActivity.f1476G + ".logBrowserOpenTimes()", "Fail to write to file").a(e.getCause()).g());
                        }
                    }
                }
            }, 1195140599);
        }
    }

    private void m1560a(ActivityStackManager activityStackManager, Provider<ComponentName> provider, SecureContextHelper secureContextHelper, InternalIntentSigner internalIntentSigner, FeedDataLoaderInitializer feedDataLoaderInitializer, NewsFeedIntentUriBuilder newsFeedIntentUriBuilder, SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger, MonotonicClock monotonicClock, ExecutorService executorService, Provider<TriState> provider2, Provider<TriState> provider3, MoreFileUtils moreFileUtils, FbErrorReporter fbErrorReporter, BrowserEventBus browserEventBus, RichDocumentSessionTracker richDocumentSessionTracker, TopicFeedsTestUtil topicFeedsTestUtil) {
        this.f1484p = activityStackManager;
        this.f1485q = provider;
        this.f1486r = secureContextHelper;
        this.f1487s = internalIntentSigner;
        this.f1488t = feedDataLoaderInitializer;
        this.f1489u = newsFeedIntentUriBuilder;
        this.f1490v = sequenceLogger;
        this.f1491w = interactionTTILogger;
        this.f1492x = monotonicClock;
        this.f1493y = executorService;
        this.f1494z = provider2;
        this.f1478A = provider3;
        this.f1479B = moreFileUtils;
        this.f1480C = fbErrorReporter;
        this.f1481D = browserEventBus;
        this.f1482E = richDocumentSessionTracker;
        this.f1483F = topicFeedsTestUtil;
    }
}
