package com.facebook.messaging.payment.prefs.receipts.nux;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.annotations.ViewerContextUser;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.dialog.ConfirmActionDialogFragment;
import com.facebook.messaging.dialog.ConfirmActionParams.Builder;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.messaging.payment.method.input.TransactionPaymentMethodSecurityInfo.C14592.C14581;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.transactions.DeclinePaymentParams;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: gametime_match_tab_switch */
public class DeclinePaymentDialogFragment extends ConfirmActionDialogFragment {
    public static final Class<?> aq = DeclinePaymentDialogFragment.class;
    @Inject
    @ViewerContextUser
    public Provider<User> am;
    @Inject
    public PaymentProtocolUtil an;
    @Inject
    @ForUiThread
    public Executor ao;
    @Inject
    public AnalyticsLogger ap;
    public C14581 ar;

    /* compiled from: gametime_match_tab_switch */
    public class C16201 extends OperationResultFutureCallback {
        final /* synthetic */ DeclinePaymentDialogFragment f14285a;

        protected final void m14708a(ServiceException serviceException) {
            Class cls = DeclinePaymentDialogFragment.aq;
            if (serviceException.errorCode == ErrorCode.CONNECTION_FAILURE) {
                PaymentConnectivityDialogFactory.a(this.f14285a.getContext());
            }
        }

        protected final void m14709a(Object obj) {
            Class cls = DeclinePaymentDialogFragment.aq;
            if (this.f14285a.ar != null) {
                C14581 c14581 = this.f14285a.ar;
                c14581.f13077a.f13080c.a.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY));
            }
        }

        public C16201(DeclinePaymentDialogFragment declinePaymentDialogFragment) {
            this.f14285a = declinePaymentDialogFragment;
        }
    }

    public static void m14711a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        DeclinePaymentDialogFragment declinePaymentDialogFragment = (DeclinePaymentDialogFragment) obj;
        Provider a = IdBasedProvider.a(injectorLike, 3596);
        PaymentProtocolUtil a2 = PaymentProtocolUtil.m14937a(injectorLike);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        AnalyticsLogger a3 = AnalyticsLoggerMethodAutoProvider.a(injectorLike);
        declinePaymentDialogFragment.am = a;
        declinePaymentDialogFragment.an = a2;
        declinePaymentDialogFragment.ao = executor;
        declinePaymentDialogFragment.ap = a3;
    }

    public static DeclinePaymentDialogFragment m14710a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("sender_name", str);
        bundle.putString("transaction_id", str2);
        DeclinePaymentDialogFragment declinePaymentDialogFragment = new DeclinePaymentDialogFragment();
        declinePaymentDialogFragment.g(bundle);
        return declinePaymentDialogFragment;
    }

    public final void m14712a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1141732063);
        super.a(bundle);
        Class cls = DeclinePaymentDialogFragment.class;
        m14711a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -768588085, a);
    }

    public final Dialog m14714c(Bundle bundle) {
        String string = this.s.getString("sender_name");
        Builder builder = new Builder(b(2131240368), b(2131240370));
        builder.d = a(2131240369, new Object[]{string});
        Builder builder2 = builder;
        builder2.f = false;
        this.am = builder2.a();
        return super.c(bundle);
    }

    public final void m14713a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        AnalyticsLogger analyticsLogger = this.ap;
        P2pPaymentsLogEvent.Builder d = P2pPaymentsLogEvent.d("p2p_decline_payment_initiate", "p2p_receive");
        d.a.b("parent_activity_name", o().getComponentName().getShortClassName());
        analyticsLogger.a(d.a);
    }

    protected final void aq() {
        super.aq();
        this.ap.a(P2pPaymentsLogEvent.d("p2p_decline_payment_confirm", "p2p_receive").a);
        PaymentProtocolUtil paymentProtocolUtil = this.an;
        Context context = getContext();
        String str = ((User) this.am.get()).a;
        String string = this.s.getString("transaction_id");
        String b = b(2131240429);
        Bundle bundle = new Bundle();
        bundle.putParcelable(DeclinePaymentParams.f14734a, new DeclinePaymentParams(str, string));
        Futures.a(BlueServiceOperationFactoryDetour.a(paymentProtocolUtil.f14533a, "decline_payment", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(paymentProtocolUtil.getClass()), 42997764).a(new DialogBasedProgressIndicator(context, b)).a(), new C16201(this), this.ao);
    }
}
