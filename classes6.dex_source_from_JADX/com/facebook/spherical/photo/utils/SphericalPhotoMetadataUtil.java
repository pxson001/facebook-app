package com.facebook.spherical.photo.utils;

import android.media.ExifInterface;
import com.facebook.bitmaps.NativeSphericalProcessing;
import com.facebook.bitmaps.SphericalPhotoMetadata;
import com.facebook.bitmaps.XMPUtil;
import com.facebook.debug.log.BLog;
import javax.annotation.Nullable;

/* compiled from: serverInfoData */
public class SphericalPhotoMetadataUtil {
    private static final Class<?> f4937a = SphericalPhotoMetadataUtil.class;

    /* compiled from: serverInfoData */
    public class SphericalProps {
        @Nullable
        public final String f4935a;
        public final boolean f4936b;

        public SphericalProps(String str, boolean z) {
            this.f4935a = str;
            this.f4936b = z;
        }

        public final boolean m7705a() {
            return this.f4936b;
        }

        @Nullable
        public final String m7706b() {
            return this.f4935a;
        }
    }

    public static SphericalProps m7707a(String str) {
        ExifInterface exifInterface;
        String str2 = null;
        try {
            exifInterface = new ExifInterface(str);
        } catch (Throwable e) {
            BLog.b(f4937a, "Error reading EXIF metadata from the file", e);
            exifInterface = null;
        }
        String a = m7708a(exifInterface, "Make");
        String a2 = m7708a(exifInterface, "Model");
        int b = m7709b(exifInterface, "ImageWidth");
        int b2 = m7709b(exifInterface, "ImageLength");
        int b3 = m7709b(exifInterface, "Orientation");
        byte[] a3 = XMPUtil.a(str);
        String str3 = a3 != null ? new String(a3) : "";
        SphericalPhotoMetadata sphericalPhotoMetadata = new SphericalPhotoMetadata();
        boolean a4 = NativeSphericalProcessing.a(a, a2, b, b2, str3, b3, sphericalPhotoMetadata);
        if (a4) {
            a4 = sphericalPhotoMetadata.a() >= 100.0d;
        }
        if (a4) {
            str2 = sphericalPhotoMetadata.serializeToJson();
        }
        return new SphericalProps(str2, a4);
    }

    private static String m7708a(ExifInterface exifInterface, String str) {
        String attribute = exifInterface.getAttribute(str);
        return attribute != null ? attribute : "";
    }

    private static int m7709b(ExifInterface exifInterface, String str) {
        String attribute = exifInterface.getAttribute(str);
        return attribute != null ? Integer.parseInt(attribute) : 0;
    }
}
