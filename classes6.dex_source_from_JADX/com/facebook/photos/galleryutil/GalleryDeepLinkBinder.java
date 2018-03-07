package com.facebook.photos.galleryutil;

import android.os.Parcelable;
import com.facebook.base.fragment.FbFragment;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import javax.annotation.Nullable;

/* compiled from: histogram */
public abstract class GalleryDeepLinkBinder {

    /* compiled from: histogram */
    public abstract class DeepLinkBinderConfig implements Parcelable {
        public int describeContents() {
            return 0;
        }
    }

    public abstract boolean m20346a(MediaMetadata mediaMetadata, MediaGalleryDeepLinkViewGroup mediaGalleryDeepLinkViewGroup, FbFragment fbFragment, @Nullable DeepLinkBinderConfig deepLinkBinderConfig);

    public void m20347b() {
    }
}
