package com.facebook.messaging.payment.awareness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.awareness.PaymentAwarenessFragment.Listener;
import javax.annotation.Nullable;

/* compiled from: internal_attribution_type */
public class PaymentAwarenessActivity extends FbFragmentActivity {

    /* compiled from: internal_attribution_type */
    class C14401 implements Listener {
        final /* synthetic */ PaymentAwarenessActivity f12809a;

        C14401(PaymentAwarenessActivity paymentAwarenessActivity) {
            this.f12809a = paymentAwarenessActivity;
        }

        public final void mo508a() {
            this.f12809a.setResult(-1);
            this.f12809a.finish();
        }
    }

    protected final void m13149a(Bundle bundle) {
        new MessengerMaterialThemeUtil(this, 2131625175).a();
        Class cls = PaymentAwarenessActivity.class;
        FbInjector.get(this);
    }

    protected final void m13151b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130904413);
        if (kO_().a(2131560203) == null) {
            kO_().a().a(2131560203, PaymentAwarenessFragment.m13152a((PaymentAwarenessMode) getIntent().getSerializableExtra("payment_awareness_mode"))).b();
        }
    }

    public final void m13150a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof PaymentAwarenessFragment) {
            ((PaymentAwarenessFragment) fragment).f12812a = new C14401(this);
        }
    }
}
