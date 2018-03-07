package com.facebook.messaging.payment.prefs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.method.input.MessengerPayCardFormParams;
import com.facebook.messaging.payment.method.input.MessengerPayCardFormParamsBuilder;
import com.facebook.messaging.payment.method.verification.PaymentCardsFetcher;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController.ResultCallback;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationNuxDialogsHelper;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationParams;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationParams.Builder;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.VerificationFollowUpAction;
import com.facebook.messaging.payment.prefs.PaymentsPreferenceActivity.C15621;
import com.facebook.messaging.payment.prefs.cards.PaymentCardPreference;
import com.facebook.messaging.payment.util.PaymentFlowTypeUtil;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.paymentmethods.cardform.CardFormActivity;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParams;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParams;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormStyle;
import com.facebook.payments.paymentmethods.cardform.CardFormStyleParams;
import com.facebook.widget.fbpreferencefragment.FbPreferenceFragment;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_rank */
public class PaymentMethodsMessengerPayPreferences extends FbPreferenceFragment implements MessengerPayPreferences<ImmutableList<PaymentCard>> {
    public static final Class<?> al = PaymentMethodsMessengerPayPreferences.class;
    @Inject
    public Context f13793a;
    public C15621 am;
    public PreferenceCategory an;
    public ListenableFuture<ImmutableList<PaymentCard>> ao;
    public SelfRegistrableReceiverImpl ap;
    public boolean aq = true;
    public ImmutableList<PaymentCard> ar;
    public ImmutableList<PaymentCard> as;
    @Inject
    PaymentCardsFetcher f13794b;
    @Inject
    public AnalyticsLogger f13795c;
    @Inject
    public SecureContextHelper f13796d;
    @Inject
    PaymentMethodVerificationNuxDialogsHelper f13797e;
    @Inject
    public PaymentMethodVerificationController f13798f;
    @Inject
    AbstractFbErrorReporter f13799g;
    @Inject
    @LocalBroadcast
    public LocalFbBroadcastManager f13800h;
    @Inject
    @ForUiThread
    Executor f13801i;

    /* compiled from: group_rank */
    class C15541 implements FutureCallback<ImmutableList<PaymentCard>> {
        final /* synthetic */ PaymentMethodsMessengerPayPreferences f13784a;

        C15541(PaymentMethodsMessengerPayPreferences paymentMethodsMessengerPayPreferences) {
            this.f13784a = paymentMethodsMessengerPayPreferences;
        }

        public void onSuccess(Object obj) {
            PaymentMethodsMessengerPayPreferences.m14359a(this.f13784a, (ImmutableList) obj);
        }

        public void onFailure(Throwable th) {
            PaymentMethodsMessengerPayPreferences.m14359a(this.f13784a, RegularImmutableList.a);
        }
    }

    /* compiled from: group_rank */
    public class C15563 implements OnPreferenceClickListener {
        final /* synthetic */ PaymentMethodsMessengerPayPreferences f13787a;

        public C15563(PaymentMethodsMessengerPayPreferences paymentMethodsMessengerPayPreferences) {
            this.f13787a = paymentMethodsMessengerPayPreferences;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f13787a.am.m14373a(preference);
            PaymentMethodsMessengerPayPreferences paymentMethodsMessengerPayPreferences = this.f13787a;
            ImmutableList immutableList = this.f13787a.ar;
            ResultCallback c15585 = new C15585(paymentMethodsMessengerPayPreferences);
            Builder newBuilder = PaymentMethodVerificationParams.newBuilder();
            newBuilder.f13172b = immutableList;
            newBuilder = newBuilder;
            newBuilder.f13175e = PaymentFlowType.SETTINGS;
            paymentMethodsMessengerPayPreferences.f13798f.m13455a(newBuilder.m13461a(), c15585);
            return true;
        }
    }

    /* compiled from: group_rank */
    public class C15574 implements ResultCallback {
        final /* synthetic */ PaymentCard f13788a;
        final /* synthetic */ boolean f13789b;
        final /* synthetic */ PaymentMethodsMessengerPayPreferences f13790c;

        public C15574(PaymentMethodsMessengerPayPreferences paymentMethodsMessengerPayPreferences, PaymentCard paymentCard, boolean z) {
            this.f13790c = paymentMethodsMessengerPayPreferences;
            this.f13788a = paymentCard;
            this.f13789b = z;
        }

