package com.facebook.messaging.payment.prefs.receipts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor.ConnectionType;
import com.facebook.messaging.connectivity.ConnectionStatusMonitorMethodAutoProvider;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent.Builder;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.connectivity.PaymentNoInternetFragment;
import com.facebook.messaging.payment.model.MessengerPayEntityType;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentType;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesSummaryFragment;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: graphql_video_incomplete_model */
public class PaymentReceiptActivity extends FbFragmentActivity implements ActionBarOwner {
    public static final Class<?> f13988p = PaymentReceiptActivity.class;
    public String f13989A;
    public MessengerPayEntityType f13990B;
    public ListenableFuture<?> f13991C;
    public Object f13992D;
    public boolean f13993E;
    public boolean f13994F;
    private AppCompatActivityOverrider f13995q;
    private AnalyticsLogger f13996r;
    public ConnectionStatusMonitor f13997s;
    public LocalFbBroadcastManager f13998t;
    private Executor f13999u;
    private PaymentProtocolUtil f14000v;
    public AbstractFbErrorReporter f14001w;
    public SelfRegistrableReceiverImpl f14002x;
    private ActionBarBasedFbTitleBar f14003y;
    public ProgressBar f14004z;

    /* compiled from: graphql_video_incomplete_model */
    public class C15891 implements ActionReceiver {
        final /* synthetic */ PaymentReceiptActivity f13985a;

