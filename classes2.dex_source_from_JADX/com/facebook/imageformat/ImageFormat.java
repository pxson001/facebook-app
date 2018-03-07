package com.facebook.imageformat;

import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: measurement.upload.interval */
public enum ImageFormat {
    WEBP_SIMPLE,
    WEBP_LOSSLESS,
    WEBP_EXTENDED,
    WEBP_EXTENDED_WITH_ALPHA,
    WEBP_ANIMATED,
    JPEG,
    PNG,
    GIF,
    BMP,
    UNKNOWN;

    public static boolean isWebpFormat(ImageFormat imageFormat) {
        return imageFormat == WEBP_SIMPLE || imageFormat == WEBP_LOSSLESS || imageFormat == WEBP_EXTENDED || imageFormat == WEBP_EXTENDED_WITH_ALPHA || imageFormat == WEBP_ANIMATED;
    }

    public static String getFileExtension(ImageFormat imageFormat) {
        switch (1.a[imageFormat.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                return "webp";
            case 6:
                return "jpeg";
            case 7:
                return "png";
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return "gif";
            case 9:
                return "bmp";
            default:
                throw new UnsupportedOperationException("Unknown image format " + imageFormat.name());
        }
    }
}
