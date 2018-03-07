package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.SharePhoto.Builder;

/* compiled from: ongameready */
public final class ShareVideoContent extends ShareContent<ShareVideoContent, Object> implements ShareModel {
    public static final Creator<ShareVideoContent> CREATOR = new C06271();
    private final String f4611a;
    private final String f4612b;
    private final SharePhoto f4613c;
    private final ShareVideo f4614d;

    /* compiled from: ongameready */
    final class C06271 implements Creator<ShareVideoContent> {
        C06271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShareVideoContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShareVideoContent[i];
        }
    }

    ShareVideoContent(Parcel parcel) {
        super(parcel);
        this.f4611a = parcel.readString();
        this.f4612b = parcel.readString();
        Builder a = new Builder().m5832a(parcel);
        if (a.f4601b == null && a.f4600a == null) {
            this.f4613c = null;
        } else {
            this.f4613c = new SharePhoto(a);
        }
        this.f4614d = new ShareVideo(new ShareVideo.Builder().m5835a(parcel));
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f4611a);
        parcel.writeString(this.f4612b);
        parcel.writeParcelable(this.f4613c, 0);
        parcel.writeParcelable(this.f4614d, 0);
    }
}