        public C15891(PaymentReceiptActivity paymentReceiptActivity) {
            this.f13985a = paymentReceiptActivity;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1619266160);
            if (!this.f13985a.f13997s.b(ConnectionType.HTTP) && this.f13985a.f13997s.a(ConnectionType.HTTP)) {
                PaymentReceiptActivity.m14501a(this.f13985a, this.f13985a.f13990B, this.f13985a.f13989A);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 577492662, a);
        }
    }

    /* compiled from: graphql_video_incomplete_model */
    class C15902 implements FutureCallback<Object> {
        final /* synthetic */ PaymentReceiptActivity f13986a;

        C15902(PaymentReceiptActivity paymentReceiptActivity) {
            this.f13986a = paymentReceiptActivity;
        }

        public void onSuccess(Object obj) {
            PaymentReceiptActivity.m14507o(this.f13986a);
            this.f13986a.f13992D = obj;
            this.f13986a.f13993E = true;
            PaymentReceiptActivity.m14506k(this.f13986a);
        }

        public void onFailure(Throwable th) {
            PaymentReceiptActivity.m14507o(this.f13986a);
            this.f13986a.f13993E = false;
            this.f13986a.f14001w.a(PaymentReceiptActivity.f13988p.getName(), "Messenger pay entity failed to fetch");
            if (ErrorCodeUtil.a(th) == ErrorCode.CONNECTION_FAILURE) {
                PaymentReceiptActivity paymentReceiptActivity = this.f13986a;
                if (paymentReceiptActivity.f13994F) {
                    PaymentNoInternetFragment.a(2131560203, paymentReceiptActivity.kO_());
                    return;
                }
                return;
            }
            PaymentConnectivityDialogFactory.b(this.f13986a);
        }
    }

    /* compiled from: graphql_video_incomplete_model */
    public enum AnalyticsSource {
        HISTORY,
        SETTINGS,
        THREAD,
        URI;

        public final String toString() {
            return name().toLowerCase(Locale.US);
        }
    }

    public static void m14502a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentReceiptActivity) obj).m14500a(AppCompatActivityOverrider.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ConnectionStatusMonitorMethodAutoProvider.a(injectorLike), LocalFbBroadcastManager.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public static Intent m14497a(Context context, PaymentTransaction paymentTransaction, AnalyticsSource analyticsSource) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(paymentTransaction);
        Intent intent = new Intent(context, PaymentReceiptActivity.class);
        FlatBufferModelHelper.a(intent, "messenger_pay_entity", paymentTransaction);
        intent.putExtra("messenger_pay_entity_type", MessengerPayEntityType.PAYMENT_TRANSACTION);
        intent.putExtra("analytics_source", analyticsSource);
        return intent;
    }

    public static Intent m14498a(Context context, PaymentRequestModel paymentRequestModel, AnalyticsSource analyticsSource) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(paymentRequestModel);
        Intent intent = new Intent(context, PaymentReceiptActivity.class);
        FlatBufferModelHelper.a(intent, "messenger_pay_entity", paymentRequestModel);
        intent.putExtra("messenger_pay_entity_type", MessengerPayEntityType.PAYMENT_REQUEST);
        intent.putExtra("analytics_source", analyticsSource);
        return intent;
    }

    public static Intent m14499a(Context context, String str, AnalyticsSource analyticsSource) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Intent intent = new Intent(context, PaymentReceiptActivity.class);
        intent.putExtra("messenger_pay_entity_id", str);
        intent.putExtra("messenger_pay_entity_type", MessengerPayEntityType.PAYMENT_TRANSACTION);
        intent.putExtra("analytics_source", analyticsSource);
        return intent;
    }

    public static Intent m14503b(Context context, String str, AnalyticsSource analyticsSource) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Intent intent = new Intent(context, PaymentReceiptActivity.class);
        intent.putExtra("messenger_pay_entity_id", str);
        intent.putExtra("messenger_pay_entity_type", MessengerPayEntityType.PAYMENT_REQUEST);
        intent.putExtra("analytics_source", analyticsSource);
        return intent;
    }

    @Inject
    private void m14500a(AppCompatActivityOverrider appCompatActivityOverrider, AnalyticsLogger analyticsLogger, ConnectionStatusMonitor connectionStatusMonitor, LocalFbBroadcastManager localFbBroadcastManager, Executor executor, PaymentProtocolUtil paymentProtocolUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13995q = appCompatActivityOverrider;
        this.f13996r = analyticsLogger;
        this.f13997s = connectionStatusMonitor;
        this.f13998t = localFbBroadcastManager;
        this.f13999u = executor;
        this.f14000v = paymentProtocolUtil;
        this.f14001w = abstractFbErrorReporter;
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 740899777);
        super.onResume();
        this.f14002x.b();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -102094628, a);
    }

    public void onPostResume() {
        super.onPostResume();
        this.f13994F = true;
        m14506k(this);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -564274620);
        this.f13994F = false;
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1104575504, a);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 316324213);
        super.onDestroy();
        if (this.f13991C != null) {
            this.f13991C.cancel(true);
            this.f13991C = null;
        }
        this.f14002x.c();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1326447659, a);
    }

    protected final void m14509a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = PaymentReceiptActivity.class;
        m14502a(this, this);
        a(this.f13995q);
        this.f14002x = this.f13998t.a().a("com.facebook.orca.CONNECTIVITY_CHANGED", new C15891(this)).a();
    }

    protected final void m14510b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906155);
        this.f14003y = new ActionBarBasedFbTitleBar(this, this.f13995q.g());
        Intent intent = getIntent();
        this.f13990B = (MessengerPayEntityType) intent.getSerializableExtra("messenger_pay_entity_type");
        this.f14003y.setTitle(this.f13990B == MessengerPayEntityType.PAYMENT_REQUEST ? 2131240557 : 2131240332);
        Object a = FlatBufferModelHelper.a(intent, "messenger_pay_entity");
        boolean z = a == null || (a instanceof PaymentTransaction) || (a instanceof PaymentRequestModel);
        Preconditions.checkArgument(z);
        this.f13989A = m14504b(a);
        if (bundle == null) {
            AnalyticsLogger analyticsLogger = this.f13996r;
            Builder g = P2pPaymentsLogEvent.d("p2p_initiate_receipt", "p2p_settings").g(this.f13989A);
            g.a.b("source", intent.getSerializableExtra("analytics_source").toString());
            analyticsLogger.a(g.a);
        }
        if (a == null || !m14505c(a)) {
            this.f14004z = (ProgressBar) a(2131565816);
            m14501a(this, this.f13990B, this.f13989A);
            return;
        }
        this.f13992D = a;
        this.f13993E = true;
    }

    private String m14504b(@Nullable Object obj) {
        if (obj == null) {
            return getIntent().getStringExtra("messenger_pay_entity_id");
        }
        if (obj instanceof PaymentTransaction) {
            return ((PaymentTransaction) obj).f13229b;
        }
        if (obj instanceof PaymentRequestModel) {
            return ((PaymentRequestModel) obj).lw_();
        }
        throw new IllegalStateException("Invalid messengerPayEntity provided");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        this.f14003y.a(menu);
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public final ActionBar m14508a() {
        return this.f13995q.g();
    }

    public static void m14506k(PaymentReceiptActivity paymentReceiptActivity) {
        if (paymentReceiptActivity.f13993E) {
            FragmentManager kO_ = paymentReceiptActivity.kO_();
            if (((FbFragment) kO_.a("receipt_fragment")) == null) {
                boolean equals;
                Fragment fragment;
                if (paymentReceiptActivity.f13990B.equals(MessengerPayEntityType.PAYMENT_TRANSACTION)) {
                    equals = ((PaymentTransaction) paymentReceiptActivity.f13992D).f13230c.equals(PaymentType.NMOR_TRANSFER);
                } else {
                    equals = false;
                }
                Bundle bundle;
                if (equals) {
                    String str = ((PaymentTransaction) paymentReceiptActivity.f13992D).f13242o;
                    InvoicesSummaryFragment invoicesSummaryFragment = new InvoicesSummaryFragment();
                    bundle = new Bundle();
                    bundle.putString("InvoicesSummaryFragment_KEY_TRANSACTION_ID", str);
                    invoicesSummaryFragment.g(bundle);
                    fragment = invoicesSummaryFragment;
                } else {
                    Object obj = paymentReceiptActivity.f13992D;
                    ReceiptFragment receiptFragment = new ReceiptFragment();
                    bundle = new Bundle();
                    FlatBufferModelHelper.a(bundle, "messenger_pay_entity", obj);
                    receiptFragment.g(bundle);
                    fragment = receiptFragment;
                }
                kO_.a().b(2131560203, fragment, "receipt_fragment").b();
            }
        }
    }

    private static boolean m14505c(Object obj) {
        if (obj instanceof PaymentTransaction) {
            return ((PaymentTransaction) obj).f13234g.isTerminalStatus;
        }
        if (obj instanceof PaymentRequestModel) {
            return PaymentRequestUtil.b((PaymentRequestModel) obj);
        }
        return false;
    }

    public static void m14501a(PaymentReceiptActivity paymentReceiptActivity, MessengerPayEntityType messengerPayEntityType, String str) {
        Object obj;
        if (paymentReceiptActivity.f13991C == null || paymentReceiptActivity.f13991C.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            switch (messengerPayEntityType) {
                case PAYMENT_TRANSACTION:
                    paymentReceiptActivity.f13991C = paymentReceiptActivity.f14000v.m14958a(str, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
                    break;
                case PAYMENT_REQUEST:
                    paymentReceiptActivity.f13991C = paymentReceiptActivity.f14000v.m14969f(str);
                    break;
                default:
                    throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("Unknown MessengerPayEntityType received ", messengerPayEntityType));
            }
            if (paymentReceiptActivity.f14004z != null) {
                paymentReceiptActivity.f14004z.setVisibility(0);
            }
            Futures.a(paymentReceiptActivity.f13991C, new C15902(paymentReceiptActivity), paymentReceiptActivity.f13999u);
        }
    }

    public static void m14507o(PaymentReceiptActivity paymentReceiptActivity) {
        if (paymentReceiptActivity.f14004z != null) {
            paymentReceiptActivity.f14004z.setVisibility(8);
        }
    }
}
