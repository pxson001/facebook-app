package com.facebook.timeline.header;

import com.facebook.common.util.TriState;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: friends_nearby_dashboard_ping_send */
public abstract class IntroCardAbstractInterstitialController<NuxController extends InterstitialController> {
    private final InterstitialManager f11226a;
    public final FbSharedPreferences f11227b;
    public TriState f11228c = TriState.UNSET;

    protected abstract String mo529a();

    public abstract PrefKey mo530b();

    protected abstract InterstitialTrigger mo531c();

    protected abstract Class<NuxController> mo532d();

    public abstract boolean mo533e();

    public IntroCardAbstractInterstitialController(InterstitialManager interstitialManager, FbSharedPreferences fbSharedPreferences) {
        this.f11226a = interstitialManager;
        this.f11227b = fbSharedPreferences;
    }

    public final void m11366f() {
        this.f11226a.a().a(mo529a());
    }

    public final void m11367g() {
        this.f11226a.a().d(mo529a());
        Editor edit = this.f11227b.edit();
        edit.putBoolean(mo530b(), true);
        edit.commit();
        this.f11228c = TriState.YES;
    }

    protected final boolean m11368h() {
        if (this.f11228c == TriState.UNSET) {
            this.f11228c = TriState.valueOf(this.f11227b.a(mo530b(), false));
        }
        return this.f11228c.asBoolean();
    }

    protected final NuxController m11369i() {
        return this.f11226a.a(mo531c(), mo532d());
    }
}
