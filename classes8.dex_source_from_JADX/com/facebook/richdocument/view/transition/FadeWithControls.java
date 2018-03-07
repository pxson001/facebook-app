package com.facebook.richdocument.view.transition;

import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;

/* compiled from: p2p_transfer */
public class FadeWithControls implements ViewAttribute<Boolean> {
    public Boolean f6955a;

    public FadeWithControls(boolean z) {
        this.f6955a = Boolean.valueOf(z);
    }

    public final ViewAttributeType mo412a() {
        return ViewAttributeType.FADES_WITH_CONTROLS;
    }

    public final /* synthetic */ Object mo415d() {
        return this.f6955a;
    }

    public final ViewAttribute<Boolean> mo413a(ViewAttribute<Boolean> viewAttribute, float f) {
        return new FadeWithControls(((Boolean) viewAttribute.mo415d()).booleanValue());
    }

    public final ViewAttribute<Boolean> mo414c() {
        return new FadeWithControls(this.f6955a.booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f6955a.equals(((FadeWithControls) obj).f6955a);
    }

    public int hashCode() {
        return this.f6955a.hashCode();
    }
}
