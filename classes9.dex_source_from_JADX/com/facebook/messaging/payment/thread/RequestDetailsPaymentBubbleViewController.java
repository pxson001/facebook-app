package com.facebook.messaging.payment.thread;

import android.content.res.Resources;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: failed_fetch_pinned_threads_communication */
public class RequestDetailsPaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleDetailsView> {
    private static final Class<?> f15038a = RequestDetailsPaymentBubbleViewController.class;
    private final Resources f15039b;
    private final PaymentRequestUtil f15040c;

    /* compiled from: failed_fetch_pinned_threads_communication */
    /* synthetic */ class C17331 {
        static final /* synthetic */ int[] f15037a = new int[GraphQLPeerToPeerPaymentRequestStatus.values().length];

        static {
            try {
                f15037a[GraphQLPeerToPeerPaymentRequestStatus.INITED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15037a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_INITED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15037a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15037a[GraphQLPeerToPeerPaymentRequestStatus.DECLINED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15037a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15037a[GraphQLPeerToPeerPaymentRequestStatus.CANCELED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15037a[GraphQLPeerToPeerPaymentRequestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public final void mo600a(View view, PaymentViewParams paymentViewParams, Listener listener) {
        PaymentBubbleDetailsView paymentBubbleDetailsView = (PaymentBubbleDetailsView) view;
        PaymentRequestModel paymentRequestModel = paymentViewParams.f15023d;
        paymentBubbleDetailsView.setMemoText(paymentRequestModel.m13814g());
        paymentBubbleDetailsView.setStatusText(m15414a(paymentRequestModel));
    }

    @Inject
    public RequestDetailsPaymentBubbleViewController(Resources resources, PaymentRequestUtil paymentRequestUtil) {
        this.f15039b = resources;
        this.f15040c = paymentRequestUtil;
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        PaymentRequestModel paymentRequestModel = paymentViewParams.f15023d;
        if (paymentRequestModel == null) {
            return false;
        }
        boolean z;
        if (StringUtil.c(paymentRequestModel.m13814g())) {
            z = false;
        } else {
            z = true;
        }
        boolean z2;
        if (StringUtil.a(m15414a(paymentRequestModel))) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z || r3) {
            return true;
        }
        return false;
    }

    @Nullable
    private String m15414a(PaymentRequestModel paymentRequestModel) {
        String d = this.f15040c.c.d(1000 * paymentRequestModel.m13818m());
        switch (C17331.f15037a[paymentRequestModel.lx_().ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (this.f15040c.d(paymentRequestModel)) {
                    return null;
                }
                return this.f15039b.getString(2131240331);
            case 4:
                return this.f15039b.getString(2131240522, new Object[]{d});
            case 5:
                return this.f15039b.getString(2131240523, new Object[]{d});
            case 6:
                return this.f15039b.getString(2131240521, new Object[]{d});
            default:
                paymentRequestModel.lx_();
                return null;
        }
    }
}
