package com.facebook.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: profile_page */
public class InterstitialStartHelper {
    private final InterstitialManager f8839a;
    private final SecureContextHelper f8840b;

    public static InterstitialStartHelper m13670b(InjectorLike injectorLike) {
        return new InterstitialStartHelper(InterstitialManager.m8082a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike));
    }

    @Inject
    public InterstitialStartHelper(InterstitialManager interstitialManager, SecureContextHelper secureContextHelper) {
        this.f8839a = interstitialManager;
        this.f8840b = secureContextHelper;
    }

    public final boolean m13673a(Activity activity, InterstitialTrigger interstitialTrigger) {
        InterstitialController a = this.f8839a.m8117a(interstitialTrigger);
        if (a == null) {
            return false;
        }
        this.f8839a.m8121a().a(a.mo1173b());
        m13669a(activity, a, interstitialTrigger, false, null);
        return true;
    }

    public static InterstitialStartHelper m13668a(InjectorLike injectorLike) {
        return m13670b(injectorLike);
    }

    public final void m13671a(Context context, InterstitialTrigger interstitialTrigger) {
        m13672a(context, interstitialTrigger, InterstitialController.class, null);
    }

    public final <T extends InterstitialController> void m13672a(Context context, InterstitialTrigger interstitialTrigger, Class<T> cls, @Nullable Object obj) {
        InterstitialController a = this.f8839a.m8118a(interstitialTrigger, (Class) cls);
        if (a != null) {
            this.f8839a.m8121a().a(a.mo1173b());
            m13669a(context, a, interstitialTrigger, true, obj);
        }
    }

    private void m13669a(Context context, InterstitialController interstitialController, InterstitialTrigger interstitialTrigger, boolean z, @Nullable Object obj) {
        if (interstitialController instanceof InterstitialActionController) {
            ((InterstitialActionController) interstitialController).mo1752a(context, obj);
        } else if (interstitialController instanceof InterstitialIntentController) {
            Intent a = ((InterstitialIntentController) interstitialController).mo1687a(context);
            if (z) {
                a.setFlags(268435456 | a.getFlags());
            }
            this.f8840b.mo662a(a, context);
        } else {
            throw new RuntimeException("Unknown InterstitialController: " + interstitialController);
        }
    }
}
