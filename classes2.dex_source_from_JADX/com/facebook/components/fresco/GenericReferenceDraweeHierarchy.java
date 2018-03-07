package com.facebook.components.fresco;

import android.graphics.drawable.Drawable;
import com.facebook.components.ComponentContext;
import com.facebook.components.reference.Reference;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;

/* compiled from: friends_except_acquaintances */
public class GenericReferenceDraweeHierarchy implements SettableDraweeHierarchy {
    public ComponentContext f23015a;
    public GenericDraweeHierarchy f23016b;
    public Reference<Drawable> f23017c;
    public Reference<Drawable> f23018d;
    public Reference<Drawable> f23019e;
    public Reference<Drawable> f23020f;
    public Drawable f23021g;
    public Drawable f23022h;
    public Drawable f23023i;
    public Drawable f23024j;

    public GenericReferenceDraweeHierarchy(GenericDraweeHierarchy genericDraweeHierarchy) {
        this.f23016b = genericDraweeHierarchy;
    }

    public final void m31152a(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        this.f23016b.m20602a(scalingUtils$ScaleType);
    }

    public final Drawable mo2732a() {
        return this.f23016b.mo2732a();
    }

    public final void mo2737b() {
        this.f23016b.mo2737b();
    }

    public final void mo2735a(Drawable drawable, float f, boolean z) {
        this.f23016b.mo2735a(drawable, f, z);
    }

    public final void mo2733a(float f, boolean z) {
        this.f23016b.mo2733a(f, z);
    }

    public final void mo2736a(Throwable th) {
        this.f23016b.mo2736a(th);
    }

    public final void mo2738b(Throwable th) {
        this.f23016b.mo2738b(th);
    }

    public final void mo2734a(Drawable drawable) {
        this.f23016b.mo2734a(drawable);
    }
}
