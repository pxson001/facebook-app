package com.facebook.photos.mediagallery.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;

/* compiled from: is_post_intercept_enabled */
public final class MediaGalleryDataCore implements Parcelable {
    public static final Creator<MediaGalleryDataCore> CREATOR = new C09221();
    public final String f10787a;
    public final String f10788b;
    public final int f10789c;
    public final int f10790d;
    public final SimpleMediaFeedbackModel f10791e;

    /* compiled from: is_post_intercept_enabled */
    final class C09221 implements Creator<MediaGalleryDataCore> {
        C09221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MediaGalleryDataCore(parcel);
        }

        public final Object[] newArray(int i) {
            return new MediaGalleryDataCore[i];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10787a);
        parcel.writeString(this.f10788b);
        parcel.writeInt(this.f10789c);
        parcel.writeInt(this.f10790d);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f10791e);
    }

    public MediaGalleryDataCore(String str, String str2, int i, int i2, SimpleMediaFeedbackModel simpleMediaFeedbackModel) {
        this.f10787a = str;
        this.f10788b = str2;
        this.f10789c = i;
        this.f10790d = i2;
        this.f10791e = simpleMediaFeedbackModel;
    }

    MediaGalleryDataCore(Parcel parcel) {
        this.f10787a = parcel.readString();
        this.f10788b = parcel.readString();
        this.f10789c = parcel.readInt();
        this.f10790d = parcel.readInt();
        this.f10791e = (SimpleMediaFeedbackModel) FlatBufferModelHelper.a(parcel);
    }
}
