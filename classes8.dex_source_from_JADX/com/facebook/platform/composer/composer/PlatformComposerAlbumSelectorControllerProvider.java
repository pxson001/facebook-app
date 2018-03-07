package com.facebook.platform.composer.composer;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albums.AlbumsAdapterProvider;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.futures.AlbumsFuturesGenerator;
import com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass29;
import com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass32;

/* compiled from: roboto */
public class PlatformComposerAlbumSelectorControllerProvider extends AbstractAssistedProvider<PlatformComposerAlbumSelectorController> {
    public final PlatformComposerAlbumSelectorController m3944a(AnonymousClass32 anonymousClass32, AnonymousClass29 anonymousClass29, Fragment fragment, ViewerContext viewerContext, String str) {
        return new PlatformComposerAlbumSelectorController(anonymousClass32, anonymousClass29, fragment, viewerContext, str, AlbumsEventBus.a(this), AlbumCreatorIntentBuilder.b(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), (Context) getInstance(Context.class), DefaultAndroidThreadUtil.b(this), AlbumsFuturesGenerator.a(this), (AlbumsAdapterProvider) getOnDemandAssistedProviderForStaticDi(AlbumsAdapterProvider.class));
    }
}