        public final void mo544a() {
            PaymentMethodsMessengerPayPreferences paymentMethodsMessengerPayPreferences = this.f13790c;
            PaymentCard paymentCard = this.f13788a;
            boolean z = this.f13789b;
            boolean z2 = true;
            paymentMethodsMessengerPayPreferences.f13795c.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_initiate_edit_card"));
            boolean z3 = paymentCard.mo523h() && !paymentCard.mo524k();
            CardFormAnalyticsParamsBuilder newBuilder = CardFormAnalyticsParams.newBuilder();
            newBuilder.a = "p2p";
            newBuilder = newBuilder;
            newBuilder.b = PaymentFlowType.SETTINGS.analyticsModule;
            CardFormAnalyticsParams c = newBuilder.c();
            CardFormStyleParams.Builder newBuilder2 = CardFormStyleParams.newBuilder();
            newBuilder2.c = PaymentsDecoratorParams.c();
            CardFormStyleParams e = newBuilder2.e();
            CardFormCommonParamsBuilder newBuilder3 = CardFormCommonParams.newBuilder();
            newBuilder3.a = CardFormStyle.MESSENGER_PAY_EDIT;
            newBuilder3 = newBuilder3;
            newBuilder3.d = paymentCard;
            newBuilder3 = newBuilder3;
            newBuilder3.c = e;
            CardFormCommonParamsBuilder cardFormCommonParamsBuilder = newBuilder3;
            cardFormCommonParamsBuilder.e = PaymentFlowTypeUtil.m15515a(z3);
            CardFormCommonParamsBuilder cardFormCommonParamsBuilder2 = cardFormCommonParamsBuilder;
            cardFormCommonParamsBuilder2.b = c;
            cardFormCommonParamsBuilder2 = cardFormCommonParamsBuilder2;
            MessengerPayCardFormParamsBuilder newBuilder4 = MessengerPayCardFormParams.newBuilder();
            newBuilder4.f13042f = cardFormCommonParamsBuilder2.f();
            MessengerPayCardFormParamsBuilder messengerPayCardFormParamsBuilder = newBuilder4;
            messengerPayCardFormParamsBuilder.f13043g = z;
            messengerPayCardFormParamsBuilder = messengerPayCardFormParamsBuilder;
            if (paymentMethodsMessengerPayPreferences.aq) {
                z2 = false;
            }
            messengerPayCardFormParamsBuilder.f13045i = z2;
            paymentMethodsMessengerPayPreferences.f13796d.a(CardFormActivity.a(paymentMethodsMessengerPayPreferences.f13793a, messengerPayCardFormParamsBuilder.m13336j()), paymentMethodsMessengerPayPreferences.getContext());
        }

        public final void mo545a(PaymentCard paymentCard, @Nullable VerificationFollowUpAction verificationFollowUpAction, boolean z, boolean z2) {
            this.f13790c.f13797e.m13458a(z, z2);
        }

        public final void mo546b() {
        }

        public final void mo547c() {
        }
    }

    /* compiled from: group_rank */
    public class C15585 implements ResultCallback {
        final /* synthetic */ PaymentMethodsMessengerPayPreferences f13791a;

        public C15585(PaymentMethodsMessengerPayPreferences paymentMethodsMessengerPayPreferences) {
            this.f13791a = paymentMethodsMessengerPayPreferences;
        }

        public final void mo544a() {
            this.f13791a.f13799g.b(PaymentMethodsMessengerPayPreferences.al.getName(), "A card already verified event received when verifying a non-verified P2P card");
        }

        public final void mo545a(PaymentCard paymentCard, @Nullable VerificationFollowUpAction verificationFollowUpAction, boolean z, boolean z2) {
            this.f13791a.f13797e.m13458a(z, z2);
        }

        public final void mo546b() {
        }

        public final void mo547c() {
        }
    }

    /* compiled from: group_rank */
    public class C15596 implements ActionReceiver {
        final /* synthetic */ PaymentMethodsMessengerPayPreferences f13792a;

