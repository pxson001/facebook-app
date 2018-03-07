package com.facebook.photos.upload.ImageSampling;

import com.facebook.photos.upload.protocol.UploadPhotoParams;

/* compiled from: graphsearch_typeahead_global_keywords */
public class RealImageSampler implements ImageSampler {
    private static final Class<?> f13487a = RealImageSampler.class;
    private ImageSamplerFactory f13488b = null;
    private int f13489c = 0;

    public final void mo1124a(ImageSamplerFactory imageSamplerFactory) {
        this.f13488b = imageSamplerFactory;
    }

    public final void mo1123a(int i) {
        this.f13489c += i;
    }

    public final boolean mo1125a(int i, int i2, UploadPhotoParams uploadPhotoParams) {
        return !uploadPhotoParams.ac() && i == i2 && this.f13489c == 0 && (this.f13488b == null || this.f13488b.m21189a());
    }

    public final void mo1122a() {
        if (this.f13488b != null) {
            this.f13488b.m21190b();
        }
    }
}
