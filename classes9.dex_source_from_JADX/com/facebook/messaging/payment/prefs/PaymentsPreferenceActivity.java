package com.facebook.messaging.payment.prefs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.BugReportCategory;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor.ConnectionType;
import com.facebook.messaging.connectivity.ConnectionStatusMonitorMethodAutoProvider;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_event_creation_params */
public class PaymentsPreferenceActivity extends FbPreferenceActivity {
    public static final Class<?> f13812i = PaymentsPreferenceActivity.class;
    @Inject
    AppCompatActivityOverrider f13813a;
    @Inject
    @LocalBroadcast
    public LocalFbBroadcastManager f13814b;
    @Inject
    ConnectionStatusMonitor f13815c;
    @Inject
    AnalyticsLogger f13816d;
    @Inject
    public SecureContextHelper f13817e;
    @Inject
    public BugReportOperationLogger f13818f;
    @Inject
    Clock f13819g;
    @Inject
    @ForUiThread
    Executor f13820h;
    public LinearLayout f13821j;
    public LinearLayout f13822k;
    public ProgressBar f13823l;
    public PaymentAccountEnabledStatusPayPreferences f13824m;
    public MessengerPayPreferences f13825n;
    public MessengerPayPreferences f13826o;
    public MessengerPayPreferences f13827p;
    public MessengerPayPreferences f13828q;
    public MessengerPayPreferences f13829r;
    public MessengerPayPreferences f13830s;
    public MessengerPayPreferences f13831t;
    public Set<MessengerPayPreferences> f13832u;
    public SelfRegistrableReceiverImpl f13833v;
    public PreferenceScreen f13834w;
    private ListenableFuture<List<Object>> f13835x;
    public boolean f13836y;
    public final C15621 f13837z = new C15621(this);

    /* compiled from: group_event_creation_params */
    public class C15621 {
        public final /* synthetic */ PaymentsPreferenceActivity f13807a;

        C15621(PaymentsPreferenceActivity paymentsPreferenceActivity) {
            this.f13807a = paymentsPreferenceActivity;
        }

        public final void m14374a(PreferenceCategory preferenceCategory) {
            PaymentsPreferenceActivity paymentsPreferenceActivity = this.f13807a;
            paymentsPreferenceActivity.f13834w.addPreference(preferenceCategory);
            if (paymentsPreferenceActivity.f13834w.getPreferenceCount() == 8) {
                PaymentsPreferenceActivity.m14384i(paymentsPreferenceActivity);
            }
        }

        public final void m14375b(PreferenceCategory preferenceCategory) {
            this.f13807a.f13834w.removePreference(preferenceCategory);
        }

        public final void m14372a() {
            PaymentsPreferenceActivity.m14384i(this.f13807a);
        }

        public final void m14373a(Preference preference) {
            this.f13807a.f13818f.a("Click on preference: " + preference.getTitle(), BugReportCategory.SETTINGS_TAB);
        }
    }

    /* compiled from: group_event_creation_params */
    public class C15632 {
        final /* synthetic */ PaymentsPreferenceActivity f13808a;

        public C15632(PaymentsPreferenceActivity paymentsPreferenceActivity) {
            this.f13808a = paymentsPreferenceActivity;
        }

        public final void m14376a(boolean z) {
            for (MessengerPayPreferences a : this.f13808a.f13832u) {
                a.mo540a(z);
            }
        }
    }

    /* compiled from: group_event_creation_params */
    public class C15643 implements ActionReceiver {
        final /* synthetic */ PaymentsPreferenceActivity f13809a;

