package com.facebook.messaging.payment.prefs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceScreen;
import android.view.Menu;
import android.view.MenuItem;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.pin.PaymentPinChangeActivity;
import com.facebook.messaging.payment.pin.PaymentPinDeletionActivity;
import com.facebook.messaging.payment.pin.PaymentPinSyncControllerFragment;
import com.facebook.messaging.payment.pin.PaymentPinSyncControllerFragment.Callback;
import com.google.common.base.Preconditions;

/* compiled from: group_index */
public class PaymentPinPreferenceActivity extends FbPreferenceActivity {
    public AppCompatActivityOverrider f13804a;
    public SecureContextHelper f13805b;

    /* compiled from: group_index */
    class C15601 implements OnPreferenceClickListener {
        final /* synthetic */ PaymentPinPreferenceActivity f13802a;

        C15601(PaymentPinPreferenceActivity paymentPinPreferenceActivity) {
            this.f13802a = paymentPinPreferenceActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f13802a.f13805b.a(preference.getIntent(), 4, this.f13802a);
            return true;
        }
    }

    /* compiled from: group_index */
    public class C15612 implements Callback {
        final /* synthetic */ PaymentPinPreferenceActivity f13803a;

        public C15612(PaymentPinPreferenceActivity paymentPinPreferenceActivity) {
            this.f13803a = paymentPinPreferenceActivity;
        }

        public final void mo531a() {
            this.f13803a.setResult(-1);
            this.f13803a.finish();
        }
    }

    public static void m14369a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PaymentPinPreferenceActivity paymentPinPreferenceActivity = (PaymentPinPreferenceActivity) obj;
        AppCompatActivityOverrider b = AppCompatActivityOverrider.b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        paymentPinPreferenceActivity.f13804a = b;
        paymentPinPreferenceActivity.f13805b = secureContextHelper;
    }

    protected final void m14370a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = PaymentPinPreferenceActivity.class;
        m14369a(this, this);
        a(this.f13804a);
    }

    protected final void m14371c(Bundle bundle) {
        super.c(bundle);
        setContentView(2130906151);
        super.onContentChanged();
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(createPreferenceScreen);
        OnPreferenceClickListener c15601 = new C15601(this);
        Preference preference = new Preference(this);
        preference.setLayoutResource(2130906154);
        preference.setTitle(2131240318);
        Parcelable intent = new Intent(this, PaymentsPreferenceActivity.class);
        Preconditions.checkNotNull(this);
        Intent intent2 = new Intent(this, PaymentPinChangeActivity.class);
        intent2.putExtra("on_activity_finish_launch_intent", intent);
        preference.setIntent(intent2);
        preference.setOnPreferenceClickListener(c15601);
        createPreferenceScreen.addPreference(preference);
        preference = new Preference(this);
        preference.setLayoutResource(2130906154);
        preference.setTitle(2131240319);
        intent = new Intent(this, PaymentsPreferenceActivity.class);
        Preconditions.checkNotNull(this);
        intent2 = new Intent(this, PaymentPinDeletionActivity.class);
        intent2.putExtra("on_activity_finish_launch_intent", intent);
        preference.setIntent(intent2);
        preference.setOnPreferenceClickListener(c15601);
        createPreferenceScreen.addPreference(preference);
        PaymentPinSyncControllerFragment paymentPinSyncControllerFragment = (PaymentPinSyncControllerFragment) c().a("payment_pin_listening_controller_fragment_tag");
        if (paymentPinSyncControllerFragment == null) {
            paymentPinSyncControllerFragment = new PaymentPinSyncControllerFragment();
            c().a().a(paymentPinSyncControllerFragment, "payment_pin_listening_controller_fragment_tag").b();
        }
        paymentPinSyncControllerFragment.f13677g = new C15612(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 4:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }

    public void onContentChanged() {
        if (findViewById(16908298) != null) {
            super.onContentChanged();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
