package com.facebook.components;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.SparseArray;
import com.facebook.components.Component.Builder;
import com.facebook.components.reference.ColorDrawableReference;
import com.facebook.components.reference.Reference;
import com.facebook.components.reference.ResourceDrawableReference;
import com.facebook.csslayout.CSSConstants;
import com.facebook.csslayout.CSSDirection;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.Spacing;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: games_peer_pressure_app_invites_user_allowed */
public class InternalNode extends CSSNode implements ComponentLayout$ContainerBuilder {
    private static final boolean f22753g = (VERSION.SDK_INT >= 17);
    private static final int[] f22754h = Align.f22791b;
    private static final int[] f22755i = Justify.f22793b;
    private static final int[] f22756j = FlexDirection.f22795b;
    private static final int[] f22757k = Positioning.f22797b;
    private static final int[] f22758l = LayoutDirection.f22799b;
    private static final int[] f22759m = Wrap.f22801b;
    public float f22760A = Float.NaN;
    public int f22761B = -1;
    public int f22762C = -1;
    public float f22763D = -1.0f;
    public float f22764E = -1.0f;
    public DiffNode f22765F;
    public boolean f22766G;
    public final ResourceResolver f22767n = new ResourceResolver();
    public ComponentContext f22768o;
    public Resources f22769p;
    public Component f22770q;
    public int f22771r = 0;
    public boolean f22772s;
    public Reference<Drawable> f22773t;
    public Reference<Drawable> f22774u;
    public boolean f22775v;
    public EventHandler f22776w;
    public CharSequence f22777x;
    public SparseArray<Object> f22778y;
    public float f22779z = Float.NaN;

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3298A(@DimenRes int i) {
        return ag(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3299B(int i) {
        return m30726P(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3300C(int i) {
        return m30725O(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3301D(int i) {
        return m30727Q(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3302E(int i) {
        return m30728R(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3304G(@DrawableRes int i) {
        return ak(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3305H(@ColorInt int i) {
        return al(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3306I(@StringRes int i) {
        return ao(i);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3308a(int i) {
        return m30729S(i);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3309a(int i, int i2) {
        return m30739p(i, i2);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3315a(Component component) {
        return m30738c(component);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3316a(ComponentLayout$Builder componentLayout$Builder) {
        return m30736b(componentLayout$Builder);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3317a(InternalNode internalNode) {
        return m30737b(internalNode);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3320b(int i) {
        return m30730T(i);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3321b(int i, @AttrRes int i2) {
        return m30740q(i, i2);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3328c(int i, @DimenRes int i2) {
        return m30741r(i, i2);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3329d(int i) {
        return m30731V(i);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3330d(int i, int i2) {
        return m30742s(i, i2);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3331e(int i) {
        return m30732W(i);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3332e(int i, int i2) {
        return m30743t(i, i2);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3334f(int i, @AttrRes int i2) {
        return m30744u(i, i2);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3335g(int i) {
        return m30733Y(i);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3336g(int i, @DimenRes int i2) {
        return m30745v(i, i2);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3338h(int i, int i2) {
        return m30746w(i, i2);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3339i(int i) {
        return aa(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3340i(int i, @AttrRes int i2) {
        return m30740q(i, i2);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3341j(int i) {
        return ab(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3342j(int i, @DimenRes int i2) {
        return m30741r(i, i2);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3345k(int i, int i2) {
        return m30742s(i, i2);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3347l(int i, int i2) {
        return m30743t(i, i2);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3349m(int i, @AttrRes int i2) {
        return m30744u(i, i2);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3350n(int i) {
        return af(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3351n(int i, @DimenRes int i2) {
        return m30745v(i, i2);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3353o(int i, int i2) {
        return m30746w(i, i2);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3354p(@DimenRes int i) {
        return ag(i);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3356r(@DrawableRes int i) {
        return ak(i);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3357s(@DrawableRes int i) {
        return am(i);
    }

    public final /* synthetic */ ComponentLayout$Builder mo3358t(@StringRes int i) {
        return ao(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3359u(int i) {
        return m30729S(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3360v(int i) {
        return m30730T(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3361w(int i) {
        return m30731V(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3362x(int i) {
        return m30732W(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3363y(int i) {
        return m30733Y(i);
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3364z(int i) {
        return aa(i);
    }

    private InternalNode m30726P(int i) {
        m30852a(Wrap.f22800a[i]);
        return this;
    }

    private InternalNode m30730T(int i) {
        m30851a(Positioning.f22796a[i]);
        return this;
    }

    private InternalNode m30725O(int i) {
        m30846a(FlexDirection.f22794a[i]);
        return this;
    }

    private InternalNode m30727Q(int i) {
        m30847a(Justify.f22792a[i]);
        return this;
    }

    public final int b_() {
        return FastMath.m31104a(super.m30865m());
    }

    public final int c_() {
        return FastMath.m31104a(super.m30866n());
    }

    public final int m30790c() {
        return FastMath.m31104a(super.m30867o());
    }

    public final int m30793d() {
        return FastMath.m31104a(super.m30868p());
    }

    public final int m30805h() {
        if (CSSConstants.m31000a(this.f22779z)) {
            this.f22779z = ap(0);
        }
        return FastMath.m31104a(this.f22779z);
    }

    public final int m30796e() {
        return FastMath.m31104a(super.k_().m30942a(1));
    }

    public final int d_() {
        if (CSSConstants.m31000a(this.f22760A)) {
            this.f22760A = ap(2);
        }
        return FastMath.m31104a(this.f22760A);
    }

    public final int m30801g() {
        return FastMath.m31104a(super.k_().m30942a(3));
    }

    public final Reference<Drawable> m30829s() {
        return this.f22773t;
    }

    public final Reference<Drawable> m30831t() {
        return this.f22774u;
    }

    public final void m30766J(int i) {
        this.f22761B = i;
    }

    public final void m30767K(int i) {
        this.f22762C = i;
    }

    final void m30804g(float f) {
        this.f22763D = f;
    }

    final void m30808h(float f) {
        this.f22764E = f;
    }

    final DiffNode m30837y() {
        return this.f22765F;
    }

    final boolean m30839z() {
        return this.f22766G;
    }

    public final int m30809i() {
        return m30869q().ordinal();
    }

    public final InternalNode m30768L(int i) {
        CSSDirection a = LayoutDirection.m30939a(i);
        if (this.f22780a.f22802a != a) {
            this.f22780a.f22802a = a;
            m30861f();
        }
        return this;
    }

    private InternalNode m30728R(int i) {
        m30845a(Align.m30938a(i));
        return this;
    }

    private InternalNode m30729S(int i) {
        m30855b(Align.m30938a(i));
        return this;
    }

    public final /* synthetic */ ComponentLayout$Builder mo3307a(float f) {
        setFlex(f);
        return this;
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3322b(float f) {
        setFlex(f);
        return this;
    }

    public final /* synthetic */ ComponentLayout$Builder mo3327c(int i) {
        this.f22771r = i;
        return this;
    }

    public final /* synthetic */ ComponentLayout$Builder mo3313a(boolean z) {
        this.f22772s = z;
        return this;
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3326b(boolean z) {
        this.f22772s = z;
        return this;
    }

    private InternalNode m30739p(int i, int i2) {
        m30844a(i, (float) i2);
        return this;
    }

    private InternalNode m30734a(int i, @AttrRes int i2, @DimenRes int i3) {
        return m30739p(i, this.f22767n.m30672c(i2, i3));
    }

    private InternalNode m30740q(int i, @AttrRes int i2) {
        return m30734a(i, i2, 0);
    }

    private InternalNode m30741r(int i, @DimenRes int i2) {
        return m30739p(i, this.f22767n.m30678f(i2));
    }

    private InternalNode m30742s(int i, int i2) {
        return m30739p(i, this.f22767n.m30666a(i2));
    }

    private InternalNode m30743t(int i, int i2) {
        m30854b(i, (float) i2);
        return this;
    }

    private InternalNode m30735b(int i, @AttrRes int i2, @DimenRes int i3) {
        return m30743t(i, this.f22767n.m30672c(i2, i3));
    }

    private InternalNode m30744u(int i, @AttrRes int i2) {
        return m30735b(i, i2, 0);
    }

    private InternalNode m30745v(int i, @DimenRes int i2) {
        return m30743t(i, this.f22767n.m30678f(i2));
    }

    private InternalNode m30746w(int i, int i2) {
        return m30743t(i, this.f22767n.m30666a(i2));
    }

    private InternalNode m30731V(int i) {
        m30856c((float) i);
        return this;
    }

    private InternalNode m30732W(int i) {
        a_((float) i);
        return this;
    }

    public final ComponentLayout$Builder mo3333f(@DimenRes int i) {
        return m30732W(this.f22767n.m30678f(i));
    }

    private InternalNode m30733Y(int i) {
        m30858d((float) i);
        return this;
    }

    public final ComponentLayout$Builder mo3337h(@DimenRes int i) {
        return m30733Y(this.f22767n.m30678f(i));
    }

    private InternalNode aa(int i) {
        b_((float) i);
        return this;
    }

    private InternalNode ab(int i) {
        m30860e((float) i);
        return this;
    }

    public final ComponentLayout$Builder mo3346l(@DimenRes int i) {
        return ab(this.f22767n.m30675e(i));
    }

    private InternalNode m30747x(@AttrRes int i, @DimenRes int i2) {
        return ab(this.f22767n.m30670b(i, i2));
    }

    public final ComponentLayout$Builder mo3344k(@AttrRes int i) {
        return m30747x(i, 0);
    }

    public final ComponentLayout$Builder mo3348m(int i) {
        return ab(this.f22767n.m30666a(i));
    }

    private InternalNode af(int i) {
        m30862f((float) i);
        return this;
    }

    private InternalNode ag(@DimenRes int i) {
        return af(this.f22767n.m30675e(i));
    }

    private InternalNode m30748y(@AttrRes int i, @DimenRes int i2) {
        return af(this.f22767n.m30670b(i, i2));
    }

    public final ComponentLayout$Builder mo3352o(@AttrRes int i) {
        return m30748y(i, 0);
    }

    public final ComponentLayout$Builder mo3355q(int i) {
        return af(this.f22767n.m30666a(i));
    }

    private InternalNode m30737b(InternalNode internalNode) {
        if (internalNode != null) {
            m30850a((CSSNode) internalNode, m30841a());
        }
        return this;
    }

    private InternalNode m30736b(ComponentLayout$Builder componentLayout$Builder) {
        if (componentLayout$Builder != null) {
            m30737b(componentLayout$Builder.mo3343j());
        }
        return this;
    }

    private InternalNode m30738c(Component<?> component) {
        if (component != null) {
            m30736b(Layout.m30714a(this.f22768o, component));
        }
        return this;
    }

    public final ComponentLayout$ContainerBuilder mo3314a(Builder builder) {
        if (builder != null) {
            m30738c(builder.mo3296d());
        }
        return this;
    }

    public final /* synthetic */ ComponentLayout$Builder mo3312a(Reference reference) {
        this.f22773t = reference;
        return this;
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3325b(Reference reference) {
        this.f22773t = reference;
        return this;
    }

    public final ComponentLayout$ContainerBuilder mo3318a(Reference.Builder builder) {
        this.f22773t = builder.mo3297b();
        return this;
    }

    private InternalNode m30749z(@AttrRes int i, @DrawableRes int i2) {
        return ak(this.f22767n.m30676e(i, i2));
    }

    public final ComponentLayout$ContainerBuilder mo3303F(@AttrRes int i) {
        return m30749z(i, 0);
    }

    private InternalNode ak(@DrawableRes int i) {
        if (i == 0) {
            this.f22773t = null;
            return this;
        }
        this.f22773t = ResourceDrawableReference.m30964a(this.f22768o).m30972h(i).mo3297b();
        return this;
    }

    private InternalNode al(@ColorInt int i) {
        this.f22773t = ColorDrawableReference.a(this.f22768o).h(i).mo3297b();
        return this;
    }

    private InternalNode am(@DrawableRes int i) {
        if (i == 0) {
            this.f22774u = null;
            return this;
        }
        this.f22774u = ResourceDrawableReference.m30964a(this.f22768o).m30972h(i).mo3297b();
        return this;
    }

    public final /* synthetic */ ComponentLayout$Builder mo3311a(EventHandler eventHandler) {
        this.f22776w = eventHandler;
        return this;
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3324b(EventHandler eventHandler) {
        this.f22776w = eventHandler;
        return this;
    }

    final EventHandler m30752B() {
        return this.f22776w;
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3319a(CharSequence charSequence) {
        this.f22777x = charSequence;
        return this;
    }

    private InternalNode ao(@StringRes int i) {
        this.f22777x = this.f22769p.getString(i);
        return this;
    }

    final CharSequence m30754C() {
        return this.f22777x;
    }

    public final /* synthetic */ ComponentLayout$Builder mo3310a(SparseArray sparseArray) {
        this.f22778y = sparseArray;
        return this;
    }

    public final /* synthetic */ ComponentLayout$ContainerBuilder mo3323b(SparseArray sparseArray) {
        this.f22778y = sparseArray;
        return this;
    }

    final SparseArray<Object> m30755D() {
        return this.f22778y;
    }

    public final InternalNode mo3343j() {
        return this;
    }

    private float ap(int i) {
        int i2 = 7;
        int i3 = 6;
        Object obj = m30869q() == LayoutDirection.m30939a(2) ? 1 : null;
        switch (i) {
            case 0:
                if (obj == null) {
                    i2 = 6;
                    break;
                }
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (obj == null) {
                    i3 = 7;
                }
                i2 = i3;
                break;
            default:
                throw new IllegalArgumentException("Not an horizontal padding index: " + i);
        }
        Spacing k_ = k_();
        float b = k_.m30946b(i2);
        if (CSSConstants.m31000a(b)) {
            return k_.m30942a(i);
        }
        return b;
    }

    final ComponentContext m30757E() {
        return this.f22768o;
    }

    final Component m30759F() {
        return this.f22770q;
    }

    final int m30761G() {
        return this.f22771r;
    }

    final boolean m30764H() {
        return this.f22772s;
    }

    final void m30782a(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index == 7) {
                index = typedArray.getLayoutDimension(index, -1);
                if (index >= 0) {
                    ab(index);
                }
            } else if (index == 8) {
                index = typedArray.getLayoutDimension(index, -1);
                if (index >= 0) {
                    af(index);
                }
            } else if (index == 2) {
                m30743t(0, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 3) {
                m30743t(1, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 4) {
                m30743t(2, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 5) {
                m30743t(3, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 17 && f22753g) {
                m30743t(6, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 18 && f22753g) {
                m30743t(7, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 1) {
                m30743t(8, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 10) {
                m30739p(0, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 11) {
                m30739p(1, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 12) {
                m30739p(2, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 13) {
                m30739p(3, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 19 && f22753g) {
                m30739p(6, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 20 && f22753g) {
                m30739p(7, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 9) {
                m30739p(8, typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 16 && VERSION.SDK_INT >= 16) {
                this.f22771r = typedArray.getInt(index, 0);
            } else if (index == 6) {
                this.f22772s = typedArray.getBoolean(index, false);
            } else if (index == 0) {
                if (TypedArrayUtils.a(typedArray, 0)) {
                    al(typedArray.getColor(index, 0));
                } else {
                    ak(typedArray.getResourceId(index, -1));
                }
            } else if (index == 14) {
                if (TypedArrayUtils.a(typedArray, 14)) {
                    this.f22774u = ColorDrawableReference.a(this.f22768o).h(typedArray.getColor(index, 0)).mo3297b();
                    InternalNode internalNode = this;
                } else {
                    am(typedArray.getResourceId(index, -1));
                }
            } else if (index == 15) {
                this.f22777x = typedArray.getString(index);
            } else if (index == 21) {
                m30725O(f22756j[typedArray.getInteger(index, 0)]);
            } else if (index == 27) {
                m30726P(f22759m[typedArray.getInteger(index, 0)]);
            } else if (index == 23) {
                m30727Q(f22755i[typedArray.getInteger(index, 0)]);
            } else if (index == 26) {
                m30728R(f22754h[typedArray.getInteger(index, 0)]);
            } else if (index == 25) {
                m30729S(f22754h[typedArray.getInteger(index, 0)]);
            } else if (index == 24) {
                m30730T(f22757k[typedArray.getInteger(index, 0)]);
            } else if (index == 32) {
                float f = typedArray.getFloat(index, -1.0f);
                if (f >= 0.0f) {
                    setFlex(f);
                }
            } else if (index == 28) {
                m30731V(typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 29) {
                m30732W(typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 30) {
                m30733Y(typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 31) {
                aa(typedArray.getDimensionPixelOffset(index, 0));
            } else if (index == 22) {
                m30768L(f22758l[typedArray.getInteger(index, -1)]);
            }
        }
    }
}
