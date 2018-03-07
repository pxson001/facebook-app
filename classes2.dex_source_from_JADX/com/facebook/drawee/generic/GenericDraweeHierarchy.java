package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.ArrayDrawable.C06031;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.RoundingParams.RoundingMethod;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: messaging_tab */
public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    public final Drawable f14230a = new ColorDrawable(0);
    private final Resources f14231b;
    @Nullable
    public RoundingParams f14232c;
    private final RootDrawable f14233d;
    public final FadeDrawable f14234e;
    public final ForwardingDrawable f14235f;
    private final int f14236g;
    private final int f14237h;
    private final int f14238i;
    private final int f14239j;
    private final int f14240k;

    GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        int size;
        int size2;
        int i;
        int i2 = 0;
        this.f14231b = genericDraweeHierarchyBuilder.f14195c;
        this.f14232c = genericDraweeHierarchyBuilder.f14213u;
        this.f14235f = new ForwardingDrawable(this.f14230a);
        if (genericDraweeHierarchyBuilder.f14210r != null) {
            size = genericDraweeHierarchyBuilder.f14210r.size();
        } else {
            size = 0;
        }
        if (genericDraweeHierarchyBuilder.f14211s != null) {
            size2 = genericDraweeHierarchyBuilder.f14211s.size();
        } else {
            size2 = 0;
        }
        if (genericDraweeHierarchyBuilder.f14212t != null) {
            i = 1;
        } else {
            i = 0;
        }
        int i3 = size2 + i;
        size2 = size + 0;
        i = size2 + 1;
        this.f14236g = size2;
        size2 = i + 1;
        this.f14238i = i;
        i = size2 + 1;
        this.f14237h = size2;
        size2 = i + 1;
        this.f14239j = i;
        int i4 = size2 + 1;
        this.f14240k = size2;
        Drawable[] drawableArr = new Drawable[(i4 + i3)];
        if (size > 0) {
            size2 = 0;
            for (Drawable c : genericDraweeHierarchyBuilder.f14210r) {
                i = size2 + 1;
                drawableArr[size2 + 0] = m20585c(c, null);
                size2 = i;
            }
        }
        drawableArr[this.f14236g] = m20585c(genericDraweeHierarchyBuilder.f14198f, genericDraweeHierarchyBuilder.f14199g);
        size = this.f14238i;
        Drawable drawable = this.f14235f;
        ScalingUtils$ScaleType scalingUtils$ScaleType = genericDraweeHierarchyBuilder.f14206n;
        PointF pointF = genericDraweeHierarchyBuilder.f14208p;
        Matrix matrix = genericDraweeHierarchyBuilder.f14207o;
        drawable.setColorFilter(genericDraweeHierarchyBuilder.f14209q);
        drawableArr[size] = WrappingUtils.m20642a(WrappingUtils.m20644a(drawable, scalingUtils$ScaleType, pointF), matrix);
        drawableArr[this.f14237h] = m20585c(genericDraweeHierarchyBuilder.f14204l, genericDraweeHierarchyBuilder.f14205m);
        drawableArr[this.f14239j] = m20585c(genericDraweeHierarchyBuilder.f14200h, genericDraweeHierarchyBuilder.f14201i);
        drawableArr[this.f14240k] = m20585c(genericDraweeHierarchyBuilder.f14202j, genericDraweeHierarchyBuilder.f14203k);
        if (i3 > 0) {
            if (genericDraweeHierarchyBuilder.f14211s != null) {
                for (Drawable c2 : genericDraweeHierarchyBuilder.f14211s) {
                    size2 = i2 + 1;
                    drawableArr[i2 + i4] = m20585c(c2, null);
                    i2 = size2;
                }
            }
            if (genericDraweeHierarchyBuilder.f14212t != null) {
                drawableArr[i4 + i2] = m20585c(genericDraweeHierarchyBuilder.f14212t, null);
            }
        }
        this.f14234e = new FadeDrawable(drawableArr);
        this.f14234e.m20660c(genericDraweeHierarchyBuilder.f14196d);
        this.f14233d = new RootDrawable(WrappingUtils.m20645a(this.f14234e, this.f14232c));
        this.f14233d.mutate();
        m20591h();
    }

    @Nullable
    private Drawable m20585c(@Nullable Drawable drawable, @Nullable ScalingUtils$ScaleType scalingUtils$ScaleType) {
        return WrappingUtils.m20643a(WrappingUtils.m20646a(drawable, this.f14232c, this.f14231b), scalingUtils$ScaleType);
    }

    public final void mo2737b() {
        this.f14235f.mo2740a(this.f14230a);
        m20591h();
    }

    private void m20591h() {
        if (this.f14234e != null) {
            this.f14234e.m20658b();
            FadeDrawable fadeDrawable = this.f14234e;
            fadeDrawable.f14257a = 0;
            Arrays.fill(fadeDrawable.f14263g, true);
            fadeDrawable.invalidateSelf();
            m20592i();
            m20586c(this.f14236g);
            this.f14234e.m20664g();
            this.f14234e.m20659c();
        }
    }

    private void m20592i() {
        m20587d(this.f14236g);
        m20587d(this.f14238i);
        m20587d(this.f14237h);
        m20587d(this.f14239j);
        m20587d(this.f14240k);
    }

    private void m20586c(int i) {
        if (i >= 0) {
            this.f14234e.m20661d(i);
        }
    }

    private void m20587d(int i) {
        if (i >= 0) {
            this.f14234e.m20662e(i);
        }
    }

    private void m20583a(float f) {
        Drawable a = m20588e(this.f14237h).mo2739a();
        if (a != null) {
            if (f >= 0.999f) {
                if (a instanceof Animatable) {
                    ((Animatable) a).stop();
                }
                m20587d(this.f14237h);
            } else {
                if (a instanceof Animatable) {
                    ((Animatable) a).start();
                }
                m20586c(this.f14237h);
            }
            a.setLevel(Math.round(10000.0f * f));
        }
    }

    public final Drawable mo2732a() {
        return this.f14233d;
    }

    public final void mo2735a(Drawable drawable, float f, boolean z) {
        Drawable a = WrappingUtils.m20646a(drawable, this.f14232c, this.f14231b);
        a.mutate();
        this.f14235f.mo2740a(a);
        this.f14234e.m20658b();
        m20592i();
        m20586c(this.f14238i);
        m20583a(f);
        if (z) {
            this.f14234e.m20664g();
        }
        this.f14234e.m20659c();
    }

    public final void mo2733a(float f, boolean z) {
        this.f14234e.m20658b();
        m20583a(f);
        if (z) {
            this.f14234e.m20664g();
        }
        this.f14234e.m20659c();
    }

    public final void mo2736a(Throwable th) {
        this.f14234e.m20658b();
        m20592i();
        if (this.f14234e.m20667a(this.f14240k) != null) {
            m20586c(this.f14240k);
        } else {
            m20586c(this.f14236g);
        }
        this.f14234e.m20659c();
    }

    public final void mo2738b(Throwable th) {
        this.f14234e.m20658b();
        m20592i();
        if (this.f14234e.m20667a(this.f14239j) != null) {
            m20586c(this.f14239j);
        } else {
            m20586c(this.f14236g);
        }
        this.f14234e.m20659c();
    }

    public final void mo2734a(@Nullable Drawable drawable) {
        RootDrawable rootDrawable = this.f14233d;
        rootDrawable.f14274a = drawable;
        rootDrawable.invalidateSelf();
    }

    private DrawableParent m20588e(int i) {
        ArrayDrawable arrayDrawable = this.f14234e;
        boolean z = true;
        Preconditions.a(i >= 0);
        if (i >= arrayDrawable.f14269d.length) {
            z = false;
        }
        Preconditions.a(z);
        if (arrayDrawable.f14269d[i] == null) {
            arrayDrawable.f14269d[i] = new C06031(arrayDrawable, i);
        }
        DrawableParent drawableParent = arrayDrawable.f14269d[i];
        if (drawableParent.mo2739a() instanceof MatrixDrawable) {
            drawableParent = (MatrixDrawable) drawableParent.mo2739a();
        }
        if (drawableParent.mo2739a() instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawableParent.mo2739a();
        }
        return drawableParent;
    }

    private void m20584a(int i, @Nullable Drawable drawable) {
        if (drawable == null) {
            this.f14234e.m20668a(i, null);
            return;
        }
        m20588e(i).mo2740a(WrappingUtils.m20646a(drawable, this.f14232c, this.f14231b));
    }

    private ScaleTypeDrawable m20589f(int i) {
        DrawableParent e = m20588e(i);
        if (e instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) e;
        }
        Drawable a = WrappingUtils.m20643a(e.mo2740a(WrappingUtils.f14249a), ScalingUtils$ScaleType.f14214a);
        e.mo2740a(a);
        Preconditions.a(a, "Parent has no child drawable!");
        return (ScaleTypeDrawable) a;
    }

    private boolean m20590g(int i) {
        return m20588e(i) instanceof ScaleTypeDrawable;
    }

    public final void m20595a(int i) {
        this.f14234e.m20660c(i);
    }

    public final void m20597a(PointF pointF) {
        Preconditions.a(pointF);
        m20589f(this.f14238i).m20653a(pointF);
    }

    public final void m20602a(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        Preconditions.a(scalingUtils$ScaleType);
        m20589f(this.f14238i).m20654a(scalingUtils$ScaleType);
    }

    @Nullable
    public final ScalingUtils$ScaleType m20612d() {
        if (m20590g(this.f14238i)) {
            return m20589f(this.f14238i).f14250a;
        }
        return null;
    }

    public final void m20596a(ColorFilter colorFilter) {
        this.f14235f.setColorFilter(colorFilter);
    }

    public final void m20598a(RectF rectF) {
        this.f14235f.m20629b(rectF);
    }

    public final void m20608b(@Nullable Drawable drawable) {
        m20584a(this.f14236g, drawable);
    }

    public final void m20601a(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        m20584a(this.f14236g, drawable);
        m20589f(this.f14236g).m20654a(scalingUtils$ScaleType);
    }

    public final boolean m20615e() {
        return m20588e(this.f14236g) != null;
    }

    public final void m20607b(PointF pointF) {
        Preconditions.a(pointF);
        m20589f(this.f14236g).m20653a(pointF);
    }

    public final void m20606b(int i) {
        m20608b(this.f14231b.getDrawable(i));
    }

    public final void m20611c(@Nullable Drawable drawable) {
        m20584a(this.f14240k, drawable);
    }

    public final void m20609b(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        m20584a(this.f14240k, drawable);
        m20589f(this.f14240k).m20654a(scalingUtils$ScaleType);
    }

    public final void m20613d(@Nullable Drawable drawable) {
        m20584a(this.f14239j, drawable);
    }

    public final void m20614e(@Nullable Drawable drawable) {
        m20584a(this.f14237h, drawable);
    }

    public final void m20603a(@Nullable RoundingParams roundingParams) {
        this.f14232c = roundingParams;
        DrawableParent drawableParent = this.f14233d;
        RoundingParams roundingParams2 = this.f14232c;
        Drawable a = drawableParent.mo2739a();
        if (roundingParams2 == null || roundingParams2.a != RoundingMethod.OVERLAY_COLOR) {
            if (a instanceof RoundedCornersDrawable) {
                drawableParent.mo2740a(((RoundedCornersDrawable) a).mo2744b(WrappingUtils.f14249a));
                WrappingUtils.f14249a.setCallback(null);
            }
        } else if (a instanceof RoundedCornersDrawable) {
            Rounded rounded = (RoundedCornersDrawable) a;
            WrappingUtils.m20648a(rounded, roundingParams2);
            rounded.m31161a(roundingParams2.d);
        } else {
            drawableParent.mo2740a(WrappingUtils.m20645a(drawableParent.mo2740a(WrappingUtils.f14249a), roundingParams2));
        }
        for (int i = 0; i < this.f14234e.m20666a(); i++) {
            DrawableParent e = m20588e(i);
            RoundingParams roundingParams3 = this.f14232c;
            Resources resources = this.f14231b;
            DrawableParent a2 = WrappingUtils.m20647a(e);
            a = a2.mo2739a();
            if (roundingParams3 == null || roundingParams3.a != RoundingMethod.BITMAP_ONLY) {
                if (a instanceof Rounded) {
                    rounded = (Rounded) a;
                    rounded.mo3382a(false);
                    rounded.mo3380a(0.0f);
                    rounded.mo3381a(0, 0.0f);
                    rounded.mo3384b(0.0f);
                }
            } else if (a instanceof Rounded) {
                WrappingUtils.m20648a((Rounded) a, roundingParams3);
            } else if (a != null) {
                a2.mo2740a(WrappingUtils.f14249a);
                a2.mo2740a(WrappingUtils.m20649b(a, roundingParams3, resources));
            }
        }
    }
}
