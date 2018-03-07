package com.facebook.messaging.payment.pin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: has_payment */
public class PaymentPinSyncControllerFragment extends FbFragment {
    public static final Class<?> f13671a = PaymentPinSyncControllerFragment.class;
    public LocalFbBroadcastManager f13672b;
    public PaymentPinProtocolUtil f13673c;
    public Executor f13674d;
    public SelfRegistrableReceiverImpl f13675e;
    public ListenableFuture<PaymentPin> f13676f;
    public Callback f13677g;

    /* compiled from: has_payment */
    public interface Callback {
        void mo531a();
    }

    /* compiled from: has_payment */
    public class C15381 implements ActionReceiver {
        final /* synthetic */ PaymentPinSyncControllerFragment f13669a;

        public C15381(PaymentPinSyncControllerFragment paymentPinSyncControllerFragment) {
            this.f13669a = paymentPinSyncControllerFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            Object obj;
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 925221794);
            PaymentPinSyncControllerFragment paymentPinSyncControllerFragment = this.f13669a;
            if (paymentPinSyncControllerFragment.f13676f == null || paymentPinSyncControllerFragment.f13676f.isDone()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                paymentPinSyncControllerFragment.f13676f = paymentPinSyncControllerFragment.f13673c.m14283a();
                Futures.a(paymentPinSyncControllerFragment.f13676f, new C15392(paymentPinSyncControllerFragment), paymentPinSyncControllerFragment.f13674d);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -36165023, a);
        }
    }

    /* compiled from: has_payment */
    public class C15392 implements FutureCallback<PaymentPin> {
        final /* synthetic */ PaymentPinSyncControllerFragment f13670a;

        public C15392(PaymentPinSyncControllerFragment paymentPinSyncControllerFragment) {
            this.f13670a = paymentPinSyncControllerFragment;
        }

        public void onSuccess(Object obj) {
            if (!((PaymentPin) obj).m14261a().isPresent() && this.f13670a.f13677g != null) {
                this.f13670a.f13677g.mo531a();
            }
        }

        public void onFailure(Throwable th) {
            BLog.b(PaymentPinSyncControllerFragment.f13671a, "Fetch of payment pin failed.");
        }
    }

    public static void m14238a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PaymentPinSyncControllerFragment paymentPinSyncControllerFragment = (PaymentPinSyncControllerFragment) obj;
        LocalFbBroadcastManager a = LocalFbBroadcastManager.a(injectorLike);
        PaymentPinProtocolUtil a2 = PaymentPinProtocolUtil.m14279a(injectorLike);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        paymentPinSyncControllerFragment.f13672b = a;
        paymentPinSyncControllerFragment.f13673c = a2;
        paymentPinSyncControllerFragment.f13674d = executor;
    }

    public final void m14241c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PaymentPinSyncControllerFragment.class;
        m14238a(this, getContext());
        this.f13675e = this.f13672b.a().a("com.facebook.messaging.payment.ACTION_PIN_UPDATED", new C15381(this)).a();
    }

    public final void m14239G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1171633147);
        super.G();
        this.f13675e.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -135352655, a);
    }

    public final void m14240I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1799538064);
        super.I();
        this.f13675e.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1977024832, a);
    }
}
