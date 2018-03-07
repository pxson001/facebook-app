package com.facebook.ui.media.attachments;

import android.net.Uri;

/* compiled from: end_call */
public enum MediaResourceScheme {
    CONTENT,
    FILE,
    HTTP,
    HTTPS;

    public final boolean isLikelyLocal() {
        return this == CONTENT || this == FILE;
    }

    public static MediaResourceScheme from(MediaResource mediaResource) {
        return from(mediaResource.c);
    }

    public static MediaResourceScheme fromOrNull(MediaResource mediaResource) {
        return fromOrNull(mediaResource.c);
    }

    public static MediaResourceScheme from(Uri uri) {
        MediaResourceScheme fromOrNull = fromOrNull(uri);
        if (fromOrNull != null) {
            return fromOrNull;
        }
        throw new IllegalArgumentException("Scheme not recognized: " + uri.getScheme());
    }

    public static MediaResourceScheme fromOrNull(Uri uri) {
        if (uri.getScheme() == null) {
            return null;
        }
        String scheme = uri.getScheme();
        Object obj = -1;
        switch (scheme.hashCode()) {
            case 3143036:
                if (scheme.equals("file")) {
                    obj = 1;
                    break;
                }
                break;
            case 3213448:
                if (scheme.equals("http")) {
                    obj = 2;
                    break;
                }
                break;
            case 99617003:
                if (scheme.equals("https")) {
                    obj = 3;
                    break;
                }
                break;
            case 951530617:
                if (scheme.equals("content")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return CONTENT;
            case 1:
                return FILE;
            case 2:
                return HTTP;
            case 3:
                return HTTPS;
            default:
                return null;
        }
    }
}
