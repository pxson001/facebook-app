package com.facebook.video.abtest;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: is_low_on_memory */
public class Video360PlayerConfig {
    public final String f19029a;
    public final String f19030b;
    public final boolean f19031c;
    public final boolean f19032d;
    public boolean f19033e;
    public final boolean f19034f;
    private final boolean f19035g;
    private final boolean f19036h;
    public final boolean f19037i;
    public final boolean f19038j;
    public final boolean f19039k;
    public final boolean f19040l;
    public final boolean f19041m;
    public final boolean f19042n;
    public final boolean f19043o;
    public final boolean f19044p;
    public final boolean f19045q;
    public final boolean f19046r;
    public final boolean f19047s;
    public final boolean f19048t;
    private final QeAccessor f19049u;
    private final ExposureLogging f19050v;

    public static Video360PlayerConfig m26762b(InjectorLike injectorLike) {
        return new Video360PlayerConfig(QeInternalImplMethodAutoProvider.m3744a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public static Video360PlayerConfig m26760a(InjectorLike injectorLike) {
        return m26762b(injectorLike);
    }

    @Inject
    public Video360PlayerConfig(QeAccessor qeAccessor, Context context) {
        Object obj;
        this.f19029a = qeAccessor.mo585a(Liveness.Cached, ExposureLogging.Off, ExperimentsForVideoAbTestModule.f6647T, "");
        this.f19030b = qeAccessor.mo585a(Liveness.Cached, ExposureLogging.Off, ExperimentsForVideoAbTestModule.f6646S, "");
        if (VERSION.SDK_INT >= 18) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            this.f19033e = false;
            this.f19036h = false;
            this.f19031c = false;
            this.f19032d = false;
            this.f19034f = false;
            this.f19035g = false;
            this.f19037i = false;
            this.f19038j = false;
            this.f19039k = false;
            this.f19040l = false;
            this.f19041m = false;
            this.f19042n = false;
            this.f19043o = false;
            this.f19044p = false;
            this.f19045q = false;
            this.f19046r = false;
            this.f19047s = false;
            this.f19048t = false;
            this.f19049u = null;
            this.f19050v = null;
            return;
        }
        boolean z;
        boolean z2;
        this.f19049u = qeAccessor;
        this.f19050v = "android_360_video_in_feed".equals(this.f19029a) ? ExposureLogging.On : ExposureLogging.Off;
        this.f19033e = m26761a(ExperimentsForVideoAbTestModule.f6643P, false);
        this.f19036h = m26761a(ExperimentsForVideoAbTestModule.f6651X, false);
        if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(15) != null) {
            z = true;
        } else {
            z = false;
        }
        this.f19031c = z;
        if (this.f19036h || this.f19031c) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f19032d = z2;
        if (!m26761a(ExperimentsForVideoAbTestModule.f6648U, true) || this.f19032d) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f19034f = z2;
        if (this.f19033e && m26761a(ExperimentsForVideoAbTestModule.f6650W, true)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f19035g = z2;
        if (this.f19033e && m26761a(ExperimentsForVideoAbTestModule.f6649V, true)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f19037i = z2;
        this.f19038j = m26761a(ExperimentsForVideoAbTestModule.f6644Q, true);
        this.f19039k = m26761a(ExperimentsForVideoAbTestModule.ab, false);
        this.f19040l = m26761a(ExperimentsForVideoAbTestModule.aa, false);
        this.f19041m = m26761a(ExperimentsForVideoAbTestModule.ac, false);
        this.f19042n = m26761a(ExperimentsForVideoAbTestModule.f6642O, false);
        this.f19043o = m26761a(ExperimentsForVideoAbTestModule.f6652Y, false);
        this.f19044p = m26761a(ExperimentsForVideoAbTestModule.f6634G, false);
        this.f19045q = m26761a(ExperimentsForVideoAbTestModule.ad, false);
        this.f19046r = m26761a(ExperimentsForVideoAbTestModule.f6653Z, false);
        this.f19047s = m26761a(ExperimentsForVideoAbTestModule.f6636I, false);
        this.f19048t = m26761a(ExperimentsForVideoAbTestModule.f6635H, false);
    }

    private boolean m26761a(short s, boolean z) {
        return this.f19049u.mo593a(Liveness.Live, this.f19050v, s, z);
    }

    public final boolean m26763c() {
        return this.f19033e && this.f19035g;
    }

    public final boolean m26764g() {
        return this.f19039k;
    }

    public final boolean m26765h() {
        return this.f19040l;
    }

    public final boolean m26766o() {
        return this.f19046r;
    }
}
