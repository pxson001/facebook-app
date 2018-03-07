package com.facebook.orca.threadview.seenheads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.inject.Assisted;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileDrawableController;
import javax.inject.Inject;

/* compiled from: manageBlockParam */
public class SeenHead {
    public long f8303a;
    public int f8304b;
    public int f8305c;
    public final UserTileDrawableController f8306d;
    private final int f8307e;
    private final float f8308f;
    public final int f8309g;
    private final Spring f8310h;
    private final Spring f8311i;
    public UserKey f8312j;
    public int f8313k;
    public int f8314l;

    /* compiled from: manageBlockParam */
    class C12471 extends SimpleSpringListener {
        final /* synthetic */ SeenHead f8302a;

        C12471(SeenHead seenHead) {
            this.f8302a = seenHead;
        }

        public final void m8266a(Spring spring) {
            SeenHead.m8267g(this.f8302a);
        }
    }

    @Inject
    public SeenHead(Context context, UserTileDrawableController userTileDrawableController, @Assisted SpringSystem springSystem) {
        this.f8306d = userTileDrawableController;
        Resources resources = context.getResources();
        this.f8307e = resources.getDimensionPixelSize(2131428631);
        this.f8308f = resources.getDimension(2131428637);
        this.f8309g = resources.getDimensionPixelSize(2131428639);
        C12471 c12471 = new C12471(this);
        Spring a = springSystem.a().a(SpringConfig.a(80.0d, 7.0d));
        a.l = 0.5d;
        a = a;
        a.k = 0.5d;
        this.f8310h = a.a(c12471);
        a = springSystem.a().a(SpringConfig.a(40.0d, 7.0d));
        a.l = 0.5d;
        a = a;
        a.k = 0.5d;
        this.f8311i = a.a(c12471);
        this.f8306d.a(context, null, 0);
        this.f8306d.a(this.f8307e);
        this.f8306d.a(true);
        this.f8306d.m.setBounds(0, 0, this.f8307e, this.f8307e);
    }

    public final void m8268a(int i, int i2, int i3, int i4) {
        double d = ((double) (i - i3)) + this.f8310h.d();
        double d2 = ((double) (i2 - i4)) + this.f8311i.d();
        this.f8313k = i3;
        this.f8314l = i4;
        this.f8310h.a(d).b(0.0d);
        this.f8311i.a(d2).b(0.0d);
    }

    public final boolean m8269b() {
        return Math.max(this.f8310h.e(), this.f8311i.e()) >= ((double) this.f8308f);
    }

    public final boolean m8270c() {
        return this.f8310h.k() && this.f8311i.k();
    }

    public final void m8271e() {
        this.f8306d.m.invalidateSelf();
        this.f8306d.d();
    }

    public final void m8272f() {
        this.f8310h.a();
        this.f8311i.a();
    }

    public static void m8267g(SeenHead seenHead) {
        Drawable drawable = seenHead.f8306d.m;
        Rect bounds = drawable.getBounds();
        int d = (int) (((double) seenHead.f8313k) + seenHead.f8310h.d());
        int d2 = (int) (((double) seenHead.f8314l) + seenHead.f8311i.d());
        int width = bounds.width() + d;
        int height = bounds.height() + d2;
        if (bounds.left != d || bounds.top != d2 || bounds.right != width || bounds.bottom != height) {
            if (VERSION.SDK_INT < 18) {
                drawable.invalidateSelf();
            }
            drawable.setBounds(d, d2, width, height);
        }
    }
}
