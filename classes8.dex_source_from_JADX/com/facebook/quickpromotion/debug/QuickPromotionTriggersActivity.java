package com.facebook.quickpromotion.debug;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import javax.inject.Inject;

/* compiled from: redspace_tab_badge */
public class QuickPromotionTriggersActivity extends FbPreferenceActivity {
    @Inject
    InterstitialManager f4668a;
    @Inject
    SecureContextHelper f4669b;

    /* compiled from: redspace_tab_badge */
    class C06232 implements OnClickListener {
        final /* synthetic */ QuickPromotionTriggersActivity f4667a;

        C06232(QuickPromotionTriggersActivity quickPromotionTriggersActivity) {
            this.f4667a = quickPromotionTriggersActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    private static <T extends Context> void m4513a(Class<T> cls, T t) {
        m4514a((Object) t, (Context) t);
    }

    public static void m4514a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((QuickPromotionTriggersActivity) obj).m4510a(InterstitialManager.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    public final void m4516c(Bundle bundle) {
        super.c(bundle);
        Class cls = QuickPromotionTriggersActivity.class;
        m4514a((Object) this, (Context) this);
        m4509a();
    }

    private void m4509a() {
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Triggers");
        createPreferenceScreen.addPreference(preferenceCategory);
        for (final Action action : Action.values()) {
            Preference preference = new Preference(this);
            preference.setTitle(action.name());
            preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                final /* synthetic */ QuickPromotionTriggersActivity f4666b;

                public boolean onPreferenceClick(Preference preference) {
                    this.f4666b.m4511a(action);
                    return false;
                }
            });
            createPreferenceScreen.addPreference(preference);
        }
        setPreferenceScreen(createPreferenceScreen);
    }

    private void m4510a(InterstitialManager interstitialManager, SecureContextHelper secureContextHelper) {
        this.f4668a = interstitialManager;
        this.f4669b = secureContextHelper;
    }

    private void m4511a(Action action) {
        InterstitialIntentController interstitialIntentController = (InterstitialIntentController) this.f4668a.a(new InterstitialTrigger(action), InterstitialIntentController.class);
        if (interstitialIntentController == null) {
            m4515a("Empty Trigger", "There are no eligible promotions associated with this trigger.");
            return;
        }
        Intent a = interstitialIntentController.a(this);
        if (a == null) {
            m4515a("Null Intent", "There was a QP interstitial but the intent was null.");
            return;
        }
        try {
            this.f4669b.a(a, this);
        } catch (ActivityNotFoundException e) {
            m4515a("Invalid Intent from Interstitial Controller", "The interstitial controller is broken and returning an invalid intent.");
        }
    }

    private void m4515a(String str, String str2) {
        new Builder(this).a(str).b(str2).a("Close", new C06232(this)).b();
    }
}
