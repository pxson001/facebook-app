package com.facebook.stickers.abtest;

import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: entities */
public class StickerContentSearchExperimentAccessor {
    public final Product f16416a;
    public final QeAccessor f16417b;

    public static StickerContentSearchExperimentAccessor m23888b(InjectorLike injectorLike) {
        return new StickerContentSearchExperimentAccessor(ProductMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StickerContentSearchExperimentAccessor(Product product, QeAccessor qeAccessor) {
        this.f16416a = product;
        this.f16417b = qeAccessor;
    }

    public final boolean m23889a() {
        return this.f16416a == Product.MESSENGER && this.f16417b.a(ExperimentsForStickerAbTestingModule.f16415f, false);
    }

    public final boolean m23890c() {
        return this.f16417b.a(ExperimentsForStickerAbTestingModule.f16414e, true);
    }

    public static StickerContentSearchExperimentAccessor m23887a(InjectorLike injectorLike) {
        return m23888b(injectorLike);
    }
}
