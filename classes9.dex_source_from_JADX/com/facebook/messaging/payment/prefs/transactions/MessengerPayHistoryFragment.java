package com.facebook.messaging.payment.prefs.transactions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbListFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationNuxDialogsHelper;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionQueryType;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity.AnalyticsSource;
import com.facebook.messaging.payment.prefs.transactions.MessengerPayHistoryLoader.Error;
import com.facebook.messaging.payment.prefs.transactions.MessengerPayHistoryLoader.LoadType;
import com.facebook.messaging.payment.prefs.transactions.MessengerPayHistoryLoader.Params;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity;
import com.facebook.payments.util.PaymentsTextViewLinkHelper;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: funding */
public class MessengerPayHistoryFragment extends FbListFragment {
    public static final Class<?> as = MessengerPayHistoryFragment.class;
    @Inject
    @LocalBroadcast
    public LocalFbBroadcastManager al;
    @Inject
    public MessengerPayHistoryAdapter am;
    @Inject
    MessengerPayHistoryLoader an;
    @Inject
    AbstractFbErrorReporter ao;
    @Inject
    public PaymentsTextViewLinkHelper ap;
    @Inject
    public PaymentRequestUtil aq;
    @Inject
    PaymentMethodVerificationNuxDialogsHelper ar;
    public ListView at;
    public FbTextView au;
    public View av;
    @Nullable
    public PaymentTransactionQueryType aw;
    public MessengerPayHistoryMode ax;
    public MessengerPayHistoryLoaderResult ay;
    public SelfRegistrableReceiverImpl az;
    @Inject
    public SecureContextHelper f14337i;

    /* compiled from: funding */
    class C16281 implements Callback<Params, MessengerPayHistoryLoaderResult, Error> {
        final /* synthetic */ MessengerPayHistoryFragment f14331a;

        C16281(MessengerPayHistoryFragment messengerPayHistoryFragment) {
            this.f14331a = messengerPayHistoryFragment;
        }

        public final void m14741a(Object obj, Object obj2) {
            this.f14331a.ay = (MessengerPayHistoryLoaderResult) obj2;
            MessengerPayHistoryFragment.au(this.f14331a);
        }

        public final /* bridge */ /* synthetic */ void m14742b(Object obj, Object obj2) {
        }

        public final void m14743c(Object obj, Object obj2) {
            Params params = (Params) obj;
            Error error = (Error) obj2;
            this.f14331a.at.removeFooterView(this.f14331a.av);
            AdapterDetour.a(this.f14331a.am, 1411539389);
            this.f14331a.ao.a(MessengerPayHistoryFragment.as.getName(), error.toString());
            BLog.a(MessengerPayHistoryFragment.as, "Loading of messenger pay history items with params %s failed with %s", new Object[]{params, error.toString()});
            PaymentConnectivityDialogFactory.a(this.f14331a.getContext(), error.f14358a);
        }

        public final void m14740a(Object obj, ListenableFuture listenableFuture) {
            MessengerPayHistoryFragment messengerPayHistoryFragment = this.f14331a;
            if (messengerPayHistoryFragment.at.getFooterViewsCount() == 0) {
                messengerPayHistoryFragment.at.addFooterView(messengerPayHistoryFragment.av, null, false);
                AdapterDetour.a(messengerPayHistoryFragment.am, -920466083);
            }
        }
    }

    /* compiled from: funding */
    class C16292 implements OnItemClickListener {
        final /* synthetic */ MessengerPayHistoryFragment f14332a;

        C16292(MessengerPayHistoryFragment messengerPayHistoryFragment) {
            this.f14332a = messengerPayHistoryFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object obj = this.f14332a.ay.m14772a().get(i);
            MessengerPayHistoryFragment messengerPayHistoryFragment;
            switch (this.f14332a.ax) {
                case PAYMENT_TRANSACTIONS:
                    messengerPayHistoryFragment = this.f14332a;
                    messengerPayHistoryFragment.f14337i.a(PaymentReceiptActivity.m14497a(messengerPayHistoryFragment.getContext(), (PaymentTransaction) obj, AnalyticsSource.HISTORY), messengerPayHistoryFragment.getContext());
                    return;
                case INCOMING_PAYMENT_REQUESTS:
                case OUTGOING_PAYMENT_REQUESTS:
                    messengerPayHistoryFragment = this.f14332a;
                    PaymentRequestModel paymentRequestModel = (PaymentRequestModel) obj;
                    if (messengerPayHistoryFragment.aq.a(paymentRequestModel)) {
                        messengerPayHistoryFragment.f14337i.a(EnterPaymentValueActivity.m15589b(messengerPayHistoryFragment.getContext(), paymentRequestModel.lw_()), 1, messengerPayHistoryFragment);
                    } else {
                        messengerPayHistoryFragment.f14337i.a(PaymentReceiptActivity.m14498a(messengerPayHistoryFragment.getContext(), paymentRequestModel, AnalyticsSource.HISTORY), messengerPayHistoryFragment.getContext());
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown MessengerPayHistoryMode provided " + this.f14332a.ax);
            }
        }
    }

