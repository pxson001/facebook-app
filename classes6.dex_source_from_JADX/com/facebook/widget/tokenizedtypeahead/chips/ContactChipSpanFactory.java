package com.facebook.widget.tokenizedtypeahead.chips;

import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.tiles.UserTileDrawableController;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.proxygen.HttpNetworkException */
public class ContactChipSpanFactory {
    public final Provider<UserTileDrawableController> f20108a;
    public final PlatformBitmapFactory f20109b;

    public static ContactChipSpanFactory m28754b(InjectorLike injectorLike) {
        return new ContactChipSpanFactory(IdBasedProvider.a(injectorLike, 3608), PlatformBitmapFactoryMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactChipSpanFactory(Provider<UserTileDrawableController> provider, PlatformBitmapFactory platformBitmapFactory) {
        this.f20108a = provider;
        this.f20109b = platformBitmapFactory;
    }
}
