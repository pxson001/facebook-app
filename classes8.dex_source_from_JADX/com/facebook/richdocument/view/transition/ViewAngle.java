package com.facebook.richdocument.view.transition;

import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;

/* compiled from: originalLocation */
public class ViewAngle implements ViewAttribute<Float> {
    public final Float f6998a;

    public ViewAngle(float f) {
        this.f6998a = Float.valueOf(f);
    }

    private ViewAngle(ViewAngle viewAngle) {
        this(viewAngle.f6998a.floatValue());
    }

    public final /* synthetic */ Object mo415d() {
        return this.f6998a;
    }

    public final ViewAttributeType mo412a() {
        return ViewAttributeType.ANGLE;
    }

    public final ViewAttribute<Float> mo413a(ViewAttribute<Float> viewAttribute, float f) {
        return new ViewAngle(ViewLayoutUtil.m7314a(this.f6998a.floatValue(), ((Float) viewAttribute.mo415d()).floatValue(), f));
    }

    public final ViewAttribute<Float> mo414c() {
        return new ViewAngle(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f6998a.equals(((ViewAngle) obj).f6998a);
    }

    public int hashCode() {
        return this.f6998a.hashCode();
    }

    public String toString() {
        return "{type: " + mo412a() + ", v: " + this.f6998a;
    }
}
