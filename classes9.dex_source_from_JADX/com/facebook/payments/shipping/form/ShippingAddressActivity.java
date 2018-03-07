package com.facebook.payments.shipping.form;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.payments.decorator.PaymentsActivityDecorator;
import com.facebook.payments.shipping.model.ShippingParams;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: backstage_upload_fail */
public class ShippingAddressActivity extends FbFragmentActivity {
    @Inject
    public SimpleShippingManager f18913p;
    private ShippingParams f18914q;

    private static <T extends Context> void m18921a(Class<T> cls, T t) {
        m18922a((Object) t, (Context) t);
    }

    public static void m18922a(Object obj, Context context) {
        ((ShippingAddressActivity) obj).f18913p = SimpleShippingManager.m18955a(FbInjector.get(context));
    }

    public static Intent m18920a(Context context, ShippingParams shippingParams) {
        Preconditions.checkNotNull(context);
        Intent intent = new Intent(context, ShippingAddressActivity.class);
        intent.putExtra("extra_shipping_address_params", shippingParams);
        return intent;
    }

    protected final void m18923a(Bundle bundle) {
        Class cls = ShippingAddressActivity.class;
        m18922a((Object) this, (Context) this);
        this.f18914q = (ShippingParams) getIntent().getExtras().getParcelable("extra_shipping_address_params");
        this.f18913p.m18958b(this.f18914q.mo759a().f18987a).mo516a(this);
    }

    protected final void m18924b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130907081);
        if (bundle == null) {
            FragmentTransaction a = kO_().a();
            Parcelable parcelable = this.f18914q;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("extra_shipping_address_params", parcelable);
            ShippingAddressFragment shippingAddressFragment = new ShippingAddressFragment();
            shippingAddressFragment.g(bundle2);
            a.b(2131560203, shippingAddressFragment).b();
        }
        PaymentsActivityDecorator.a(this, this.f18914q.mo759a().f18992f);
    }

    public void finish() {
        super.finish();
        PaymentsActivityDecorator.b(this, this.f18914q.mo759a().f18992f);
    }
}
