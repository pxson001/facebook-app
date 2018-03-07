package com.facebook.photos.mediagallery.util;

import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import javax.annotation.Nullable;

/* compiled from: is_place_tip */
public class MediaGalleryPrivacyUtil {
    public static MediaGalleryPrivacyUtil m12808a(InjectorLike injectorLike) {
        return new MediaGalleryPrivacyUtil();
    }

    @Nullable
    public static String m12809b(@Nullable MediaMetadata mediaMetadata) {
        if (mediaMetadata == null) {
            return null;
        }
        if (mediaMetadata.R() != null && mediaMetadata.R().b() != null && mediaMetadata.R().a()) {
            return mediaMetadata.R().b().a();
        }
        if (mediaMetadata.x() == null || mediaMetadata.x().bl_() == null || mediaMetadata.x().bl_().b() == null || !mediaMetadata.x().bl_().a()) {
            return null;
        }
        return mediaMetadata.x().bl_().b().a();
    }
}
