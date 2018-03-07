package com.facebook.messaging.payment.prefs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionQueryType;
import com.facebook.messaging.payment.prefs.PaymentsPreferenceActivity.C15621;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity;
import com.facebook.messaging.payment.prefs.receipts.PaymentReceiptActivity.AnalyticsSource;
import com.facebook.messaging.payment.prefs.transactions.MessengerPayHistoryActivity;
import com.facebook.messaging.payment.prefs.transactions.MessengerPayHistoryMode;
import com.facebook.messaging.payment.prefs.transactions.MessengerPayHistoryPreference;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.transactions.FetchTransactionListResult;
import com.facebook.payments.contactinfo.form.ContactInfoCommonFormParams;
import com.facebook.payments.contactinfo.form.ContactInfoCommonFormParamsBuilder;
import com.facebook.payments.contactinfo.form.ContactInfoFormActivity;
import com.facebook.payments.contactinfo.form.ContactInfoFormStyle;
import com.facebook.tools.dextr.runtime.LogUtils;
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

/* compiled from: group_by */
public class TransactionHistoryMessengerPayPreferences extends FbPreferenceFragment implements MessengerPayPreferences<ImmutableList<PaymentTransaction>> {
    @Inject
    public Context f13893a;
    public SelfRegistrableReceiverImpl al;
    @Inject
    GatekeeperStoreImpl f13894b;
    @Inject
    PaymentProtocolUtil f13895c;
    @Inject
    @LocalBroadcast
    public LocalFbBroadcastManager f13896d;
    @Inject
    SecureContextHelper f13897e;
    @Inject
    @ForUiThread
    Executor f13898f;
    public C15621 f13899g;
    public PreferenceCategory f13900h;
    public ListenableFuture<ImmutableList<PaymentTransaction>> f13901i;

    /* compiled from: group_by */
    class C15791 implements Function<FetchTransactionListResult, ImmutableList<PaymentTransaction>> {
        final /* synthetic */ TransactionHistoryMessengerPayPreferences f13886a;

        C15791(TransactionHistoryMessengerPayPreferences transactionHistoryMessengerPayPreferences) {
            this.f13886a = transactionHistoryMessengerPayPreferences;
        }

        public Object apply(Object obj) {
            return ((FetchTransactionListResult) obj).f14748a;
        }
    }

    /* compiled from: group_by */
    class C15802 implements FutureCallback<ImmutableList<PaymentTransaction>> {
        final /* synthetic */ TransactionHistoryMessengerPayPreferences f13887a;

        C15802(TransactionHistoryMessengerPayPreferences transactionHistoryMessengerPayPreferences) {
            this.f13887a = transactionHistoryMessengerPayPreferences;
        }

        public void onSuccess(Object obj) {
            TransactionHistoryMessengerPayPreferences.m14424a(this.f13887a, (ImmutableList) obj);
        }

        public void onFailure(Throwable th) {
            TransactionHistoryMessengerPayPreferences.m14424a(this.f13887a, RegularImmutableList.a);
        }
    }

    /* compiled from: group_by */
    public class C15824 implements OnPreferenceClickListener {
        final /* synthetic */ TransactionHistoryMessengerPayPreferences f13890a;

        public C15824(TransactionHistoryMessengerPayPreferences transactionHistoryMessengerPayPreferences) {
            this.f13890a = transactionHistoryMessengerPayPreferences;
        }

        public boolean onPreferenceClick(Preference preference) {
            if (this.f13890a.f13894b.a(402, false)) {
                Context context = this.f13890a.getContext();
                ContactInfoCommonFormParamsBuilder contactInfoCommonFormParamsBuilder = new ContactInfoCommonFormParamsBuilder();
                contactInfoCommonFormParamsBuilder.f18644a = ContactInfoFormStyle.EMAIL;
                ContactInfoCommonFormParams contactInfoCommonFormParams = new ContactInfoCommonFormParams(contactInfoCommonFormParamsBuilder);
                Preconditions.checkNotNull(context);
                Intent intent = new Intent(context, ContactInfoFormActivity.class);
                intent.putExtra("extra_contact_info_form_params", contactInfoCommonFormParams);
                this.f13890a.f13897e.a(intent, this.f13890a.getContext());
            } else {
                this.f13890a.f13899g.m14373a(preference);
                this.f13890a.f13897e.a(MessengerPayHistoryActivity.m14733a(this.f13890a.f13893a, MessengerPayHistoryMode.PAYMENT_TRANSACTIONS), this.f13890a.getContext());
            }
            return true;
        }
    }

    /* compiled from: group_by */
    public class C15835 implements ActionReceiver {
        final /* synthetic */ TransactionHistoryMessengerPayPreferences f13891a;

