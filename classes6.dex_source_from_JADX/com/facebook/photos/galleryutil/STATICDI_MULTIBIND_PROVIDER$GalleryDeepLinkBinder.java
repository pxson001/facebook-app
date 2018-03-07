package com.facebook.photos.galleryutil;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.thirdparty.instagram.InstagramGalleryDeepLinkBinder;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.friendsharing.photoremix.PhotoRemixGalleryDeepLinkBinder;
import com.facebook.heisman.ProfilePictureOverlayDeepLinkBinder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.photos.mediagallery.ui.ProfilePicDeepLinkBinder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class STATICDI_MULTIBIND_PROVIDER$GalleryDeepLinkBinder implements MultiBindIndexedProvider<GalleryDeepLinkBinder>, Provider<Set<GalleryDeepLinkBinder>> {
    private final InjectorLike f13009a;

    private STATICDI_MULTIBIND_PROVIDER$GalleryDeepLinkBinder(InjectorLike injectorLike) {
        this.f13009a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f13009a.getScopeAwareInjector(), this);
    }

    public static Set<GalleryDeepLinkBinder> m20357a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$GalleryDeepLinkBinder(injectorLike));
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new InstagramGalleryDeepLinkBinder(InstagramUtils.a(injector), NewsFeedAnalyticsEventBuilder.a(injector), FbObjectMapperMethodAutoProvider.a(injector));
            case 1:
                return new PhotoRemixGalleryDeepLinkBinder((QeAccessor) QeInternalImplMethodAutoProvider.a(injector), ResourcesMethodAutoProvider.a(injector), (Context) injector.getInstance(Context.class), GlyphColorizer.a(injector), IdBasedLazy.a(injector, 6117));
            case 2:
                return new ProfilePictureOverlayDeepLinkBinder(GlyphColorizer.a(injector), IdBasedSingletonScopeProvider.a(injector, 7160), (QeAccessor) QeInternalImplMethodAutoProvider.a(injector));
            case 3:
                return ProfilePicDeepLinkBinder.b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
