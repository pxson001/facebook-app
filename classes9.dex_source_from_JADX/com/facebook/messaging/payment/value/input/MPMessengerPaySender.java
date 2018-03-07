package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.moneypenny.MoneyPennyPlaceOrderResult;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17758;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: exit_flow */
public class MPMessengerPaySender implements MessengerPaySender {
    private PaymentProtocolUtil f15402a;
    private UniqueIdGenerator f15403b;
    private Executor f15404c;
    private AbstractFbErrorReporter f15405d;
    private Context f15406e;
    private Lazy<PaymentDialogsBuilder> f15407f;
    private Provider<User> f15408g;
    private MPMessengerPayLogger f15409h;
    private ListenableFuture<MoneyPennyPlaceOrderResult> f15410i;
    private MessengerPayData f15411j;
    private C17758 f15412k;

    /* compiled from: exit_flow */
    class C17971 extends ResultFutureCallback<MoneyPennyPlaceOrderResult> {
        final /* synthetic */ MPMessengerPaySender f15400a;

        C17971(MPMessengerPaySender mPMessengerPaySender) {
            this.f15400a = mPMessengerPaySender;
        }

        public final void m15720a(ServiceException serviceException) {
            MPMessengerPaySender.m15722a(this.f15400a, serviceException);
        }

        public final void m15721a(Object obj) {
            MPMessengerPaySender.m15726b(this.f15400a);
        }
    }

    /* compiled from: exit_flow */
    class C17982 implements OnClickListener {
        final /* synthetic */ MPMessengerPaySender f15401a;

        C17982(MPMessengerPaySender mPMessengerPaySender) {
            this.f15401a = mPMessengerPaySender;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static MPMessengerPaySender m15725b(InjectorLike injectorLike) {
        return new MPMessengerPaySender(PaymentProtocolUtil.m14937a(injectorLike), UniqueIdGenerator.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedLazy.a(injectorLike, 8039), IdBasedProvider.a(injectorLike, 3596), MPMessengerPayLogger.m15716b(injectorLike));
    }

    @Inject
    public MPMessengerPaySender(PaymentProtocolUtil paymentProtocolUtil, UniqueIdGenerator uniqueIdGenerator, FbErrorReporter fbErrorReporter, Executor executor, Context context, Lazy<PaymentDialogsBuilder> lazy, Provider<User> provider, MPMessengerPayLogger mPMessengerPayLogger) {
        this.f15402a = paymentProtocolUtil;
        this.f15403b = uniqueIdGenerator;
        this.f15405d = fbErrorReporter;
        this.f15404c = executor;
        this.f15406e = context;
        this.f15407f = lazy;
        this.f15408g = provider;
        this.f15409h = mPMessengerPayLogger;
    }

    public final void mo616a(C17758 c17758) {
        this.f15412k = c17758;
    }

    public final void mo614a() {
        if (this.f15410i != null) {
            this.f15410i.cancel(true);
            this.f15410i = null;
        }
    }

    public final void mo615a(Bundle bundle, MessengerPayData messengerPayData) {
        this.f15411j = messengerPayData;
        if (m15724a(this.f15410i)) {
            String a = ((PaymentMethod) this.f15411j.m15763e().get()).a();
            C17971 c17971 = new C17971(this);
            this.f15410i = this.f15402a.m14947a(this.f15406e, this.f15411j.m15765p().f15482f, a, this.f15411j.m15764m(), this.f15403b.a(), this.f15411j.m15765p().f15477a, ((User) this.f15408g.get()).d(), this.f15406e.getString(2131240527));
            Futures.a(this.f15410i, c17971, this.f15404c);
            m15723a("p2p_confirm_send");
        }
    }

    private static boolean m15724a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }

    public static void m15722a(MPMessengerPaySender mPMessengerPaySender, ServiceException serviceException) {
        mPMessengerPaySender.f15412k.m15636a();
        mPMessengerPaySender.m15723a("p2p_send_fail");
        BLog.b("MPMessengerPaySender", "Failed to place order", serviceException);
        mPMessengerPaySender.f15405d.a("MPMessengerPaySender", "Attempted to place order, but received a response with an error", serviceException);
        if (serviceException.errorCode != ErrorCode.API_ERROR) {
            PaymentConnectivityDialogFactory.a(mPMessengerPaySender.f15406e, serviceException);
            return;
        }
        String a = ApiErrorResult.a(((ApiErrorResult) serviceException.result.h()).c());
        mPMessengerPaySender.f15407f.get();
        PaymentDialogsBuilder.m13299a(mPMessengerPaySender.f15406e, mPMessengerPaySender.f15406e.getString(2131240529), a, mPMessengerPaySender.f15406e.getString(2131230726), new C17982(mPMessengerPaySender)).show();
    }

    public static void m15726b(MPMessengerPaySender mPMessengerPaySender) {
        mPMessengerPaySender.m15723a("p2p_send_success");
        Intent intent = new Intent();
        intent.putExtra("show_card_added_nux", mPMessengerPaySender.f15411j.f15467x);
        intent.putExtra("show_pin_nux", mPMessengerPaySender.f15411j.f15466w);
        mPMessengerPaySender.f15412k.m15637a(intent);
    }

    private void m15723a(String str) {
        this.f15409h.m15718a(str, this.f15411j);
    }
}
