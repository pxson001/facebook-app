package com.facebook.photos.mediafetcher.query.param;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.calls.MediaTypeInputMediaType;
import com.facebook.photos.mediafetcher.interfaces.QueryParam;
import com.google.common.base.Preconditions;

/* compiled from: key IN ( */
public class MediaTypeQueryParam extends QueryParam {
    public static final Creator<MediaTypeQueryParam> CREATOR = new C09031();
    public final String f10638a;
    public final String f10639b;

    /* compiled from: key IN ( */
    final class C09031 implements Creator<MediaTypeQueryParam> {
        C09031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MediaTypeQueryParam(parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new MediaTypeQueryParam[i];
        }
    }

    public static MediaTypeQueryParam m12707a(String str) {
        return new MediaTypeQueryParam(str, MediaTypeInputMediaType.ALL.toString());
    }

    public static MediaTypeQueryParam m12708b(String str) {
        return new MediaTypeQueryParam(str, MediaTypeInputMediaType.PHOTO.toString());
    }

    public MediaTypeQueryParam(String str, String str2) {
        this.f10638a = (String) Preconditions.checkNotNull(str);
        this.f10639b = (String) Preconditions.checkNotNull(str2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10638a);
        parcel.writeString(this.f10639b);
    }
}