        public C15643(PaymentsPreferenceActivity paymentsPreferenceActivity) {
            this.f13809a = paymentsPreferenceActivity;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1293337330);
            if (!this.f13809a.f13815c.b(ConnectionType.HTTP) && this.f13809a.f13815c.a(ConnectionType.HTTP)) {
                PaymentsPreferenceActivity.m14384i(this.f13809a);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 800806506, a);
        }
    }

    public static void m14380a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PaymentsPreferenceActivity) obj).m14379a(AppCompatActivityOverrider.b(fbInjector), LocalFbBroadcastManager.a(fbInjector), ConnectionStatusMonitorMethodAutoProvider.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), BugReportOperationLogger.a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    private void m14379a(AppCompatActivityOverrider appCompatActivityOverrider, LocalFbBroadcastManager localFbBroadcastManager, ConnectionStatusMonitor connectionStatusMonitor, AnalyticsLogger analyticsLogger, SecureContextHelper secureContextHelper, BugReportOperationLogger bugReportOperationLogger, Clock clock, Executor executor) {
        this.f13813a = appCompatActivityOverrider;
        this.f13814b = localFbBroadcastManager;
        this.f13815c = connectionStatusMonitor;
        this.f13816d = analyticsLogger;
        this.f13817e = secureContextHelper;
        this.f13818f = bugReportOperationLogger;
        this.f13819g = clock;
        this.f13820h = executor;
    }

    protected final void m14385a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = PaymentsPreferenceActivity.class;
        m14380a(this, this);
        a(this.f13813a);
    }

    protected final void m14386c(Bundle bundle) {
        super.c(bundle);
        setContentView(2130906160);
        this.f13816d.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_initiate_settings"));
        this.f13821j = (LinearLayout) a(2131565826);
        this.f13822k = (LinearLayout) a(2131563269);
        this.f13823l = (ProgressBar) a(2131565816);
        this.f13822k.setVisibility(8);
        super.onContentChanged();
        this.f13834w = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(this.f13834w);
        this.f13833v = this.f13814b.a().a("com.facebook.orca.CONNECTIVITY_CHANGED", new C15643(this)).a();
        this.f13832u = new HashSet();
        this.f13824m = (PaymentAccountEnabledStatusPayPreferences) c().a("IS_PAYMENT_ENABLED_PREFERENCES");
        if (this.f13824m == null) {
            this.f13824m = new PaymentAccountEnabledStatusPayPreferences();
            c().a().a(this.f13824m, "IS_PAYMENT_ENABLED_PREFERENCES").b();
        }
        this.f13824m.mo539a(this.f13837z);
        this.f13824m.f13778f = new C15632(this);
        this.f13832u.add(this.f13824m);
        this.f13825n = (MessengerPayPreferences) c().a("PAYMENT_METHODS_MESSENGER_PAY_PREFERENCES");
        if (this.f13825n == null) {
            this.f13825n = new PaymentMethodsMessengerPayPreferences();
            c().a().a((FbFragment) this.f13825n, "PAYMENT_METHODS_MESSENGER_PAY_PREFERENCES").b();
        }
        this.f13825n.mo539a(this.f13837z);
        this.f13832u.add(this.f13825n);
        this.f13826o = (MessengerPayPreferences) c().a("INCOMING_REQUEST_HISTORY_MESSENGER_PAY_PREFERENCES");
        if (this.f13826o == null) {
            this.f13826o = RequestHistoryMessengerPayPreferences.m14403a(QueryType.INCOMING);
            c().a().a((FbFragment) this.f13826o, "INCOMING_REQUEST_HISTORY_MESSENGER_PAY_PREFERENCES").b();
        }
        this.f13826o.mo539a(this.f13837z);
        this.f13832u.add(this.f13826o);
        this.f13827p = (MessengerPayPreferences) c().a("OUTGOING_REQUEST_HISTORY_MESSENGER_PAY_PREFERENCES");
        if (this.f13827p == null) {
            this.f13827p = RequestHistoryMessengerPayPreferences.m14403a(QueryType.OUTGOING);
            c().a().a((FbFragment) this.f13827p, "OUTGOING_REQUEST_HISTORY_MESSENGER_PAY_PREFERENCES").b();
        }
        this.f13827p.mo539a(this.f13837z);
        this.f13832u.add(this.f13827p);
        this.f13828q = (MessengerPayPreferences) c().a("TRANSACTION_HISTORY_MESSENGER_PAY_PREFERENCES");
        if (this.f13828q == null) {
            this.f13828q = new TransactionHistoryMessengerPayPreferences();
            c().a().a((FbFragment) this.f13828q, "TRANSACTION_HISTORY_MESSENGER_PAY_PREFERENCES").b();
        }
        this.f13828q.mo539a(this.f13837z);
        this.f13832u.add(this.f13828q);
        this.f13829r = (MessengerPayPreferences) c().a("SECURITY_MESSENGER_PAY_PREFERENCES");
        if (this.f13829r == null) {
            this.f13829r = new SecurityMessengerPayPreferences();
            c().a().a((FbFragment) this.f13829r, "SECURITY_MESSENGER_PAY_PREFERENCES").b();
        }
        this.f13829r.mo539a(this.f13837z);
        this.f13832u.add(this.f13829r);
        this.f13830s = (MessengerPayPreferences) c().a("PROTECT_CONVERSATION_PAY_PREFERENCES");
        if (this.f13830s == null) {
            this.f13830s = new ProtectConversationsPayPreferences();
            c().a().a((FbFragment) this.f13830s, "PROTECT_CONVERSATION_PAY_PREFERENCES").b();
        }
        this.f13830s.mo539a(this.f13837z);
        this.f13832u.add(this.f13830s);
        this.f13831t = (MessengerPayPreferences) c().a("CUSTOMER_SUPPORT_MESSENGER_PAY_PREFERENCES");
        if (this.f13831t == null) {
            this.f13831t = new CustomerSupportMessengerPayPreferences();
            c().a().a((FbFragment) this.f13831t, "CUSTOMER_SUPPORT_MESSENGER_PAY_PREFERENCES").b();
        }
        this.f13831t.mo539a(this.f13837z);
        this.f13832u.add(this.f13831t);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 464491277);
        super.onResume();
        this.f13833v.b();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1343881355, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1254247759);
        super.onDestroy();
        if (this.f13835x != null) {
            this.f13835x.cancel(true);
            this.f13835x = null;
        }
        this.f13833v.c();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 532854780, a);
    }

    public void onBackPressed() {
        this.f13816d.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_cancel_settings"));
        super.onBackPressed();
    }

    public void onContentChanged() {
        if (findViewById(16908298) != null) {
            super.onContentChanged();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f13816d.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_cancel_settings"));
        finish();
        return true;
    }

    public static void m14381e(PaymentsPreferenceActivity paymentsPreferenceActivity) {
        paymentsPreferenceActivity.f13821j.setVisibility(8);
        paymentsPreferenceActivity.m14383h();
        paymentsPreferenceActivity.f13822k.setVisibility(0);
    }

    public static void m14382f(PaymentsPreferenceActivity paymentsPreferenceActivity) {
        paymentsPreferenceActivity.f13822k.setVisibility(8);
        paymentsPreferenceActivity.m14383h();
        paymentsPreferenceActivity.f13821j.setVisibility(0);
    }

    private void m14383h() {
        this.f13823l.setVisibility(8);
    }

    public static void m14384i(PaymentsPreferenceActivity paymentsPreferenceActivity) {
        if (paymentsPreferenceActivity.f13835x == null || paymentsPreferenceActivity.f13835x.isDone()) {
            paymentsPreferenceActivity.f13821j.setVisibility(8);
            paymentsPreferenceActivity.f13822k.setVisibility(8);
            paymentsPreferenceActivity.f13823l.setVisibility(0);
            final long a = paymentsPreferenceActivity.f13819g.a();
            paymentsPreferenceActivity.f13816d.a(P2pPaymentsLogEvent.d("p2p_settings_get_request", "p2p_settings").f(String.valueOf(a)).a);
            ListenableFuture b = paymentsPreferenceActivity.f13824m.mo541b();
            ListenableFuture b2 = paymentsPreferenceActivity.f13825n.mo541b();
            ListenableFuture b3 = paymentsPreferenceActivity.f13826o.mo541b();
            ListenableFuture b4 = paymentsPreferenceActivity.f13827p.mo541b();
            ListenableFuture b5 = paymentsPreferenceActivity.f13828q.mo541b();
            ListenableFuture b6 = paymentsPreferenceActivity.f13829r.mo541b();
            ListenableFuture b7 = paymentsPreferenceActivity.f13830s.mo541b();
            ListenableFuture b8 = paymentsPreferenceActivity.f13831t.mo541b();
            Builder builder = new Builder();
            builder.c(b);
            builder.c(b2);
            builder.c(b3);
            builder.c(b4);
            builder.c(b5);
            builder.c(b6);
            builder.c(b7);
            builder.c(b8);
            paymentsPreferenceActivity.f13835x = Futures.b(builder.b());
            Futures.a(paymentsPreferenceActivity.f13835x, new ResultFutureCallback<List<Object>>(paymentsPreferenceActivity) {
                final /* synthetic */ PaymentsPreferenceActivity f13811b;

                public final void m14378a(@Nullable Object obj) {
                    this.f13811b.f13816d.a(P2pPaymentsLogEvent.d("p2p_settings_get_request_success", "p2p_settings").f(String.valueOf(a)).a);
                    PaymentsPreferenceActivity.m14382f(this.f13811b);
                }

                public final void m14377a(ServiceException serviceException) {
                    this.f13811b.f13816d.a(P2pPaymentsLogEvent.d("p2p_settings_get_request_fail", "p2p_settings").f(String.valueOf(a)).a);
                    BLog.b(PaymentsPreferenceActivity.f13812i, "Fetch of payment preference data failed.");
                    this.f13811b.f13836y = false;
                    if (ErrorCodeUtil.a(serviceException) == ErrorCode.CONNECTION_FAILURE) {
                        PaymentsPreferenceActivity.m14381e(this.f13811b);
                    } else {
                        PaymentConnectivityDialogFactory.b(this.f13811b);
                    }
                }
            }, paymentsPreferenceActivity.f13820h);
        }
    }
}
