package com.facebook.payments.paymentmethods.cardform;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.inject.FbInjector;
import com.facebook.payments.decorator.PaymentsActivityDecorator;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: target_actor_type */
public class CardFormActivity extends FbFragmentActivity {
    @Inject
    public SimpleCardFormManager f1765p;
    private CardFormParams f1766q;

    private static <T extends Context> void m1963a(Class<T> cls, T t) {
        m1964a((Object) t, (Context) t);
    }

    public static void m1964a(Object obj, Context context) {
        ((CardFormActivity) obj).f1765p = SimpleCardFormManager.m2071a(FbInjector.get(context));
    }

    public static Intent m1962a(Context context, CardFormParams cardFormParams) {
        Preconditions.checkNotNull(context);
        Intent intent = new Intent(context, CardFormActivity.class);
        intent.putExtra("card_form_params", cardFormParams);
        return intent;
    }

    protected final void m1966a(Bundle bundle) {
        Class cls = CardFormActivity.class;
        m1964a((Object) this, (Context) this);
        this.f1766q = (CardFormParams) getIntent().getParcelableExtra("card_form_params");
        this.f1765p.m2075c(this.f1766q.mo78a().f1772a).m2061a((Context) this);
    }

    protected final void m1967b(Bundle bundle) {
        super.b(bundle);
        getWindow().addFlags(8192);
        setContentView(2130903500);
        if (bundle == null) {
            m1965i();
        }
        PaymentsActivityDecorator.m1937a((Activity) this, this.f1766q.mo78a().f1774c.f1855c);
    }

    private void m1965i() {
        if (kO_().a("card_form_fragment") == null) {
            FragmentTransaction a = kO_().a();
            Parcelable parcelable = this.f1766q;
            CardFormFragment cardFormFragment = new CardFormFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("card_form_params", parcelable);
            cardFormFragment.g(bundle);
            a.b(2131560203, cardFormFragment, "card_form_fragment").b();
        }
    }

    public void onBackPressed() {
        Fragment a = kO_().a("card_form_fragment");
        if (a != null && (a instanceof CanHandleBackPressed)) {
            ((CanHandleBackPressed) a).O_();
        }
        super.onBackPressed();
    }

    public void finish() {
        super.finish();
        PaymentsActivityDecorator.m1939b((Activity) this, this.f1766q.mo78a().f1774c.f1855c);
    }
}
