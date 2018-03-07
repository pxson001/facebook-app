package com.facebook.photos.upload.ImageSampling;

import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.protocol.UploadPhotoParams;

/* compiled from: groupMembers */
public class NoOpImageSampler implements ImageSampler {
    public static NoOpImageSampler m21192a(InjectorLike injectorLike) {
        return new NoOpImageSampler();
    }

    public final void mo1124a(ImageSamplerFactory imageSamplerFactory) {
    }

    public final void mo1123a(int i) {
    }

    public final boolean mo1125a(int i, int i2, UploadPhotoParams uploadPhotoParams) {
        return false;
    }

    public final void mo1122a() {
    }
}
