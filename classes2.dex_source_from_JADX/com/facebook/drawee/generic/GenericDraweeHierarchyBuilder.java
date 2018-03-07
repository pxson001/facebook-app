package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: messenger_android_client_check_clock_skew */
public class GenericDraweeHierarchyBuilder {
    public static final ScalingUtils$ScaleType f14193a = ScalingUtils$ScaleType.f14219f;
    public static final ScalingUtils$ScaleType f14194b = ScalingUtils$ScaleType.f14220g;
    public Resources f14195c;
    public int f14196d;
    public float f14197e;
    public Drawable f14198f;
    @Nullable
    public ScalingUtils$ScaleType f14199g;
    public Drawable f14200h;
    public ScalingUtils$ScaleType f14201i;
    public Drawable f14202j;
    public ScalingUtils$ScaleType f14203k;
    public Drawable f14204l;
    public ScalingUtils$ScaleType f14205m;
    public ScalingUtils$ScaleType f14206n;
    public Matrix f14207o;
    public PointF f14208p;
    public ColorFilter f14209q;
    public List<Drawable> f14210r;
    public List<Drawable> f14211s;
    public Drawable f14212t;
    public RoundingParams f14213u;

    public GenericDraweeHierarchyBuilder(Resources resources) {
        this.f14195c = resources;
        m20553v();
    }

    public static GenericDraweeHierarchyBuilder m20552a(Resources resources) {
        return new GenericDraweeHierarchyBuilder(resources);
    }

    private void m20553v() {
        this.f14196d = 300;
        this.f14197e = 0.0f;
        this.f14198f = null;
        this.f14199g = f14193a;
        this.f14200h = null;
        this.f14201i = f14193a;
        this.f14202j = null;
        this.f14203k = f14193a;
        this.f14204l = null;
        this.f14205m = f14193a;
        this.f14206n = f14194b;
        this.f14207o = null;
        this.f14208p = null;
        this.f14209q = null;
        this.f14210r = null;
        this.f14211s = null;
        this.f14212t = null;
        this.f14213u = null;
    }

    public final GenericDraweeHierarchyBuilder m20554a() {
        m20553v();
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20556a(int i) {
        this.f14196d = i;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20555a(float f) {
        this.f14197e = f;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20557a(@Nullable Drawable drawable) {
        this.f14198f = drawable;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20559a(@Nullable ScalingUtils$ScaleType scalingUtils$ScaleType) {
        this.f14199g = scalingUtils$ScaleType;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20558a(Drawable drawable, @Nullable ScalingUtils$ScaleType scalingUtils$ScaleType) {
        this.f14198f = drawable;
        this.f14199g = scalingUtils$ScaleType;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20560b(@Nullable Drawable drawable) {
        this.f14200h = drawable;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20561b(@Nullable ScalingUtils$ScaleType scalingUtils$ScaleType) {
        this.f14201i = scalingUtils$ScaleType;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20562c(@Nullable Drawable drawable) {
        this.f14202j = drawable;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20563c(@Nullable ScalingUtils$ScaleType scalingUtils$ScaleType) {
        this.f14203k = scalingUtils$ScaleType;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20564d(@Nullable Drawable drawable) {
        this.f14204l = drawable;
        return this;
    }

    @Nullable
    public final Drawable m20570k() {
        return this.f14204l;
    }

    public final GenericDraweeHierarchyBuilder m20565d(@Nullable ScalingUtils$ScaleType scalingUtils$ScaleType) {
        this.f14205m = scalingUtils$ScaleType;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20567e(@Nullable ScalingUtils$ScaleType scalingUtils$ScaleType) {
        this.f14206n = scalingUtils$ScaleType;
        this.f14207o = null;
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20566e(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.f14210r = null;
        } else {
            this.f14210r = Arrays.asList(new Drawable[]{drawable});
        }
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20568f(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.f14211s = null;
        } else {
            this.f14211s = Arrays.asList(new Drawable[]{drawable});
        }
        return this;
    }

    public final GenericDraweeHierarchyBuilder m20569g(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.f14212t = null;
        } else {
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable);
            this.f14212t = stateListDrawable;
        }
        return this;
    }

    public final GenericDraweeHierarchy m20571u() {
        if (this.f14211s != null) {
            for (Drawable a : this.f14211s) {
                Preconditions.a(a);
            }
        }
        if (this.f14210r != null) {
            for (Drawable a2 : this.f14210r) {
                Preconditions.a(a2);
            }
        }
        return new GenericDraweeHierarchy(this);
    }
}
