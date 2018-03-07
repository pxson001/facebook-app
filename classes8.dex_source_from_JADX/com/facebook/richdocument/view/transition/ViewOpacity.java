package com.facebook.richdocument.view.transition;

import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import java.text.DecimalFormat;

/* compiled from: originalAirdate */
public final class ViewOpacity implements ViewAttribute<Float> {
    private static final DecimalFormat f7002a = new DecimalFormat("0.00");
    private final float f7003b;

    public final /* synthetic */ Object mo415d() {
        return m7318b();
    }

    public ViewOpacity(float f) {
        this.f7003b = f;
    }

    public final ViewAttributeType mo412a() {
        return ViewAttributeType.OPACITY;
    }

    public final Float m7318b() {
        return Float.valueOf(this.f7003b);
    }

    public final ViewAttribute<Float> mo413a(ViewAttribute<Float> viewAttribute, float f) {
        return new ViewOpacity(ViewLayoutUtil.m7314a(this.f7003b, ((Float) viewAttribute.mo415d()).floatValue(), f));
    }

    public final ViewAttribute<Float> mo414c() {
        return new ViewOpacity(this.f7003b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.f7003b != ((ViewOpacity) obj).f7003b) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Float.valueOf(this.f7003b).hashCode();
    }

    public final String toString() {
        return "{type: " + mo412a() + ", opacity: " + f7002a.format((double) this.f7003b) + "}";
    }
}
