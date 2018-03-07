package com.facebook.messaging.payment.prefs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceCategory;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentAccountEnabledStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentAccountEnabledStatusModel;
import com.facebook.messaging.payment.prefs.PaymentsPreferenceActivity.C15621;
import com.facebook.messaging.payment.prefs.PaymentsPreferenceActivity.C15632;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.widget.fbpreferencefragment.FbPreferenceFragment;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_thread_fbid */
public class PaymentAccountEnabledStatusPayPreferences extends FbPreferenceFragment implements MessengerPayPreferences<PaymentAccountEnabledStatus> {
    @Inject
    public Context f13773a;
    public SelfRegistrableReceiverImpl al;
    public boolean am = true;
    @Inject
    public PaymentProtocolUtil f13774b;
    @Inject
    @ForUiThread
    public Executor f13775c;
    @Inject
    @LocalBroadcast
    public LocalFbBroadcastManager f13776d;
    private C15621 f13777e;
    public C15632 f13778f;
    private PreferenceCategory f13779g;
    private PaymentAccountEnabledStatusPreference f13780h;
    public ListenableFuture<PaymentAccountEnabledStatus> f13781i;

    /* compiled from: group_thread_fbid */
    class C15521 implements FutureCallback<PaymentAccountEnabledStatus> {
        final /* synthetic */ PaymentAccountEnabledStatusPayPreferences f13771a;

        C15521(PaymentAccountEnabledStatusPayPreferences paymentAccountEnabledStatusPayPreferences) {
            this.f13771a = paymentAccountEnabledStatusPayPreferences;
        }

        public void onSuccess(@Nullable Object obj) {
            boolean z;
            PaymentAccountEnabledStatusModel paymentAccountEnabledStatusModel = (PaymentAccountEnabledStatusModel) obj;
            PaymentAccountEnabledStatusPayPreferences paymentAccountEnabledStatusPayPreferences = this.f13771a;
            if (paymentAccountEnabledStatusModel == null) {
                z = true;
            } else {
                z = paymentAccountEnabledStatusModel.m13688a();
            }
            paymentAccountEnabledStatusPayPreferences.am = z;
            PaymentAccountEnabledStatusPayPreferences.m14342b(this.f13771a, this.f13771a.am);
        }

        public void onFailure(Throwable th) {
            PaymentAccountEnabledStatusPayPreferences.m14342b(this.f13771a, this.f13771a.am);
        }
    }

    /* compiled from: group_thread_fbid */
    public class C15532 implements ActionReceiver {
        final /* synthetic */ PaymentAccountEnabledStatusPayPreferences f13772a;

        public C15532(PaymentAccountEnabledStatusPayPreferences paymentAccountEnabledStatusPayPreferences) {
            this.f13772a = paymentAccountEnabledStatusPayPreferences;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -359458418);
            this.f13772a.f13778f.m14376a(intent.getBooleanExtra("extra_payment_account_enabled_status", true));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -615017286, a);
        }
    }

    public static void m14341a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PaymentAccountEnabledStatusPayPreferences paymentAccountEnabledStatusPayPreferences = (PaymentAccountEnabledStatusPayPreferences) obj;
        Context context2 = (Context) injectorLike.getInstance(Context.class);
        PaymentProtocolUtil a = PaymentProtocolUtil.m14937a(injectorLike);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        LocalFbBroadcastManager a2 = LocalFbBroadcastManager.a(injectorLike);
        paymentAccountEnabledStatusPayPreferences.f13773a = context2;
        paymentAccountEnabledStatusPayPreferences.f13774b = a;
        paymentAccountEnabledStatusPayPreferences.f13775c = executor;
        paymentAccountEnabledStatusPayPreferences.f13776d = a2;
    }

    public final void mo542c(Bundle bundle) {
        super.mo542c(bundle);
        Class cls = PaymentAccountEnabledStatusPayPreferences.class;
        m14341a(this, getContext());
        this.f13779g = new PreferenceCategory(ao());
        this.f13779g.setLayoutResource(2130906359);
        this.f13780h = new PaymentAccountEnabledStatusPreference(this.f13773a);
        this.al = this.f13776d.a().a("com.facebook.messaging.payment.ACTION_PAYMENT_ACCOUNT_ENABLED_STATUS_UPDATED", new C15532(this)).a();
        this.f13777e.m14374a(this.f13779g);
    }

    public final void mo539a(C15621 c15621) {
        this.f13777e = c15621;
    }

    public final void m14343G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 909842556);
        super.G();
        this.al.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -770449215, a);
    }

    public final void mo543I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 414045311);
        super.mo543I();
        if (this.f13781i != null) {
            this.f13781i.cancel(true);
            this.f13781i = null;
        }
        this.al.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -275543222, a);
    }

    public static void m14342b(PaymentAccountEnabledStatusPayPreferences paymentAccountEnabledStatusPayPreferences, boolean z) {
        paymentAccountEnabledStatusPayPreferences.f13779g.addPreference(paymentAccountEnabledStatusPayPreferences.f13780h);
        paymentAccountEnabledStatusPayPreferences.f13778f.m14376a(z);
    }

    public final void mo540a(boolean z) {
        if (z) {
            this.f13779g.removePreference(this.f13780h);
        } else {
            this.f13779g.addPreference(this.f13780h);
        }
    }

    public final ListenableFuture<PaymentAccountEnabledStatus> mo541b() {
        Object obj;
        if (this.f13781i == null || this.f13781i.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return this.f13781i;
        }
        this.f13781i = this.f13774b.m14967e();
        Futures.a(this.f13781i, new C15521(this), this.f13775c);
        return this.f13781i;
    }
}
