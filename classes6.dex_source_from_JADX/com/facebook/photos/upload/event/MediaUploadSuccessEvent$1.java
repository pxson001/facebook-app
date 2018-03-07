package com.facebook.photos.upload.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: graph_search_v2_discreet_filter */
final class MediaUploadSuccessEvent$1 implements Creator<MediaUploadSuccessEvent> {
    MediaUploadSuccessEvent$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new MediaUploadSuccessEvent(parcel);
    }

    public final Object[] newArray(int i) {
        return new MediaUploadSuccessEvent[i];
    }
}
