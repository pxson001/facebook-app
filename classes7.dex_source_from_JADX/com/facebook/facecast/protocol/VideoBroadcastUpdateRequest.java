package com.facebook.facecast.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.facecast.model.FacecastCompositionData;

/* compiled from: avcC */
public class VideoBroadcastUpdateRequest implements Parcelable {
    public static final Creator<VideoBroadcastUpdateRequest> CREATOR = new C16291();
    public final String f18803a;
    public final FacecastCompositionData f18804b;

    /* compiled from: avcC */
    final class C16291 implements Creator<VideoBroadcastUpdateRequest> {
        C16291() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoBroadcastUpdateRequest(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoBroadcastUpdateRequest[i];
        }
    }

    public VideoBroadcastUpdateRequest(String str, FacecastCompositionData facecastCompositionData) {
        this.f18803a = str;
        this.f18804b = facecastCompositionData;
    }

    public VideoBroadcastUpdateRequest(Parcel parcel) {
        this.f18803a = parcel.readString();
        this.f18804b = (FacecastCompositionData) parcel.readParcelable(FacecastCompositionData.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18803a);
        parcel.writeParcelable(this.f18804b, 0);
    }
}
