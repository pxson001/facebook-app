package com.facebook.messaging.payment.util;

import android.media.AudioManager;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.sounds.fb4a.Fb4aSoundUtil;
import javax.inject.Inject;

/* compiled from: extra_transfer_id */
public class PaymentsSoundUtil {
    private Product f15176a;
    private AudioManager f15177b;
    private AppStateManager f15178c;
    private FbSharedPreferences f15179d;
    private FBSoundUtil f15180e;

    public static PaymentsSoundUtil m15530b(InjectorLike injectorLike) {
        return new PaymentsSoundUtil(ProductMethodAutoProvider.b(injectorLike), AudioManagerMethodAutoProvider.b(injectorLike), AppStateManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (FBSoundUtil) Fb4aSoundUtil.a(injectorLike));
    }

    @Inject
    public PaymentsSoundUtil(Product product, AudioManager audioManager, AppStateManager appStateManager, FbSharedPreferences fbSharedPreferences, FBSoundUtil fBSoundUtil) {
        this.f15176a = product;
        this.f15177b = audioManager;
        this.f15178c = appStateManager;
        this.f15179d = fbSharedPreferences;
        this.f15180e = fBSoundUtil;
    }

    public final void m15532a() {
        if (m15531d()) {
            this.f15180e.a(2131165318, 2, 0.235f);
        }
    }

    public static PaymentsSoundUtil m15529a(InjectorLike injectorLike) {
        return m15530b(injectorLike);
    }

    public final void m15533b() {
        if (m15531d()) {
            this.f15180e.a(2131165247, 2, 0.25f);
        }
    }

    public final void m15534c() {
        if (m15531d()) {
            this.f15180e.a(2131165248, 2, 0.25f);
        }
    }

    private boolean m15531d() {
        return this.f15176a == Product.MESSENGER && this.f15179d.a(PaymentUtilPrefKeys.f15175c, true) && this.f15178c.l() && !this.f15177b.isMusicActive() && this.f15177b.getStreamVolume(2) > 0;
    }
}
