package com.facebook.photos.upload.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: graph_search_v2_feed_trending_module */
final class MediaUploadFailedEvent$1 implements Creator<MediaUploadFailedEvent> {
    MediaUploadFailedEvent$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new MediaUploadFailedEvent(parcel);
    }

    public final Object[] newArray(int i) {
        return new MediaUploadFailedEvent[i];
    }
}