        public C15835(TransactionHistoryMessengerPayPreferences transactionHistoryMessengerPayPreferences) {
            this.f13891a = transactionHistoryMessengerPayPreferences;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            Object obj;
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -33293015);
            int preferenceCount = this.f13891a.f13900h.getPreferenceCount();
            int i = preferenceCount > 2 ? preferenceCount - 1 : preferenceCount;
            for (int i2 = 0; i2 < i; i2++) {
                if (((PaymentTransaction) ((MessengerPayHistoryPreference) this.f13891a.f13900h.getPreference(i2)).f14375a).f13229b.equals(String.valueOf(intent.getLongExtra("extra_transfer_id", 0)))) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                this.f13891a.f13899g.m14372a();
            }
            LogUtils.e(1612543509, a);
        }
    }

    /* compiled from: group_by */
    public class C15846 implements ActionReceiver {
        final /* synthetic */ TransactionHistoryMessengerPayPreferences f13892a;

        public C15846(TransactionHistoryMessengerPayPreferences transactionHistoryMessengerPayPreferences) {
            this.f13892a = transactionHistoryMessengerPayPreferences;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 205131688);
            this.f13892a.f13899g.m14372a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 327834253, a);
        }
    }

    public static void m14425a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((TransactionHistoryMessengerPayPreferences) obj).m14423a((Context) injectorLike.getInstance(Context.class), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), LocalFbBroadcastManager.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    private void m14423a(Context context, GatekeeperStoreImpl gatekeeperStoreImpl, PaymentProtocolUtil paymentProtocolUtil, LocalFbBroadcastManager localFbBroadcastManager, SecureContextHelper secureContextHelper, Executor executor) {
        this.f13893a = context;
        this.f13894b = gatekeeperStoreImpl;
        this.f13895c = paymentProtocolUtil;
        this.f13896d = localFbBroadcastManager;
        this.f13897e = secureContextHelper;
        this.f13898f = executor;
    }

    public final void mo539a(C15621 c15621) {
        this.f13899g = c15621;
    }

    public final void mo542c(Bundle bundle) {
        super.mo542c(bundle);
        Class cls = TransactionHistoryMessengerPayPreferences.class;
        m14425a((Object) this, getContext());
        this.f13900h = new PreferenceCategory(ao());
        this.f13900h.setLayoutResource(2130906356);
        this.f13900h.setTitle(2131240301);
        C15835 c15835 = new C15835(this);
        this.al = this.f13896d.a().a("com.facebook.messaging.payment.ACTION_PAYMENT_TRANSACTION_CACHE_UPDATED", c15835).a("com.facebook.messaging.payment.ACTION_NEW_TRANSFER", new C15846(this)).a();
        this.f13899g.m14374a(this.f13900h);
    }

    public final void m14426G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -395112269);
        super.G();
        this.al.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 149312367, a);
    }

    public final void mo543I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -518781860);
        super.mo543I();
        if (this.f13901i != null) {
            this.f13901i.cancel(true);
            this.f13901i = null;
        }
        this.al.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 3206133, a);
    }

    public final void mo540a(boolean z) {
    }

    public static void m14424a(TransactionHistoryMessengerPayPreferences transactionHistoryMessengerPayPreferences, ImmutableList immutableList) {
        transactionHistoryMessengerPayPreferences.f13900h.removeAll();
        if (immutableList.isEmpty()) {
            Preference preference = new Preference(transactionHistoryMessengerPayPreferences.f13893a);
            preference.setLayoutResource(2130906148);
            preference.setTitle(2131240310);
            transactionHistoryMessengerPayPreferences.f13900h.addPreference(preference);
            return;
        }
        for (int i = 0; i < Math.min(2, immutableList.size()); i++) {
            final PaymentTransaction paymentTransaction = (PaymentTransaction) immutableList.get(i);
            Preference messengerPayHistoryPreference = new MessengerPayHistoryPreference(transactionHistoryMessengerPayPreferences.f13893a, paymentTransaction);
            messengerPayHistoryPreference.setOnPreferenceClickListener(new OnPreferenceClickListener(transactionHistoryMessengerPayPreferences) {
                final /* synthetic */ TransactionHistoryMessengerPayPreferences f13889b;

                public boolean onPreferenceClick(Preference preference) {
                    this.f13889b.f13899g.m14373a(preference);
                    this.f13889b.f13897e.a(PaymentReceiptActivity.m14497a(this.f13889b.f13893a, paymentTransaction, AnalyticsSource.SETTINGS), this.f13889b.f13893a);
                    return true;
                }
            });
            transactionHistoryMessengerPayPreferences.f13900h.addPreference(messengerPayHistoryPreference);
        }
        if (immutableList.size() > 2) {
            messengerPayHistoryPreference = new Preference(transactionHistoryMessengerPayPreferences.f13893a);
            messengerPayHistoryPreference.setLayoutResource(2130906154);
            messengerPayHistoryPreference.setTitle(2131240308);
            messengerPayHistoryPreference.setOnPreferenceClickListener(new C15824(transactionHistoryMessengerPayPreferences));
            transactionHistoryMessengerPayPreferences.f13900h.addPreference(messengerPayHistoryPreference);
        }
    }

    public final ListenableFuture<ImmutableList<PaymentTransaction>> mo541b() {
        Object obj;
        if (this.f13901i == null || this.f13901i.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return this.f13901i;
        }
        this.f13901i = Futures.a(this.f13895c.m14949a(PaymentTransactionQueryType.ALL, 3), new C15791(this), this.f13898f);
        Futures.a(this.f13901i, new C15802(this), this.f13898f);
        return this.f13901i;
    }
}
