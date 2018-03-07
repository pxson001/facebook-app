package com.facebook.photos.upload.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: graph_search_v2_hashtag */
final class MediaServerProcessingEvent$1 implements Creator<MediaServerProcessingEvent> {
    MediaServerProcessingEvent$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new MediaServerProcessingEvent(parcel);
    }

    public final Object[] newArray(int i) {
        return new MediaServerProcessingEvent[i];
    }
}