    /* compiled from: funding */
    public class C16303 implements ActionReceiver {
        final /* synthetic */ MessengerPayHistoryFragment f14333a;

        public C16303(MessengerPayHistoryFragment messengerPayHistoryFragment) {
            this.f14333a = messengerPayHistoryFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1902920026);
            MessengerPayHistoryFragment.aq(this.f14333a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1253310144, a);
        }
    }

    /* compiled from: funding */
    class MessengerPayHistoryItemsOnScrollListener implements OnScrollListener {
        final /* synthetic */ MessengerPayHistoryFragment f14336a;

        public MessengerPayHistoryItemsOnScrollListener(MessengerPayHistoryFragment messengerPayHistoryFragment) {
            this.f14336a = messengerPayHistoryFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i3 > i2 && i + i2 >= i3 && i3 != 0) {
                MessengerPayHistoryFragment.at(this.f14336a);
            }
        }
    }

    public static void m14745a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MessengerPayHistoryFragment) obj).m14744a((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), LocalFbBroadcastManager.a(injectorLike), new MessengerPayHistoryAdapter(CompositeMessengerPayHistoryItemViewFactory.m14724b(injectorLike)), MessengerPayHistoryLoader.m14764b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentsTextViewLinkHelper.b(injectorLike), PaymentRequestUtil.a(injectorLike), PaymentMethodVerificationNuxDialogsHelper.m13457b(injectorLike));
    }

    private void m14744a(SecureContextHelper secureContextHelper, LocalFbBroadcastManager localFbBroadcastManager, MessengerPayHistoryAdapter messengerPayHistoryAdapter, MessengerPayHistoryLoader messengerPayHistoryLoader, AbstractFbErrorReporter abstractFbErrorReporter, PaymentsTextViewLinkHelper paymentsTextViewLinkHelper, PaymentRequestUtil paymentRequestUtil, PaymentMethodVerificationNuxDialogsHelper paymentMethodVerificationNuxDialogsHelper) {
        this.f14337i = secureContextHelper;
        this.al = localFbBroadcastManager;
        this.am = messengerPayHistoryAdapter;
        this.an = messengerPayHistoryLoader;
        this.ao = abstractFbErrorReporter;
        this.ap = paymentsTextViewLinkHelper;
        this.aq = paymentRequestUtil;
        this.ar = paymentMethodVerificationNuxDialogsHelper;
    }

    public final void m14751a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1003807767);
        super.a(bundle);
        Class cls = MessengerPayHistoryFragment.class;
        m14745a(this, getContext());
        C16303 c16303 = new C16303(this);
        this.az = this.al.a().a("com.facebook.messaging.payment.ACTION_PAYMENT_TRANSACTION_CACHE_UPDATED", c16303).a("com.facebook.messaging.payment.ACTION_NEW_TRANSFER", c16303).a("com.facebook.messaging.payment.ACTION_PAYMENT_REQUEST_CACHE_UPDATED", c16303).a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -270733663, a);
    }

    public final View m14749a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1501399210);
        View inflate = layoutInflater.inflate(2130905260, viewGroup, false);
        this.at = (ListView) inflate.findViewById(16908298);
        this.au = (FbTextView) inflate.findViewById(2131563859);
        this.av = layoutInflater.inflate(2130905261, null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -316084776, a);
        return inflate;
    }

    public final void m14752d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1349816710);
        super.d(bundle);
        this.at.addFooterView(this.av);
        this.at.setAdapter(this.am);
        this.at.setOnScrollListener(new MessengerPayHistoryItemsOnScrollListener(this));
        this.ax = (MessengerPayHistoryMode) this.s.get("messenger_pay_history_mode");
        if (this.ax == MessengerPayHistoryMode.PAYMENT_TRANSACTIONS) {
            this.aw = (PaymentTransactionQueryType) this.s.get("payment_transaction_query_type");
        }
        this.an.m14768a(new C16281(this));
        this.at.setOnItemClickListener(new C16292(this));
        if (bundle != null) {
            MessengerPayHistoryLoader messengerPayHistoryLoader = this.an;
            messengerPayHistoryLoader.f14370i = (MessengerPayHistoryLoaderResult) bundle.getParcelable("current_result");
            messengerPayHistoryLoader.f14371j = bundle.getBoolean("initial_loading_done");
            this.ay = (MessengerPayHistoryLoaderResult) bundle.getParcelable("messenger_pay_history_loader_result");
            if (this.ay != null) {
                au(this);
            }
        }
        if (this.ay == null) {
            as();
            if (this.an.f14371j) {
                boolean z;
                this.at.removeFooterView(this.av);
                if (this.am.getCount() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                m14746a(z);
            }
        }
        LogUtils.f(-1246226253, a);
    }

    public final void m14750a(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    this.ar.m13460b(intent.getBooleanExtra("show_pin_nux", false), intent.getBooleanExtra("show_card_added_nux", false));
                    return;
                }
                return;
            default:
                super.a(i, i2, intent);
                return;
        }
    }

    private void m14746a(boolean z) {
        if (z) {
            this.at.setVisibility(0);
            this.au.setVisibility(8);
            return;
        }
        if (this.aw != null) {
            switch (this.aw) {
                case INCOMING:
                    this.ap.a(2131240328, "[[learn_more_link]]", b(2131240326), this.au, "https://m.facebook.com/help/messenger-app/750020781733477");
                    break;
                case OUTGOING:
                    this.ap.a(2131240327, "[[learn_more_link]]", b(2131240326), this.au, "https://m.facebook.com/help/messenger-app/750020781733477");
                    break;
                default:
                    break;
            }
        }
        this.at.setVisibility(8);
        this.au.setVisibility(0);
    }

    public final void m14747G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1082806393);
        super.G();
        this.az.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1613617224, a);
    }

    public final void m14748I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1619956583);
        super.I();
        if (this.an != null) {
            MessengerPayHistoryLoader messengerPayHistoryLoader = this.an;
            if (messengerPayHistoryLoader.f14368g != null) {
                messengerPayHistoryLoader.f14368g.a(false);
                messengerPayHistoryLoader.f14368g = null;
            }
            if (messengerPayHistoryLoader.f14369h != null) {
                messengerPayHistoryLoader.f14369h.a(false);
                messengerPayHistoryLoader.f14369h = null;
            }
            messengerPayHistoryLoader.f14370i = null;
        }
        this.az.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1792347662, a);
    }

    public final void m14753e(Bundle bundle) {
        MessengerPayHistoryLoader messengerPayHistoryLoader = this.an;
        bundle.putParcelable("current_result", messengerPayHistoryLoader.f14370i);
        bundle.putBoolean("initial_loading_done", messengerPayHistoryLoader.f14371j);
        bundle.putParcelable("messenger_pay_history_loader_result", this.ay);
        super.e(bundle);
    }

    public static void aq(MessengerPayHistoryFragment messengerPayHistoryFragment) {
        MessengerPayHistoryLoader messengerPayHistoryLoader = messengerPayHistoryFragment.an;
        if (messengerPayHistoryLoader.f14368g != null) {
            messengerPayHistoryLoader.f14368g.a(false);
            messengerPayHistoryLoader.f14368g = null;
        }
        if (messengerPayHistoryLoader.f14369h != null) {
            messengerPayHistoryLoader.f14369h.a(false);
            messengerPayHistoryLoader.f14369h = null;
        }
        messengerPayHistoryLoader.f14370i = null;
        messengerPayHistoryFragment.as();
    }

    private void as() {
        Params params;
        switch (this.ax) {
            case PAYMENT_TRANSACTIONS:
                params = new Params(this.aw, null, LoadType.LIST);
                break;
            case INCOMING_PAYMENT_REQUESTS:
                params = Params.m14761a(QueryType.INCOMING);
                break;
            case OUTGOING_PAYMENT_REQUESTS:
                params = Params.m14761a(QueryType.OUTGOING);
                break;
            default:
                throw new IllegalArgumentException("Unknown MessengerPayHistoryMode provided " + this.ax);
        }
        this.an.m14769a(params);
    }

    public static void at(MessengerPayHistoryFragment messengerPayHistoryFragment) {
        switch (messengerPayHistoryFragment.ax) {
            case PAYMENT_TRANSACTIONS:
                messengerPayHistoryFragment.an.m14769a(new Params(messengerPayHistoryFragment.aw, null, LoadType.MORE));
                return;
            case INCOMING_PAYMENT_REQUESTS:
            case OUTGOING_PAYMENT_REQUESTS:
                return;
            default:
                throw new IllegalArgumentException("Unknown MessengerPayHistoryMode provided " + messengerPayHistoryFragment.ax);
        }
    }

    public static void au(MessengerPayHistoryFragment messengerPayHistoryFragment) {
        messengerPayHistoryFragment.at.removeFooterView(messengerPayHistoryFragment.av);
        BaseAdapter baseAdapter = messengerPayHistoryFragment.am;
        baseAdapter.f14330b = messengerPayHistoryFragment.ay.m14772a();
        AdapterDetour.a(baseAdapter, 1981618086);
        messengerPayHistoryFragment.m14746a(messengerPayHistoryFragment.am.getCount() != 0);
    }
}
