package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: onprogressload */
public final class ShareVideo extends ShareMedia {
    public static final Creator<ShareVideo> CREATOR = new C06261();
    public final Uri f4610a;

    /* compiled from: onprogressload */
    final class C06261 implements Creator<ShareVideo> {
        C06261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShareVideo(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShareVideo[i];
        }
    }

    /* compiled from: onprogressload */
    public final class Builder extends com.facebook.share.model.ShareMedia.Builder<ShareVideo, Builder> {
        public Uri f4609a;

        private Builder m5833a(ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            Builder builder = (Builder) super.mo117a(shareVideo);
            builder.f4609a = shareVideo.f4610a;
            return builder;
        }

        public final Builder m5835a(Parcel parcel) {
            return m5833a((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }
    }

    public ShareVideo(Builder builder) {
        super((com.facebook.share.model.ShareMedia.Builder) builder);
        this.f4610a = builder.f4609a;
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        this.f4610a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4610a, 0);
    }
}
