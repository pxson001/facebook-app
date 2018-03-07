package com.facebook.messaging.seenheads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.inject.Lazy;
import com.facebook.messaging.util.CircleOverflowDrawable;
import com.facebook.messaging.util.CircleOverflowRenderer.Builder;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileDrawableController;
import com.facebook.user.tiles.UserTileViewParams;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: delete_payment_pin */
public class ThreadItemSeenHeadsDrawableController {
    @VisibleForTesting
    public HorizontalListDrawable f16629a;
    @VisibleForTesting
    CircleOverflowDrawable f16630b;
    private final Provider<UserTileDrawableController> f16631c;
    private final Context f16632d;
    private final Lazy<SeenHeadCircleOverflowRendererProvider> f16633e;
    private final RTLUtil f16634f;
    public final List<UserTileDrawableController> f16635g;
    public int f16636h;
    private int f16637i;
    public int f16638j;
    public int f16639k = 3;
    public OverflowType f16640l = OverflowType.START;
    public StackingDirection f16641m = StackingDirection.START;

    /* compiled from: delete_payment_pin */
    public enum OverflowType {
        START,
        END
    }

    /* compiled from: delete_payment_pin */
    public enum StackingDirection {
        START,
        END
    }

    @Inject
    public ThreadItemSeenHeadsDrawableController(Provider<UserTileDrawableController> provider, Context context, Lazy<SeenHeadCircleOverflowRendererProvider> lazy, RTLUtil rTLUtil) {
        this.f16631c = provider;
        this.f16632d = context;
        this.f16633e = lazy;
        this.f16634f = rTLUtil;
        Resources resources = context.getResources();
        this.f16629a = new HorizontalListDrawable();
        this.f16629a.m16632a(resources.getDimensionPixelSize(2131428636));
        m16642a(0, resources.getDimensionPixelSize(2131428642), 0, 0);
        this.f16635g = Lists.b(this.f16639k);
        this.f16636h = resources.getDimensionPixelSize(2131428631);
    }

    public final Drawable m16641a() {
        return this.f16629a;
    }

    public final void m16644b() {
        for (UserTileDrawableController c : this.f16635g) {
            c.c();
        }
    }

    public final void m16646c() {
        for (UserTileDrawableController d : this.f16635g) {
            d.d();
        }
    }

    public final void m16642a(int i, int i2, int i3, int i4) {
        this.f16629a.f16625a.set(i, i2, i3, i4);
    }

    public final void m16645b(int i) {
        if (Math.abs(i) > this.f16636h) {
            throw new IllegalArgumentException("Magnitude of spacing must be larger than tile size");
        }
        this.f16637i = i;
        this.f16629a.m16632a(this.f16637i);
    }

    public final void m16643a(List<UserKey> list) {
        boolean z;
        int i;
        int i2;
        int min = Math.min(list.size(), this.f16639k);
        Drawable[] drawableArr = new Drawable[min];
        boolean a = this.f16634f.a();
        if (list.size() <= this.f16639k) {
            z = false;
            i = 0;
            i2 = min;
        } else if (this.f16637i < 0) {
            throw new IllegalArgumentException("Stacking is not supported with overflow right now.");
        } else {
            int size = list.size() - this.f16639k;
            i = this.f16639k - 1;
            m16640g();
            drawableArr[m16638e() ? 0 : min - 1] = this.f16630b;
            this.f16630b.a(list.size() - i);
            i2 = i;
            i = size;
            z = true;
        }
        m16637d(i2);
        int i3 = m16639f() ? 0 : min - 1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5;
            int i6;
            if (a) {
                i5 = (min - 1) - i4;
            } else {
                i5 = i4;
            }
            if (z && OverflowType.START.equals(this.f16640l)) {
                int i7;
                if (a) {
                    i7 = -1;
                } else {
                    i7 = 1;
                }
                i6 = i7 + i5;
            } else {
                i6 = i5;
            }
            UserTileDrawableController userTileDrawableController = (UserTileDrawableController) this.f16635g.get(i4);
            userTileDrawableController.a(UserTileViewParams.a((UserKey) list.get(i + i4)));
            if (this.f16637i >= 0 || i6 == i3) {
                userTileDrawableController.a(true);
            } else {
                userTileDrawableController.a(m16636d());
            }
            drawableArr[i6] = userTileDrawableController.n;
        }
        this.f16629a.m16633a(drawableArr);
    }

    private void m16637d(int i) {
        for (int size = this.f16635g.size(); size < i; size++) {
            UserTileDrawableController userTileDrawableController = (UserTileDrawableController) this.f16631c.get();
            userTileDrawableController.a(this.f16632d, null, 0);
            userTileDrawableController.a(this.f16636h);
            this.f16635g.add(userTileDrawableController);
        }
    }

    private CrescentShape m16636d() {
        int i = this.f16636h + this.f16637i;
        if (m16639f()) {
            i *= -1;
        }
        return new CrescentShape(((float) i) / ((float) this.f16636h), ((float) this.f16638j) / ((float) this.f16636h));
    }

    @VisibleForTesting
    private boolean m16638e() {
        return this.f16634f.a() ? OverflowType.END.equals(this.f16640l) : OverflowType.START.equals(this.f16640l);
    }

    @VisibleForTesting
    private boolean m16639f() {
        return this.f16634f.a() ? StackingDirection.END.equals(this.f16641m) : StackingDirection.START.equals(this.f16641m);
    }

    private void m16640g() {
        if (this.f16630b == null) {
            Builder a = ((SeenHeadCircleOverflowRendererProvider) this.f16633e.get()).m16635a();
            a.b = this.f16636h;
            this.f16630b = new CircleOverflowDrawable(a.a());
        }
    }
}
