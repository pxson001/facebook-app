package com.facebook.productionprompts.model;

import com.facebook.productionprompts.model.PromptObject.PromptSurface;
import com.google.common.base.Objects;

/* compiled from: networkFetchIsCritPath */
public class ProductionPromptObject implements PromptObject {
    public final ProductionPrompt f12765a;

    public ProductionPromptObject(ProductionPrompt productionPrompt) {
        this.f12765a = productionPrompt;
    }

    public final String mo2493b() {
        return this.f12765a.a();
    }

    public final String mo2494c() {
        return this.f12765a.i();
    }

    public final PromptSurface mo2495d() {
        return PromptSurface.INLINE_COMPOSER;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductionPromptObject)) {
            return false;
        }
        return Objects.equal(this.f12765a, ((ProductionPromptObject) obj).f12765a);
    }

    public int hashCode() {
        return this.f12765a.hashCode();
    }

    public final ProductionPrompt m18807e() {
        return this.f12765a;
    }
}
