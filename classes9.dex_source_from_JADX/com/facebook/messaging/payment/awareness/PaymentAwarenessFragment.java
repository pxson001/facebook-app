package com.facebook.messaging.payment.awareness;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: interstitialInfo */
public class PaymentAwarenessFragment extends FbFragment {
    public Listener f12812a;

    /* compiled from: interstitialInfo */
    public interface Listener {
        void mo508a();
    }

    /* compiled from: interstitialInfo */
    public class C14411 {
        public final /* synthetic */ PaymentAwarenessFragment f12810a;

        C14411(PaymentAwarenessFragment paymentAwarenessFragment) {
            this.f12810a = paymentAwarenessFragment;
        }
    }

    public static PaymentAwarenessFragment m13152a(PaymentAwarenessMode paymentAwarenessMode) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("payment_awareness_mode", paymentAwarenessMode);
        PaymentAwarenessFragment paymentAwarenessFragment = new PaymentAwarenessFragment();
        paymentAwarenessFragment.g(bundle);
        return paymentAwarenessFragment;
    }

    public final void m13156c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PaymentAwarenessFragment.class;
        FbInjector.get(getContext());
    }

    public final View m13154a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 995844986);
        View inflate = layoutInflater.inflate(2130903324, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1696367118, a);
        return inflate;
    }

    public final void m13155a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        PaymentAwarenessView b = m13153b((PaymentAwarenessMode) this.s.getSerializable("payment_awareness_mode"));
        b.setListener(new C14411(this));
        ((ViewGroup) view.findViewById(2131559223)).addView((View) b);
    }

    private PaymentAwarenessView m13153b(PaymentAwarenessMode paymentAwarenessMode) {
        PaymentAwarenessView defaultPaymentAwarenessView;
        DefaultPaymentAwarenessViewParamsBuilder newBuilder;
        switch (paymentAwarenessMode) {
            case GROUP_COMMERCE:
                defaultPaymentAwarenessView = new DefaultPaymentAwarenessView(getContext());
                newBuilder = DefaultPaymentAwarenessViewParams.newBuilder();
                newBuilder.f12796a = b(2131241063);
                newBuilder = newBuilder;
                newBuilder.f12798c = new PaymentAwarenessRow(2131241064, 2130841205);
                newBuilder = newBuilder;
                newBuilder.f12799d = new PaymentAwarenessRow(2131241065, 2130840384);
                newBuilder = newBuilder;
                newBuilder.f12800e = new PaymentAwarenessRow(2131241066, 2130838384);
                newBuilder = newBuilder;
                newBuilder.f12801f = 2131241067;
                newBuilder = newBuilder;
                newBuilder.f12802g = 2130904645;
                defaultPaymentAwarenessView.setViewParams(newBuilder.m13140h());
                return defaultPaymentAwarenessView;
            case ORION_SEND:
                defaultPaymentAwarenessView = new DefaultPaymentAwarenessView(getContext());
                newBuilder = DefaultPaymentAwarenessViewParams.newBuilder();
                newBuilder.f12796a = b(2131241056);
                newBuilder = newBuilder;
                newBuilder.f12797b = b(2131241057);
                newBuilder = newBuilder;
                newBuilder.f12798c = new PaymentAwarenessRow(2131241058, 2130838043);
                newBuilder = newBuilder;
                newBuilder.f12799d = new PaymentAwarenessRow(2131241059, 2130840384);
                newBuilder = newBuilder;
                newBuilder.f12800e = new PaymentAwarenessRow(2131241060, 2130838384);
                newBuilder = newBuilder;
                newBuilder.f12801f = 2131241062;
                newBuilder = newBuilder;
                newBuilder.f12802g = 2130905929;
                defaultPaymentAwarenessView.setViewParams(newBuilder.m13140h());
                return defaultPaymentAwarenessView;
            default:
                throw new IllegalArgumentException("Invalid PaymentAwarenessMode provided: " + paymentAwarenessMode);
        }
    }
}
