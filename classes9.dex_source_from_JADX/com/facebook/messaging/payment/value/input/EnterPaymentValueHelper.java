package com.facebook.messaging.payment.value.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.inject.Assisted;
import com.facebook.messaging.business.nativesignup.view.BusinessCreateAccountFragment;
import com.facebook.messaging.business.nativesignup.view.BusinessCreateAccountFragment.C10276;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder.MultiOptionsDialogListener;
import com.facebook.messaging.payment.method.verification.PaymentCardsFetcher;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController.ResultCallback;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationParams;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationParams.Builder;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.VerificationFollowUpAction;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_is_from_qp */
public class EnterPaymentValueHelper {
    public static final String f15292a = EnterPaymentValueHelper.class.getSimpleName();
    @Nullable
    public C10276 f15293b;
    private final Fragment f15294c;
    private final Executor f15295d;
    public final AbstractFbErrorReporter f15296e;
    public final PaymentCardsFetcher f15297f;
    private final PaymentDialogsBuilder f15298g;
    public final Context f15299h;
    public final Resources f15300i;
    public final PaymentMethodVerificationController f15301j;
    private final boolean f15302k;
    public ListenableFuture<ImmutableList<PaymentCard>> f15303l;

    /* compiled from: extra_is_from_qp */
    class C17771 implements FutureCallback<ImmutableList<PaymentCard>> {
        final /* synthetic */ EnterPaymentValueHelper f15288a;

        C17771(EnterPaymentValueHelper enterPaymentValueHelper) {
            this.f15288a = enterPaymentValueHelper;
        }

        public void onSuccess(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            if (this.f15288a.f15293b != null) {
                C10276 c10276 = this.f15288a.f15293b;
                BusinessCreateAccountFragment.m9204a(c10276.f8959a, false);
                c10276.f8959a.ao = immutableList;
                if (c10276.f8959a.ap == null) {
                    BusinessCreateAccountFragment.m9202a(c10276.f8959a, (PaymentCard) Iterables.a(immutableList, null));
                }
            }
        }

        public void onFailure(Throwable th) {
            this.f15288a.f15296e.a(EnterPaymentValueHelper.f15292a, "Failed to fetch PaymentCards for sending money.");
            if (this.f15288a.f15293b != null) {
                C10276 c10276 = this.f15288a.f15293b;
                BusinessCreateAccountFragment.m9204a(c10276.f8959a, false);
                c10276.f8959a.f8970h.a(SoftError.a("BusinessCreateAccountFragment", "Failed to fetch payment cards").g());
            }
        }
    }

    /* compiled from: extra_is_from_qp */
    class C17782 implements ResultCallback {
        final /* synthetic */ EnterPaymentValueHelper f15289a;

        C17782(EnterPaymentValueHelper enterPaymentValueHelper) {
            this.f15289a = enterPaymentValueHelper;
        }

        public final void mo544a() {
            this.f15289a.f15296e.b(EnterPaymentValueHelper.f15292a, "A card already verified event received when adding a new card");
        }

        public final void mo545a(PaymentCard paymentCard, @Nullable VerificationFollowUpAction verificationFollowUpAction, boolean z, boolean z2) {
            if (this.f15289a.f15293b != null) {
                C10276 c10276 = this.f15289a.f15293b;
                BusinessCreateAccountFragment.m9202a(c10276.f8959a, paymentCard);
                c10276.f8959a.an.m15662a();
            }
        }

        public final void mo546b() {
            this.f15289a.m15662a();
        }

        public final void mo547c() {
        }
    }

    /* compiled from: extra_is_from_qp */
    public class C17793 implements MultiOptionsDialogListener {
        final /* synthetic */ ImmutableList f15290a;
        final /* synthetic */ EnterPaymentValueHelper f15291b;

        public C17793(EnterPaymentValueHelper enterPaymentValueHelper, ImmutableList immutableList) {
            this.f15291b = enterPaymentValueHelper;
            this.f15290a = immutableList;
        }

        public final void mo520a() {
            EnterPaymentValueHelper.m15661c(this.f15291b, this.f15290a);
        }

        public final void mo521a(int i) {
            if (this.f15291b.f15293b != null) {
                C10276 c10276 = this.f15291b.f15293b;
                PaymentCardsFetcher paymentCardsFetcher = this.f15291b.f15297f;
                BusinessCreateAccountFragment.m9202a(c10276.f8959a, (PaymentCard) PaymentCardsFetcher.m13432c(this.f15290a).get(i));
            }
        }
    }

    @Inject
    public EnterPaymentValueHelper(@Assisted Fragment fragment, @Assisted boolean z, Executor executor, AbstractFbErrorReporter abstractFbErrorReporter, PaymentCardsFetcher paymentCardsFetcher, PaymentDialogsBuilder paymentDialogsBuilder, Context context, Resources resources, PaymentMethodVerificationController paymentMethodVerificationController) {
        this.f15294c = fragment;
        this.f15302k = z;
        this.f15295d = executor;
        this.f15296e = abstractFbErrorReporter;
        this.f15297f = paymentCardsFetcher;
        this.f15298g = paymentDialogsBuilder;
        this.f15299h = context;
        this.f15300i = resources;
        this.f15301j = paymentMethodVerificationController;
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public final void m15662a() {
        this.f15303l = this.f15297f.m13434a();
        Futures.a(this.f15303l, new C17771(this), this.f15295d);
    }

    public static void m15661c(EnterPaymentValueHelper enterPaymentValueHelper, ImmutableList immutableList) {
        ResultCallback c17782 = new C17782(enterPaymentValueHelper);
        Builder newBuilder = PaymentMethodVerificationParams.newBuilder();
        newBuilder.f13172b = immutableList;
        newBuilder = newBuilder;
        newBuilder.f13175e = PaymentFlowType.MESSENGER_COMMERCE;
        newBuilder = newBuilder;
        newBuilder.f13173c = enterPaymentValueHelper.f15294c;
        newBuilder = newBuilder;
        newBuilder.f13181k = enterPaymentValueHelper.f15302k;
        enterPaymentValueHelper.f15301j.m13455a(newBuilder.m13461a(), c17782);
    }
}
