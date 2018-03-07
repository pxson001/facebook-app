package com.facebook.bitmaps;

import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.base.Preconditions;

@DoNotStrip
/* compiled from: android.support.remoteInputs */
public class NativeSphericalProcessing {
    @DoNotStrip
    private static native boolean nativeTryDeriveSphericalMetadata(String str, String str2, int i, int i2, String str3, int i3, SphericalPhotoMetadata sphericalPhotoMetadata);

    static {
        SoLoaderShim.a("fb_imgproc");
    }

    public static boolean m18485a(String str, String str2, int i, int i2, String str3, int i3, SphericalPhotoMetadata sphericalPhotoMetadata) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(str3);
        return nativeTryDeriveSphericalMetadata(str, str2, i, i2, str3, i3, sphericalPhotoMetadata);
    }
}
