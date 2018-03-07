package com.facebook.composer.capability;

import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: core_header_rendered */
public class ComposerStickersCapability {
    public final Product f16702a;

    public static ComposerStickersCapability m20734a(InjectorLike injectorLike) {
        return new ComposerStickersCapability(ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ComposerStickersCapability(Product product) {
        this.f16702a = product;
    }
}
