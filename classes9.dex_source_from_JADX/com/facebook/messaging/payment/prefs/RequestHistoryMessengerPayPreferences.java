package com.facebook.messaging.payment.prefs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.activitylistener.FbActivityListener;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.config.IsP2pPaymentsRequestEligible;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationNuxDialogsHelper;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.prefs.PaymentsPreferenceActivity.C15621;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity.AnalyticsSource;
import com.facebook.messaging.payment.prefs.transactions.MessengerPayHistoryActivity;
import com.facebook.messaging.payment.prefs.transactions.MessengerPayHistoryMode;
import com.facebook.messaging.payment.prefs.transactions.MessengerPayHistoryPreference;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsResult;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity;
import com.facebook.widget.fbpreferencefragment.FbPreferenceFragment;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: group_commerce/ */
public class RequestHistoryMessengerPayPreferences extends FbPreferenceFragment implements MessengerPayPreferences<ImmutableList<PaymentRequest>> {
    @Inject
    PaymentProtocolUtil f13864a;
    public QueryType al;
    public ListenableFuture<ImmutableList<PaymentRequest>> am;
    public SelfRegistrableReceiverImpl an;
    public final FbActivityListener ao = new C15691(this);
    @IsP2pPaymentsRequestEligible
    @Inject
    Provider<Boolean> f13865b;
    @Inject
    SecureContextHelper f13866c;
    @Inject
    @ForUiThread
    Executor f13867d;
    @Inject
    PaymentRequestUtil f13868e;
    @Inject
    PaymentMethodVerificationNuxDialogsHelper f13869f;
    @Inject
    @LocalBroadcast
    public LocalFbBroadcastManager f13870g;
    public C15621 f13871h;
    public PreferenceCategory f13872i;

    /* compiled from: group_commerce/ */
    class C15691 extends AbstractFbActivityListener {
        final /* synthetic */ RequestHistoryMessengerPayPreferences f13857a;

        C15691(RequestHistoryMessengerPayPreferences requestHistoryMessengerPayPreferences) {
            this.f13857a = requestHistoryMessengerPayPreferences;
        }

        public final void m14402a(Activity activity, int i, int i2, Intent intent) {
            this.f13857a.a(i, i2, intent);
        }
    }

    /* compiled from: group_commerce/ */
    class C15702 implements Function<FetchPaymentRequestsResult, ImmutableList<PaymentRequest>> {
        final /* synthetic */ RequestHistoryMessengerPayPreferences f13858a;

        C15702(RequestHistoryMessengerPayPreferences requestHistoryMessengerPayPreferences) {
            this.f13858a = requestHistoryMessengerPayPreferences;
        }

        public Object apply(Object obj) {
            return ((FetchPaymentRequestsResult) obj).m15195a();
        }
    }

    /* compiled from: group_commerce/ */
    class C15713 implements FutureCallback<ImmutableList<PaymentRequest>> {
        final /* synthetic */ RequestHistoryMessengerPayPreferences f13859a;

        C15713(RequestHistoryMessengerPayPreferences requestHistoryMessengerPayPreferences) {
            this.f13859a = requestHistoryMessengerPayPreferences;
        }

        public void onSuccess(Object obj) {
            RequestHistoryMessengerPayPreferences.m14404a(this.f13859a, (ImmutableList) obj);
        }

        public void onFailure(Throwable th) {
            if (this.f13859a.getContext() != null) {
                RequestHistoryMessengerPayPreferences.m14404a(this.f13859a, RegularImmutableList.a);
            }
        }
    }

    /* compiled from: group_commerce/ */
    public class C15735 implements OnPreferenceClickListener {
        final /* synthetic */ RequestHistoryMessengerPayPreferences f13862a;

        public C15735(RequestHistoryMessengerPayPreferences requestHistoryMessengerPayPreferences) {
            this.f13862a = requestHistoryMessengerPayPreferences;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f13862a.f13871h.m14373a(preference);
            this.f13862a.f13866c.a(MessengerPayHistoryActivity.m14733a(this.f13862a.getContext(), this.f13862a.al == QueryType.INCOMING ? MessengerPayHistoryMode.INCOMING_PAYMENT_REQUESTS : MessengerPayHistoryMode.OUTGOING_PAYMENT_REQUESTS), this.f13862a.getContext());
            return true;
        }
    }

    /* compiled from: group_commerce/ */
    public class C15746 implements ActionReceiver {
        final /* synthetic */ RequestHistoryMessengerPayPreferences f13863a;