        public C15596(PaymentMethodsMessengerPayPreferences paymentMethodsMessengerPayPreferences) {
            this.f13792a = paymentMethodsMessengerPayPreferences;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1171608551);
            this.f13792a.am.m14372a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -98670445, a);
        }
    }

    public static void m14360a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentMethodsMessengerPayPreferences) obj).m14358a((Context) injectorLike.getInstance(Context.class), PaymentCardsFetcher.m13429a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), PaymentMethodVerificationNuxDialogsHelper.m13457b(injectorLike), PaymentMethodVerificationController.m13449b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), LocalFbBroadcastManager.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    private void m14358a(Context context, PaymentCardsFetcher paymentCardsFetcher, AnalyticsLogger analyticsLogger, SecureContextHelper secureContextHelper, PaymentMethodVerificationNuxDialogsHelper paymentMethodVerificationNuxDialogsHelper, PaymentMethodVerificationController paymentMethodVerificationController, AbstractFbErrorReporter abstractFbErrorReporter, LocalFbBroadcastManager localFbBroadcastManager, Executor executor) {
        this.f13793a = context;
        this.f13794b = paymentCardsFetcher;
        this.f13795c = analyticsLogger;
        this.f13796d = secureContextHelper;
        this.f13797e = paymentMethodVerificationNuxDialogsHelper;
        this.f13798f = paymentMethodVerificationController;
        this.f13799g = abstractFbErrorReporter;
        this.f13800h = localFbBroadcastManager;
        this.f13801i = executor;
    }

    public final void mo539a(C15621 c15621) {
        this.am = c15621;
    }

    public final void mo542c(Bundle bundle) {
        super.mo542c(bundle);
        Class cls = PaymentMethodsMessengerPayPreferences.class;
        m14360a((Object) this, getContext());
        this.an = new PreferenceCategory(ao());
        this.an.setLayoutResource(2130906359);
        this.an.setTitle(2131240300);
        this.ap = this.f13800h.a().a("com.facebook.messaging.payment.ACTION_PAYMENT_CARD_UPDATED", new C15596(this)).a();
        this.am.m14374a(this.an);
    }

    public final void m14361G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 661684658);
        super.G();
        this.ap.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1851448211, a);
    }

    public final void mo548a(int i, int i2, Intent intent) {
        switch (i) {
            case 1000:
                this.f13798f.m13454a(i, i2, intent);
                return;
            case 1001:
                this.f13798f.m13454a(i, i2, intent);
                return;
            default:
                super.mo548a(i, i2, intent);
                return;
        }
    }

    public final void mo543I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 452280235);
        super.mo543I();
        if (this.ao != null) {
            this.ao.cancel(true);
            this.ao = null;
        }
        PaymentMethodVerificationController paymentMethodVerificationController = this.f13798f;
        if (paymentMethodVerificationController.f13155n != null) {
            paymentMethodVerificationController.f13155n.cancel(true);
            paymentMethodVerificationController.f13155n = null;
        }
        if (paymentMethodVerificationController.f13156o != null) {
            paymentMethodVerificationController.f13156o.cancel(true);
            paymentMethodVerificationController.f13156o = null;
        }
        if (paymentMethodVerificationController.f13157p != null) {
            paymentMethodVerificationController.f13157p.cancel(true);
            paymentMethodVerificationController.f13157p = null;
        }
        paymentMethodVerificationController.f13154m = null;
        this.ap.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -592035136, a);
    }

    public final void mo540a(boolean z) {
        this.aq = z;
        aq();
    }

    public static void m14359a(PaymentMethodsMessengerPayPreferences paymentMethodsMessengerPayPreferences, ImmutableList immutableList) {
        paymentMethodsMessengerPayPreferences.ar = immutableList;
        paymentMethodsMessengerPayPreferences.as = PaymentCardsFetcher.m13430a(immutableList);
        paymentMethodsMessengerPayPreferences.aq();
    }

    private void aq() {
        if (this.an != null) {
            int i;
            this.an.removeAll();
            if (!(this.ar == null || this.as == null)) {
                int size = this.as.size();
                for (i = 0; i < size; i++) {
                    final PaymentCard paymentCard = (PaymentCard) this.as.get(i);
                    Preference paymentCardPreference = new PaymentCardPreference(this.f13793a, paymentCard);
                    paymentCardPreference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                        final /* synthetic */ PaymentMethodsMessengerPayPreferences f13786b;

                        public boolean onPreferenceClick(Preference preference) {
                            PaymentMethodsMessengerPayPreferences paymentMethodsMessengerPayPreferences = this.f13786b;
                            preference = (PaymentCardPreference) preference;
                            PaymentCard paymentCard = paymentCard;
                            ImmutableList immutableList = this.f13786b.as;
                            ImmutableList immutableList2 = this.f13786b.ar;
                            paymentMethodsMessengerPayPreferences.am.m14373a(preference);
                            ResultCallback c15574 = new C15574(paymentMethodsMessengerPayPreferences, paymentCard, preference.f13904c);
                            Builder newBuilder = PaymentMethodVerificationParams.newBuilder();
                            newBuilder.f13171a = paymentCard;
                            newBuilder = newBuilder;
                            newBuilder.f13172b = immutableList2;
                            newBuilder = newBuilder;
                            newBuilder.f13175e = PaymentFlowType.SETTINGS;
                            paymentMethodsMessengerPayPreferences.f13798f.m13455a(newBuilder.m13461a(), c15574);
                            return true;
                        }
                    });
                    this.an.addPreference(paymentCardPreference);
                }
            }
            for (i = 0; i < this.an.getPreferenceCount(); i++) {
                PaymentCardPreference paymentCardPreference2 = (PaymentCardPreference) this.an.getPreference(i);
                if (paymentCardPreference2.f13902a.mo525l()) {
                    paymentCardPreference2.f13904c = true;
                    break;
                }
            }
            if (this.aq) {
                Preference preference = new Preference(this.f13793a);
                preference.setLayoutResource(2130906154);
                preference.setTitle(2131240309);
                preference.setOnPreferenceClickListener(new C15563(this));
                this.an.addPreference(preference);
            }
        }
    }

    public final ListenableFuture<ImmutableList<PaymentCard>> mo541b() {
        Object obj;
        if (this.ao == null || this.ao.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return this.ao;
        }
        this.ao = this.f13794b.m13434a();
        Futures.a(this.ao, new C15541(this), this.f13801i);
        return this.ao;
    }
}
