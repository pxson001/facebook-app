package com.facebook.composer.capability;

import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.TargetType;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: core_attribute_truncation_text */
public class ComposerTextEditCapability {
    private final Product f16703a;

    public static ComposerTextEditCapability m20737a(InjectorLike injectorLike) {
        return new ComposerTextEditCapability(ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ComposerTextEditCapability(Product product) {
        this.f16703a = product;
    }

    public final boolean m20738a(TargetType targetType) {
        Preconditions.checkNotNull(targetType);
        if (targetType == TargetType.PAGE || this.f16703a == Product.PAA) {
            return false;
        }
        return true;
    }
}