        public C15746(RequestHistoryMessengerPayPreferences requestHistoryMessengerPayPreferences) {
            this.f13863a = requestHistoryMessengerPayPreferences;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -912768826);
            this.f13863a.f13871h.m14372a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1972131434, a);
        }
    }

    public static void m14406a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RequestHistoryMessengerPayPreferences) obj).m14405a(PaymentProtocolUtil.m14937a(injectorLike), IdBasedProvider.a(injectorLike, 4182), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PaymentRequestUtil.a(injectorLike), PaymentMethodVerificationNuxDialogsHelper.m13457b(injectorLike), LocalFbBroadcastManager.a(injectorLike));
    }

    private void m14405a(PaymentProtocolUtil paymentProtocolUtil, Provider<Boolean> provider, SecureContextHelper secureContextHelper, Executor executor, PaymentRequestUtil paymentRequestUtil, PaymentMethodVerificationNuxDialogsHelper paymentMethodVerificationNuxDialogsHelper, LocalFbBroadcastManager localFbBroadcastManager) {
        this.f13864a = paymentProtocolUtil;
        this.f13865b = provider;
        this.f13866c = secureContextHelper;
        this.f13867d = executor;
        this.f13868e = paymentRequestUtil;
        this.f13869f = paymentMethodVerificationNuxDialogsHelper;
        this.f13870g = localFbBroadcastManager;
    }

    public static final RequestHistoryMessengerPayPreferences m14403a(QueryType queryType) {
        RequestHistoryMessengerPayPreferences requestHistoryMessengerPayPreferences = new RequestHistoryMessengerPayPreferences();
        Bundle bundle = new Bundle();
        bundle.putSerializable("payment_request_query_type", queryType);
        requestHistoryMessengerPayPreferences.g(bundle);
        return requestHistoryMessengerPayPreferences;
    }

    public final void mo539a(C15621 c15621) {
        this.f13871h = c15621;
    }

    public final void mo542c(Bundle bundle) {
        super.mo542c(bundle);
        Class cls = RequestHistoryMessengerPayPreferences.class;
        m14406a((Object) this, getContext());
        this.al = (QueryType) this.s.getSerializable("payment_request_query_type");
        Preconditions.checkNotNull(this.al);
        this.f13872i = new PreferenceCategory(ao());
        this.f13872i.setLayoutResource(2130906356);
        this.f13872i.setTitle(this.al == QueryType.INCOMING ? 2131240269 : 2131240270);
        this.an = this.f13870g.a().a("com.facebook.messaging.payment.ACTION_PAYMENT_REQUEST_CACHE_UPDATED", new C15746(this)).a();
        this.f13871h.m14374a(this.f13872i);
    }

    public final void m14407G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1067070256);
        super.G();
        this.an.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 110226092, a);
    }

    public final void mo543I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -987650596);
        super.mo543I();
        if (this.am != null) {
            this.am.cancel(true);
            this.am = null;
        }
        this.an.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 743936591, a);
    }

    public final void mo548a(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    this.f13869f.m13460b(intent.getBooleanExtra("show_pin_nux", false), intent.getBooleanExtra("show_card_added_nux", false));
                    return;
                }
                return;
            default:
                super.mo548a(i, i2, intent);
                return;
        }
    }

    public final ListenableFuture<ImmutableList<PaymentRequest>> mo541b() {
        if (((Boolean) this.f13865b.get()).booleanValue()) {
            Object obj;
            if (this.am == null || this.am.isDone()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return this.am;
            }
            this.am = Futures.a(this.f13864a.m14951a(this.al), new C15702(this), this.f13867d);
            Futures.a(this.am, new C15713(this), this.f13867d);
            return this.am;
        }
        this.f13871h.m14375b(this.f13872i);
        return Futures.a(null);
    }

    public final void mo540a(boolean z) {
    }

    public static void m14404a(RequestHistoryMessengerPayPreferences requestHistoryMessengerPayPreferences, ImmutableList immutableList) {
        requestHistoryMessengerPayPreferences.f13872i.removeAll();
        if (immutableList.isEmpty()) {
            requestHistoryMessengerPayPreferences.f13871h.m14375b(requestHistoryMessengerPayPreferences.f13872i);
            return;
        }
        for (int i = 0; i < Math.min(2, immutableList.size()); i++) {
            final PaymentRequestModel paymentRequestModel = (PaymentRequestModel) immutableList.get(i);
            Preference messengerPayHistoryPreference = new MessengerPayHistoryPreference(requestHistoryMessengerPayPreferences.getContext(), paymentRequestModel);
            messengerPayHistoryPreference.setOnPreferenceClickListener(new OnPreferenceClickListener(requestHistoryMessengerPayPreferences) {
                final /* synthetic */ RequestHistoryMessengerPayPreferences f13861b;

                public boolean onPreferenceClick(Preference preference) {
                    this.f13861b.f13871h.m14373a(preference);
                    if (this.f13861b.f13868e.a(paymentRequestModel)) {
                        Intent b = EnterPaymentValueActivity.m15589b(this.f13861b.getContext(), paymentRequestModel.lw_());
                        C15621 c15621 = this.f13861b.f13871h;
                        FbActivityListener fbActivityListener = this.f13861b.ao;
                        c15621.f13807a.f13817e.a(b, 1, c15621.f13807a);
                        c15621.f13807a.a(fbActivityListener);
                    } else {
                        this.f13861b.f13866c.a(PaymentReceiptActivity.m14498a(this.f13861b.getContext(), paymentRequestModel, AnalyticsSource.SETTINGS), this.f13861b.getContext());
                    }
                    return true;
                }
            });
            requestHistoryMessengerPayPreferences.f13872i.addPreference(messengerPayHistoryPreference);
        }
        if (immutableList.size() > 2) {
            messengerPayHistoryPreference = new Preference(requestHistoryMessengerPayPreferences.getContext());
            messengerPayHistoryPreference.setLayoutResource(2130906154);
            messengerPayHistoryPreference.setTitle(2131240308);
            messengerPayHistoryPreference.setOnPreferenceClickListener(new C15735(requestHistoryMessengerPayPreferences));
            requestHistoryMessengerPayPreferences.f13872i.addPreference(messengerPayHistoryPreference);
        }
    }
}
