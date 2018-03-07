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
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.pin.PaymentPinCreationActivity;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.messaging.payment.prefs.PaymentsPreferenceActivity.C15621;
import com.facebook.widget.fbpreferencefragment.FbPreferenceFragment;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: group_clusters */
public class SecurityMessengerPayPreferences extends FbPreferenceFragment implements MessengerPayPreferences<PaymentPin> {
    @Inject
    Context f13877a;
    @Inject
    PaymentPinProtocolUtil f13878b;
    @Inject
    @LocalBroadcast
    public LocalFbBroadcastManager f13879c;
    @Inject
    SecureContextHelper f13880d;
    @Inject
    @ForUiThread
    Executor f13881e;
    public C15621 f13882f;
    private PreferenceCategory f13883g;
    public ListenableFuture<PaymentPin> f13884h;
    public SelfRegistrableReceiverImpl f13885i;

    /* compiled from: group_clusters */
    class C15751 implements FutureCallback<PaymentPin> {
        final /* synthetic */ SecurityMessengerPayPreferences f13873a;

        C15751(SecurityMessengerPayPreferences securityMessengerPayPreferences) {
            this.f13873a = securityMessengerPayPreferences;
        }

        public void onSuccess(Object obj) {
            SecurityMessengerPayPreferences.m14415a(this.f13873a, (PaymentPin) obj);
        }

        public void onFailure(Throwable th) {
            SecurityMessengerPayPreferences.m14415a(this.f13873a, PaymentPin.f13711a);
        }
    }

    /* compiled from: group_clusters */
    public class C15762 implements OnPreferenceClickListener {
        final /* synthetic */ SecurityMessengerPayPreferences f13874a;

        public C15762(SecurityMessengerPayPreferences securityMessengerPayPreferences) {
            this.f13874a = securityMessengerPayPreferences;
        }

        public boolean onPreferenceClick(Preference preference) {
            Intent intent = new Intent(this.f13874a.f13877a, PaymentPinPreferenceActivity.class);
            preference.setIntent(intent);
            this.f13874a.f13880d.a(intent, this.f13874a.f13877a);
            return true;
        }
    }

    /* compiled from: group_clusters */
    public class C15773 implements OnPreferenceClickListener {
        final /* synthetic */ SecurityMessengerPayPreferences f13875a;

        public C15773(SecurityMessengerPayPreferences securityMessengerPayPreferences) {
            this.f13875a = securityMessengerPayPreferences;
        }

        public boolean onPreferenceClick(Preference preference) {
            Intent a = PaymentPinCreationActivity.m14149a(this.f13875a.f13877a);
            preference.setIntent(a);
            this.f13875a.f13880d.a(a, this.f13875a.getContext());
            return true;
        }
    }

    /* compiled from: group_clusters */
    public class C15784 implements ActionReceiver {
        final /* synthetic */ SecurityMessengerPayPreferences f13876a;

        public C15784(SecurityMessengerPayPreferences securityMessengerPayPreferences) {
            this.f13876a = securityMessengerPayPreferences;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2033710340);
            this.f13876a.f13882f.m14372a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1452988208, a);
        }
    }

    public static void m14416a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SecurityMessengerPayPreferences) obj).m14414a((Context) injectorLike.getInstance(Context.class), PaymentPinProtocolUtil.m14279a(injectorLike), LocalFbBroadcastManager.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public final void mo539a(C15621 c15621) {
        this.f13882f = c15621;
    }

    public final void mo542c(Bundle bundle) {
        super.mo542c(bundle);
        Class cls = SecurityMessengerPayPreferences.class;
        m14416a((Object) this, getContext());
        this.f13883g = new PreferenceCategory(ao());
        this.f13883g.setLayoutResource(2130906356);
        this.f13883g.setTitle(2131240302);
        this.f13885i = this.f13879c.a().a("com.facebook.messaging.payment.ACTION_PIN_UPDATED", new C15784(this)).a();
        this.f13882f.m14374a(this.f13883g);
    }

    private void m14414a(Context context, PaymentPinProtocolUtil paymentPinProtocolUtil, LocalFbBroadcastManager localFbBroadcastManager, SecureContextHelper secureContextHelper, Executor executor) {
        this.f13877a = context;
        this.f13878b = paymentPinProtocolUtil;
        this.f13879c = localFbBroadcastManager;
        this.f13880d = secureContextHelper;
        this.f13881e = executor;
    }

    public final void m14417G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -88732850);
        super.G();
        this.f13885i.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 302779872, a);
    }

    public final void mo543I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1100247477);
        super.mo543I();
        if (this.f13884h != null) {
            this.f13884h.cancel(true);
            this.f13884h = null;
        }
        this.f13885i.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 374861701, a);
    }

    public final void mo540a(boolean z) {
    }

    public static void m14415a(SecurityMessengerPayPreferences securityMessengerPayPreferences, PaymentPin paymentPin) {
        securityMessengerPayPreferences.f13883g.removeAll();
        Preference preference = new Preference(securityMessengerPayPreferences.f13877a);
        preference.setLayoutResource(2130906154);
        preference.setTitle(2131240307);
        securityMessengerPayPreferences.f13883g.addPreference(preference);
        if (paymentPin.m14261a().isPresent()) {
            preference.setSummary(2131240312);
            preference.setOnPreferenceClickListener(new C15762(securityMessengerPayPreferences));
            return;
        }
        preference.setSummary(2131240313);
        preference.setOnPreferenceClickListener(new C15773(securityMessengerPayPreferences));
    }

    public final ListenableFuture<PaymentPin> mo541b() {
        Object obj;
        if (this.f13884h == null || this.f13884h.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return this.f13884h;
        }
        this.f13884h = this.f13878b.m14283a();
        Futures.a(this.f13884h, new C15751(this), this.f13881e);
        return this.f13884h;
    }
}
