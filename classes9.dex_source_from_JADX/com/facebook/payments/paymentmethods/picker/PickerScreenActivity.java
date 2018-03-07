package com.facebook.payments.paymentmethods.picker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.decorator.PaymentsActivityDecorator;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UriMatchPatterns
/* compiled from: bookmark_sync_status */
public class PickerScreenActivity extends FbFragmentActivity {
    @Inject
    public PaymentsActivityDecorator f18769p;
    @Inject
    public SimplePickerScreenManager f18770q;
    private PickerScreenParams f18771r;

    private static <T extends Context> void m18781a(Class<T> cls, T t) {
        m18782a((Object) t, (Context) t);
    }

    public static void m18782a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PickerScreenActivity pickerScreenActivity = (PickerScreenActivity) obj;
        PaymentsActivityDecorator b = PaymentsActivityDecorator.b(injectorLike);
        SimplePickerScreenManager a = SimplePickerScreenManager.m18833a(injectorLike);
        pickerScreenActivity.f18769p = b;
        pickerScreenActivity.f18770q = a;
    }

    public static Intent m18779a(Context context, PickerScreenParams pickerScreenParams) {
        Preconditions.checkNotNull(context);
        Intent intent = new Intent(context, PickerScreenActivity.class);
        m18780a(intent, pickerScreenParams);
        return intent;
    }

    public static void m18780a(Intent intent, PickerScreenParams pickerScreenParams) {
        intent.putExtra("extra_picker_screen_param", pickerScreenParams);
    }

    public static PaymentMethod m18783b(Intent intent) {
        return (PaymentMethod) intent.getParcelableExtra("selected_payment_method");
    }

    protected final void m18784a(Bundle bundle) {
        super.a(bundle);
        Class cls = PickerScreenActivity.class;
        m18782a((Object) this, (Context) this);
        this.f18771r = (PickerScreenParams) getIntent().getExtras().getParcelable("extra_picker_screen_param");
        this.f18769p.a(this, this.f18771r.mo743a().f18784a.f18812a.b);
        this.f18770q.m18835a(this.f18771r.mo743a().f18786c).mo656a(this, this.f18771r);
    }

    protected final void m18785b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130904178);
        this.f18769p.b(this, this.f18771r.mo743a().f18784a.f18812a.b);
        if (bundle == null) {
            FragmentTransaction a = kO_().a();
            Parcelable parcelable = this.f18771r;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("extra_picker_screen_param", parcelable);
            PickerScreenFragment pickerScreenFragment = new PickerScreenFragment();
            pickerScreenFragment.g(bundle2);
            a.b(2131558429, pickerScreenFragment, "picker_screen_fragment_tag").b();
        }
        PaymentsActivityDecorator.a(this, this.f18771r.mo743a().f18784a.f18812a);
    }

    public void onBackPressed() {
        Fragment a = kO_().a("picker_screen_fragment_tag");
        if (a != null && (a instanceof CanHandleBackPressed)) {
            ((CanHandleBackPressed) a).O_();
        }
        super.onBackPressed();
    }

    public void finish() {
        super.finish();
        PaymentsActivityDecorator.b(this, this.f18771r.mo743a().f18784a.f18812a);
    }
}
