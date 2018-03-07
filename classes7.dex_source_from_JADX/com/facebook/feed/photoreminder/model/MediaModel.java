package com.facebook.feed.photoreminder.model;

import android.net.Uri;

/* compiled from: admin_click_recent_reviews */
public final class MediaModel {
    public final String f19769a;
    public final MediaType f19770b;
    public final int f19771c;
    public final Uri f19772d;

    public MediaModel(String str, MediaType mediaType) {
        this(str, mediaType, 0);
    }

    public MediaModel(String str, MediaType mediaType, int i) {
        this.f19769a = str;
        this.f19770b = mediaType;
        this.f19771c = i;
        this.f19772d = Uri.parse("file:" + str);
    }
}
