package com.facebook.rtc.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtcpresence.RtcPresenceState;
import com.facebook.rtcpresence.abtests.ExperimentsForRtcPresenceModule;
import javax.inject.Inject;

/* compiled from: application/vnd.wap.wta-eventc */
public class RtcCallButtonIconProvider {
    private final Context f19729a;
    public final GlyphColorizer f19730b;
    private final Resources f19731c;
    private final QeAccessor f19732d;
    public final int f19733e = ContextCompat.b(this.f19729a, 2131362514);
    public int f19734f = this.f19731c.getColor(2131362502);
    public int f19735g = this.f19731c.getColor(2131362314);
    private int f19736h;
    private boolean f19737i;
    public Drawable f19738j;
    private Drawable f19739k;
    public Drawable f19740l;
    public Drawable f19741m;
    public Drawable f19742n;
    public Drawable f19743o;
    public Drawable f19744p;
    public Drawable f19745q;
    public Drawable f19746r;
    public Drawable f19747s;
    public Drawable f19748t;
    public Drawable f19749u;
    public Drawable f19750v;
    public Drawable f19751w;
    public Drawable f19752x;

    public static RtcCallButtonIconProvider m19533b(InjectorLike injectorLike) {
        return new RtcCallButtonIconProvider((Context) injectorLike.getInstance(Context.class), GlyphColorizer.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public static RtcCallButtonIconProvider m19532a(InjectorLike injectorLike) {
        return m19533b(injectorLike);
    }

    @Inject
    public RtcCallButtonIconProvider(Context context, GlyphColorizer glyphColorizer, Resources resources, QeAccessor qeAccessor) {
        this.f19729a = context;
        this.f19730b = glyphColorizer;
        this.f19731c = resources;
        this.f19732d = qeAccessor;
    }

    public final Drawable m19539a() {
        if (this.f19739k == null) {
            this.f19739k = this.f19730b.a(2130843999, this.f19734f, false);
        }
        return this.f19739k;
    }

    public final Drawable m19542b() {
        return m19535o();
    }

    public final Drawable m19540a(RtcPresenceState rtcPresenceState) {
        if (this.f19732d.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcPresenceModule.c, false) && rtcPresenceState.a && rtcPresenceState.b) {
            return m19536p();
        }
        if (rtcPresenceState.a) {
            return m19535o();
        }
        if (this.f19732d.a(ExperimentsForRtcPresenceModule.a, false)) {
            return m19535o();
        }
        return m19537q();
    }

    public final Drawable m19543b(RtcPresenceState rtcPresenceState) {
        boolean a = this.f19732d.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcPresenceModule.a, false);
        if (rtcPresenceState.a || a) {
            return m19546e();
        }
        return m19547f();
    }

    public final Drawable m19541a(boolean z) {
        if (!z) {
            return m19534k();
        }
        if (this.f19748t == null) {
            this.f19748t = this.f19730b.a(2130843948, this.f19734f, false);
        }
        return this.f19748t;
    }

    private Drawable m19534k() {
        if (this.f19747s == null) {
            this.f19747s = this.f19730b.a(m19538r(), this.f19734f, false);
        }
        return this.f19747s;
    }

    public final Drawable m19544b(boolean z) {
        if (z) {
            if (this.f19750v == null) {
                this.f19750v = this.f19730b.a(2130844023, this.f19735g, false);
            }
            return this.f19750v;
        }
        if (this.f19749u == null) {
            this.f19749u = this.f19730b.a(2130844023, this.f19734f, false);
        }
        return this.f19749u;
    }

    private Drawable m19535o() {
        if (this.f19738j == null) {
            this.f19738j = this.f19730b.a(m19538r(), this.f19734f, false);
        }
        return this.f19738j;
    }

    private Drawable m19536p() {
        if (this.f19740l == null) {
            Drawable o = m19535o();
            Drawable rtcCallabilityBadgeDrawable = new RtcCallabilityBadgeDrawable(o.getIntrinsicWidth(), o.getIntrinsicHeight(), o.getIntrinsicWidth() / 4, this.f19734f);
            this.f19740l = new LayerDrawable(new Drawable[]{o, rtcCallabilityBadgeDrawable});
        }
        return this.f19740l;
    }

    public final Drawable m19545d() {
        if (this.f19741m == null) {
            Drawable o = m19535o();
            Drawable rtcCallabilityBadgeDrawable = new RtcCallabilityBadgeDrawable(o.getIntrinsicWidth(), o.getIntrinsicHeight(), o.getIntrinsicWidth() / 4, this.f19733e);
            this.f19741m = new LayerDrawable(new Drawable[]{o, rtcCallabilityBadgeDrawable});
        }
        return this.f19741m;
    }

    private Drawable m19537q() {
        if (this.f19743o == null) {
            this.f19743o = this.f19730b.a(m19538r(), this.f19735g);
        }
        return this.f19743o;
    }

    public final Drawable m19546e() {
        if (this.f19744p == null) {
            this.f19744p = this.f19730b.a(2130844023, this.f19734f, false);
        }
        return this.f19744p;
    }

    public final Drawable m19547f() {
        if (this.f19745q == null) {
            this.f19745q = this.f19730b.a(2130844023, this.f19735g);
        }
        return this.f19745q;
    }

    private int m19538r() {
        if (!this.f19737i) {
            if (this.f19732d.a(ExperimentsForRtcPresenceModule.d, false)) {
                this.f19736h = 2130843999;
            } else {
                this.f19736h = 2130841417;
            }
            this.f19737i = true;
        }
        return this.f19736h;
    }
}
