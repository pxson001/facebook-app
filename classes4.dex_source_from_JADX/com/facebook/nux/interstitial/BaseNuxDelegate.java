package com.facebook.nux.interstitial;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.nux.NuxHistory;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.fasterxml.jackson.databind.ObjectMapper;

/* compiled from: profile_types */
public abstract class BaseNuxDelegate {
    private final ObjectMapper f4095a;
    private final AbstractFbErrorReporter f4096b;
    private final FbSharedPreferences f4097c;
    private final InterstitialManager f4098d;
    private final Clock f4099e;
    private InterstitialController f4100f;
    private FeedNuxBubbleInterstitialInfo f4101g;

    public BaseNuxDelegate(ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, InterstitialManager interstitialManager, Clock clock) {
        this.f4095a = objectMapper;
        this.f4096b = abstractFbErrorReporter;
        this.f4097c = fbSharedPreferences;
        this.f4098d = interstitialManager;
        this.f4099e = clock;
    }

    public boolean mo331a(InterstitialTrigger interstitialTrigger) {
        return m4632e() != null && this.f4098d.a(m4632e(), interstitialTrigger);
    }

    public void mo330a() {
        NuxHistory f = m4633f();
        f.a();
        f.a(this.f4099e.a());
        this.f4097c.edit().a(m4631d().prefKey, m4630a(f)).commit();
        this.f4098d.a(m4632e());
        this.f4098d.a().a(m4631d().interstitialId);
    }

    public final void m4636b() {
        this.f4097c.edit().a(m4631d().prefKey, m4630a(m4633f().a(true))).commit();
        this.f4098d.a(m4632e());
        this.f4098d.a().d(m4631d().interstitialId);
    }

    public final void m4637c() {
        NuxHistory f = m4633f();
        f.a(this.f4099e);
        this.f4097c.edit().a(m4631d().prefKey, m4630a(f)).commit();
        this.f4098d.a(m4632e());
    }

    private FeedNuxBubbleInterstitialInfo m4631d() {
        if (this.f4101g == null) {
            this.f4101g = FeedNuxBubbleInterstitialInfo.forNuxDelegate(getClass());
        }
        return this.f4101g;
    }

    private InterstitialController m4632e() {
        if (this.f4100f == null) {
            this.f4100f = this.f4098d.a(m4631d().interstitialId);
        }
        return this.f4100f;
    }

    private String m4630a(NuxHistory nuxHistory) {
        try {
            return this.f4095a.a(nuxHistory);
        } catch (Throwable e) {
            this.f4096b.a("nux_history_encode_fail", e);
            return "";
        }
    }

    private NuxHistory m4633f() {
        Object a = this.f4097c.a(m4631d().prefKey, "");
        if (StringUtil.a(a)) {
            return new NuxHistory();
        }
        try {
            return (NuxHistory) this.f4095a.a(a, NuxHistory.class);
        } catch (Throwable e) {
            this.f4096b.a("nux_history_decode_fail", e);
            return new NuxHistory().a(true);
        }
    }
}
