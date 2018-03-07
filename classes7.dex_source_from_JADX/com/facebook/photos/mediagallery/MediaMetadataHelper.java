package com.facebook.photos.mediagallery;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: iso2 */
public class MediaMetadataHelper {
    public Provider<String> f10676a;

    public static MediaMetadataHelper m12755b(InjectorLike injectorLike) {
        return new MediaMetadataHelper(IdBasedProvider.a(injectorLike, 4443));
    }

    @Inject
    public MediaMetadataHelper(Provider<String> provider) {
        this.f10676a = provider;
    }

    public static boolean m12754a(MediaMetadata mediaMetadata) {
        return (mediaMetadata.N() == null || mediaMetadata.N().b() == null || mediaMetadata.N().b().g() == 2479791) ? false : true;
    }

    public static MediaMetadataHelper m12753a(InjectorLike injectorLike) {
        return m12755b(injectorLike);
    }
}
