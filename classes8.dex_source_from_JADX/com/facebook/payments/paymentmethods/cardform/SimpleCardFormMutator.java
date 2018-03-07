package com.facebook.payments.paymentmethods.cardform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.messaging.dialog.ConfirmActionParams.Builder;
import com.facebook.messaging.payment.connectivity.PaymentConnectivityDialogFactory;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.payments.paymentmethods.cardform.protocol.CardFormProtocolUtil;
import com.facebook.payments.paymentmethods.cardform.protocol.model.AddCreditCardParams;
import com.facebook.payments.paymentmethods.cardform.protocol.model.AddCreditCardResult;
import com.facebook.payments.paymentmethods.cardform.protocol.model.CreditCardProtocolParams;
import com.facebook.payments.paymentmethods.cardform.protocol.model.EditCreditCardParams;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: taggable_gallery */
public class SimpleCardFormMutator implements CardFormComponent {
    public SimplePaymentsComponentCallback f1878a;
    public final Context f1879b;
    public final Executor f1880c;
    public final CardFormProtocolUtil f1881d;

    /* compiled from: taggable_gallery */
    public class C02071 extends ResultFutureCallback<AddCreditCardResult> {
        final /* synthetic */ SimpleCardFormMutator f1875a;

        public C02071(SimpleCardFormMutator simpleCardFormMutator) {
            this.f1875a = simpleCardFormMutator;
        }

        protected final void m2078a(Object obj) {
            this.f1875a.m2086a(((AddCreditCardResult) obj).m2119a());
        }

        protected final void m2077a(ServiceException serviceException) {
            this.f1875a.m2084a(serviceException);
        }
    }

    public final void m2084a(ServiceException serviceException) {
        if (serviceException.errorCode != ErrorCode.API_ERROR) {
            PaymentConnectivityDialogFactory.m1707a(this.f1879b, serviceException);
            return;
        }
        ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.h();
        String a = m2083a(apiErrorResult);
        String a2 = ApiErrorResult.a(apiErrorResult.c());
        if (this.f1878a != null) {
            Builder builder = new Builder(a, this.f1879b.getString(2131230726));
            builder.f1496d = a2;
            builder = builder;
            builder.f1498f = true;
            this.f1878a.mo80a(PaymentsConfirmDialogFragment.m1953b(builder.m1678a()));
        }
    }

    @Inject
    public SimpleCardFormMutator(Context context, Executor executor, CardFormProtocolUtil cardFormProtocolUtil) {
        this.f1879b = context;
        this.f1880c = executor;
        this.f1881d = cardFormProtocolUtil;
    }

    public final void mo85a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f1878a = simplePaymentsComponentCallback;
    }

    public ListenableFuture m2082a(CardFormParams cardFormParams, PaymentsComponentAction paymentsComponentAction) {
        return Futures.a(Boolean.valueOf(true));
    }

    public ListenableFuture m2081a(CardFormParams cardFormParams, CardFormInput cardFormInput) {
        if (cardFormParams.mo78a().f1775d == null) {
            CreditCardProtocolParams.Builder builder = new AddCreditCardParams.Builder();
            builder.f1913a = cardFormInput.f1799a;
            builder = builder;
            builder.f1909c = cardFormInput.f1801c;
            AddCreditCardParams.Builder builder2 = (AddCreditCardParams.Builder) builder;
            builder2.f1910d = cardFormInput.f1802d;
            builder2 = builder2;
            builder2.f1908b = cardFormInput.f1803e;
            builder2 = builder2;
            builder2.f1911e = cardFormInput.f1804f;
            builder2 = builder2;
            builder2.f1907a = cardFormParams.mo78a().f1776e;
            ListenableFuture b = this.f1881d.f1904a.mo71b(new AddCreditCardParams(builder2));
            Futures.a(b, new C02071(this), this.f1880c);
            return b;
        }
        final Object obj = cardFormParams.mo78a().f1775d;
        builder = new EditCreditCardParams.Builder();
        builder.f1925a = obj.mo94a();
        builder = builder;
        builder.f1909c = cardFormInput.f1801c;
        EditCreditCardParams.Builder builder3 = (EditCreditCardParams.Builder) builder;
        builder3.f1910d = cardFormInput.f1802d;
        builder3 = builder3;
        builder3.f1908b = cardFormInput.f1803e;
        builder3 = builder3;
        builder3.f1911e = cardFormInput.f1804f;
        builder3 = builder3;
        builder3.f1907a = cardFormParams.mo78a().f1776e;
        b = this.f1881d.f1905b.m1936c(new EditCreditCardParams(builder3));
        Futures.a(b, new ResultFutureCallback<Void>(this) {
            final /* synthetic */ SimpleCardFormMutator f1877b;

            protected final void m2080a(Object obj) {
                this.f1877b.m2086a(obj.mo94a());
            }

            protected final void m2079a(ServiceException serviceException) {
                this.f1877b.m2084a(serviceException);
            }
        }, this.f1880c);
        return b;
    }

    protected final void m2086a(String str) {
        if (this.f1878a != null) {
            Parcelable intent = new Intent();
            intent.putExtra("encoded_credential_id", str);
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_activity_result_data", intent);
            this.f1878a.mo79a(new PaymentsComponentAction(Action.FINISH_ACTIVITY, bundle));
        }
    }

    protected String m2083a(ApiErrorResult apiErrorResult) {
        return this.f1879b.getString(2131238332);
    }
}
