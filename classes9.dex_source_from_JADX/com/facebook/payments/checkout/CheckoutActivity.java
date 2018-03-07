package com.facebook.payments.checkout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.decorator.PaymentsActivityDecorator;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: cat */
public class CheckoutActivity extends FbFragmentActivity {
    @Inject
    public PaymentsActivityDecorator f18451p;
    @Inject
    public SimpleCheckoutManager f18452q;
    private CheckoutParams f18453r;

    private static <T extends Context> void m18456a(Class<T> cls, T t) {
        m18457a((Object) t, (Context) t);
    }

    public static void m18457a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        CheckoutActivity checkoutActivity = (CheckoutActivity) obj;
        PaymentsActivityDecorator b = PaymentsActivityDecorator.b(injectorLike);
        SimpleCheckoutManager a = SimpleCheckoutManager.m18489a(injectorLike);
        checkoutActivity.f18451p = b;
        checkoutActivity.f18452q = a;
    }

    public static Intent m18455a(Context context, CheckoutParams checkoutParams) {
        Preconditions.checkNotNull(context);
        Intent intent = new Intent(context, CheckoutActivity.class);
        intent.putExtra("checkout_params", checkoutParams);
        return intent;
    }

    protected final void m18459a(Bundle bundle) {
        SimpleCheckoutStyleRenderer simpleCheckoutStyleRenderer;
        Class cls = CheckoutActivity.class;
        m18457a((Object) this, (Context) this);
        this.f18453r = (CheckoutParams) getIntent().getParcelableExtra("checkout_params");
        this.f18451p.a(this, this.f18453r.mo627a().f18462d.b);
        SimpleCheckoutManager simpleCheckoutManager = this.f18452q;
        CheckoutStyle checkoutStyle = this.f18453r.mo627a().f18459a;
        if (simpleCheckoutManager.f18488a.containsKey(checkoutStyle)) {
            simpleCheckoutStyleRenderer = (SimpleCheckoutStyleRenderer) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(checkoutStyle)).f15732j.get();
        } else {
            simpleCheckoutStyleRenderer = (SimpleCheckoutStyleRenderer) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(CheckoutStyle.SIMPLE)).f15732j.get();
        }
        simpleCheckoutStyleRenderer.mo632a(this);
    }

    protected final void m18460b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130904178);
        this.f18451p.b(this, this.f18453r.mo627a().f18462d.b);
        if (bundle == null) {
            m18458i();
        }
        PaymentsActivityDecorator.a(this, this.f18453r.mo627a().f18462d);
    }

    private void m18458i() {
        if (kO_().a("checkout_fragment") == null) {
            FragmentTransaction a = kO_().a();
            Parcelable parcelable = this.f18453r;
            CheckoutFragment checkoutFragment = new CheckoutFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("checkout_params", parcelable);
            checkoutFragment.g(bundle);
            a.b(2131558429, checkoutFragment, "checkout_fragment").b();
        }
    }

    public void finish() {
        super.finish();
        PaymentsActivityDecorator.b(this, this.f18453r.mo627a().f18462d);
    }
}
