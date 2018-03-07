package com.facebook.payments.confirmation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.activity.FbFragmentActivity;
import com.google.common.base.Preconditions;

/* compiled from: caller_camp */
public class ConfirmationActivity extends FbFragmentActivity {
    private ConfirmationParams f18588p;

    public static Intent m18613a(Context context, ConfirmationParams confirmationParams) {
        Preconditions.checkNotNull(context);
        Intent intent = new Intent(context, ConfirmationActivity.class);
        intent.putExtra("confirmation_params", confirmationParams);
        return intent;
    }

    protected final void m18614a(Bundle bundle) {
        super.a(bundle);
        this.f18588p = (ConfirmationParams) getIntent().getParcelableExtra("confirmation_params");
    }

    protected final void m18615b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903750);
        FragmentManager kO_ = kO_();
        if (bundle == null && kO_.a("confirmation_fragment_tag") == null) {
            FragmentTransaction a = kO_.a();
            Parcelable parcelable = this.f18588p;
            ConfirmationFragment confirmationFragment = new ConfirmationFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("confirmation_params", parcelable);
            confirmationFragment.g(bundle2);
            a.b(2131560203, confirmationFragment, "confirmation_fragment_tag").b();
        }
    }
}
